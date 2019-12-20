<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.triby.tImage.model.vo.Image, com.triby.triby.model.vo.Triby, com.triby.common.PageInfo"%>
<%
	ArrayList<Triby> tList = (ArrayList<Triby>) request.getAttribute("tList");
	ArrayList<Image> iList = (ArrayList<Image>) request.getAttribute("iList");
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
<title>myTriby</title>
<style>
	#wrap{
		float:left;
		margin: 1%;
		font-family: 'Noto Sans KR', sans-serif;
		width:80%;
	}
	#title{font-size:18px; font-weight:bold; margin-bottom:1rem;}
	#content{width:100%; height: 77vh; margin: 0; padding:1rem 1rem 1rem 2rem; overflow-y: auto;}
	#navArea{float:left;}
	#article{height:100%}
	#article .card-header{
		width:30%;
		height:420px;
		margin-top:1rem; 
		margin-bottom:1rem;
		background:#F6F6F6;
		float:left;
		margin-left:1rem;
		margin-right:1rem;
		position:relative;
		}
	.pagination{justify-content: center;}
	#imgArea{height:180px;}
	#contentArea{height:220px;}
	table{width:90%; margin-left:auto; margin-right:auto; font-size:16px;}
	#contentTb tr td:nth-child(2){text-align:right;}
	#btnTb{text-align:center; position: absolute; bottom:1%}
	td{height:30px;}
	h3{margin-left:3%;}
	.btn:hover{cursor:pointer;}
	#emptyArea{width:100%; text-align:center; padding-top:20%; height:100%;}
</style>
</head>
<body>
	<%@ include file="aside.jsp" %>
	<div id="wrap">
	<div id="title">마이 트리비</div>
	<div id="content" class="jumbotron">
		<div id="top">
	<div id="navArea">
		<ul class="nav nav-tabs">
		  
<% if(status == 0) { %>
<li class="nav-item">
		    <a class="nav-link active" data-toggle="tab" id="ing" onclick="change(0, 1);">판매중</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" data-toggle="tab" id="wait" onclick="change(1, 1);">대기</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" data-toggle="tab" id="end" onclick="change(2, 1);">종료</a>
		  </li>

<% } else if(status == 1) { %>
<li class="nav-item">
    <a class="nav-link" data-toggle="tab" id="ing" onclick="change(0, 1);">판매중</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link active" data-toggle="tab" id="wait" onclick="change(1, 1);">대기</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" data-toggle="tab" id="end" onclick="change(2, 1);">종료</a>
		  </li>

<%} else {%>
<li class="nav-item">
    <a class="nav-link" data-toggle="tab" id="ing" onclick="change(0, 1);">판매중</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" data-toggle="tab" id="wait" onclick="change(1, 1);">대기</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link active" data-toggle="tab" id="end" onclick="change(2, 1);">종료</a>
		  </li>
<% } %>
		</ul>
	</div>
	</div>
	<br style="clear:both">
	<hr>
	<div id="article">
	<% if(tList.isEmpty()) { %>
		<div id="emptyArea"><h2>트리비가 없습니다ㅠ^ㅠ</h2></div>
	<% } else { %>
		<%for(int i=0; i<tList.size(); i++) { %>
			<div id="div1" class="card-header">
		<div id="imgArea"><img src="<%=contextPath %>/resources/images/triby/<%=iList.get(i).getiName() %>" width="100%" height="100%"></div>
		<div id="contentArea">
		<br>
		<h3><%= tList.get(i).gettTitle() %></h3> <br>
		<table id="contentTb">
			<tr>
				<td>상태</td>	
				<td><% if(tList.get(i).getAppoval_status().equals("Y")) { %>
				판매중
				<% } else if(tList.get(i).getAppoval_status().equals("N")) { %>
				대기
				<%} else { %>
				종료
				<%} %>
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td><%= tList.get(i).gettPrice() %> 원</td>
			</tr>
		</table>
		<table id="btnTb">
			<tr>
				<td><form method="post" action="<%= contextPath%>/insertForm.op">
				<input type="hidden" name="tNo" value="<%= tList.get(i).gettNo() %>">
				<button class="btn btn-info" type="submit">옵션 추가</button>
				</form></td>
				<td><form method="post" action="<%= contextPath%>/select.op">
				<input type="hidden" name="tNo" value="<%= tList.get(i).gettNo() %>">
				<button class="btn btn-info">옵션 관리</button>
				</form></td>
				<td><form method="post" action="<%= contextPath%>/updateForm.tr">
				<input type="hidden" name="tNo" value="<%= tList.get(i).gettNo() %>">
				<button class="btn btn-info" type="submit">내용 수정</button></form></td>
			</tr>
		</table>
		</div>
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
	</div>
	<script>
		function change(status, page){
			
			var hNo = <%= loginHost.getHost_no() %>
			
			var form = document.createElement("form");      // form생성

			form.setAttribute("method", "post");                    // method 설정
			form.setAttribute("action", "<%= contextPath %>/myTriby.ho");       // action 설정
			
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
	</script>
</body>
</html>