<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<script type="text/javascript" src=https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js></script>
<script type="text/javascript" src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script type="text/javascript" src ="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/additional-methods.js"> </script>
<script type="text/javascript" src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/additional-methods.min.js"></script>

<title>회원가입</title>
</head>
<body>
 <style>
h3{

    font-weight: bold;

}

hr{

	
}

*{
	font-family:'Noto Sans KR';
	margin:auto;

}

#signup{

	text-align:center;
}


#joinform{
border:0px solid black;
width: 60%;
height: 100%;
margin-left:30;

margin-top:20px;



}
button{
    touch-action: manipulation;
}




.search-option-container { list-style: none; padding: 0; text-align: center;}
      .search-option-container li { display: inline-block; }
      .search-option-container label { cursor: pointer; }
      .search-option-container input[type=checkbox] { display: none; }
      .search-option-container div {
         height: 40px;
         width: 100px;
         border: 1px solid rgb(11, 140, 140);
         color: rgb(11, 140, 140);
         border-radius: 10px;
         font-size: 15px;
         line-height: 40px;
        

         cursor: pointer;
      }
      
      #interesting{
      
      position:abtolute;
      left:60%;
      
      
      }
      
      .gender{
      
    display: inline-block;
      margin-left:115px;
      
   
      }
      
      #emailCheck{
      	margin-top:1%;
      	margin-left:40%;
      
      }
    </style>

