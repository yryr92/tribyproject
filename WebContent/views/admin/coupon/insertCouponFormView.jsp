<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<%
	Date now = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일");
	String today = sdf.format(now);
	
	String userNo = (String)request.getAttribute("userNo");
	String couponNo = (String)request.getAttribute("couponNo");
	
	String successMsg = (String)request.getAttribute("successCoupon");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠폰발급</title>
<style>
	button:hover{cursor:pointer;}
</style>
</head>
<script>
	var msg = "<%=successMsg%>"
	if(msg != "null") {
		alert(msg);
		close();
	}
</script>
<body>
    <!-- open(새창크기지정) -->
    <h3 align="center">쿠폰 보내기</h3>
    <br>
    <div class="updatePw" align="center">
        <hr>
        <form action="<%=request.getContextPath() %>/insertCoupon.ad" method="post">
            <table>
                <tr>
                    <td>쿠폰번호</td>
                    <td>
                        <input type="text" id="couponNo" name="couponNo" value="<%=couponNo %>"readonly>
                    </td>
                </tr>
                <tr>
                    <td>쿠폰명(5글자이내)</td>
                    <td>
                        <input type="text" name="couponName" required>
                    </td>
                </tr>
                <tr>
                    <td>할인금액</td>
                    <td>
                        <input type="text" name="discountRate" required>
                    </td>
                </tr>
                <tr>
                    <td>발급일</td>
                    <td>
                        <input type="text" value="<%=today %>" readonly>
                    </td>
                </tr>
                 <tr>
                    <td>만료일</td>
                    <td>
                        <input type="date" name="couponEnd">
                    </td>
                </tr>
				<tr>
                    <td>회원번호</td>
                    <td>
                        <input type="text" id="userNo" name="userNo" value="<%=userNo %>" readonly>
                    </td>
                </tr>
            </table>
            <br>
            <div align="center">
                <button type="submit">등록하기</button>
                <button onclick="window.close()">취소</button>
            </div>
        </form>
    </div>
</body>
</html>