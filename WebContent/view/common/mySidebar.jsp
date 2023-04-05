<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.e2.user.model.vo.Member"%>
<% 
	//세션에서 받을 유저 정보
	/* Member loginUser = (Member)session.getAttribute("loginUser"); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 스타일 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/mySidebar.css">

</head>
<body>
	
     <div class="lnb-area addchat">
		<nav id="lnb">
			<p class="tit"><a href="/myPage" title="마이페이지" style="background-color:#82ae46">마이페이지</a></p>
			<ul>
				<!-- <li><a href="">회원정보 변경</a></li> -->
				<li><a href="<%=request.getContextPath()%>/orderGetList.my" title="주문내역">주문 내역</a></li>
				<li><a href="<%=request.getContextPath()%>/cartGetList.my" name="장바구니">장바구니</a></li>
				<li><a href="<%=request.getContextPath() %>/view/mypage/MY_0020.jsp" name="장바구니">내 정보 수정</a></li>
			</ul>

			<!-- 고객센터 메뉴일때만 출력 -->
			<div class="left-customer-info">
				<p class="tit">
					EPOWER2
					<span align="">2조 </span>
				</p>
				<p class="time"><i class="iconset ico-clock"></i> 09:30~16:20</p>
			</div>
		</nav>
	</div>
	<script>
	</script>
</body>
</html>