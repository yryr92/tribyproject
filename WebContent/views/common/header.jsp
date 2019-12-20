<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.triby.member.model.vo.Member" %>
<%
   String contextPath = request.getContextPath();
   Member loginUser = (Member)session.getAttribute("loginUser");
   String msg = (String)session.getAttribute("joinSuccessMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
   <link rel="stylesheet" href="css/bootstrap.min.css">
   <link rel="stylesheet" href="<%=contextPath %>/resources/css/triby_myPage.css">
    <title>TRIBY</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
   $(document).ready(function() {
      var msg = "<%=msg%>";
      if(msg != "null") {
         alert(msg);
         <%session.removeAttribute("joinSuccessMsg");%>
      }
   })
</script>
<style>
a, a:hover {
	text-decoration: none;
}

header {
	font-family: 'Noto Sans KR', sans-serif; //
	background: red;
	width: 100%;
}

#header {
	width: 60%;
	height: 60px;
	margin: 0 auto;
	border: 0px solid black;
}

#logo_bar {
	width: 20%;
	height: 100%;
	float: left;
}

#logo_cover {
	width: 100%;
	height: 100%;
}

#logo {
	width: 100%;
	height: 100%;
}

#search_bar {
	width: 45%;
	height: 100%;
	float: left;
}

#search_form {
	width: 100%;
	height: 100%;
}

#search_tool {
	border: 0px solid black;
	width: 92.5%;
	height: 90%;
}

#right {
	float: right;
	border: 0px solid black;
	/* text-align: center; */
	width: 34.5%;
	height: 100%;
	top: 25px;
	font-size: 14px;
}

#right_menu {
	height: 100%;
	line-height: 50px;
}

#login_right_menu {
	border: 0px solid black;
	height: 20%;
	line-height: 50px;
}

#signup1, #login1 {
	min-height: 1px;
}

#signup_background, #login_background, #center_background {
	display: inline;
	cursor: pointer;
	position: relative;
}

#signup_text, #login_text, #center_text {
	text-decoration: none;
	max-width: 85px;
	height: 14px;
	font-size: 14px;
	font-weight: bold;
	font-style: normal;
	font-stretch: normal;
	line-height: 1;
	letter-spacing: normal;
	text-align: right;
	color: rgb(0, 0, 0);
}

#boundary {
	width: 1px;
	height: 10px;
	background-color: rgb(221, 221, 221);
	margin-left: 14px;
	margin-right: 14px;
	display: inline-block;
}

#arrow {
	margin-left: 4px;
	width: 18px;
	height: 18px;
	transform: rotate(90deg);
	vertical-align: text-bottom;
}

#center_category {
	width: 124px;
	background-color: rgb(255, 255, 255);
	position: absolute;
	z-index: 200;
	left: 0px;
	top: 30px;
	border-width: 1px;
	border-style: solid;
	border-color: rgb(238, 238, 238);
	border-image: initial;
	border-radius: 5px;
	padding: 10px;
}

#notice_text, #question_text, #signHost_text {
	font-size: 12px;
	font-weight: bold;
	line-height: 24px;
	margin: 3px;
}

#loginUser1 {
	height: 18px;
	width: 45px;
	display: inline;
	cursor: pointer;
}

#loginUser2 {
	text-decoration: none;
	max-width: 85px;
	height: 14px;
	font-size: 14px;
	font-weight: bold;
	font-style: normal;
	font-stretch: normal;
	line-height: 1;
	letter-spacing: normal;
	text-align: right;
	color: rgb(0, 0, 0);
}

#loginUser_category {
	width: 124px;
	background-color: rgb(255, 255, 255);
	position: absolute;
	z-index: 200;
	left: 59%;
	top: 9.5%;
	border-width: 1px;
	border-style: solid;
	border-color: rgb(238, 238, 238);
	border-image: initial;
	border-radius: 5px;
	padding: 5px;
}

#like2, #buy2, #coupon2, #mypage2, #logout2 {
	font-size: 12px;
	font-weight: bold;
	line-height: 24px;
	margin: 3px;
}

#category_line {
	display: block;
	border: 0px solid red;
}

#category_cover {
	width: 60%;
	height: 60px;
	margin: 0 auto;
	border: 0px solid blue;
}

#btn_cover {
	boerder: 1px solid blue;
	position: relative;
	width: 100%;
	height: 35px;
}

