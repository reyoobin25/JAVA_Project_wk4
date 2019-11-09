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
	<%
		String user_id = (String) request.getSession().getAttribute("user_id");

		if (user_id != null) {
	%>
	
	<nav class="navbar navbar-expand-lg navbar-lighr bg-light">
			<a class="navbar-brand" href="http://localhost:8080/index.html">게시판</a>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"><%=user_id%>님</a></li>
					<li class="nav-item active"><a class="nav-link" href="http://localhost:8080/boardWriteForm.html">글작성</a></li>
					<li class="nav-item active"><a class="nav-link" href="http://localhost:8080/logoutAction">로그아웃</a></li>
				</ul>
			</div>
	</nav>

	<section class="container mt-4" style="max-width: 550px;">
		<a href="http://localhost:8080/index.html">목록으로</a>

		<div class="form-group">
			<label>제목</label> 
			<input id="title" name="title" type="text" max="45" placeholder="제목입력" class="form-control">
		</div>
		
		<div class="form-group">
			<label>작성자</label> 
			<%=user_id%>
    	</div>
    		
		<div class="form-group">
			<label>내용</label>
			<textarea id = "content" rows="10" cols="50" name="content" placeholder="내용입력" class="form-control"></textarea>
		</div>
	
		<button id="register_btn" name="register_btn" class="btn btn-primary">등록하기</button>
		<button type="reset" class="btn btn-primary">다시쓰기</button>
		
		<%
			} else {
		%>
		<script> alert("권한이 없습니다."); history.back(); </script>
		<%
			}
		%>
	</section>
<script type="text/javascript">
		$(document).ready(function() {
			$('#register_btn').click(function(){
				check();
			});
		});

		function check(){
			console.log("register check");
			var title = $('#title').val();
			var content = $('#content').val();

			if(title == "" || content == ""){
				alert("제목과 내용을 입력해주세요.");
				return;
			}
			if(title.length > 21){
				alert("제목은 20자 이하로 적어주세요.");
				$('#title').focus();
				return;
			}
			register();
		}

		function register() {
			var data = {
				title : $('#title').val(),
				content : $('#content').val(),
			};
			
			console.log(data);
			$.ajax({
				type : "POST",
				url : "http://localhost:8080/boardWriteAction",
				data : JSON.stringify(data),
				dataType : "json",
				contentType : "application/json;",
				success : function(data, status, xhr) {
					if(data==1){
						alert('글 등록 성공');
						location.href="http://localhost:8080/index.html"
					} else {
						alert('글 등록 실패');
					}
				},
				error : function(xhr, status, err) {
					alert('error');
				}
			});
		}
	</script>
</body>
</html>