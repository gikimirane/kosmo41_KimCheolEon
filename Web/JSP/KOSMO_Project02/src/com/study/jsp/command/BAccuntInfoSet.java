package com.study.jsp.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.study.jsp.BDao;
import com.study.jsp.BDto;

public class BAccuntInfoSet implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){

//		"ggID="+ggID+"&ggName="+ggName+"&ggImageURL="+ggImageURL+"&ggEmail="+ggEmail;
		
		String ggID = request.getParameter("ggID");
		String ggName = request.getParameter("ggName");
		String ggImageURL = request.getParameter("ggImageURL");
		String ggEmail = request.getParameter("ggEmail");
		
/*		System.out.println("ggID :" + ggID);
		System.out.println("ggName : " + ggName);
		System.out.println("ggImageURL : " + ggImageURL);
		System.out.println("ggEmail : " + ggEmail);*/
		
		HttpSession session = null;
		session = request.getSession();
		session.setAttribute("ggID", ggID);
		session.setAttribute("ggName", ggName);
		session.setAttribute("ggImageURL", ggImageURL);
		session.setAttribute("ggEmail", ggEmail);
		
		try {
			PrintWriter writer = response.getWriter();
			writer.println("[{\"result\":\"ok\",\"desc\":\"none\"}]");
			writer.close();	
		} catch (Exception e) {
			System.out.println("AccountInfoSetError :" + e);
			try {
				PrintWriter writer = response.getWriter();
				writer.println("[{\"result\":\"fail\",\"desc\":\"로그아웃 실패\"}]");
				writer.close();
			} catch (Exception e2) {
			}
		}
	}
}
