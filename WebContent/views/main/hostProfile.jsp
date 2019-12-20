<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.triby.host.model.vo.Host"%>
<%
	Host h=(Host)request.getAttribute("host");
	String tag=(String)request.getAttribute("tag");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/custom.css">

    <title>TRIBY</title>
<style>
a{
	text-decoration: none;
}

body {
	width: 100%;
}

#body {
	width: 50%;
	margin: 0 auto;
	border: 0px solid black;
}

.intro_title {
	font-size: 54px;
	font-weight: bold;
	margin-bottom:60px;
}

.host_view {
	margin: 0 auto;
	border: 0px solid black;
	position: relative;
}

#heart {
	cursor: pointer;
}

#tLike, #host_point {
	float: right;
	font-size: 20px;
}

#host_text {
	width: 90%;
	margin-left: auto;
	margin-right: auto;
}

.host_picture {
	width: 90%;
	margin-left: auto;
	margin-right: auto;
	display: flex;
	align-items: center;
}

.host_text2 {
	font-size: 18px;
}

#host_intro2 {
	height: 100%;
	border: 0px solid red;
}

#host_btn {
	height:50px;
	width: 50%;
	margin-left: auto;
	margin-right: auto;
	border: 0px solid red;
}

#host_triby {
	width:90%;
	border: 0px solid blue;
	display: block;
	margin:auto;
	padding-left:20px;
}

#host_review {
	border: 0px solid blue;
	display: none;
}

.hBtn {
	width: 80px;
	height: 40px;
	border: 0px;
	background: white;
	font-size: 20px;
}

#btn_triby {
	float: left;
	cursor: pointer;
}

#btn_review {
	float: right;
	cursor: pointer;
}

/* 트리비  스타일 */
#other {
	clear: both;
	border: 0px solid lightgrey;
	height: 210px;
}

#other_List {
	float: left;
}

#other_triby, #host_review2 {
	margin-left: auto;
	margin-right: auto;
	width: 90%;
	height: 90%;
}

#other_triby1 {
	border: 0px solid blue;
	width: 33.3%;
	height: 100%;
	float: left;
}

.other_triby1_img {
	height: 60%;
}

.other_triby1_text {
	height: 40%;
	width: 95%;
}

.other_triby_title {
	font-size: 20px;
}

.other_triby_price {
	font-size: 15px;
	text-align: right;
}

.other_triby_point {
	font-size: 15px;
}

.other_triby_likeCount {
	font-size: 15px;
	float: right;
}

#user_name {
	font-size: 20px;
	font-weight: bolder;
}

.hostName {
	display: flex;
	justify-content: space-between;
}

.hostTitle {
	margin-left: 20px;
}

.hostThumb1 {
	width: 80px;
	height: 80px;
	flex: 0 0 auto;
	overflow: hidden;
	margin-right: 20px;
	border-radius: 50%;
}

.hostThumb1 img {
	width: 100%;
	height: 100%;
	border-radius: 50%;
}
#host_intro{
	margin-top:60px;
}
</style>
</head>
<body>
    <%@ include file="../common/header.jsp" %>

    <body>
        <div id="body">
            <div class="host_view">
                <div id="host_intro">
				<div class="host_picture">
					<div class="hostThumb1">
						<img src="/triby/resources/images/host/profile/<%=h.getHost_image()%>">
					</div>
					<div class="hostTitle">
						<div class="hostName">
							<h4><%=h.getHost_sName()%></h4>
							<div class="hostlikebtn">
								<img class="hostHeart0"
									src="/triby/resources/images/common/heart0.png">
							</div>
						</div>
						<div class="hostCount">트리비 0 | 후기 0 | 좋아요 0</div>
					</div>
				</div>
				<br>
                    <div id="host_text">
                        <div class="host_text2"><%=h.getHost_introduce() %></div>
                    </div>
                </div>
                
                <br><br><hr>
                <div id="hostContentWrap">

                    <!--버튼 2개 div 판떼기-->
                    <div id="host_btn">
                        <button class="hBtn" id="btn_triby">트리비</button>
                        <button class="hBtn" id="btn_review">후기</button>
                    </div>
                    <hr>
                    <!-- 호스트 트리비 틀 트리비 3개 나머지 페이징-->
                    <div id="host_triby">
                        <div id="other_triby">
                        </div>
                    </div>

                    <!-- 호스트 후기 틀 후기 5개 나머지 페이징-->
                    <div id="host_review">

                        
                    </div>

                </div>
            </div>
        </div>
    </body>
