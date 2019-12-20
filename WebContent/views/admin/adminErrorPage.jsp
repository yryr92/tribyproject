<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String message = (String)request.getAttribute("msg");
%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>에러페이지</title>
<style>
	button:hover{cursor:pointer;}
</style>
</head>
<body>
	<h2 align="center"><%=message %></h2>
	<br><br>
	<div align="center" class="btns">
		<button onclick="location.href='<%=request.getContextPath() %>/adminMain.ad';">adminPage로 돌아가기</button>
	</div>
</body>
</html>