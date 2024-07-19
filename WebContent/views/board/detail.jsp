
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// getParameter : 브라우저에서 보내온 정보를 꺼내올 때 사용
// getAttribute : requet 객체에 setAttribute한 정보를 꺼내올 때 사용
	BoardVO bv = (BoardVO)request.getAttribute("bv");

	String msg = session.getAttribute("msg") == null ? "" : (String)session.getAttribute("msg");

	session.removeAttribute("msg");

	LocalDateTime date = (LocalDateTime) bv.getBoardDate();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 상세</title>

<style>
	#board-id {
		text-align: right;
	}
</style>

</head>
<body>
	<table border="1">
		<tr>
			<th id="board-id">NO.</th>
			<td><%= bv.getBoardNo() %></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><%= date.format(formatter) %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%= bv.getBoardWriter() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%= bv.getBoardTitle() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><%= bv.getBoardContent() %></td>
		</tr>

		<tr>
			<td colspan="2">
			<a href="<%=request.getContextPath() %>/board/list.do">[목록]</a>
			<a href="<%=request.getContextPath() %>/board/update.do?boardNo=<%=bv.getBoardNo() %>">[게시물 수정]</a>
			<a onclick="return confirm('정말 삭제하시겠습니까?')" href="<%=request.getContextPath() %>/board/delete.do?boardNo=<%=bv.getBoardNo() %>">[게시물 삭제]</a>
			</td>
		</tr>
	</table>
	
	
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