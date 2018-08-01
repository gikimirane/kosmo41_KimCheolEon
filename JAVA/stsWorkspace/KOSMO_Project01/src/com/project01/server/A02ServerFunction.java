package com.project01.server;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import com.project01.DB.*;
import com.sun.xml.internal.ws.util.StringUtils;

public class A02ServerFunction {

	Server svr = new Server();

	B02chat_usersDAO chuDAO = new B02chat_usersDAO();
	C02roomlistDAO roomDAO = new C02roomlistDAO();

	// 접속된 모든 클라이언트들에게 메시지 전달
	public void sendAllMsg(String msg) {
		// 출력 스트림을 순차적으로 얻어와서 해당 메시지를 출력한다.
		Iterator it = svr.clientMap.keySet().iterator();

		while (it.hasNext()) {
			try {
				PrintWriter it_out = (PrintWriter) svr.clientMap.get(it.next());

				it_out.println(URLEncoder.encode(msg, "UTF-8"));
			} catch (Exception e) {
				System.out.println("예외[Server/sendAllMsg] : " + e);
			}
		}
	}

	// 미구현
	public void sendPersonalMsg(String name, String msg) {
		try {
			PrintWriter it_out = (PrintWriter) svr.clientMap.get(name);

			it_out.println(URLEncoder.encode(msg, "UTF-8"));
		} catch (Exception e) {
			System.out.println("예외[Server/sendAllMsg] : " + e);
		}
	}

	public void CommandProcess(String command, String name, String body) {
		try {

			System.out.println("command : [" + command + "]");
			System.out.println("name : [" + name + "]");
			System.out.println("body : [" + body + "]");

			switch (command) {

			case "/list":
				CmdList(name);
				break;

			case "/roomlist":
				CmdRoomList(name);
				break;

			case "/to":
				CmdWhisper(name, body);
				break;

			case "/mkroom":
				CmdMKRoom(name, body);
				break;

			case "/dstroom":
				CmdDSTRoom(name);
				break;

			case "/in":
				System.out.println("in 준비중");
				// CmdRoomIn(name);
				break;
			default:
				CmdDefault(name);

			}
		} catch (Exception e) {
			System.out.println("예외[Server/CommandProcess] : " + e);
		}

	}

	public void CmdList(String name) {
		String sResult = "";

		try {
			// Key만 담고있는 컬렉션 인스턴스 생성
			Set<String> keys = svr.clientMap.keySet();

			// 전체 Key 출력
			for (String n : keys) {
				if (sResult == "") {
					sResult = n;
				} else {
					sResult = sResult + ", " + n;
				}
			}

			PrintWriter it_out = (PrintWriter) svr.clientMap.get(name);
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
			PrintWriter it_out = (PrintWriter) svr.clientMap.get(wantName);
			it_out.println(URLEncoder.encode("From [" + name + "] : " + toBody, "UTF-8"));

			PrintWriter it_out2 = (PrintWriter) svr.clientMap.get(name);
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

			PrintWriter it_out = (PrintWriter) svr.clientMap.get(name);

			if (chuDAO.checkUSERS("NAME", name).getROOMADMIN().equals("ADMIN")) {
				PassCheck -= 99;
				it_out.println(URLEncoder.encode("ADMIN 상태로 새 방을 생성할 수 없습니다.", "UTF-8"));
			}

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
					roomDO.setRMAX(roomMax);
					roomDO.setRHIDDEN(roomHidden);
					roomDO.setRPASS(roomPass);

					// 방생성
					roomDAO.insertRoom(roomDO);
					sResult = "방이 생성되었습니다.";

					// 방장 권한 업데이트
					chuDAO.updateCHAT_USERS("NAME", name, "ROOMADMIN", "ADMIN");
					// 로케이션 업데이트 (룸리스트 조회한 다음에..... 룸 이름 equals 로 찾아서 로케이션딴다음에 번호를 때려넣어야하네)
					C01roomlistDO selectRoom = roomDAO.selectRoomList(roomName);
					System.out.println("생성된 방번호 : " + selectRoom.getRNUMBER());
					chuDAO.updateCHAT_USERS("NAME", name, "LOCATION", selectRoom.getRNUMBER());

				} else {
					sResult = "방 생성에 실패하였습니다";
					it_out.println(URLEncoder.encode("작성한 옵션 : [" + body.toString() + "]", "UTF-8"));
				}
			}

			it_out.println(URLEncoder.encode(sResult.toString(), "UTF-8"));

		} catch (Exception e) {
			System.out.println("예외[Server/CmdList] : " + e);
		}
	}

	public void CmdDSTRoom(String name) {

		String sResult = "";

		PrintWriter it_out = (PrintWriter) svr.clientMap.get(name);

		try {
			B01chat_usersDO USER = chuDAO.checkUSERS("NAME", name);

			if (!USER.getROOMADMIN().equals("ADMIN")) {
				it_out.println(URLEncoder.encode("ADMIN 권한이 없습니다.", "UTF-8"));
			}else {
				chuDAO.checkUSERS("NAME", name);
				
				
				
			}

			it_out.println(URLEncoder.encode(sResult.toString(), "UTF-8"));
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
		PrintWriter it_out = (PrintWriter) svr.clientMap.get(name);
		try {
			it_out.println(URLEncoder.encode(sResult.toString(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// public void CmdRoomIn(String name) {
	//
	// try {
	// PrintWriter it_out = (PrintWriter) svr.clientMap.get(name);
	//
	// it_out.println(URLEncoder.encode("알수없는 명령어 입니다.", "UTF-8"));
	// } catch (Exception e) {
	// System.out.println("예외[Server/CmdDefault] : " + e);
	// }
	// }

	public void CmdDefault(String name) {

		try {
			PrintWriter it_out = (PrintWriter) svr.clientMap.get(name);

			it_out.println(URLEncoder.encode("알수없는 명령어 입니다.", "UTF-8"));
		} catch (Exception e) {
			System.out.println("예외[Server/CmdDefault] : " + e);
		}

	}

	public boolean isNumeric(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