</head>
<body>

	<%@ include file ="../common/header.jsp" %>
	
   <body>
    <!-- 회원가입 용 div--><br>
    <form action="<%= contextPath %>/signup.me"  class ="form" id="joinform" method="POST" onsubmit="return joinValidate();" >
        <article class="container">
            <div class="page-header">
                <div class="col-md-6 col-md-offset-3">
                    <h3 id = "signup">회원가입 </h3><br>
                </div>
            </div>
            <div class="col-sm-6 col-md-offset-3">
                <form role="form">
                <div class="form-group">
                        <label for="InputEmail">이메일 </label><br>
                        <input type="email" class="form-control" id="email" name="email"  placeholder="이메일 주소를 입력해주세요">
                    	<div id ="emailCheck" class="btn btn-outline-danger" style="cursor:pointer" >중복확인</div>
                    </div>
                    <div class="form-group">
                        <label for="inputName">성명</label><br>
                        <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력해 주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputName">성별</label><br>
                        <div id = "male" class="gender"> <input type="radio"  id = "man" name = "gender" value="남자">남자</div>
                        <div id = "female" class="gender"><input type="radio" id ="woman" name = "gender" value="여자">여자</div>
                    </div>
                    
                    <div class="form-group">
                        <label for="inputPassword">비밀번호</label><br>
                        <input type="password" class="form-control" id="pw"  name="pw"  placeholder="비밀번호를 입력해주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputPasswordCheck">비밀번호 확인</label><br>
                        <input type="password" class="form-control" id="pw2"  name="pw2" placeholder="비밀번호 확인">
                    </div>
                    
                    <div class="form-group">
                        <label for="inputMobile">휴대폰 번호</label><br>
                        <input type="tel" class="form-control" id="phone" name="phone"  placeholder="(-제외)휴대폰번호를 입력해 주세요">
                    </div>
                   
                    <div id ="interesting">
                        <label>관심분야</label>
                        <div>
                            <div class="search-option-outer">
                                <ul class="search-option-container"><br>
                                    <p>액티비티
                                    <li>
                                        <input type="checkbox" name="category" id="search-option-1" value="아웃도어">
                                        <div>
                                            <label for="search-option-1">아웃도어</label>
                                        </div>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="category" id="search-option-2" value="워터파크">
                                        <div>
                                            <label for="search-option-2">워터파크</label>
                                        </div>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="category" id="search-option-3" value="수상레저">
                                        <div>
                                            <label for="search-option-3">수상레저</label>
                                        </div>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="category" id="search-option-4" value="투어">
                                        <div>
                                            <label for="search-option-4">투어</label>
                                        </div>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="category" id="search-option-5" value="축제">
                                        <div>
                                            <label for="search-option-5">축제</label>
                                        </div>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="category" id="search-option-6" value="공연">
                                        <div>
                                            <label for="search-option-6">공연</label>
                                        </div>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="category" id="search-option-7" value="전시">
                                        <div>
                                            <label for="search-option-7">전시</label>
                                        </div>
                                    </li>
                                     <li>
                                        <input type="checkbox" name="category" id="search-option-8" value="실내체험">
                                        <div>
                                            <label for="search-option-8">실내체험</label>
                                        </div>
                                    </li>
                                    </p>
                                    <p>배움
                                    <li>
                                        
                                        <input type="checkbox" name="category" id="search-option-9" value="스포츠">
                                        <div>
                                            <label for="search-option-9">스포츠</label>
                                        </div>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="category" id="search-option-10" value="음악">
                                        <div>
                                            <label for="search-option-10">음악</label>
                                        </div>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="category" id="search-option-11" value="미술">
                                        <div>
                                            <label for="search-option-11">미술</label>
                                        </div>
                                    </li>
                                    <li>
                                    
                                        <input type="checkbox" name="category" id="search-option-12" value="공예">
                                        <div>
                                            <label for="search-option-12">공예</label>
                                        </div>
                                    </li>
                                     <li>
                                        <input type="checkbox" name="category" id="search-option-13" value="요리">
                                        <div>
                                            <label for="search-option-13">요리</label>
                                        </div>
                                    </li>
                                     <li>
                                        <input type="checkbox" name="category" id="search-option-14" value="음료">
                                        <div>
                                            <label for="search-option-14">음료</label>
                                        </div>
                                    </li>
                                     <li>
                                        <input type="checkbox" name="category" id="search-option-15" value="영상">
                                        <div>
                                            <label for="search-option-15">영상</label>
                                        </div>
                                    </li>
                                     <li>
                                        <input type="checkbox" name="category" id="search-option-16" value="사진">
                                        <div>
                                            <label for="search-option-16">사진</label>
                                        </div>
                                    </li>
                                     <li>
                                        <input type="checkbox" name="category" id="search-option-17" value="외국어">
                                        <div>
                                            <label for="search-option-17">외국어</label>
                                        </div>
                                    </li>
                                     <li>
                                        <input type="checkbox" name="category" id="search-option-18" value="독서">
                                        <div>
                                            <label for="search-option-18">독서</label>
                                        </div>
                                    </li>
                                    </p>
                                    
                                    <p>건강,뷰티
                                    <li>
                                        <input type="checkbox" name="category" id="search-option-19" value="피트니스">
                                        <div>
                                            <label for="search-option-19">피트니스</label>
                                        </div>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="category" id="search-option-20" value="요가">
                                        <div>
                                            <label for="search-option-20">요가</label>
                                        </div>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="category" id="search-option-21" value="필라테스">
                                        <div>
                                            <label for="search-option-21">필라테스</label>
                                        </div>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="category" id="search-option-22" value="스파">
                                        <div>
                                            <label for="search-option-22">스파</label>
                                        </div>
                                    </li>
                                     <li>
                                        <input type="checkbox" name="category" id="search-option-23" value="심리">
                                        <div>
                                            <label for="search-option-23">심리</label>
                                        </div>
                                    </li>
                                     <li>
                                        <input type="checkbox" name="category" id="search-option-24" value="상담">
                                        <div>
                                            <label for="search-option-24">상담</label>
                                        </div>
                                    </li>
								</p>
                                </ul>
                            </div>
				
                        </div>
                        </div>
                </form>

                <div class="form-group">
                    <label>약관 동의</label>
                    <div data-toggle="buttons">
                        <span class="fa fa-check"></span>
                        <input id="agree" type="checkbox" autocomplete="off">
                        </label>
                        <a href="#">이용약관</a>,개인정보처리방침, 위치기반 서비스에 동의합니다.
                    </div>
                </div>

                <div class="form-group text-center" id="group">
                    <button type="submit" id = "signUp" name = "signUp"class="btn btn-outline-success" disabled>
                      	  회원가입
                    </button>

                </div>
                
    </form>






