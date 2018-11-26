<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	pageContext.setAttribute("br", "<br/>");
	pageContext.setAttribute("cn", "\n");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>content_view</title>

<!-- 댓글기능 -->
<link rel="stylesheet" type="text/css"
	href="https://t1.daumcdn.net/tistory_admin/blogs/plugins/MapSideBar/static/mapSidebar.css?_version_=4730ecfe869263f43ddcc7621843f343afb05ed3" />
<link rel="stylesheet" type="text/css"
	href="https://t1.daumcdn.net/tistory_admin/blogs/style/menubar.css?_version_=4730ecfe869263f43ddcc7621843f343afb05ed3" />
<!--[if lt IE 9]><script src="https://t1.daumcdn.net/tistory_admin/lib/jquery/jquery-1.12.4.min.js"></script><![endif]-->
<!--[if gte IE 9]>
<!-->
<script
	src="https://t1.daumcdn.net/tistory_admin/lib/jquery/jquery-3.2.1.min.js"></script>
<!--<![endif]-->


<%
	String content_view_makerName = (String) session.getAttribute("content_view_makerName");
	String userName = null;
	if (session.getAttribute("ValidMem") != null) {
		userName = (String) session.getAttribute("userName");
	}
%>

<!-- 웹페이지 메인 -->
<link href="resources/web/css/bootstrap.css" rel='stylesheet'
	type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/web/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="resources/web/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<!-- Custom Theme files -->
<!-- navigation -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="My Pets Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 



</script>
<!--webfont-->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="resources/web/js/move-top.js"></script>
<script type="text/javascript" src="resources/web/js/easing.js"></script>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">


<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<!-- =================================== 공통 시작 ===================================  -->
<!-- OFM Common Style -->
<link rel="stylesheet"
	href="https://static.onoffmix.com/css/common/pc/common-pc.css">
<!-- Common Script -->
<script
	src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery-1.10.2.js"></script>
<script
	src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery-ui-1.10.4.custom.js"></script>
<script
	src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.dotdotdot-1.5.0.js"></script>
<!-- =================================== 공통 끝 ===================================  -->

<!-- =================================== 화면 고유 시작 ===================================  -->
<!-- OFM Style -->
<link rel="stylesheet"
	href="https://static.onoffmix.com/css/pc/event/event-view.css">
<!-- =================================== 화면 고유 끝 ===================================  -->
<script>dataLayer=[{uid:"990343"}]</script>
<noscript>
	<iframe src="//www.googletagmanager.com/ns.html?id=GTM-TMSKZ8"
		height="0" width="0" style="display: none; visibility: hidden"></iframe>
</noscript>
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
			new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
			j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
			'//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
		})(window,document,'script','dataLayer','GTM-TMSKZ8');</script>