.category_btn_cover {
	background: #0b8c8c;
	height: 35px;
}

.category_btn_cover2 {
	background: #0b8c8c;
	height: 35px;
	flex:0 0 auto;
	flex-flow:row wrap;
}

.category_btn {
	width: 33.3%;
	text-align: center;
	font-weight: bolder;
	font-size: 20px;
	float: left;
}

.category_btn2 {
	margin-left:30px;
	text-align: center;
	font-weight: bolder;
	font-size: 15px;
}

.category_btn3 {
	width: 10%;
	text-align: center;
	font-weight: bolder;
	font-size: 15px;
	float: left;
}

.category_btn4 {
	width: 15.5%;
	text-align: center;
	font-weight: bolder;
	font-size: 15px;
	float: left;
}

#category_list {
	display: none;
}

#category_list2 {
	display: none;
}

#category_list3 {
	display: none;
}

a {
	color: black;
}

/*  인덱스 페이지 스타일 */
body {
	width: 100%;
	font-family: 'Noto Sans KR', sans-serif;
}

#body {
	width: 60%;
	margin: 0 auto;
	border: 0px solid black;
	font-family: 'Noto Sans KR', sans-serif;
}

#body1 {
	width: 50%;
	margin: 0 auto;
	border: 0px solid black;
	font-family: 'Noto Sans KR', sans-serif;
}

.mainCover {
	width: 100%;
	height: 300px;
	border: 0px solid black;
}

#changeBanner {
   width: 100%;
   height: 100%;
   background-image: url('resources/images/common/00.jpg');
   background-size: cover;
   background-repeat: no-repeat;
}

#banner {
	/* 오른쪽 테이블 hover 하면 여기가 체인지 */
	float: left;
	color: white;
}

#table_cover {
	width: 25%;
	height: 100%;
	float: right;
	margin-top: 10px;
	margin-right: 20px;
}

#table {
	margin-top: 25%;
	width: 95%;
	height: 60%;
	text-align: center;
	font-size: 15px;
	line-height: 55px;
	font-weight: bold; //
	border: 1px solid white;
}

#table div {
	color: black;
	height: 30%;
	background-color: #ffffff;
	opacity: 0.5;
}

#st, #hb {
	margin-top: 2px;
}

/* 메인 인기 트리비 */
#hot, #new {
	width: 100%;
	height: 350px;
	/* border: 1px solid black; */
}

.hot_label, .new_label {
	width: 40%;
}

/*메인 인기 트리비*/

/* 이미지 슬라이드 스타일 */
li, ul {
	list-style: none;
}

#slide {
	width: 100%;
	height: 100%;
	position: relative; /* position : static 이 아닌 부모 기준 */
	overflow: hidden;
	padding: 0;
	margin: 0 auto;
}

#slide ul {
	position: absolute;
	top: 0;
	left: 0;
	/*width: 400%;
        height: 100%;
        transition: 1s;*/
	margin: 0;
	padding: 0px;
	width: 100%;
}

#slide ul li {
	float: left;
	/*width:25%;
        height:100%;*/
	width: 1200px;
	height: 200px;
	cursor: pointer;
	margin: 0;
	padding: 0;
}

#slide li:nth-child(1) {
	background: #faa;
}

#slide li:nth-child(2) {
	background: #ffa;
}

#slide li:nth-child(3) {
	background: #faF;
}

#slide li:nth-child(4) {
	background: #aff;
}

#slide input {
	display: none;
}

#slide label {
	display: inline-block;
	vertical-align: middle;
	width: 10px;
	height: 10px;
	border: 2px solid #666;
	background: #fff;
	transition: 0.3s;
	border-radius: 50%;
	cursor: pointer;
}

#slide .pos {
	text-align: center;
	position: absolute;
	bottom: 10px;
	left: 0;
	width: 100%;
}

#pos1:checked ~ul{
	margin-left: 0%;
}

#pos2:checked ~ul{
	margin-left: -100%;
}

#pos3:checked ~ul{
	margin-left: -200%;
}

#pos4:checked ~ul{
	margin-left: -300%;
}

#pos1:checked ~.pos>label:nth-child(1) {
	background: #666;
}

#pos2:checked ~.pos>label:nth-child(2) {
	background: #666;
}

#pos3:checked ~.pos>label:nth-child(3) {
	background: #666;
}

#pos4:checked ~.pos>label:nth-child(4) {
	background: #666;
}

