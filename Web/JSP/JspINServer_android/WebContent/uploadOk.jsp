<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getRealPath("fileFolder");

	int size = 1024 * 1024 * 10; // 10MB
	String file = "";
	String oriFile = "";

	JSONObject obj = new JSONObject();

	try {
		MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8",
				new DefaultFileRenamePolicy());

		Enumeration files = multi.getFileNames();
		String str = (String) files.nextElement();

		file = multi.getFilesystemName(str);
		oriFile = multi.getOriginalFileName(str);

		if (file == null) {
			obj.put("fail", new Integer(2));
			obj.put("desc", "file null...");
		} else {
			obj.put("success", new Integer(1));
			obj.put("desc", "성공");
		}
	} catch (Exception e) {
		e.printStackTrace();
		obj.put("fail", new Integer(3));
		obj.put("desc", e.getMessage());
	}

	//JSONObject obj = new JSONObject();
	//obj.put("success", new Integer(1));
	//obj.put("desc", "성공");

	out.println(obj.toJSONString());
%>