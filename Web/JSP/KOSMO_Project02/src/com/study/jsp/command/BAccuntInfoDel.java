package com.study.jsp.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;
import com.study.jsp.BDto;

public class BAccuntInfoDel implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){

		HttpSession session = null;
		session = request.getSession();
		
		session.invalidate();
		
		
		String ggID = null;
		String ggName = null;
		String ggImageURL = null;
		String ggEmail = null;
		
		/*session.getAttribute("ggID");
		session.getAttribute("ggName");
		session.getAttribute("ggImageURL");
		session.getAttribute("ggEmail");	
		
		System.out.println("ggID :" + ggID);
		System.out.println("ggName : " + ggName);
		System.out.println("ggImageURL : " + ggImageURL);
		System.out.println("ggEmail : " + ggEmail);*/
		
		try {
			PrintWriter writer = response.getWriter();
			writer.println("[{\"result\":\"ok\",\"desc\":\"none\"}]");
			writer.close();	
		} catch (Exception e) {
			System.out.println("AccountInfoSetError :" + e);
			try {
				PrintWriter writer = response.getWriter();
				writer.println("[{\"result\":\"fail\",\"desc\":\"로그인 실패\"}]");
				writer.close();
			} catch (Exception e2) {
			}
			
		}
	}
}
