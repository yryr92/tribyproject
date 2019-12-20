<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="com.triby.member.model.vo.Member"%>
    <%

    	String findID = (String)request.getParameter("findID");
    	//String findID = (String)session.getAttribute("findID");
    %>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<head>
    <meta charset="UTF-8">
  



    <title>회원 아이디 찾기</title>

    <style>
      a{
    color: inherit;
    text-decoration: none;
    font-size: 10px;
    
}
    *{
	font-family:'Noto Sans KR';
	margin:auto;

}

#boundary{
    width: 1px;
    height: 10px;
    background-color: rgb(221, 221, 221);
    margin-left: 14px;
    margin-right: 14px;
    display: inline-block;
}
   .main{
    border:0px solid black;
    width: 400px;
    text-align: center;
    line-height: 2;
   
    }

    #find_Id{
        border: 0px solid black;
        width:30%;
        height: 10%;
        text-align: center;
        margin:auto;
        
    }
    #header{
    border: 0px solid black;
    height:40%;
    font-weight:bold;
    text-align:left;
    
    }
    
    
    
    
    </style>
    
</head>
<body>
	
	<!--<form action="<%=request.getContextPath() %>/findId.me" method="POST" id="userfid">  -->
<div id="header" class="navbar navbar-expand-lg navbar-dark bg-primary"><img src="<%=request.getContextPath()%>/resources/images/triby_logo.png" style="width:100px;"></div>
  <div class="main">
 
  <h2>아이디를 찾았습니다!!</h2>
  <h4>회원님의 아이디는 <%=findID %> 입니다.</h4>
   <a id = "findId" value="확인" class="btn btn-outline-success" onclick=window.close() href="<%=request.getContextPath() %>/loginpg.me" target=_blank style="width:20%">확인</a><br>
  </div>
  
  
    
 	<script>
 	
 		function login(){
 		location.href="<%= request.getContextPath()%>/loginpg.me"
 		}
 		function findMember(){
 			location.href ="<%= request.getContextPath()%>/views/host/FindPwd.jsp"
 		}
 	
 	</script>
    
</body>
</html>