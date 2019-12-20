<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.triby.member.model.vo.Member,com.triby.common.PageInfo" %>
<%
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>검색한 회원 리스트</title>
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
		#searchMembtn:hover{cursor:pointer;}
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
                <h1 class="aTitle">회원관리</h1>
                <div class="tagWrap">
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/member.ad';">
                    	<div class="btn" id="report_btn">전체회원조회</div></button>
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/host.ad';">
                    	<div class="btn" id="blacklist_btn">전체호스트조회</div></button>
                </div>
                <div class="searchMemberForm">
                       <form action="<%=request.getContextPath() %>/searchMem.ad" method="POST">
       					  <select name="selectSearch" required>
       					  		
       					  		<option value="selectUserId">회원번호</option>
       					  		<option value="selectUserName">이름</option>
       					  </select>
                          <input type="search" name="searchMemInput" id="searchMemInput">
                          <input type="submit" value="전체검색" id="searchMembtn">
                       </form>
                 </div>
                <div class="notice">
                    <table id="userTableArea">
                        <tr>
                            <th width="150px">회원번호</th>
                            <th width="100px">이메일</th>
                            <th width="100px">이름</th>
                            <th width="100px">성별</th>
                            <th width="100px">생년월일</th>
                            <th width="100px">전화번호</th>
                            <th width="100px">관심사</th>
                           <!--  <th width="100px">누적신고횟수</th> -->
                            <th width="100px">가입일</th>
                            <th width="100px">탈퇴여부</th>

                            <th width="100px">쿠폰</th>

                            

                        </tr>
                        <%if(list.isEmpty()) { %>
                        <tr>
                        	<td colspan="10">해당 회원이 없습니다</td>
                        </tr>
                        <%}else { %>
                        
                        <%for(Member m : list) { %>
                        <tr>
<!--start from pak 10/09  -->
                            <td ><%=m.getuNo() %></td>
                            <td ><%=m.getEmail() %>
                            <td ><%=m.getName() %></td>
                            <td ><%=m.getGender() %></td>
                            <td ><%=m.getBirth()%></td>
                            <td ><%=m.getPhone()%>
                            <td ><%=m.getCategory()%></td>
                            <%-- <td ><%=m.getUsre_reported_count() %></td> --%>
                            <td ><%=m.getRegisterDate() %></td>
                            <td ><%=m.getStatus() %></td>
<!--end from pak 10/09  -->
                            <td>쿠폰보내기</td>

                            

                        </tr>
                        <%} %>
                        <%} %>
                    </table>
                </div>
            </div>
        </div>    
    </div>
    
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<form action="<%=request.getContextPath() %>/insertCouponForm.ad" method="post" target="openW" id="sendCouponForm" >
			<input type="hidden" id= "userNo" name="userNo">
			<input type="hidden" id="couponNo" name= "couponNo">
		</form>
<script>
	$(document).ready(function() {

		<%if(!list.isEmpty()) {%>	
		<%
		int couponNo = (int)(Math.random()*1000000000+1);
		%>
		$("#userTableArea td").mouseenter(function() {
			$(this).parent().css({background:"#f5f5f5",cursor:"pointer"});
		}).mouseout(function() {
			$(this).parent().css("background","white");
		}).click(function() {
			
			var userNo = $(this).parent().children().eq(0).text();
			var couponNo = "<%=couponNo%>"
			if(confirm("해당 회원에게 쿠폰을 발급하시겠습니까")) {
				
			$("#userNo").val(userNo);
			$("#couponNo").val(couponNo);
			console.log(userNo);
			$("#sendCouponForm").submit();
			var openW = open("","쿠폰발급","width=500,height=400");
			}
		})
		<%}%>
		})
		
</script>

</body>
</html>