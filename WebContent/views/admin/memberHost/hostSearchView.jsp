<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.triby.host.model.vo.Host,com.triby.common.PageInfo" %>
<%
	ArrayList<Host> list = (ArrayList<Host>)request.getAttribute("list");

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>호스트 관리</title>
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
        button:hover{cursor:pointer;}
        #searchHostbtn:hover{cursor:pointer;}
    </style>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
               <h1 class="aTitle">회원관리</h1>
                <div class="tagWrap">
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/member.ad';">
                    	<div class="btn" id="report_btn">전체회원조회</div></button>
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/host.ad';">
                    	<div class="btn" id="blacklist_btn">전체호스트조회</div></button>
                </div>
                <div class="searchHostForm">
                       <form action="<%=request.getContextPath() %>/searchHost.ad" method="POST">
       					  <select name="selectSearch" required>
       					  		
       					  		<option value="selectHostNo">호스트번호</option>
       					  		<option value="selectHostName">이름</option>
       					  </select>
                          <input type="search" name="searchHostInput" id="searchHostInput">
                          <input type="submit" value="전체검색" id="searchHostbtn">
                       </form>
                 </div>
                <div class="notice">
                    <table id="hostTableArea">
                        <tr>
                            <th width="150px">호스트번호</th>
                            <th width="100px">이메일</th>
                            <th width="100px">상호명</th>
                            <th width="100px">이름</th>
                            <th width="100px">전화번호</th>
<!--                             <th width="100px">좋아요갯수</th>
                            <th width="100px">누적신고횟수</th> -->
                            <th width="100px">가입일</th>
                            <th width="100px">탈퇴여부</th>
                            <th width="100px">소개글</th>
                            <th width="100px">승인여부</th>
                        </tr>
                        <%if(list.isEmpty()) { %>
                        <tr>
                        	<td colspan="9">해당 호스트가 없습니다</td>    
                        </tr>
                        <%}else { %>
                        
                        <%for(Host h : list) { %>
                        
                        <tr>
                            <td ><%=h.getHost_no() %></td>
                            <td ><%=h.getHost_email() %>
                            <td ><%=h.getHost_sName() %></td>
                            <td ><%=h.getHost_name() %></td>
                            <td ><%=h.getHost_phone() %>
<%--                             <td ><%=h.getLike_count()%></td>
                            <td ><%=h.getReport_count()%></td> --%>
                            <td ><%=h.getEnroll_date() %></td>
                            <td ><%=h.getStatus() %></td>
                            <td ><%=h.getHost_introduce() %></td>
                            <%if(h.getApproval().equals("N")) { %>
                            <td>승인하기</td>
                            <%}else if(h.getApproval().equals("Y")){ %>
                            <td>승인취소</td>
                            <%} %>
                        </tr>
                        <%} %>
                        <%} %>
                    </table>
                </div>
            </div>
        </div>    
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		<%if(!list.isEmpty()) {%>
		$("#hostTableArea td").mouseenter(function() {
			$(this).parent().css({background:"#f5f5f5",cursor:"pointer"});
		}).mouseout(function() {
			$(this).parent().css("background","white");
		}).click(function() {
			var hostNo = $(this).parent().children().eq(0).text();
			var approval = $(this).parent().children().eq(8).text();
			console.log(approval);
			if(approval == "승인하기") {
				if(confirm("호스트를 승인하시겠습니까")) {
				location.href="<%=request.getContextPath()%>/approveHost.ad?hostNo=" + hostNo;			
			}	
			}else if(approval == "승인취소"){
				if(confirm("승인을 취소하시겠습니까")) {
					location.href="<%=request.getContextPath()%>/approveHost.ad?disapproval=Y&hostNo=" + hostNo;	
				}
			}	
			})
			<%}%>
		})

</script>
</body>
</html>