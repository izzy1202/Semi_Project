<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.e2.product.model.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<Product> topList = (ArrayList<Product>)request.getAttribute("topList");
	DecimalFormat pdDecimalFormat = new DecimalFormat ( "###,###,###,###");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- [메인] 메인: 이지은 -->
<title>지은이</title>

<link href="https://hangeul.pstatic.net/hangeul_static/css/NanumBarunGothicYetHangul.css" rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
</head>

<body class="goto-here" style="font-family: NanumBarunGothicYetHangul">
<%@ include file="/view/common/header.jsp" %>
	

	<!-- 롤링 배너 시작 -->
	<section id="home-section" class="hero">
		<div class="home-slider owl-carousel">

				<div class="slider-item"
					style="background-image: url(resources/images/banner_003.png);">
					<a href="<%=request.getContextPath() %>/ProductGet.pd?pdPno=8"><div class="overlay"></div></a>
					<div class="container">
						<div
							class="row slider-text justify-content-center align-items-center"
							data-scrollax-parent="true">

							<div class="col-md-12 ftco-animate text-center">
								<h1 class="mb-2"></h1>
								<h2 class="subheading mb-4"></h2>
							</div>
						</div>
					</div>
				</div>
			
				<div class="slider-item"
					style="background-image: url(resources/images/banner_002.png);">
					 <a href="<%=request.getContextPath() %>/ProductGet.pd?pdPno=2"><div class="overlay"></div></a>
					<div class="container">
						<div
							class="row slider-text justify-content-center align-items-center"
							data-scrollax-parent="true">
							<div class="col-sm-12 ftco-animate text-center">
								<h1 class="mb-2"></h1>
								<h2 class="subheading mb-4"></h2>
							</div>
						</div>
					</div>
				</div>
			
				<div class="slider-item"
					style="background-image: url(resources/images/banner_001.png);">
					 <a href="<%=request.getContextPath() %>/ProductGet.pd?pdPno=35"><div class="overlay"></div></a>
					<div class="container">
						<div
							class="row slider-text justify-content-center align-items-center"
							data-scrollax-parent="true">
							<div class="col-sm-12 ftco-animate text-center">
								<h1 class="mb-2"></h1>
								<h2 class="subheading mb-4"></h2>
							</div>
						</div>
					</div>
				</div>
		</div>
	</section>
	<!-- 롤링 배너 끝 -->

	<!-- 베스트셀러 시작 -->
	<section class="ftco-section"
		style="font-family: NanumBarunGothicYetHangul">
		<div class="container">
			<div class="row justify-content-center mb-3 pb-3">
				<div class="col-md-12 heading-section text-center ftco-animate">
					<h2 class="mb-4">베스트셀러</h2>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row ftco-animate">
				<div class="col-md-12" id="mainTop">
					<div class="owl-carousel" style="display: inline-block !important; padding: 0 auto !important;">
					<!-- ajax 베스트셀러 부분  -->
				</div>
			</div>
		</div>
		</div>
	</section>
	<!-- 베스트셀러 끝 -->
	
	<!-- 한줄평 시작 -->
	<section class="ftco-section testimony-section">
		<div class="container">
			<div class="row justify-content-center mb-5 pb-3">
				<div class="col-md-7 heading-section ftco-animate text-center">
					<h2 class="mb-4">한줄평</h2>
				</div>
			</div>
			<div class="row ftco-animate">
				<div class="col-md-12">
					<div class="carousel-testimony owl-carousel">
						<div class="item">
							<div class="testimony-wrap p-4 pb-5">
								<div class="user-img mb-5"
									style="background-image: url(resources/images/hy_Img.gif)">
									<span
										class="quote d-flex align-items-center justify-content-center">
										<i class="icon-quote-left"></i>
									</span>
								</div>
								<div class="text text-center">
									<p class="mb-5 pl-4 line">다들 정말 힘들었을텐데 열심히 해주셔서<br>이렇게 멋진 사이트가 만들어졌네요!!<br>
									저희 조원들 다들 너무 잘하고 열심히 하는<br>멋진 친구들입니다😎<br>덕분에 저도 많이 배워가요!<br>고생많으셨습니다🤗</p>
									<p class="name">박혜영</p>
									<span class="position">상품 / 마이페이지</span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimony-wrap p-4 pb-5">
								<div class="user-img mb-5"
									style="background-image: url(resources/images/강아지.jpg)">
									<span
										class="quote d-flex align-items-center justify-content-center">
										<i class="icon-quote-left"></i>
									</span>
								</div>
								<div class="text text-center">
									<p class="mb-5 pl-4 line">처음에 조장님이 틀을 잘 잡아준 덕분에 프로젝트 진행에
										무리없이 잘 진행된거 같아서 좋았고 저희 조원들 모두 노력해서 열심히 <br>참여해주셔서 재밌게 프로젝트를 <br>할 수
										있었던거 같습니다. <br>다들 그동안 고생하셨고 이번 기회에 <br>많은 것을 배우고 가셨으면 좋겠습니다 ^^</p>
									<p class="name">우도균</p>
									<span class="position">게시판</span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimony-wrap p-4 pb-5">
								<div class="user-img mb-5"
									style="background-image: url(resources/images/댕댕이.jpg)">
									<span
										class="quote d-flex align-items-center justify-content-center">
										<i class="icon-quote-left"></i>
									</span>
								</div>
								<div class="text text-center">
									<p class="mb-5 pl-4 line">프로젝트 초반에 정말 막막했는데 조장님께서 가이드를 잘
										잡아주셔서 조원들 전부 큰 문제 없이 다들 마무리 한 것 같습니다. 조원분들 모두 각자 맡은 파트를 책임감 있게
										끝까지 완성시키려고 노력하시는 모습 보고 저도 더욱 더 열심히 프로젝트를 마무리 했던 것 같습니다. 다들 짧은
										기간 안에 프로젝트 완성 시키려고 정말 많은 노력 하셨고 다들 고생많으셨습니다.</p>
									<p class="name">유원호</p>
									<span class="position">상품</span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimony-wrap p-4 pb-5">
								<div class="user-img mb-5"
									style="background-image: url(resources/images/하치와레2.gif)">
									<span
										class="quote d-flex align-items-center justify-content-center">
										<i class="icon-quote-left"></i>
									</span>
								</div>
								<div class="text text-center">
									<p class="mb-5 pl-4 line">부족한 점이 매우 많지만 팀원분들이 도와주신 덕분에 조금씩
										과제를 수행할 수 있었습니다. 조모임을 주도하고 팀원들을 이끌어주신 <br>혜영님께 항상 감사드리고, 앞으로 사장인
										<br>이지은님과 함께 지은이 서점을 잘꾸려나가 <br>번창시키도록 하겠습니다</p>
									<p class="name">추지은</p>
									<span class="position">게시판</span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimony-wrap p-4 pb-5">
								<div class="user-img mb-5"
									style="background-image: url(resources/images/울프독.jpg)">
									<span
										class="quote d-flex align-items-center justify-content-center">
										<i class="icon-quote-left"></i>
									</span>
								</div>
								<div class="text text-center">
									<p class="mb-5 pl-4 line">프로젝트가 확실히 수업 시간에 하는 것과는 <br> 확실히 다르다는 것을 느꼈습니다. 
									<br>또한 내 자신이 무언가 담당하는 부분이 생기고 그것에 대하여 해야 한다는 것이 <br>부담도 되었지만
									한편으로 그런 부분에 있어서 책임감을 가지고 만들어본다는 것이 좋은 경험이 되는 자양분이 되었습니다.</p>
									<p class="name">김용건</p>
									<span class="position">회원</span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimony-wrap p-4 pb-5">
								<div class="user-img mb-5"
									style="background-image: url(resources/images/농담곰.gif)">
									<span
										class="quote d-flex align-items-center justify-content-center">
										<i class="icon-quote-left"></i>
									</span>
								</div>
								<div class="text text-center">
									<p class="mb-5 pl-4 line">팀프로젝트를 처음 해봐서 막막했는데 <br>조장님이 이끌어주셔서 <br>잘
										마무리 할 수 있었습니다. <br>이번 세미 프로젝트에서의 경험을 바탕으로<br> 파이널 프로젝트도 잘 해나갈 수<br> 있을 거라고
										생각합니다. <br>다들 고생 많으셨습니다!</p>
									<p class="name">이지은</p>
									<span class="position">메인 / 회원</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- 한줄평 끝 -->
	
	<!-- 푸터(footer) 시작-->
	<hr>

	<footer class="ftco-footer ftco-section">
		<div class="container">
			<div class="row">
				<div class="mouse">
					<a href="#" class="mouse-icon">
						<div class="mouse-wheel">
							<span class="ion-ios-arrow-up"></span>
						</div>
					</a>
				</div>
			</div>
			<div class="row mb-5">
				<div class="col-md">
					<div class="ftco-footer-widget mb-4 ml-md-5">
						<a data-toggle="modal" href="#myModal"><h2 class="ftco-heading-2">개인정보취급방침</h2></a>
						<div class="modal" id="myModal">
							<div class="modal-dialog modal-dialog-scrollable">
								<div class="modal-content">
									<div class="modal-header">
										<h1 class="modal-title">개인정보취급방침</h1>
										<button type="button" class="close" data-dismiss="modal">×</button>
									</div>
									<div class="modal-body">
										<p>제1조 [목 적] 본 약관은 지은이(이하 “회사”라 합니다)가 운영하는
											웹사이트(www.epower2.com), 앱마켓 앱, 기타 향후 개발되는 콘텐츠 등 정보 접근의 도구로
											사용되는 여하한 모든 형태(이하 “플랫폼”이라 합니다)를 통하여 제공하는 상품 및 디지털콘텐츠 서비스(이하
											“서비스”라 합니다)의 이용과 관련하여 이용자의 권리, 의무 및 책임사항 등을 규정함을 목적으로 합니다.</p>
										<p>회사는 다음과 같은 업무를 수행합니다. 재화 또는 용역에 대한 정보 제공 및 구매계약의 체결
											구매계약이 체결된 재화 또는 용역의 제공 및 배송 광고 또는 이벤트 등 재화 또는 용역과 관련된 판촉 행위
											기타 이용자에게 유용한 정보 제공 회사는 재화의 품절 또는 기술적 사양의 변경 등의 불가피한 경우에는 장차
											체결되는 계약에 의해 제공할 재화와 용역의 내용을 변경할 수 있습니다. 이 경우에는 변경된 재화 등의 내용 및
											제공 일자를 명시하여 현재의 재화 등의 내용을 게시한 곳에 그 제공 일자 이전 7일부터 공지합니다. 단,
											회사가 합리적으로 예측할 수 없는 불가피한 여건이나 사정이 있는 경우, 위 공지를 하지 않을 수 있습니다.
											회사가 제공하기로 이용자와 계약을 체결한 서비스의 내용을 재화 등의 품절 또는 기술적 사양의 변경 등의 사유로
											변경할 경우에는 회사는 이로 인하여 이용자가 입은 손해를 배상합니다. 단, 회사에 고의 또는 과실이 없는
											경우에는 그 책임을 지지 않습니다. 회사는 무료로 제공되는 서비스의 일부 또는 전부를 회사의 정책 및 운영의
											필요 상 수정, 중단, 변경할 수 있으며, 이에 대하여 회원에게 별도의 보상을 하지 않습니다.</p>
									</div>
								</div>
							</div>
						</div>
						<ul class="list-unstyled">
						</ul>
					</div>
				</div>

				<div class="col-md">
					<div class="ftco-footer-widget mb-4 ml-md-5">
						<a data-toggle="modal" href="#myModal2"><h2 class="ftco-heading-2">이용약관</h2></a>
						<div class="modal" id="myModal2">
							<div class="modal-dialog modal-dialog-scrollable">
								<div class="modal-content">
									<div class="modal-header">
										<h1 class="modal-title">이용약관</h1>
										<button type="button" class="close" data-dismiss="modal">×</button>
									</div>
									<div class="modal-body">
										<p>제 1 조 [목적] 이 약관은 지은이가 제공하는 서비스인
											http://www.epower2.com의 이용조건 및 절차에 관한 사항과 기타 필요한 사항을 규정함을 목적으로
											합니다. </p>
											<p>제 2 조 약관의 효력과 변경 1) 약관은 이용자에게 공시함으로써 효력을 발생합니다. 2)
											지은이는 교육원 사정상 변경의 경우와 영업상 중요사유가 있을 때 약관을 변경할 수 있으며, 변경된
											약관은 전항과 같은 방법으로 효력을 발생합니다. 제 3 조 약관 외 준칙 이 약관에 명시되지 않은 사항이
											관계법령에 규정되어 있을 경우에는 그 규정에 따릅니다. 제 2 장 회원 가입과 서비스 이용 제 1 조 이용
											계약의 성립 1)지은이에서 운영하는 모든 회원서비스는 이 약관에 동의한 이용자들에게 무료로 제공 되는
											서비스입니다. 이용자가 "동의합니다" 버튼을 누르면 이 약관에 동의하는 것으로 간주됩니다. 2) 회원에
											가입하여 서비스를 이용하고자 하는 희망자는 회사에서 요청하는 개인 신상정보를 제공해야 합니다. 3) 등록정보
											지은이는 이용자 등록정보를 집단적인 형태로 사용할 수는 있지만 각 이용자 개인 정보는, 불법적이거나 기타 다른
											불온한 문제를 일으킬 경우를 제외하고, 이용자의 동의 없이는 절대 공개하지 않습니다. 지은이을 이용하여
											타인에게 피해를 주거나 미풍양속을 해치는 행위를(즉 욕설, 비방성글, 인신공격성 발언, 사회적질서를 혼란시키는
											유언비어등)한 이용자는 회원자격이 박탈되며, 이로 인해 발생되는 모든 사회적문제는 지은이에서 책임지지
											않습니다. 4) 약관의 수정 지은이는 이 약관을 변경할 수 있으며 변경된 약관은 서비스 화면에 게재하거나 기타
											다른 방법으로 이용자에게 공지함으로써 효력을 발생합니다. [부 칙] ( 시 행 일 ) 이 약관은 2022년
											11월 17일부터 시행합니다.</p>
									</div>
								</div>
							</div>
						</div>
						<ul class="list-unstyled">
						</ul>
					</div>
				</div>
				<div class="col-md">
					<div class="ftco-footer-widget mb-4 ml-md-5">
						<a href="<%=request.getContextPath()%>/NoticeGetController.bd?bcate=1&currentPage=1"><h2 class="ftco-heading-2">공지사항</h2></a>
						<ul class="list-unstyled">
						</ul>
					</div>
				</div>
				<div class="col-md">
					<div class="ftco-footer-widget mb-4 ml-md-5">
						<a href="<%=request.getContextPath()%>/FaqGet.bd?bcate=6"><h2 class="ftco-heading-2">고객센터</h2></a>
						<ul class="list-unstyled">
							<li><a href="<%=request.getContextPath()%>/FaqGet.bd?bcate=6" class="py-2 d-block">자주하는 질문(FAQ)</a></li>
							<li><a href="<%=request.getContextPath() %>/InquiryGet.bd?currentPage=1" class="py-2 d-block">1:1 문의</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- 푸터(footer) 끝 -->

	<script>
	//베스트셀러 클릭시 해당 페이지로 이동
	$(function(){
	 $(document).on("click","#mainTop .user-img",function(){
		location.href="<%=contextPath%>/ProductGet.pd?pdPno="+$(this).parents(".topItem").prev().val();
		})  
	});
	

	window.onload = function(){
	//베스트셀러 띄우기	
		$.ajax({
			url : "ProductGetList.main",
			success : function(topList){
				var str = "";
				for(var i in topList) {
					
					var PdPrice = topList[i].pdPrice;
					var oDis = topList[i].pdDiscount;
					var dDis = oDis*0.01;
					var pd = PdPrice*dDis;
					
					str += 
						
						"<input type='hidden' class='please' value='"+topList[i].pdPno+"'>"+
						"<div class='item topItem'>"+
							"<div class='product' style='cursor: pointer;'>"+
							"<div class='user-img mb-5 topImg img-prod img-fluid' style='background-image: url("+topList[i].titleImg+")'>"+
						"<span class='topStatus'>"+topList[i].pdDiscount+"%</span>"+
							"<div class='overlay' ></div></div>"+
						"<div class='text py-3 pb-4 px-3 text-center'><h3><p>"+topList[i].pdName+"</p></h3>"+
						"<p class='name' style='color: #82ae46;'>"+(PdPrice-(pd))+"원</p>"+
						"</span></div></div></div>";
						
				 } 
				$("#mainTop").html(str);
			},
			error : function(){
				console.log("통신 실패")
			}
			
		});
	
}
	
	
	</script>

	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>

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
	<!-- 쓰고 싶으면 API키 받는 곳에서 도메인 등록 해야합니다 -->
	<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script> -->
	<script src="resources/js/main.js"></script>

</body>
</html>
