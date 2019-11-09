<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>JAVA게시판</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="/static/css/bootstrap.min.css">
	<script type="/static/js/bootstrap.min.js"></script>
	<script src="/static/js/jquery-3.4.1.min.js" ></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-lighr bg-light">
		<a class="navbar-brand" href="http://localhost:8080/index.html">게시판</a>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="http://localhost:8080/loginForm.html">로그인</a></li>
				<li class="nav-item active"><a class="nav-link" href="http://localhost:8080/joinForm.html">회원가입</a></li>
			</ul>
		</div>
	</nav>

	<section class="container mt-4" style="max-width: 550px;">
			<div class="form-group">
    		   <label>아이디</label>
    		   <input id="user_id" name = "user_id" type ="text" max="30" class="form-control">
    		</div>

			<div class="form-group">
	    	  <label>비밀번호 </label>
	    	  <input id="user_pw" name = "user_pw" type="password" max="30" class="form-control">
            </div>
            
			<button id="login_btn" class="btn btn-primary">로그인</button>
	</section>
			
	<script type="text/javascript">
		$(document).ready(function() {
			$('#login_btn').click(function(){
				login();
			});
		});

		function login() {
			console.log("login 확인");
			$.ajax({
				type : "POST",
				url : "http://localhost:8080/loginAction",
				data : JSON.stringify({
					user_id:$('#user_id').val(),
					user_pw:$('#user_pw').val()
				}),
				dataType : "json",
				contentType : "application/json;",
				success : function(data, status, xhr) {
					console.log("data="+data);
					console.log("status="+status);
					console.log("xhr="+xhr);

					if(data==1){
						alert('Login Success');
						location.href = "http://localhost:8080/index.html";
					} else {
						alert('Login Fail');
					}
				},
				error : function(xhr, status, err) {
					alert('error');
				}
			});
		}
	</script>
	<script type="/static/js/popper.min.js"></script>
</body>
</html>