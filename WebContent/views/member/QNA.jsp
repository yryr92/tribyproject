<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int hNo=(int)request.getAttribute("hNo");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../common/header.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="qnaListWrap">
        <div class="qnaHead">
            <h1>문의사항</h1>
            <button class="QwriteForm">문의하기</button>
        </div>
        <div class="qnaList">
            <div class="nothave">
                <p>문의내역이 없습니다</p>
            </div>
            
                
        </div>
    </div>

<%@ include file='../common/footer.jsp' %>
<script>
	$(function(){
		loadMyQna(1);
        	$(document).on("click",".footer>button",function(e){
        		e.preventDefault();
        		$(".footer>button").removeClass("tagactive");
        		$(this).addClass("tagactive");
        		var page=$(this).text();
        		var category=$(".tagWrap").find(".tacactive").text();
        		console.log(category);
        		loadMyQna(page);
        	});
        	$(document).on("click",".leftbtn>button",function(e){
        		e.preventDefault();
        		var category=$(".tagWrap .tacactive").text();
        		var btn=$(this).text();
        		if(currentPage>1){
        			currentPage=currentPage-1;
        			var preBtn=$(".footer>.tagactive").prev();
        			$(".footer>button").removeClass("tagactive");
        			if(btn=="<<"){
        				$(".footer>button").eq(0).addClass("tagactive");
        				var page=1;
        				loadMyQna(page);
        			}else if(btn=="<"){
        				preBtn.addClass("tagactive");
        				loadMyQna(page);
        			}
        		}
        	});
        	$(document).on("click",".footer>button",function(e){
        		e.preventDefault();
        		$(".footer>button").removeClass("tagactive");
        		$(this).addClass("tagactive");
        		var page=$(this).text();
        		var category=$(".tagWrap").find(".tacactive").text();
        		console.log(category);
        		loadMyQna(page);
        	});
        	$(document).on("click",".qnaAnswer",function(e){
        		e.preventDefault();
        		var qNo=$(this).find("a").attr("href");
        		loadQcontent(qNo);
        	});
        	$(document).on("click",".qnaBack",function(e){
        		e.preventDefault();
        		loadMyQna(currentPage);
        	});
        	$(document).on("click",".qWriteBtn",function(e){
        		e.preventDefault();
        		QnAwriteForm();
        	});
        	$(document).on("click","#qnaWrite",function(e){
        		e.preventDefault();
        		var title=$(".qTitle").val();
        		var content=$("#qWrite").val();
        		insertMyQna(title,content);
        	});
        	
	});
	function loadMyQna(page){
		$.ajax({
			url:"QNA.me",
			data:{page:page},
			dataType:"json",
			success:function(data){
				var $qnaList=$(".qnaList");
				$qnaList.html("")
				$(".qnaHead").html("").append($("<h1>").text("문의하기")).append($("<a class='qWriteBtn'>").text("문의하기").attr("href","<%=hNo%>"));
				if(data.length==0){
					$qnaList.append($("<div class='nothave'>").append($("<p>").text("문의가 존재하지 않습니다")));
				}else{
					$.each(data,function(i,v){
						var $QNA=$("<div class='QNA'>");
						var $qnaWrap=$("<div class='qnaWrap'>");
						var $qnaTitle=$("<div class='qnaTitle'>");
						var $hostProfile=$("<div class='hostProfile'>").append($("<img>").attr("src","/triby/resources/images/host/profile/"+v.qContent));
						var $qnaName=$("<div class='qnaName'>");
						var $myQnaTitle=$("<div clas='myQnaTitle'>").text(v.qTitle);
						var $QhostName=$("<div clas='QhostName'>").text(v.user_name);
						var $qDate=$("<div clas='qDate'>").text(v.qDate+" 작성");
						$qnaName.append($myQnaTitle);
						$qnaName.append($QhostName);
						$qnaName.append($qDate);
						$qnaTitle.append($hostProfile);
						$qnaTitle.append($qnaName);
						var $qnaAnswer=$("<div class='qnaAnswer'>");
						if(v.qStatus=='Y'){
							$qnaAnswer.append($("<div class='answered'>").append($("<a>").attr("href",v.qNo).text("답변완료")));
						}else{
							$qnaAnswer.append($("<div class='notAnswer'>").append($("<a>").attr("href",v.qNo).text("답변대기")));
						}
						$qnaWrap.append($qnaTitle)
						$qnaWrap.append($qnaAnswer)
						$qnaList.append($QNA.append($qnaWrap));
					});
					paging(page);
				}
			},
			error:function(){
				console.log("QNA.me error");	
			}
		});
	}
	var listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage;
	function paging(page){
    	var $content=$(".qnaListWrap");
    	$(".footer").remove();
    	var $footer = $("<div class='footer'>");
    	$content.append($footer);
    	currentPage=page;
    	$.ajax({
				url : "QNA.count",
				success : function(data) {
						listCount = data;
						pageLimit = 5;
						boardLimit = 5;
						maxPage = Math.ceil(listCount / boardLimit);
						startPage = (Math.floor((currentPage - 1) / pageLimit))
								* pageLimit + 1;
						endPage = startPage + pageLimit - 1;

						if (endPage > maxPage) {
							endPage = maxPage;
						}
					var $leftbtn = $("<div class='leftbtn'>");
					var $ltlt = $("<button>").text("<<");
					var $lt = $("<button>").text("<");
					$leftbtn.append($ltlt).append($lt);
					$footer.append($leftbtn);
					var $rightbtn = $("<div class='rightbtn'>");
					var $gt = $("<button>").text(">");
					var $gtgt = $("<button>").text(">>");
					$rightbtn.append($gt).append($gtgt);
					
					for (var i = startPage; i <= endPage; i++) {
						if (i == currentPage) {
							var btn = $("<button class='tagactive'>").text(i);
						} else {
							var btn = $("<button>").text(i);
						}
						$footer.append(btn);
					}
					$footer.append($rightbtn);

				},
				error : function() {
					console.log("listCount 통신오류");
				}

			});
		}
	function loadQcontent(qNo){
		$.ajax({
			url:"loadQcontent.me",
			data:{qNo:qNo},
			dataType:"json",
			success:function(data){
				$(".qnaHead").html("").append($("<h1>").text(data.qTitle)).append($("<a class='qnaBack'>").text("뒤로가기").attr("href","<%=hNo%>"));
				var $qnaList=$(".qnaList");
				$qnaList.html("")
				var $QNA=$("<div class='QNA'>");
				var $qContentWrap=$("<div class='qContentWrap'>").append($("<div class='qContent'>").text(data.qContent.replace(/\n/gi,"<br//>")));
				$QNA.append($qContentWrap);
				if(data.qStatus=='Y'){
					var $hostAnswerWrap=$("<div class='hostAnswerWrap'>");
					var $aContentHead=$("<div class='aContentHead'>").append($("<div class='hName'>").text(data.user_name)).append($("<div class='qDate'>").text(data.aDate+" 답변함"));
					var $aContent=$("<div class='aContent'>").text(data.qAnswer.replace(/\n/gi,"<br//>"));
					$hostAnswerWrap.append($aContentHead);
					$hostAnswerWrap.append($aContent);
					$QNA.append($hostAnswerWrap);
				}
				$qnaList.append($QNA);
				$(".footer").remove();
			},
			error:function(){
				console.log("loadQcontent error");
			}
		});
	}
	function QnAwriteForm(){
		$.ajax({
			url:"qnaHostName.me",
			data:{hNo:<%=hNo%>},
			success:function(data){
				$(".qnaHead").html("").append($("<h1>").text(data+" 님께")).append($("<a class='qnaBack'>").text("뒤로가기").attr("href","<%=hNo%>"));
				var $qnaList=$(".qnaList");
				$qnaList.html("")
				var $QNA=$("<div class='QNA'>");
				var $qContentWrap=$("<div class='qContentWrap'>").append($("<input type='text' class='qTitle' placeholder='제목을 입력해주세요'>"));
				$QNA.append($qContentWrap);
				var $hostAnswerWrap=$("<div class='hostAnswerWrap'>");
				var $aContent=$("<div class='aContent'>").append( $("<textarea id='qWrite' cols='80' rows='10' style='resize:none;border-style:none;' placeholder='문의하실 내용을 작성해주세요.'>")).append($("<button id='qnaWrite'>").text("작성하기"));
				$hostAnswerWrap.append($aContent);
				$QNA.append($hostAnswerWrap);
				$qnaList.append($QNA);
				$(".footer").remove();
			},
			error:function(){
				console.log("qnaHostName.me");
			}
		});
	}
	function insertMyQna(title,content){
		$.ajax({
			url:"insertQna.me",
			data:{hNo:<%=hNo%>,title:title,content:content},
			type:"post",
			success:function(e){
				if(e>0){
					alert("성공적으로 작성되었습니다.");
					location.reload();
				}else{
					alert("작성 실패");
				}
				
			},
			error:function(){
				console.log("insertQna error");
			}
		});
	}
</script>
</body>
</html>