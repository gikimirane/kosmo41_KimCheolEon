<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileForm JSP</title>
</head>
<body>
	<form action="fileFormOk" method="post" enctype="multipart/form-data">
		파일 : <input type="file" name="filename"> <br>
		<input type="submit" value="file Upload">
	</form>
	
</body>
</html>