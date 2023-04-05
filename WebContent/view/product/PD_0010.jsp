<%@page import="java.text.DecimalFormat"%>
<%@page import="oracle.net.aso.b"%>
<%@page import="com.e2.product.model.vo.PageInfo"%>
<%@page import="com.e2.product.model.vo.Category"%>
<%@page import="com.e2.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 상품 list 꺼내기
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");

	// 카테고리 list 꺼내기
	ArrayList<Category> cList = (ArrayList<Category>)request.getAttribute("cList");

	// 베스트상품 list 꺼내기
	ArrayList<Product> topList = (ArrayList<Product>)request.getAttribute("topList");
	
	// 페이징 꺼내기
	PageInfo pInfo = (PageInfo)request.getAttribute("pageInfo");
	
	// 
	String category = "0";
	try{		
		category = request.getAttribute("category").toString();
	}catch(Exception e) {
		
	}
	
	// 금액 ','표시 
 	DecimalFormat pdDecimalFormat = new DecimalFormat ( "###,###,###,###");
%>

<!DOCTYPE html>
<html lang="en">
<head>
 
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
   

<!-- STRAT 링크 -->
<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="resources/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="resources/css/animate.css">
<link rel="stylesheet" href="resources/css/owl.carousel.min.css">
<link rel="stylesheet" href="resources/css/owl.theme.default.min.css">
<link rel="stylesheet" href="resources/css/magnific-popup.css">
<link rel="stylesheet" href="resources/css/aos.css">
<link rel="stylesheet" href="resources/css/ionicons.min.css">
<link rel="stylesheet" href="resources/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="resources/css/jquery.timepicker.css">
<link rel="stylesheet" href="resources/css/flaticon.css">
<link rel="stylesheet" href="resources/css/icomoon.css">
<link rel="stylesheet" href="resources/css/style.css">
<!-- END 링크 -->


<!-- [상품] 상품 목록 페이지 : 유원호 -->
<title>[상품] 상품 목록 페이지: 유원호</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
  
<style type="text/css">
	.img-fluid {
		width:200px !important; 
		height:300px !important;
	}

	#content_wrap{
		padding : 0px !important;
	}
	
	.topItem {
		display: inline-block;
		width: 19%;
		padding: 0 !important;
		position: relative;
	}
	
	.topImgWrap{
		width : 150px !important;
		height : 200px !important;
	}
	
	.topImg{
		width : 100% !important;
		height : 100% !important;
	}
	
	.topStatus{
		    position: absolute;
		    top: 0;
		    left: 0;
		    padding: 2px 10px;
		    color: #fff;
		    font-weight: 300;
		    background: #82ae46;
		    font-size: 12px;
	}
	
	.product-category{
		    border-top: 3px solid green;
		    border-bottom: 3px solid green;
		    padding: 5px 0;
	}
</style>
	
	
 <body class="goto-here">

<!-- 헤더 -->
<%@ include file="/view/common/header.jsp" %>

