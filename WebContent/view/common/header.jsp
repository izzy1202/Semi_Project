<%@page import="com.e2.user.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
	String contextPath = request.getContextPath();
	Member loginUser = (Member)session.getAttribute("loginUser");
	String loginDone = (String)session.getAttribute("loginDone");
	String alertMsg = (String)session.getAttribute("alertMsg");
%>  
<%@ page errorPage="view/common/errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- [공통] 헤더: 이지은 -->
<title>지은이</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body class="goto-here" style="font-family: NanumBarunGothicYetHangul">
<script>
		
		var msg = "<%=alertMsg%>";
			
		
		if(msg != "null"){
			alert(msg);
			<%session.removeAttribute("alertMsg");%>
		}
	
	</script>
	<nav
		class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
		id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="<%=contextPath%>/index.jsp" style="font-family: HSGyeoulNoonkott20">지은이</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#ftco-nav" aria-controls="ftco-nav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>
			
		
			<%if(loginUser==null) {%>
			<div class="customer_service_box">
				<ul class="customer_service_list">
					<li class="customer_service_item">
						<a href="<%=request.getContextPath() %>/MemberEnrollForm.do" class="util_link" >회원가입</a>
					</li>
					<li class="customer_service_item">
						<a class="util_link" href="<%=request.getContextPath() %>/view/user/US_0020.jsp" data-role="login">로그인</a>
					</li>
				</ul>
				</div>		
				<%}else {%>
				<div class="customer_service_box">
					<ul class="customer_service_list">
						<li class="customer_service_item">
						<a class="util_link" ><%=loginUser.getUserName() %>님</a></li>
						<li class="customer_service_item">
						<a class="util_link" href="<%=contextPath %>/logout.member" data-role="logout">로그아웃</a></li>
					</ul>		
				</div>
				<%} %>
			
			<script>
		
				var msg = "<%=loginDone %>";
		
				
				if(msg != "null"){
				alert(msg);
				
				<%session.removeAttribute("loginDone"); %>
				}
	
	
			</script>
			

			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item dropdown"  onclick="location.href='<%=request.getContextPath() %>/ProductGetList.pd?curPage=1&category=0>'" style="cursor:pointer">
						<a class="nav-link dropdown-toggle" onclick="location.href='<%=request.getContextPath() %>/ProductGetList.pd?curPage=1&category=0>'" id="dropdown04"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">분야보기</a>
						<div class="dropdown-menu" aria-labelledby="dropdown04">
							<a class="dropdown-item" href="<%=request.getContextPath() %>/ProductGetList.pd?curPage=1&category=1000">철학</a>
							<a class="dropdown-item" href="<%=request.getContextPath() %>/ProductGetList.pd?curPage=1&category=2000">종교</a>
							<a class="dropdown-item" href="<%=request.getContextPath() %>/ProductGetList.pd?curPage=1&category=3000">과학</a>
							<a class="dropdown-item" href="<%=request.getContextPath() %>/ProductGetList.pd?curPage=1&category=4000">예술</a>
							<a class="dropdown-item" href="<%=request.getContextPath() %>/ProductGetList.pd?curPage=1&category=5000">언어</a>
							<a class="dropdown-item" href="<%=request.getContextPath() %>/ProductGetList.pd?curPage=1&category=6000">문학</a>
							<a class="dropdown-item" href="<%=request.getContextPath() %>/ProductGetList.pd?curPage=1&category=7000">역사</a>
						</div></li>
					<li class="nav-item"><a href="<%=request.getContextPath() %>/ProductGetList.pd" class="nav-link">전체도서</a></li>
					<li class="nav-item"><a href="<%=request.getContextPath()%>/NoticeGetController.bd?bcate=1&currentPage=1" class="nav-link">공지사항</a></li>
					<li class="nav-item dropdown" onclick="location.href='<%=request.getContextPath()%>/FaqGet.bd?bcate=6'" style="cursor:pointer">
						<a class="nav-link dropdown-toggle"  onclick="location.href='<%=request.getContextPath()%>/FaqGet.bd?bcate=6'" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">고객센터</a>
							<div class="dropdown-menu" aria-labelledby="dropdown04">
								<a class="dropdown-item" href="<%=request.getContextPath()%>/FaqGet.bd?bcate=6">자주하는 질문(FAQ)</a> <a
									class="dropdown-item" href="<%=request.getContextPath() %>/InquiryGet.bd?currentPage=1">1:1 문의</a>
							</div>
					</li>
					<li class="nav-item cta cta-colored">
						<a href="<%=contextPath%>/cartGetList.my" class="nav-link">
							<img src="<%=contextPath%>/resources/images/cart.png" width="30px" height="30px">
						</a>
					</li>
					<li class="nav-item cta cta-colored">
						<a href="<%=contextPath%>/MypageForm.my" class="nav-link">
							<img src="<%=contextPath%>/resources/images/user.png" width="35px" height="35px">
						</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>