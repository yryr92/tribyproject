<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.triby.triby.model.vo.*"%>
    
<%
	ArrayList<ThumbnailTriby> cListH = (ArrayList<ThumbnailTriby>)request.getAttribute("cListH");
	ArrayList<ThumbnailTriby> cListV = (ArrayList<ThumbnailTriby>)request.getAttribute("cListV");
	ArrayList<ThumbnailTriby> cListN = (ArrayList<ThumbnailTriby>)request.getAttribute("cListN");
	String category = (String)request.getAttribute("category");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
    <div id="body">
    	<br>
    	
		<%if(cListH.size() != 0){%>		<!-- 인기카테고리가 0개가 아닌경우만 출력 -->
        <div id="hot">   <!--인기 카테고리 라인-->
            <div class="hot_label">
                <span id="hot_category">인기! &nbsp;&nbsp;&nbsp; <%=category %></span>
            </div>
            <br>
            <div id="hot_triby">
            	<% for(int i=0 ; i<cListH.size() ; i++) {%>
            	
                <div class="hot_triby1">
                    <a href="<%=contextPath%>/detail.ma?tNo=<%=cListH.get(i).gettNo()%>">
                        <div class="hot_triby1_img">
                            <img src="<%=contextPath%>/resources/images/triby/<%=cListH.get(i).gettImg()%>" width ="95%" height="100%">
                        </div>
                        <div class="hot_triby1_text">
                            <div class="hot_triby_title"><%=cListH.get(i).gettName() %></div>
                            <div class="hot_triby_price">가격 <%=cListH.get(i).gettPrice()%></div>
                            <span class="hot_triby_likeCount">좋아요 <%=cListH.get(i).getLike()%></span>
                        </div>
                    </a>
                </div>
                <%} %>
            </div>
        </div>
        <hr>
        <%} %>
		
		<%if(cListV.size() != 0){%>		<!-- 인기카테고리가 0개가 아닌경우만 출력 -->
        <div id="deadline">   <!-- 마감임박 카테고리--> <!-- 옵션에 해당하는 샘플이 있어야 실행 가능할듯 -->
            <div class="deadline_label">
                <span id="deadline_category">가격!&nbsp;&nbsp;&nbsp;<%=category %></span>
            </div>
            <br>
            <div id="deadline_triby">
            
            	<!-- 임시로 가격순 넣음 -->
            	<%for(int i=0 ; i<cListV.size() ; i++) {%>
            	
                <div class="deadline_triby1">
                    <a href="<%=contextPath%>/detail.ma?tNo=<%=cListV.get(i).gettNo()%>">
                        <div class="deadline_triby1_img">
                            <img src="<%=contextPath%>/resources/images/triby/<%=cListV.get(i).gettImg()%>" width ="95%" height="100%">
                        </div>
                        <div class="deadline_triby1_text">
                            <div class="deadline_triby_title"><%=cListV.get(i).gettName()%></div>
                            <div class="deadline_triby_price">가격 <%=cListV.get(i).gettPrice()%></div>
                            <span class="deadline_triby_likeCount">좋아요 <%=cListV.get(i).getLike()%></span>
                        </div>
                    </a>
                </div>
                <%} %>
            </div>
        </div>
        <hr>
        <%} %>
        
		<%if(cListN.size() != 0){%>		<!-- 신규 카테고리가 0개가 아닌경우만 출력 -->
        <div id="new">   <!--신규 카테고리-->
            <div class="new_label">
                <span id="new_category">신규! &nbsp;&nbsp;&nbsp; <%=category %>	</span>
            </div>
            <br>
            <div id="new_triby">
            	<%for(int i=0 ; i<cListN.size() ; i++) {%>
                <div class="new_triby1">
                    <a href="<%=contextPath%>/detail.ma?tNo=<%=cListN.get(i).gettNo()%>">
                        <div class="new_triby1_img">
                            <img src="<%=contextPath%>/resources/images/triby/<%=cListN.get(i).gettImg()%>" width ="95%" height="100%">
                        </div>
                        <div class="new_triby1_text">
                            <div class="new_triby_title"><%=cListN.get(i).gettName()%></div>
                            <div class="new_triby_price">가격 <%=cListV.get(i).gettPrice()%></div>
                            <span class="new_triby_likeCount">좋아요 <%=cListV.get(i).getLike()%></span>
                        </div>
                    </a>
                </div>
                <%} %>
            </div>
        </div>
        <%} %>
    </div>
    
    <footer>
    	<%@ include file="../common/footer.jsp" %>
    </footer>
 
</body>
</html>