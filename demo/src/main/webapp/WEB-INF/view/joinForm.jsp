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

	<section class="container mt-4">
    	<div class="form-group">
    		<h3><center>회원가입</center></h3>
    	</div>
    	<div class="form-group">
        	<label>아이디</label> 
        	<input id="user_id" name="user_id" type="text" max="20" placeholder="아이디 입력" class="form-control">
        </div>
		<div class="form-group">	
        	<label>비밀번호</label> 
        	<input id="user_pw" name="user_pw" type="password" max="30" placeholder="비밀번호 입력" class="form-control">
    	</div>
    	<div class="form-group">	
        	<label>비밀번호 확인</label> 
        	<input id="user_pw_ck" name="user_pw_ck" type="password" max="30" placeholder="비밀번호 확인" class="form-control">
    	</div>
    	<div class="form-group">	
        	<label>핸드폰번호</label> 
        	<input id="phone" name="phone" type="text" max="30" placeholder="핸드폰 번호 ex.010-1234-1234" class="form-control">
    	</div>
    	<div class="form-group">	
        	<label>이메일</label> 
        	<input id="email" name="email" type="email" placeholder="이메일 입력" class="form-control">
    	</div>
	<button id="submit_btn" class="btn btn-primary">회원가입</button>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#submit_btn').click(function(){
				check();
			});
		});

		function check(){
			console.log("joinForm check");
			var user_id = $("#user_id").val();
			var user_pw = $('#user_pw').val();
			var user_pw_ck = $('#user_pw_ck').val();
			var phone = $('#phone').val();
			var email = $('#email').val();

			var patt = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
			var kpatt = /[ㄱ-ㅎ | ㅏ-ㅣ | 가-힣]]/;
			var spatt = /\s/g;
			
			if ((patt.test(user_id) || kpatt.test(user_id) || spatt.test(user_id))) {
				alert("아이디를 확인해주세요.(영문/숫자)");
				return;
			}

			var pwpatt = /^[a-zA-Z0-9]{8,16}$/;
			if (!(pwpatt.test(user_pw))) {
				alert("비밀번호는 영문 대소문자 숫자포함 8자리 이상 16자이하입니다.");
				return;
			}

			 //== : value, === : 타입
			if (!(user_pw === user_pw_ck)) {
				alert("비밀번호가 일치하지 않습니다.");
				$('#user_pw_ck').focus();
				return;
			}

			var phpatt = /^\d{2,3}\d{3,4}\d{4}$/;
			if (!(phpatt.test(phone))) {
				alert("전화번호를 확인해주세요.");
				return;
			}
			
			var epatt = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			if (!(epatt.test(email))) {
				alert("이메일을 확인해주세요.");
				return;
			}
			join();
		}

		function join() {
			console.log("join 확인");

			var data = {
				userId : $('#user_id').val(),
				userPw : $('#user_pw').val(),
				phone : $('#phone').val(),
				email : $('#email').val()
			};
			console.log(data);
			$.ajax({
				type : "POST",
				url : "http://localhost:8080/joinAction",
				data : JSON.stringify(data),
				dataType : "json",
				contentType : "application/json;",
				success : function(data, status, xhr) {
					console.log("data="+data);
					console.log("status="+status);
					console.log("xhr="+xhr);
					if(data==1){
						alert('Join Success!');
						location.href="http://localhost:8080/loginForm.html"
					} else {
						alert('Join Fail!');
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