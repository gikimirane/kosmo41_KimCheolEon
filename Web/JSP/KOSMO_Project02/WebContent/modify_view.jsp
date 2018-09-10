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
<script>
	function form_check() {
		
		var modify_title = $("#modify_title").val();
		var modify_content = $("#modify_content").val();		
		if(modify_title != "" && modify_content != ""){
/* 			alert("둘다 내용 있음");	 */
			document.getElementById('modify_form').submit();
		}else{
			alert("제목 또는 내용이 비었음");
		}
	}
</script>
<body>
<form name="modify_form" action="modify.do" method="post" id="modify_form">
	<table width="800" cellpadding="0" cellspaceing="0" border="1">
			<input type="hidden" name="bId" value="${content_view.bId }">
			<tr>
				<td>번호</td>
				<td>${content_view.bId }</td>
			</tr>
			<tr>
				<td>히트</td>
				<td>${content_view.bHit }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="hidden" name="bName" size="50" value="<%=ggName%>"><%=ggName%></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" value="${content_view.bTitle }" id="modify_title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="bContent" id="modify_content" rows="10" cols="80">
						${content_view.bContent }
		           	</textarea>
		           	<script>
		                // Replace the <textarea id="editor1"> with a CKEditor
		                // instance, using default configuration.
		                CKEDITOR.replace( 'modify_content' );
		           	</script>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="javascript:form_check();">수정완료</a>
					<a href="content_view.do?bId=${content_view.bId }">취소</a>&nbsp;&nbsp;
					<a href="list.do?page=<%=session.getAttribute("cpage")%>">목록보기</a> &nbsp;&nbsp;
				</td>
			</tr>
	</table>
</form>

</body>
</html>