<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.triby.payment.model.vo.Payment,java.util.Date,java.text.SimpleDateFormat" %>    
<%
	ArrayList<Payment> list = (ArrayList<Payment>)request.getAttribute("list");
	String past = (String)request.getAttribute("past");
	Date today = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MM");
	String present = sdf.format(today);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
        .rContent{
            background-color:white;
            width:1500px;
            margin-left:auto;
            margin-right:auto;
            margin-top:30px;
            padding-bottom:30px;
        }
        .rContent table{
            border:1px solid black;
            text-align: center;
            margin-left:auto;
            margin-right:auto;
        }
        .btn:hover{cursor:pointer;}
        #reply_div{display:none;width:100%;height:10%;padding:30px;text-align:center;background-color:lightblue;z-index:1;position:absolute;}
    	#hostListTable{border-collapse:collapse; width:80%; height:50px;}
        #hostListTable th td{border-bottom:1px solid #ddd; padding:8px;text-align:center}
    </style>
</head>
<body>
<%@include file ="../adminHeader.jsp" %>
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
				<h1 class="aTitle">정산</h1>
			    <div class="tagWrap">
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/calculate.ad';">
                    	<div class="btn" id="blacklist_btn">결제내역조회</div></button>
	                <button type="button" onclick="location.href='<%=request.getContextPath()%>/calculateList.ad';">
                    	<div class="btn" id="blacklist_btn">정산대기중</div></button>
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/doCalculate.ad';">
                    	<div class="btn" id="report_btn">정산하기</div></button>
                    <button type="button" onclick="location.href='<%=request.getContextPath()%>/calListView.ad';">
                    	<div class="btn" id="blacklist_btn">정산내역조회</div></button>
                </div>
				<div class="rContent">
					<h3 align="center"><%=past %>월 16일부터 <%=present%>월 15일까지 정산하기</h3>
				 	<form>
				 	<!-- <h3>정산대기중</h3> -->
				 	<table id="calTableArea" >
				 		<tr>
				 			<td width="50px">선택</td>
				 			<td width="200px">옵션번호</td>
				 			<td width="200px">최종금액</td>
				  		</tr>
                       	<%if(list.isEmpty()) { %>
                       	<tr>
                       		<td colspan="3">정산할 내역이 없습니다</td>
                       	</tr>
                       	<%}else { %>
                       	<%for(Payment p : list) { %>
                       	<tr>
                       		<td><input type="checkbox" name="checkTono" id="checkTono" value="<%=p.gettONo()%>"></td>
                       		<td ><%=p.gettONo() %></td>
                       		<td ><%=p.getpFinal() %></td>
                       	</tr>
                       	<%} %>
                       	<%} %>
                       	 
                    </table>
                    </form>
                    <!--from pak 10/12  -->
                    <%if(!list.isEmpty()) { %>
                    <div class="btnArea" align="center">
                    <br>
                    	<button id="btn">정산하기</button>
                    </div>
                    <br>
                     <div class="reply_div" align="center">
                    	<h4>입금후 정산한 내용을 확인하여 해당호스트에게 정산이 완료 되었음을 알려주세요</h4>
                    	<br>
                    	<table id="hostListTable">
                    	<thead>
                    		<tr>
                    			<th>호스트번호</th>
                    			<th>예금주</th>
                    			<th>은행명</th>
                    			<th>계좌번호</th>
                    			<th>입금하실금액</th>
                    		</tr>
                    	</thead>
                    	<tbody></tbody>	
                    	</table>
                    	
                    	<br>
                    	
                    		<button id="chebtn" disabled>확인하기</button>
                    	
                    </div>   
                    <%} %>
                    <!--end pak 10/12  -->  
				</div>
			</div>
		</div>
	
	</div>
<script>
	var clist=[];
	$(document).ready(function() {
		$("#btn").click(function() {
		<%-- location.href="<%=request.getContextPath()%>/updateCalSta.ad"; --%>
		var list=[];
		//list=$("input:checked");
		//console.log(list+"asdasd");
		$("input:checkbox[name=checkTono]").each(function() {
		if(this.checked) {
			list.push($(this).val());
		}
		});
			//console.log(list);
			//console.log(this.checked);
			jQuery.ajaxSettings.traditional = true;
			$.ajax({
				url:"callHostAjax.ad",
				method:"post",
				data:{list:list},
				dataType:"json",
				success:function(hostList) {
					//console.log(hostList);
					clist=[];
					var $showTable = $("#hostListTable tbody");
					$showTable.html("");
					var json = new Object();
					$.each(hostList, function(index,value) {
						var $tr = $("<tr>");
						var $host_no =$("<td>").text(value.host_no).css("width","100px");
						var $host_accountName = $("<td>").text(value.host_accountName).css("width","100px");
						var $bank_name = $("<td>").text(value.bank_name).css("width","100px");
						var $account = $("<td>").text(value.account).css("width","100px");
						var $report_count = $("<td>").text(value.report_count).css("width","100px");
						$tr.append($host_no);
						$tr.append($host_accountName);
						$tr.append($bank_name);
						$tr.append($account);
						$tr.append($report_count);
						$showTable.append($tr);
						//$("#reply_div").attr("style:display","block");
						
						//if(confirm("정산을 진행할까요")) {
							
						<%-- location.href="<%=request.getContextPath()%>/updateCal.ad?sum="+ value.report_count + "&toNo=" + value.like_count; --%>
						//}else {
					  /*   $("#calTableArea").css("display","none"); */
							
						//}
						//clist.push(value);
						$("#chebtn").removeAttr("disabled");
						json.triby_op_no = value.report_count;
						json.cal_sum = value.like_count;
						clist.push({op:value.like_count,sum:value.report_count})
						
					})
					var realData = {jsonData:JSON.stringify(json)}
					//console.log(realData);
					console.log(clist);
					<%-- $.post("<%=request.getContextPath()%>/insertCal.ad", json,"realData"); --%>
					
				}
			});
			
		})
	//})
		$("#chebtn").click(function() {									
				//옵션번호							//입금액
			<%--location.href="<%=request.getContextPath()%>/updateCal.ad?sum="+ value.report_count + "&toNo=" + value.like_count";--%>
			$.each(clist,function(i,v){
				console.log(v.op);
			$.ajax({
				url:"updateCal.ad",
				data:{toNo:v.op,sum:v.sum},
				success:function(data){
					if(data>0){
					console.log(v.op+"성공");
						
					}else{
						console.log("실패");
					}
					
				},
				error:function(){
					console.log("updateCal.ad Error");
				}
				
			});
				location.href="<%=request.getContextPath()%>/calListView.ad"
			});
		//$("#chebtn").click();
		})
	
})
					
	//})
	
</script>
</body>
</html>