<style type="text/css">
#main{
overflow: auto;
}
</style>
</head>
<body>

	<!-- header-section-starts -->

	<div class="header">
		<div class="header-top">
			<div class="container">
				<p class="location">
					<i class="location"></i>한국소프트웨어인재개발원
				</p>
				<%
					if (session.getAttribute("ValidMem") != null) {
				%>
				<p class="phonenum"><%=userName%>님 안녕하세요 <a href="mem_modify"
						style="font-size: 20px; color: white;">정보수정</a>
				</p>
				<%
					} else {
				%>
				<p class="phonenum"><%=userName%>님 안녕하세요　　　<a href="mem_modify" style="font-size: 20px; color: white;">정보수정</a></p>
				<%
					}
				%>
				<div class="clearfix"></div>
			</div>
		</div>

		<div class="header-bottom">
			<div class="container">
				<div class="logo">
					<a href="/spring"><img src="resources/web/images/logo.png"
						alt="" /></a>
				</div>
				<span class="menu"></span>
				<div class="top-menu">
					<ul>
						<nav class="cl-effect-5">
							<li><a class="active" href="/spring"><span
									data-hover="Home">Home</span></a></li>
							<li><a href="list"><span data-hover="일반게시판">일반게시판</span></a></li>
							<li><a href="joinlist"><span data-hover="모임게시판">모임게시판</span></a></li>
							<%
								if (session.getAttribute("ValidMem") != null) {
							%>
							<li><a href="recheck"><span data-hover="기록관리">기록관리</span></a></li>
							<li><a href="myPagelist"><span data-hover="마이페이지">마이페이지</span></a></li>
							<li><a href="logout"><span data-hover="로그아웃">로그아웃</span></a></li>
							<%
								}
							%>
						</nav>
					</ul>
				</div>
				<!-- script for menu -->
				<script>
            $( "span.menu" ).click(function() {
              $( ".top-menu" ).slideToggle( "slow", function() {
                // Animation complete.
              });
            });
         </script>
				<!-- script for menu -->
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

	<!-- Main Content : event/event-view.html -->
	<!-- wrapping -->
	<div class="container justify-content-center">
		<div class="content_wrapping">
			<!-- EVENT Summary Infomation -->
			<section class="event_summary">
				<div class="top_area"></div>
				<div class="center_area">

					<h3 class="event_title">${content_view.bTitle }</h3>
					<ul class="event_info_wrap">
						<li><i class="fas fa-calendar"> 글번호</i>
							<p class="description bId">${content_view.bId}</p></li>

						<li><i class="fas fa-thumbs-up"> 조회수</i>
							<p class="description bHit">${content_view.bHit}</p></li>

						<li><i class="fas fa-address-card"> 작성자</i>
							<p class="description place">
								<span class="bName">${content_view.bName }</span>
							</p></li>

						<li><i class="fas fa-comment-dots"> 내용</i></li>
					</ul>

					<!-- 이벤트 요약설명 : 서브 타이틀 -->
					<div class="summary_wrap">
						<p class="summary_txt">${content_view.bContent}
					</div>
				</div>
				<br /> <br />
				<div class="bottom_area" align="right" style="font-size: 20px;">
					<a href="list.do?page=<%=session.getAttribute("cpage")%>"
						class="badge badge-pill badge-info">목록보기</a>&nbsp;&nbsp;

					<!-- 작성자와 열람자 동일여부 확인 동일인일시 수정,삭제 활성화 -->
					<%
						if (content_view_makerName.equals(userName)) {
					%>

					<a href="modify_view.do?bId=${content_view.bId }"
						class="badge badge-pill badge-warning">수정</a>&nbsp;&nbsp; <a
						href="delete.do?bId=${content_view.bId }"
						class="badge badge-pill badge-danger">삭제</a>&nbsp;&nbsp;

					<%
						}
					%>

					<a href="reply_view.do?bId=${content_view.bId}"
						class="badge badge-pill badge-success">답변</a>
				</div>
				<br />
				<!-- 댓글 부분 -->
				<div id="comment">
					<table border="1" bordercolor="lightgray">
						<tr bgcolor="#F5F5F5">
							<!-- 아이디-->
							<td width="150">
							<%if(session.getAttribute("ValidMem") != null) { %>
								<div>
									<%=userName%>
								</div>
								<%}else{ %>
								<div>
								</div>
								<%} %>
							</td>
							<!-- 본문 작성-->
							<td width="550">
								<div>
									<textarea id="contentBox" rows="4" cols="70" style="resize: none;"></textarea>
								</div>
							</td>
							<!-- 댓글 등록 버튼 -->
							<td width="100">
								<div id="btn" style="text-align: center;">
									<p>
										<a href="javascript:void(0);" onclick="idcheck()">[댓글등록]</a>
									</p>
								</div>
							</td>
						</tr>

						<!-- 댓글 목록 -->
						<tr>
							<!-- 아이디, 작성날짜 -->
							<c:forEach var="reply" items="${content_reply}">
							<td>									
									<div>
										${ reply.writeName}<br>
										<font size="2" color="lightgray">${reply.timeInfo }</font>
									</div>
									</td>
									</td>
									<!-- 본문내용 -->
									<td width="550">
										<div class="text_wrapper">${fn:replace(reply.content, cn, br) }</div>
									</td>
									<!-- 버튼 -->
									<td width="100">
										<div id="btn" style="text-align: center;">
											<c:if test="${ reply.writeName eq userName}">
												<!-- 댓글 작성자만 수정, 삭제 가능하도록 -->
											<a href="javascript:void(0);" onclick="reply_delete(${reply.reply});">[삭제]</a>
											</c:if>
										</div>
									</td>
						</tr>
						</c:forEach>
					</table>
				</div>
			</section>
		</div>
	</div>
	<script>
	var scriptUsername = '<%=userName%>';
	function idcheck() {
		alert(document.getElementById('contentBox').value);
		if(scriptUsername != "null") {
			if(document.getElementById('contentBox').value != "") {
				$.ajax({
				      url : 'content_reply',
				      type : 'POST',
				      data : 'name=' + scriptUsername + "&numId=" +  '${content_view.bId}' + "&content=" + document.getElementById('contentBox').value,
				      dataType : 'json',
				      success : function(json) {
				         var result = eval(json);
				         alert(result[0].desc);
				         location.reload(); 
				      }
				   });
			}else {
				alert("글을 입력하지 않아 댓글을 달 수 없습니다.");
			}
			
		}else {
			alert("로그인후 이용가능합니다.");
		}
	}
	
	function reply_delete(content_num){
		var msg = confirm("댓글을 삭제합니다.")
		if(msg == true) {
			 $.ajax({
			      url : 'reply_delete',
			      type : 'POST',
			      data : 'name=' + scriptUsername + "&numId=" +  content_num ,
			      dataType : 'json',
			      success : function(json) {
			         var result = eval(json);
			         alert(result[0].desc);
			         location.reload(); 
			      }
			   });
		}else {
			alert("false");
			return false;
			}
		}
	</script>
</body>
</html>