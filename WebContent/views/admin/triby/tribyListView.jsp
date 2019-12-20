<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.triby.triby.model.vo.Triby,com.triby.common.PageInfo" %>    
<%
	ArrayList<Triby> list = (ArrayList<Triby>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	int currentPage = pi.getCurrentPage();
	
	String appMsg = (String)session.getAttribute("appMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>트리비목록페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
    <style>
        div{
            box-sizing:border-box;
        }
        body{
            margin:0;
        }
        .outer{
            width:1920px;
            height:969px;
        }
        .header{
            height:10%;
            background: aquamarine;
        }
        .body{
            display:flex;
            height:90%;
        }
        .sidemenu{
            width:260px;
            height:100%;
            background:wheat;
        }
        .contentWrap{
            width:1660px;
            background: lightgray;
        }
        .menu{
            height:50px;
            background:white;
            border:1px solid black;
            font-size:2em;
            list-style:none;
            padding:12px 10px;
        }
        .menu a{
            display:block;
            text-decoration: none;
            box-sizing:border-box;
            width:278px;
            height:90%;

        }
        .menu a:visited{
            color:aqua;
        }
        .menu a:link{
            color:aqua;
        }
        .logo{
            margin:0;
            padding:24px;
        }
        .aTitle{
            padding:20px;
            margin:0;
        }
        button{
            background-color:white;
            cursor:pointer;
            /* display:block; */
        }
        .tagWrap{
            display:flex;
        }
        .btn{
            width:80px;
            height:60px;
            text-align:center;
            padding-top:20px;
        }
        .tagWrap button{
            margin-left:20px;
            border-radius:4px;
        }
        .notice table{
            border:1px solid black;
            text-align: center;
            margin-left:auto;
            margin-right:auto;
        }
        .notice{
            background-color:white;
            width:1500px;
            margin-left:auto;
            margin-right:auto;
            margin-top:30px;
            padding-bottom:30px;
        }
        .write{
            margin-left:880px;
        }
        .notice table tr th button{
            margin-left:auto;
            margin-right:auto;
        }
        .btn:hover {cursor:pointer;}
        #searchNoticeInput:hover{cursor:pointer;}
    </style>
    <script>
    	$(document).ready(function() {
    		var appMsg = "<%=appMsg%>";
    		if(appMsg !="null") {
    		alert(appMsg);
    		<%session.removeAttribute("appMsg");%>
    		}
    	})
    </script>
</head>
<body>
<%@include file="../adminHeader.jsp" %>
    <div class="outer">

        <div class="body">
            <div class="sidemenu">
                    <li class="menu"><a href="<%=request.getContextPath()%>/adminMain.ad"><span>공지사항</span></a></li>
                    <li class="menu"><a href="<%=request.getContextPath()%>/report.ad"><span>신고</span></a></li>
                    <li class="menu"><a href="<%=request.getContextPath()%>/calculate.ad"><span>정산</span></a></li>
                    <li class="menu"><a href="<%=request.getContextPath()%>/member.ad"><span>회원/호스트</span></a></li>
                    <li class="menu"><a href="<%=request.getContextPath()%>/triby.ad"><span>트리비승인</span></a></li>
                    <li class="menu"><a href="<%=request.getContextPath()%>/logout.ad"><span>로그아웃</span></a></li>
            </div>
            <div class="contentWrap">
                <h1 class="aTitle">트리비승인</h1>
               
                <div class="notice" id="tribyTableArea">
                    <table id="tribyTable">
                        <tr>
                            <th width="150px">트리비번호</th>
                            <th width="200px">트리비제목</th>
                           <!--  <th width="300px">소개글</th> -->
                            <th width="100px">호스트이름</th>
                          	<th width="300px">호스트승인여부</th>
                          	<th width="300px">호스트전화번호</th>
                          	<th width="300px">호스트이메일</th>
                            <th width="100px">작성일</th>
                            <th width="100px">승인여부</th>             
                        </tr>
                        <% if(list.isEmpty()) { %>
                        <tr>
                            <td colspan="8" height="50px">미승인 트리비가 없습니다</td>
                        </tr>
						<%}else { %>
						<% for(Triby t : list) { %>
                        <tr>
                            <td><%=t.gettNo() %></td>
                            <td><%=t.gettTitle() %></td>
							<%-- <td><%=t.gettContent() %></td> --%>
                            <td><%=t.getcId1()%></td>
                            <td><%=t.getcId2() %></td>
                            <td><%=t.gettContent1() %></td>
                            <td><%=t.gettContent2()%></td>
                            <td><%=t.getTriby_date() %></td>
                            <td><%=t.getAppoval_status() %>
                        
                        </tr>
						<%} %>
						<%} %>

                    </table>
                </div>
                
                <div class="pagingArea" align="center">
                    <button onclick="location.href='<%=request.getContextPath()%>/triby.ad?currentPage=1';">&lt;&lt;</button>
                	<%if(currentPage ==1) { %>
                		<button disabled>&lt;</button>
                	<%}else { %>
                		<button onclick="location.href='<%=request.getContextPath()%>/triby.ad?currentPage=<%=currentPage-1%>';">&lt;</button>
                	<%} %>
                	
                	<%for(int p = startPage;p<=endPage;p++) { %>
                		<%if(p == currentPage) { %>
						<button disabled><%=p %></button>                	
                	<%}else { %>
                		<button onclick="location.href='<%=request.getContextPath()%>/triby.ad?currentPage=<%=p%>';"><%=p %></button>
                	<%} %>
                	<%} %>
                
                	<%if(currentPage == maxPage) { %>
                		<button disabled>&gt;</button>
                	<%}else { %>
                		<button onclick="location.href='<%=request.getContextPath()%>/triby.ad?currenPage=<%=currentPage+1%>';">&gt;</button>
                	<%} %>
                	<button onclick="location.href='<%=request.getContextPath() %>/triby.ad?currentPage=<%=maxPage %>';">&gt;&gt;</button>
                </div>
            </div>
        </div>    
    </div>

<script>
	$(document).ready(function() {
		<%if(!list.isEmpty()) {%>
		$("#tribyTable td").mouseenter(function() {
			$(this).parent().css({background:"#f5f5f5",cursor:"pointer"});
		}).mouseout(function() {
			$(this).parent().css("background","white");
		}).click(function() {
				var tNo = $(this).parent().children().eq(0).text();
<%-- 				
				var winObj = window.open("<%=request.getContextPath()%>/views/admin/triby/tribyDetailView.jsp","Triby","width=1000,height=1000");
				winObj.document.all.tNo.text()= tNo; --%>
				
			
				
				location.href="<%=request.getContextPath()%>/tribyDetail.ad?tNo=" + tNo;
				<%-- location.href="<%=request.getContextPath()%>/tribyDetail.ad"; --%>
		})
		<%}%>
	})
	
</script>
</body>
</html>