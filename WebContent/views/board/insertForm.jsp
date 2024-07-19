<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규회원 등록</title>
</head>
<body>
<%--	요청이 들어오면 지정한 action의 주소로 입력한 내용이 날아감 --%>
<%-- 	루트에는 반드시 해당 애플리케이션의 이름을 지정해줘야 한다.
	 	/ServletExam 대신	<%=request.getContextPath() %> 
	 	컨텍스트 루트를 불러오는 메서드를 사용해서 대체 가능 --%>
<%-- 	<form action="<%=request.getContextPath() %>/board/insert.do" method="post"> --%>
	<form method="post" onsubmit="insertBoard(event)">
		<table>
			<tr>
				<td>작성자명 : </td>
				<td><input type="text" name="boardWriter" value=""></td>
			</tr>
			<tr>
				<td>제목 : </td>
				<td><input type="text" name="boardTitle"></td></td>
			</tr>
			<tr>
				<td>내용 : </td>
				<td><textarea name="boardContent" ></textarea></td>
			</tr>
		</table>
		<input type="submit" value="게시물 등록">
	</form>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>

function insertBoard(e) {
	e.preventDefault();
	
	let formData = $('form').serialize();
	
	$.ajax({
		type: 'post',
		url: '<%=request.getContextPath() %>/board/insert.do',
		data: formData,
		success: function(res) {
			console.log("응답 >>>", res);
			if (res == 1) {
				alert("게시글 등록에 성공하였습니다.");
				location.href = 'list.do';
			} else {
				alert("게시글 등록에 실패하였습니다.");
			}
		},
		error: function(err) {
			console.log(err.status);
		}
	});
	
}

</script>
	
</body>
</html>