<!-- START 베스트 TOP5 -->
<% if ( topList != null ) { //TOP5가 비어있지 않을 경우 %>		
	<section id="content_wrap" class="ftco-section">
		<div class="container">
	
			<!-- START 베스트 목록  타이틀 -->
			<div class="row justify-content-center mb-5 pb-3" style="margin-bottom: 0px !important;">
				<div class="col-md-7 heading-section ftco-animate text-center">
					<h2 class="mb-4" style="font-size: 20px;"> 
						<span class="subheading" style="display: inline-block;">지은이</span>&nbsp; &nbsp; 베스트 셀러 TOP 5
					</h2>
				</div>
			</div>
			<!-- END 베스트 목록  타이틀 -->

			<!-- START 베스트 상품 목록  -->
			<div class="row ftco-animate">
				<div class="col-md-12">
					<div class=" owl-carousel" style="display: inline-block !important; padding: 0 auto !important;">
						<% for(Product tp : topList) { //TOP5 리스트 반복문 %>
							<div class="item topItem">
								<% if (tp.getPdDiscount() != 0) { //할인율이 있을 경우 %>
									<span class="topStatus"> <%=tp.getPdDiscount() +"%"%> </span> 
								<% } %>
								<div class="testimony-wrap p-4 pb-5 topImgWrap" onclick="location.href='<%=contextPath%>/ProductGet.pd?pdPno=<%= tp.getPdPno() %>'" style="cursor: pointer;">
									<%
										int PdPrice = Integer.parseInt(tp.getPdPrice()); //상품 가격
										int oDis = tp.getPdDiscount(); // 할인율
										double dDis = oDis*0.01;
									%>
									<div class="user-img mb-5 topImg" style="background-image: url(<%=tp.getTitleImg()%>)"></div>
									<div class="text text-center">
										<p class="mb-5 pl-4 line"><%=tp.getPdName()%></p>
										<p class="name" style="color: #82ae46; "><%= pdDecimalFormat.format(Math.round(PdPrice-(PdPrice*dDis)))+"원"%></p>
										<span class="position">
											<% if (tp.getPdDiscount() != 0) { //할인율이 있을 경우 %> 
												<p style="text-decoration:line-through;"><%= pdDecimalFormat.format(Integer.parseInt(tp.getPdPrice())) +"원" %></p> 
											<% } else { %>
												&nbsp;
											<% } %>
										</span>
									</div>
								</div>
							</div>
						<% } %>
					</div>
				</div>
			</div>
			<!-- END 베스트 상품 목록   -->
		</div>
	</section> <br><hr>
<% } %>
<!-- END 베스트 TOP5 -->


