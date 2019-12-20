<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.triby.option.model.vo.Option"%>
<% 
	ArrayList<Option> list = (ArrayList<Option>) request.getAttribute("list");
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
	#content{width:100%; height: 77vh; margin: 0; padding:1rem 1rem 1rem 2rem; overflow-y: auto;}
	#article{height:100%}
	img:hover, .btn:hover{cursor:pointer;}
	#tableArea{width:100%; height:400px; padding: 3%;}
	table{width:70%;}
	#minimumP, #maximumP{width:40px; height:40px}
	//tr td{border:1px solid;}
	#datePlus{float: right; margin-right:15%;}
	//table tr:nth-child(1) td:nth-child(2){text-align:right}
	table{text-align:center}
	#price{width:300px}
	#emptyArea{width:100%; text-align:center; padding-top:20%; height:100%;}
	#attend:hover{cursor:pointer}
</style>
</head>
<body>
	<%@ include file="aside.jsp" %>
	<div id="wrap">
	<div id="title"><img src="resources/images/back.png" width="32px" height="32px" onclick="javascript:history.back();">&nbsp;&nbsp;옵션 관리</div>
	<div id="content" class="jumbotron">
		<div id="top">
	</div>
	<div id="article">
		<div id="tableArea">
		<% if(list.isEmpty()) { %>
			<div id="emptyArea"><h2>아직 만들어진 옵션이 없습니다!</h2><br>
			<form method="post" action="<%= contextPath%>/insertForm.op">
				<input type="hidden" name="tNo" value="<%= tNo %>">
				<button class="btn btn-info" type="submit">옵션 추가</button>
				</form>
			</div>
		<% } else { %>
		<input type="hidden" name="tNo" value="<%= tNo %>">
		<table align="center">
			<tr>
				<td height="50px">최소인원</td>
				<td><button class="btn btn-secondary" type="button" onclick="minus(0);">-</button>
				<input type="number" id="minimumP" name="minimumP" min="1" value="<%=list.get(0).getPerson_min() %>">
				<button class="btn btn-secondary" type="button" onclick="plus(0);">+</button></td>
				<td height="50px">최대인원</td>
				<td><button class="btn btn-secondary" type="button" onclick="minus(1);">-</button>
				<input type="number" id="maximumP" name="maximumP" min="1" value="<%=list.get(0).getPerson_max() %>" step="1">
				<button class="btn btn-secondary" type="button" onclick="plus(1);">+</button></td>
				<td>현재<br>신청인원</td>
				<td width="90px">예약<br>그만받기</td>
			</tr>
			<tr>
			<td rowspan="<%= list.size() %>">일정/시간</td>
			<% for(int i=0; i<list.size(); i++) { %>
				<% if(list.get(i).getStatus().equals("E")) { %>
				<td height="40px"><input name="date1" type="date" value="<%= list.get(i).gettDay() %>" disabled></td>
				<td colspan="2"><input name="time1" type="time" value="<%=list.get(i).gettTime() %>" step="1800" min="00:00" max="23:59" disabled></td>
				<td><input size="3" type="text" value="<%= list.get(i).gettAttend() %>" readonly></td>
				<td><button type="button" class="btn btn-info" disabled>종료</button></td>
				<% } else { %>
				<td height="40px"><input name="date1" type="date" value="<%= list.get(i).gettDay() %>" required></td>
				<td colspan="2">
				<input name="time1" type="time" value="<%=list.get(i).gettTime() %>" step="1800" min="00:00" max="23:59" required></td>
				<% if(list.get(i).gettAttend() != 0) { %>
				<td><input id="attend" size="3" type="text" value="<%= list.get(i).gettAttend() %>" readonly onclick="attendance(<%= list.get(i).getoNo() %>);"></td>
				<% } else { %>
				<td><input size="3" type="text" value="<%= list.get(i).gettAttend() %>" readonly></td>
				<% } %>
				<td><button id="ebt<%= list.get(i).getoNo() %>" type="button" class="btn btn-info" onclick="endOption(<%= list.get(i).getoNo() %>)">종료</button></td>
			<% } %>
				</tr>
			<% } %>
		</table><br>
		</div>
		<% } %>
		</div>
	</div>
	</div>
	<script>
		function minus(e){
			
			if(e == 0) {
				var minimumP = $('input[name=minimumP]').val();
				$('input[name=minimumP]').val(minimumP - 1);
			} else {
				var maximumP = $('input[name=maximumP]').val();
				$('input[name=maximumP]').val(maximumP - 1);
			}
		}
		
		function plus(e){
			
			if(e == 0) {
				var minimumP = $('input[name=minimumP]').val();
				$('input[name=minimumP]').val(parseInt(minimumP) + 1);
			} else {
				var maximumP = $('input[name=maximumP]').val();
				$('input[name=maximumP]').val(parseInt(maximumP) + 1);
			}
		}
		
	//	function test(){
		//	console.log($('input[name=time2]').val());
		//}
	
		function endOption(oNo){
			var tNo = <%= tNo %>;
			
			//console.log(tNo);
			//console.log(oNo);
			$.ajax({
				url:"end.op",
				type:"post",
				data:{tNo:tNo, oNo:oNo},
				success:function(){
					$("#ebt" + oNo).attr("disabled", true);
				}, error:function(){
					console.log("통신 실패");
				}
			});
			
		}
		
		function attendance(oNo){
			
			var form = document.createElement("form");      // form생성

			form.setAttribute("method", "post");                    // method 설정
			form.setAttribute("action", "<%= contextPath%>/selecth.pa");       // action 설정
			form.setAttribute("target", "attendance")
			
			document.body.appendChild(form);
			
			var input_id = document.createElement("input");
			
			input_id.setAttribute("type", "hidden");

			input_id.setAttribute("name", "oNo");      //name 속성 지정
			input_id.setAttribute("value", oNo);        //value 값 설정

			form.appendChild(input_id);
			
			var wintype = "width=600, height=500, resizable=no";
			open("", "attendance", wintype);
			
			form.submit();
			
		}
		
	</script>
	
</body>
</html>