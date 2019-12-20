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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	button:hover{cursor:pointer;}
	body{font-family: 'Noto Sans KR', sans-serif;}
</style>
<script>
	var msg = "<%=msg%>";
	$(document).ready(function() {
	if(msg != "null") {
		alert(msg);		
	}
	if(msg=="성공적으로 수정되었습니다") {
		close();
	}
	})
</script>
</head>
<body>
    <!-- open(새창크기지정) -->
    <h3 align="center">비밀번호 변경하기</h3>
    <div class="updatePw" align="center">
        <hr>
        <form action="<%=request.getContextPath() %>/updateHostPw.ad" method="post" id="editPwForm" >
            <table>
                <tr>
                    <td>현재비밀번호</td>
                    <td>
                        <input type="password" name="userPw" id="userPw" required>
                    </td>
                    <td>
                    	<button id="checkbtn">확인</button>
                    </td>
                </tr>
                <tr>
                    <td>변경할 비밀번호</td>
                    <td>
                        <input type="password" name="newPw" id="newPw" disabled required>
                    </td>
                </tr>
                <tr>
                    <td>변경할 비밀번호 확인</td>
                    <td>
                        <input type="password" name="newPw2" required id="newPw2">
                    </td>
                </tr>
            </table>
            <br>
            <div align="center">
                <button type="button" id="confirmbtn" onclick="validateHostPw();">변경하기</button>
            </div>
        </form>
    </div>
    
    <script>
    	$(document).ready(function() {
    		$("#checkbtn").click(function() {
    			var userPw = $("#userPw").val();
    			if(userPw.trim() == "") {
    				alert("현재 비밀번호를 입력해 주세요");
    				return;
    			}else {
    	    		var pw = userPw;
    	    		$.ajax({
    	    			url:"<%=request.getContextPath()%>/checkHostPwAjax.ad",
    	    			method:"post",
    	    			data:{hostPw:pw},
    	    			dataType:"text",
    	    			success:function(string) {
    	    				if(string=="identified") {
    	    					alert("새 비밀번호를 입력해 주세요");
    	    					$("#newPw").removeAttr("disabled")
    	    					$("#newPw").focus();
    	    				}else {
    	    					alert("비밀번호가 다릅니다 다시 입력해 주세요");
    	    					//from pak 10/09
    	    					$("#userPw").focus().val("");
    	    					//end pak 10/09
    	    					return;
    	    				}
    	    			},
    	    			error:function() {
    	    				console.log("error");
    	    			}
    	    		})
    			}
    			
    		})

    	})
    	function validateHostPw() {
    		var newPw = $("#newPw");
    		var newPw2 = $("#newPw2");
    		
    		if(newPw.val().trim() == "" || newPw2.val().trim() == "") {
    			alert("값이 누락되었습니다");
    			return;
    		}
    		if(newPw.val() != newPw2.val()) {
    			alert("비밀번호가 다릅니다");
    			newPw2.val("").focus();
    			return;
    		}
    		$("#editPwForm").submit();	
    	
    		
    	}

    			

    </script>

</body>
</html>