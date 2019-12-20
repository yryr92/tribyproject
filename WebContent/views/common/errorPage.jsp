<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	button:hover{cursor:pointer;}
	
</style>
</head>
<body>
<script>
	alert("<%=msg%>");
	history.back();
	location.reload();
</script>
	<!-- <h1 align="center"><%=msg %></h1>
	<div align="center">
		<button type="submit" onclick="location.href='<%=request.getContextPath() %>';">첫 페이지로</button>
	</div>-->
</body>
</html>