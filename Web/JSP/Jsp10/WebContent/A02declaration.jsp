<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A02declaration</title>
</head>
<body>
	<%!
		int i = 10;
		String str = "abc";
		
		private int sum(int a, int b){
			return a+b;
		}
	%>
	
	숫자 i : <%= i %><br>
	문자 str : <%= str %><br>
	sum 3,5 의 값 : <%= sum(3,5) %><br>


</body>
</html>