<!--     <footer id = footer>
        <div id = footer_in>
          <div id = jooTriby>㈜트리비</div>
          <div id = footer_center>
                <div id = footer_left>
                    <div id = footer_left1>
                        <p>대표 : 최봉운</p>
                        <p>개인정보 관리 책임자 : 최봉운</p>
                        <p>사업자등록번호 : 123-45-67890</p>
                        <p>통신판매업신고번호: 2019-경기도안산-92023</p>
                    </div>
                    
                    <div>
                        <p>이메일: xv1212@triby.com</p>
                        <p>대표전화: 010-4602-6227</p>
                        <p>고객센터: 02-562-2378</p>
                        <p>업무시간: 평일 11:00 - 18:00 (점심: 13:00 - 14:00)</p>
                        <p>주소: 서울특별시 강남구 테헤란로 14길 6 남도빌딩</p>
                    </div>
              <div id = footer_right>
                  <a class = right href="#"><span>이용약관</span></a>
                  <a class = right href="#"><span>개인정보 처리방침</span></a>
                  <a class = right href="#"><span>위치기반 서비스 이용약관</span></a>
              </div>
          
                <div id = footer_lower>
                    <div id = lowerLeft>㈜트리비는 통신판매중개자로서 거래당사자가 아니며,<br>호스트가 등록한 상품정보 및 거래에 대해 ㈜트리비는 일체의 책임을 지지 않습니다. </div>
                    <div id = lowerRight>@TRIBY. all rights reserved.</div>
                </div>
          </div>
        </div>
    </footer> -->
    <script>
    
    $(function () {
        $(".search-option-container div").click(function () {
            $(this).children().trigger("click");
        });
    });

    $(function () {
        $(".search-option-container label").click(function (e) {
            e.stopPropagation();
            if ($(this).parent().prev().is(":checked") == false) {
                $(this).parent().css({
                    "color": "white",
                    "background-color": "rgb(11, 140, 140)"
                });
            } else {
                $(this).parent().css({
                    "color": "rgb(11, 140, 140)",
                    "background-color": "white"
                });
            }

            
        });
    });

    
    
    	
    	

    $(function(){
    	$("#joinform").submit(function(){
    		
    	 	var emailCk = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
        	var nameCk = /^[가-힣]+$/;
        	var pwck = /^[A-Za-z0-9]{6,12}$/;
        	var phoneck = /^[0-9]{2,3}[0-9]{3,4}[0-9]{4}$/;
    	
        	if($("#email").val()==""){
    			alert("이메일을 꼭 입력하세요!");
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
    			
    		}else if(!($("#man").is(":checked"))&&!($("#woman").is(":checked"))){
    			alert("성별을 선택하세요!");
    			$("#man").focus();
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
    		}else if($("#phone").val()==""){
    			alert("핸드폰 번호를 입력해주세요");
    			$("#phone").focus();
    			return false;
    		}else if(!phoneck.test($("#phone").val())){
    			alert("'-'를 제외한 번호를 입력해주세요");
    			$("#phone").focus();
    			return false;
    			
    		}else if(!($("#agree").is(":checked"))){
    			alert("이용약관에 동의해주세요");
    			$("#agree").focus();
    			return false;
    		}else{
    			if(confirm("트리비 가입을 하시겠습니까?")){
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
			
			var email = $("#joinform input[name = email]")
			
			var eCheck = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			
			if(!eCheck.test(email.val())){
				
				alert("이메일을 잘못 입력했습니다.");
				email.focus().val("");
			}else{
				$.ajax({
					url:"emailCheck.me",
					type:"post",
					data:{email:email.val()},
					success:function(result){
						
						
						if(result =="fail"){
							alert("사용 할수없는 이메일입니다.");
							email.focus().val("");
						}else{
							if(confirm("사용 가능한 아이디입니다. 사용하시겠습니까?")){
								email.attr("readonly","true");
								isUsable = true;
							}else{
								email.focus().val("");
							}
						}
						if(isUsable){
							$("#signUp").removeAttr("disabled");
						}
						},
						error:function(){
							console.log("서버와 통신 실패");
						}
					});
				}
					
	
			
			
		});
			
		
	});

	
			
 
   
    	
    
    	
			
    	
   
    
  
    </script>
    
   
    
  
 </body>


</html>   	
    


