<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>replyForm</title>

<script src="https://code.jquery.com/jquery.js" ></script>

<style type="text/css">
#wrap {
	width: 550px;
	margin: 0 auto 0 auto;
	text-align: center;
}

#commentReplyForm {
	text-align: center;
}
</style>

<script type="text/javascript">
	
	function checkValue(){
		alert("흑흑 광고아 우럭따");
		var form = document.forms[0];
		// 전송할 값을 변수에 담는다.	
		var comment_num = "${content_ReplyDto.reply}";
		var comment_board = "${content_ReplyDto.numId}";
		var comment_id = "${content_ReplyDto.writeName}";
		var comment_content = form.comment_content.value
		
		if(!comment_content){
			alert("내용을 입력하세요");
			return;
		}else{
			alert("헉 내용 이써용;");
			$.ajax({
			      url : 'content_reply_reply',
			      type : 'POST',
			      data : 'name=' + comment_id + "&comment_num=" + comment_num + "&comment_board=" + comment_board + "&comment_content="+comment_content,
			      dataType : 'json',
			      success : function(json) {
			    	  var result = eval(json);
			    	  alert(result[0].desc);
			    	  window.opener.document.location.reload();
				      opener.repltForm = null;
				      self.close();
			      }
			 });
		}
		
	}
	
</script>
</head>
<body>
	<div id="wrap">
		<br> <b><font size="5" color="gray">댓글 답변</font></b>
		<hr size="1" width="550">
		<br>

		<div id="commentReplyForm">
			<form name="replyInfo" target="parentForm">
				<textarea rows="7" cols="70" name="comment_content"></textarea>
				<br><br>
				<input type="button" value="등록" onclick="checkValue();">
				<input type="button" value="창닫기"	onclick="window.close();">
			</form>
		</div>
	</div>
	

</body>
</html>