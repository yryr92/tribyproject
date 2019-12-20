<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int uNo = (int) request.getAttribute("uNo");
	int hNo = (int) request.getAttribute("hNo");
	String msg = (String) request.getAttribute("msg");
%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="resources/js/popper.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<script>
	var msg = "<%= msg%>"; // "" 꼭 감싸주기
	
	$(function(){
		if(msg != "null") { // 메세지가 담겨있을 경우
			alert(msg);
		} 
		
		if(msg == "신고가 성공적으로 완료되었습니다.") {
			close();
		}
	})
</script>
<style>
    button {cursor:pointer;}
    body{width:500px; height:400px; font-family: 'Noto Sans KR', sans-serif;}
    #etcArea{width:100%; height:100px;}
	#footer{text-align:center;}
	#reportWrite{width:100%; height:100%;}
	h4{color:white;}
	.report{padding-left:20px;}
</style>
<body>
	<div id="all">
   <div id="header" class="navbar navbar-expand-lg navbar-dark bg-primary"><h4>신고하기</h4></div>
    <hr>
    <div class="report">
        <b>신고사유</b><br>
        <form action="insertbyh.rep" method="post">
        <input type="hidden" name="uNo" value="<%= uNo%>">
        <input type="hidden" name="hNo" value="<%= hNo%>">
            <input type="radio" name="report" value="영리목적/홍보성" id="re1">
            <label for="re1">영리목적/홍보성</label><br>
            <input type="radio" name="report" value="불법정보" id="re2">
            <label for="re2">불법정보</label><br>
            <input type="radio" name="report" value="음란성/선정성" id="re3">
            <label for="re3">음란성/선정성</label><br>
            <input type="radio" name="report" value="욕설/인신공격" id="re4">
            <label for="re4">욕설/인신공격</label><br>
            <input type="radio" name="report" value="개인정보노출" id="re5">
            <label for="re5">개인정보노출</label><br>
            <input type="radio" name="report" value="반복개시/도배" id="re6">
            <label for="re6">같은 내용의 반복 개시(도배)</label><br>
            <input type="radio" name="report" value="기타" id="re7">
            <label for="re7">기타</label><br>
  			<div id="etcArea"><textarea name="etc" id="reportWrite" style="resize:none" placeholder="기타 항목 선택후 입력해 주세요(최대 500자)"></textarea></div>
            <br>
            <hr>
            	<div id="footer">무분별한 신고는 관리자를 힘들게 합니다ㅠ</div>
            <div class="re_btns" align="center"><br>
                <button class="btn btn-primary" type="submit">신고</button><br><br>
            </div> 
               </form>
    </div>
    </div>
    <script>


	</script>
</body>
</html>