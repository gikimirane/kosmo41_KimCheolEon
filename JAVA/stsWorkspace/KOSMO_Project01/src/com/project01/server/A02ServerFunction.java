package com.project01.server;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import com.project01.DB.*;
import com.sun.xml.internal.ws.api.pipe.NextAction;
import com.sun.xml.internal.ws.util.StringUtils;

public class A02ServerFunction {

	B02chat_usersDAO chuDAO = new B02chat_usersDAO();
	C02roomlistDAO roomDAO = new C02roomlistDAO();

	// 접속된 모든 클라이언트들에게 메시지 전달
	public void sendAllMsg(String msg) {
		// 출력 스트림을 순차적으로 얻어와서 해당 메시지를 출력한다.
		Iterator<?> it = Server.clientMap.keySet().iterator();

		while (it.hasNext()) {
			try {
				PrintWriter it_out = (PrintWriter) Server.clientMap.get(it.next());

				it_out.println(URLEncoder.encode(msg, "UTF-8"));
			} catch (Exception e) {
				System.out.println("예외[Server/sendAllMsg] : " + e);
			}
		}
	}

//	public void sendPrivateMsg(String msg, String name) {
//		
//		PrivateMapBuildInsert(name);
//		
//		Iterator<?> it = Server.PrivateMap.keySet().iterator();
//		while (it.hasNext()) {
//			try {
//				PrintWriter it_out = (PrintWriter) Server.clientMap.get(it.next());
//
//				it_out.println(URLEncoder.encode(msg, "UTF-8"));
//			} catch (Exception e) {
//				System.out.println("예외[Server/sendAllMsg] : " + e);
//			}
//		}
//	}
	
//	public void PrivateMapBuildInsert(String name) {
//		ArrayList<B01chat_usersDO> user = chuDAO.checkUSERS("NAME", name);
//		String location = user.get(0).getLOCATION();
//		ArrayList<B01chat_usersDO> list = chuDAO.checkUSERS("LOGIN = 'IN' and LOCATION", location);
//		
//		int size = list.size();
//		for (int index = 0; index < size; index++) {
//			Server.clientMap.put(name, Server.clientMap.get(name));
//		}
//	}
//	
//	public void PrivateMapBuildClear() {
//		Server.PrivateMap.clear();
//	}



