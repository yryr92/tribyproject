<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.triby.member.model.vo.Member"%>
<!DOCTYPE html>
<%




%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
   <script>
   
   
   
   </script>
   

  

</head>

<style>
*{
	font-family:'Noto Sans KR';
	margin:auto;
	font-color:black;

}

a{
text-decoration: none;
color:#646464;

}
.text{
    color: inherit;
    text-decoration: none;
    font-size: 10px
}
h3{
    font-weight: bold;
    text-align: center;
}

.main1{
    border:0px solid black;
    width: 25%;
    margin:auto;
    text-align: center;
    line-height: 4;
    
}
.main2{
 border:0px solid black;
    width: 25%;
    margin:auto;
    text-align: center;
    line-height: 4;
}


#boundary{
    width: 1px;
    height: 10px;
    background-color: rgb(221, 221, 221);
    margin-left: 14px;
    margin-right: 14px;
    display: inline-block;
}
.How{
    display: inline;
    font-weight: bold;
    cursor:pointer;
    
    
}
.login{
    width: 50%;
    height: 50%;
    background-color: transparent;
    font-size: 12px;
    padding: 14px 0px;
    outline: none;
    border-style: none;
    touch-action: manipulation;
    border-bottom: 1px solid rgb(238, 238, 238);
    transition: border 0.2s ease 0s;
    
}




.login:focus{
    border-bottom: 1px solid rgb(112, 186, 100);
    transition: border 0.2s ease 0s;
}
</style>
<body>
<%@ include file ="../common/header.jsp" %>

	<div class = "main1">
 <form action="<%=request.getContextPath()%>/login.me" method="POST" id="userLog" name ="loginUser">
      <!-- 어떤 로그인을 할것인지?-->
           <div class ="How" id = "userLogin">일반 로그인</div>
           <span id = "boundary"></span>
           <div class ="How" id = "hostLogin">호스트 로그인</div>
            <!--유저 로그인-->
            <div id = "Ulogin">
                <h3>안녕하세요 회원님!</h3>

                <input type="email" class= "login" name = "user_email" id = "user_email" placeholder="이메일을 입력하세요">
                <input type="password" class ="login" name = "user_pw" id = "user_pw" placeholder="비밀번호를 입력하세요">
                <input type="submit" value="로그인" class="btn btn-outline-success"  style="width:50%"><br>                
                
                <a href="#" class= "text" onclick="findID();">아이디찾기</a>
                <span id = "boundary"></span>
                <a href="#" class = "text" onclick="findPwd();">비밀번호 찾기</a>
                <span id = "boundary"></span>
                <a href="#" class ="text" onclick="signUpMember();">회원가입</a><br>
             
            </div>
            
		</form>
		</div>
		
		<div class= "main2">
        <form action="<%=request.getContextPath()%>/login.ho" method="POST" id="hostLog" >
            <div id = Hlogin style="display:none">

                    <h3>안녕하세요 호스트님!</h3>
                
                    <input type="email" class = "login" name ="email" id = "host_email" placeholder="이메일을 입력하세요" value="host01@kh.com">
                    <input type="password" class ="login" name = "pw"  id = "host_pw" placeholder="비밀번호를 입력하세요" value="pass01">
                    <input type="submit" value="로그인" class="btn btn-outline-success" style="width:50%"><br>
                    <a href="#" class= "text"  onclick ="findHostId();">아이디 찾기</a>
                    <span id = "boundary"></span>
                    <a href="#" class= "text" onclick="findHostPwd();">비밀번호 찾기</a>
                    <span id = "boundary"></span>
                    <a href="#" class= "text" onclick="signUpHost();">호스트 가입</a>
                    
                </div>
                
 
        </form>
    </div>
    <script>
    
    $(function(){
         $("#userLogin").on("click",function(){
                $("#Ulogin").show(1);
                    $("#Hlogin").hide(1);
                });
                $("#hostLogin").on("click",function(){
                    $("#Hlogin").show(1);
                    $("#Ulogin").hide(1);
                });


            });
    
    function signUpMember(){
		location.href="<%= contextPath %>/form.me";
	}
	function signUpHost(){
		location.href="<%= contextPath%>/adminSignup.ho";
	}
	
	function findID(){
		location.href="<%= contextPath%>/findIDview.me";
	}
	
	function findPwd(){
		location.href="<%=contextPath%>/findPwdview.me";
	}
	
	function findHostId(){
		location.href="<%= contextPath%>/findidhost.ho";
	}
	
	function findHostPwd(){
		location.href = "<%= contextPath%>/findpwdhost.ho";
	}
    
    

	</script>
	
    <%@ include file ="../common/footer.jsp" %>
</body>
</html>