#triby_img {
	height: 200px;
	position: relative;
}
/* 이미지 슬라이드 스타일 */

/* 카테고리 검색 스타일 */
#hot, #deadline, #new {
	width: 100%;
	height: 30%;
	display: block;
	/* border: 1px solid black; */
}

.hot_label, .deadline_label, .new_label {
	width: 40%;
}

#hot_category, #hot_List, #deadline_category, #deadline_List,
	#new_category, #new_List {
	height: 20%;
	margin: 0 auto;
	font-size: 20px;
	font-weight: bold;
	line-height: 100%;
}

#hot_List, #deadline_List, #new_List {
	float: right;
}

#hot_triby, #deadline_triby, #new_triby {
	width: 100%;
	height:250px;
	display: flex;
}
.hot_triby1_img img {
	border-radius: 5px;
}
.new_triby1_img img {
	border-radius: 5px;
}
.deadline_triby1_img img {
	border-radius: 5px;
}

.hot_triby1, .deadline_triby1, .new_triby1 {
	/* border: 1px solid blue; */
	width: 25%;
	margin-right: 10px;
	flex: 0 0 calc(25% - 10px);
}

.hot_triby1_img, .deadline_triby1_img, .new_triby1_img {
	height: 60%;
}

.hot_triby1_text, .deadline_triby1_text, .new_triby1_text {
	height: 40%;
	width: 95%;
}

.hot_triby_title, .deadline_triby_title, .new_triby_title {
	font-size: 15px;
	font-weight:800;
}

.hot_triby_price, .deadline_triby_price, .new_triby_price {
	font-size: 15px;
	font-weight:500;
}

.hot_triby_point, .deadline_triby_point, .new_triby_point {
	font-size: 15px;
}

.hot_triby_likeCount, .deadline_triby_likeCount, .new_triby_likeCount {
	font-size: 15px;
	font-weight:500;
}

/* 검색  */
#filter_line {
	width: 100%;
	height: 25px;
	/* border: 1px solid black; */
	/* 인기순 / 평점순 / 가격순 / 최신순 */
}

#filter_btn {
	float: right;
	width: 100%;
	height: 100%;
	text-align: right;
	font-weight: bold;
	position: relative;
}

#filter_btn a {
	font-size: 20px;
}

#filter_hide {
	border: 0px solid black;
	background: white;
	width: 30%;
	height: 100%;
	display: none;
	float: right;
	z-index: 1px;
}
/* 트리비 검색 결과 */
#search {
	width: 100%;
	display: flex;
	flex-wrap: wrap;
	/* border: 1px solid black; */
}

.search_label {
	width: 100%;
	height: 5%;
	margin-bottom: 60px;
}

#search_category {
	height: 80%;
	width: 20%;
	margin: 0 auto;
	font-size: 20px;
	font-weight: bold;
	line-height: 100%;
	float: left;
}

#search_triby {
	width: 100%;
	display: flex;
	flex-flow: row wrap;
}

.pagingArea {
	margin-top: 60px;
}

.pagingArea button {
	width: 40px;
	height: 40px;
	line-height: normal;
	background-color: white;
	cursor: pointer;
	font-size: 18px;
	padding: 0px;
	border-radius: 50%;
	outline: none;
	border-style: none;
}

.search_triby1_img img {
	border-radius: 5px;
}

.search_triby1 {
	/* border: 1px solid blue; */
	width: 25%;
	height:300px;
	flex: 0 0 calc(25% -10px);
}

.search_triby1_img {
	height: 60%;
}

.search_triby1_text {
	height: 40%;
	width: 95%;
}

.search_triby_title {
	font-size: 18px;
	font-weight: 800;
}

.search_triby_price {
	font-size: 15px;
	font-weight: 500;
}

.search_triby_point {
	font-size: 15px;
	font-weight: 500;
}

.search_triby_likeCount {
	font-size: 15px;
	font-weight: 500;
}

/* 디테일 뷰 */
#leftNright {
	height: 100%;
	position: relative;
}

#left {
	width: 60%;
	height: 100%;
	border: 0px solid red;
	float: left;
}

.triby_left {
	margin: 0 auto;
	border: 0px solid black;
	position: relative;
}

#triby_img1 {
	height: 400px;
}

/* 이미지 슬라이드 스타일 */
li, ul {
	list-style: none;
}

