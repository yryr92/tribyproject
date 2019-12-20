<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.triby.host.model.vo.Host" %>
<%
	ArrayList<Host> list = (ArrayList<Host>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>정산</title>
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
        .cContent{
            background-color:white;
            width:1500px;
            margin-left:auto;
            margin-right:auto;
            margin-top:30px;
            padding-bottom:30px;
        }
        .dateWrap{
            margin-left:80px;
        }
        .cContent table{
            border:1px solid black;
            text-align: center;
            margin-left:auto;
            margin-right:auto;
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
                <h1 class="aTitle">정산</h1>
                <br>
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
                <div class="dateWrap">
<!--                     <form action="" method="post">
                        <input type="date" name="startDate"> - <input type="date" name="lastDate"> <input type="submit" value="검색">
                    </form> -->
<!--                     <div class="cSearch">
                        <form action="" method="GET">
                            <select name="tag" id="tag">
                                <option value="host_no">호스트</option>
                                <option value="name">예금주</option>
                            </select>
                            <input type="text" name="host_no">
                            <input type="submit" value="검색">
                        </form>
                    </div>
                </div>  -->
                
                
                <div class="cContent">
                <h3>정산대기중</h3>
                    <table id="calTableArea">
                        <tr>
                            <!-- <td width="150px">정산번호</td> -->
                            <th width="150px">호스트번호</th>
                            <th width="150px">예금주</th>
                            <th width="150px">은행명</th>
                            <th width="200px">계좌번호</th>
                            <th width="200px">트리비이름</th>
                            <th width="100px">옵션번호</th>
                            <!-- <th width="150px">정산금액</th> -->
                            <!-- <th width="150px">정산여부</th> -->
                        </tr>
						<%if(list.isEmpty()) { %>
							<tr>
								<td colspan="8">내역이 없습니다</td>
							</tr>
						<%}else { %>
							<%for(Host h : list) { %>
								<tr>
									<td><%=h.getHost_no() %></td>
									<td><%=h.getHost_accountName() %></td>
									<td><%=h.getBank_name() %></td>
									<td><%=h.getAccount() %></td>
									<td><%=h.getHost_name() %></td>
									<td><%=h.getLike_count() %></td>
									<%-- <td><%=h.getReport_count() %></td> --%>
									<%-- <td><%=h.getApproval() %></td> --%>
								</tr>
							<%} %>
						<%} %>
                    </table>

                </div>
            </div>
        </div>    
    </div>
    <script>
    	$(document).ready(function() {
    		//from pak 10/12
    		<%if(!list.isEmpty()) {%>
    		$("#calTableArea td").mouseenter(function() {
    			$(this).parent().css({background:"#f5f5f5",cursor:"pointer"});
    		}).mouseout(function() {
    			$(this).parent().css("background","white");
    		}).click(function() {
    			var tOno = $(this).parent().children().eq(5).text();
    			console.log(tOno);
<%--     			location.href="<%=request.getContextPath()%>/updateCal.ad?tOno="+ tOno; --%>
    		})
    		<%}%>
    		//end pak 10/12
    	})   </script>
</body>
</html>