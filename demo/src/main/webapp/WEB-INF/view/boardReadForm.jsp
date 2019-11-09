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
	<% } else { %>
	<nav class="navbar navbar-expand-lg navbar-lighr bg-light">
		<a class="navbar-brand" href="http://localhost:8080/index.html">게시판</a>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="http://localhost:8080/loginForm.html">로그인</a></li>
				<li class="nav-item active"><a class="nav-link" href="http://localhost:8080/joinAction">회원가입</a></li>
			</ul>
		</div>
	</nav>
	<% } %>
<section class="container mt-4" style="max-width: 900px;">
	<h3><center>등록된 글</center></h3>
	<br/><br/>
	<div id="divList"></div>
	
	<div style='display: inline;'>
		<a href = "http://localhost:8080/index.html">목록</a>
		
		<div id="btnlist">
			<button id="update_btn" class="btn btn-primary">수정</button>
			<button id="delete_btn"  class="btn btn-primary">삭제</button>
		</div>
	</div>
	
	<br />
	<br />
	<h3>댓글</h3>
		<input type="text" max="300" name="content" id="txtCommentContent" placeholder="댓글입력" class="form-control"><br/>
		<input type="button" id="comment_register" value="등록" class="btn btn-primary">
		<div id="divCommentList"></div>
</section>
</body>
	
	<script type="text/javascript">
		var fullPath = location.pathname; // /boardReadFrom/1
		var arr = fullPath.split("/");
		var no = arr[arr.length - 1]; // 1
	
		$(document).ready(function() {
			boardRead();
			commentList();
			
			$('#comment_register').click(function(){
				comment_write();
			});

			$('#update_btn').click(function() {
				location.href = "http://localhost:8080/boardUpdateForm/" + no;
			});
			$('#delete_btn').click(function() {
				boardDelete();
			});
		});

		function commentDelete(no){
			$.ajax({
				type : "GET",
				url : "http://localhost:8080/commentDeleteAction/"+no,
				dataType : "json",
				contentType : "application/json; charset=utf-8",
				success : function(data, xhr, settings) {
					if(data==1){
						location.reload();	
					}
				},
				error : function(){
					alert("error");
				}
			});
		}
		
		function commentList() {
			var user_id = "<%=(String)session.getAttribute("user_id")%>"
			var fullPath = location.pathname; 
			var arr = fullPath.split("/");
			var no = arr[arr.length - 1]; // 1
			$.ajax({
				type: "GET",
				url: "http://localhost:8080/commentListAll/"+no,
			    dataType: "json",
			    contentType: "application/json; charset=utf-8",
				success: function(data, xhr, settings) {
					var info = "<table class=\"table table-bordered\">";
					$.each(data, function(index, item) {
						if(null != item) {
							
							info += "<tr><td>" + (index+1) +"</td><td>" + item['comment_user_id']+"</td><td>" +item['comment_write_date']+"</td><td>"+item['content'] 
							if(user_id == item['comment_user_id']){
								info += "<a href='javascript:void(0);' onclick = 'commentDelete("+item['no']+")'>삭제</a>"
							}
							+"</td></tr>";
						} else {
							info = "no content";
						}
					});
					info += "</table>";
					$("#divCommentList").html(info);
				}
			});
		}
			
		function boardRead() {

			var user_id = "<%=(String)session.getAttribute("user_id")%>"
			
			console.log("no:" + no);
	
			$.ajax({
				type : "GET",
				url : "http://localhost:8080/boardReadAction/" + no,
				dataType : "json",
				contentType : "application/json; charset=utf-8",
				success : function(data, xhr, settings) {
					console.log(data);
					var info = "<table class=\"table table-bordered\" border=1>"
									+"<tr>"
										+"<td width='150' align='center'> 번호 </td>"
										+"<td>" + data["no"] + "</td>"
										+"<td width='150' align='center'> 제목 </td>"
										+"<td>" + data["title"] + "</td>"
									+"</tr><tr>"
										+"<td width='150' align='center'> 등록날짜 </td>"
										+"<td>" + data["write_date"] + "</td>"
										+"<td width='150' align='center'> 조회수 </td>"
										+"<td>" + data["view"] + "</td>"
									+"</tr><tr>"
										+"<td width='150' align='center'> 작성자 </td>"
										+"<td colspan=\"3\">" + data["member_user_id"] +"</td>"
									+"</tr><tr>"
										+"<td width='150' align='center'> 내용 </td>"
										+"<td colspan=\"3\">" + data["content"] +"</td>"
										+"</tr></table>";
					info += "<input type=\"hidden\" id=\"hdnUserId\" value=\"" + data["member_user_id"] + "\" />"
				$("#divList").html(info);
					if(user_id != data['member_user_id']){
							$("#btnlist").css("display","none");
						}
				},error :function(){
					alert("Error!"); history.back();
				}
			});
		}
	
		function comment_write() {

			var user_id = "<%=(String)session.getAttribute("user_id")%>"
			
			console.log("no:" + no);
			var param = {
				"comment_board_no": no,
				"comment_user_id":user_id,
				"content": $("#txtCommentContent").val()
			};
			$.ajax({
				type : "GET",
				url : "http://localhost:8080/commentWriteAction",
				data: param,
				dataType : "json",
				contentType : "application/json; charset=utf-8",
				success : function(data, xhr, settings) {
					
				}
			});
		}

			function boardDelete() {
				console.log("no:" + no);
	
				$.ajax({
					type : "GET",
					url : "http://localhost:8080/boardDeleteAction/" + no,
					dataType : "json",
					contentType : "application/json; charset=utf-8",
					success : function(data, xhr, settings) {
						console.log("data###=="+data);
						console.log(xhr);
						if(data == 1){
							alert('글삭제 성공');
							location.href="http://localhost:8080/index.html"
						}else{
							alert('글삭제 실패');
						}
					}
				});
			}
	</script>	
	<script type="/static/js/popper.min.js"></script>
</body>
</html>