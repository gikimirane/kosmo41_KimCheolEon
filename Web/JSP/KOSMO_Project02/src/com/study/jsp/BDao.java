package com.study.jsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDao {

	private static BDao instance = new BDao();
	DataSource dataSource = null;
	
	int listCount = 10; // 한 페이지당 보여줄 게시물 갯수
	int pageCount = 4; // 하단에 보여줄 페이지 리스트의 갯수

	private BDao() {
		try {
//			lookup 함수의 파라메터는 context.xml에 설정된
//			name(jdbc/Oracle11g)과 동일해야 한다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
//			con = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static BDao getInstance() {
		return instance;
	}

//	private Connection getConnection() {

//		Context context = null;
//		DataSource dataSource = null;
//		Connection con = null;

//		try {
////			lookup 함수의 파라메터는 context.xml에 설정된
////			name(jdbc/Oracle11g)과 동일해야 한다.
//			context = new InitialContext();
//			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
//			con = dataSource.getConnection();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		return con;
//	}

	public void write(String bName, String bTitle, String bContent) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) "
				+ "values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";

		try {
			con = dataSource.getConnection(); // ConnectionPool

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);

			int rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<BDto> list(int curPage) {

		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int nStart = (curPage - 1) * listCount + 1;
		int nEnd = (curPage - 1) * listCount + listCount;
		
		System.out.println("nStart : " + nStart);
		System.out.println("nEnd : " + nEnd);
		
		
		try {
			con = dataSource.getConnection(); // ConnectionPool

//			String query = "select * " + "from mvc_board " + "order by bGroup desc, bStep asc";
			String query = 
					"select * " + 
					"  from ( " + 
					"   select rownum num, A.* " + 
					"     from ( " + 
					"        select * " + 
					"          from mvc_board " + 
					"         order by bgroup desc, bstep asc ) A " + 
					"    where rownum <= ? ) B " + 
					" 	where B.num >= ? ";

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, nEnd);
			pstmt.setInt(2, nStart);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int bId = rs.getInt("bID");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");

				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, 
						bHit, bGroup, bStep, bIndent);

				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return dtos;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public BPageInfo articlePage(int curPage) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Paging Logic----------------------
		// 총 게시물의 갯수
		int totalCount = 0;
		try {
			con = dataSource.getConnection();

			String query = "select count(*) as total from mvc_board";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				totalCount = rs.getInt("total");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// 총 페이지 수
		int totalPage = totalCount / listCount;
		if (totalCount % listCount > 0) {
			totalPage++;
		}

		// 현재 페이지
		int myCurPage = curPage;
		if (myCurPage > totalPage) {
			myCurPage = totalPage;
		}
		if (myCurPage < 1) {
			myCurPage = 1;
		}
		
		// 시작 페이지
		int startPage = ((myCurPage - 1) / pageCount) * pageCount + 1;
		
		// 끝 페이지
		int endPage = startPage + pageCount - 1;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
	
		
		// PageInfo Set
		BPageInfo pInfo = new BPageInfo();
		pInfo.setTotalCount(totalCount);
		pInfo.setListCount(listCount);
		pInfo.setTotalPage(totalPage);
		pInfo.setCurPage(myCurPage);
		pInfo.setPageCount(pageCount);
		pInfo.setStartPage(startPage);
		pInfo.setEndPage(endPage);
		
		return pInfo;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public BDto contentView(String strID) {
		upHit(strID);

		BDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			con = dataSource.getConnection(); // ConnectionPool

			String query = "select * from mvc_board where bId = ?";

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strID));
			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				int bId = resultSet.getInt("bID");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");

				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return dto;
	}

	public void modify(String bId, String bName, String bTitle, String bContent) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "update mvc_board " + " set bName = ?, bTitle = ?, bContent = ? " + " where bId = ?";

		try {
			con = dataSource.getConnection(); // ConnectionPool

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, bId);

			int rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private void upHit(String bId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection(); // ConnectionPool

			String query = "update mvc_board set bHit = bHit+1 where bId = ?";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bId);

			int rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void delete(String bId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection(); // ConnectionPool

			String query = "delete from mvc_board where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bId));
			int rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public BDto reply_View(String str) {
		BDto dto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			con = dataSource.getConnection(); // ConnectionPool

			String query = "select * from mvc_board where bId = ?";

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(str));
			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				int bId = resultSet.getInt("bID");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");

				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return dto;
	}

	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent) {

		replyShape(bGroup, bStep);

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection(); // ConnectionPool

			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) "
					+ "values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bGroup));
			pstmt.setInt(5, Integer.parseInt(bStep) + 1);
			pstmt.setInt(6, Integer.parseInt(bIndent) + 1);

			int rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private void replyShape(String strGroup, String strStep) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection(); // ConnectionPool

			String query = "update mvc_board set bStep = bStep+1 where bGroup = ? and bStep > ?";

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strGroup));
			pstmt.setInt(2, Integer.parseInt(strStep));

			int rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<BDto> searchList(int curPage, String select, String word) {

		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int nStart = (curPage - 1) * listCount + 1;
		int nEnd = (curPage - 1) * listCount + listCount;
		
		try {
			con = dataSource.getConnection(); // ConnectionPool

//			String query = "select * " + "from mvc_board " + "order by bGroup desc, bStep asc";
			String query = "select *\r\n" + 
					"  from (\r\n" + 
					"   select rownum num, A.*\r\n" + 
					"     from (\r\n" + 
					"        select *\r\n" + 
					"          from mvc_board where "+ select +" like ?\r\n" + 
					"         order by bgroup desc, bstep asc ) A\r\n" + 
					"    where rownum <= ? ) B\r\n" + 
					"    where B.num >= ?";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%"+word+"%");
			pstmt.setInt(2, nEnd);
			pstmt.setInt(3, nStart);
			rs = pstmt.executeQuery();
						
			while (rs.next()) {
				
				int bId = rs.getInt("bID");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");

				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, 
						bHit, bGroup, bStep, bIndent);

				dtos.add(dto);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return dtos;
	}
	
	public BPageInfo search_articlePage(int curPage, String select, String word) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int nStart = (curPage - 1) * listCount + 1;
		int nEnd = (curPage - 1) * listCount + listCount;
		
		
		System.out.println("curPage : " + curPage);
		System.out.println("select : " + select);
		System.out.println("word : " + word);
		

		// Paging Logic----------------------
		// 총 게시물의 갯수
		int totalCount = 0;
		try {
			con = dataSource.getConnection();

//			String query = "select count(*) as total from mvc_board";
			String query = "select count(*) as SEARCHTOTAL from mvc_board where "+ select +" like ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%"+word+"%");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				totalCount = rs.getInt("SEARCHTOTAL");
			}
			
			System.out.println("SEARCHTOTAL1 : " + rs.getInt("SEARCHTOTAL"));
			System.out.println("SEARCHTOTAL2 : " + totalCount);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// 총 페이지 수
		int totalPage = totalCount / listCount;
		if (totalCount % listCount > 0) {
			totalPage++;
		}

		// 현재 페이지
		int myCurPage = curPage;
		if (myCurPage > totalPage) {
			myCurPage = totalPage;
		}
		if (myCurPage < 1) {
			myCurPage = 1;
		}
		
		// 시작 페이지
		int startPage = ((myCurPage - 1) / pageCount) * pageCount + 1;
		
		// 끝 페이지
		int endPage = startPage + pageCount - 1;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
	
		
		// PageInfo Set
		BPageInfo pInfo = new BPageInfo();
		pInfo.setTotalCount(totalCount);
		pInfo.setListCount(listCount);
		pInfo.setTotalPage(totalPage);
		pInfo.setCurPage(myCurPage);
		pInfo.setPageCount(pageCount);
		pInfo.setStartPage(startPage);
		pInfo.setEndPage(endPage);
		
		return pInfo;
	}
	

}
