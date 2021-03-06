<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int tNo = (int) request.getAttribute("tNo");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#wrap{
		float:left;
		margin: 1%;
		font-family: 'Noto Sans KR', sans-serif;
		width:80%;
	}
	#title{font-size:18px; font-weight:bold; margin-bottom:1rem;}
	#content{width:100%; height: 77vh; margin: 0; padding:1rem 1rem 1rem 2rem; overflow-y: hidden;}
	#article{height:100%}
	img:hover, .btn:hover{cursor:pointer;}
	#tableArea{width:100%; height:400px; padding: 3%;}
	table{width:70%; text-align:center;}
	#minimumP, #maximumP{width:40px; height:40px}
	//tr td{border:1px solid;}
	#datePlus{float: right; margin-right:15%;}
	//table tr:nth-child(1) td:nth-child(2){text-align:right}
	//#dtTable{border:1px solid;}
</style>
</head>
<body>
	<%@ include file="aside.jsp" %>
	<div id="wrap">
	<div id="title"><img src="resources/images/back.png" width="32px" height="32px" onclick="javascript:history.back();">&nbsp;&nbsp;옵션 추가</div>
	<div id="content" class="jumbotron">
		<div id="top">
	</div>
	<div id="article">
		<div id="tableArea">
		<form method="post" action="<%= contextPath%>/insert.op">
		<input type="hidden" name="tNo" value="<%= tNo %>">
		<input type="hidden" name="hNo" value="<%= loginHost.getHost_no() %>">
		<input type="hidden" name="status" value="1">
		<table align="center">
			<tr>
				<td height="50px">최소인원</td>
				<td><button id="minusbtn" class="btn btn-secondary" type="button" onclick="minus(0);">-</button>
				<input type="number" id="minimumP" name="minimumP" min="1" value="1">
				<button class="btn btn-secondary" type="button" onclick="plus(0);">+</button></td>
				<td height="50px">최대인원</td>
				<td><button class="btn btn-secondary" type="button" onclick="minus(1);">-</button>
				<input type="number" id="maximumP" name="maximumP" min="1" value="5" step="1">
				<button class="btn btn-secondary" type="button" onclick="plus(1);">+</button></td>
			</tr>
		</table><br>
		<table align="center" id="dtTable">
		<tbody id="dtBody">
		<tr id="tr1">
				<td rowspan="5">일정/시간<br>
				<button class="btn btn-info" type="button" onclick="dtMinus();">-</button>
				<button class="btn btn-info" type="button" onclick="dtPlus();">+</button>
				</td>
				<td height="40px"><input name="date" type="date" required></td>
				<td colspan="2"><input name="time" type="time" value="21:00" step="1800" min="00:00" max="23:59" required>
				</td>
			</tr>
		</tbody>
		</table>
		</div>
		<div align="center">
			<button type="submit" class="btn btn-info">저장</button>
			</form>
		</div>
	</div>
	</div>
	</div>
	
	<script>
		function minus(e){
			
			if(e == 0) {
				var minimumP = $('input[name=minimumP]').val();
				$('input[name=minimumP]').val(minimumP - 1);
				//console.log(minimumP);
				if(minimumP == 1) {
					$('#minusbtn').attr("disabled",true);
				} else {
					$('#minusbtn').attr("disabled",false);
				}
				//console.log(minimumP);
				
			} else {
				var maximumP = $('input[name=maximumP]').val();
				$('input[name=maximumP]').val(maximumP - 1);
			}
		}
		
		function plus(e){
			//console.log("+");
			if(e == 0) {
				var minimumP = $('input[name=minimumP]').val();
				$('input[name=minimumP]').val(parseInt(minimumP) + 1);
				console.log(minimumP);
			} else {
				var maximumP = $('input[name=maximumP]').val();
				$('input[name=maximumP]').val(parseInt(maximumP) + 1);
			}
		}
		
		$count = 1;
		
		function dtPlus(){
			
			if($count < 5) {
				$tr = $('<tr>');
				$td1 = $('<td height="40px"><input name="date" type="date" required></td>');
				$td2 = $('<td colspan="2"><input name="time" type="time" value="21:00" step="1800" min="00:00" max="23:59" required></td>');
			
				$tr.append($td1);
				$tr.append($td2)
				
				$("#dtBody").append($tr);
				$count++;	
			} else {
				alert("일정을 5개 이상 추가할 수 없습니다.");
			}	
		}
		
		function dtMinus(){
			if($count != 1) {
				$('#dtBody tr:last').remove();
				$count--;
			}
		}
	
	</script>
	
</body>
</html>