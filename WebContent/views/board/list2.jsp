
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<BoardVO> boardList = (List<BoardVO>)request.getAttribute("boardList");

	// 넣은 값을 가져오고, null이면 빈칸으로 초기화시키고, null이 아니면 그대로 가져옴 (오류방지), 삼항연산자 사용
// 	String msg = (String)request.getAttribute("msg") == null ? "" : (String)request.getAttribute("msg");
	
	String msg = session.getAttribute("msg") == null ? "" : (String)session.getAttribute("msg");
	
	session.removeAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원목록</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">

<style>
#container {
  font-family: "Do Hyeon", sans-serif;
}
td {
	border: 2px solid #f59494;
	width : 100px;
	height : 30px;
}
#table {
	width : 800px;
	height : 30px;
	text-align: center;
	margin: 30px;
}
#board-id {
	width : 10px;	
	text-align: center;
	border-left: 2px solid red;
}
#board-date {
	width : 150px;	
}
#board-con {
	width : 300px;
	height : 30px;
	text-align: left;
	border-right: 2px solid red;
}
#table-td{
	border: 2px solid blue;
}
#table-tr th {
	background-color: lightgreen;
	border: 2px solid green;
}
</style>


</head>
<body>

<div id="container">
	<table id="table" class="table table-striped">
		<tr id="table-tr">
			<th>NO.</th>
			<th>작성일</th>
			<th>작성자</th>
			<th>제목</th>
			<th id="bv-con">내용</th>
		</tr>
		
<%
	int boardSize = boardList.size();

	
	if (boardSize > 0) {
		for (BoardVO bv : boardList) {
		LocalDateTime date = (LocalDateTime) bv.getBoardDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");
%>	
		<tr>
			<td id="board-id"><%= bv.getBoardNo() %></td>
			<td id="board-date"><%= date.format(formatter) %></td>
			<td id="board-writer"><%= bv.getBoardWriter() %></td>
			<td><a href="<%=request.getContextPath() %>/board/detail.do?boardNo=<%= bv.getBoardNo() %>"><%= bv.getBoardTitle() %></td>
			<td id="board-con"><%= bv.getBoardContent() %></td>
		</tr>
<%
		} // for문
		
	} else {
%>	
		<tr>
			<td colspan="5">게시물이 존재하지 않습니다.</td>
		</tr>
<%	
	} // if문
%>	
		
		<tr align="center">
			<td id="table-td" colspan="5"><a href="<%=request.getContextPath() %>/board/insert.do">[게시물 등록]</a></td>
		</tr>

	</table>
</div>

<%-- 정상적으로 처리되었을 때만 알림창이 뜨도록 할 것임 --%>
<%
	if (msg.equals("SUCCESS")) {
%>
<script>
// 정상적으로 처리되었을 때만 알림창이 뜨도록 할 것임
	alert('정상적으로 처리되었습니다.');
</script>
<%
	}
%>
</body>
</html>