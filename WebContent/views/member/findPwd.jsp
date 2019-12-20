<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
   <%
	String failPwd = (String)request.getAttribute("failPwd");
   %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호변경</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script>
	var failPwd = "<%= failPwd %>";
	
	$(function(){
	
		if(failPwd == "입력하신 정보가 다릅니다."){
			console.log(failPwd);
			alert(failPwd);
		}

	});
</script>
</head>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<style>
*{
	font-family:'Noto Sans KR';
	margin:auto;

}

h3{
    font-weight: bold;
    text-align: center;
}

.main{
    border:0px solid black;
    width: 35%;
    
    margin:auto;
    text-align: center;
    line-height: 4;
    margin-top:5%;
    
    
}


#boundary{
    width: 1px;
    height: 10px;
    background-color: rgb(221, 221, 221);
    margin-left: 14px;
    margin-right: 14px;
    display: inline-block;
}
.login{
    display: inline;
    font-weight: bold;
    font-size: 16px;
    
    
}
.find{
    width: 50%;
    height: 50%;
    background-color: transparent;
    line-height: 12px;
    font-size: 12px;
    padding: 14px 0px;
    outline: none;
    border-style: none;
    touch-action: manipulation;
    border-bottom: 1px solid rgb(238, 238, 238);
    transition: border 0.2s ease 0s;
    
}

.find:focus{
    border-bottom: 1px solid rgb(112, 186, 100);
    transition: border 0.2s ease 0s;
}
.text{
    color: inherit;
    text-decoration: none;
    font-size: 10px
}

#emailinput{
	font-size:10px;

}
</style>
<body>
	<%@ include file = "../common/header.jsp" %>

  <form action="<%=contextPath %>/findPwd.me" method="POST" id="userfid">
           
			 <div class = "main" >
                    <h3>비밀번호 찾기</h3>
                    
                    <input type="email" class="find" name = "email" id = "email"placeholder="이메일을 입력하세요">
                    <input type="text" class="find" name = "name" id = "name" placeholder="이름을 입력하세요">
                    <input type="text" class="find" name = "phone" id = "phone" placeholder="(-)제외 핸드폰번호르 입력하세요">
                    <input type="submit" id = "findPwd" value="찾기" class="btn btn-outline-success" style="width:50%"><br>
                      <a href="#" class= "text"  onclick="findId();">아이디를 모르시겠다면?</a>
                </div>
				</form>
     



</body>

<script>


function findId(){
	
	location.href = "<%=request.getContextPath()%>/findIDview.me";
}


</script>

</html>