<%@ include file='../common/footer.jsp' %>


    <script>
    	var str="<%=tag%>";
        $(function(){
        	loadHostCount(<%=h.getHost_no()%>);
        	loadHostContent(str,<%=h.getHost_no()%>,1);
        	amIlike(<%=h.getHost_no()%>);
        	$(document).on("click",".footer>button",function(e){
        		e.preventDefault();
        		$(".footer>button").removeClass("tagactive");
        		$(this).addClass("tagactive");
        		var page=$(this).text();
        		loadHostContent(str,<%=h.getHost_no()%>,page);
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
        				loadHostContent(str,<%=h.getHost_no()%>,page);
        			}else if(btn=="<"){
        				preBtn.addClass("tagactive");
        				loadHostContent(str,<%=h.getHost_no()%>,currentPage);
        			}
        		}
        	});
        	$(document).on("click",".rightbtn>button",function(e){
        		e.preventDefault();
        		var category=$(".tagWrap>.tacactive").text();
        		var btn=$(this).text();
        		if(currentPage<endPage){
        			currentPage=currentPage+1;
        			var nextBtn=$(".footer>.tagactive").next();
        			$(".footer>button").removeClass("tagactive");
        			if(btn==">>"){
        				$(".footer>button").eq(0).addClass("tagactive");
        				var page=endPage;
        				loadHostContent(str,<%=h.getHost_no()%>,page);
        			}else if(btn==">"){
        				nextBtn.addClass("tagactive");
        				loadHostContent(str,<%=h.getHost_no()%>,currentPage);
        			}
        		}
        	});
        	$(document).on("click",".hBtn",function(e){
        		e.preventDefault();
        		str=$(this).text();
        		loadHostContent(str,<%=h.getHost_no()%>,1);
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
        });
        function loadHostCount(hNo){
        	$.ajax({
        		url:"mainHostCount.ho",
        		data:{hNo:hNo},
        		dataType:"json",
        		success:function(data){
        			$(".hostCount").html("").text("트리비 "+data[0]+" | 후기 "+data[1]+" | 좋아요 "+data[2]);
        		},error:function(){
        			console.log("loadHostCountError");
        		}
        	});
        }
        function loadHostContent(str,hNo,page){
        	$.ajax({
        		url:"loadHostDetailContent.ma",
        		data:{str:str,hNo:hNo,page:page},
        		dataType:"json",
        		success:function(data){
        			console.log(data);
        				var $host_triby=$("#host_triby");
	        			$host_triby.html("");
	    				if(data.length==0){
	    					var $nothave=$("<div class='nothave'>").append($("<p>").text("아직 아무것도 없습니다"));
	        				$host_triby.append($nothave);
		    			}else{
        				if(str=="트리비"){
        				var $likeWrap=$("<div class='likeWrap'>")
	    				$host_triby.append($likeWrap);
	    				$.each(data, function(index, value){
		    					var $a=$("<a>").attr("href","detail.ma?tNo="+value.tNo);
			    				var $tribyWrap=$("<div class='tribyWrap'>");
			    				var $triby=$("<div class='triby'>");
			    				var $tribytop=$("<div class='tribytop'>");
			    				var $tribythumb=$("<div class='tribythumb'>");
			    				var $thumb=$("<img width='310'>").attr("src","/triby/resources/images/triby/"+value.tImg);
			    				$tribythumb.append($thumb);
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
			    			
	    				});
    						str="트리비";
		    				paging(str,page);
    				
        			}else{
	        				$.each(data, function(i,v){
	        					var $myTribyWrap=$("<div class='myTribyWrap'>");
	        					$host_triby.append($myTribyWrap);
	        					var $myTribyTop=$("<div class='myTribyTop'>").append($("<span>").text(v.tDate+" 진행 | "+v.title));
	        					var $myTribyMid=$("<div class='myTribyMid'>");
	        					var $host_picture=$("<div class='host_picture'>");
	        					var $hostThumb1=$("<div class='hostThumb1'>").append($("<img>").attr("src","/triby/resources/images/user/profile/"+v.address));
	        					var $hostTitle=$("<div class='hostTitle'>").text(v.img)
	        					$myTribyMid.append($host_picture.append($hostThumb1).append($hostTitle));
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
	        						var $myReviewTop2=$("<div class='myReviewTop'>").append($("<a>").attr("href",v.hNo).text(v.hostName));
	        						var $myReviewContent2=$("<div class='myReviewContent'>").html(v.reply.replace(/\n/gi, "<br//>"));
	        						$myReviewBot.append($myReviewTop2).append($myReviewContent2);
	        						
	        					}
	        					$myTribyBot.append($myReviewWriteWrap);
	        					$myTribyWrap.append($myTribyTop).append($myTribyMid).append($myTribyBot);
        					});
	        				str="후기"
	        				paging(str,page);
        			}
        			}
        			
        		},
        		error:function(){
        			console.log("loadHostTribyError");
        		}
        	});
        }
        var listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage;
        function paging(category,page){
        	var $content=$("#hostContentWrap");
        	$(".footer").remove();
        	var $footer = $("<div class='footer'>");
        	$content.append($footer);
        	currentPage=page;
        	$.ajax({
    				url : "loadHostDetail.count",
    				data:{category:category,hNo:<%=h.getHost_no()%>},
    				success : function(data) {
    					if(category=="트리비"){
    						
    						listCount = data;
    						pageLimit = 5;
    						boardLimit = 9;
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
    					}else{
    						
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
    					}

    				},
    				error : function() {
    					console.log("listCount 통신오류");
    				}

    			});
    		}
        function removeLikeHost(hNo){
        	$.ajax({
        		url:"removeLikeHost.me",
        		data:{hNo:<%=h.getHost_no()%>},
        		success:function(data){
        			if(data>0){
        				console.log(hNo+"좋아요 제거");
        			}else{
        				alert("로그인 후 이용해주세요");
        				 location.reload();
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
        		data:{hNo:<%=h.getHost_no()%>},
        		success:function(data){
        			if(data>0){
        				console.log(hNo+"좋아요");
        			}else{
        				alert("로그인 후 이용해주세요");
        				 location.reload();
        			}
        		},
        		error:function(){
        			console.log("addLikeHostError");
        		}
        	});
        }
        function amIlike(hNo){
        	$.ajax({
        		url:"amIlikeHost.me",
        		data:{hNo:hNo},
        		success:function(data){
        			var heart=$(".hostlikebtn>img");
        			if(data>0){
        				heart.removeClass("heart0").addClass("heart1").attr("src","/triby/resources/images/common/heart1.png");
        			}
        		},
        		error:function(){
        			console.log("amIlikeError");
        		}
        	});
        }
    </script>
</body>
</html>