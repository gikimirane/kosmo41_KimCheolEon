package com.study.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.study.spring.dto.BDto;

public class BDao implements IDao {

	JdbcTemplate template;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public BDao() {

	}

	@Override
	public ArrayList<BDto> listDao() {
		String query = "select * from board order by mId desc";
		ArrayList<BDto> dtos = (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));

		return dtos;
	}

	@Override
	public void writeDao(String mWriter, String mContent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BDto viewDao(String strID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDao(String bId) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void writeDao(final String mWriter, final String mContent) {
//		System.out.println("writeDao()");
//
//		this.template.update(new PreparedStatementCreator() {
//
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				String query = "insert into board (mId, mWriter, mContent) values (board_seq.nextval, ?, ?)";
//				PreparedStatement pstmt = con.prepareStatement(query);
//				pstmt.setString(1, mWriter);
//				pstmt.setString(2, mContent);
//
//				return pstmt;
//			}
//		});
//	}
//
//	@Override
//	public ContentDto viewDao(String strID) {
//		System.out.println("viewDao()");
//
//		String query = "select * from board where mId = " + strID;
//		return template.queryForObject(query, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
//	}
//
//	@Override
//	public void deleteDao(final String bId) {
//		System.out.println("deleteDao()");
//
//		String query = "delete from board where mId = ?";
//		this.template.update(query, new PreparedStatementSetter() {
//
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setInt(1, Integer.parseInt(bId));
//
//			}
//		});
//	}

}
