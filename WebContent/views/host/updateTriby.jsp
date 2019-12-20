<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.triby.tImage.model.vo.Image, com.triby.triby.model.vo.Triby"%>
<%
	Triby tr = (Triby) request.getAttribute("tr");
	ArrayList<Image> list = (ArrayList<Image>) request.getAttribute("list");
%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css" rel="stylesheet">
<style>
	#wrap{
		float:left;
		margin: 1%;
		font-family: 'Noto Sans KR', sans-serif;
		width:80%;
	}
	#title{font-size:18px; font-weight:bold; margin-bottom:1rem;}
	#content{width:100%; height:77vh; margin: 0; padding:1rem 1rem 0 1rem; overflow-y: auto;}
	#editor{height:60vh; background:white; width:100%;}
	.btn{margin-top:5px;}
	#plus{width:100%; height:570px;}
	#contentImgArea1, #contentImgArea2, #contentImgArea3{
		width:240px;
		height:120px;
		background-image:url('resources/images/host/common/plus.png');
		background-size: 50px 50px;
		background-repeat: no-repeat;
		background-position: center;
	}
	table div{
		text-align:center;
		display:table-cell;
		vertical-align:center;
	}
	img:hover, #contentImgArea1:hover, #contentImgArea2:hover, #contentImgArea3:hover, .btn:hover, .cate:hover{cursor:pointer;}
	table tr td{text-align:center;}
	#tribyContent{resize:none; width:100%; height:100%;}
	.cate{width:70px; color:black; height:30px; line-height:30px;}
	.btn{margin-bottom:10px;}
	//table tr:nth-child(6), table tr:nth-child(7), table tr:nth-child(8), table tr:nth-child(6) td{border: 1px solid;}
</style>
</head>
<body>
	<%@ include file="aside.jsp" %>
	
	 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>
    <script src="lang/summernote-ko-KR.js"></script>
	
	<div id="wrap">
	<div id="title"><img src="resources/images/back.png" width="32px" height="32px" onclick="javascript:history.back();">&nbsp;&nbsp;트리비 수정</div>
	<div id="content" class="jumbotron">
		<form method="post" action="<%= contextPath%>/update.tr" enctype="multipart/form-data">
		<input type="hidden" name="loginHostno" value="<%= loginHost.getHost_no() %>">
		<input type="hidden" value="<%=	tr.gettNo() %>" name="tNo">
		<div><input class="form-control form-control-lg" type="text" name="title" placeholder="트리비 제목을 입력하세요" id="inputLarge" 
			required value="<%= tr.gettTitle() %>"></div><br>
		<div id="editor">
			<textarea id="summernote" name="tribyContent" required><%= tr.gettContent() %></textarea>
		</div> <br>
		<div id="plus">
		<table align="center">
				<tr>
				<td width="100px">썸네일 이미지</td>
					<% for(int i=0; i<list.size(); i++) { %>
						<td>
						<div id="contentImgArea<%= i+1 %>">
							<img id="contentImg<%= i+1 %>" width="240" height="120" src="resources/images/triby/<%=list.get(i).getiName() %>">
							<input type="hidden" name="iNo<%= i+1 %>" value="<%= list.get(i).getiNo() %>">
						</div>
						</td>
					<% } %>
				</tr>
				<tr>
				<td height="50px">포함 사항</td>
				<td colspan="3"><input type="text" class="form-control" name="content1" required value="<%= tr.gettContent1() %>"></td>
				</tr>
				<tr>
				<td height="50px">세부 일정</td>
				<td colspan="3"><input type="text" class="form-control" name="content2" required value="<%= tr.gettContent2() %>"></td>
				</tr>
				<tr>
				<td height="50px">준비물</td>
				<td colspan="3"><input type="text" class="form-control" name="content3" required value="<%= tr.gettContent3() %>"></td>
				</tr>
				<tr>
				<td height="50px">진행 장소</td>
				<td colspan="3"><input type="text" class="form-control" name="address" required value="<%= tr.getAddress() %>"></td>
				</tr>
				<tr>
				<td height="50px">가격</td>
				<td colspan="3"><input type="number" id="price" name="price" min="0" step="10000" value="<%= tr.gettPrice() %>"></td>
				</tr>
				<tr>
				<td rowspan="3">카테고리<br>
				(필수 선택 3)
				</td>
				<td>액티비티</td>
				<td colspan="2" width="480px">
				<input type="checkbox" id="ac1" name="category" value="AC1">
				<label for="ac1" class="cate">아웃도어</label>
				<input type="checkbox" id="ac8" name="category" value="AC8">
				<label for="ac8" class="cate">실내체험</label>
				<input type="checkbox" id="ac2" name="category" value="AC2">
				<label for="ac2" class="cate">워터파크</label>
				<input type="checkbox" id="ac3" name="category" value="AC3">
				<label for="ac3" class="cate">수상레저</label> <br>
				
				<input type="checkbox" id="ac4" name="category" value="AC4">
				<label for="ac4" class="cate">투어</label>
				<input type="checkbox" id="ac5" name="category" value="AC5">
				<label for="ac5" class="cate">축제</label>
				<input type="checkbox" id="ac6" name="category" value="AC6">
				<label for="ac6" class="cate">공연</label>
				<input type="checkbox" id="ac7" name="category" value="AC7">
				<label for="ac7" class="cate">전시</label>
				</td>
				</tr>
				<tr>
				<td>스터디</td>
				<td colspan="2">
				<input type="checkbox" id="st1" name="category" value="ST1">
				<label for="st1" class="cate">스포츠</label>
				<input type="checkbox" id="st2" name="category" value="ST2">
				<label for="st2" class="cate">음악</label>
				<input type="checkbox" id="st3" name="category" value="ST3">
				<label for="st3" class="cate">미술</label>
				<input type="checkbox" id="st4" name="category" value="ST4">
				<label for="st4" class="cate">공예</label>
				<input type="checkbox" id="st10" name="category" value="ST10">
				<label for="st10" class="cate">독서</label><br>
				
				<input type="checkbox" id="st5" name="category" value="ST5">
				<label for="st5" class="cate">요리</label>
				<input type="checkbox" id="st6" name="category" value="ST6">
				<label for="st6" class="cate">음료</label>
				<input type="checkbox" id="st7" name="category" value="ST7">
				<label for="st7" class="cate">영상</label>
				<input type="checkbox" id="st8" name="category" value="ST8">
				<label for="st8" class="cate">사진</label>
				<input type="checkbox" id="st9" name="category" value="ST9">
				<label for="st9" class="cate">외국어</label>
				</td>
				</tr>
				<tr>
				<td>헬스·뷰티</td>
				<td colspan="2">
				<input type="checkbox" id="hb1" name="category" value="HB1">
				<label for="hb1" class="cate">피트니스</label>
				<input type="checkbox" id="hb2" name="category" value="HB2">
				<label for="hb2" class="cate">요가</label>
				<input type="checkbox" id="hb3" name="category" value="HB3">
				<label for="hb3" class="cate">필라테스</label><br>
				
				<input type="checkbox" id="hb4" name="category" value="HB4">
				<label for="hb4" class="cate">스파</label>
				<input type="checkbox" id="hb5" name="category" value="HB5">
				<label for="hb5" class="cate">심리</label>
				<input type="checkbox" id="hb6" name="category" value="HB6">
				<label for="hb6" class="cate">상담</label>
				</td>
				</tr>
			</table>
		</div>
		<div id="fileArea">
				<input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="loadImg(this, 1);">
				<input type="file" id="thumbnailImg2" name="thumbnailImg2" onchange="loadImg(this, 2);">
				<input type="file" id="thumbnailImg3" name="thumbnailImg3" onchange="loadImg(this, 3);">
			</div>
		<div align="center">
			<button type="button" class="btn btn-secondary" onclick="deleteTriby();">삭제</button>
			<button id="complete" type="submit" class="btn btn-info" disabled>저장</button>
		</div>
		</form>
	</div>
	</div>
	
