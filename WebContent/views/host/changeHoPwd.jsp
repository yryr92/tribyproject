<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="com.triby.member.model.vo.Member"%>
    <%
   
    	//String findPwd = (String)request.getParameter("findPwd");
    	String email = (String)request.getAttribute("hostEmail");
    	
    	//String findPwd = (String)session.getAttribute("findPwd");
    //	String message = (String)request.getAttribute("msg");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<title></title>
</head>
<style>
   *{
	font-family:'Noto Sans KR';
	margin:auto;

}
table{

	text-align:left;
}

    .updatePwd{
        border: 0px solid black;
          width:40%;
        height: 10%;
        text-align: center;
        
        
    }
    #updatePwdBtn{
    
    	cursor:pointer;
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
    
    </style>
<body>

	<%@include file = "../common/header.jsp" %>
	
	

	<form id ="updatePwdForm" action="<%= request.getContextPath()%>/updatePwd.ho" method="post">
    	<input type="hidden" name="email" id="email" value=<%=email %>>
    <div class = "updatePwd">
		<h2>비밀번호 변경하기</h2><br><br>
		<table>
			<tr>
				
				<td>변경할 비밀번호</td>
				<td></td>
				<td><input type="password" class = "find" name="newPwd" id="newPwd" style="width:200px;"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td></td>
				<td><input type="password" class = "find" name="newPwd2" id="newPwd2" style="width:200px;"></td>
			</tr>
		</table>
		
		<br>
		<div id = "updatePwdBtn" onclick ="checkPwd();">변경하기</div>
	 </div> 
	</form>
        
	<%@include file = "../common/footer.jsp" %>

<script>

function checkPwd(){
	
	var newPwd = $("#newPwd");
	var newPwd2 = $("#newPwd2");
	
	
	if(newPwd.val().trim() == "" || newPwd2.val().trim() == ""){
		alert("입력하신 값이 없습니다.");
		return;
	}
	if(newPwd.val() != newPwd2.val()){
		alert("비밀번호가 다릅니다.");
		newPwd2.val("").focus();
		return;
	}
	
	$("#updatePwdForm").submit();
	
}



<%-- $(function(){
	
	var msg = "<%= message %>"; 
	
	if(msg != "null"){ // 메세지가 담겨있을 경우
		alert(msg);
	}
	
	if(msg == "성공적으로 비밀번호를 변경하였습니다."){
		location.href="<%=request.getContextPath()%>";
	}
});

	function checkPwd(){
		var newPwd = $("#newPwd");
		var newPwd2 = $("#newPwd2");
		
		if(newPwd.val().trim() == "" || newPwd2.val().trim() == ""){
			alert("값이 누락되었습니다.");
			return;
		}
		
		if(newPwd.val() != newPwd2.val()){
			alert("비밀번호가 다릅니다.");
			newPwd2.val("").focus();
			return;
		}
		
		
	} --%>


</script>
</body>
</html>