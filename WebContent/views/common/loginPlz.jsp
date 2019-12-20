<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TRIBY</title>
<style>
	a, a:hover{
        text-decoration: none;
    }
    a:link, a:visited, a:hover{
        color: black;
    }
    #loginGo{
    	heigth:100px;
    	width:300px;
    	border: 0px solid black;
    	border-radius:20px 20px 20px 20px;
    	color:white;
    	background:#0b8c8c;
    }
</style>
</head>
<body>
	<h1 align="center"><%=msg %></h1>
	<div align="center">
		<a id="login_a" href="<%=request.getContextPath()%>/loginpg.me">
			<div id="loginGo">
				로그인 페이지로 이동
			</div>
		</a>
	</div>
</body>
</html>