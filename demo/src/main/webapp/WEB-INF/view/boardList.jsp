<!DOCTYPE html>
<html>
<head>
<title>JAVA게시판</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="/static/css/bootstrap.min.css">
<script type="/static/js/bootstrap.min.js"></script>
<script src="/static/js/jquery-3.4.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

	<section class="container mt-4" style="max-width: 900px;">
		<h3 align=center>게시글</h3><br/><br/>
				<div id="divList"></div>
				<div id="blockList"></div>
				<script type="text/javascript">
				$(document).ready(function() {
					boardList(0);
					makeBlock();
				});
				
				function boardList(page) {
					$.ajax({
					type: "GET",
					url: "http://localhost:8080/boardList/"+page,
				    dataType: "json",
				    contentType: "application/json; charset=utf-8",
					success: function(data, xhr, settings) {
						var info = "<table class='table table-bordered'>"
									+"<thead align='center'>"
									+"<tr>"
										+"<td width='150' align='center'><strong>번호</strong></td>"
										+"<td width='500' align='center'><strong>제목</strong></td>"
										+"<td width='100' align='center'><strong>작성자</strong></td>"
										+"<td width='200' align='center'><strong>날짜</strong></td>"
										+"<th style='width: 80px; text-align: center;'><strong>조회수</strong>"
									+"</tr>"
									+"</thead>"
									+"<tbody>"; //<table>
						console.log(xhr);
						$.each(data, function(index, item) {
							if(null != item) {
								info +="<tr><td width='50' align='center'>" + item['no'] 
								       + "</td><td width='400' align='center'> <a href='http://localhost:8080/boardReadForm/"
								       + item['no'] +"'>" +item['title'] + "</a></td><td width='100' align='center'>"
								       +item['member_user_id'] + "</td><td width='200' align='center'>"
								       +item['write_date']+ "</td><td width='50' align='center'>"
								       +item['view'] + "</td></tr>";
								info += "</tbody>";
							} else {
								info = "no content";
							}
						});
						// $("#listTable tr:last").after(info);
						//info += "</table>";
						$("#divList").html(info);
					}
				});
			   }

				   function makeBlock(){
					   var boardPage = 10; //페이지당 보여주는 게시글 수
					   var boardBlock = 10; //페이지 목록의 개수
					   
					   $.ajax({
							type : "GET",
							url : "http://localhost:8080/selectBoardCnt",
							dataType : "json",
							contentType : "application/json; charset=utf-8",
							success : function(data, xhr, settings) {
								var totalPage = data/boardPage;
								var remainBoard = data%boardPage;
								var info="<center>";
								for(var i = 0; i<totalPage; i++){
										info += "<a href = 'javascript:void(0);' onclick = 'boardList("+i+")'>["+i+"]</a>";
								}
								info += "</center>";
								$("#blockList").html(info);
							}
						});
					}
			
			</script>
	</section>
	<script type="/static/js/popper.min.js"></script>
</body>
</html>