<!-- START 상품 목록 -->
<section class="ftco-section" style="padding-top: 20px !important;">
	<div class="container" >
	
		<!-- START 상품 카테고리 목록 -->
		<div class="row justify-content-center" >
			<div class="col-md-10 mb-5 text-center" >
				<ul class="product-category">
					<% if ( !cList.isEmpty() ) { //카테고리가 있을 경우 %>
						<li onclick="location.href='<%=contextPath%>/ProductGetList.pd?curPage=1&category=0'">
							<a href="#" class="<% if (category.equals("0")) { %> active <% } %>" >All</a>
						</li>
						<% for(Category c : cList) { //카테고리 리스트 반복문 %>
							<li class="cgList" onclick="location.href='<%=contextPath%>/ProductGetList.pd?curPage=1&category=<%=c.getcNo()%>'">
								<a href="#" class="<% if (Integer.parseInt(category) == c.getcNo()) { %> active <% } %>"><%=c.getcName()%></a>
							</li>
						<% } %>
					<% } else { %>
						<li>존재하는 카테고리가 없습니다.</li>
					<% } %>
				</ul>
			</div>
		</div>
		<!-- END 상품 카테고리 목록 -->

		<!-- START 상품 목록 -->
		<div class="row">
			<% if( !list.isEmpty() ) { //상품 리스트가 있을 경우 %>
				<% for ( Product p : list ) { //상품 리스트 반복문 %>
					<div class="col-md-6 col-lg-3 ftco-animate">
						<div class="product">
							<!-- START 상품 이미지 구간 -->
							<a class="img-prod" href="<%=contextPath%>/ProductGet.pd?pdPno=<%=p.getPdPno()%>">
								<img class="img-fluid" src="<%=p.getTitleImg()%>" alt="Colorlib Template">
								<% if (p.getPdDiscount() != 0) { // 할인율이 있을 경우 %>
									<span class="status"> <%=p.getPdDiscount()%> % </span>
								<% } %>
								<div class="overlay"></div>
							</a>
							<!-- END 상품 이미지 구간 -->
							<div class="text py-3 pb-4 px-3 text-center">
								<!-- START 상품 제목 구간 -->
								<h3><a href="#"><%=p.getPdName()%></a></h3>
								<!-- END 상품 제목 구간 -->
								
								<!-- START 상품 가격 구간 -->
								<div class="d-flex">
									<div class="pricing">
										<% if( p.getPdDiscount() != 0)	{ //할인율이 있을 경우 %>
											<p class="price">
												<span class="mr-2 price-dc"><%= pdDecimalFormat.format(Integer.parseInt(p.getPdPrice()))%></span>
												<%
													int PdPrice = Integer.parseInt(p.getPdPrice()); //상품 가격
													int oDis = p.getPdDiscount(); // 상품 할인율
													double dDis = oDis*0.01;
												%>
												<span class="price-sale"><%=pdDecimalFormat.format(Math.round((PdPrice-(PdPrice*dDis)))) %><%="원"%></span>
											</p>
										<% } else { //할인율이 없을 경우%>
											<p class="price">
												<span class="price-sale"><%=pdDecimalFormat.format(Integer.parseInt(p.getPdPrice()))%><%="원"%></span>
											</p>
										<% } %>
									</div>
								</div>
								<!-- END 상품 가격 구간-->
								
								<!-- START 상품 이동 구간-->
								<div class="bottom-area d-flex px-3">
									<div class="m-auto d-flex">
										<!-- 메뉴 이동 -->
										<a href="<%=contextPath%>/ProductGetList.pd" class="add-to-cart d-flex justify-content-center align-items-center text-center">
											<span><i class="ion-ios-menu"></i></span>
										</a>
										<!-- 장바구니 담기 -->
										<a href="<%=contextPath%>/insertCart.pd?pdPno=<%=p.getPdPno()%>" class="buy-now d-flex justify-content-center align-items-center mx-1">
											<span><i class="ion-ios-cart"></i></span>
										</a>
									</div>
								</div>
								<!-- END 상품 이동 구간-->
								
							</div>
						</div>
					</div>
				<% } %>
			<% } else { %>
				<a>존재하는 상품이 없습니다.</a>
			<% } %> 
		</div>
		<!-- END 상품 목록 -->
	
		<!-- STRAT 상품 페이징바 -->
		<div class="row mt-5">
			<div class="col text-center">
				<div class="block-27">
					<ul>
					<% if ( pInfo.getStartPage() != 1 ) { //시작페이지가 1이 아닐 경우 %>
						<li>
							<!-- 이전 페이지 '<' 버튼 -->
							<a href="<%=contextPath%>/ProductGetList.pd?curPage=<%= pInfo.getStartPage()-1 %>&category=<%=category%>">&lt;</a>
						</li>
					<% } %>
					<% for ( int i = pInfo.getStartPage(); i<pInfo.getEndPage()+1; i++ ) { %>	
						<li class="<% if(pInfo.getCurrentPage()== i) { %> active <% } %>" style="cursor: pointer;" onclick="location.href='<%=contextPath%>/ProductGetList.pd?curPage=<%=i%>&category=<%=category%>'">
							<span><%= i %></span>
						</li>
					<% } %>
					<% if ( pInfo.getEndPage() != pInfo.getMaxPage() ) { //마지막 페이징바와 총 페이지징 수가 같지 않다면%>
						<li>
							<!-- 다음 페이지 '>' 버튼 -->
							<a href="<%=contextPath%>/ProductGetList.pd?curPage=<%= pInfo.getEndPage()+1 %>&category=<%=category%>">&gt;</a>
						</li>
					<% } %>
					</ul>	
				</div>
			</div>
		</div>
		<!-- END 상품 페이징바 -->
	</div>
</section>
<!-- END 상품 목록 -->

<!-- 푸터 -->
<%@ include file="/view/common/footer.jsp" %>  


<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/jquery-migrate-3.0.1.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/jquery.easing.1.3.js"></script>
<script src="resources/js/jquery.waypoints.min.js"></script>
<script src="resources/js/jquery.stellar.min.js"></script>
<script src="resources/js/owl.carousel.min.js"></script>
<script src="resources/js/jquery.magnific-popup.min.js"></script>
<script src="resources/js/aos.js"></script>
<script src="resources/js/jquery.animateNumber.min.js"></script>
<script src="resources/js/bootstrap-datepicker.js"></script>
<script src="resources/js/scrollax.min.js"></script>
<script src="resources/js/main.js"></script>
  
</body>
</html>