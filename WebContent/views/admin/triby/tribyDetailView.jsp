<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.triby.triby.model.vo.Triby" %>    
<%
	Triby t = (Triby)request.getAttribute("pick");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<style>
    .outer{width:1280px;height:1080px;font-family: 'Noto Sans KR', sans-serif;}

    input{text-align:right;}
    table{border-collapse:collapse; width:80%; height:50px;}
    table,th,td{border-bottom:1px solid #ddd; padding:8px;text-align:left;}
    tr:hover{background-color: #f5f5f5;}

    .detail_div{width:100%;margin-right:auto;margin-left:auto;}
    .favor_table{text-align:center;}
    #rollbackbtn:hover{cursor:pointer;}
    #confirm_detail:hover{cursor:pointer;background-color:#ccc;}
</style>
</head>
<body>
<%@include file="../adminHeader.jsp" %>
   <div class="outer">
        <br>
        <h3 align="center">상세정보</h3>
        <hr>
        <div class="detail_div">
            <table align="center">
            	<tr>
            		<th width="15%">트리비번호</th>
            		<th width="15%">호스트이름</th>
            		<th width="20%">트리비제목</th>
            		<th width="15%">카테고리</th>
            		<th width="30%">위치</th>
            		<th width="15%">가격</th>
            	</tr>
                <tr>
                    <td id="tNo"><%=t.gettNo() %></td>
                    <td ><%=t.getAppoval_status() %></td>
                    <td ><%=t.gettTitle() %></td>
                    <td ><%=t.getcId1() %>, <%=t.getcId2() %>, <%=t.getcId3() %></td>
                    <td ><%=t.getAddress() %></td>
                    <td ><%=t.gettPrice() %></td>
                </tr>
            </table>
        </div>

        <div class="checkout_table">
            <table align="center">
                <tr>
				<th>포함사항</th>
				<td colspan="5"><p id="contentArea1"><%=t.gettContent1() %></p></td>
			</tr>
			<tr>
				<th>세부일정</th>
				<td colspan="5"><p id="contentArea2"></p><%=t.gettContent2() %></td>
			</tr>
			<tr>
				<th>준비물</th>
				<td colspan="5"><p id="contentArea3"></p><%=t.gettContent3() %></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="5">
					<div id="contentClobArea">
						<%=t.gettContent() %>
					</div>
				</td>
			</tr>
            </table>
        </div>
        <br>
        <div id="confirm_detail" align="center" onclick="approveTriby()">확인</div>

    </div>
<script>
	function approveTriby() {
		var tNo = <%= t.gettNo()%>;
		
		$.ajax({
			url:"checkOption.ad",
			method:"post",
			data:{tNo:tNo},
			dataType:"text",
			success:function(check) {
				if(check>0) {
					var bool = confirm("승인하시겠습니까");
					if(bool) {
						var tNo = $("#tNo").text();
						location.href="<%=request.getContextPath()%>/tribyApprove.ad?tNo=" + tNo;
					}else {
						location.href="javascript:history.back();"
					}	
				}else {
					alert("구매옵션이 없습니다");
						location.href="javascript:history.back();"
				}
			}
		}) 
	}
</script>
</body>
</html>