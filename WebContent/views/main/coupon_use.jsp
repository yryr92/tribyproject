<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.triby.member.model.vo.*, com.triby.coupon.model.vo.*"%>
<%
	String contextPath = request.getContextPath();
	ArrayList<Coupon> uC = (ArrayList<Coupon>)request.getAttribute("uC");	// 쿠폰 정보
	Member user = (Member)request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/custom.css">
    <title>TRIBY</title>
<style>
    a{
        text-decoration: none;
    }
    body{
        width:100%;
    }
    #body{
        width:100%;
        margin:0 auto;
        border: 0px solid black;
    }
    #title_line{
        height: 50px;
        border-bottom: 0px solid black;
        margin-top:20px;
    }
    .title_font{
        font-size: 20px;
        margin-left: 20px;
        font-weight: bold;
    }
    #coupon_choice{
        margin: 0 auto;
        height:300px;
        width:95%;
        overflow: scroll;
    }
    .coupon_info{
        height:20%;
        
    }
    #radio{
        margin-left:20px;
        margin-top:20px;
        float: left;
    }
    #cNum{
	    margin-left: 20px;
        margin-top:15px;
	    float: left;
	    width: 5%;
    }
    #cEnd{
        margin-top:15px;
        font-size: 15px;
        font-weight: bolder;
        float: left;
    }
    #cSale{
        margin-right: 20px;
        margin-top:15px;
        font-size: 15px;
        font-weight: bolder;
        float: right;
        text-align:right;
        width: 30%;
    }
    #coupon_use{
        margin: 0 auto;
        height:50px;
        width:80%;
        border: 0px;
    }
    #cUse{
        height:100%;
        width:100%;
        background-color:#18BC9C;
        border: 0px;
        color:white;
        border-radius:4px;
    }
    .coInfo{
    	width: 40%;
    	border:0px;
    }
    #coName{
    	width:40%;
    	float:left;
    	text-align:right;
    }
    #coSale{
    	width:30%;
    	float:right;
    	text-align:center;
    }
    #coInfoTitle{
    	width:95%;
    	height:30px;
    }
</style>
</head>
<body>

    <body>
        <div id="body">
            <!-- 쿠폰 제목 틀 -->
            <div id="title_line">
                <div class="title_font">쿠폰 선택</div>
            </div>
            <div id="coInfoTitle">
	            <div id="coName">쿠폰번호/쿠폰명</div>
            	<div id="coSale">할인액</div>
           	</div>
            <!-- 쿠폰 선택란 -->
            <div id="coupon_choice">
        	<form method="get" name="coupon">
            	<% for(int i=0; i<uC.size(); i++){ %>
                <div class="coupon_info">
                    <input id="radio" type="radio" name="coupon"></input>
                    <input type="text" id="cNum" name="cNo" class="coInfo" value="<%=uC.get(i).getcNo()%>" readonly>
	                <input type="text" id="cEnd" name="cTitle" class="coInfo" value="<%=uC.get(i).getcName()%>" readonly>
                    <input type="text" id="cSale" name="cSale" class="coInfo" value="<%=uC.get(i).getDiscountRate()%>" readonly>
                </div>
                <%} %>
            </form>
            </div>
            <br>
            <!-- 쿠폰 사용하기 버트 -->
            <div id="coupon_use">
                <input type="button" id="cUse" type="submit" value="사용하기" onclick="Coupon()">
            </div>
        </form>
        </div>
    </body>
    
    <script>
    	function Coupon(){
    		opener.document.getElementById("cNo").value = document.getElementById("cNum").value;
    		opener.document.getElementById("cName").value = document.getElementById("cEnd").value;
    		opener.document.getElementById("cDis").value = document.getElementById("cSale").value;
    		opener.document.getElementById("pay_price").value =  (opener.document.getElementById("price").value - document.getElementById("cSale").value);
    		window.close();

    	}
    </script>
    
</body>
</html>