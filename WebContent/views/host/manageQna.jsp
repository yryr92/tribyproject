<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.triby.qnaHost.model.vo.QnA, com.triby.common.PageInfo"%>
<% 
	ArrayList<QnA> list = (ArrayList<QnA>) request.getAttribute("list");
	int status = (int) request.getAttribute("status");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QNA 관리</title>
<style>
	#wrap{
		float:left;
		margin: 1%;
		font-family: 'Noto Sans KR', sans-serif;
		width:80%;
	}
	#title{font-size:18px; font-weight:bold; margin-bottom:1rem;}
	#content{width:100%; height:77vh; margin: 0; padding:1rem 1rem 1rem 2rem; overflow-y: auto;}
	#navArea{float:left;}
	#searchArea{float:right;}
	#article{height:100%}
	#article .card-header{
		width:100%;
		height:280px;
		margin-top:1rem; 
		margin-bottom:1rem;
		background:#F6F6F6;}
	.pagination{justify-content: center;}
	#qArea, #aArea{display:flex; height:42%; padding-left:2%; width:100%;}
	#qmark, #amark{float:left; padding-top:1%;}
	#qctArea{font-size:18px; font-weight:bold; padding-top:1%;}
	#qcnArea{height:50%; overflow-y: auto;}
	#qtArea{width:68%; margin-left:3%;}
	#ansArea{margin-left:3%; padding-top:1%; width:100%;}
	#qiArea{flex-grow:1; padding-top:1%; font-size:15px; color:dark-gray; text-align:right;}
	#bArea{float:right; margin-right:1%; margin-bottom:2%;}
	.btn:hover{cursor:pointer;}
	.answer{width:100%; height:90%; resize:none;}
	#emptyArea{width:100%; text-align:center; padding-top:20%; height:100%;}
</style>
</head>
<body>
	<%@ include file="aside.jsp" %>
	<div id="wrap">
	<div id="title">Q&A 관리</div>
	<div id="content" class="jumbotron">
	<div id="top">
	<div id="navArea">
		<ul class="nav nav-tabs">
		<% if(status == 0) { %>
  <li class="nav-item">
    <a class="nav-link active" data-toggle="tab" id="allqna" onclick="change(0, 1);">전체 Q&A</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" id="unfinishqna" onclick="change(1, 1);">답변 전 Q&A</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" id="finishqna" onclick="change(2, 1);">답변 완료 Q&A</a>
  </li>
  <% } else if(status == 1) { %>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" id="allqna" onclick="change(0, 1);">전체 Q&A</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" data-toggle="tab" id="unfinishqna" onclick="change(1, 1);">답변 전 Q&A</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" id="finishqna" onclick="change(2, 1);">답변 완료 Q&A</a>
  </li>
  <%} else {%>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" id="allqna" onclick="change(0, 1);">전체 Q&A</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" id="unfinishqna" onclick="change(1, 1);">답변 전 Q&A</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" data-toggle="tab" id="finishqna" onclick="change(2, 1);">답변 완료 Q&A</a>
  </li>
  <% } %>
</ul>
</div><div id="searchArea">
	</div>
	</div>
	<br style="clear:both">
	<hr>
	<div id="article">
	<% if(list.isEmpty()) { %>
		<div id="emptyArea"><h2>QnA가 없습니다!</h2></div>
	<% } else { %>
		<%for(int i=0; i<list.size(); i++) { %>
	<div id="div1" class="card-header">
	<div id="qArea">
		<div id="qmark">
		<img src="resources/images/host/common/question.png" width="50px">
		</div>
		<div id="qtArea">
		<div id="qctArea"><%= list.get(i).getqTitle() %></div>
		<div id="qcnArea"><%= list.get(i).getqContent() %></div>
		</div>
		<div id="qiArea"><%= list.get(i).getUser_name() %>&nbsp;&nbsp;&nbsp;<% if(list.get(i).getqSecret().equals("N")) { %>
			공개 
		<% } else { %>
			비공개
		<% } %>
		&nbsp;&nbsp;&nbsp;<%= list.get(i).getqDate() %></div>
	</div>
	<div id="aArea">
		<div id="amark">
			<img src="resources/images/host/common/warning.png" width="50px">
		</div>
		<div id="ansArea">
		<% if(list.get(i).getqAnswer() != null) { %>
		<textarea class="answer" disabled><%= list.get(i).getqAnswer() %></textarea></div>
		<% } else { %>
		<textarea class="answer" name="answer" id="answer<%= list.get(i).getqNo() %>"></textarea></div>
		<% } %>
	</div>
	<div id="bArea"><button id="addAnswer" class="btn btn-info" onclick="addAnswer(<%= list.get(i).getqNo() %>);">저장</button></div>
	</div>
		<% } %>
			<br style="clear:both">
			<div id="pageArea"> <ul class="pagination pagination-sm">
    <% if(currentPage <= 5) { %>
		<li class="page-item disabled">
     	 <a class="page-link" href="#">&laquo;</a>
    	</li>
	<%} else { %>
		<li class="page-item">
     	 <a class="page-link" onclick="change(<%= status %>, <%= startPage-1 %>);">&laquo;</a>
    	</li>
	<% } %>
    <% for(int p = startPage; p<=endPage; p++) { %>
					
				<% if(p == currentPage) { %>
					<li class="page-item active"><a class="page-link"><%= p %></a></li>
				<%} else { %>
					<li class="page-item"><a class="page-link" onclick="change(<%= status %>, <%= p %>);"><%= p %></a></li>
				<% } %>
				
			<% } %>
	<% if(startPage > maxPage -5) { %>		
		<li class="page-item disabled">
     	 <a class="page-link" href="#">&raquo;</a>
    	</li>
	<%} else { %>
		<li class="page-item">
      <a class="page-link" onclick="change(<%= status %>, <%= endPage +1%>);">&raquo;</a>
    	</li>
	<% } %>
  </ul></div>
	<% } %>
	</div>
	</div>

	 <script>
	 function change(status, page){
			
			var hNo = <%= loginHost.getHost_no() %>
			
			var form = document.createElement("form");      // form생성

			form.setAttribute("method", "post");                    // method 설정
			form.setAttribute("action", "<%= contextPath %>/manageQna.ho");       // action 설정
			
			document.body.appendChild(form);
			
			var input_id = document.createElement("input");
			
			input_id.setAttribute("type", "hidden");

			input_id.setAttribute("name", "hNo");      //name 속성 지정
			input_id.setAttribute("value", hNo);        //value 값 설정

			form.appendChild(input_id);
			
			var input_id2 = document.createElement("input");
			
			input_id2.setAttribute("type", "hidden");

			input_id2.setAttribute("name", "status");      //name 속성 지정
			input_id2.setAttribute("value", status);
			
			form.appendChild(input_id2);
			
			var input_id3 = document.createElement("input");
			
			input_id3.setAttribute("type", "hidden");

			input_id3.setAttribute("name", "page");      //name 속성 지정
			input_id3.setAttribute("value", page);
			
			form.appendChild(input_id3);
			
			form.submit();
			
		}
	 
	 function addAnswer(qNo){
		 var answer = $("#answer" + qNo);
		 
		 $.ajax({
			 url:"update.qa",
			 type:"post",
			 data:{qNo:qNo, answer:answer.val()},
			 success:function(){
				 	answer.attr("disabled", true);
				}, error:function(){
					console.log("통신 실패");
				}
		 });
		 
	 }
	
    </script>
	
</body>
</html>