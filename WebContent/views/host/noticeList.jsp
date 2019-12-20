<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.triby.notice.model.vo.Notice, com.triby.common.PageInfo"%>
<% 
	ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list"); 
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
	#searchArea{float:right;}
	.table{background:white; font-size:15px; text-align:center;}
	.table th{height:50px}
	.pagination{justify-content: center;}
	tr>td:nth-child(3){text-align:center;}
	tr>td:nth-child(4){text-align:right; font-size:12px; color:gray;}
	span{background:#1CA9AE; border-radius:5px;}
	td:hover{cursor:pointer;}
	tr>td:nth-child(1), tr>td:nth-child(2){width:120px;}
</style>
</head>
<body>
	<%@ include file="aside.jsp" %>
	<div id="wrap">
	<div id="title">공지사항</div>
	<div id="content" class="jumbotron">
	<div id="searchArea">
	</div>
	<br style="clear:both">
	<hr>
	<div id="article">
		<table class="table table-hover" id="notice">
  <thead>
    <tr>
      <th scope="col">글번호</th>
      <th scope="col">카테고리</th>
      <th scope="col" >제목</th>
      <th scope="col">날짜</th>
    </tr>
  </thead>
  <tbody>
  <% if(list.isEmpty()) { %>
  	<tr><td colspan="3">존재하는 글이 없습니다.</td></tr>
  <% } else { %>
  
  <% for(Notice n : list) { %>
    <tr>
	  <td><%= n.getnNo() %></td>
      <td>
      <% if(n.getnCategory().equals("공지")) { %>
      <span><%= n.getnCategory() %></span>
      <% } else if(n.getnCategory().equals("호스트")) { %>
      <span style="background:yellow"><%= n.getnCategory() %></span>
      <% } else { %>
      <span style="background:pink"><%= n.getnCategory() %></span>
      <% } %>
     </td>
      <td><%= n.getnTitle() %></td>
      <td><%=n.getnDate() %></td>
    </tr>
    <% } %>
  <% } %>
  </tbody>
</table> 
<div> <ul class="pagination pagination-sm">
    <% if(currentPage <= 5) { %>
		<li class="page-item disabled">
     	 <a class="page-link" href="#">&laquo;</a>
    	</li>
	<%} else { %>
		<li class="page-item">
     	 <a class="page-link" href="<%= contextPath%>/listh.no?currentPage=<%= startPage-1 %>">&laquo;</a>
    	</li>
	<% } %>
    <% for(int p = startPage; p<=endPage; p++) { %>
					
				<% if(p == currentPage) { %>
					<li class="page-item active"><a class="page-link"><%= p %></a></li>
				<%} else { %>
					<li class="page-item"><a class="page-link" href="<%= contextPath%>/listh.no?currentPage=<%= p %>"><%= p %></a></li>
				<% } %>
				
			<% } %>
	<% if(startPage > maxPage -5) { %>		
		<li class="page-item disabled">
     	 <a class="page-link" href="#">&raquo;</a>
    	</li>
	<%} else { %>
		<li class="page-item">
      <a class="page-link" href="<%= contextPath%>/listh.no?currentPage=<%= endPage +1%>">&raquo;</a>
    	</li>
	<% } %>
  </ul></div>
	</div>
	</div>
	</div>
	
	<script>
			$(function(){
				$("#notice td").click(function(){
					
					var nNo = $(this).parent().children().eq(0).text();
						location.href="<%= contextPath%>/detailh.no?nNo=" + nNo;
				});
			})	
		
		</script>
	
</body>
</html>