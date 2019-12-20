<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.triby.triby.model.vo.*, com.triby.coupon.model.vo.*"%>    
<%
	int tNo = (int)request.getAttribute("tNo");			// 트리비 번호
	int oNo = (int)request.getAttribute("oNo");			// 옵션 번호
	String tDay = (String)request.getAttribute("tDay");	// 트리비 시작날짜+시간
	int person = (int)request.getAttribute("person");	// 사람 수
	int tPayment = (int)request.getAttribute("tPayment");	// 가격
	Member user = (Member)request.getAttribute("loginUser");	// 회원 정보
	
	ArrayList<Coupon> uC = (ArrayList<Coupon>)request.getAttribute("uC");					// 쿠폰 정보
	ArrayList<ThumbnailTriby> pt = (ArrayList<ThumbnailTriby>)request.getAttribute("pt");	// 썸네일
	
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript"></script>
    <!-- 결제 관련 -->
	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
	
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
        width:50%;
        margin:0 auto;
        border: 0px solid black;
    }
    #title_line{
        height: 50px;
        border-bottom: 1px solid black;
    }
    .title_font{
        font-size: 20px;
        margin-left: 20px;
        font-weight: bold;
    }
    #triby_line{
        height: 200px;
        margin-left: 20px;
        border-bottom: 0px solid black;
    }
    #other_triby1{
        border: 0px solid blue;
        height:100%;
    }
    .other_triby1_img{
        height:100%;
        width: 33.3%;
        float: left;
    }
    .other_triby1_text{
        height:40%;
        width:50%;
        float: left;
    }
    #cash_line{
        height: 40px;
    }
    #price_title{
        width: 60px;
        float: left;
    }
    #price{
        float: right;
        margin-right:20px;
    }
    #coupon_line{
        height: 50px;
    }
    #coupon_title{
        float: left;
    }
    .coupon_price{
        float:right;
        margin-right:10px;
         width: 200px;
         text-align:right;
         border:0px;
    }
    #coupon_btn{
        float:right;
        margin-right:20px;
    }
    #sale_bar, #pay_bar{
        height: 30px;
    }
    #sale_title, #pay_title{
        float:left;
    }
    #sale_price, #pay_price{
        float:right;
        margin-right:20px;
    }
    #pway_btn_line{
        text-align: center;
    }
    #pway_btn_line button{
        margin-right:20px;
        height: 40px;
    }
    #agree_line{
        text-align:center;
        font-size:15px;
    }
    #payment_btn_line{
        text-align:center;
    }
    #pay_btn{
        height: 50px;
        width: 50%;
    }
    #cName{
    	width: 
    }
    #cNo{
    	float:left;
    	width:50px;
    	text-align:left;
    }
