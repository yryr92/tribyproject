<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.triby.host.model.vo.Host"%>
<% 
	Host loginHost = (Host) session.getAttribute("loginHost");
	String joinSuccessMsg = (String)request.getAttribute("joinSuccessMsg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="resources/js/popper.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<script>
	var joinSuccessMsg = "<%=joinSuccessMsg%>"
$(function(){
	if(joinSuccessMsg!="null"){
	alert(joinSuccessMsg);
	
	}
	
	})


</script>
<style>
	html, body{height:100%; overflow:hidden;}
	#wrapper{
    height: 10%;
    overflow:hidden;
    font-family: 'Noto Sans KR', sans-serif;
	} 
	#logo-wrap{
		width:15%;
	}
	#logo{
		margin-left: auto;
		margin-right:auto;
		width:150px;
		height:60px;
		color:white;
		text-align:center;
	}
	label{
		margin-left:1%;
		color:white;
		width:50%;
		line-height: 50px;
		margin-top: auto;
		margin-bottom: auto;
	}
	#lb2{
		width:27%;
		color:white;
		text-align:right;
		line-height: 50px;
		margin-right:1%;
	}
	#logout{
		margin-left:2%;
	}
	#logo:hover{cursor:pointer;}
</style>
<title>관리자 페이지</title>
</head>
<body>
<div id="wrapper">
<div id="header" class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div id="logo-wrap"><div id="logo" onclick="goIndex();"><img src="resources/images/triby5.png"></div></div>
  <label>호스트 관리페이지</label>
   <div id="lb2"><%= loginHost.getHost_name() %> 호스트님 반갑습니다!</div>
  <div id="logout"><a href="<%= request.getContextPath()%>/logout.ho;"><img src="resources/images/host/common/logout.png"></a></div>
</div>
</div>
<script>
	function goIndex(){
	location.href="<%= request.getContextPath()%>/goIndex.ho";
	}
</script>

</body>
</html>