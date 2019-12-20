<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>공지사항 작성하기</title>
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
        .noticeWrite{
            background-color:white;
            height:700px;
            width:1500px;
            margin-left:auto;
            margin-right:auto;
        }
		.btns:hover{cursor:pointer;}
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
                <div class="noticeWrite">
                    <form action="<%=request.getContextPath() %>/insertNotice.ad" method="POST" id="writeForm">
                        <section>
                            <table>
                                <tr>
                                    <th>제목</th>
                                    <th><input type="text" id="nTitle" name="nTitle" ></th>
                                    <th>분류</th>
                                    <th><select name="nCategory" id="noticeTag">
                                        <option value="공지">공지</option>
                                        <option value="이벤트">이벤트</option>
                                        <option value="호스트">호스트</option>
                                    </select></th>
                                    <th>게시여부</th>
                                    <th><select name="nStatus" id="status">
                                        <option value="N">비공개</option>
                                        <option value="Y">공개</option>
                                    </select></th>
                                </tr>
                            </table>
                        </section>
                        <section>
                            <h3>내용</h3>
                            <textarea name="nContent" id="" cols="100" rows="30"></textarea>
                        </section>
        
                        <input type="submit" value="작성" class="btns">
                        <input type="button" value="취소" class="btns" onclick="javascript:history.back();">
						
                    </form>
                </div>
            </div>
        </div>
    </div>    
</body>
</html>