<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
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
	#content{width:100%; height:77vh; margin: 0; padding:1rem 1rem 1rem 2rem; overflow-y: auto;}
	table{width:50%; height:550px;}
	table tr{height:8%;}
	#bottom{float:right;}
	.btn:hover{cursor:pointer;}
	#exampleTextarea{resize:none;}
</style>
</head>
<body>
	<%@ include file="aside.jsp" %>
	<div id="wrap">
	<div id="title">호스트 프로필</div>
	<div id="content" class="jumbotron">
  	<form action="<%=contextPath %>/update.ho" method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<td width="12%;"><h6>이메일</h6></td>
						<td colspan="2">
						<input type="text" class="form-control" id="staticEmail" value="<%= loginHost.getHost_email() %>" readonly name="email"></td>
					</tr>
					<tr>
						<td><h6>비밀번호</h6></td>
						<!--from pak  -->
						<td colspan="2"><input type="button" class="btn btn-info" onclick="changeHostPw()" value="비밀번호 변경"></td> <!-- 추후에 ajax로 작업할 것 -->
						<!--end pak  -->
					</tr>
					<tr>
						<td height="5%;"><h6>프로필 사진</h6></td>
					</tr>
					<tr>
						<td><div id="profilePArea">
						<% if(loginHost.getHost_image() != null) { %>
							<img src="<%=contextPath %>/resources/images/host/profile/<%= loginHost.getHost_image()%>" id="profileP" width="100" height="100">
						<% } else { %>
							<img src="<%=contextPath %>/resources/images/host/profile/user.png" id="profileP" width="100" height="100">
						<% } %>
						</div></td>
						<td width="40%;" colspan="2"><input type="file" name="profileP" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp" onchange="loadImg(this, 1);"></td>
					</tr>
					<tr>
						<td><h6>이름</h6></td>
						<td colspan="2"><input type="text" class="form-control" id="staticEmail" value="<%= loginHost.getHost_name() %>" readonly></td>
					</tr>
					<tr>
						<td><h6>호스트 이름</h6></td>
						<td colspan="2"><input type="text" class="form-control" id="staticEmail" value="<%= loginHost.getHost_sName() %>" name="sname"></td>
					</tr>
					<tr>
						<td><h6>핸드폰 번호</h6></td>
						<td colspan="2"><input type="text" class="form-control" id="staticEmail" placeholder="(-포함)" value="<%= loginHost.getHost_phone() %>" name="phone"></td>
					</tr>
					<tr>
						<td><h6>계좌정보</h6></td>
						<td width="40px"><input type="text" class="form-control" id="staticEmail" value="<%= loginHost.getBank_name() %>" name="bankname"></td><!-- 나중에 시간되면 select 옵션으로 -->
						<td><input type="text" class="form-control" id="staticEmail" placeholder="(-포함)" value="<%= loginHost.getAccount() %>" name="account"></td>
					</tr>
					<tr>
						<td><h6>소개</h6></td>
						<td colspan="2">
						<% if(loginHost.getHost_introduce() != null) { %>
							<textarea class="form-control" id="exampleTextarea" rows="3" name="introduce"><%= loginHost.getHost_introduce() %></textarea>
						<% } else { %>
							<textarea class="form-control" id="exampleTextarea" rows="3" name="introduce" placeholder="소개를 넣어주세요."></textarea>
						<% } %>
						</td>
					</tr>
				</table>
				<div id="bottom"><input class="btn btn-info" type="submit" value="변경사항 저장"></div>
		</form>  
</div>
	</div>
	
	<script>
	
	function loadImg(value, num){
		if(value.files && value.files[0]){ 
			
			var reader = new FileReader();
			
			reader.onload = function(e){
				
				switch(num){
				case 1: $("#profileP").attr("src", e.target.result); // data:URL
					break;
				}
				
			}
			reader.readAsDataURL(value.files[0]);
		}
			
	}
	//from pak
	function changeHostPw() {
		window.open("views/admin/miscellaneous/pwUpdateForm.jsp","호스트비밀번호변경창","width=500,height=250");
	}
	//end pak	
	</script>
	
</body>
</html>