<script>
		// 각 div 클릭할 때 파일 첨부 창이 뜨도록
		$(function(){
			$("#fileArea").hide();
			
			$("#contentImgArea1").click(function(){
				$("#thumbnailImg1").click();
			});
			$("#contentImgArea2").click(function(){
				$("#thumbnailImg2").click();
			});
			$("#contentImgArea3").click(function(){
				$("#thumbnailImg3").click();
			});
			
		});
		
		function loadImg(value, num){
		
			if(value.files && value.files[0]){
				
				var reader = new FileReader();
				
				reader.onload = function(e){
					
					switch(num){
					case 1: $("#contentImg1").attr("src", e.target.result);
						break;
					case 2: $("#contentImg2").attr("src", e.target.result);
						break;
					case 3:  $("#contentImg3").attr("src", e.target.result);
						break;
					}
					
				}
	
				reader.readAsDataURL(value.files[0]);
			}
		}
		
		$(function(){
			
			$("input[name^=cate]:checkbox").change(function() {

				if($("input[name^=cate]:checkbox:checked").length == 3) {
		            $(":checkbox:not(:checked)").attr("disabled", "disabled");
		            $("#complete").removeAttr("disabled");
		        } else {
		            $("input[name^=cate]:checkbox").removeAttr("disabled");
		        }
		    });
		
		});
		
		$(function(){
			 $('#summernote').summernote({
			        placeholder: 'Try new hobby',
			        tabsize: 2,
			        height: 370,
			        lang: 'ko-KR'
			      });
		});
		
		function deleteTriby(){
			
			var form = document.createElement("form");      // form생성

			form.setAttribute("method", "post");                    // method 설정
			form.setAttribute("action", "<%= contextPath %>/delete.tr");       // action 설정
			
			document.body.appendChild(form);
			
			var input_id = document.createElement("input");
			
			input_id.setAttribute("type", "hidden");

			input_id.setAttribute("name", "hNo");      //name 속성 지정
			input_id.setAttribute("value", <%= loginHost.getHost_no() %>);        //value 값 설정

			form.appendChild(input_id);
			
			var input_id2 = document.createElement("input");
			
			input_id2.setAttribute("type", "hidden");

			input_id2.setAttribute("name", "tNo");      //name 속성 지정
			input_id2.setAttribute("value", <%= tr.gettNo() %>);
			
			form.appendChild(input_id2);
			
			var input_id3 = document.createElement("input");
			
			input_id3.setAttribute("type", "hidden");

			input_id3.setAttribute("name", "status");      //name 속성 지정
			input_id3.setAttribute("value", 0);
			
			form.appendChild(input_id3);
			
			form.submit();
			
		}
		
	</script>
	
</body>
</html>