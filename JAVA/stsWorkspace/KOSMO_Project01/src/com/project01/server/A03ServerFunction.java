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

public class A03ServerFunction {

	Server svr = new Server();

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

			System.out.println(command);
			System.out.println(name);
			System.out.println(body);

			switch (command) {

			case "/list":
				CmdList(name);
				break;

			case "/to":
				CmdWhisper(body);
				break;

			case "/mkroom":
				System.out.println("[mkroom] 명령");
				CmdMKRoom(name, body);
				break;

			case "/roomlist":
				System.out.println("[roomlist] 명령");
				CmdRoomList(name);
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

	public void CmdWhisper(String msg) {

		StringTokenizer to = new StringTokenizer(msg, " ");
		to.nextToken();
		to.nextToken();
		to.nextToken();
		String toName = to.nextToken();
		String toBody = to.nextToken("").trim();

		try {
			PrintWriter it_out = (PrintWriter) svr.clientMap.get(toName);

			it_out.println(URLEncoder.encode("From [" + toName + "] : " + toBody, "UTF-8"));
		} catch (Exception e) {
			System.out.println("예외[Server/CmdWhisper] : " + e);
		}
	}

	public void CmdMKRoom(String name, String body) {
		String sResult = "";
		System.out.println("mkroomBody : " + body);
		if (body.equals("")) {
			sResult = "[MKRoom] 방을 생성합니다.명령어를 작성해주세요.\n" + "/mkroom [방이름] [인원제한] [히든(Y/N)]\n\n"
					+ "예시)		/mkroom 모두모여랑! 3 n ";
		}
		sResult = "몰라 만드는중이야;;;";

		try {
			PrintWriter it_out = (PrintWriter) svr.clientMap.get(name);
			it_out.println(URLEncoder.encode(sResult.toString(), "UTF-8"));

		} catch (Exception e) {
			System.out.println("예외[Server/CmdList] : " + e);
		}
	}

	public void CmdRoomList(String name) {
		String sResult = "";

		System.out.println("CmdRoomList 메소드 진입");
		
		D02roomlistDAO chuDAO = new D02roomlistDAO();
		ArrayList<D01roomlistDO> list = chuDAO.getRoomList();

		int totalElements = list.size();// arrayList의 요소의 갯수를 구한다.
		for (int index = 0; index < totalElements; index++) {
			String rnumber = list.get(index).getRNUMBER();
			String rmax = list.get(index).getRMAX();
			String rname = list.get(index).getRName();
			String rhidden = list.get(index).getRHIDDEN();

			sResult = "[" + rnumber + "]\t[" + rmax + "]\t\t[" + rname + "]\t[" + rhidden + "]";
			System.out.println("sResult 전문 : " + sResult);

			PrintWriter it_out = (PrintWriter) svr.clientMap.get(name);
			try {
				it_out.println(URLEncoder.encode(sResult.toString(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void CmdDefault(String name) {

		try {
			PrintWriter it_out = (PrintWriter) svr.clientMap.get(name);

			it_out.println(URLEncoder.encode("알수없는 명령어 입니다.", "UTF-8"));
		} catch (Exception e) {
			System.out.println("예외[Server/CmdDefault] : " + e);
		}

	}
}
