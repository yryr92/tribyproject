<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.triby.triby.model.vo.*"%>
     
<%
	ArrayList<Triby> tList = (ArrayList<Triby>)request.getAttribute("tList");
	ArrayList<ThumbnailTriby> thList = (ArrayList<ThumbnailTriby>)request.getAttribute("thList");
	Triby t = (Triby)request.getAttribute("t");
	String successPwd = (String)request.getAttribute("successPwd");
	String success = (String)request.getAttribute("successHoPwd");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TRIBY</title>
</head>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript"></script>
    <script>
    var  successPwd = "<%=successPwd%>";
 	 console.log(successPwd);
   $(function(){

  	 if(successPwd !="null"){
  	 	alert(successPwd);
  		 
  	 }
    })
       var success = "<%=success %>";
$(function(){
	if(success != "null"){
		alert(success);
	}
})
    
    
    </script>
    
	<style>
    

</style>
</head>
<body>

	<%@ include file="views/common/header.jsp" %>

    <body>
        <div id="body">
            <!-- 메인 배너 -->
            <div class="mainCover">
                <div id="changeBanner">
                	<div id="banner">
                		
                	</div>
                    <div id="table_cover">
                        <div id="table">
                            <a href="<%=request.getContextPath()%>/category.ma?category=AC"><div id="ac">액티비티</div></a>
                            <a href="<%=request.getContextPath()%>/category.ma?category=ST"><div id="st">배움</div></a>
                            <a href="<%=request.getContextPath()%>/category.ma?category=HB"><div id="hb">건강뷰티</div></a>
                        </div>
                    </div>
                </div>
            </div>
            <br><br>
            <!-- 인기 트리비 -->
            <div id="hot">
                <div class="hot_label">
                    <div id="hot_category">인기 트리비</div>
                </div>
                <div id="hot_triby">
                    
          
	                    <div class="hot_triby1">
	                        <a href="#">
	                            <div class="hot_triby1_img">
	                                <img>
	                            </div>
	                            <div class="hot_triby1_text">
	                                <div class="hot_triby_title">트리비 제목</div>
	                                <div class="hot_triby_price">트리비 가격</div>
	                                <span class="hot_triby_point">평점</span>
	                                <span class="hot_triby_likeCount">좋아요</span>
	                            </div>
	                        </a>
	                    </div>
	      
                    
                </div>
            </div>

            <!-- 홈페이지 광고 -->
            <div class="mainCover" id="triby_img">
                <div id="slide">
                    <!--<input type="radio" name = "pos" id = "pos1" checked>
                    <input type="radio" name = "pos" id = "pos2">
                    <p class ="pos">
                        <label for="pos1"></label>
                        <label for="pos2"></label>  
                    </p>-->
                    <ul>
                        <li><img src="<%=contextPath%>/resources/images/나도껴조.jpg" style="width:100%; height:100%;"></li>
                        <li><img src="<%=contextPath%>/resources/images/역시마무리는춘식이.jpg" style="width:100%; height:100%;"></li>
                    </ul>
                </div>
            </div>


            <br><br>
            <!-- 신규 트리비 -->
            
            <div id="new">   <!--신규 카테고리-->
                <div class="new_label">
                    <div id="new_category">신규! 트리비</div>
                </div>
                <div id="new_triby">
                
                    <div id="new_triby1">
                        <a href="#">
                            <div class="new_triby1_img">
                                <img>
                            </div>
                            <div class="new_triby1_text">
                                <div class="new_triby_title">트리비 제목</div>
                                <div class="new_triby_price">트리비 가격</div>
                                <span class="new_triby_point">평점</span>
                                <span class="new_triby_likeCount">좋아요</span>
                            </div>
                        </a>
                    </div>
                 
                </div>
            </div>
        </div>
	<script>
		$(function (){
			var $banner = $("#slide").find("ul");

			var $bannerWidth = $banner.children().outerWidth() ;//배너 이미지의 폭
			var $bannerHeight =  $banner.children().outerHeight(); // 높이
			var $bannerLength = $banner.children().length;//배너 이미지의 갯수
			var rollingId;
			
			rollingId=setInterval(function(){
				rollingStart();
			},4000);
			$banner.mouseover(function(){
				clearInterval(rollingId);
			});
			$banner.mouseout(function(){
				rollingId=setInterval(function(){rollingStart();},4000);
				
			});
			function rollingStart(){
				$banner.css("width", $bannerWidth * $bannerLength + "px");
				$banner.css("height", $bannerHeight+"px");
				$banner.animate({left: - $bannerWidth + "px"}, 2000, function() { 
					$(this).append("<li>" + $(this).find("li:first").html() + "</li>");
					$(this).find("li:first").remove();
					$(this).css("left", 0);
				});
				console.log($bannerHeight);
				console.log($bannerWidth);
				console.log($bannerLength);
				
			}
			
			
			selectNlist();
			
			setInterval(function(){
				selectNlist();
			}, 300000);
		});
		$(function(){
			$(".hot_triby1").click(function(){
				var tId = $(this).children().eq(0).val();
				
				location.href="<%=contextPath%>/detail.tr?tId=" + tId;
			});
		});
		
