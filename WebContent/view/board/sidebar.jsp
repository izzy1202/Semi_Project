<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.e2.user.model.vo.Member"%>
<% 
	//세션에서 받을 유저 정보 1을 넣으면 admin 그다음 유저
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 스타일 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/sidebar.css">

</head>
<body>
	
     <div class="lnb-area addchat">
		<nav id="lnb">
			<p class="tit"><a href="<%=request.getContextPath()%>/FaqGet.bd?bcate=6" title="고객센터" style="background-color:#82ae46">고객센터</a></p>
			<!-- 사이드바 안에 들어갈 내용(로그인 부분이랑 생각이 많아서 나중에 바뀔것 같습니다.) -->
			<ul>
				<li><a href="<%=request.getContextPath()%>/FaqGet.bd?bcate=6" title="자주 묻는 질문">자주 묻는 질문</a></li>
				<li><a href="<%=request.getContextPath() %>/NoticeGetController.bd?bcate=1&currentPage=1" name="공지사항">공지사항</a></li>
				<li><a href="<%=request.getContextPath() %>/InquiryGet.bd?currentPage=1">1:1문의접수</a></li>
                
                <!-- 관리자일때는 1:1문의 대신 1:1문의관리 페이지로 이동 -->
                <%if(loginUser != null && loginUser.getUserNo() != 1) {%>
                <li><a href="<%=request.getContextPath() %>/InquiryUserList.bd?currentPage=1&userNo=<%=loginUser.getUserNo()%>">
                		1:1문의내역</a></li>
	            <%}else if(loginUser != null && loginUser.getUserNo() == 1){ %>
                <li><a href="<%=request.getContextPath() %>/InquiryAdminGet?currentPage=1">1:1관리페이지(관리자)</a></li>
                <%} %>
			</ul>
			<!-- 여기까지 -->
			
			<div class="left-customer-info">
				<p class="tit">
					EPOWER2
					<span align="">2조 </span>
				</p>
				<p class="time"><i class="iconset ico-clock"></i> 09:30~16:20</p>
			</div>
		</nav>
	</div>
	
</body>
</html>