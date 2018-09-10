<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>
<script src="http://code.jquery.com/jquery.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String ggName = (String) session.getAttribute("ggName");
	String ggEmail = (String) session.getAttribute("ggEmail");
%>

<script type="text/javascript">

	function writeform_check() {
		var write_title = $("#write_title").val();
		var write_content = $("#write_content").val();		
		if(write_title != "" && write_content != ""){
			/* alert("둘다 내용 있음"); */	
			document.getElementById('write_form').submit();
		}else{
			alert("제목 또는 내용이 비었음");
		}
	}

</script>
</head>
<body>
	<form action="write.do" method="post" enctype="multipart/form-data" id="write_form">
		<table style="width: 100%" border="1">
			<tr>
				<td>이름</td>
				<td><input type="hidden" name="bName" size="50" value="<%=ggName%>"><%=ggName%></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" size="50" id="write_title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<!-- <td><textarea name="bContent" rows="10"></textarea></td> -->
				<td>
					<textarea name="bContent" id="write_content" rows="10" cols="80">
						by CKEditor
	            	</textarea>
	            	<script>
		                // Replace the <textarea id="editor1"> with a CKEditor
		                // instance, using default configuration.
		                CKEDITOR.replace( 'write_content' );
	            	</script>
				</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="filename"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="입력" onclick="writeform_check()">&nbsp;&nbsp;
					<a href="list.do">목록보기</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>