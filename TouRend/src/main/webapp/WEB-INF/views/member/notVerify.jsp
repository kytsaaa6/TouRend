<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Dashboard</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/regist.css" rel="stylesheet" type="text/css" >

<script>
</script>


</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">


        <!-- Begin Page Content -->
        <div class="container-fluid">

			  <div class="container">
    <div class="row">
      <div class="col-lg-10 col-xl-9 mx-auto">
        <div class="card card-signin flex-row my-5">
          <div class="card-img-left d-none d-md-flex">
             <!-- Background image for card set in CSS! -->
          </div>
          <div class="card-body">
            <h5 class="card-title text-center">Email 인증을 완료하여 주세요.</h5>
            <h5 class="card-title text-center" style="font-size: 20px">가입 시 입력한 이메일 주소에서 인증 메일을 확인하여 주세요 </h5>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button>
              <!-- <input class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register -->
              <a class="d-block text-center mt-2 small" id="mailSend" href="#"> 인증 메일 전송 </a>
              <hr class="my-4">
          </div>
        </div>
      </div>
    </div>
  </div>

		</div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>


  <!-- Bootstrap core JavaScript-->
  <script src="<c:url value="/resources/vendor/jquery/jquery.slim.min.js" />"></script>
  <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>


<script>

	$(document).ready(function() {
		
		
		$('#mailSend').click(function() {
			
			$.ajax({
				url : 'verify/reMailSend',
				type : 'post',
				
				
				
			});
			
			
			
			
			
			
			
			
		});
		
		
		
		
		
		
		
	});
	
	

</script>

</body>

</html>
