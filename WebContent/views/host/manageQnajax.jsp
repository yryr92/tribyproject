<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.triby.qnaHost.model.vo.QnA"%>
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
	#content{width:100%; height:80vh; margin: 0; padding:1rem 1rem 1rem 2rem; overflow-y: auto;}
	#navArea{float:left;}
	#searchArea{float:right;}
	#article{height:100%}
	#article .card-header{
		width:100%;
		height:280px;
		margin-top:1rem; 
		margin-bottom:1rem;
		background:#F6F6F6;}
	.pagination{justify-content: center;}
	#qArea, #aArea{display:flex; height:42%; padding-left:2%; width:100%;}
	#qmark, #amark{float:left; padding-top:1%;}
	#qctArea{font-size:18px; font-weight:bold; padding-top:1%;}
	#qcnArea{height:50%; overflow-y: auto;}
	#qtArea{width:68%; margin-left:3%;}
	#ansArea{margin-left:3%; padding-top:1%; width:100%;}
	#qiArea{flex-grow:1; padding-top:1%; font-size:15px; color:dark-gray; text-align:right;}
	#bArea{float:right; margin-right:1%; margin-bottom:2%;}
	.btn:hover{cursor:pointer;}
	#answer{width:100%; height:90%; resize:none;}
</style>
</head>
<body>
	<%@ include file="aside.jsp" %>
	<div id="wrap">
	<div id="title">Q&A 관리</div>
	<div id="content" class="jumbotron">
	<div id="top">
	<div id="navArea">
		<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" data-toggle="tab" href="#home" id="allqna" onclick="show(this.id);">전체 Q&A</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#profile" id="unfinishqna" onclick="show(this.id);">답변 전 Q&A</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#" id="finishqna" onclick="show(this.id);">답변 완료 Q&A</a>
  </li>
</ul>
</div><div id="searchArea">
	<input class="form-control mr-sm-2" type="text" placeholder="문의 내용 검색"></div>
	</div>
	<br style="clear:both">
	<hr>
	<div id="article">

		//<div id="emptyArea"><h2>QnA가 아직 없습니다ㅠ^ㅠ</h2></div>

	<div id="div1" class="card-header">
	<div id="qArea">
		<div id="qmark">
		<img src="resources/images/host/common/question.png" width="50px">
		</div>
		<div id="qtArea">
		<div id="qctArea"></div>
		<div id="qcnArea"></div>
		</div>
		<div id="qiArea">&nbsp;&nbsp;&nbsp;
			공개 
		&nbsp;&nbsp;&nbsp;</div>
	</div>
	<div id="aArea">
		<div id="amark">
			<img src="resources/images/host/common/warning.png" width="50px">
		</div>
		<div id="ansArea">
		<textarea></textarea></div>
		<textarea name="answer" id="answer"></textarea></div>
	</div>
	<div id="bArea"><button id="addAnswer" class="btn btn-info">저장</button></div>
	</div>
			<div> <ul class="pagination pagination-sm">
	    <li class="page-item disabled">
	      <a class="page-link" href="#">&laquo;</a>
	    </li>
	    <li class="page-item active">
	      <a class="page-link" href="#">1</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">2</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">3</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">4</a>
	    </li>				
	    <li class="page-item">
	      <a class="page-link" href="#">5</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">&raquo;</a>
    </li>
  </ul></div>
	</div>
	</div>
	 <script>
		 $(function(){
			selectCalList(0);
			
		});
    </script>
	
</body>
</html>