#slide1 {
	margin-top: 10px;
	width: 95%;
	height: 100%;
	position: absolute; /* position : static 이 아닌 부모 기준 */
	overflow: hidden;
}

#slide1 ul {
	width: 400%;
	height: 100%;
	transition: 1s;
	padding: 0px;
}

#slide1 ul:after {
	content: "";
	display: block;
	clear: both;
}

#slide1 li {
	float: left;
	width: 25%;
	height: 100%;
}

#slide1 li:nth-child(1) {
	background: #faa;
}

#slide1 li:nth-child(2) {
	background: #ffa;
}

#slide1 li:nth-child(3) {
	background: #faF;
}

#slide1 li:nth-child(4) {
	background: #aff;
}

#slide1 input {
	display: none;
}

#slide1 label {
	display: inline-block;
	vertical-align: middle;
	width: 10px;
	height: 10px;
	border: 2px solid #666;
	background: #fff;
	transition: 0.3s;
	border-radius: 50%;
	cursor: pointer;
}

#slide1 .pos {
	text-align: center;
	position: absolute;
	bottom: 10px;
	left: 0;
	width: 100%;
}

#pos1:checked ~ul{
	margin-left: 0%;
}

#pos2:checked ~ul{
	margin-left: -100%;
}

#pos3:checked ~ul{
	margin-left: -200%;
}

#pos4:checked ~ul{
	margin-left: -300%;
}

#pos1:checked ~.pos>label:nth-child(1) {
	background: #666;
}

#pos2:checked ~.pos>label:nth-child(2) {
	background: #666;
}

#pos3:checked ~.pos>label:nth-child(3) {
	background: #666;
}

#pos4:checked ~.pos>label:nth-child(4) {
	background: #666;
}
/* 이미지 슬라이드 스타일 */

/* 트리비 타이틀 & 좋아요 */
.triby_left {
	margin: 0 auto;
	border: 0px solid black;
	position: relative;
}

#triby_title, #triby_price { /* 부모 설정 */
	height: 60px;
	width: 95%;
	margin-left: 0;
}

#tTitle {
	margin-top:5px;
	font-size: 23px;
	font-weight: 800;
	float: left;
}

#report {
	float: right;
}

#review_write {
	float: right;
}

#icon {
	float: right;
}

#tLike {
	float: right;
	margin-left: 5px;
}

#tPrice {
	font-size: 15px;
	font-weight: 800;
}

#heart {
	cursor: pointer;
}

#triby_info {
	height: 130px;
}
#info2{
	font-weight: 500;
}
#info4{
	color:rgb(11,140,140);
	font-weight:600;
}

#tInfo {
	font-size: 18px;
	font-weight: 800;
}

#host_profile, #host_review { /* 부모 설정 */
	height: 250px;
	width: 95%;
	margin-left: 0px;
}

#triby_introduce {
	height: 100%;
}

#triby_position {
	height: 500px;
}

#FAQ {
	height: 300px;
}

#rMoney {
	height: 300px;
}

.intro_title {
	width: 50%;
	font-size: 20px;
	font-weight: bold;
}

#host_point {
	width: 20%;
	font-size: 15px;
	font-weight: bold;
	text-align: right;
	float: right;
}

.profile_img {
	height: 40px;
	width: 40px;
}

#host_intro, #review {
	height: 100px;
	width: 100%;
}

#host_intro2 {
	height: 80px;
	width: 100%;
	border: 0px solid black;
	overflow: hidden;
}

#host_pro_link {
	width: 100%;
	height: 50px;
	border: 0px solid black;
	text-align: center;
	font-size: 20px;
	cursor: pointer;
	border-radius: 20px;
}

#triby_introduce { /* 부모 설정 */
	width: 95%;
	margin-left: 0px;
}

#triby {
	height: 80%;
	width: 100%;
}

#triby_text1 {
	text-align: center;
}

#triby_position2 {
	height: 100px;
	width: 95%;
	margin-left: 0px;
}

#FAQ {
	width: 95%;
	margin-left: 0px;
}

#FAQ_text, #rMoney_text {
	text-align: left;
	font-weight: bolder
}

#rMoney {
	width: 95%;
	height: 230px;
	margin-left: 0px;
}

/* 오른쪽 란 */
#rightOption {
	width: 39%;
	height: 100%;
	border: 0px solid lightgrey;
	float: right;
	position: relative;
}

