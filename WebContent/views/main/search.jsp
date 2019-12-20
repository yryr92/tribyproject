<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.triby.triby.model.vo.*, com.triby.common.PageInfo"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<ThumbnailTriby> slist = (ArrayList<ThumbnailTriby>)request.getAttribute("slist");
	String search = (String)request.getAttribute("search");
	
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TRIBY</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript"></script>	
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<style>

    
    
</style>
</head>
<body>
   <%@ include file="../common/header.jsp" %>

    <body>
    <div id="body">

            <!--필터 버튼 라인-->
            <div id="filter_line">   
                <div id="filter_btn">
                    <div id="filter_btn2"><a href="#">필터▽</a></div>
                    <div id="filter_hide">
                        <span><a href="<%=contextPath%>/search.ma?search=<%=search%>&currentPage=1">인기순</a></span>
                        <span> | </span>
                        <span><a href="<%=contextPath%>/searchPrice.ma?search=<%=search%>&currentPage=1">가격순</a></span>
                        <span> | </span>
                        <span><a href="<%=contextPath%>/searchDate.ma?search=<%=search%>&currentPage=1">최신순</a></span>
                    </div>
                </div>
            </div>

			<%if(slist.size() == 0){ %>
				해당 검색 결과가 없습니다
			
			
			<%}else{ %>
            <div id="search">   <!--검색 목록 라인-->
                <div class="search_label">
                    <span id="search_category"><%=search %></span>
                </div>
                
                
                <div id="search_triby">
                	<%for(int i=0; i<slist.size();i++){ %>
				
                    <div class="search_triby1">
                        <a href="<%=contextPath%>/detail.ma?tNo=<%=slist.get(i).gettNo()%>">
                            <div class="search_triby1_img">
                                <img src="<%=contextPath%>/resources/images/triby/<%= slist.get(i).gettImg() %>" width="95%;" height="100%">
                            </div>
                            <div class="search_triby1_text">
                                <div class="search_triby_title"><%=slist.get(i).gettName() %></div>
                                <div class="search_triby_price">가격 <%=slist.get(i).gettPrice()%></div>
                                <div class="search_triby_likeCount">좋아요 <%=slist.get(i).getLike()%></div>
                            </div>
                        </a>
                    </div>
					<%} %>
				</div>
            </div>
            <%} %>

            <!-- ----------- 페이징 바 ------------ -->
			<div class="pagingArea" align="center">
				
				<!-- 맨처음으로(<<) -->
				<button onclick="location.href='<%=contextPath%>/search.ma?search=<%=search%>&currentPage=1';"> &lt;&lt; </button>
				
				<!-- 이전 페이지로(<) -->
				<% if(currentPage == 1){ %>
				<button disabled> &lt; </button>
				<% }else{ %>
				<button onclick="location.href='<%=contextPath%>/search.ma?search=<%=search%>&currentPage=<%= currentPage-1 %>';"> &lt; </button>
				<% } %>
				
				<!-- 5개의 페이지 목록 -->
				<% for(int p=startPage; p<=endPage; p++){ %>
					
					<% if(p == currentPage){ %>
					<button disabled> <%= p %> </button>
					<% }else { %>
					<button onclick="location.href='<%=contextPath%>/search.ma?search=<%=search%>&currentPage=<%=p%>';"> <%= p %> </button>
					<% } %>
					
				<% } %>
				
				<!-- 다음 페이지로(>) -->
				<% if(currentPage == maxPage){ %>
				<button disabled> &gt; </button>
				<% }else{ %>
				<button onclick="location.href='<%=contextPath%>/search.ma?search=<%=search%>&currentPage=<%=currentPage+1%>';"> &gt; </button>
				<% } %>
				
				<!-- 맨끝으로(>>) -->
				<button onclick="location.href='<%=contextPath%>/search.ma?search=<%=search%>&currentPage=<%=maxPage%>';"> &gt;&gt; </button>
				
			</div>
            <br>
    </div>
    </body>

    <footer>
	    <%@ include file="../common/footer.jsp" %>
    </footer>
    
    <script>
        $(function(){
            $("#filter_btn2").on("click",function(){
                if($("#filter_hide").css("display") == "none"){
                    $("#filter_hide").css("display","block");
                }else{
                    $("#filter_hide").css("display","none");
                }
            });
        }); 
        
        
    </script>
</body>
</html>