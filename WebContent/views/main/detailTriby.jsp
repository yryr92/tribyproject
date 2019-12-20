<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.triby.triby.model.vo.*"%>
    
<%
	ArrayList<MainDetailTriby> dt = (ArrayList<MainDetailTriby>)request.getAttribute("dt");		// 트리비 정보
	ArrayList<MainHostDetail> dh = (ArrayList<MainHostDetail>)request.getAttribute("dh");		// 호스트 정보
	ArrayList<MainReviewDetail> dv = (ArrayList<MainReviewDetail>)request.getAttribute("dv");	// 리뷰 정보
	ArrayList<MainDetailRight> dr = (ArrayList<MainDetailRight>)request.getAttribute("dr");		// 옵션 정보
	ArrayList<ThumbnailTriby> ot = (ArrayList<ThumbnailTriby>)request.getAttribute("ot");		// 이런 트리비는 어떠세요
	int tNo = (int)request.getAttribute("tNo");
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
    </style>
</head>
<body>
    <body>
    <%@ include file="../common/header.jsp" %>
        <div id="body1">
            <!-- 왼쪽 상세설명란 -->
            <div id="leftNright">
                <div id="left">
                
                    <!-- 트리비 이미지 삽입  3개까지 들어감  (선택한 트리비에 저장된 이미지 갯수만큼) -->
                    <div class="triby_left" id="triby_img1">
                        <div id="slide1">
                        	<!-- 동작하는 버튼은 처음부터 3개를 만들어 둔다 -->
                            <input type="radio" name = "pos" id = "pos1" checked>
                            <input type="radio" name = "pos" id = "pos2" >
                            <input type="radio" name = "pos" id = "pos3" >
                            <ul>
                            	<!-- 이미지 보유수 만큼 for 문 돈다 -->
                            	<%for(int i=0;i<dt.size();i++){ %>
                                <li><img src="<%=contextPath%>/resources/images/triby/<%=dt.get(i).gettImg()%>" style="width:100%; height:100%;"></li>
                                <%} %>
                            </ul>
                            <p class ="pos">
                            	<!-- 이미지 보유 수 만큼 이미지 하단에 버튼 생성  pos1 / pos2 / pos3 라벨 이름-->
	                            <%for(int i=1;i<=dt.size();i++){ %>
                                <label for="pos<%=i%>"></label>
                                <%} %>
                            </p>
                        </div>
                    </div>
                    <hr>
                    <!-- 트리비 타이틀 & 좋아요 -->
                    <div class="triby_left" id="triby_title">
                        <div id="tTitle"><%=dt.get(0).gettTitle() %></div>
                        <div id="icon">
                            <div id="tLike"><img class="heart0" src="<%=contextPath%>/resources/images/common/heart0.png" style="width:30px; height:30px; margin-top:8px;"></div>
                            <a href="<%=contextPath%>/QNA?hNo=<%=dh.get(0).gethNo()%>"><div id="review_write"><img id="review_icon" src="<%=contextPath%>/resources/images/리뷰2.png" style="width:30px; height:30px; margin-top:8px;"></div></a>
                            <div id="report" onclick="reportHost();"><img id="report_icon" src="<%=contextPath%>/resources/images/alarm.png" style="width:35px; height:35px; margin-top:3px; margin-right:5px;"></div>
                        </div>
                    </div>

                    <!-- 트리비 가격 란 -->
                    <div class="triby_left" id="triby_price">
                        <div id="tPrice"><%=dt.get(0).gettPrice()%>원</div>
                    </div>
                    <hr>
                    <!-- 트리비 좋아요 갯수, 시작날짜, 위치, 평점 -->
                    <div class="triby_left" id="triby_info">
                        <div id="tInfo">
                            <div id="info1"> <%=dt.get(0).gettLike()%>명이 좋아하는 호스트 </div>
                        <%if(dr.size() != 0){ %>
                           	<div id="info2"> <%=dr.get(0).getTDay()%> &nbsp;&nbsp;&nbsp; <%=dr.get(0).getTTime()%></div>
                        <%}else{ %>
                            <div id="info2"> 곧 오픈 될 트리비입니다 많이 기대해주세요! </div>
                        <%} %>
                            <div id="info3"> <%=dt.get(0).getAddress() %></div>
                        <%if(dv.size() != 0){ %>
                            <div id="info4"> 트리비 평점 | <%=dv.get(0).getRPoint() %></div>
                        <%}else{ %>
                            <div id="info4"> 등록된 평점이 없습니다</div>
                        <%} %>
                            
                        </div>
                    </div>
                    <hr>
                    <!-- 호스트 프로필 -->
                    <div class="triby_left" id="host_profile">
                        <div class="intro_title">호스트</div>
                        <div id="host_intro">
                        	<%if(dh.get(0).gethImage() == null){ %>
	                            <span class="profile_img"><img src="<%=contextPath%>/resources/images/logo_toll.png" height="80px;" width="80px;"></span>
                            <%}else{ %>
    	                        <span class="profile_img"><img src="<%=contextPath%>/resources/images/host/profile/<%=dh.get(0).gethImage()%>" height="80px;" width="80px;"></span>
                            <%} %>
                            <!-- 호스트 이름(상호명) -->
                            <span class="intro_title"><%=dh.get(0).getsName()%></span>
                            <!-- 호스트 소개 -->
                            <div id="host_intro2"><%=dh.get(0).gethIntroduce()%></div>
                            <br>
                            <div id="host_pro_link"><a href="detail.ho?hNo=<%=dh.get(0).gethNo() %>&tag=트리비">호스트 프로필</a></div> 
                        </div>
                    </div>
			
					<hr>
                    <!-- 호스트 후기 -->
                    <div class="triby_left" id="host_review">
                        <div class="intro_title">호스트 후기</div>
                        <div id="review">
                        <br> 
                        <%if(dv.size() != 0){ %> 
                            <span class="intro_title"><%=dv.get(0).getuName()%></span>
                            <span id="host_point">평점 <%=dv.get(0).getRPoint() %></span>
                            <div id="host_intro2"><%=dv.get(0).getRContent() %></div>
                        <%}else{ %>
                        	<div>현재 등록된 후기가 없습니다</div>
                        <%} %>
                            <br>
                            <div id="host_pro_link"><a href="detail.ho?hNo=<%=dh.get(0).gethNo() %>&tag=후기">후기 모두 보기</a></div>
                        </div>  
                    </div>
                    <hr>
                    
                    <!-- 트리비 소개 -->
                    <div class="triby_left" id="triby_introduce">
                        <div class="intro_title">트리비 소개</div>
                        <div id="triby">
                            <%=dt.get(0).gettContent() %>
                        </div>
                    </div>
                    <hr>

                    <!-- 트리비 위치 -->
                    <div class="triby_left" id="triby_position2">
                        <div class="intro_title">위치</div>
                        <div id="triby">
                            <div id="position_text">
                                <p><%=dt.get(0).getAddress() %> </p>
                            </div>
                        </div>

                    </div>
                    <hr>
                    <!-- 자주묻는 질문 -->
                    <div class="triby_left" id="FAQ">
                        <div class="intro_title">자주 묻는 질문</div>
                        <div id="FAQ_text">
                            <br>
                            <div>Q : 이거 언제 끝나나요?</div>
                            <div>A : 내가 질문하고 싶네요</div>
                            <br>
                            <div>Q : 끝나긴 하나요?</div>
                            <div>A : 하..</div>
                            <br>
                            <div>Q : CSS 개싫다 진짜</div>
                            <div>A : 이건 질문이 아니자나여</div>
                            <br>
                            <div>Q : 수고 하십셔</div>
                            <div>A : 오야</div>
                        </div>
                    </div>
                    <hr>
                    <!-- 환불정책 -->
                    <div class="triby_left" id="rMoney">
                        <div class="intro_title">환불정책</div>
                        <div id="rMoney_text">
                            <br>
                            <div>트리비 신청 마감 1주일 전</div>
                            <div> : 100% 환불</div>
                            <br>
                            <div>트리비 신청 마감 5일 전</div>
                            <div> : 50% 환불</div>
                            <br>
                            <div>트리비 신청 마감 종료 후</div>
                            <div> : 환불 불가</div>
                        </div>
                    </div>
                    <br>
                </div>
            <%if(dr.size() != 0){ %>
                <!-- 오른쪽 상세설명란 -->
                <div id="rightOption">
                    <div id="option">
                        <div style="height:40px; font-size:20px; font-weight:bold">&nbsp; 일정 선택</div>
                        
                        <div id="scadule">
                            <div id="scadule_choice">&nbsp;일정</div>
                            <div id="scadule_btn"><button>▽</button></div>
                        </div>
                    
                    <!-- 선택한 옵션 정보 전송 -->
					<form method="post" action="<%=contextPath%>/payment.ma">
					<input type="hidden" name="tNo" value="<%=dt.get(0).gettNo()%>">	<!-- 트리비 번호 전송 -->
					<input type="hidden" name="hNo" value="<%=dh.get(0).gethNo()%>">	<!-- 호스트 번호 전송 -->
					
                        <div id="scadule_list">
                            <!-- 등록한 옵션 일정 수 만큼 p 생성 -->
                            <%for(int i=0; i<dr.size(); i++){ %>
                            
                            <div class="scadule_text" onclick="check();">
	                            <input type="radio" class="rOradio" name="tDay" value='<%=dr.get(i).getTDay()%> / <%=dr.get(i).getTTime()%>' checked>
	                            <input type="radio" name="oNo" value='<%=dr.get(i).getoNo()%>' style='display:none' checked>	<!-- 옵션 번호 전송 -->
                                <span><%=dr.get(i).getTDay()%>&nbsp;<%=dr.get(i).getTTime()%></span>
                                <p><%=dr.get(i).gettAttend()%>/<%=dr.get(i).getpMax()%>명</p>
                            </div>
                            <%} %>
                        </div>
                        <div id="triby_person2">
                            <div id="triby_person">
                                <div id="exit"></div>
                                <div>참가비</div>
                                <br>
                                <input type="number" id="tPayment" name="tPayment" value="<%=dt.get(0).gettPrice()%>" min="<%=dt.get(0).gettPrice()%>" readonly>
                                <div id="cal">
                                	<button class="btn btn-secondary" type="button" onclick="minus(0);">-</button>
                                	<!-- 인원은 최소 1명부터 2명 까지 -->
                                    <input type="number" id="person" name="person" value="1" min="1" max="2" readonly>
                                    <button class="btn btn-secondary" type="button" onclick="plus(0);">+</button>
                                </div>
                            </div>
                        </div>
						<br><br>
                        <div id="enter">
                            <div id="enter_party">
                                <br><br>
                                <!-- 비회원시 버튼 비 활성화 -->
                                	<button type="submit">참가하기</button>
                                
                            </div>
                        </div>
                    </form>
                    </div>
                </div>
            </div>
			<%}else{ %>
			<div id="rightOption">
				현재 계획중인 일정이 없습니다
			</div>
			<%} %>
            <!-- 하단 이런 트리비는 어떠세요? -->
            <div id="other">
                <div id="text2" style="font-size:20px; font-weight:bolder">이런 트리비는 어떠세요?</div>
                
                <div id="other_triby">
                <%for(int i=0 ; i<ot.size() ; i++) {%>
                
                    <div id="other_triby1">
                        <a href="<%=contextPath%>/detail.ma?tNo=<%=ot.get(i).gettNo()%>">
                            <div class="other_triby1_img">
                                <img src="<%=contextPath%>/resources/images/triby/<%=ot.get(i).gettImg()%>" width ="95%" height="100%">
                            </div>
                            <div class="other_triby1_text">
                                <div class="other_triby_title"><%=ot.get(i).gettName()%></div>
                                <div class="other_triby_price">가격 <%=ot.get(i).gettPrice()%></div>
                                <span class="other_triby_likeCount">좋아요 <%=ot.get(i).getLike()%></span>
                            </div>
                        </a>
                    </div>
                    
                <%} %>
                    
                </div>
            </div>
        </div>
        
    </body>
    	<%@ include file="../common/footer.jsp" %>

    <script>
        $(function(){
        	 amITriby(<%=dt.get(0).gettNo()%>);
        });

        $(function(){
            $("#exit").on("click",function(){
                if($("#triby_person").css("display")==("block")){
                    $("#triby_person").css("display","none");
                }
            });
            $(document).on("click",".heart1",function(e){
            	e.preventDefault();
            	$(this).removeClass("heart1").addClass("heart0").attr("src","/triby/resources/images/common/heart0.png");
            	var tNo=<%=dt.get(0).gettNo()%>;
            	removeLikeTriby(tNo);
            });
            $(document).on("click",".heart0",function(e){
            	e.preventDefault();
            	$(this).removeClass("heart0").addClass("heart1").attr("src","/triby/resources/images/common/heart1.png");
            	var tNo=<%=dt.get(0).gettNo()%>;
            	addLikeTriby(tNo);
            });
        });
        function removeLikeTriby(tNo){
        	$.ajax({
        		url:"removeLikeTriby.me",
        		data:{tNo:tNo},
        		success:function(data){
        			if(data==1){
        				console.log(tNo+"좋아요 제거");
        			}else if(data==0){
        				alert("취소 실패");
        			}else{
        				alert(data);
        				location.reload();
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
        			if(data==1){
        				console.log(tNo+"좋아요");
        			}else if(data==0){
						alert("좋아요 실패");        				
        			}else{
        				alert(data);
        				location.reload();
        			}
        		},
        		error:function(){
        			console.log("addLikeTribyError");
        		}
        	});
        }
        // 스크롤 일정이상 내려가면 display none; 처리
        $(window).scroll(function(){
            if($(document).scrollTop() >= 1600 || $(document).scrollTop() < 40){
                $("#option").fadeOut(100);
            }else{
                $("#option").fadeIn(100);
            }
        });
        
        
        // 일정 선택 버튼 클릭시 list 출현
        $(function(){
            $("#scadule_btn").on("click",function(){
                if($(".scadule_text").css("display")==("block")){
                    $(".scadule_text").fadeOut(100);
                    $("#triby_person").fadeOut(100);

                }else{
                	$(".scadule_text").fadeIn(100);
                	$("#triby_person").fadeIn(100);
                };
            });
        }); 
        
        function minus(e){
        	if(e == 0) {
				var person = $('input[name=person]').val();
				var tPayment = $('input[name=tPayment]').val();
				
				if(person == 1 ){
					$('input[name=person]').attr("disabled",false);
				}else{
					$('input[name=person]').val(person - 1);
					$('input[name=tPayment]').val(tPayment - <%=dt.get(0).gettPrice()%>);
				}		
			}
        }
        
        function plus(e){
        	if(e == 0) {
				var person = $('input[name=person]').val();
				var tPayment = <%=dt.get(0).gettPrice()%>;
				
				if(person == 2){
					$('input[name=person]').attr("disabled",false);
				}else{
					$('input[name=person]').val(parseInt(person) + 1);
					$('input[name=tPayment]').val(parseInt(tPayment) + parseInt(<%=dt.get(0).gettPrice()%>));
				}
			}
        }
        
        
        $(window).scroll(function(){
            if($(document).scrollTop() >= 1600 || $(document).scrollTop() < 40){
                $("#option").fadeOut(100);
            }else{
                $("#option").fadeIn(100);
            }
        });
        
        $(".scadule_text").click(function(){
        	$(this).find("input").prop('checked',true);
        	
        });
        
	function reportHost(){
        	
        	var form = document.createElement("form");      // form생성
        	
        	form.setAttribute("method", "post");                    // method 설정
			form.setAttribute("action", "<%= contextPath%>/insertM.rep");       // action 설정
			form.setAttribute("target", "reportForm")
			
			document.body.appendChild(form);
			
			var input_id2 = document.createElement("input");
			
			input_id2.setAttribute("type", "hidden");

			input_id2.setAttribute("name", "hNo");      //name 속성 지정
			input_id2.setAttribute("value", <%= dh.get(0).gethNo() %>);        //value 값 설정

			form.appendChild(input_id2);
			
			var wintype = "width=520, height=520, resizable=no";
			open("", "reportForm", wintype);
			
			form.submit();
        	
        }
	function amITriby(tNo){
    	$.ajax({
    		url:"amIlikeTriby.me",
    		data:{tNo:tNo},
    		success:function(data){
    			var heart=$(".heart0");
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
