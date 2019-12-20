<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
    

    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
<!-- jQuery -->
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
  <link rel="stylesheet" href="resources/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="resources/css/bootstrap.min.css">
   
  
 
</head>
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
    </style>
<body>
   	<%@ include file = "../common/header.jsp" %>

                
                <%-- <form action="<%=contextPath %>/findId.me" method="POST" id="userfid">  --%>
                  <div class = "main" >
                  <div id = "">
           	    <h3>아이디 찾기</h3>

                <input type="text" class= "find" name = "name" id = "name" placeholder="이름을 입력하세요">
                <input type="text" class ="find" name ="phone" id = "phone" placeholder="(-)빼고전화번호를 입력하세요">
                <input type="submit" id = "findId" value="찾기" class="btn btn-outline-success"  style="width:50%"><br> 
                 <a href="#" class= "text" onclick="findPwd()">비밀번호도 모르시겠다면?</a>            
                
            		</div>
                  
                  
                  </div>
      
            
           		
					<!-- </form> -->
                    				
                                	
                   
			
    </body>
    
    	<script>
    	
    	function findPwd(){
    		
    		location.href = "<%=request.getContextPath()%>/findPwdview.me";
    	}
    		
    	$(function(){
    		
     		$("#findId").click(function(){
     			
    			var name = $("#name");
    			var phone = $("#phone");
    			//var settings = 'toolbar=0,status=0,menubar=0,height=500,width=400'
    			//var target = '<%=contextPath%>/views/member/findIDview.jsp'
    			//var view = window.open('about:blank','뷰', settings);
    			
    			$.ajax({
    				
    				url:"findId.me", // FindMemberIDServlet
    				type:"post",
    				dataType:"json",
    				data:{name:name.val() , phone:phone.val()},
    				success:function(result){
    					
							if (name.val() == "" && phone.val() == ""){
    						
    						alert("이름과 번호를 입력해주세요.");
    						
    					}else{
    						if(result.status == "fail"){
        						
        						alert("일치하는 값이 없습니다.");
        					
        					}else{
        						
        						//result.findID
        						window.open('<%=contextPath%>/views/member/findIDview.jsp?findID='+result.findID,'뷰', 'toolbar=0,status=0,menubar=0,height=168,width=460');
        						//view.location = target;
        					}
    						
    					}
   
    				}
    			
    			
    			
    			})
    			
     		
     		
     		})
    				
    			
    				
    			
     		
    		
    	});
    	
    
    	</script>

</body>
</html>