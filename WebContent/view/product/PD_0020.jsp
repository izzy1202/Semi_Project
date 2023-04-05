<%@page import="com.e2.product.model.vo.ProductComment"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="oracle.net.aso.b"%>
<%@page import="com.e2.product.model.vo.PageInfo"%>
<%@page import="com.e2.product.model.vo.Category"%>
<%@page import="com.e2.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 상품 꺼내기
	Product product = (Product)request.getAttribute("product");
	
	// 코맨트 리스트 꺼내기
	ArrayList<ProductComment> cmList = (ArrayList<ProductComment>)request.getAttribute("cmList");
	
	// 코맨트 리스트 갯수 꺼내기
	int cmCount = ((int)(request.getAttribute("cmCount")));
	
	// 상품 가격 ',' 표시하기
	DecimalFormat pdDecimalFormat = new DecimalFormat("###,###,###,###");
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


<!-- [상품] 상품 상세 페이지 : 유원호 -->
<title>[상품] 상품 상세 페이지: 유원호</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>
	<style>
		.img-detail{
			width : 450px !important;
			height : 600px !important;
		}
		 	
		.pd_wrap{
			padding-bottom: 0px !important;
		}
  	</style>
  
	<script>
	$(document).ready(function(){
		var pdPno = $("#pdPno").val();
	
		var quantitiy= 0;

		// 상품 갯수 증가 버튼
		$('.quantity-right-plus').click(function(e){
			
	        // Stop acting like a button
	        e.preventDefault();
	        // Get the field name
	        var quantity = parseInt($('#quantity').val());
	        
	        if (quantity>0 && quantity<100){
            $('#quantity').val(quantity + 1);
	        }
		    });

		// 상품 갯수 감소 버튼
		$('.quantity-left-minus').click(function(e){
			// Stop acting like a button
		    e.preventDefault();
		    // Get the field name
	        var quantity = parseInt($('#quantity').val());
	        
	        if(quantity>1){
	        $('#quantity').val(quantity - 1);
	        }
		});
		     
		// 코맨트 등록 버튼
		$("#commentBtn").click(function(){
			var name = $('#comment_name').val();
	    	var pwd = $('#comment_pwd').val();
	    	var content = document.querySelector("#comment_message").value;
	    	
	    	
	    	var str = document.getElementById("comment_message").value;
			str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
			document.getElementById("comment_message").value = str;
	    	
	    	console.log("str : "+str);
	    	
	    	$("#comment_message").attr('value', content);
	    	
    	    if (name == "") {
    	    	alert("Name를 입력해주세요.");
    	    	$('#comment_name').focus();
    	      	return false;
    	    }
    	    
    	    if (pwd == "") {
    	    	alert("Password를 입력해주세요.");
    	    	$('#comment_pwd').focus();
    	      	return false;
    	    }   
    	    
    	    if (content == "") {
    	    	alert("Content를 입력해주세요.");
    	    	$('#comment_content').focus();
    	      	return false;
    	    }   
	    	 
    	    $("#commentFrm").submit();
		});
		
		// 코맨트 삭제버튼 클릭시
		$('#comment_list_wrap').on('click','.delete',function() {
			
			$(".deleteChk").hide(); // 전체 비밀번호 확인 input 숨기기
     		$(this).closest('.pwd_wrap').find(".deleteChk").show(); // 클릭한 코맨트 비밀번호 확인 input 보여주기 
     		
     		console.log(this);
     		
     		// 코맨트 삭제 확인 버튼 클릭시
	    	$(".deleteSubmit").on('click',function() {
	    		
		    	var pwdChk = $(this).closest("div").find(".pwdChk").val(); // 입력한 비밀번호 값
		    	var pComment_cmPwd = $(this).closest(".pwd_wrap").find(".pComment_cmPwd").val(); // 해당 코맨트의 비밀번호
	    	 	var pComment_cmNo = $(this).closest(".pwd_wrap").find(".pComment_cmNo").val(); // 해당 코맨트의 번호
				
	    	 	console.log("deleteSubmit 클릭했을때")
	    	 
	    		// 코맨트 삭제
		    	if (pwdChk == pComment_cmPwd) { // 입력한 비밀번호와 해당 비밀번호가 일치할 경우
		    		alert("비밀번호가 일치합니다.");
		    		console.log("deleteSubmit if문 : 성공");

		    		// 코맨트 삭제 후 리스트 조회(ajax)
		    		$.ajax({
			    		  type: 'POST',
			    		  url: "ProductCmDelte.pd",
			    		  data: { cmNo : pComment_cmNo,
			    			  	  pdPno : pdPno},
			    		  success: function (result) {
			    			  console.log("delete_ajax : 성공");
			    			  $("#comment_list_wrap").html(result);
			    		  },
			    		  error : function(){
			    			  console.log("delete_ajax : 실패");
			    		  }
			    		  
			    	});
		    		
   			    } else { // 입력한 비밀번호와 해당 비밀번호가 일치하지 않을 경우
   			    	alert("비밀번호가 일치하지 않습니다.");
   			    	console.log("deleteSubmit if문 : 실패");
   			    	
   			    	$(".deleteSubmit").off('click'); // 실패시 on 클릭 이벤트 제거
	    	 	}
	    	});
	    });
	
	// 코맨트 리스트 조회(ajax)
	commentList(pdPno);
		    
	});
  		
  	// 코맨트 조회
  	function commentList(pdPno) {
  		$.ajax({
  			type: 'POST',
   		  	url: "ProductCmGet.pd",
   		  	data: { pdPno : pdPno},
   		  	success: function (result) {
   		  		$("#comment_list_wrap").html(result);
   		  	},
   		  	error : function(){
   		  		console.log("commentList 통신실패");	
     		}
   		});
	}
	</script>
  
