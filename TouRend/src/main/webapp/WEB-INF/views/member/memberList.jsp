<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Dashboard</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet" type="text/css" >

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	#list {
		border : 2px solid #666;
		width : 800px;
	}
	
	table {
		width : 700px;
		
	}
	
	table>tr td {
		margin: 20px 30px;
	
	}
	
	
	
</style>

</head>
<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
	<%@ include file="/WEB-INF/views/frame/sidebar.jsp" %>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
		<%@ include file="/WEB-INF/views/frame/nav.jsp" %>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid" id="list">


	<h3 style="text-align: center">회원 리스트</h3>
	<hr>
	<div class="searchBox">
	
		<form>
			<select name="stype">
				<option value="both">아이디+이름</option>
				<option value="id">아이디</option>
				<option value="name">이름</option>
			</select>
			<input type="text" name="keyword"> <input type="submit" value="검색">
		</form>
		
	</div>
	<div id="mList">
	<table>
		<tr>
			<td>no</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>사진</td>
			<td>가입일</td>
			<td>관리</td>
		</tr>
		
		<c:forEach items="${viewData.memberList}" var="memberInfo" varStatus="stat" >
		<tr>
			<td><%-- ${memberInfo.idx} / ${stat.index} / ${stat.count} / ${viewData.totalCount} /  --%>${viewData.no-stat.index}</td>
			<td>${memberInfo.uId}</td>
			<td>${memberInfo.uPw}</td>
			<td>${memberInfo.uName}</td>
			<td><img src="<c:url value='/uploadfile/userphoto/${memberInfo.uPhoto}'/>" height="30">  </td>
			<td>
				<fmt:formatDate value="${memberInfo.regDate}" pattern="yyyy.MM.dd"/>
			</td>
			<td>	
				<a href="memberEdit?memberId=${memberInfo.idx}">수정</a> 
				<a href="#" onclick="delMember(${memberInfo.idx})">삭제</a>
			</td>
		</tr>
		</c:forEach>
		
	</table>
	</div>
	
	<c:if test="${viewData.totalCount>0}">
	<div id="pagingBox" style="text-align: center">
		<c:forEach begin="1" end="${viewData.pageTotalCount}" var="num">
			<%-- <div><a href="memberList?p=${num}">${num}</a> </div> --%>
			<div><a href="memberList?p=${num}&stype=${param.stype}&keyword=${param.keyword}">${num}</a> </div> 
		</c:forEach>
		
	</div>
	</c:if>
	
			</div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

	<!-- Footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp" %>
	<!-- End Of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
	<%@ include file="/WEB-INF/views/frame/logout.jsp" %>

  <!-- Bootstrap core JavaScript-->
  <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
  <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

  <!-- Core plugin JavaScript-->
  <script src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

  <!-- Custom scripts for all pages-->
  <script src="<c:url value="/resources/js/sb-admin-2.min.js"/>"></script>

  <!-- Page level plugins -->
  <script src="<c:url value="/resources/vendor/chart.js/Chart.min.js"/>"></script>

  <!-- Page level custom scripts -->
  <script src="<c:url value="/resources/js/demo/chart-area-demo.js"/>"></script>
  <script src="<c:url value="/resources/js/demo/chart-pie-demo.js"/>"></script>
	



<script>
	function delMember(idx) {
		
		if(confirm("삭제하시겠습니까?")){
			/* location.href = 'memberDelete?memberId='+idx; */
			location.href = 'delete/'+idx;
		}
		
	}
</script>














</body>
</html>
