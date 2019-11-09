<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JAVA게시판</title>
<script src="/static/js/jquery-3.4.1.min.js" ></script>
</head>
<body>
	<h3>Update Form 부분</h3>
	<a href="http://localhost:8080/index.html">목록으로</a>
	<br/>
	<input type="hidden" value="${no}" id="hdnNo" />
	
	
	제목 <input type="text" id="title" name="title" placeholder="제목" value="${title}"><br /> 
	작성자 ${member_user_id}<br /> 
	내용 <textarea id = "content" rows="10" cols="50" name="content" placeholder="내용입력">${content}</textarea><br />
	<button id="update_btn" name="register_btn">수정하기</button>
	<button type="reset">다시쓰기</button>


<script type="text/javascript">
		$(document).ready(function() {
			$('#update_btn').click(function(){
				check();
			});

			getList();	
		});

		function getList() {
			var no = $("#hdnNo");
			
		}
		
		function check(){
			var fullPath = location.pathname; // /boardReadFrom/1
			var arr = fullPath.split("/");
			var no = arr[arr.length - 1];
			
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
				type : "GET",
				url : "http://localhost:8080/boardUpdateAction/"+no,
				data : JSON.stringify(data),
				dataType : "json",
				contentType : "application/json;",
				success : function(data, status, xhr) {
					if(data==1){
						alert('글 수정 성공');
						location.href="http://localhost:8080/index.html"
					} else {
						alert('글 수정 실패');
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