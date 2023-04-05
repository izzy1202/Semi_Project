<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.e2.user.model.vo.Member"%>
<%
	// context root(path) : 고정값이 아닌 메소드를 통해 얻어오기
	String contextPath = request.getContextPath();

	// 로그인 성공 시 session에 담아놓은 loginUser 꺼내기
	Member loginUser = (Member)session.getAttribute("loginUser");
	// 로그인 전 loginUser == null
	// 로그인 후 loginUser == 로그인한 회원 정보를 담은 Member 객체
	
	// 로그인 성공시 session에 담아놓은 알림 메세지도 꺼내주기
	String alertMsg = (String)session.getAttribute("alertMsg");
	
	// 서비스 요청 전 : null
	// 서비스 요청 후 : 해당서비스에서 넣어놓은 알림 메세지
	
	
%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome E Class</title>
<style>
#login-form, #user-info {
	float: right;
}

#user-info a {
	text-decoration: none; /*밑줄 없애기*/
	color: black;
	font-size: 12px;
}

</style>
</head>
<body>
<script>
	// script 태그 내에도 스크립틀릿과 같은 jsp 요소를 사용할 수 있다.
	// alert 메세지가 있으면 띄워주고 없으면 안띄워주면 됨
	var msg = "<%=alertMsg%>";
	if(msg != "null"){
		alert(msg);
		// 알림창을 띄워준 후에 session에 담긴 alertMsg를 지워야 한다.
		// 하지 않으면 새로고침(페이지 리로딩)될 때마다 alert창이 띄워지게 된다.
		<%session.removeAttribute("alertMsg");%>
	}	
</script>
	<div class="login-area">
	<%if(loginUser==null){ %>
		<form action="<%=contextPath%>/login.me" method="post" id="login-form">
			<!-- table>(tr>th+td)*3 -->
			<table>
				<tr>
					<th>아이디 :</th>
					<td><input type="text" name="userId" required></td>
				</tr>
				<tr>
					<th>비밀번호 :</th>
					<td><input type="password" name="userPwd" required></td>
				</tr>
				<tr>
					<th colspan="2">
						<button type="submit">로그인</button>
						<button type="button" onclick="enrollPage();">회원가입</button>
					</th>
				</tr>
			</table>
		</form>
		<script>
			function enrollPage(){
				// location.href="<%=contextPath%>/views/member/memberEnrollForm.jsp";
				// 웹 애플리케이션의 디렉토리 구조가 url에 노출되면 보안에 취약하다.
				// 단순한 정적 페이지 이동이여도 해당 페이지로 바로 이동하지 않고
				// servlet을 거쳐서 서블릿 매핑값으로 보여지게 할 것
				
				location.href="<%=contextPath%>/enrollForm.me";
			}
		</script>
		<%}else{ %>
		<div id="user-info">
			<!-- 로그인 성공 후 보여질 폼 -->
			<b><%=loginUser.getUserName() %>님 환영합니다.</b><br> <br>
			<div align="center">
				<a href="<%=contextPath%>/orderGetList.my">주문내역</a>
				<a href="<%=contextPath%>/mypage.me">마이페이지</a>
				<a href="<%=contextPath%>/logout.me">로그아웃</a>
			</div>
		</div>
		<%} %>
	</div>


	<br clear="both">
	<!--float 속성해제 -->

</body>
</html>