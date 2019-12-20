<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.triby.payment.model.vo.PaymentforHost"%>
<%
	ArrayList<PaymentforHost> list = (ArrayList<PaymentforHost>) request.getAttribute("list"); 
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="resources/js/popper.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	button {cursor:pointer;}
    body{width:600px; height:500px; font-family: 'Noto Sans KR', sans-serif; overflow-y: auto;}
	.table{background:white; font-size:15px; text-align:center;}
	.table th{height:50px}
	.btn:hover{cursor:pointer;}
</style>

</head>
<body>
	<div id="wrap">
		<table class="table table-hover">
			<tr>
			<th scope="col">신청자명</th>
    	  	<th scope="col">생년월일</th>
    	  	<th scope="col">성별</th>
      		<th scope="col">연락처</th>
      		<th scope="col">결제일</th>
			</tr>
			<% for(int i=0; i<list.size(); i++) { %>
			<tr>
			<td><%= list.get(i).getUserName() %></td>
			<td><%= list.get(i).getBirth() %></td>
			<td><%= list.get(i).getGender() %></td>
			<td><%= list.get(i).getPhone() %></td>
			<td><%= list.get(i).getpDate() %></td>
			</tr>
			<% } %>
		</table>
		<div align="center"><button type="button" class="btn btn-primary" onclick="window.close();">닫기</button></div>
	</div>
	
	
</body>
</html>