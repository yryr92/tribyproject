<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#wrap{
		float:left;
		margin: 1%;
		font-family: 'Noto Sans KR', sans-serif;
		width:80%;
	}
	#title{font-size:18px; font-weight:bold; margin-bottom:1rem;}
	#content{width:100%; height:77vh; margin: 0; padding:1rem 1rem 1rem 2rem; overflow-y: auto;}
	#navArea{float:left;}
	#searchArea{float:right;}
	#noticeArea{float:right; padding-top:20px; font-size:15px; color:gray; text-align:right;}
	.table{background:white; font-size:15px; text-align:center;}
	.table th{height:50px}
	.pagination{justify-content: center;}
</style>
</head>
<body>
	<%@ include file="aside.jsp" %>
	<div id="wrap">
	<div id="title">정산 관리</div>
	<div id="content" class="jumbotron">
	<div id="top">
	<div id="navArea">
		<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" data-toggle="tab" href="#home" id="prevcal" onclick="selectCalList(0);">정산 대기</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#profile" id="finishcal" onclick="selectCalList(1);">정산 완료</a>
  </li>
</ul>
</div><div id="noticeArea">※정산은 매달 16일에 진행되며, 전날 오전까지 완료된 트리비에 한해서만 입금처리 됩니다.<br>
		최근 1개월 내역에 한해서만 보여지며, 이전 정산 내역이 궁금하신 분은 고객센터로 문의하세요.
</div>
	</div>
	<br style="clear:both">
	<hr>
	<div id="article">
		<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">진행일</th>
      <th scope="col">트리비명</th>
      <th scope="col">참가인원</th>
      <th scope="col">매출</th>
      <th scope="col">수수료</th>
      <th scope="col">최종 정산금액</th>
      <th scope="col">정산여부</th>
    </tr>
  </thead>
  <tbody id="tbody">
  </tbody>
</table> 
<div id="pageArea"></div>
	</div>
	</div>
	</div>
	
	<script>
		$(function(){
			selectCalList(0);
			
		});
		
		var hNo = <%= loginHost.getHost_no() %>
		
		function selectCalList(status){
			
			$.ajax({
				url:"calList.ho",
				type:"post",
				dataType:"json",
				data:{hNo:hNo, status:status},
				success:function(list){
					console.log(list);
					
					var $tbody = $("#tbody");// <table></table>
					
					$tbody.html("");
					
					$.each(list, function(index, value){
						var $tr = $("<tr>");
						var $dateTd = $("<td>").text(value.tday);
						var $tribyTd = $("<td>").text(value.tTitle);
						var $attendTd = $("<td>").text(value.tAttend);
						var $priceTd = $("<td>").text(value.cal_sum);
						var $chargeTd = $("<td>").text("5%");
						var $finalTd = $("<td>").text(value.cal_sum*0.95);
						
						if(value.cal_status == 'N') {
							var $statusTd = $("<td>").text("정산대기");
						} else {
							$statusTd = $("<td>").text("정산완료");
						}
						
						$tr.append($dateTd);
						$tr.append($tribyTd);
						$tr.append($attendTd);
						$tr.append($priceTd);
						$tr.append($chargeTd);
						$tr.append($finalTd);
						$tr.append($statusTd);
						
						$tbody.append($tr);
						
					});
					
					
				},error:function(){
					console.log("통신 실패");
				}
			});
			
			paging(status);
		}
		
		/* function paging(status){
			var listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage;
			currentPage=1;
			
			var $pageArea = $("#pageArea");
			
			$pageArea.html("");
			
			$.ajax({
				url:"counth.ca",
				data:{hNo:hNo, status:status},
				success : function(data) {
					//console.log(data);
					listCount = data;
					pageLimit = 5;  // 버튼 개수 직접지정
					boardLimit = 10; // 페이지당 객체 개수 직접지정
					maxPage = Math.ceil(listCount / boardLimit);
					startPage = (Math.floor((currentPage - 1) / pageLimit))* pageLimit + 1;
					endPage = startPage + pageLimit - 1;

					if (endPage > maxPage) {
						endPage = maxPage;
					};
					
					var $leftbtn = $("<div class='leftbtn'>");
					var $ltlt = $("<button>").text("<<");
					var $lt = $("<button>").text("<");
					$leftbtn.append($ltlt).append($lt);
					$pageArea.append($leftbtn);
					var $rightbtn = $("<div class='rightbtn'>");
					var $gt = $("<button>").text(">");
					var $gtgt = $("<button>").text(">>");
					$rightbtn.append($gt).append($gtgt);
					for (var i = startPage; i <= endPage; i++) {
						if (i == currentPage) {
							var btn = $("<button class='tagactive'>").text(i);
						} else {
							var btn = $("<button>").text(i);
						}
						$pageArea.append(btn);
					}
					$pageArea.append($rightbtn);
					
				}, error : function() {
					console.log("listCount 통신오류");
				}
			});
			
		} */
		
		
	</script>
	
</body>
</html>