#option {
	height: 100%;
	width: 20%;
	top: 30px;
	position: fixed; /* position : static 이 아닌 부모 기준 */
	border: 0px solid purple;
	display: none;
}

#scadule {
	height: 50px;
	width: 100%;
}

#scadule_choice {
	width: 75%;
	font-size: 20px;
	float: left;
}

#scadule_btn {
	width: 20%;
	float: right
}

#scadule_list {
	height: 40%;
	display: block;
}

.scadule_text {
	font-size: 15px;
	margin: 0 auto;
	width: 90%;
	height:50px;
	text-align: center;
	border: 1px solid rgb(11,140,140);
	border-radius:10px;
	cursor: pointer;
	display: none;
	
}

#triby_person2 {
	margin-top: 50px;
	margin-left: auto;
	margin-right: auto;
	height: 80px;
	display: block;
}

#triby_person {
	font-size: 15px;
	margin: 0 auto;
	width: 90%;
	height: 85px;
	text-align: left;
	border-radius:10px;
	border: 1px solid rgb(11,140,140);
	display: none;
}

#exit {
	float: right;
}

#cal {
	float: right;
}

#enter {
	height: 20%;
}

#enter_party {
	width: 100%;
	height: 100%;
	display:flex;
	align-items:center;
	justify-content:center;
}

/* 하단 이런 트리비는 어떠세요? */
#other {
	clear: both;
	border: 0px solid lightgrey;
	height: 210px;
}

#other_List {
	float: left;
}

#other_triby {
	width: 100%;
	height: 90%;
}

#other_triby1 {
	border: 0px solid blue;
	width: 25%;
	height: 250px;
	float: left;
}
#pay_triby1{
	width: 100%;
	height: 100%;
	float: left;
}
.pay_triby1_img{
	height:100%;
	width:30%;
	float:left;
	border-radius:10px;
}
.pay_triby1_text{
	height:40%;
	width:50%;
	float:left;
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

#tPayment {
	width: 50%;
	font-size: 20px;
	float: left;
}

#person {
	width: 30px;
}

#report_icon:hover {
	cursor: pointer
}

#icon>* {
	margin-right: 5px;
}

#enter_party>button{
	box-sizing: border-box;
	background: rgb(11, 140, 140);
	text-align: center;
	width:80%;
	height:80px;
	font-size: 30px;
	border-radius: 5px;
	display: flex;
	padding: 15px;
	align-items: center;
	justify-content: center;
	color: white;
	font-weight: bold;
	cursor: pointer;
	border: 1px solid lightgray;
}
#scadule_btn>button{
	background: transparent;
	color: rgb(11, 140, 140);
	font-size: 15px;
	border-style:none;
}
#triby_person input{
	border-style:none;
	background:white;
}

</style>
</head>

