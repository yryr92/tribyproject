<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.triby.review.model.vo.ReviewHost, com.triby.common.PageInfo"%>
<% 
	ArrayList<ReviewHost> list = (ArrayList<ReviewHost>) request.getAttribute("list");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	
	int count = (int) request.getAttribute("count");
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	
	int sum = 0;
	
	for(int i=0; i<list.size(); i++) {
		sum += list.get(i).getRvPoint();
	}
	
	double avg = (double) sum / list.size();
	if(Double.isNaN(avg)) {
		avg = 0;
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#wrap{
		float:left;
		margin: 1%;
		font-family: 'Noto Sans KR', sans-serif;
		width:80%;
	}
	#title{font-size:18px; font-weight:bold; margin-bottom:1rem;}
	#content{width:100%; height:77vh; margin: 0; padding:1rem 1rem 1rem 2rem; overflow-y: auto;}
	#navArea{float:right; margin-right:10px;}
	.dropdown-toggle{width:160px}
	#div1{margin-top:10px}
	.dropdown-menu>a {
		  color: black;
		  display: block;
		  padding: 3px 20px;
		  line-height: 1.5;
		  text-align: right;
		  text-decoration: none;
	}
	.dropdown-toggle{text-align:right;}
	#article{height:100%}
	#article .card-header{
		width:100%;
		height:280px;
		margin-top:1rem; 
		margin-bottom:1rem;
		background:#F6F6F6;}
	#informArea{float:left; padding-top:20px; font-weight:bold;}
	.pagination{justify-content: center;}
	#qArea, #aArea{display:flex; height:42%; padding-left:2%;}
	#qmark, #amark{float:left; padding-top:1%;}
	#qctArea{font-size:18px; font-weight:bold; padding-top:1%;}
	#qcnArea{height:50%; overflow-y: auto;}
	#qtArea{width:68%; margin-left:3%;}
	#qiArea{flex-grow:1; padding-top:1%; font-size:15px; color:dark-gray; text-align:right;}
	#ansArea{margin-left:3%; padding-top:1%; width:100%}
	#bArea{float:right; margin-right:1%; margin-bottom:2%;}
	.btn:hover{cursor:pointer;}
	.reply{width:100%; height:90%; resize:none;}
	#emptyArea{width:100%; text-align:center; padding-top:20%; height:100%;}
</style>
</head>
<body>
	<%@ include file="aside.jsp" %>
	<div id="wrap">
	<div id="title">리뷰 관리</div>
	<div id="content" class="jumbotron">
	<div id="informArea">평균 별점 <%= String.format("%.2f", avg) %> (총 <%= count %>개) </div>
	<br style="clear:both">
	<hr>
	<div id="article">
	<% if(list.isEmpty()) { %>
		<div id="emptyArea"><h2>리뷰가 없습니다!</h2></div>
	<% } else { %>
		<%for(int i=0; i<list.size(); i++) { %>
	<div id="div1" class="card-header">
	<div id="qArea">
		<div id="qmark">
		<img src="resources/images/host/common/chat.png" width="50px">
		</div>
		<div id="qtArea">
		<div id="qctArea"><%= list.get(i).getTriby() %></div>
		<div id="qcnArea"><%= list.get(i).getRvContent() %></div>
		</div>
		<div id="qiArea"><%= list.get(i).getUser_name() %>&nbsp;&nbsp;&nbsp;
		<img src="resources/images/host/common/rating.png" width="32px">
		<%= list.get(i).getRvPoint() %>&nbsp;&nbsp;&nbsp;&nbsp;<%= list.get(i).getRvDate() %></div>
	</div>
	<div id="aArea">
		<div id="amark">
		<img src="resources/images/host/common/chatheart.png" width="50px">
		</div>
		<div id="ansArea">
		<% if(list.get(i).getReply() != null) { %>
		<textarea class="reply" disabled><%= list.get(i).getReply() %></textarea></div>
		<% } else { %>
		<textarea class="reply" name="reply" id="reply<%= list.get(i).getRvNo() %>"></textarea></div>
		<% } %>
	</div>
	<div id="bArea">
	<button type="button" class="btn btn-danger" onclick="report(<%= list.get(i).getuNo() %>);">신고</button>
	<button type="button" class="btn btn-info" onclick="addReply(<%= list.get(i).getRvNo() %>);">저장</button></div>
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
     	 <a class="page-link" onclick="change(<%= startPage-1 %>);">&laquo;</a>
    	</li>
	<% } %>
    <% for(int p = startPage; p<=endPage; p++) { %>
					
				<% if(p == currentPage) { %>
					<li class="page-item active"><a class="page-link"><%= p %></a></li>
				<%} else { %>
					<li class="page-item"><a class="page-link" onclick="change(<%= p %>);"><%= p %></a></li>
				<% } %>
				
			<% } %>
	<% if(startPage > maxPage -5) { %>		
		<li class="page-item disabled">
     	 <a class="page-link" href="#">&raquo;</a>
    	</li>
	<%} else { %>
		<li class="page-item">
      <a class="page-link" onclick="change(<%= endPage +1%>);">&raquo;</a>
    	</li>
	<% } %>
  </ul></div>
	<% } %>
	</div>
	</div>
	
	<script>
		
		//var winObject = null;
	
		function report(uNo){
			
			var form = document.createElement("form");      // form생성

			form.setAttribute("method", "post");                    // method 설정
			form.setAttribute("action", "<%= contextPath%>/inserth.rep");       // action 설정
			form.setAttribute("target", "reportForm")
			
			document.body.appendChild(form);
			
			var input_id = document.createElement("input");
			
			input_id.setAttribute("type", "hidden");

			input_id.setAttribute("name", "uNo");      //name 속성 지정
			input_id.setAttribute("value", uNo);        //value 값 설정

			form.appendChild(input_id);
			
			var input_id2 = document.createElement("input");
			
			input_id2.setAttribute("type", "hidden");

			input_id2.setAttribute("name", "hNo");      //name 속성 지정
			input_id2.setAttribute("value", <%= loginHost.getHost_no() %>);        //value 값 설정

			form.appendChild(input_id2);
			
			var wintype = "width=520, height=520, resizable=no";
			open("", "reportForm", wintype);
			
			form.submit();
			
		//	var wintype = "width=520, height=470, resizable=no";
			//open("<%= contextPath%>/inserth.rep?uNo=" + uNo, "reportForm", wintype);
			
		}
		
		function change(page) {
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
		
		function addReply(rNo) {
			var reply = $("#reply" + rNo);
			
			$.ajax({
				 url:"update.re",
				 type:"post",
				 data:{rNo:rNo, reply:reply.val()},
				 success:function(){
					 reply.attr("disabled", true);
					}, error:function(){
						console.log("통신 실패");
					}
			});
			
		}
		
		
	</script>
	
</body>
</html>