//		인기 트리비 Ajax
		$(function (){
			selectHlist();
			
			setInterval(function(){
				selectHlist();
			}, 300000);
		});
		
		function selectHlist(){
			//boardDetailView 참고
			$.ajax({
				url:"mainHot.ma",				// MainHotServlet.java
				dataType:"json",
				success: function(list){
					
					var $tList = $("#hot_triby");		//	<div></div> = hot_triby 큰틀 위치
					
					$tList.html("");	// 기존  div 초기화?
							
					$.each(list, function(index, value){
						
						var $div = $("<div class='hot_triby1'>");		//	<div class='hot_triby1'></div> 생성
						var $a	= $("<a>").attr('href','<%=contextPath%>/detail.ma?tNo=' + value.tNo);					//	<a></a> 생성	..? <div class='hot_triby1_img'></div> 생성
						var $tImg = $("<div class='hot_triby1_img'>");
						
						var $iImg = $("<img>").attr('src','<%=contextPath%>/resources/images/triby/' + value.tImg).css('width','95%').css('height','100%');
						
						var $tText = $("<div class='hot_triby1_text'>");
						var $tTitle = $("<div class='hot_triby_title'>").text(value.tName);
						var $tPrice = $("<div class='hot_triby_price'>").text("가격 "+value.tPrice);
						var $tLike = $("<div class='hot_triby_likeCount'>").text("좋아요 "+value.like);
						
						$tText.append($tTitle);
						$tText.append($tPrice);
						$tText.append($tLike);
						
						$tImg.append($iImg);
						
						$a.append($tImg);
						$a.append($tText);
						
						$div.append($a);
						$tList.append($div);
								
					});
					
				},error:function(){
					console.log("서버와의 통신 실패!");
				}
			});			
		}
		
		// 신규 트리비
		$(function(){
			$(".new_triby1").click(function(){
				var tId = $(this).children().eq(0).val();
				
				location.href="<%=contextPath%>/detail.tr?tId=" + tId;
			});
		});
		
		
		function selectNlist(){
			//boardDetailView 참고
			$.ajax({
				
				url:"mainNew.ma",				// MainNewServlet.java
				dataType:"json",
				success: function(list){
					
					var $nList = $("#new_triby");		//	<div></div> = hot_triby 큰틀 위치
					
					$nList.html("");	// 기존  div 초기화?
							
					$.each(list, function(index, value){
						
						var $div = $("<div class='new_triby1'>");		//	<div class='new_triby1'></div> 생성
						var $a	= $("<a>").attr('href','<%=contextPath%>/detail.ma?tNo=' + value.tNo);   //	<a></a> 생성	..? <div class='hot_triby1_img'></div> 생성
						var $tImg = $("<div class='new_triby1_img'>");
						
						var $iImg = $("<img>").attr('src','<%=contextPath%>/resources/images/triby/'+ value.tImg).css('width','95%').css('height','100%');
						
						var $tText = $("<div class='new_triby1_text'>");
						var $tTitle = $("<div class='new_triby_title'>").text(value.tName);
						var $tPrice = $("<div class='new_triby_price'>").text("가격 "+value.tPrice);
						var $tLike = $("<div class='new_triby_likeCount'>").text("좋아요 "+value.like);
						
						
						$tText.append($tTitle);
						$tText.append($tPrice);
						$tText.append($tLike);
						
						$tImg.append($iImg);
						
						$a.append($tImg);
						$a.append($tText);
						
						$div.append($a);
						$nList.append($div);
								
					});
					
				},error:function(){
					console.log("서버와의 통신 실패!");
				}
			});			
		}
		
		$("#ac").hover(function(){
			//console.log("호버확인")
			$("#changeBanner").css({"background-image":"url('resources/images/common/11.jpg')"});
			$(this).css("opacity", "0.8");
		});
		
		$("#st").hover(function(){
			$("#changeBanner").css({"background-image":"url('resources/images/common/222.jpg')"});
			$(this).css("opacity", "0.8");
		});
		
		$("#hb").hover(function(){
			$("#changeBanner").css({"background-image":"url('resources/images/common/3.jpg')"});
			$(this).css("opacity", "0.8");
		});
		
		$("#ac").mouseleave(function(){
			$(this).css("opacity", "0.5");
		});
		
		$("#st").mouseleave(function(){
			$(this).css("opacity", "0.5");
		});
		
		$("#hb").mouseleave(function(){
			$(this).css("opacity", "0.5");
		});
		
		$("#changeBanner").mouseleave(function(){
			$(this).css({"background-image":"url('resources/images/common/00.jpg')"});
		});

	</script>
  
    </body>

    <%@ include file="views/common/footer.jsp" %>
</body>
</html>

