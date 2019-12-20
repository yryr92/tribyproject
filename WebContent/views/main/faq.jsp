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
        <h1>자주 묻는 질문</h1>
        <form action="" class="faqsearch">
            <input type="text" placeholder="키워드를 입력하세요">
        </form>
        <div class="tagWrap">
            <span class="tag tagactive">전체</span>
            <span class="tag">이용안내</span>
            <span class="tag">회원정보</span>
            <span class="tag">결제/환불</span>
            <span class="tag">쿠폰</span>
            <span class="tag">호스트신청</span>
            <span class="tag">기타</span>
        </div>
        <ul class="faqwrap">
            <li>
                <div class="faqtitle">트리비란?</div>
                <div class="faqcontent">트리비입니다</div>
            </li>
            <li>
                <div class="faqtitle">트리비 이용방법</div>
                <div class="faqcontent">검색해서 즐기시길 바랍니다</div>
            </li>

        </ul>
        <div class="footer">
            <div class="leftbtn">
                <button>&lt;&lt;</button>
                <button>&lt;</button>
            </div>
            <button>1</button>
            <button>2</button>
            <button>3</button>
            <button>4</button>
            <button>5</button>
            <button>6</button>
            <button>7</button>
            <button>8</button>
            <button>9</button>
            <button>10</button>
            <div class="rightbtn">
                <button>&gt;</button>
                <button>&gt;&gt;</button>
            </div>
        </div>

    </div>

<%@ include file='../common/footer.jsp' %>
<script>
	var keyword="전체";
	$(function(){
		loadFaq(keyword,1);
		
		$(document).on("click",".footer>button",function(e){
    		e.preventDefault();
    		$(".footer>button").removeClass("tagactive");
    		$(this).addClass("tagactive");
    		var page=$(this).text();
    		var category=$(".tagWrap").find(".tacactive").text();
    		console.log(category);
    		loadFaq(keyword,page);
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
    				loadFaq(keyword,page);
    			}else if(btn=="<"){
    				preBtn.addClass("tagactive");
    				loadFaq(keyword,currentPage);
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
    				loadFaq(keyword,page);
    			}else if(btn==">"){
    				nextBtn.addClass("tagactive");
    				loadFaq(keyword,currentPage);
    			}
    		}
    	});
    	$(document).on("keyup",".faqsearch>input",function(e){
    		keyword=$(this).val();
    		loadFaq(keyword,1);
    	});
    	$(".tag").click(function(){
            $(".tag").removeClass("tagactive");
            $(this).addClass("tagactive");
            keyword=$(this).text();
            loadFaq(keyword,1);
        });
    	$(document).on("click",".faqtitle",function(e){
            $(".faqcontent").css("display","none");
            $(".faqtitle").css("font-weight","inherit")
            $(this).next().css("display","block");
            $(this).css("font-weight","bold");
        });
	})
	function loadFaq(key,page){
		var $faqWrap=$(".faqwrap");
		$faqWrap.html("");
		$.ajax({
			url:"loadMainFaq.fq",
			data:{key:key,page:page},
			dataType:"json",
			success:function(data){
				$.each(data,function(i,v){
					var $li=$("<li>");
					var $faqTitle=$("<div class='faqtitle'>").attr("id",v.no).text(v.title);
					var $faqContent=$("<div class='faqcontent'>").html(v.content.replace(/\n/gi,"<br//>"));
					$li.append($faqTitle).append($faqContent);
					$faqWrap.append($li);
				});
				paging(key,page);
			},
			error:function(){
				console.log("faq불러오기 실패");
			}
		});
		
	}
	var listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage;
	function paging(key,page){
    	var $content=$(".outer");
    	$(".footer").remove();
    	var $footer = $("<div class='footer'>");
    	$content.append($footer);
    	currentPage=page;
    	$.ajax({
				url : "loadMainFaq.count",
				data:{key:key},
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
</script>
</body>
</html>