<body class="goto-here">
  
<!-- 헤더 -->
<%@ include file="/view/common/header.jsp" %>
	
<!-- contextPath -->
<input type="hidden" id="contextPath_val" value="<%=contextPath%>">
	
<!-- START 상단 광고 구간 -->
<div class="hero-wrap hero-bread" style="background-image: url('resources/images/book_1.jpg');">
	<div class="container">
		<div class="row no-gutters slider-text align-items-center justify-content-center">
			<div class="col-md-9 ftco-animate text-center">
				<p class="breadcrumbs">
					<span class="mr-2"></span> 
					<span class="mr-2"><a href="<%=contextPath%>/ProductGetList.pd">Product</a></span>
				</p>
				<h1 class="mb-0 bread">도서 안내</h1>
			</div>
		</div>
	</div>
</div>
<!-- END 상단 광고 구간 -->
	
<!-- START 상품 상세 구간 -->
<section class="ftco-section pd_wrap">
	<div class="container">
		<div class="row">
			<!-- START 상품 이미지 -->
			<div class="col-lg-6 mb-5 ftco-animate">
				<img src="<%=product.getTitleImg()%>" class="img-fluid img-detail" alt="Colorlib Template" style="border: 3px solid right; padding: 10px;" >
			</div>
			<!-- END 상품 이미지 -->
			<!-- START 상품 내용 -->
			<div class="col-lg-6 product-details pl-md-5 ftco-animate">
			<form action="<%=contextPath %>/orderInsertForm.my" id="goOrderForm" method="post">
				<input type="hidden" name="productNo" id="productNo" value="<%=product.getPdPno()%>"/>
				<input type="hidden" name="productName" id="productName" value="<%=product.getPdName()%>"/>
				<!-- 상품 제목 -->
				<h1 class="text-left mr-4">
					<%= product.getPdName() %> <span style="color: #bbb;">&nbsp;제목</span>
				</h1>
				<div class="rating d-flex">
					<!-- 카테고리 제목 -->
					<p class="text-left mr-4">
						<%=product.getPdCname()%> <span style="color: #bbb;">&nbsp;카테고리</span>
					</p>
					<!-- 조회수 -->
					<p class="text-left mr-4">
						<%= product.getPdCount() %>&nbsp;<span style="color: #bbb;">Rating</span>
					</p>
				</div>
				<input type="hidden" name="productPrice" id="productPrice" value="<%=product.getPdPrice()%>"/>
				<% if( product.getPdDiscount() != 0) { //할인율이 0이 아닐 경우 %> 
					<p class="price">
						<span class="mr-2 price-dc" style="color: gray; text-decoration:line-through;"><%= pdDecimalFormat.format(Integer.parseInt(product.getPdPrice()))+"원"%></span>
						(<span style="font-size: 15px;"><%=product.getPdDiscount()%>%</span>)
							<%
								int PdPrice = Integer.parseInt(product.getPdPrice()); //상품 가격
		    					int oDis = product.getPdDiscount(); //상품 할인율
		    					double dDis = oDis*0.01;
							%>
						<span class="price-sale" style="color: #82ae46;">&nbsp;<%=pdDecimalFormat.format(Math.round(PdPrice-(PdPrice*dDis)))+"원"%></span>
						<input type="hidden" name="orderPrice" id="orderPrice" value="<%=Math.round(PdPrice-(PdPrice*dDis))%>"/>
					</p>
				<% }  else { // 할인율이 0일 경우 %>
					<p class="price" >
						<span class="price-sale"><%=pdDecimalFormat.format(Integer.parseInt(product.getPdPrice()))+"원"%></span>
						<input type="hidden" name="orderPrice" id="orderPrice" value="<%=product.getPdPrice()%>"/>
					</p>
				<% } %>
				<!-- 상품 상세 설명 -->
				<p><%=product.getPdDesc()%></p>
				<div class="row mt-4">
					<div class="col-md-6">
						<div class="form-group d-flex"></div>
					</div>
					<div class="w-100"></div>
					<div class="input-group col-md-6 d-flex mb-3">
						<!-- 상품 갯수 (-) 버튼 -->
						<span class="input-group-btn mr-2">
							<button type="button" class="quantity-left-minus btn"  data-type="minus" data-field="">
								<i class="ion-ios-remove"></i>
							</button>
						</span>
						<!-- 상품 갯수  -->
						<input type="text" id="quantity" name="quantity" class="form-control input-number input_number_cart" value="1" readonly="readonly">
						<!-- 상품 갯수 (+) 버튼 -->
						<span class="input-group-btn ml-2">
							<button type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
								<i class="ion-ios-add"></i>
							</button>
						</span>
					</div>
					<div class="w-100"></div>
				</div>
				<!-- 장바구니 담기 -->
				<p>
				<input type="submit" class="btn btn-black py-3 px-5" value="주문하기">
					&nbsp;&nbsp;&nbsp;
				<input type="submit" class="btn" value="💗" formaction="<%=contextPath %>/CartInsert.pd">
				</p>
				</form>
			</div>
			<!-- END 상품 내용 -->
		</div>
	</div>
