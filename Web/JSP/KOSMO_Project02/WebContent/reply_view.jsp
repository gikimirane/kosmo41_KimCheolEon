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
</head>
<script type="text/javascript">
	function form_check() {
		
		var reply_bTitle = $("#reply_bTitle").val();
		var reply_content = $("#reply_content").val();		
		if(reply_bTitle != "" && reply_content != ""){
			/* alert("둘다 내용 있음"); */	
			document.getElementById('reply_form').submit();
		}else{
			alert("제목 또는 내용이 비었음");
		}
	}
</script>
<body>
<form action="reply.do" method="post" enctype="multipart/form-data" id="reply_form">

	<input type="hidden" name="bId" value="${reply_view.bId }">
	<input type="hidden" name="bGroup" value="${reply_view.bGroup }">
	<input type="hidden" name="bStep" value="${reply_view.bStep }">
	<input type="hidden" name="bIndent" value="${reply_view.bIndent }">
	
	<table style="width: 100%" border="1">
		<tr>
			<td>번호</td>
			<td>${reply_view.bId }</td>
		</tr>
		<tr>
			<td>히트</td>
			<td>${reply_view.bHit }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="hidden" name="bName" size="50" value="<%=ggName%>"><%=ggName%></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="bTitle" value="${reply_view.bTitle } - " id="reply_bTitle"></td>
		</tr>
		<tr>
			<td>원문내용</td>
			<td>${reply_view.bContent }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea name="bContent" id="reply_content" rows="10" cols="80">
					by CKEditor
	           	</textarea>
	           	<script>
	                // Replace the <textarea id="editor1"> with a CKEditor
	                // instance, using default configuration.
	                CKEDITOR.replace( 'reply_content' );
	           	</script>
			</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td><input type="file" name="filename"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="답변" onclick="">
				<a href="list.do?page=<%=session.getAttribute("cpage")%>">목록보기</a> &nbsp;&nbsp;
			</td>
		</tr>
	</table>
</form>

</body>
</html>