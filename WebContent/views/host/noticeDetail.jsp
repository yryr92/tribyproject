<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.triby.notice.model.vo.Notice"%>
<% 
	Notice no = (Notice) request.getAttribute("no");
%>
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
	#searchArea{float:right;}
	.table{background:white; font-size:15px;}
	.table th{height:50px; text-align:center;}
	#noContent{height:400px; background:white;}
</style>
</head>
<body>
	<%@ include file="aside.jsp" %>
	<div id="wrap">
	<div id="title">공지사항</div>
	<div id="content" class="jumbotron">
	<div id="searchArea">
	<form><input class="form-control mr-sm-2" type="text" placeholder="공지사항 검색"></form></div>
	<br style="clear:both">
	<hr>
	<div id="article">
		<table class="table table-hover" id="notice">
  <thead>
    <tr>
      <th scope="col"><%= no.getnTitle() %></th>
    </tr>
  </thead>
  <tbody>
  	<tr>
  	<td><p id="noContent"><%= no.getnContent() %></p></td>
  	</tr>
	</tbody>
	</table>
	</div>
	</div>
	</div>
</body>
</html>