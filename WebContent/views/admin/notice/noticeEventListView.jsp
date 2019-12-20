<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.triby.notice.model.vo.Notice,com.triby.common.PageInfo,java.text.SimpleDateFormat" %>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <title>공지사항 페이지</title>
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
                <h1 class="aTitle">공지사항</h1>
                <div class="tagWrap">
                    <button type="button" onclick="location.href='<%=request.getContextPath() %>/notice.ad';">
                    	<div class="btn" id="btn0">전체</div></button>
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/notice.ad?selected=공지';">
                    	<div class="btn" id="btn1">공지</div></button>
                    <button type="button" onclick="location.href='<%=request.getContextPath() %>/notice.ad?selected=이벤트';">
                    	<div class="btn" id="btn2">이벤트</div></button>
                    <button type="button" onclick="location.href='<%=request.getContextPath() %>/notice.ad?selected=호스트';">
                    	<div class="btn" id="btn3">호스트</div></button>
                    <button type="button" onclick="location.href='<%=request.getContextPath() %>/notice.ad?selected=N';">
                    	<div class="btn" id="btn4">비공개</div></button>
                    
                    <div class="write"><button type="button" onclick="location.href='<%=request.getContextPath()%>/insertNoticeForm.ad';"><div class="btn" id="write_notice">공지 작성</div></button></div>
                </div>
                    <div class="searchNoticeForm">
                       <form action="<%=request.getContextPath() %>/searchNotice.ad?" method="post">
						  <span>제목:</span>
                          <input type="search" name="searchNoticeTitle" id="searchNoticeTitle">
                          <input type="submit" value="전체검색" id="searchNoticeInput" >
                       </form>
                    </div>
                <div class="notice" id="noticeTable1">
                    <table>
                        <tr>
                            <th width="150px">번호</th>
                            <th width="200px">분류</th>
                            <th width="300px">제목</th>
                          
                            <th width="200px">작성일</th>
                            <th width="100px">게시여부</th>
                           
                        </tr>
                        <%if(list.isEmpty()){ %>
                        <tr>
                            <td colspan="6" height="50px">공지사항이 없습니다</td>

                        </tr>
                        <%}else { %>
                        <%for(Notice n : list) { %>
                        <tr>
                            <td height="50px"><%=n.getnNo() %></td>
                            <td><%=n.getnCategory()%></td>
                            <td><%=n.getnTitle() %></td>
                           		<%String nDate = sdf.format(n.getnDate()); %>
                            <td><%= nDate%></td>
                            <td><%=n.getnStatus() %></td>
                        
                        </tr>
                 		<%} %>
                        <%} %>

                    </table>
                </div>
                
                <div class="pagingArea" align="center">
                	<button onclick="location.href='<%=request.getContextPath()%>/notice.ad?selected=이벤트&currentPage=1';">&lt;&lt;</button>
                	<%if(currentPage ==1) { %>
                		<button disabled>&lt;</button>
                	<%}else { %>
                		<button onclick="location.href='<%=request.getContextPath()%>/notice.ad?selected=이벤트&currentPage=<%=currentPage-1%>';">&lt;</button>
                	<%} %>
                	
                	<%for(int p = startPage;p<=endPage;p++) { %>
                		<%if(p == currentPage) { %>
						<button disabled><%=p %></button>                	
                	<%}else { %>
                		<button onclick="location.href='<%=request.getContextPath()%>/notice.ad?selected=이벤트&currentPage=<%=p%>';"><%=p %></button>
                	<%} %>
                	<%} %>
                
                	<%if(currentPage == maxPage) { %>
                		<button disabled>&gt;</button>
                	<%}else { %>
                		<button onclick="location.href='<%=request.getContextPath()%>/notice.ad?selected=이벤트&currenPage=<%=currentPage+1%>';">&gt;</button>
                	<%} %>
                	<button onclick="location.href='<%=request.getContextPath() %>/notice.ad?selected=이벤트&currentPage=<%=maxPage %>';">&gt;&gt;</button>
                </div>
            </div>
        </div>    
    </div>
 	<input type="hidden" name="selected">
<script>
	$(document).ready(function() {
		<%if(!list.isEmpty()) {%>
		$("#noticeTable1 td").mouseenter(function() {
			$(this).parent().css({background:"#f5f5f5",cursor:"pointer"});
		}).mouseout(function() {
			$(this).parent().css("background","white");
		}).click(function() {
			var nNo = $(this).parent().children().eq(0).text();

			location.href="<%=request.getContextPath()%>/noticeDetail.ad?nNo=" + nNo;
			
		})
		<%}%>
	})
</script>
</body>
</html>