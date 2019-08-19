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
/* $(document).ready(function() {
	
	$('#uId').focusout(function() {
		
		// aJax 비동기 통신 id 전송 사용 유무에 대한 결과 값을 반환
		
		$.ajax({
			url: 'idCheck.do',
			type: 'get',
			// 전송할 파라미터
			data: {id: $(this).val()},
			success: function(data){
				alert(data);
				
				$('#idcheckmsg').html('');
				$('#idcheckmsg').removeClass('color_red');
				$('#idcheckmsg').removeClass('color_blue');
				
				if(data == 'Y'){
					$('#idcheck').prop('checked', true);
					$('#idcheckmsg').html('사용가능한 멋진 아이디 입니다.');
					$('#idcheckmsg').addClass('color_blue');
				} else {
					$('#idcheck').prop('checked', false);
					$('#idcheckmsg').html('사용중인 아이디 이거나 탈퇴한 아이디 입니다.');
					$('#idcheckmsg').addClass('color_red');
				}
				
			}
		});
		
		
		$('#regform').submit(function(){
			
			if(!$('#idcheck').prop('checked')){
				alert('아아디 중복확인이 필요합니다.');
				return false;
			}
			
		});
		
		
	});
	
	
	
}); */

$(document).ready(function() {

	

	/* Member Validation */
	/* 
	   id - 길이: 5~20, 영어대소문자, 숫자 각 1개 이상 포함
	   pw - 길이: 9~20, 특수문자, 영어대소문자, 숫자 각 1개 이상 포함
	   email - email 폼
	   photo - 확장자 jpg, png || null 이면 default image
	*/
	
	function checkz() {
	
	$('#inputUserame').focusout(function() {
		
	});
	
	$('#inputEmail').focusout(function() {
		
	});
	
	$('#inputPassword').focusout(function() {
		
	});
	
	$('#inputFile').focusout(function() {
		
	});
	
	}

	/* Confirm Password Match */
	$('#inputConfirmPassword').focusout(function() {
		
		if($(this).val() == $('#inputPassword').val()){
			$(this).css('background-color','#02BB53');
			$('#inputPassword').css('background-color','#02BB53');
		} else {
			$(this).css('background-color','#f0932b');
			$('#inputPassword').css('background-color','#f0932b');
		}
		
	});

});


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
            <h5 class="card-title text-center">Register</h5>
            <h5 class="card-title text-center" style="font-size: 20px">계정이 있으신가요? <a href="<c:url value="/member/login" />"> 로그인</a></h6>
            <form class="form-signin" method="post" enctype="multipart/form-data">
            
              <div class="form-label-group">
                <input type="text" id="inputUserame" class="form-control" placeholder="Username" name="uName" required autofocus>
                <label for="inputUserame">Username</label>
              </div>

              <div class="form-label-group">
                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="uId" required>
                <label for="inputEmail">Email address</label>
              </div>
              
              <hr>

              <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="uPw" required>
                <label for="inputPassword">Password</label>
              </div>
              
              <div class="form-label-group">
                <input type="password" id="inputConfirmPassword" class="form-control" placeholder="Password" required>
                <label for="inputConfirmPassword">Confirm password</label>
              </div>
              
              <div class="form-label-group">
                <input type="file" id="inputFile" class="form-control" placeholder="Profile Photo" name="uPhoto">
                <label for="inputFile">Profile Photo</label>
              </div>

              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button>
              <!-- <input class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register -->
              <a class="d-block text-center mt-2 small" href="#">Sign In</a>
              <hr class="my-4">
              <button class="btn btn-lg btn-google btn-block text-uppercase" type="submit"><i class="fab fa-google mr-2"></i> Sign up with Google</button>
              <button class="btn btn-lg btn-facebook btn-block text-uppercase" type="submit"><i class="fab fa-facebook-f mr-2"></i> Sign up with Facebook</button>
            </form>
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


</body>

</html>
