<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.triby.report.model.vo.Report, java.util.ArrayList, com.triby.common.PageInfo" %>
<%
	ArrayList<Report> list = (ArrayList<Report>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	
	String message = (String)session.getAttribute("black");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>신고</title>
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
        .rContent{
            background-color:white;
            width:1500px;
            margin-left:auto;
            margin-right:auto;
            margin-top:30px;
            padding-bottom:30px;
        }
        .rContent table{
            border:1px solid black;
            text-align: center;
            margin-left:auto;
            margin-right:auto;
        }
        .btn:hover{cursor:pointer;}
    </style>
<script>
	$(document).ready(function() {
		var msg = "<%= message %>";
	
		if(msg != "null") {
			alert(msg);
		
			<% session.removeAttribute("black");%>
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
                <h1 class="aTitle">신고</h1>
                <div class="tagWrap">
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/report.ad';">
                    	<div class="btn" id="report_btn">신고내역</div></button>
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/blacklist.ad';">
                    	<div class="btn" id="blacklist_btn">블랙리스트</div></button>
                </div>
                <div class="rContent">
                    <h3>신고내역</h3>
                    <table id="reportTableArea">
                        <tr>
                            <th width="100px">번호</th>
                            <th width="150px">신고자</th>
                            <th width="150px">신고자이름</th>
                            <th width="150px">대상자</th>
                            <th width="150px">대상자이름</th>
                            <th width="600px">상세</th>
                            <th width="150px">신고일</th>
                        </tr>
                        <%if(list.isEmpty()) { %>
                        <tr>
                            <td colspan="5">신고내역이 없습니다</td>

                        </tr>
                        <%}else {%>
                        <%for(Report r : list) { %>
                        <tr>
                            <td><%=r.getrNo() %></td>
                            <td><%=r.getrReporter() %></td>
                            <td><%=r.getUserName() %></td>
                            <td><%=r.getrTarget() %></td>
                            <td><%=r.getHostName() %></td>
                            <td><%=r.getrDetail() %></td>
                            <td><%=r.getrDate() %></td>
                        </tr>
                        <%} %>
                        
                        <%} %>

                    </table>
                    각 행 선택시 블랙리스트로 이동 대상자 자동입력
                </div>
                <br clear="both">
                <div class="pagingArea" align="center">
                	<button onclick="location.href='<%=request.getContextPath()%>/report.ad?currentPage=1';">&lt;&lt;</button>
                	<%if(currentPage ==1) { %>
                		<button disabled>&lt;</button>
                	<%}else { %>
                		<button onclick="location.href='<%=request.getContextPath()%>/report.ad?currentPage=<%=currentPage-1%>';">&lt;</button>
                	<%} %>
                	
                	<%for(int p = startPage;p<=endPage;p++) { %>
                		<%if(p == currentPage) { %>
						<button disabled><%=p %></button>                	
                	<%}else { %>
                		<button onclick="location.href='<%=request.getContextPath()%>/report.ad?currentPage=<%=p%>';"><%=p %></button>
                	<%} %>
                	<%} %>
                
                	<%if(currentPage == maxPage) { %>
                		<button disabled>&gt;</button>
                	<%}else { %>
                		<button onclick="location.href='<%=request.getContextPath()%>/report.ad?currenPage=<%=currentPage+1%>';">&gt;</button>
                	<%} %>
                	<button onclick="location.href='<%=request.getContextPath() %>/report.ad?currentPage=<%=maxPage %>';">&gt;&gt;</button>
                </div>
            </div>
        </div>    
    </div>

<script>
	$(document).ready(function() {
		<%if(!list.isEmpty()) { %>
		$("#reportTableArea td").mouseenter(function() {
			$(this).parent().css({background:"#f5f5f5",cursor:"pointer"});
		}).mouseout(function() {
			$(this).parent().css("background","white");
		}).click(function() {
			var target = $(this).parent().children().eq(3).text();
			var bool = confirm("블랙리스트에 등록하시겠습니까 ")
			if(bool) {
				
			location.href="<%=request.getContextPath()%>/insertBlacklist.ad?target=" + target;
			}
		})
		<%}%>
	})
</script>
</body>
</html>