<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
   
    %>
    
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
	#inform-modify:hover, #notice-detail:hover, #noticeTb tr:hover{cursor:pointer;}
	#notice-detail+div{font-size:18px; font-weight:bold;}
	#noticeTb{clear:both; margin-top:20px;}
	.table tr td{font-size:15px; font-weight:bold;}
	#informTb tr:nth-child(2n), #calculateTb tr:nth-child(2n){font-size:18px;}
	#informTb tr:nth-child(1), #informTb tr:nth-child(3), #calculateTb tr:nth-child(1), #calculateTb tr:nth-child(3){font-size:12px; color:gray;}
</style>
</head>
<script>

<%--var success = "<%=successPwd %>";
$(function(){
	if(success != "null"){
		alert(success);
	}
})--%>

</script>



<body>
<%@ include file="../host/aside.jsp" %>
<div id="content">
	<div id="div1" class="card border-secondary">
  <div id="card-body1" class="card-body">
  <div id="inform-modify" onclick="myPage();">회원정보수정</div>
   <h4 class="card-title" style="clear:both;">안녕하세요! <%= loginHost.getHost_name() %> 호스트님</h4>
    <p class="card-text"><%= loginHost.getHost_sName() %></p>
  </div>
</div>
<div id="div2" class="card border-secondary">
<div id="card-body2" class="card-body">
   <div id="notice-detail" onclick="goNotice();">더 보기</div>
   <div>공지사항</div>
   <div id="noticeTb">
   		<table class="table table-hover">
    <tr>
      <td style="height:20px; width:70px;">분류</td>
      <td>제목</td>
      <td style="font-size:12px; color:gray; text-align:right;">날짜</td>
    </tr>
    <tr>
      <td style="height:20px;">분류</td>
      <td>제목</td>
      <td style="font-size:12px; color:gray; text-align:right;">날짜</td>
    </tr>
    <tr>
      <td style="height:20px;">분류</td>
      <td>제목</td>
      <td style="font-size:12px; color:gray; text-align:right;">날짜</td>
    </tr> 
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
						<td height="35%">17</td>
						<td>0</td>
						<td>92</td>
					</tr>
					<tr>
						<td>전체 후기</td>
						<td>평균 별점</td>
						<td>Q&A 응답률</td>
					</tr>
					<tr>
						<td height="35%">53</td>
						<td>4.26</td>
						<td>91.8%</td>
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
			<td>1,217,000원</td>
		</tr>
		<tr>
			<td>전체 매출액</td>
		</tr>
		<tr>
			<td>3,688,000원</td>
		</tr>
		</table>
  </div>
</div>
</div>

<script>
	function myPage(){
	location.href="<%= request.getContextPath()%>/myPage.ho";
	}
	
	function goNotice(){
		location.href="<%= contextPath%>/listh.no";
	}
</script>

</body>
</html>