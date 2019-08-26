<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>

	<h1>회원 리스트</h1>
	<hr>
	<div id="memberlist"></div> <br>
	
	
<script>
	$(document).ready(function() {
		
		$.ajax({
			url: 'http://localhost:8080/tr/rest-api/members',
			type: 'GET',
			success: function(data) {
				alert(JSON.stringify(data));
			}
			
		});
		
	});

</script>
</body>
</html>