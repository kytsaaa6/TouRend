<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
div {
	border : 2px solid #666;
	width: 200px;
}
</style>
</head>
<body>

	<h1> 방명록 </h1>
	
	<div style="text-align: right;"> <a href="writeForm">글쓰기</a></div>
	
	<div id="list">
	
	</div>
	
	<div id="paging">
	
	</div>
	
	
	
<script>

	$(document).ready(function() {
		
		$.ajax({
			url: 'guest/listJson',
			type: 'get',
			data: {page:1},
			success: function(data) {
				//alert(data); /* 응답 데이터 확인 */
				//console.log(data); /* 콘솔 확인용 */
				//alert(data.messageTotalCount); /* 총개수 직접 참조 */
				//alert(JSON.stringify(data)); /* JSON 형식으로 보기 */
				
				var output = '';
				
				var list = data.messageList;
				for(var i = 0; i < list.length; i++) {
					console.log(list[i]);
					var id = list[i].id;
					var guestName = list[i].guestName;
					var message = list[i].message;
						
					output += '<div>\n';
					output += '메시지 번호 : '+id+' <br>\n';
					output += '손님 이름 : '+id+' <br>\n'; 
					output += '메시지 : '+id+' <br>\n';
					output += '</div>\n';
				}
				
				$('#list').html(output);
			}
			
		});	
		
	});

</script>



</body>
</html>
