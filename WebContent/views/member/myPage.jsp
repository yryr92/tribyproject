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
		<div class="profileWrap">
			<div class="profile">
				<input type="file" accept=".jpg, .jpeg, .png">
				<div class="pic">
					<img src="/triby/resources/images/user/profile/user.png" alt="">
				</div>
				<div class="userinfo">
					<div class="nickname">트리비대원</div>
					<div class="edit">변경</div>
				</div>
			</div>
			<div class="coupon">
				<h3>쿠폰</h3>
				<div class="count">3개</div>
			</div>
		</div>
		<hr>
		<div class="infoWrap">
			<div class="navWrap">
				<ul>
					<a href="myLike" class="nav">좋아요</a>
					<a href="myTriby" class="nav">내 트리비</a>
					<a href="myCoupon" class="nav">쿠폰</a>
					<a href="myProfile" class="nav">프로필 수정</a>
				</ul>
			</div>
			<div class="contentWrap">
				<div class="subnav">
					<a href="myLikeTriby" class="tagactive aa">트리비</a> <a href="myLikeHost" class="aa">호스트</a>
				</div>
				<div class="content">
					
					
            </div>
        </div>
    </div>
</div>
<%@ include file='../common/footer.jsp' %>
	<script>
    $(function(){
    	$(window).on("popstate",function(e){
    		refresh();
    		console.log(e.state);
    	})

    	refresh();// 페이지 다시불러오기
		reviewPoint=5;//리뷰포인트초기화용
    	$(".nav").click(function(e){//사이드버튼
    		e.preventDefault();
    		$(".nav").removeClass("tagactive");
    		$(this).addClass("tagactive");
    		var $URL=$(this).attr("href") // myLikeTriby, my
    		var $cWrap=$(".contentWrap");
    		$(".contentWrap").html("");
			var $subnav=$("<div class='subnav'>");
			var $content=$("<div class='content'>");
			var $a1, $a2, $a3, $span;
			switch($URL){//어떤버튼을 눌렀는지에따라 다른 서브메뉴생성
			case "myLike":
				$a1=$("<a href='myLikeTriby' class='aa'>").text("트리비");
				$a2=$("<a href='myLikeHost' class='aa'>").text("호스트");
				$subnav.append($a1);
				$subnav.append($a2);
				break;
			case "myTriby":
				$a1=$("<a href='myTribyPre' class='aa'>").text("이용가능");
				$a2=$("<a href='myTribyHistory' class='aa'>").text("신청 내역");
				$a3=$("<a href='myReview' class='aa'>").text("후기");
				$subnav.append($a1);
				$subnav.append($a2);
				$subnav.append($a3);break;
			case "myCoupon":
				$span=$("<span>").text("쿠폰");
				$subnav.append($span);
				loadContent($URL,1);break;
			case "myProfile":
				$span=$("<span>").text("내 프로필");
				$subnav.append($span);
				loadContent($URL,1);break;
			}
			$cWrap.append($subnav);
			$cWrap.append($content);
    		$(".subnav").children().eq(0).click();//첫번째 서브메뉴 클릭
    	});
    	$(document).on("click",".aa",function(e){//서브메뉴
    		e.preventDefault();
    		$(".aa").removeClass("tagactive");
    		$(this).addClass("tagactive");
    		var $URL=$(this).attr("href");
    		loadContent($URL,1);//서브메뉴에 따른 컨텐츠 불러오기
    	});
    	$(".pic").click(function(){//사진 업로드용 클릭이벤트
    		$(".profile>input").click();
				
    	});
    	$(".profile>input").change(function(e){
    		uploadProfileImg();//업로드해줄 메소드
    				
    	});
    	$(document).on("click",".footer>button",function(e){//페이징 버튼
    		e.preventDefault();
    		$(".footer>button").removeClass("tagactive");
    		$(this).addClass("tagactive");
    		var URL=location.pathname;
    		var page=$(this).text();
        	URL=URL.replace("/triby/","");
    		loadContent(URL,page);
    	});
    	$(document).on("click",".leftbtn>button",function(e){
    		e.preventDefault();
    		var btn=$(this).text();
    		var URL=location.pathname;
        	URL=URL.replace("/triby/","");
    		if(currentPage>1){
    			currentPage=currentPage-1;
    			var preBtn=$(".footer>.tagactive").prev();
    			$(".footer>button").removeClass("tagactive");
    			if(btn=="<<"){
    				$(".footer>button").eq(0).addClass("tagactive");
    				var page=1;
    				loadContent(URL,page);
    			}else if(btn=="<"){
    				preBtn.addClass("tagactive");
    				loadContent(URL,currentPage);
    			}
    		}
    	});
    	$(document).on("click",".rightbtn>button",function(e){
    		e.preventDefault();
    		var btn=$(this).text();
    		console.log(btn);
    		var URL=location.pathname;
        	URL=URL.replace("/triby/","");
    		if(currentPage<endPage){
    			currentPage=currentPage+1;
    			var nextBtn=$(".footer>.tagactive").next();
    			$(".footer>button").removeClass("tagactive");
    			if(btn==">>"){
    				$(".footer>button").eq(0).addClass("tagactive");
    				var page=endPage;
    				loadContent(URL,page);
    			}else if(btn==">"){
    				nextBtn.addClass("tagactive");
    				loadContent(URL,currentPage);
    			}
    		}
    	});
    	$(document).on("click",".categoryBtn",function(e){//카테고리 선택시 스타일 변경
    		$(this).toggleClass("categoryChecked");
    	});
    	
    	$(document).on("click","#updateCategory",function(e){
    		e.preventDefault();
    		updateMyCategory();//프로필 저장용
    	});
    	$(document).on("click",".writeAreview",function(e){//리뷰 작성하러가기
    		e.preventDefault();
    		var pNo=$(this).children().attr("href");
    		writeAreviewForm(pNo);
    	});
    	$(document).on("click","#writeReview",function(e){
    		e.preventDefault();
    		var pNo=$("#writeReview>a").attr("href");//이건 replace안함
    		var hNo=$(".host>a").attr("href").replace("detail.ho?hNo=","");//링크작업후 replace할것
    		insertReview(pNo,hNo,reviewPoint);
    	});
        $(document).on("click",".reviewStar",function(){
            $(".reviewStar").attr("src","/triby/resources/images/common/staroff.png");
        });
        $(document).on("click","#point1",function(){
            $(".reviewStar").eq(0).attr("src","/triby/resources/images/common/staron.png");
            reviewPoint=1;
        });
        $(document).on("click","#point2",function(){
            $(".reviewStar").eq(0).attr("src","/triby/resources/images/common/staron.png");
            $(".reviewStar").eq(1).attr("src","/triby/resources/images/common/staron.png");
            reviewPoint=2;
        });
        $(document).on("click","#point3",function(){
            $(".reviewStar").eq(0).attr("src","/triby/resources/images/common/staron.png");
            $(".reviewStar").eq(1).attr("src","/triby/resources/images/common/staron.png");
            $(".reviewStar").eq(2).attr("src","/triby/resources/images/common/staron.png");
            reviewPoint=3;
        });
        $(document).on("click","#point4",function(){
            $(".reviewStar").eq(0).attr("src","/triby/resources/images/common/staron.png");
            $(".reviewStar").eq(1).attr("src","/triby/resources/images/common/staron.png");
            $(".reviewStar").eq(2).attr("src","/triby/resources/images/common/staron.png");
            $(".reviewStar").eq(3).attr("src","/triby/resources/images/common/staron.png");
            reviewPoint=4;
        });
        $(document).on("click","#point5",function(){
            $(".reviewStar").eq(0).attr("src","/triby/resources/images/common/staron.png");
            $(".reviewStar").eq(1).attr("src","/triby/resources/images/common/staron.png");
            $(".reviewStar").eq(2).attr("src","/triby/resources/images/common/staron.png");
            $(".reviewStar").eq(3).attr("src","/triby/resources/images/common/staron.png");
            $(".reviewStar").eq(4).attr("src","/triby/resources/images/common/staron.png");
            reviewPoint=5;
        });
        $(document).on("click",".updateReview",function(e){
        	e.preventDefault();
        	$(this).toggleClass("updateSubmit");
        	var writeWrap=$(this).parent().parent().children().eq(0);
        	var rNo=$(this).attr("href");
        	updateReviewForm(writeWrap,rNo);
        	
        });
        $(document).on("click",".deleteReview",function(e){
        	e.preventDefault();
        	if(confirm("정말 삭제하시겠습니까?")){
        		var rNo=$(this).attr("href");
        		deleteReview(rNo);
        	}
        });
        $(document).on("click",".updateSubmit",function(e){
        	e.preventDefault();
        	var rNo=$(this).attr("href");
        	var content=$(this).parent().parent().children().eq(0).children().eq(1).children().val();
        	updateReview(rNo,content,reviewPoint);
        });
        $(document).on("click",".tribyCancel a",function(e){
        	e.preventDefault();
        	var pNo=$(this).attr("href");
        	tribyCancel(pNo);
        });
        $(document).on("click",".edit",function(e){
        	$(".nav").eq(3).click();
        });
        $(document).on("click",".coupon",function(e){
        	$(".nav").eq(2).click();
        });
        $(document).on("click",".heart1",function(e){
        	e.preventDefault();
        	$(this).removeClass("heart1").addClass("heart0").attr("src","/triby/resources/images/common/heart0.png");
        	var tNo=$(this).parent().parent().parent().parent().attr("href").replace("detail.ma?tNo=","");
        	removeLikeTriby(tNo);
        });
        $(document).on("click",".heart0",function(e){
        	e.preventDefault();
        	$(this).removeClass("heart0").addClass("heart1").attr("src","/triby/resources/images/common/heart1.png");
        	var tNo=$(this).parent().parent().parent().parent().attr("href").replace("detail.ma?tNo=","");
        	addLikeTriby(tNo);
        });
        $(document).on("click",".hostHeart1",function(e){
        	e.preventDefault();
        	$(this).removeClass("hostHeart1").addClass("hostHeart0").attr("src","/triby/resources/images/common/heart0.png");
        	var hNo=$(this).parent().parent().children().eq(0).attr("href");
        	removeLikeHost(hNo);
        });
        $(document).on("click",".hostHeart0",function(e){
        	e.preventDefault();
        	$(this).removeClass("hostHeart0").addClass("hostHeart1").attr("src","/triby/resources/images/common/heart1.png");
        	var hNo=$(this).parent().parent().children().eq(0).attr("href");
        	addLikeHost(hNo);
        });
        $(document).on("click",".pwChange",function(e){
        	e.preventDefault();
        	pwChangeForm();
        });
        $(document).on("submit","#updatePw",function(e){
        	e.preventDefault();
        	var pw=$(this).find("input").eq(0);
        	var pw1=$(this).find("input").eq(1);
        	var pw2=$(this).find("input").eq(2);
        	
        	var reg=/^[a-z0-9!@#$%^&*]{6,}$/;
        	
        	if(pw.val().trim()==""||pw1.val().trim()==""||pw2.val().trim()==""){
        		alert("비밀번호를 입력해주세요");
        		if(pw.val().trim()==""){
        			pw.focus();
        		}else if(pw1.val().trim()==""){
        			pw1.focus();
        		}else{
        			pw2.focus();
        		}
        		return;
        	}
        	if(pw.val()!="<%=loginUser.getPw()%>"){
        		alert("현재 비밀번호가 일치하지 않습니다.");
        		pw.val("").focus();
        		return;
        	}
        	if(!reg.test(pw1.val())){
        		alert("영문자,숫자,특수문자를 포함하는 6자 이상의 비밀번호를 입력해주세요.");
        		pw1.val("").focus();
        		pw2.val("");
        		return;
        	}
        	if(pw1.val()!=pw2.val()){
        		alert("다시 입력한 비밀번호와 일치하지 않습니다.");
        		return;
        	}
        	updateMyPw(pw1.val());
        	
        });
    });
    function renewUrl(title, url){
    	history.replaceState(null, title, url);
    }
    function refresh(){
    	var URL=location.pathname;
    	URL=URL.replace("/triby/","");
    	var $subnav=$(".subnav");
    	$subnav.html("");
		$.ajax({
			url:"userProfile.me",
			dataType:"json",
			success:function(data){
				$(".pic img").attr("src","/triby/resources/images/user/profile/"+data.profile);
				$(".count").text(data.uNo+"개");
				$(".nickname").text(data.name);
				//loadContent(URL,1);
				
				switch(URL){
				case "myLikeTriby":
					$a1=$("<a href='myLikeTriby' class='aa tagactive'>").text("트리비");
					$a2=$("<a href='myLikeHost' class='aa'>").text("호스트");
					$subnav.append($a1);
					$subnav.append($a2);
					loadContent(URL,1);
					break;
				case "myLikeHost":
					$a1=$("<a href='myLikeTriby' class='aa'>").text("트리비");
					$a2=$("<a href='myLikeHost' class='aa tagactive'>").text("호스트");
					$subnav.append($a1);
					$subnav.append($a2);
					loadContent(URL,1);
					break;
				case "myTribyPre":
					$a1=$("<a href='myTribyPre' class='aa tagactive'>").text("이용가능");
					$a2=$("<a href='myTribyHistory' class='aa'>").text("신청 내역");
					$a3=$("<a href='myReview' class='aa'>").text("후기");
					$subnav.append($a1);
					$subnav.append($a2);
					$subnav.append($a3);
					loadContent(URL,1);break;
				case "myTribyHistory":
					$a1=$("<a href='myTribyPre' class='aa'>").text("이용가능");
					$a2=$("<a href='myTribyHistory' class='aa tagactive'>").text("신청 내역");
					$a3=$("<a href='myReview' class='aa'>").text("후기");
					$subnav.append($a1);
					$subnav.append($a2);
					$subnav.append($a3);
					loadContent(URL,1);break;
				case "myReview":
					$a1=$("<a href='myTribyPre' class='aa'>").text("이용가능");
					$a2=$("<a href='myTribyHistory' class='aa'>").text("신청 내역");
					$a3=$("<a href='myReview' class='aa tagactive'>").text("후기");
					$subnav.append($a1);
					$subnav.append($a2);
					$subnav.append($a3);
					loadContent(URL,1);break;
				case "myCoupon":
					$span=$("<span>").text("쿠폰");
					$subnav.append($span);
					loadContent(URL,1);break;
				case "myProfile":
					$span=$("<span>").text("내 프로필");
					$subnav.append($span);
					loadContent(URL,1);break;
				}
				var $nav=$(".nav");
				$nav.removeClass("tagactive");
				switch(URL){
				case "myLikeTriby":$nav.parent().children().eq(0).addClass("tagactive");break;
				case "myTribyPre":$nav.parent().children().eq(1).addClass("tagactive");break;
				case "myCoupon":$nav.parent().children().eq(2).addClass("tagactive");break;
				case "myProfile":$nav.parent().children().eq(3).addClass("tagactive");break;
				}
			},
			error:function(){
				console.log("통신오류")
			}
		});
    }
    function loadContent(url, page){
    	$.ajax({
    		url:url+".me",
    		data:{page:page},
    		type:"post",
    		dataType:"json",
    		success:function(data){
    				var $content=$(".content");
    				$content.html("");
    			
    				if(data.length==0){
    					var $nothave=$("<div class='nothave'>").append($("<p>").text("아직 아무것도 없습니다"));
    					$content.append($nothave);
    					renewUrl("",url);
    				}else{
    			switch(url){
    			case "myLikeTriby":
    				var $likeWrap=$("<div class='likeWrap'>")
    				$content.append($likeWrap);
    					
    				$.each(data, function(index, value){
    					
    				var $a=$("<a>").attr("href","detail.ma?tNo="+value.tNo);
    				var $tribyWrap=$("<div class='tribyWrap'>");
    				var $triby=$("<div class='triby'>");
    				var $tribytop=$("<div class='tribytop'>");
    				var $likebtn=$("<div class='likebtn'>");
    				var $heart=$("<img class='heart1'>").attr("src","/triby/resources/images/common/heart1.png");
    				$likebtn.append($heart);
    				var $tribythumb=$("<div class='tribythumb'>");
    				var $thumb=$("<img width='310'>").attr("src","/triby/resources/images/triby/"+value.tImg);
    				$tribythumb.append($thumb);
    				$tribytop.append($likebtn);
    				$tribytop.append($tribythumb);
    				var $tribyname=$("<div class='tribyname'>").text(value.tName);
    				var $tribyprice=$("<div class='tribyprice'>").text(value.tPrice+"원");
    				var $tribyPoint=$("<div class='tribyPoint'>");
    				var $star=$("<img>").attr("src","/triby/resources/images/common/staron.png");
    				if(value.point!=0){
    					$tribyPoint.append($star);
    					$tribyPoint.append($("<span>").text(value.point+"점"));
    				}
    				$tribyWrap.append($tribytop);
    				$tribyWrap.append($tribyname);
    				$tribyWrap.append($tribyprice);
    				$tribyWrap.append($tribyPoint);
    				$a.append($tribyWrap);
    				$triby.append($a)
    				$likeWrap.append($triby);
    				})
    				paging(page,url);
    				renewUrl("좋아요",url);break;
    				
    			case "myLikeHost":
    				var $likeWrap=$("<div class='likeWrap'>")
    				$content.append($likeWrap);
    				$.each(data, function(index, value){
    					var $hostWrap=$("<div class='hostWrap'>");
    					var $a=$("<a>").attr("href",value.hNo);
    					var $host=$("<div class='host'>");
    					var $hostThumb=$("<div class='hostThumb'>");
    					var $hImg=$("<img>").attr("src","/triby/resources/images/host/profile/"+value.hImg);
    					$hostThumb.append($hImg);
    					var $hostInfo=$("<div class='hostInfo'>");
    					var $h4=$("<h4>").text(value.hName);
    					var $h6=$("<h6>").text("트리비 "+value.tCount+"| 후기 "+value.rvCount+" | 좋아요 "+value.likeCount);
    					$hostInfo.append($h4).append($h6);
    					$host.append($hostThumb).append($hostInfo);
    					var $hostlikebtn=$("<div class='hostlikebtn'>");
    					var heart=$("<img class='hostHeart1'>").attr("src","/triby/resources/images/common/heart1.png");
    					$hostlikebtn.append(heart);
    					$a.append($host);
    					$hostWrap.append($a).append($hostlikebtn);
    					$likeWrap.append($hostWrap);
    				});
    					paging(page,url);
    					renewUrl("좋아요",url);break;
    					
    					
    			case "myTribyPre":
    				var $myTribyListWrap=$("<div class='myTribyListWrap'>");
    				$content.append($myTribyListWrap);
    				$.each(data, function(i,v){
    					var $myTribyWrap=$("<div class='myTribyWrap'>");
    					var $myTribyTop=$("<div class='myTribyTop'>").append($("<span>").text(v.pDate+" | ")).append($("<span>").text("수량 "+v.amount));
    					var $myTribyMid=$("<div class='myTribyMid'>");
    					var $myTribyInfoWrap=$("<div class='myTribyInfoWrap'>");
    					var $myTribyThumb=$("<div class='myTribyThumb'>").append($("<img>").attr("src","/triby/resources/images/triby/"+v.img));
    					var $myTribyTitle=$("<div class='myTribyTitle'>").append($("<h4>").text(v.title)).append($("<h5>").text(v.address)).append($("<div class='host'>").append($("<a>").attr("href","detail.ho?hNo="+v.hNo).text(v.hostName)));
    					$myTribyInfoWrap.append($myTribyThumb).append($myTribyTitle);
    					var $a1=$("<a>").attr("href","detail.ma?tNo="+v.tNo).text("상세보기");
    					$myTribyMid.append($myTribyInfoWrap).append($a1);
    					var $myTribyBot=$("<div class='myTribyBot'>");
    					var $myTribyDateWrap=$("<div class='myTribyDateWrap'>").append($("<div>").text(v.tDate)).append($("<div>").text(v.amount+" 인")).append($("<div>").text(v.price+"원"));
    					var $tribyCancel=$("<div class='tribyCancel'>").append($("<a>").attr("href",v.pNo).text("취소하기"));
    					$myTribyBot.append($myTribyDateWrap).append($tribyCancel);
    					$myTribyWrap.append($myTribyTop).append($myTribyMid).append($myTribyBot);
    					$myTribyListWrap.append($myTribyWrap);
    				});
    					paging(page,url);
    					renewUrl("이용가능 트리비",url);
    					break;
    				
    				
    			case "myTribyHistory":
    				var $myTribyListWrap=$("<div class='myTribyListWrap'>");
    				$content.append($myTribyListWrap);
    				$.each(data, function(i,v){
    					var $myTribyWrap=$("<div class='myTribyWrap'>");
    					var $myTribyTop=$("<div class='myTribyTop'>").append($("<span>").text(v.pDate+" | ")).append($("<span>").text("수량 "+v.amount));
    					var $myTribyMid=$("<div class='myTribyMid'>");
    					var $myTribyInfoWrap=$("<div class='myTribyInfoWrap'>");
    					var $myTribyThumb=$("<div class='myTribyThumb'>").append($("<img>").attr("src","/triby/resources/images/triby/"+v.img));
    					var $myTribyTitle=$("<div class='myTribyTitle'>").append($("<h4>").text(v.title)).append($("<h5>").text(v.address)).append($("<div class='host'>").append($("<a>").attr("href","detail.ho?hNo="+v.hNo).text(v.hostName)));
    					$myTribyInfoWrap.append($myTribyThumb).append($myTribyTitle);
    					var $a1=$("<a>").attr("href","detail.ma?tNo"+v.tNo).text("상세보기");
    					$myTribyMid.append($myTribyInfoWrap).append($a1);
    					var $myTribyBot=$("<div class='myTribyBot'>");
    					var $myTribyDateWrap=$("<div class='myTribyDateWrap'>").append($("<div>").text(v.tDate)).append($("<div>").text(v.amount+" 인")).append($("<div>").text(v.price+"원"));
    					$myTribyBot.append($myTribyDateWrap);
    					$myTribyWrap.append($myTribyTop).append($myTribyMid).append($myTribyBot);
    					$myTribyListWrap.append($myTribyWrap);
    					if(v.status=='Y'){
    						var $canceled=$("<div class='canceled'>").text("취소됨");
    						$myTribyDateWrap.append($canceled);
    					}else if(v.status=='E'){
    						var $finished=$("<div class='finished'>").text("완료됨");
    						$myTribyDateWrap.append($finished);
    						var $writeAreview=$("<div class='writeAreview'>").append($("<a>").attr("href",v.pNo).text("후기 작성"));
    						$myTribyBot.append($writeAreview);
    					}else{
    						$myTribyDateWrap.append($("<div>").text("진행 예정"));
    					}
    					
    					
    				});
    					paging(page,url);
    					renewUrl("신청내역",url);
    					break;
    				
    				
    			case "myReview":
    				var $myTribyListWrap=$("<div class='myTribyListWrap'>");
    				$content.append($myTribyListWrap);
    				$.each(data, function(i,v){
    					var $myTribyWrap=$("<div class='myTribyWrap'>");
    					var $myTribyTop=$("<div class='myTribyTop'>").append($("<span>").text(v.tDate+" 진행 | ")).append($("<span>").text("수량 "+v.amount));
    					var $myTribyMid=$("<div class='myTribyMid'>");
    					var $myTribyInfoWrap=$("<div class='myTribyInfoWrap'>");
    					var $myTribyThumb=$("<div class='myTribyThumb'>").append($("<img>").attr("src","/triby/resources/images/triby/"+v.img));
    					var $myTribyTitle=$("<div class='myTribyTitle'>").append($("<h4>").text(v.title)).append($("<h5>").text(v.address)).append($("<div class='host'>").append($("<a>").attr("href","detail.ho?hNo="+v.hNo).text(v.hostName)));
    					$myTribyInfoWrap.append($myTribyThumb).append($myTribyTitle);
    					var $a1=$("<a>").attr("href","detail.ma?tNo="+v.tNo).text("상세보기");
    					$myTribyMid.append($myTribyInfoWrap).append($a1);
    					var $myTribyBot=$("<div class='myTribyBot'>");
    					var $myReviewWriteWrap=$("<div class='myReviewWriteWrap'>");
    					var $myReviewTop=$("<div class='myReviewTop'>")
    					var $myReviewStar=$("<div class='myReviewStar'>");
    					var $myReviewDate=$("<div class='myReviewDate'>").text(v.writeDate+" 작성");
    					switch(v.point){
    					case 1:    					
	    					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staron.png"));
	    					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staroff.png"));
	    					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staroff.png"));
	    					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staroff.png"));
	    					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staroff.png"));break;
    					case 2:    					
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staron.png"));
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staron.png"));
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staroff.png"));
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staroff.png"));
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staroff.png"));break;
    					case 3:    					
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staron.png"));
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staron.png"));
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staron.png"));
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staroff.png"));
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staroff.png"));break;
    					case 4:    					
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staron.png"));
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staron.png"));
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staron.png"));
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staron.png"));
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staroff.png"));break;
    					case 5:    					
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staron.png"));
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staron.png"));
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staron.png"));
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staron.png"));
        					$myReviewStar.append($("<img>").attr("src","/triby/resources/images/common/staron.png"));break;
    					}
    					$myReviewTop.append($myReviewStar).append($myReviewDate);
    					var $myReviewContent=$("<div class='myReviewContent'>").html(v.content.replace(/\n/gi, "<br//>"));
    					$myReviewWriteWrap.append($myReviewTop).append($myReviewContent);
    					if(v.reply!=null){
    						var $myReviewBot=$("<div class='myReviewBot'>");
    						var $myReviewTop2=$("<div class='myReviewTop'>").append($("<a>").attr("href","detail.ho?hNo="+v.hNo).text(v.hostName));
    						var $myReviewContent2=$("<div class='myReviewContent'>").html(v.reply.replace(/\n/gi, "<br//>"));
    						$myReviewBot.append($myReviewTop2).append($myReviewContent2);
    						
    					}
    					var $rewriteReview=$("<div class='rewriteReview'>").append($("<a class='updateReview'>").attr("href",v.rNo).text("수정하기")).append($("<a class='deleteReview'>").attr("href",v.rNo).text("삭제하기"));
    					$myTribyBot.append($myReviewWriteWrap).append($rewriteReview);
    					$myTribyWrap.append($myTribyTop).append($myTribyMid).append($myTribyBot);
    					$myTribyListWrap.append($myTribyWrap);
    				});
    				paging(page,url);
    				renewUrl("내 후기",url);
    				break;
    				
    				
    			case "myCoupon":
    				var $myCouponListWrap=$("<div class='myCouponListWrap'>");
    				$content.append($myCouponListWrap);
    				$.each(data, function(index, value){
    					var $myCouponWrap=$("<div class='myCouponWrap'>");
    					var $myCouponInfo=$("<div class='myCouponInfo'>");
    					var $img=$("<img>").attr("src","/triby/resources/images/logo_toll.png");
    					var $myCouponTitle=$("<div class='myCouponTitle'>");
    					var $h3=$("<h3>").text(value.cName);
    					var $span=$("<span>").text(" code : "+value.cNo);
    					$h3.append($span);
    					var $h4=$("<h4>").text("~ "+value.couponEnd);
    					$myCouponTitle.append($h3).append($h4);
    					$myCouponInfo.append($img).append($myCouponTitle);
    					var $myCouponPrice=$("<div class='myCouponPrice'>");
    					var $h2=$("<h3>").text(value.discountRate+"원");
    					$myCouponPrice.append($h2);
    					var $myCouponUsable=$("<div class='myCouponUsable'>").text("사용가능");
    					$myCouponWrap.append($myCouponInfo).append($myCouponPrice).append($myCouponUsable);
    					$myCouponListWrap.append($myCouponWrap);
    				});
    				
    				renewUrl("내 쿠폰",url);break;
    				
    				
    			case "myProfile":
    				var $wrap=$("<div class='myInfoWrap'>");
    				$content.append($wrap);
    				var $form=$("<form>");
    				$wrap.append($form);
    				var $infoInput1=$("<div class='infoInput'>");
    				var $infoInput2=$("<div class='infoInput'>");
    				var $infoInput3=$("<div class='infoInput'>");
    				var $infoInput4=$("<div class='infoInput'>");
    				var $infoInput5=$("<div class='infoInput'>");
    				var $infoInput6=$("<div class='infoInput'>");
    				var $infoInput7=$("<div class='infoInput'>");
    				var $infoName1=$("<div class='infoName'>").text("이름");
    				var $infoName2=$("<div class='infoName'>").text("생년월일");
    				var $infoName3=$("<div class='infoName'>").text("성별");
    				var $infoName4=$("<div class='infoName'>").text("휴대폰");
    				var $infoName5=$("<div class='infoName'>").text("이메일");
    				var $infoName6=$("<div class='infoName'>").text("비밀번호");
    				var $infoName7=$("<div class='infoName'>").text("관심사");
    				var $infoContent1=$("<div class='infoContent'>").append($("<span>").text(data.name));
    				var $infoContent2=$("<div class='infoContent'>").append($("<span>").text(data.birth));
    				var $infoContent3=$("<div class='infoContent'>").append($("<span>").text(data.gender));
    				var $infoContent4=$("<div class='infoContent'>").append($("<span>").text(data.phone));
    				var $infoContent5=$("<div class='infoContent'>").append($("<span>").text(data.email));
    				var $infoContent6=$("<div class='infoContent'>").append($("<div class='pwChange'>").text("변경하기"));
    				$infoInput1.append($infoName1).append($infoContent1);
    				$infoInput2.append($infoName2).append($infoContent2);
    				$infoInput3.append($infoName3).append($infoContent3);
    				$infoInput4.append($infoName4).append($infoContent4);
    				$infoInput5.append($infoName5).append($infoContent5);
    				$infoInput6.append($infoName6).append($infoContent6);
    				$infoInput7.append($infoName7);
    				$form.append($infoInput1);
    				$form.append($infoInput2);
    				$form.append($infoInput3);
    				$form.append($infoInput4);
    				$form.append($infoInput5);
    				$form.append($infoInput6);
    				$form.append($infoInput7);
    				
    				var likeCategory=data.category.split(",");
    				myCategoryForm(likeCategory);
    				
    				renewUrl("내 프로필",url);break;
    			}
    			}
    		},
    		error:function(){
    			console.log("loadContent 통신오류")
    		}
    	});
    	
    }
    	var listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage;
    function paging(page,url){
    	var $content=$(".content");
    	$(".footer").remove();
    	var $footer = $("<div class='footer'>");
    	$content.append($footer);
    	currentPage=page;
    	$.ajax({
				url : url + ".count",
				success : function(data) {
						listCount = data;
					if (url == "myLikeTriby") {
						pageLimit = 5;
						boardLimit = 9;
						maxPage = Math.ceil(listCount / boardLimit);
						startPage = (Math.floor((currentPage - 1) / pageLimit))
								* pageLimit + 1;
						endPage = startPage + pageLimit - 1;

						if (endPage > maxPage) {
							endPage = maxPage;
						}
					} else if (url == "myLikeHost") {
						pageLimit = 5;
						boardLimit = 20;
						maxPage = Math.ceil(listCount / boardLimit);
						startPage = (Math.floor((currentPage - 1) / pageLimit))
								* pageLimit + 1;
						endPage = startPage + pageLimit - 1;

						if (endPage > maxPage) {
							endPage = maxPage;
						}
					}else if(url=="myTribyPre"){
						pageLimit = 5;
						boardLimit = 5;
						maxPage = Math.ceil(listCount / boardLimit);
						startPage = (Math.floor((currentPage - 1) / pageLimit))
								* pageLimit + 1;
						endPage = startPage + pageLimit - 1;

						if (endPage > maxPage) {
							endPage = maxPage;
						}
					}else if(url == "myTribyHistory"){
						pageLimit = 5;
						boardLimit = 5;
						maxPage = Math.ceil(listCount / boardLimit);
						startPage = (Math.floor((currentPage - 1) / pageLimit))
								* pageLimit + 1;
						endPage = startPage + pageLimit - 1;

						if (endPage > maxPage) {
							endPage = maxPage;
						}
					}else if(url=="myReview"){
						pageLimit = 5;
						boardLimit = 5;
						maxPage = Math.ceil(listCount / boardLimit);
						startPage = (Math.floor((currentPage - 1) / pageLimit))
								* pageLimit + 1;
						endPage = startPage + pageLimit - 1;

						if (endPage > maxPage) {
							endPage = maxPage;
						}
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
    function myCategoryForm(list){
		$.ajax({
			url:"categoryList.me",
			dataType:"json",
			success:function(data){
				var $myCategory1=$("<div class='myCategory'>");
				var $myCategory2=$("<div class='myCategory'>");
				var $myCategory3=$("<div class='myCategory'>");
				var $categoryTag1=$("<div class='categoryTag'>").text("액티비티");
				var $categoryTag2=$("<div class='categoryTag'>").text("배움");
				var $categoryTag3=$("<div class='categoryTag'>").text("건강·뷰티");
				var $categoryChoice1=$("<div class='categoryChoice'>");
				var $categoryChoice2=$("<div class='categoryChoice'>");
				var $categoryChoice3=$("<div class='categoryChoice'>");
				$.each(data,function(i,v){
					var $btn=$("<button class='categoryBtn' type='button'>").text(v);
					$.each(list,function(i,v){
						if(v==$btn.text()){
							$btn.addClass("categoryChecked");
						}
					});
					if(i<8){
						$categoryChoice1.append($btn);
					}else if(i<18){
						$categoryChoice2.append($btn);
					}else{
						$categoryChoice3.append($btn);
					}
					
				});
				$myCategory1.append($categoryTag1).append($categoryChoice1);
				$myCategory2.append($categoryTag2).append($categoryChoice2);
				$myCategory3.append($categoryTag3).append($categoryChoice3);
				$(".myInfoWrap>form").append($myCategory1);
				$(".myInfoWrap>form").append($myCategory2);
				$(".myInfoWrap>form").append($myCategory3);
				var $profileSave=$("<div class='profileSave'>");
				var $saveBtn=$("<button id='updateCategory' class='saveBtn' type='submit'>").text("저장하기");
				$(".myInfoWrap>form").append($profileSave.append($saveBtn));
			},
			error:function(){
				console.log("mycategoryform error");
			}
		});
    
    	
    	
    }
    
    function updateMyCategory(){
    	var categoryChecked=$(".categoryChecked");
		var arr=[];
		$.each(categoryChecked,function(i,v){
			arr.push(v.innerText);
		})
		var str=arr.toString();
		$.ajax({
			url:"updateMyCategory.me",
			data:{category:str},
			type:"post",
			success:function(result){
				if(result>0){
					alert("수정 성공");
					refresh();
				}else{
					alert("수정 실패");
				}
				
			},
			error:function(){
				console.log("updateCategoryError");
			}
		});
    }
    function writeAreviewForm(pNo){
    	reviewPoint=5;
    	$.ajax({
    		url:"writeAreivewForm.me",
    		data:{pNo:pNo},
    		dataType:"json",
    		success:function(data){
    			$(".subnav").html("").append($("<span>").text("후기작성"))
    			var $content=$(".content");
				$content.html("");
				var $myTribyListWrap=$("<div class='myTribyListWrap'>");
				$content.append($myTribyListWrap);
				var $myTribyWrap=$("<div class='myTribyWrap'>");
				var $myTribyTop=$("<div class='myTribyTop'>").append($("<span>").text(data.tDate+" 진행 | ")).append($("<span>").text("수량 "+data.amount));
				var $myTribyMid=$("<div class='myTribyMid'>");
				var $myTribyInfoWrap=$("<div class='myTribyInfoWrap'>");
				var $myTribyThumb=$("<div class='myTribyThumb'>").append($("<img>").attr("src","/triby/resources/images/triby/"+data.img));
				var $myTribyTitle=$("<div class='myTribyTitle'>").append($("<h4>").text(data.title)).append($("<h5>").text(data.address)).append($("<div class='host'>").append($("<a>").attr("href","detail.ho?hNo="+data.hNo).text(data.hostName)));
				$myTribyInfoWrap.append($myTribyThumb).append($myTribyTitle);
				var $a1=$("<a>").attr("href","detail.ma?tNo="+data.tNo).text("상세보기");
				$myTribyMid.append($myTribyInfoWrap).append($a1);
				var $myTribyBot=$("<div class='myTribyBot'>");
				var $myReviewWriteWrap=$("<div class='myReviewWriteWrap'>");
				var $myReviewTop=$("<div class='myReviewTop'>")
				var $myReviewStar=$("<div class='myReviewStar'>");
				$myReviewStar.append($("<img class='reviewStar' id='point1'>").attr("src","/triby/resources/images/common/staron.png"));
				$myReviewStar.append($("<img class='reviewStar' id='point2'>").attr("src","/triby/resources/images/common/staron.png"));
				$myReviewStar.append($("<img class='reviewStar' id='point3'>").attr("src","/triby/resources/images/common/staron.png"));
				$myReviewStar.append($("<img class='reviewStar' id='point4'>").attr("src","/triby/resources/images/common/staron.png"));
				$myReviewStar.append($("<img class='reviewStar' id='point5'>").attr("src","/triby/resources/images/common/staron.png"));
				var $rewriteReview=$("<div class='rewriteReview' id='writeReview'>").append($("<a>").attr("href",data.pNo).text("작성하기"));
				$myReviewTop.append($myReviewStar).append($rewriteReview);
				var $myReviewContent=$("<div class='myReviewContent'>").append($("<textarea name='reviewContent' id='reviewContent' cols='60' rows='10' style='resize:none;' placeholder='후기를 입력해주세요'>"));
				$myReviewWriteWrap.append($myReviewTop).append($myReviewContent);
				$myTribyBot.append($myReviewWriteWrap);
				$myTribyWrap.append($myTribyTop).append($myTribyMid).append($myTribyBot);
				$myTribyListWrap.append($myTribyWrap);
    		},
    		error:function(){
    			console.log("writeAreviewFormError");
    		}
    	});
    }
    function insertReview(pNo,hNo,point){
    	var content=$("#reviewContent").val();
    	$.ajax({
    		url:"insertReview.me",
    		data:{pNo:pNo,hNo:hNo,content:content,point:point},
    		type:"post",
    		success:function(data){
    			if(data>0){
    				alert("후기 작성 성공");
    				renewUrl("내 후기","myReview");
    				refresh();
    			}else{
    				alert("후기 작성 실패");
    			}
    		},
    		error:function(){
    			console.log("insertReviewError");
    		}
    		
    	});
    }
    function updateReviewForm(writeWrap,rNo){
    	$.ajax({
    		url:"reviewContent.me",
    		data:{rNo:rNo},
    		success:function(data){
    			writeWrap.children().eq(0).children().eq(0).children().eq(0).addClass("reviewStar").attr("id","point1");
    	    	writeWrap.children().eq(0).children().eq(0).children().eq(1).addClass("reviewStar").attr("id","point2");
    	    	writeWrap.children().eq(0).children().eq(0).children().eq(2).addClass("reviewStar").attr("id","point3");
    	    	writeWrap.children().eq(0).children().eq(0).children().eq(3).addClass("reviewStar").attr("id","point4");
    	    	writeWrap.children().eq(0).children().eq(0).children().eq(4).addClass("reviewStar").attr("id","point5");
    	    	writeWrap.children().eq(1).html("").append($("<textarea name='reviewContent' id='reviewContent' cols='60' rows='10' style='resize:none;' placeholder='후기를 입력해주세요'>").val(data));
    	    },
    		error:function(){
    			console.log("reviewContentError");
    		}
    	});
    }
    function updateReview(rNo,content,point){
    	$.ajax({
    		url:"updateReview.me",
    		data:{rNo:rNo,content:content,point:point},
    		success:function(data){
    			if(data>0){
    				alert("수정 성공");
    				refresh();
    			}else{
    				alert("수정 실패");
    			}
    		},
    		error:function(){
    			console.log("updateReviewError");
    		}
    	});
    }
    function tribyCancel(pNo){
    	$.ajax({
    		url:"tribyCancel.me",
    		data:{pNo:pNo},
    		success:function(data){
    			if(data>0){
    				alert("취소 성공");
    				refresh();
    			}else{
    				alert("취소 실패");
    			}
    		},
    		error:function(){
    			console.log("tribyCancelError");
    		}
    	});
    }
    function deleteReview(rNo){
    	$.ajax({
    		url:"deleteReview.me",
    		data:{rNo:rNo},
    		success:function(data){
    			if(data>0){
    				alert("삭제 성공");
    				refresh();
    			}else{
    				alert("삭제 실패");
    			}
    		},
    		error:function(){
    			console.log("deleteReviewError");
    		}
    	});
    }
    function removeLikeTriby(tNo){
    	$.ajax({
    		url:"removeLikeTriby.me",
    		data:{tNo:tNo},
    		success:function(data){
    			if(data>0){
    				console.log(tNo+"좋아요 제거");
    			}else{
    				alert("삭제 실패");
    			}
    		},
    		error:function(){
    			console.log("removeLikeTribyError");
    		}
    	});
    }
    function addLikeTriby(tNo){
    	$.ajax({
    		url:"addLikeTriby.me",
    		data:{tNo:tNo},
    		success:function(data){
    			if(data>0){
    				console.log(tNo+"좋아요");
    			}else{
    				alert("삭제 실패");
    			}
    		},
    		error:function(){
    			console.log("addLikeTribyError");
    		}
    	});
    }
    function removeLikeHost(hNo){
    	$.ajax({
    		url:"removeLikeHost.me",
    		data:{hNo:hNo},
    		success:function(data){
    			if(data>0){
    				console.log(hNo+"좋아요 제거");
    			}else{
    				alert("삭제 실패");
    			}
    		},
    		error:function(){
    			console.log("removeLikeHostError");
    		}
    	});
    }
    function addLikeHost(hNo){
    	$.ajax({
    		url:"addLikeHost.me",
    		data:{hNo:hNo},
    		success:function(data){
    			if(data>0){
    				console.log(hNo+"좋아요");
    			}else{
    				alert("삭제 실패");
    			}
    		},
    		error:function(){
    			console.log("addLikeHostError");
    		}
    	});
    }
    function uploadProfileImg(){
    	var data=new FormData();
		data.append('profileImg',$(".profile>input")[0].files[0]);
		$.ajax({
			url:"uploadProfileImg.me",
			type:"post",
			dataType:"json",
			data:data,
			contentType:false,
			processData:false,
			success:function(e){
				if(e>0){
					refresh();					
				}else{
					alert("수정 실패");
				}
			},
			error:function(){
				console.log("uploadProfileImgError")
			}
		})    	
    }
    function pwChangeForm(){
    	$(".subnav").html("").append($("<span>").text("비밀번호 변경"));
    	var content=$(".content");
    	content.html("");
    	var $myInfoWrap=$("<div class='myInfoWrap'>");
    	var $form=$("<form id='updatePw'>");
    	var $pwInputWrap1=$("<div class='pwInputWrap'>").append($("<input type='password' placeholder='현재 비밀번호를 입력해주세요'>"));
    	var $pwInputWrap2=$("<div class='pwInputWrap'>").append($("<input type='password' placeholder='새로운 비밀번호를 입력해주세요'>"));
    	var $pwInputWrap3=$("<div class='pwInputWrap'>").append($("<input type='password' placeholder='새로운 비밀번호를  다시 입력해주세요'>"));
    	var $saveBtn=$("<div class='profileSave' id='updatePw'>").append($("<button type='submit' class='saveBtn'>").text("변경하기"));
    	$form.append($pwInputWrap1)
    	$form.append($pwInputWrap2)
    	$form.append($pwInputWrap3)
    	$form.append($saveBtn)
    	$myInfoWrap.append($form);
    	content.append($myInfoWrap);
    }
    function updateMyPw(pw){
    	$.ajax({
    		url:"updateMyPw.me",
    		data:{pw:pw},
    		success:function(data){
    			if(data>0){
    				alert("비밀번호 변경 성공");
    				refresh();
    			}else{
    				alert("비밀번호 변경 실패");
    			}
    		},
    		error:function(){
    			console.log("updateMyPwError");
    		}
    	});
    }
	</script>
</body>
</html>