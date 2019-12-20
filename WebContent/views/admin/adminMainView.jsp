<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<%
	Date now = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 hh:mm E요일");
	String today = sdf.format(now);
	
	//String calMsg = (String)session.getAttribute("calMsg"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <title>관리자 페이지</title>
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
            input{text-align:right;}
    table{border-collapse:collapse; width:80%; height:50px;}
    table,th,td{border:1px solid #ddd; padding:8px;text-align:center}
    
    button:hover{cursor:pointer;}
    </style>
<%--     <script>
    	$(document).ready(function() {
    		var calMsg = "<%=calMsg%>";
    		if(calMsg != "null") {
    			alert(calMsg);
    			<%session.removeAttribute("calMsg");%>
    		}
    	})
    </script> --%>
    
</head>
<body>
<%@include file="../admin/adminHeader.jsp" %>
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
                    	<div class="btn" id="all_notice_btn">전체</div></button>
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/notice.ad?selected=공지';">
                    	<div class="btn" id="notice_btn">공지</div></button>
                    <button type="button" onclick="location.href='<%=request.getContextPath() %>/notice.ad?selected=이벤트';">
                    	<div class="btn" id="event_notice_btn">이벤트</div></button>
                    <button type="button" onclick="location.href='<%=request.getContextPath() %>/notice.ad?selected=호스트';">
                    	<div class="btn" id="host_notice_btn">호스트</div></button>
                    <button type="button" onclick="location.href='<%=request.getContextPath() %>/notice.ad?selected=N';">
                    	<div class="btn" id="secret_notice_btn">비공개</div></button>
                    
                    <div class="write"><button type="button" onclick="location.href='<%=request.getContextPath()%>/insertNoticeForm.ad';"><div class="btn" id="write_notice">공지 작성</div></button></div>
                </div>
              	<hr clear="both">
            	<div class="startInfoArea">
            		<h4 align="center"><%=today %></h4>

            		<table align="center">
                    <tr>
                        <td>전체회원수</td>
                        <td>
                            <input type="email" id="userEmail" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>신규회원수</td>
                        <td>
                            <input type="text" id="newMem" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>신규호스트</td>
                        <td>
                            <input type="text" id="name" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>신규트리비</td>
                        <td>
                            <input type="text" id="gender"  readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>인기트리비</td>
                        <td>
                            <input type=datetime id="birthdate"  readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>인기호스트</td>
                        <td>
                            <input type="text" id="phone" readonly>
                        </td>
                    </tr>
<!--                     <tr>
                        <td></td>
                        <td>
                            <input type="file" name="profile" value="image">
                        </td>
                    </tr> -->
                    </table>
            	</div>
    			
            </div>
        </div>    
    </div>
    <script>
    	$(document).ready(function() {
    		$.ajax({
    			url:"infoAjax.ad",
    			method:"post",
    			dataType:"text",
    			success:function(string) {
    				$("#userEmail").val(string);
    			},
    			error:function() {
    				console.log("error");
    			}
    		})
    		
    		$.ajax({
    			url:"infoAjaxtwo.ad",
    			method:"post",
    			dataType:"text",
    			success:function(string) {
    				$("#newMem").val(string);
    			}
    		})
    		
    		$.ajax({
    			url:"infoAjaxthree.ad",
    			method:"post",
    			dataType:"text",
    			success:function(string) {
    				$("#name").val(string);
    			}
    		})
    		
    		$.ajax({
    			url:"infoAjaxfour.ad",
    			method:"post",
    			dataType:"text",
    			success:function(string) {
    				$("#gender").val(string);
    			}
    		})
    		
    		$.ajax({
    			url:"infoAjaxPop.ad",
    			method:"post",
    			dataType:"text",
    			success:function(string) {
    				$("#birthdate").val(string);
    			}
    		})
    		
    		$.ajax({
    			url:"infoAjaxPopTwo.ad",
    			method:"post",
    			dataType:"text",
    			success:function(string) {
    				$("#phone").val(string);
    			}
    		})
    	})
    </script>
</body>
</html>