<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.e2.user.model.vo.Member"%>
<%
	String loginFail = (String)session.getAttribute("loginFail");
	Member loginUser = (Member)session.getAttribute("loginUser");	
	String contextPath = request.getContextPath();
	String alertMsg = (String)session.getAttribute("alertMsg");
%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>CodePen - Login/Registration Form Transition</title>
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link
	rel="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

	<style>
		*, *:before, *:after {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  font-family: "Open Sans", Helvetica, Arial, sans-serif;
  background: #ededed;
}

input, button {
  border: none;
  outline: none;
  background: none;
  font-family: "Open Sans", Helvetica, Arial, sans-serif;
}

.tip {
  font-size: 20px;
  margin: 40px auto 50px;
  text-align: center;
}

.cont {
  padding-top: 10px;
  overflow: hidden;
  position: relative;
  width: 900px;
  height: 550px;
  margin: 0 auto 100px;
  background: #fff;
}

.form {
  position: relative;
  width: 640px;
  height: 100%;
  transition: transform 1.2s ease-in-out;
  padding: 50px 30px 0;
}

.sub-cont {
  overflow: hidden;
  position: absolute;
  left: 640px;
  top: 0;
  width: 900px;
  height: 100%;
  padding-left: 260px;
  background: #fff;
  transition: transform 1.2s ease-in-out;
}
.cont.s--signup .sub-cont {
  transform: translate3d(-640px, 0, 0);
}

button {
  display: block;
  margin: 0 auto;
  width: 260px;
  height: 36px;
  border-radius: 30px;
  color: #fff;
  font-size: 15px;
  cursor: pointer;
}

.img {
  overflow: hidden;
  z-index: 2;
  position: absolute;
  left: 0;
  top: 0;
  width: 260px;
  height: 100%;
  padding-top: 360px;
}
.img:before {
  content: "";
  position: absolute;
  right: 0;
  top: 0;
  width: 900px;
  height: 100%;
  background-image: url("https://s3-us-west-2.amazonaws.com/s.cdpn.io/142996/sections-3.jpg");
  background-size: cover;
  transition: transform 1.2s ease-in-out;
}
.img:after {
  content: "";
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.6);
}
.cont.s--signup .img:before {
  transform: translate3d(640px, 0, 0);
}
.img__text {
  z-index: 2;
  position: absolute;
  left: 0;
  top: 50px;
  width: 100%;
  padding: 0 20px;
  text-align: center;
  color: #fff;
  transition: transform 1.2s ease-in-out;
}
.img__text h2 {
  margin-bottom: 10px;
  font-weight: normal;
}
.img__text p {
  font-size: 14px;
  line-height: 1.5;
}
.cont.s--signup .img__text.m--up {
  transform: translateX(520px);
}
.img__text.m--in {
  transform: translateX(-520px);
}
.cont.s--signup .img__text.m--in {
  transform: translateX(0);
}
.img__btn {
  overflow: hidden;
  z-index: 2;
  position: relative;
  width: 100px;
  height: 36px;
  margin: 0 auto;
  background: transparent;
  color: rgb(255, 255, 255);
  text-transform: uppercase;
  font-size: 15px;
  cursor: pointer;
}
.img__btn:after {
  content: "";
  z-index: 2;
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  border: 2px solid #fff;
  border-radius: 30px;
}
.img__btn span {
  position: absolute;
  left: 0;
  top: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  transition: transform 1.2s;
}
.img__btn span.m--in {
  transform: translateY(-72px);
}
.cont.s--signup .img__btn span.m--in {
  transform: translateY(0);
}
.cont.s--signup .img__btn span.m--up {
  transform: translateY(72px);
}

h2 {
  width: 100%;
  font-size: 26px;
  text-align: center;
}

label {
  display: block;
  width: 260px;
  margin: 25px auto 0;
  text-align: center;
}
label span {
  font-size: 12px;
  color: #cfcfcf;
  text-transform: uppercase;
}

input {
  display: block;
  width: 100%;
  margin-top: 5px;
  padding-bottom: 5px;
  font-size: 16px;
  border-bottom: 1px solid rgba(0, 0, 0, 0.4);
  text-align: center;
}

.forgot-pass {
  margin-top: 15px;
  text-align: center;
  font-size: 12px;
  color: #cfcfcf;
}

#login {
  margin-top: 40px;
  margin-bottom: 10px;
  background: #6ddfc2;
  text-transform: uppercase;
}

#user-insert {	
  margin-top: 20px;
  border: 2px solid #d3dae9;
  color: #57688f;
}

#find-id {
  margin-top: 40px;
  margin-bottom: 20px;
  background: #6ddfc2;
  text-transform: uppercase;
}

#find-pwd {
  margin-top: 20px;
  border: none;
  color: #ffffff;
  background: #6ddfb9;
}

.fb-btn span {
  font-weight: bold;
  color: #455a81;
} 

.sign-in {
  transition-timing-function: ease-out;
}
.cont.s--signup .sign-in {
  transition-timing-function: ease-in-out;
  transition-duration: 1.2s;
  transform: translate3d(640px, 0, 0);
}

.sign-up {
  transform: translate3d(-900px, 0, 0);
}
.cont.s--signup .sign-up {
  transform: translate3d(0, 0, 0);
}
.top-header {
  margin-top: 150px;
}
#errorMsg{
	color : red;
	text-align : center;
	margin-top : 3px;
}
	</style>

</head>
<body>
	
	
	<!-- partial:index.partial.html -->
	<div class="top-header"></div>
	<div class="cont" style="border-radius : 15px; ">

	
	<div class="form sign-in">
		<%if(loginUser==null) {%>
		<form action="<%=request.getContextPath() %>/login.member" method="post" id="login-form">
			<h2>환영합니다</h2>
			<label> 
			<span>아이디</span> 
			<input type="text" id="userId" name="userId"required/>
			</label> 
			
			
			<label> 
			<span>비밀번호</span> 
			<input type="password" id="password" name="password" required/>
			</label>
			

			<button type="submit" id="login">로그인</button>
			<button onclick="location.href='<%=contextPath%>/MemberEnrollForm.do'" id="user-insert">회원가입</button>
		</form>
		<%}else {%>
			<%response.sendRedirect("contextPath"); %>
			
		<%} %>
	</div>
		
		
		<div class="sub-cont">
			<div class="img">
				<div class="img__text m--up">
					<h3>기억이 안나시나요?</h3><br>
					<p>당신의 잃어버린 아이디와 비밀번호를 찾아드립니다</p>
				</div>
				<div class="img__btn" onclick="location.href='US_0030.jsp'">
					<span class="m--up">정보 찾기</span>
			</div>
		</div>
	</div>
	</div>


	

	<!-- partial -->
	<script>	
		
		
		var msg = "<%=alertMsg%>";
			
		
		if(msg != "null"){
			alert(msg);
			console.log("msg : "+msg);
			<%session.removeAttribute("alertMsg");%>
		}
		
	</script>

</body>
</html>