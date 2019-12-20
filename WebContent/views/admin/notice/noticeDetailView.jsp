<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.triby.notice.model.vo.Notice"%>
<%
	Notice notice = (Notice)request.getAttribute("notice");
	
	String[] category = new String[3];
	switch(notice.getnCategory()) {
	case "공지"  : category[0] = "selected"; break;
	case "이벤트" : category[1] = "selected"; break;
	case "호스트" : category[2] = "selected"; break;
	}
	
	String[] status = new String[2];
	switch(notice.getnStatus()) {
	case "Y" : status[0] = "selected"; break;
	case "N" : status[1] = "selected"; break;
	}
	
	int nNo = notice.getnNo();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>공지사항 상세보기</title>
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
                    <form action="<%=request.getContextPath() %>/updateNotice.ad?nNo=<%=nNo %>" method="POST" id="writeForm">
                        <section>
                            <table>
                                <tr>
                                    <th>제목</th>
                                    <th><input type="text" id="nTitle" name="nTitle" value="<%=notice.getnTitle() %>"></th>
                                    <th>분류</th>
                                    <th><select name="nCategory" id="noticeTag">
                                        <option value="공지" <%=category[0] %>>공지</option>
                                        <option value="이벤트" <%=category[1] %>>이벤트</option>
                                        <option value="호스트" <%=category[2] %>>호스트</option>
                                    </select></th>
                                    <th>게시여부</th>
                                    <th><select name="nStatus" id="status">
                                        <option value="N" <%=status[1] %>>비공개</option>
                                        <option value="Y" <%=status[0] %>>공개</option>
                                    </select></th>
                                </tr>
                            </table>
                        </section>
                        <section>
                            <h3>내용</h3>
                            <textarea name="nContent" id="" cols="100" rows="30"><%=notice.getnContent() %></textarea>
                        </section>
        
                        <input type="submit" value="수정" class="btns">
                        <input type="button" value="취소" class="btns" onclick="javascript:history.back();">
                        <input type="button" value="삭제" class="btns" onclick="deleteNotice()">
						
                    </form>
                </div>
            </div>
        </div>
    </div>
    
<script>
	function deleteNotice() {
		var bool = confirm("정말로 삭제 하시겠습니까");
		if(bool) {
			location.href="<%=request.getContextPath()%>/deleteNotice.ad?nNo=<%=nNo%>";
		}else {
			location.href="javascript:history.back()";
		}
	}
</script>    
</body>
</html>