<body>
    <!-- 헤더 부분 화면의   //  100%를 큰 틀로 잡고 -->
    <header>
    <br>
        <!-- 헤더 큰틀 이 안에서만 작업  //그 100% 중에 50%를 다시 중간 틀로 잡고 작업 -->
        <div id="header">
            <!-- 헤더 중에서 로고 들어갈 1번 구역 -->
            <div id="logo_bar">
            	<div id="logo_cover">
	                <a id="logo" href="index.jsp"><img src="<%=contextPath%>/resources/images/triby_logo.png" height="100%;"></a>
                </div>	
            </div>
            <!-- 헤더 중에서 서치바 들어갈 2번 구역 -->
            <div id="search_bar">
            	<form action="<%= contextPath %>/search.ma" method="get" id="search_form">
                	<input type="text" id="search_tool" name="search" placeholder="새로운 취미를 경험해보세요!">
				</form>
            </div>
            <!-- 헤더 중에서 오른쪽 버튼 들어갈 3번 구역 -->
            <div id="right">
            <%if(loginUser == null) { %>
                <div id="right_menu">
                    <a id="signup_a" href="<%=request.getContextPath()%>/form.me">
                        <div id="signup_background">
                            <span id="signup_text">회원가입</span>
                        </div>
                    </a>
                    <span id="boundary"></span>
                    <a id="login_a" href="<%=request.getContextPath()%>/loginpg.me">
                        <div id="login_background">
                            <span id="login_text">로그인</span>
                        </div>
                    </a>
                    <span id="boundary"></span>	
                    <div id="center_background">
                            <span id="center_text">
                                   	고객센터
                                <img src= "<%=contextPath%>/resources/images/캡처.PNG" id="arrow">
                            </span>
                            <div id="center_category" style="display: none">
                                <a id="notice_a" href="notice">
                                    <div id="notice_text">공지사항</div>
                                </a>
                                <a id="question_a" href="FAQ">
                                    <div id="question_text">자주 묻는 질문</div>
                                </a>
                                <a id="signHost_a" href="<%=request.getContextPath()%>/adminSignup.ho">
                                    <div id="signHost_text">호스트 가입</div>
                                </a>
                            </div>
                        </div>
                </div>
            </div>    
            
        </div>
                    
                    <%}else{ %>
                    <div id = "login_right">
                    <div id ="login_right_menu" >
            
               <div id="loginUser1">
                  <span id="loginUser2"> <%=loginUser.getName()%>트리버님 <img src="<%=contextPath%>/resources/images/캡처.PNG" id="arrow">
                  </span>
                  <div id="loginUser_category" style="display:none">
                     <a id="like1" href="myLikeTriby">
                        <div id="like2">좋아요</div>
                     </a> <a id="buy1" href="myTribyPre">
                        <div id="buy2">구매목록</div>
                     </a> <a id="coupon1" href="myCoupon">
                        <div id="coupon2">쿠폰</div>
                     </a> <a id="mypage1" href="myProfile">
                        <div id="mypage2">마이 페이지</div>
                     </a> <a id="logout1" href=#>
                        <div id="logout2" onclick="logout();">로그아웃</div>
                     </a>
                  </div>
            
            <span id="boundary"></span>
         <div id="center_background">
                <span id="center_text">
                                고객센터
                 <img src= "<%=contextPath%>/resources/images/캡처.PNG" id="arrow">
                   </span>
                    <div id="center_category" style="display: none">
                                <a id="notice_a" href="notice">
                                    <div id="notice_text">공지사항</div>
                                </a>
                                <a id="question_a" href="FAQ">
                                    <div id="question_text">자주 묻는 질문</div>
                                </a>
                                <a id="signHost_a" href="<%=request.getContextPath()%>/adiminSignup.ho">
                                    <div id="signHost_text">호스트 가입</div>
                                </a>
                            </div>
                        </div>
                    
                </div>
          
                    <%} %>
              </div>
      </div>
      
      <!-- 헤더 하단 카테고리 부분 -->
      
      </header>
