<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.triby.payment.model.vo.Payment,java.util.Date,java.text.SimpleDateFormat" %>    
<%
	ArrayList<Payment> list = (ArrayList<Payment>)request.getAttribute("list");
	String past = (String)request.getAttribute("past");
	Date today = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MM");
	String present = sdf.format(today);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
</head>
<body>
<%@include file ="../adminHeader.jsp" %>
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
				<h1 class="aTitle">정산</h1>
			    <div class="tagWrap">
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/calculate.ad';">
                    	<div class="btn" id="blacklist_btn">결제내역조회</div></button>
	                <button type="button" onclick="location.href='<%=request.getContextPath()%>/calculateList.ad';">
                    	<div class="btn" id="blacklist_btn">정산대기중</div></button>
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/doCalculate.ad';">
                    	<div class="btn" id="report_btn">정산하기</div></button>
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/calListView.ad';">
                    	<div class="btn" id="blacklist_btn">정산내역조회</div></button>
                </div>
				<div class="rContent">
					<h3 align="center"><%=past %>월 16일부터 <%=present%>월 15일까지의 결제내역조회</h3>
				 	<table>
				 		<tr>
				 			<th width="200px">결제번호</th>
				 			<th width="200px">결제일</th>
				 			<th width="200px">회원명</th>
				 			<th width="200px">옵션번호</th>
				 			<th width="200px">최종금액</th>
				 			<th width="200px">결제여부</th>
				 		</tr>
                       	<%if(list.isEmpty()) { %>
                       	<tr>
                       		<td colspan="6">정산하지 않은 결제 내역이 없습니다</td>
                       	</tr>
                       	<%}else { %>
                       	<%for(Payment p : list) { %>
                       	<tr>
                       		<td><%=p.getpNo() %></td>
                       		<td ><%=p.getpDate() %></td>
                       		<td ><%=p.getpInfo()%></td>
                       		<td ><%=p.gettONo() %></td>
                       		<td ><%=p.getpFinal() %></td>
                       		<td><%=p.getStatus() %></td>
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