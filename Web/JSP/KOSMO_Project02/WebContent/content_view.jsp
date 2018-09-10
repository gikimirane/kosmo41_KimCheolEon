<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	/* String ggName = (String) session.getAttribute("ggName");
	String ggEmail = (String) session.getAttribute("ggEmail"); */
	boolean contentNameCheck = (boolean)session.getAttribute("contentNameCheck");
%>
</head>
<script>
	function onDownload(bId) {
		var o = document.getElementById("ifrm_filedown");	
		o.src = "download.do?bId="+bId;
	
	}
</script>
<body>
<!-- 참고 : http://cusmaker.tistory.com/111 -->
<iframe id="ifrm_filedown"  style="position:absolute; z-index:1;visibility : hidden;"></iframe>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
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
			<td>${content_view.bName }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${content_view.bTitle }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${content_view.bContent }</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td>
				<a href="#" onclick="onDownload('${content_view.bId}')">${content_view.bFilename}</a>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			
			<!-- 여기서 true false 구별이 안되서 BDao - contentView 에서 비교후 세션을 생성해버림 -->
			<%
				if(contentNameCheck){
			%>
				<a href="modify_view.do?bId=${content_view.bId }">수정</a>&nbsp;&nbsp;
				<a href="delete.do?bId=${content_view.bId }&filename=${content_view.bFilename}">삭제</a>&nbsp;&nbsp;
			<%
				}
			%>
				<a href="list.do?page=<%=session.getAttribute("cpage")%>">목록보기</a> &nbsp;&nbsp;
				<a href="reply_view.do?bId=${content_view.bId }">답변</a>
			</td>
		</tr>
	</table>
	
	<br> ggName : [${ggName}]
	<br> content_view.bName : [${content_view.bName}]

</body>
</html>