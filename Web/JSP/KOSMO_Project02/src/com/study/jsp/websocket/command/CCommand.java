package com.study.jsp.websocket.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response);
//	Jsp25_3 Service 참고했음.
}
