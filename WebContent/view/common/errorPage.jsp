<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String errorMsg = (String) request.getAttribute("errorMsg");
	String contextPath = request.getContextPath();
%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<!-- [공통] 에러페이지: 박혜영 -->
<head>
<link rel="stylesheet" href="resources/css/error.css" type="text/css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	// 메인 이동
	function go_main(){
		location.href="<%=contextPath%>";
	}
</script>
<body>
	<div class="page-error">
		<div class="outer">
			<div class="middle">
				<div class="inner" onclick="go_main();">
					<!--BEGIN CONTENT-->
					<div class="inner-circle">
						<i class="fa fa-home"></i><span>ERROR</span>
					</div>
					<span class="inner-status"><%=errorMsg %></span>
					<span class="inner-detail">
						<!-- We can not find the page you're looking for. --> 
					<a href="<%=contextPath%>" class="btn btn-info mtl" >
						<i class="fa fa-home"></i>&nbsp; Return home </a>
					</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>