</style>
</head>
<body>
    <body>
    <%@ include file="../common/header.jsp" %>
        <div id="body1">
            <!-- 결제 페이지 제목 틀 -->
            <div id="title_line">
                <div class="title_font">결제</div>
            </div>
            <!-- 선택한 트리비 글자 틀 -->
            <div id="choice_line">
                <br>
                <div class="title_font">선택한 트리비</div>
            </div>
            <hr>
            <!-- 트리비 간략하게 보여주는 틀 -->
            <div id="triby_line">
                <div id="pay_triby1">
                    <div class="pay_triby1_img">
                        <img src="<%=contextPath%>/resources/images/triby/<%=pt.get(0).gettImg()%>" width ="95%" height="100%">
                    </div>
                    <div class="pay_triby1_text">
                        <div class="title_font"><%=pt.get(0).gettName()%></div>
                        <br>
                        <div class="title_font"><%=tDay%></div>
                    </div>
                </div>
            </div>
            <hr>
            <!-- 금액 보여주는 틀 -->
            <div id="cash_line">
                <div class="title_font" id="price_title">금액</div>
                <input type="text" class="coupon_price" id="price" value="<%=tPayment%>" readonly>
            </div>
            <hr>
            <!-- 쿠폰 보여주는 틀 -->
            <div class="title_font" id="coupon_line">
                <div id="coupon_title">쿠폰</div>
                <input type="text" class="coupon_price" id="cNo" value="0" readonly>
                <div id="coupon_btn"><button class="btn btn-success" id="cbtn" onclick="window.open('<%=request.getContextPath()%>/couponUse.ma','쿠폰 선택','width=470,height=500,location=no,status=no,scrollbars=no');">선택</button></div>
                <input type="text" class="coupon_price" id="cName" readonly>
            </div>
            <hr>
            <!-- 쿠폰까지 적용된 금액 보여주는 틀2 -->
            <div class="title_font" id="pay_line">
                <div id="sale_bar">
                    <div id="sale_title">할인 금액</div>
                    <input type="text" class="coupon_price" id="cDis" style="margin-right:20px;" value="0" readonly>
                </div>
                <br>
                <div id="pay_bar">
                    <div id="pay_title">최종금액</div>
                    <input type="text" class="coupon_price" id="pay_price" value="<%=tPayment%>" readonly>
                </div>
            </div>
            <hr>
            <!-- 결제 수단 글자 틀 -->
        <form method="post" name="form">
            <!-- 약관 동의 배치할 틀 -->
            <div class="title_font" id="agree_line">
                <input type="checkbox" name="agree" onclick="payBtn_on(this.form)">개인정보 제3자 제공 동의, 결제 대행 서비스 이용 약관 등 모든 약관에 동의합니다</input>
            </div>
            <br>
            <!-- 결제하기 버튼 배치할 틀 -->
            <div id="payment_btn_line">
                <input type="button" class="btn btn-success" id="pay_btn" name="pay_Btn" value="결제하기" onclick="requestPay()" disabled>
            </div>
        </form>
            <br>
        </div>
    </body>
    
    
    <script>
	   IMP.init('imp43632278');  // 가맹점 식별 코드
	   function requestPay(){
		   
		   IMP.request_pay({
			    pg : 'inicis',			// 이니시스 테스트(inicis) / (kcp.A52CY)
			    pay_method : 'card',	// 카드 결제
			    merchant_uid : 'merchant_' + new Date().getTime(),
			    name : '<%=pt.get(0).gettName()%>',	 
			    amount : 100		 // 최종금액(쿠폰 적용 가능) [ $('#pay_price').val() ]
			    
			}, function(rsp) {
			    if ( rsp.success ) {
			        // 결제 성공시 로직
			    	var msg = '결제가 완료되었습니다.';
			        msg += '결제 금액 : ' + rsp.paid_amount;
			        msg += '카드 승인번호 : ' + rsp.apply_num;
			        
			        var oNo = '<%=oNo%>';					
			        var tPayment = $('#pay_price').val();	
			        var payInfo = 'card';
			        var dic = $('#cDis').val();
			        var person = '<%=person%>';				
			        var cNo = $('#cNo').val();		
			        
			        $.ajax({
			        	url:"payComplete.ma",
			        	data:{oNo:oNo, tPayment:tPayment, person:person, payInfo:payInfo, dic:dic, cNo:cNo},
			        	type:"post",
			        	success:function(data){
			        		console.log("통신 성공!");
			        		location.href="index.jsp";
			        			
			        	},error:function(){
			        		console.log("서버와의 통신 실패!!");
			        		console.log(oNo);
			        		console.log(tPayment);
			        		console.log(payInfo);
			        		console.log(dic);
			        	}
			        });
			       
			    } else {
			    	// 결제 실패시 로직
			        var msg = '결제에 실패하였습니다.';
			        msg += '에러내용 : ' + rsp.error_msg;	
			        
			    }
			    alert(msg);
			});
	   }
	   
	   function payBtn_on(frm){
		   if(frm.pay_Btn.disabled == true){
			   frm.pay_Btn.disabled = false;
		   }else{
			   frm.pay_Btn.disabled = true;
		   }
	   }
	   
    </script>

    <footer>
    	<%@ include file="../common/footer.jsp" %>
    </footer>
</body>
</html>