<!--  <hr>     -->
	       <div id="category_line">
				<!-- 헤더 하단부 버튼 틀 -->
				
	       		<div id="category_cover">
	       		
	       			<div id="btn_cover">
	       			<div class="category_btn_cover">
						<div class="category_btn">
							<a href="<%=request.getContextPath()%>/category.ma?category=AC" style="color:white;" id="cAc" name="categoty">액티비티</a>
						</div>
						<div class="category_btn">
							<a href="<%=request.getContextPath()%>/category.ma?category=ST" style="color:white;" id="cSt" name="category">배움</a>
						</div>
						<div class="category_btn">
							<a href="<%=request.getContextPath()%>/category.ma?category=HB" style="color:white;" id="cHb" name="category">건강/뷰티</a>
						</div>
					</div>	
	       			</div>
	       			
	       			<div class="category_btn_cover2" id="category_list">
	       				<div class="category_btn2">
							<a href="<%=request.getContextPath()%>/category.ma?category=AC1" style="color:white;">아웃도어</a>
						</div>
						<div class="category_btn2">
							<a href="<%=request.getContextPath()%>/category.ma?category=AC2" style="color:white;">워터파크</a>
						</div>
						<div class="category_btn2">
							<a href="<%=request.getContextPath()%>/category.ma?category=AC3" style="color:white;">수상레저</a>
						</div>
						<div class="category_btn2">
							<a href="<%=request.getContextPath()%>/category.ma?category=AC4" style="color:white;">투어</a>
						</div>
						<div class="category_btn2">
							<a href="<%=request.getContextPath()%>/category.ma?category=AC5" style="color:white;">축제</a>
						</div>
						<div class="category_btn2">
							<a href="<%=request.getContextPath()%>/category.ma?category=AC6" style="color:white;">공연</a>
						</div>
						<div class="category_btn2">
							<a href="<%=request.getContextPath()%>/category.ma?category=AC7" style="color:white;">전시</a>
						</div>
						<div class="category_btn2">
							<a href="<%=request.getContextPath()%>/category.ma?category=AC8" style="color:white;">실내체험</a>
						</div>
	       			</div>
	       			<div class="category_btn_cover2" id="category_list2">
	       				<div class="category_btn3">
							<a href="<%=request.getContextPath()%>/category.ma?category=ST1" style="color:white;">스포츠</a>
						</div>
						<div class="category_btn3">
							<a href="<%=request.getContextPath()%>/category.ma?category=ST2" style="color:white;">음악</a>
						</div>
						<div class="category_btn3">
							<a href="<%=request.getContextPath()%>/category.ma?category=ST3" style="color:white;">미술</a>
						</div>
						<div class="category_btn3">
							<a href="<%=request.getContextPath()%>/category.ma?category=ST4" style="color:white;">공예</a>
						</div>
						<div class="category_btn3">
							<a href="<%=request.getContextPath()%>/category.ma?category=ST5" style="color:white;">요리</a>
						</div>
						<div class="category_btn3">
							<a href="<%=request.getContextPath()%>/category.ma?category=ST6" style="color:white;">음료</a>
						</div>
						<div class="category_btn3">
							<a href="<%=request.getContextPath()%>/category.ma?category=ST7" style="color:white;">영상</a>
						</div>
						<div class="category_btn3">
							<a href="<%=request.getContextPath()%>/category.ma?category=ST8" style="color:white;">사진</a>
						</div>
						<div class="category_btn3">
							<a href="<%=request.getContextPath()%>/category.ma?category=ST9" style="color:white;">외국어</a>
						</div>
						<div class="category_btn3">
							<a href="<%=request.getContextPath()%>/category.ma?category=ST10" style="color:white;">독서</a>
						</div>
	       			</div>
	       			<div class="category_btn_cover2" id="category_list3">
	       				<div class="category_btn4">
							<a href="<%=request.getContextPath()%>/category.ma?category=HB1" style="color:white;">피트니스</a>
						</div>
						<div class="category_btn4">
							<a href="<%=request.getContextPath()%>/category.ma?category=HB2" style="color:white;">요가</a>
						</div>
						<div class="category_btn4">
							<a href="<%=request.getContextPath()%>/category.ma?category=HB3" style="color:white;">필라테스</a>
						</div>
						<div class="category_btn4">
							<a href="<%=request.getContextPath()%>/category.ma?category=HB4" style="color:white;">스파</a>
						</div>
						<div class="category_btn4">
							<a href="<%=request.getContextPath()%>/category.ma?category=HB5" style="color:white;">심리</a>
						</div>
						<div class="category_btn4">
							<a href="<%=request.getContextPath()%>/category.ma?category=HB6" style="color:white;">상담</a>
						</div>
	       			</div>
	       			
	       		</div>
       		<hr>
	       </div>
              

<script>
   
    $(function () {
        $("#center_text").on("click", function () {
         $("#center_category").toggle(1);
      $("#loginUser_category").hide(1);
          });
    });
    
    $(function(){
        $("#cAc").mouseover(function(){
            if($("#category_list").css("display") == "none"){
                $('#category_list').css("display", "flex");
                $('#category_list2').css("display", "none");
                $('#category_list3').css("display", "none");     
            }
        });
        
        $("#cSt").mouseover(function(){
            if($("#category_list2").css("display") == "none"){
                $('#category_list2').css("display", "flex");
                $('#category_list').css("display", "none");
                $('#category_list3').css("display", "none");     
            }
        });
        $("#cHb").mouseover(function(){
        	if($("#category_list3").css("display") == "none"){
                $('#category_list3').css("display", "flex");
                $('#category_list2').css("display", "none");
                $('#category_list').css("display", "none");     
            }
        });
        
    });
    
   $(function() {
      $("#loginUser2").on("click", function() {
         $("#loginUser_category").toggle(1);
         $("#center_category").hide(1);
      });
   });
   function logout(){
       location.href="<%=contextPath %>/logout.me";
    }
   
	// 스크롤 일정이상 내려가면 display none; 처리
	  $(window).scroll(function(){
	      if($(document).scrollTop() == 0){
	    	  $("#category_line").slideDown();
	          //$("#").css("display","block");
	      }else{
	    	  $("#category_line").slideUp();
	    	  $('#category_list').css("display", "none");
              $('#category_list2').css("display", "none");
              $('#category_list3').css("display", "none");
	      }
	  });
	
</script>

</body>
</html>
