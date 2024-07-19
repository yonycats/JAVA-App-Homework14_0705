
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	BoardVO bv = (BoardVO) request.getAttribute("bv");

	LocalDateTime date = (LocalDateTime) bv.getBoardDate();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 변경</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/board/update.do" method="post">
		<input type="hidden" name="boardNo" value="<%=bv.getBoardNo() %>">
		<table>
			<tr>
				<td>게시물번호</td>
				<td><%=bv.getBoardNo() %></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><%=date.format(formatter) %></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="boardWriter" value="<%=bv.getBoardWriter() %>"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="boardTitle" value="<%=bv.getBoardTitle() %>"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="boardContent" ><%=bv.getBoardContent() %></textarea></td>
			</tr>

		</table>
		<input type="submit" value="회원정보 수정">

	</form>
</body>
</html>