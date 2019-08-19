<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
</style>
</head>
<body>

	<h3>리뷰 작성하기</h3>
	<hr>
	<form method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>

			<tr>
				<td>내용</td>
				<td><textarea rows="3" cols="30" name="contents"></textarea></td>
			</tr>
			<tr>
				<td>사진 첨부</td>
				<td><input type="text" name="photo"></td>
			</tr>
			<tr>
				<td>평점</td>
				<td><input type="text" name="star"></td>
			</tr>
			<tr>
				<td>멤버 아이디</td>
				<td><input type="number" name="member_id"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="등록"></td>
			</tr>


		</table>
	</form>
	
</body>	
</html>