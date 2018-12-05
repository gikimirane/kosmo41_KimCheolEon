<%@page import="com.study.spring.dto.GroupRunningDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MY pets</title>

<%
	String userName = null;
	String email = null;
	if(session.getAttribute("ValidMem") != null){
		userName = (String)session.getAttribute("userName");
		email = (String)session.getAttribute("email_id");
	}
%>



<!-- 웹페이지 메인 -->
<link href="resources/web/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/web/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="resources/web/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<!-- navigation -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="My Pets Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
  <script type="text/javascript" src="resources/web/js/move-top.js"></script>
<script type="text/javascript" src="resources/web/js/easing.js"></script>

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
	href="https://static.onoffmix.com/css/pc/event/event-search.css">
<!-- =================================== 화면 고유 끝 ===================================  -->
<noscript>
	<iframe src="//www.googletagmanager.com/ns.html?id=GTM-TMSKZ8"
		height="0" width="0" style="display: none; visibility: hidden"></iframe>
</noscript>
<script>
	(function(w, d, s, l, i) {
		w[l] = w[l] || [];
		w[l].push({
			'gtm.start' : new Date().getTime(),
			event : 'gtm.js'
		});
		var f = d.getElementsByTagName(s)[0], j = d.createElement(s), dl = l != 'dataLayer' ? '&l='
				+ l
				: '';
		j.async = true;
		j.src = '//www.googletagmanager.com/gtm.js?id=' + i + dl;
		f.parentNode.insertBefore(j, f);
	})(window, document, 'script', 'dataLayer', 'GTM-TMSKZ8');
</script>

<!-- 구글차트를 위한 script -->
  <!-- jQuery -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
  <!-- google charts -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
     <script>
 
  var chartDrowFun = {
 
    chartDrow : function(){
        var chartData = '';
 
        //날짜형식 변경하고 싶으시면 이 부분 수정하세요.
        var chartDateformat     = 'yyyy년MM월dd일';
        //라인차트의 라인 수
        var chartLineCount    = 10;
        //컨트롤러 바 차트의 라인 수
        var controlLineCount    = 10;
 
 
        function drawDashboard() {
 
          var data = new google.visualization.DataTable();
          //그래프에 표시할 컬럼 추가
          data.addColumn('datetime' , '날짜');
          data.addColumn('number'   , '시간(초단위)');

          //그래프에 표시할 데이터
          var dataRow = [];
 
          <%session = request.getSession();
      	ArrayList<GroupRunningDto> rDto = (ArrayList<GroupRunningDto>)session.getAttribute("setting");
      	for(int j=0, k=1 ; j<rDto.size(); j++, k++) {
      		String movetime = rDto.get(j).getMoveTime();
      		
      		String starttime = rDto.get(j).getStartTime();
      		
      		String[] yy = starttime.split("/");
      		String[] dd = yy[2].split(" ");
      		
      		 int m = movetime.indexOf("분");
      	     String mm = movetime.substring(0, m);
      	     int mmConvert = Integer.parseInt(mm);
      	     

      	     String ss = movetime.substring(m + 2, movetime.length() - 1);
      	     int ssConvert = Integer.parseInt(ss);
      	     
      	     int value = (Integer.parseInt(mm)*60) + Integer.parseInt(ss);
      	     
      	     String time = dd[1];
      	     String[] hh = time.split(":");%>
      		
      		var yy = <%=yy[0]%>;
      		var mm = <%=yy[1]%>;
      		var dd = <%=dd[0]%>;
      		var hh = <%=hh[0]%>;
      		var value = <%=value%>;
      		dataRow = [new Date(yy, mm, dd , hh), value];
      		data.addRow(dataRow);
      		
 			<%
 			}
			%>

            var chart = new google.visualization.ChartWrapper({
              chartType   : 'LineChart',
              containerId : 'lineChartArea', //라인 차트 생성할 영역
              options     : {
                              isStacked   : 'percent',
                              focusTarget : 'category',
                              height          : 300,
                              width              : '100%',
                              legend          : { position: "top", textStyle: {fontSize: 13}},
                              pointSize        : 5,
                              tooltip          : {textStyle : {fontSize:12}, showColorCode : true,trigger: 'both'},
                              hAxis              : {format: chartDateformat, gridlines:{count:chartLineCount,units: {
                                                                  years : {format: ['yyyy년']},
                                                                  months: {format: ['MM월']},
                                                                  days  : {format: ['dd일']},
                                                                  hours : {format: ['HH시']}}
                                                                },textStyle: {fontSize:12}},
                vAxis              : {minValue: 100,viewWindow:{min:0},gridlines:{count:-1},textStyle:{fontSize:12}},
                animation        : {startup: true,duration: 1000,easing: 'in' },
                annotations    : {pattern: chartDateformat,
                                textStyle: {
                                fontSize: 15,
                                bold: true,
                                italic: true,
                                color: '#871b47',
                                auraColor: '#d799ae',
                                opacity: 0.8,
                                pattern: chartDateformat
                              }
                            }
              }
            });
 
            var control = new google.visualization.ControlWrapper({
              controlType: 'ChartRangeFilter',
              containerId: 'controlsArea',  //control bar를 생성할 영역
              options: {
                  ui:{
                        chartType: 'LineChart',
                        chartOptions: {
                        chartArea: {'width': '60%','height' : 50},
                          hAxis: {'baselineColor': 'none', format: chartDateformat, textStyle: {fontSize:12},
                            gridlines:{count:controlLineCount,units: {
                                  years : {format: ['yyyy년']},
                                  months: {format: ['MM월']},
                                  days  : {format: ['dd일']},
                                  hours : {format: ['HH시']}}
                            }}
                        }
                  },
                    filterColumnIndex: 0
                }
            });
 
            var date_formatter = new google.visualization.DateFormat({ pattern: chartDateformat});
            date_formatter.format(data, 0);
 
            var dashboard = new google.visualization.Dashboard(document.getElementById('Line_Controls_Chart'));
            window.addEventListener('resize', function() { dashboard.draw(data); }, false); //화면 크기에 따라 그래프 크기 변경
            dashboard.bind([control], [chart]);
            dashboard.draw(data);
 
        }
          google.charts.setOnLoadCallback(drawDashboard);
 
      }
    }
 
