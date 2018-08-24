package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cal")
public class Cal extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");

		request.setCharacterEncoding("UTF-8");

		int result = 0;
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
//        parseInt 에 문자열 들어가면 뻗을텐데, try-catch 넣으면 됨

		String calc = request.getParameter("calcradio");

		if (calc.equals("+")) {
			result = num1 + num2;
		}
		if (calc.equals("-")) {
			result = num1 - num2;
		}
		if (calc.equals("*")) {
			result = num1 * num2;
		}
		if (calc.equals("/")) {
			if (num2 <= 0) {
				System.out.println("0으로 나눌 수 없음");
			} else {
				result = num1 / num2;
			}
		}

		doSuccess(request, response, num1, num2, calc, result);

		/*
		 * if(예외체크) doSuccess(request, response, num1, num2, calc, nResult); doFail
		 */
	}

	void doSuccess(HttpServletRequest request, HttpServletResponse response, int num1, int num2, String calc,
			int result) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

//		HashMap<String, String> options = new LinkedHashMap<String, String>();
//		
//		options.put("key1", "value1");
//		options.put("key3", "value3");
//		options.put("key2", "value2");
//		options.put("key4", "value4");
		
		response.getWriter().print(result);
//		response.getWriter().print(options);
		
		
	}

	void doFail() {

	}

}
