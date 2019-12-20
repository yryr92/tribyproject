<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호스트 회원가입</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script src ="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/additional-methods.js"> </script>
<script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/additional-methods.min.js"></script>
<style>
*{
	font-family:'Noto Sans KR';
	margin:auto;

}
        a{
            text-decoration: none;
        }
        a{
            color: blue;
        }
        select{
            font-weight: 100;
            border: 0px solid black;
        }
       label, h3{
    font-weight: bold;
    text-align:center;
    
	}
	 #emailCheck{
      	margin-top:1%;
      	margin-left:40%;
      
      }
#inputEmail{


}



#joinform{
border:0px solid black;
width: 60%;
height: 60%;
margin-left:30;

margin-top:20px;


}


       
        
 </style>
</head>

<body>
	<%@ include file ="../common/header.jsp" %>

      
</head>
<body>
    <!-- 회원가입 용 div-->
    <form action="<%= contextPath %>/signup.ho" id ="joinform" method="POST">
    
            <div class="page-header">
                <div class="col-md-6 col-md-offset-3">
                <h3>호스트 회원가입 </h3>
                </div><br><br>
            </div>
            <div class="col-sm-6 col-md-offset-3">
                <form role="form">
               		 <div class="form-group">
                        <label for="InputEmail">이메일 </label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="이메일 주소를 입력해주세요" required>
                        <div id="emailCheck"class="btn btn-outline-danger" style="cursor:pointer">중복확인</div>
                    </div>
                    <div class="form-group">
                        <label for="inputName">담당자명</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력해 주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputName">상호명</label>
                        <input type="text" class="form-control" id="Sname" name="sName" placeholder="상호명을 입력해 주세요">
                    </div>
                    
                    <div class="form-group">
                        <label for="inputPassword">비밀번호</label>
                        <input type="password" class="form-control" id="pw" name="host_pwd" placeholder="비밀번호를 입력해주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputPasswordCheck">비밀번호 확인</label>
                        <input type="password" class="form-control" id="pw2" name="host_pwd2" placeholder="비밀번호 확인을 위해 다시한번 입력 해 주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputPasswordCheck">사업자 등록 번호</label>
                        <input type="text" class="form-control" id="Rn" name="host_rn" placeholder="(-)빼고 10자리 입력해주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputMobile">휴대폰 번호</label>
                        <input type="tel" class="form-control" id="phone" name="host_phone" placeholder="(-제외)휴대폰번호를 입력해 주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputBank" >예금주</label>
                        <input type="text" class="form-control" style="width: 30%" id="accountName" name="accountName" placeholder="예금주"><br>
                        <label for="bankName">은행명</label>
                        <select class="form-control" id="exampleSelect1" id = "bName" name="bank_Name" style="width:20%">
                        <option>----</option>
                        <option>국민</option>
                        <option>신한</option>
                        <option>IBK</option>
                        <option>카카오뱅크</option>
                        </select><br>
                        <label for="account">계좌정보</label>
                        <input type="text" class="form-control" style="width: 60%" id="account" name="account" placeholder="(-)을 제외한 계좌번호"><br>

                
      <textarea class="form-control" id="exampleTextarea" rows="4"  id="intro" name="host_introduce"placeholder="호스트님 자신을 알려주세요!"></textarea>
                    
                    </div>
                    
        
                     <div class="form-group">
                    <label for="agree">약관 동의</label>
                    <input id="agree" type="checkbox" autocomplete="off" >
                    <p><a href="#">이용약관</a>,개인정보처리방침, 위치기반 서비스에 동의합니다.</p>
                    <div data-toggle="buttons">
                        <span class="fa fa-check"></span>
                      
                    </div>
                </div>

                <div class="form-group text-center" id="group">
                    <button type="submit" id = "signUp" name = "signUp"class="btn btn-outline-success" disabled>
                      	  회원가입
                    </button>

                </div>
    	</form>
    	</div>
    	
    
    
    </form>
        

   

    
    <script>
   
		$(function(){
			var emailCk = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	    	var nameCk = /^[가-힣]+$/;
	    	var pwck = /^[A-Za-z0-9]{6,12}$/;
	    	var Rnck = /^[0-9]{1,10}$/;
	    	var phoneCk = /^[0-9]{2,3}[0-9]{3,4}[0-9]{4}$/;
	    	var account = /^[0-9]{1,10} $/;


	    	$("#joinform").submit(function(){
	    		/*
	    		
	    		
	    		
	    		}else if(emailCk.test("#email")) {
	    			
	    			alert("이메일 형식에 어긋납니다.");
	    			$("#email").focus();
	    			return false;
	        			*/
	        	if($("#email").val()==""){
	    	    	alert("이메일을 입력해주세요!");
	    	    	$("#email").focus();
	    	    	return false;
	        	}else if($("#name").val()==""){
	    			alert("이름을 꼭 입력하세요!");
	    			$("#name").focus();
	    			return false;
	        	}else if(!nameCk.test($("#name").val())){
	    			alert("이름이 올바르지 않습니다.");
	    			$("#name").focus();
	    			return false;	
	    			
	    		}else if($("#Sname").val()==""){
	    			alert("상호명을 입력하세요!");
	    			$("#Sname").focus();
	    			return false;
	    		}else if($("#pw").val() ==""){
	    			alert("비밀번호 를 입력하세요!");
	    			$("#pw").focus();
	    			return false;
	    		}else if (!pwck.test($("#pw").val())){
	    			alert("특수문자를 제외한 6-12자리 비밀번호를 입력해주세요");
	    			$("#pw").focus();
	    			return false;	
	    		}else if($("#pw2").val()==""){
	    			alert("비밀번호 확인을 위해 입력해주세요!");
	    			$("pw2").focus();
	    			return false;
	    		}else if($("#pw").val()!=$("#pw2").val()){
	    			alert("비밀번호가 일치하지 않습니다!");
	    			$("#pwd").focus();
	    			return false;
	    		}else if($("#Rn").val()==""){
	    			alert("사업자 등록번호를 입력해주세요");
	    			$("#Rn").focus();
	    			return false;
	    		
	    		}else if(!Rnck.test($("#Rn").val())){
	    			alert("사업자번호는 숫자로 10자리만 입력해주세요");
	    			$("#Rn").focus();
	    			return false;
	    			
	    		}else if($("#phone").val()==""){
	    			alert("휴대폰 번호를 입력하세요");
	    			$("#phone").focus();
	    			return false;
	    
	    		}else if($("#accountName").val() == ""){
	    			alert("예금주를 입력하세요");
	    			$("#accountName").focus();
	    			return false;
	    		
	    		}else if($("#account").val()==""){
	    			alert("계좌정보를 입력하세요");
	    			$("#account").focus();
	    			return false;
	    			
	    		}else if(!account.test("#account").val()){
	    			alert("'-'을 제외한 계좌번호를 입력하세요");
	    			$("#account").focus();
	    			return false;
	    			
	    		}else if($("#intro").val()==""){
	    			alert("자기소개를 입력하세요");
	    			$("#intro").focus();
	    			return false;
	    		
	    		}else{
	    			if(confirm("호스트 가입을 하시겠습니까?")){
	    				return true;
	    			}else{
	    				return false;
	    			}
	    		}
	    });
			
		});
		
		
		$(function(){
			
			var isUsable = false;
			
			$("#emailCheck").click(function(){
				
				var email = $("#joinform input[name=email]");
				
				var eCheck = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
				
				if(!eCheck.test(email.val())){
					
					alert("이메일을 잘못 입력하였습니다.");
					email.focus().val("");
				}else{ // 유효값
					$.ajax({
						url:"emailcheck.ho",
						type:"post",
						data:{email:email.val()},
						success:function(result){
						
							
							if(result =="fail"){
								alert("사용할수 없는 이메일입니다.");
								email.focus().val("");
							}else{
								
								if(confirm("사용 가능한 이메일입니다.사용하시겠습니까?")){
									email.attr("readonly","true");
									isUsable="true";
								}else{
									userId.focus().val("");
								}
							}
							
							if(isUsable){
								$("#signUp").removeAttr("disabled");
							}
						},
						error:function(){
							console.log("서버와 통신실패");
						}
						
					});
					
						
				}
			});
			
		
		});
		
    </script>
</body>
</html>