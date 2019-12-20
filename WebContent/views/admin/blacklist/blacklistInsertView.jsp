<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.triby.blackList.model.vo.BlackList" %>    
<%
	ArrayList<BlackList> list = (ArrayList<BlackList>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>블랙리스트</title>
<script src="https://ajax/googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
            margin-top:30px;
        }
        .rContent table tr th button{
            margin-left:auto;
            margin-right:auto;
        }
        .blacklistForm{
            float:right;
        }
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
                    <button type="button" onclick="location.href='<%=request.getContextPath() %>/blacklist.ad';">
                    	<div class="btn" id="blacklist_btn">블랙리스트</div></button>
                </div>
                <div class="rContent">
                    <h3>블랙리스트</h3>
                    <div class="blacklistForm">
                        <form action="" method="POST">
                            <input type="text" name="black_no" id="black_no">
                            <!-- <input type="submit" value="추가"> -->

                            <input type="button" id="deleteInput" value="제거">
                            <input type="button" value="검색">
                        </form>
                    </div>
                    <table>
                        <tr>
                            <th width="150px">번호</th>
                            <th width="150px">블랙리스트</th>
                            <th width="150px">이관일</th>
                            <th width="100px">선택</th>
                        </tr>
                        <%for(BlackList bk :list) { %>
                        
                        <tr>
                            <td><%=bk.getBlack_no() %></td>
                            <td><%=bk.getBlack_target() %></td>
                            <td><%=bk.getBlack_date() %></td>
                            <td><button type="button">선택</button></td>
                        </tr>
                        <%} %>
                    </table>
                    선택누르면 input value에 아이디 입력
                </div>
            </div>
        </div>    
    </div>
</body>
</html>