</section>
<!-- END 상품 상세 구간 -->
		
<!-- START Comment -->
<div class="col-lg-8 ftco-animate fadeInUp ftco-animated" style="margin-left: 15%;">
	<div class="pt-5 mt-5">
		<!-- START Comment_list -->
		<div id="comment_list_wrap">	
			<!-- Comment_ajax 뿌려주는곳 -->
		</div>
		<!-- END Comment_list -->
		
	 	<!-- START Comment_작성 -->
		<div class="comment-form-wrap pt-5">
			<h3 class="mb-5">리뷰 작성</h3>
			<form action="<%=contextPath%>/ProductCommentInsert.pd" id="commentFrm" class="p-5 bg-light" method="post">
				<input type="hidden" name="pdPno" id="pdPno" value="<%=product.getPdPno()%>"/>
				<div class="form-group">
					<label for="name">Name <span style="color: red; font-weight: bold;">*</span></label>
					<input type="text" class="form-control" id="comment_name" name="comment_name" 
					<% if ( loginUser != null ) { %>
					value="<%=loginUser.getUserId()%>"
					<% } %>
					>
				</div>
				<div class="form-group">
					<label for="email">Password <span style="color: red; font-weight: bold;">*</span></label>
					<input type="email" class="form-control" id="comment_pwd" name="comment_pwd">
				</div>
				<div class="form-group">
					<label for="message">Content <span style="color: red; font-weight: bold;">*</span></label>
					<textarea name="comment_message" id="comment_message" cols="30" rows="10" class="form-control" wrap="hard"></textarea>
				</div>
				<div class="form-group">
					<input type="button"  id="commentBtn" value="Post Comment" class="btn py-3 px-4 btn-primary">
				</div>
			</form>
		</div>
		<!-- END Comment_작성 -->
	</div>
</div>
<!-- END Comment -->
	
<!-- 푸터 -->
<%@ include file="/view/common/footer.jsp" %>  

</body>
</html>