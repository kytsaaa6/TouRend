<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		width : 500px;
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
        
	<h4>
		<%-- ${viewData.messageTotalCount} <br> ${viewData.currentPageNumber}
		<br> ${viewData.currentPageNumber} <br>
		${viewData.pageTotalCount} <br> ${viewData.messageCountPerPage} <br>
		${viewData.firstRow} <br> ${viewData.endRow} <br> --%>

	</h4>
	
	<H1> 리뷰 목록 </H1>
	
	<DIV style="text-align: right;"> <a href="write">리뷰 작성하기</a></DIV>
	
	
	<c:if test="${viewData.reviewTotalCount>0}">
	
	<c:forEach items="${viewData.reviewList}" var="review">
		<div>
		리뷰 번호 : ${review.id}<br> 
		리뷰 제목 :${review.title}<br>
		리뷰 내용 :${review.contents}<br> 
		사진 : ${review.photo}<br> 
		평점 :${review.star}<br>
		작성자 :${review.member_id}<br>
		<a href="update?reviewId=${review.id}">수정하기</a> 
		<a href="delete?reviewId=${review.id}">삭제하기</a>
		</div>
	
	
	</c:forEach>
	
	
	<c:forEach begin="1" end="${viewData.pageTotalCount}" step="1" var="num">
		<a href="list?page=${num}">[${num}]</a> 
	</c:forEach>

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
	
</body>
</html>