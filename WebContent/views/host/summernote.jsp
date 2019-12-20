<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>
    <script src="lang/summernote-ko-KR.js"></script>
<style>
	#wrap{
		float:left;
		margin: 1%;
		font-family: 'Noto Sans KR', sans-serif;
		width:80%;
	}
	#title{font-size:18px; font-weight:bold; margin-bottom:1rem;}
	#content{width:100%; height:77vh; margin: 0; padding:1rem 1rem 1rem 2rem; overflow-y: auto;}
</style>
</head>
<body>
	<div id="wrap">
	<div id="title">summernote 테스트</div>
	<div id="content" class="jumbotron">
	<div id="top">
	</div>
	<br style="clear:both">
	<hr>
	<div id="article">
	<form method="post" action="<%= request.getContextPath()%>/insert.su"><br>
   <input type="text" name="title" size="30" placeholder="제목을 입력하세요"><br><br>
    <textarea name="contents" id="summernote"></textarea><br>
	<input type="submit" value="submit">
    </form>
	</div>
	</div>
	</div>
	
	<script>
	$(function(){
		 $('#summernote').summernote({
		        placeholder: 'Try new hobby',
		        tabsize: 2,
		        height: 330,
		        lang: 'ko-KR'
		      });
	});
	</script>
	
</body>
</html>