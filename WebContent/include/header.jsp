<%-- <%@page import="javax.print.attribute.standard.PagesPerMinuteColor"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>대덕렌탈</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">


<link rel="stylesheet" href="../css/board.css">

<!-- fullCalendar.jsp -->
<link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.css' rel='stylesheet' />
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js'></script>
<!-- fullCalendar.jsp -->

  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
/*     .row.content {height: 450px} */
       .row.content {height: 80vh;}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
/*       height: 100%; */
	  height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>    
<%
	
	String loginCd = (String)session.getAttribute("loginCode");
	
	if(loginCd != null){
%>
		<!-- 회원 -->
		<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>                        
		      </button>
		      <a class="navbar-brand" href="<%=request.getContextPath()%>/Main">로고</a>
		    </div>
		    <div class="collapse navbar-collapse" id="myNavbar">
		      <ul class="nav navbar-nav">
		        <li class="active"><a href="#">홈</a></li>
<!-- 		        <li><a href="./fullCalendar.jsp" title="fullCalendar">회원만</a></li> -->
<!-- 		        <li><a href="./webSocket.jsp" title="webSocket">볼수있는</a></li> -->
<!-- 		        <li><a href="./bootPay.jsp" title="pay">메뉴</a></li> -->
		        <li><a href="/index.jsp?code=1" title="fullCalendar">회원만</a></li>
		        <li><a href="<%=request.getContextPath() %>/index.jsp?code=2" title="webSocket">볼수있는</a></li>
		        <li><a href="/index.jsp?code=3" title="pay">메뉴</a></li>
		        <li><a href="/index.jsp?code=4" title="api">메뉴2</a></li>
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="javascript:myInfo()"><span>내정보</span></a></li>
		        <li><a href="#"><span class="glyphicon glyphicon-bell">0</span></a></li>
		        <li><a href="/Logout"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
		      </ul>
		    </div>
		  </div>
		</nav>
		<!-- 회원 -->


<%
	}else{
%>
		<!-- 비회원 -->
		<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
		        <span class="icon-bar">a</span>
		        <span class="icon-bar">b</span>
		        <span class="icon-bar">c</span>                        
		      </button>
		      <a class="navbar-brand" href="Main">대덕렌탈</a>
		    </div>
		    <div class="collapse navbar-collapse" id="myNavbar">
		      <ul class="nav navbar-nav">
		        <li class="active"><a href="#">자유게시판</a></li>
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="./login.html"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
		      </ul>
		    </div>
		  </div>
		</nav>
		<!-- 비회원 -->
<%	
	}
%>

