<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{height:100%; overflow:auto;}
	#aside{
		width:18%;
		height:100vh;
		float:left;
		font-family: 'Noto Sans KR', sans-serif;
	}
	#triby-manage, #member-manage{
		width:100%;
	}
	.none-bullet{list-style-type: none;}
	li{margin-top:10px;}
	li a{
		text-decoration:none;
		color:black;
	}
	li a:hover{
		text-decoration:underline;
		color:black;
		cursor:pointer;
	}
	#list-header{font-size:18px;}
	</style>
</head>
<body>
<div id="header"><%@ include file="header.jsp" %></div>
	<div id="aside" class="table-secondary">
		<div id="triby-manage">
  			<div id="list-header" class="card-header">트리비 관리</div>
 			 <div class="card-body">
 			 <ul class="none-bullet">
 			 	<li><a onclick="makeTriby();">트리비 만들기</a></li>
			 	<li><a onclick="myTriby();">마이 트리비</a></li>
			 </ul>
			</div>
		</div>
		<div id="member-manage">
			<div id="list-header" class="card-header">멤버 관리</div>
 			 <div class="card-body">
 			 <ul class="none-bullet">
 			 	<li><a onclick="manageQna();">Q&A 관리</a></li>
			 	<li><a onclick="manageRev();">리뷰 관리</a></li>
			 </ul>
			</div>
		</div>
		<div id="calculate-manage">
			<div id="list-header" class="card-header">정산 센터</div>
 			 <div class="card-body">
 			 <ul class="none-bullet">
 			 	<li><a onclick="manageCal();">정산 관리</a></li>
			 </ul>
			</div>
		</div>
		<div id="manage-center">
			<div id="list-header" class="card-header">지원 센터</div>
 			 <div class="card-body">
 			 <ul class="none-bullet">
 			 	<li><a onclick="goNotice();">공지사항</a></li>
			 </ul>
			</div>
		</div>
	</div>
	
	<script>
		function makeTriby(){
			location.href="<%= contextPath%>/makeTriby.ho";
		}
		
		function myTriby(){
			//location.href="<%= contextPath%>/myTriby.ho?hno=" + <%= loginHost.getHost_no() %>;
			
			var form = document.createElement("form");      // form생성

			form.setAttribute("method", "post");                    // method 설정
			form.setAttribute("action", "<%= contextPath %>/myTriby.ho");       // action 설정
			
			document.body.appendChild(form);
			
			var input_id = document.createElement("input");
			
			input_id.setAttribute("type", "hidden");

			input_id.setAttribute("name", "hNo");      //name 속성 지정
			input_id.setAttribute("value", <%= loginHost.getHost_no() %>);        //value 값 설정

			form.appendChild(input_id);
			
			var input_id2 = document.createElement("input");
			
			input_id2.setAttribute("type", "hidden");

			input_id2.setAttribute("name", "status");      //name 속성 지정
			input_id2.setAttribute("value", 0);
			
			form.appendChild(input_id2);
			
			var input_id3 = document.createElement("input");
			
			input_id3.setAttribute("type", "hidden");

			input_id3.setAttribute("name", "page");      //name 속성 지정
			input_id3.setAttribute("value", 1);
			
			form.appendChild(input_id3);
			
			form.submit();
			
		}
		
		function manageQna(){
			//location.href="<%= contextPath%>/manageQna.ho";
			

			var form = document.createElement("form");      // form생성

			form.setAttribute("method", "post");                    // method 설정
			form.setAttribute("action", "<%= contextPath %>/manageQna.ho");       // action 설정
						
			document.body.appendChild(form);
						
			var input_id = document.createElement("input");
						
			input_id.setAttribute("type", "hidden");

			input_id.setAttribute("name", "hNo");      //name 속성 지정
			input_id.setAttribute("value", <%= loginHost.getHost_no() %>);        //value 값 설정

			form.appendChild(input_id);
			
			var input_id2 = document.createElement("input");
			
			input_id2.setAttribute("type", "hidden");

			input_id2.setAttribute("name", "status");      //name 속성 지정
			input_id2.setAttribute("value", 0);
			
			form.appendChild(input_id2);
			
			var input_id3 = document.createElement("input");
			
			input_id3.setAttribute("type", "hidden");

			input_id3.setAttribute("name", "page");      //name 속성 지정
			input_id3.setAttribute("value", 1);
			
			form.appendChild(input_id3);
						
			form.submit();
			
		}
		
		function manageRev(){
			//location.href="<%= contextPath%>/manageRev.ho";
			
			var form = document.createElement("form");      // form생성

			form.setAttribute("method", "post");                    // method 설정
			form.setAttribute("action", "<%= contextPath %>/manageRev.ho");       // action 설정
						
			document.body.appendChild(form);
						
			var input_id = document.createElement("input");
						
			input_id.setAttribute("type", "hidden");

			input_id.setAttribute("name", "hNo");      //name 속성 지정
			input_id.setAttribute("value", <%= loginHost.getHost_no() %>);        //value 값 설정

			form.appendChild(input_id);
			
			var input_id2 = document.createElement("input");
			
			input_id2.setAttribute("type", "hidden");

			input_id2.setAttribute("name", "page");      //name 속성 지정
			input_id2.setAttribute("value", 1);
			
			form.appendChild(input_id2);
						
			form.submit();
			
		}
		
		function manageCal(){
			location.href="<%= contextPath%>/manageCal.ho";
		}
		
		function goNotice(){
			location.href="<%= contextPath%>/listh.no";
		}
		
	</script>
	
</body>
</html>