$(document).ready(function(){
  google.charts.load('current', {'packages':['line','controls']});
  chartDrowFun.chartDrow(); //chartDrow() 실행
});
  </script>    
</head>
<body class="onoffmix">

	<!-- header-section-starts -->
	<div class="header">
		<div class="header-top">
			<div class="container">
				<p class="location">
					<i class="location"></i>한국소프트웨어인재개발원
				</p>
				<%
                  if(session.getAttribute("ValidMem") != null){
                  %>
				<p class="phonenum"><%=userName%>님 안녕하세요　　　<a href="mem_modify" style="font-size: 20px; color: white;">정보수정</a></p>
				<%
                  }else{
                  %>
				<p class="phonenum"><a href="login" style="font-size: 20px; color: white;">로그인</a> 해주세요</p>
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
                  			if(session.getAttribute("ValidMem") != null){
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
	
	    <div id="Line_Controls_Chart">
      <!-- 라인 차트 생성할 영역 -->
          <div id="lineChartArea" style="padding:0px 20px 0px 0px;"></div>
      <!-- 컨트롤바를 생성할 영역 -->
          <div id="controlsArea" style="padding:0px 20px 0px 0px;"></div>
        </div>

	<!-- Main Content : event/event-search.html -->
	<main id="content" class="event_search"> <!-- wrapping -->
	<div class="content_wrapping max_width_area">
		<!-- event list -->
		<section class="event_main_area">
			<div class="title_bar">
				<h2 class="main_title">기록관리</h2>
			</div>
			<ul class="event_lists">
				<c:forEach items="${recordlist}" var="record">
					<li>
						<article class='event_area event_state'>
							<a href='recordcheck_view?startTime=${record.startTime}'>
								<div class='event_thumbnail'>
									<img src="resources/upload/${record.upLoad}" name="filename">
								</div>
								<div class='event_info_area'>
									<!-- 타이틀 -->
									<div class='title_area'>
										<h5 class='numId ellipsis'>시작시간 : ${record.startTime}</h5>
										<br />
										<h5 class='Name ellipsis'>종료시간 : ${record.endTime}</h5>
										<br />
										<h5 class='Title ellipsis'>이동시간 : ${record.moveTime}</h5>
									</div>

								</div>
							</a>
						</article>
					</li>
				</c:forEach>
			</ul>
			<br/>
			<br/>
			<!-- 페이지항목 부트스트랩 -->
			<td colspan="5">
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">

						<li class="page-item"><a class="page-link"
							href="recheck.do?option=${option}&search=${search}&page=1">[
								&lt;&lt; ]</a></li>
						<li class="page-item"><a class="page-link"
							href="recheck.do?option=${option}&search=${search}&page=${page.curPage - 1}">[
								&lt; ]</a></li>
						<c:forEach var="fEach" begin="${page.startPage}"
							end="${page.endPage}" step="1">
							<li class="page-item"><a class="page-link"
								href="recheck.do?option=${option}&search=${search}&page=${fEach }">[${fEach}]</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link"
							href="recheck.do?option=${option}&search=${search}&page=${page.curPage + 1}">[
								&gt; ]</a></li>
						<li class="page-item"><a class="page-link"
							href="recheck.do?option=${option}&search=${search}&page=${page.totalPage }">[
								&gt;&gt; ]</a></li>
					</ul>
				</nav>
		</section>
		
		
		
		
		<!-- 광고창 -->
        <section class="keyword_search_area">
            <h2 class="hidden">모임 검색</h2>
                
                                <!-- search -->
                <fieldset class="search_area">
                    <label for="keywordSearch" class="title">시작시간 검색하기</label>
                    <form action="recheck" method="post">
                    <input type="text" id="search" name="search" class="keyword_search" placeholder="YYYY/MM/DD">
                    <button type="submit" class="btn_search">검색</button>
                    </form>
                </fieldset>
            </section>	
	</div>
	</main>	

	<!-- =================================== 화면 고유 끝 ===================================  -->

	<!-- PC Common Script -->
	<script src="https://static.onoffmix.com/js/pc/dist/common/header.js"></script>
	<script
		src="https://static.onoffmix.com/js/common/dist/plugins/app/app-ver-chk.js"></script>
	<script
		src="https://static.onoffmix.com/js/common/dist/log/statistic.js"></script>
	<!-- Script -->
	<script type="text/javascript">
		window.NREUM || (NREUM = {});
		NREUM.info = {
			"beacon" : "bam.nr-data.net",
			"licenseKey" : "4d73c0dfa7",
			"applicationID" : "119983018",
			"transactionName" : "Z1MAZEVWDREHWkEMWl4ZI1NDXgwMSXZzKGpzWQxERVgPDgNLGjpHVVsDQA==",
			"queueTime" : 0,
			"applicationTime" : 424,
			"atts" : "SxQDEg1MHh8=",
			"errorBeacon" : "bam.nr-data.net",
			"agent" : ""
		}
	</script>
	
</body>
</html>