	// Location Msg
	public void sendPrivateMsg(String msg, String name) {

		ArrayList<B01chat_usersDO> user = chuDAO.checkUSERS("NAME", name);
		String location = user.get(0).getLOCATION();
		ArrayList<B01chat_usersDO> list = chuDAO.checkUSERS("LOGIN = 'IN' and LOCATION", location);

		int size = list.size();
		for (int index = 0; index < size; index++) {
			PrintWriter it_out = (PrintWriter) Server.clientMap.get(list.get(index).getNAME());
			try {
				it_out.println(URLEncoder.encode(msg, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		list.clear();
	}

//	public void PrivateMsgClear() {
//		list.clear();
//	}

	public void CommandProcess(String command, String name, String body) {

		PrintWriter it_out = (PrintWriter) Server.clientMap.get(name);

		try {

			System.out.println("command : [" + command + "]");
			System.out.println("name : [" + name + "]");
			System.out.println("body : [" + body + "]");

			switch (command) {

			case "/list":
				CmdList(name);
				break;

			case "/to":
				CmdWhisper(name, body);
				break;

			case "/roomlist":
				CmdRoomList(name);
				break;

			case "/mkroom":
				CmdMKRoom(name, body);
				break;

			case "/dstroom":
				CmdDSTRoom(name);
				break;

			case "/in":
				CmdRoomIn(name, body);
				break;

			case "/test":
				break;
			default:
				CmdDefault(name);

			}
		} catch (Exception e) {
			System.out.println("예외[Server/CommandProcess] : " + e);
			try {
				it_out.println(URLEncoder.encode("[SYSTEM] 올바르지 않은 명령입니다.", "UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public void CmdList(String name) {
		String sResult = "";

		try {
			// Key만 담고있는 컬렉션 인스턴스 생성
			Set<String> keys = Server.clientMap.keySet();

			// 전체 Key 출력
			for (String n : keys) {
				if (sResult == "") {
					sResult = n;
				} else {
					sResult = sResult + ", " + n;
				}
			}

			PrintWriter it_out = (PrintWriter) Server.clientMap.get(name);
			it_out.println(URLEncoder.encode(sResult.toString(), "UTF-8"));

		} catch (Exception e) {
			System.out.println("예외[Server/CmdList] : " + e);
		}
	}

	public void CmdWhisper(String name, String body) {

		StringTokenizer to = new StringTokenizer(body, " ");
		String wantName = to.nextToken();
		String toBody = to.nextToken("").trim();

		try {
			PrintWriter it_out = (PrintWriter) Server.clientMap.get(wantName);
			it_out.println(URLEncoder.encode("From [" + name + "] : " + toBody, "UTF-8"));

			PrintWriter it_out2 = (PrintWriter) Server.clientMap.get(name);
			it_out2.println(URLEncoder.encode("[정상발송] : " + toBody, "UTF-8"));
		} catch (Exception e) {
			System.out.println("예외[Server/CmdWhisper] : " + e);
		}
	}

	public void CmdMKRoom(String name, String body) {
		try {
			String sResult = "";

			String roomName = "";
			String roomMax = "";
			String roomHidden = "";
			String roomPass = "";
			int PassCheck = 0;

			System.out.println(PassCheck);

			PrintWriter it_out = (PrintWriter) Server.clientMap.get(name);

			if (chuDAO.checkUSERS("NAME", name).get(0).getROOMADMIN().equals("ADMIN")) {
				PassCheck -= 99;
				it_out.println(URLEncoder.encode("ADMIN 상태로 새 방을 생성할 수 없습니다.", "UTF-8"));
			} else {
				if (body.equals("")) {
					sResult = "\n[MKRoom] 방을 생성합니다.명령어를 작성해주세요.\n" + "/mkroom [방이름]#[인원제한]#[공개/비공개]#[비공개시, 패스워드]\n\n"
							+ "\t예시)\n" + "\t\t /mkroom 모두모여랑!#3#공개\n" + "\t\t /mkroom 방이름입니다 # 3 # 비공개 # 1324";
				} else {
					StringTokenizer mkroom = new StringTokenizer(body, "#");

					int tokenCount = mkroom.countTokens();

					if (tokenCount == 3) {
						roomName = mkroom.nextToken().trim();
						roomMax = mkroom.nextToken().trim();
						roomHidden = mkroom.nextToken().trim();

						PassCheck += 1;
					}
					if (tokenCount == 4) {
						roomName = mkroom.nextToken().trim();
						roomMax = mkroom.nextToken().trim();
						roomHidden = mkroom.nextToken().trim();
						roomPass = mkroom.nextToken().trim();

						PassCheck += 1;
					}

					if (isNumeric(roomMax) == true) {
						PassCheck += 2;
					}

					if (!roomMax.equals("0")) {
						PassCheck += 4;
					}

					if (roomHidden.equals("공개")) {
						PassCheck += 8;
					}
					if (roomHidden.equals("비공개")) {
						PassCheck += 8;
					}

					System.out.println(PassCheck);

					if (PassCheck == 15) {
						C01roomlistDO roomDO = new C01roomlistDO();
						roomDO.setRNAME(roomName);
						roomDO.setRMAX(Integer.toString(Integer.parseInt(roomMax)));
						roomDO.setRHIDDEN(roomHidden);
						roomDO.setRPASS(roomPass);

						// 방생성
						roomDAO.insertRoom(roomDO);
						sResult = "방이 생성되었습니다.";

						// 방장 권한 업데이트
						chuDAO.updateCHAT_USERS("NAME", name, "ROOMADMIN", "ADMIN");
						// 로케이션 업데이트 (룸리스트 조회한 다음에..... 룸 이름 equals 로 찾아서 로케이션딴다음에 번호를 때려넣어야하네)
						C01roomlistDO selectRoom = roomDAO.selectRoomList("RNAME", roomName);
						System.out.println("생성된 방번호 : " + selectRoom.getRNUMBER());
						chuDAO.updateCHAT_USERS("NAME", name, "LOCATION", selectRoom.getRNUMBER());

					} else {
						sResult = "방 생성에 실패하였습니다";
						it_out.println(URLEncoder.encode("작성한 옵션 : [" + body.toString() + "]", "UTF-8"));
					}
				}

				it_out.println(URLEncoder.encode(sResult.toString(), "UTF-8"));
			}

		} catch (Exception e) {
			System.out.println("예외[Server/CmdList] : " + e);
		}
	}

	public void CmdDSTRoom(String name) {

		PrintWriter it_out = (PrintWriter) Server.clientMap.get(name);

		// B01chat_usersDO USER = chuDAO.checkUSERS("NAME", name);
		ArrayList<B01chat_usersDO> USER = chuDAO.checkUSERS("NAME", name);

		String isAdmin = USER.get(0).getROOMADMIN();
		String isLocation = USER.get(0).getLOCATION();

		try {
			if (!isAdmin.equals("ADMIN")) {
				it_out.println(URLEncoder.encode("[SYSTEM] ADMIN 권한이 없습니다.", "UTF-8"));
			} else {

				it_out.println(URLEncoder.encode("[SYSTEM] ADMIN 권한이 확인되었습니다. 방을 삭제합니다.", "UTF-8"));

				// B01chat_usersDO userList = chuDAO.checkUSERS("LOCATION", isLocation);
				ArrayList<B01chat_usersDO> userList = chuDAO.checkUSERS("LOCATION", isLocation);
				int uListElements = userList.size();
				for (int i = 0; i < uListElements; i++) {
					// 여기 문제있다. 이거 운용하는 사람이 마지막에 업데이트되는 바람에 실제로 이 값을 구한놈이 마지막놈밖에 없음
					// locationArray로 처리할수 있을까?
					PrintWriter it_out2 = (PrintWriter) Server.clientMap.get(userList.get(i).getNAME());
					it_out2.println(URLEncoder.encode("[SYSTEM] ADMIN 이 방을 삭제하여, 대기실로 이동합니다.", "UTF-8"));
				}

				// 로케이션업데이트 하기전에, 파괴하려는 방 어드민 권환 회수
				chuDAO.updateCHAT_USERS("NAME", name, "ROOMADMIN", "NOADMIN");

				// 방 삭XE
				if (roomDAO.deleteRoom(isLocation)) {
					// 로케이션 업데이트
					chuDAO.updateCHAT_USERS("LOCATION", isLocation, "LOCATION", "1");
				}
			}

		} catch (Exception e) {
			System.out.println("예외[Server/CmdDefault] : " + e);
		}

	}

	public void CmdRoomList(String name) {
		String sResult = "";

		ArrayList<C01roomlistDO> list = roomDAO.getRoomList();

		int totalElements = list.size();// arrayList의 요소의 갯수를 구한다.

		for (int index = 0; index < totalElements; index++) {
			String rnumber = list.get(index).getRNUMBER();
			String rmax = list.get(index).getRMAX();
			String rusercount = list.get(index).getRUSERCOUNT();
			String rname = list.get(index).getRNAME();
			String rhidden = list.get(index).getRHIDDEN();

			sResult += "\n\t[No." + rnumber + "]\t" + "[총원:" + rmax + "]\t" + "[현재원:" + rusercount + "]\t" + "[상태:"
					+ rhidden + "]\n\t[" + rname + "]\n";
		}
		System.out.println("sResult 전문 : " + sResult);
		PrintWriter it_out = (PrintWriter) Server.clientMap.get(name);
		try {
			it_out.println(URLEncoder.encode(sResult.toString(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void CmdRoomIn(String name, String body) {

		PrintWriter it_out = (PrintWriter) Server.clientMap.get(name);

		if (body.equals("")) {
			try {
				it_out.println(URLEncoder.encode("\n\t예시)\n" + "\t\t/in [방번호] [비공개방일시, 비밀번호]", "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			ArrayList<B01chat_usersDO> USER = chuDAO.checkUSERS("NAME", name);
			// 명령어 날린사람 계급 확보 ADMIN / NOADMIN
			String isAdmin = USER.get(0).getROOMADMIN();
			// 명령어 날린사람의 LOCATION 확보
			String isLocation = USER.get(0).getLOCATION();

			int PassCheck = 0;

			// body 분리 및 토큰개수 확보
			StringTokenizer inToken = new StringTokenizer(body, " ");
			int tokenCount = inToken.countTokens();

			String tokenBody = "";
			String tokenPass = "";

			if (tokenCount == 1) {
				tokenBody = inToken.nextToken();
			}

			if (tokenCount == 2) {
				tokenBody = inToken.nextToken();
				tokenPass = inToken.nextToken();
			}

			// 방이 존재하는가?
			// 방이 존재하지 않으면 NULL 뿜어버리는데, CommandProcess 에서 에러처리해버림
			C01roomlistDO selectRoom = roomDAO.selectRoomList("RNUMBER", tokenBody);

			String doRnumber = selectRoom.getRNUMBER();
			int doMax = Integer.parseInt(selectRoom.getRMAX());
			int doUserCount = Integer.parseInt(selectRoom.getRUSERCOUNT());
			String doHidden = selectRoom.getRHIDDEN();
			String doPass = selectRoom.getRPASS();

			System.out.println("방의 비밀번호 : " + doPass);

			// 이동할 수 있는 권한인가?
			if (isAdmin.equals("ADMIN")) {
				try {
					it_out.println(URLEncoder.encode("[SYSTEM] ADMIN 이 방을 이동하려면 방파괴(dstroom) / 권한승계(admin) 한 후에 가능합니다",
							"UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PassCheck -= 1;
			}

			// 숫자를 입력한 것이 맞는가?
			if (!isNumeric(tokenBody)) {
				try {
					it_out.println(URLEncoder.encode("[SYSTEM] 숫자가 아닙니다.", "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PassCheck -= 1;
			}

			// 토큰의 갯수가 최대 2개를 넘지 않는가?
			if (tokenCount > 2) {
				try {
					it_out.println(URLEncoder.encode("[SYSTEM] 입력 인자 갯수가 다릅니다.", "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PassCheck -= 1;
			}

			// 방에 들어갈수 있는 인원수인가?
			if (doMax == doUserCount) {
				try {
					it_out.println(URLEncoder.encode("[SYSTEM] 방의 인원이 꽉찼습니다.", "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PassCheck -= 1;
			}

			System.out.println("PassCheck : " + PassCheck);

			// 에러 검출 안됬을 시 입장 시행
			if (PassCheck == 0) {
				System.out.println("뭐야 여기 진입 안함?");
				System.out.println(tokenPass.equals(doPass));
				System.out.println("비밀번호 확인결과");

				// 토큰 1개짜리, 공개방 입장
				if (doHidden.equals("공개")) {
					chuDAO.updateCHAT_USERS("NAME", name, "LOCATION", tokenBody);
//					roomDAO.
					try {
						it_out.println(URLEncoder.encode("[SYSTEM] 방이 이동되었습니다. (번호 : " + tokenBody + ")", "UTF-8"));
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// 토큰 2개짜리, 비공개방 입장
				if (doHidden.equals("비공개")) {
					if (tokenPass.equals(doPass)) {
						chuDAO.updateCHAT_USERS("NAME", name, "LOCATION", tokenBody);
						try {
							it_out.println(URLEncoder.encode("[SYSTEM] 방이 이동되었습니다. (번호 : " + tokenBody + ")", "UTF-8"));
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						try {
							it_out.println(URLEncoder.encode("[SYSTEM] 비밀번호가 틀렸습니다.", "UTF-8"));
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	public void CmdDefault(String name) {

		try {
			PrintWriter it_out = (PrintWriter) Server.clientMap.get(name);

			it_out.println(URLEncoder.encode("알수없는 명령어 입니다.", "UTF-8"));
		} catch (Exception e) {
			System.out.println("예외[Server/CmdDefault] : " + e);
		}

	}

	// -------------------------------------------------------------------------------------------//

	public boolean isNumeric(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
