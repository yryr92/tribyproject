<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.triby.member.model.vo.Member" %>
<%

	Member admin = (Member)session.getAttribute("admin");
	
	String msg = (String)session.getAttribute("adminMessage");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <title>관리자 페이지</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 <script>
 	$(document).ready(function() {
 	var msg = "<%=msg%>";
 	if(msg != "null") {
 		alert(msg);
 		<% session.removeAttribute("adminMessage");%>
 	}
 		
 	})
 </script>
    <style>
        div{
            box-sizing:border-box;
        }
        body{
            margin:0;
        }
        .outer{
            width:1920px;
            height:969px;
            font-family: 'Noto Sans KR', sans-serif;
        }
        .header{
        	width:1920px;
            height:10%;
            background: #1ca9ae;
        }
        .header:hover{cursor:pointer;}
        .body{
            display:flex;
            height:90%;
        }
        .sidemenu{
            width:260px;
            height:100%;
            background:lightgray;
        }
        .contentWrap{
            width:1660px;
            background: white;
        }
        .menu{
            height:50px;
            background:lightgray;
            border:1px solid black;
            font-size:18px;
            list-style:none;
            padding:12px 10px;
        }
        .menu a{
            display:block;
            text-decoration: none;
            box-sizing:border-box;
            width:278px;
            height:90%;

        }
        .menu a:visited{
            color:#024959;
        }
        .menu a:link{
            color:#024959;
        }
        .logo{
            margin:0;
            padding:24px;
        }
        .aTitle{
            padding:20px;
            margin:0;
        }
        button{
            background-color:white;
/*             display:block; */
        }
        .tagWrap{
            display:flex;
        }
        .btn{
            width:80px;
            height:60px;
            text-align:center;
            padding-top:20px;
        }
        .tagWrap button{
            margin-left:20px;
            border-radius:4px;
        }
        .notice table{
            border:1px solid black;
            text-align: center;
            margin-left:auto;
            margin-right:auto;
        }
        .notice{
            background-color:white;
            width:1500px;
            margin-left:auto;
            margin-right:auto;
            margin-top:30px;
            padding-bottom:30px;
        }
        .write{
            margin-left:880px;
        }
        .notice table tr th button{
            margin-left:auto;
            margin-right:auto;
        }
        .btn:hover {cursor:pointer;}
        
    </style>
</head>
<body>
 
        <div class="header">
        	<div onclick="location.href='<%=request.getContextPath()%>/adminMain.ad';">
	            <img src="<%=request.getContextPath() %>/resources/images/triby_logo.png" class="logo">
        	</div>
        </div>

</body>
</html>