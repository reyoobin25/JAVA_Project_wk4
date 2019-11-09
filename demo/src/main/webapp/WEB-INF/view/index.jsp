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
	String user_id = (String)request.getSession().getAttribute("user_id");
	String user_pw = (String)request.getSession().getAttribute("user_pw");
		
	if(user_id == null) {
%>
	
	<nav class="navbar navbar-expand-lg navbar-lighr bg-light">
			<a class="navbar-brand" href="http://localhost:8080/index.html">게시판</a>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="http://localhost:8080/loginForm.html">로그인</a></li>
					<li class="nav-item active"><a class="nav-link" href="http://localhost:8080/joinForm.html">회원가입</a></li>
				</ul>
			</div>
	</nav>
	
	<section class="container">
	  	<jsp:include page="boardList.jsp"/>
	</section>
<%
	} else {
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
		
	<section class="container">
	  	<jsp:include page="boardList.jsp"/>
	</section>
		
<%
	}
%>	
	<script type="/static/js/popper.min.js"></script>

</body>
</html>