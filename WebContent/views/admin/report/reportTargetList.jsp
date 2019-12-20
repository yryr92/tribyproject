<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.triby.report.model.vo.Report, java.util.ArrayList" %>
<%
	ArrayList<Report> list = (ArrayList<Report>)request.getAttribute("list");
	int target = (int)request.getAttribute("target");	
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
            display:block;
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
        .blacklistForm{
            float:right;
        }
        .btn:hover{cursor:pointer;}
        #goback:hover{cursor:pointer;}
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
                <h1 class="aTitle">신고</h1>
                <div class="tagWrap">
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/report.ad';">
                    	<div class="btn" id="report_btn">신고내역</div></button>
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/blacklist.ad';">
                    	<div class="btn" id="blacklist_btn">블랙리스트</div></button>
                </div>
                <div class="rContent">
                    <h3>조회내역</h3>
                    <div class="blacklistForm">
                        <form action="" method="POST">
                            <input type="text" name="black_no" id="black_no" value="<%=target %>" readonly>
                            
                            <input type="button" value="뒤로 " id="goback" onclick="javascript:history.back()">
                           <!--  <input type="button" value="검색" onclick="searchBlackFunction()"> -->
                        </form>
                    </div>
                    <table id="reportTableArea">
                        <tr>
                            <th width="100px">번호</th>
                            <th width="150px">신고자</th>
                            <th width="150px">신고자이름</th>
                            <th width="900px">상세</th>
                            <th width="150px">신고일</th>
                        </tr>
                        <%if(list.isEmpty()) { %>
                        <tr>
                            <td colspan="5">내역이 없습니다</td>

                        </tr>
                        <%}else {%>
                        <%for(Report r : list) { %>
                        	<%String[] srr = new String[2];
                        		srr = r.getrDetail().split("/");
                        		String detail = srr[0];
                        		String name = srr[1];
                        	%>
                        <tr>
                            <td><%=r.getrNo() %></td>
                            <td><%=r.getrReporter() %></td>
                            <td><%=name%></td>
                            <td><%=detail %></td>
                            <td><%=r.getrDate() %></td>
                        </tr>
                        <%} %>
                        
                        <%} %>

                    </table>

                </div>
            </div>

        </div>    
    </div>

</body>
</html>