<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../common/header.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

    <div class="outer">
        <h1>공지사항</h1>
        <div class="tagWrap">
            <span class="tag tagactive">전체</span>
            <span class="tag">공지</span>
            <span class="tag">이벤트</span>
        </div>
        <ul class="noticelist">
            <li>
                <div class="noticewrap">
                    <div class="noticeTagN">
                        공지
                    </div>
                    <div class="noticeTitle">
                        공지제목1
                    </div>
                    <div class="noticedate">
                        2019-09-25 00:46
                    </div>
                </div>
                <div class="noticecontent">
                    공지내용
                </div>
            </li>
            <li>
                <div class="noticewrap">    
                    <div class="noticeTagN">
                        공지
                    </div>
                    <div class="noticeTitle">
                        공지제목2
                    </div>
                    <div class="noticedate">
                        2019-09-25 01:46
                    </div>
                </div>
                <div class="noticecontent">
                    공지내용123
                </div>
            </li>
        </ul>
    </div>


<%@ include file='../common/footer.jsp' %>
<script>
	var nowCategory="전체";
	$(function(){
		loadNotice("전체",1);
		$(document).on("click",".tag",function(e){
			$(".tag").removeClass("tagactive");
			$(this).addClass("tagactive");
			nowCategory=$(this).text();
			loadNotice(nowCategory,1);
        });
		$(document).on("click",".footer>button",function(e){
    		e.preventDefault();
    		$(".footer>button").removeClass("tagactive");
    		$(this).addClass("tagactive");
    		var page=$(this).text();
    		var category=$(".tagWrap").find(".tacactive").text();
    		console.log(category);
    		loadNotice(nowCategory,page);
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
    				loadNotice(nowCategory,page);
    			}else if(btn=="<"){
    				preBtn.addClass("tagactive");
    				loadNotice(nowCategory,currentPage);
    			}
    		}
    	});
    	$(document).on("click",".rightbtn>button",function(e){
    		e.preventDefault();
    		var category=$(".tagWrap>.tacactive").text();
    		var btn=$(this).text();
    		console.log(btn);
    		if(currentPage<endPage){
    			currentPage=currentPage+1;
    			var nextBtn=$(".footer>.tagactive").next();
    			$(".footer>button").removeClass("tagactive");
    			if(btn==">>"){
    				$(".footer>button").eq(0).addClass("tagactive");
    				var page=endPage;
    				loadNotice(nowCategory,page);
    			}else if(btn==">"){
    				nextBtn.addClass("tagactive");
    				loadNotice(nowCategory,currentPage);
    			}
    		}
    	});
    	$(document).on("click",".noticewrap",function(e){
    		e.preventDefault();
    		$(".noticecontent").remove();
    		var wrap=$(this).parent();
    		var nNo=$(this).children().eq(0).attr("id");
    		loadMainNoticeContent(wrap,nNo);
        });
	});
	function loadNotice(category,page){
		var $noticeList=$(".noticelist");
		$noticeList.html("");
		$.ajax({
			url:"loadNotice.no",
			data:{category:category,page:page},
			dataType:"json",
			success:function(data){
				$.each(data,function(i,v){
					var $li=$("<li>");
					var $noticeWrap=$("<div class='noticewrap'>");
					if(v.nCategory=="공지"){
						var $noticeTagN=$("<div class='noticeTagN'>").text(v.nCategory).attr("id",v.nNo);
						$noticeWrap.append($noticeTagN);
					}else if(v.nCategory=="이벤트"){
						var $noticeTagE=$("<div class='noticeTagE'>").text(v.nCategory).attr("id",v.nNo);
						$noticeWrap.append($noticeTagE);
					}
					var $noticeTitle=$("<div class='noticeTitle'>").text(v.nTitle);
					var $noticeDate=$("<div class='noticedate'>").text(v.sDate);
					$noticeWrap.append($noticeTitle);
					$noticeWrap.append($noticeDate);
					$li.append($noticeWrap);
					$noticeList.append($li);
				});
				paging(category,page);
			},
			error:function(){
				console.log("공지 불러오기 실패");
			}
		})
	}
	var listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage;
	function paging(category,page){
    	var $content=$(".outer");
    	$(".footer").remove();
    	var $footer = $("<div class='footer'>");
    	$content.append($footer);
    	currentPage=page;
    	$.ajax({
				url : "mainNotice.count",
				data:{category:category},
				success : function(data) {
						listCount = data;
						pageLimit = 10;
						boardLimit = 20;
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
	function loadMainNoticeContent(wrap,nNo){
		$.ajax({
			url:"loadNoticeContent.no",
			data:{nNo:nNo},
			success:function(data){
				var $noticeContent=$("<div class='noticecontent'>").html(data.replace(/\n/gi,"<br//>"));
				wrap.append($noticeContent);
			},
			error:function(){
				console.log(loadMainNoticeContent)
			}
		});
	}
</script>
</body>
</html>