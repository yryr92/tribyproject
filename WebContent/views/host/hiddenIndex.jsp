<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{height:100%; overflow:auto;}
	#content{
		float:left;
		margin: 1%;
		font-family: 'Noto Sans KR', sans-serif;
		width:80%;
		height:90vh;
	}
	#div1, #div2, #div4{
		width:40%;
		height:250px;
		float:left;
		margin: 25px 25px 25px 55px;
	}
	#div3{
		width:40%;
		height:250px;
		float:left;
		margin: 25px 25px 25px 55px;
		clear:both;
	}
	#card-body1, #card-body3, #card-body4{text-align:center;}
	#card-body1 h4, #card-body1 p{
		height: 40%;
		line-height: 100px;
	}
	#inform-modify, #notice-detail{
		float:right;
		font-size:12px;
		color:gray;
	}
	#inform-modify:hover, #notice-detail:hover{cursor:pointer;}
	#notice-detail+div{font-size:18px; font-weight:bold;}
	#noticeTb{clear:both; margin-top:20px;}
	.table tr td{font-size:15px; font-weight:bold;}
	#informTb tr:nth-child(2n), #calculateTb tr:nth-child(2n){font-size:18px;}
	#informTb tr:nth-child(1), #informTb tr:nth-child(3), #calculateTb tr:nth-child(1), #calculateTb tr:nth-child(3){font-size:12px; color:gray;}
</style>
</head>
<body>
<%@ include file="aside.jsp" %>
<%
	double avgPoint = loginHost.getAvgPoint();
	double qnaAnswer = loginHost.getQnaAnswer();
	if(Double.isNaN(avgPoint)) {
    	avgPoint = 0;
	}
	if(Double.isNaN(qnaAnswer)) {
		qnaAnswer = 0;
	}
	
%>   
<div id="content">
	<div id="div1" class="card border-secondary">
  <div id="card-body1" class="card-body">
  <div id="inform-modify" onclick="myPage();">회원정보수정</div>
   <h4 class="card-title" style="clear:both;">안녕하세요! <%= loginHost.getHost_name() %> 호스트님</h4>
   <h4><p class="card-text"><%= loginHost.getHost_sName() %></p></h4>
  </div>
</div>
<div id="div2" class="card border-secondary">
<div id="card-body2" class="card-body">
   <div id="notice-detail" onclick="goNotice();">더 보기</div>
   <div>공지사항</div>
   <div id="noticeTb">
   		<table id="noticeTbt" class="table table-hover">
</table> 
   </div>
  </div>
</div>
<div id="div3" class="card border-secondary">
			<div id="card-body3" class="card-body">
				<table id="informTb" height="100%" width="100%">
					<tr>
						<td width="33%">이번 달<br>신청 트리비
						</td>
						<td width="33%">이번 달<br>호스트 취소
						</td>
						<td width="33%">전체<br>신청 완료
						</td>
					</tr>
					<tr>
						<td height="35%"><%= loginHost.getThisMtriby() %></td>
						<td>0</td>
						<td><%= loginHost.getAllTriby() %></td>
					</tr>
					<tr>
						<td>전체 후기</td>
						<td>평균 별점</td>
						<td>Q&A 응답률</td>
					</tr>
					<tr>
						<td height="35%"><%= loginHost.getReviewCount() %></td>
						<td>
						<%= String.format("%.2f", avgPoint)%>
						</td>
						<td><%= String.format("%.2f", qnaAnswer)%>%</td>
					</tr>
				</table>
			</div>
		</div>
<div id="div4" class="card border-secondary">
  <div id="card-body4" class="card-body">
	<table id="calculateTb" height="100%" width="100%">
		<tr>
			<td>이번달 매출액</td>
		</tr>
		<tr>
			<td><%= loginHost.getThisMsales() %>원</td>
		</tr>
		<tr>
			<td>전체 매출액</td>
		</tr>
		<tr>
			<td><%= loginHost.getAllsales() %>원</td>
		</tr>
		</table>
  </div>
</div>
</div>

<script>
	function myPage(){
	location.href="<%= request.getContextPath()%>/myPage.ho";
	};
	
	function goNotice(){
		location.href="<%= contextPath%>/listh.no";
	};
	
	$(function(){
		$.ajax({
			url:"mnlist.no",
			dataType:"json",
			success:function(list){
				console.log(list);
				
				var $noticeTb = $("#noticeTbt");// <table></table>
				
				$noticeTb.html("");
				
				$.each(list, function(index, value){
					var $tr = $("<tr>");	// <tr> </tr>
					var $categoryTd = $("<td>").text(value.nCategory).css({"width":"70px", "height":"20px", "font-size":"15px"}); // <td width="100px">관리자</td>
					var $titleTd = $("<td>").text(value.nTitle); // <td width="400px">안녕하세여</td>
					var $dateTd = $("<td>").text(value.nDate).css({"font-size":"12px", "text-align":"right", "color":"gray"}); // <td width="200px">19년 10월 04일</td>
					
					$tr.append($categoryTd);
					$tr.append($titleTd);
					$tr.append($dateTd);
					
					$noticeTb.append($tr);
				
				});
				
				
			},error:function(){
				console.log("통신 실패");
			}
		});
	});
	
</script>
</body>
</html>