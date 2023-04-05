<%@page import="com.e2.product.model.vo.Product"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DecimalFormat df = new DecimalFormat("###,###,###,###");
	String productNo = request.getParameter("productNo");
	String productName = request.getParameter("productName");
	int productCount = Integer.parseInt(request.getParameter("quantity")); 
	int productPrice = Integer.parseInt(request.getParameter("productPrice"));
	int orderPrice = Integer.parseInt(request.getParameter("orderPrice"));
%>
<!DOCTYPE html>
<html>
<head>
<!-- [상품] 상품 주문하기: 박혜영 -->
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 툴팁 -->
<link rel="stylesheet" href="resources/css/tooltip.css">
</head>
<body class="goto-here">
    <%@ include file="/view/common/header.jsp" %>
    <!-- END nav -->

    <div class="hero-wrap hero-bread" style="background-image: url('resources/images/bg_1.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
          	<p class="breadcrumbs"><span class="mr-2"></span> <span>ORDER</span></p>
            <h1 class="mb-0 bread">주문하기</h1>
          </div>
        </div>
      </div>
    </div>

    <section class="ftco-section">
      <div class="container">
      <form action="<%=contextPath%>/orderInsert.my" class="billing-form" method="post" id="goOrder">
        <div class="row justify-content-center">
          <div class="col-xl-7 ftco-animate">
			<%-- <form action="<%=contextPath%>/orderInsert.my" class="billing-form" method="post" id="goOrder"> --%>
				<h3 class="mb-4 billing-heading">주문서 작성</h3>
	          	<div class="row align-items-end">
	          		<div class="col-md-6">
	            	    <div class="form-group">
	                		<label for="firstname">주문 상품</label>
	                		<input type="hidden" name="productNo" id="productNo" value="<%=productNo %>">
	                  		<input type="text" class="form-control" value="<%=productName%>" readonly>
	                	</div>
	              	</div>
	              	<div class="col-md-6">
	                	<div class="form-group">
	                		<label for="lastname">주문 수량</label>
	                  	<input type="text" class="form-control" id="productCount" name="productCount" value="<%=productCount %>" readonly >
	                	</div>
                	</div>
		            <div class="col-md-6">
		            	<div class="form-group">
		                	<label for="streetaddress">주문자</label>
		                 	<input type="text" id="orderName" name="orderName" class="form-control" value="<%=loginUser.getUserName()%>" readonly>
	                	</div>
		            </div>
		            <div class="col-md-6">
		            	<div class="form-group">
			            	<label for="streetaddress">주문자 전화번호</label>
		                 	<input type="text" id="orderPhone" name="orderPhone" class="form-control" value="<%=loginUser.getPhone()%>" readonly>
	                	</div>
		            </div>
		            <div class="w-100"></div>
		            <div class="col-md-6">
		            	<div class="form-group">
		                	<label for="towncity">수령자</label>&nbsp;&nbsp;&nbsp;
		                	<label><input type="checkbox" id="chkChange" onclick="change();" class="mr-2">주문자 정보와 동일</label>
		                  	<input type="text" id="receverName" name="receverName" class="form-control" placeholder="받으실 분의 성함을 입력해주세요">
		                </div>
		            </div>
		            <div class="col-md-6">
		            	<div class="form-group">
		            		<label for="postcodezip">수령자 전화번호</label>
		                  	<input type="text" id="receverPhone" name="receverPhone" class="form-control" placeholder="받으실 분의 전화번호를 입력해주세요">
		                </div>
		            </div>
		            <div class="w-100"></div>
		            <div class="col-md-6">
	                	<div class="form-group">
		                	<label for="phone">주소</label>
			                <input type="text" name="address" id="address" class="form-control" placeholder="받으실 주소를 입력해주세요" style="width: 210%;">
			            </div>
		            </div>
                	<div class="w-100"></div>
	            </div>
	          <!-- </form>END -->
			</div>
			<div class="col-xl-5">
	          <div class="row mt-5 pt-3">
	          	<div class="col-md-12 d-flex mb-5">
	          		<div class="cart-detail cart-total p-3 p-md-4">
	          			<h3 class="billing-heading mb-4">Cart Total</h3>
	          			<p class="d-flex">
    						<span>상품 가격</span>
    						<span><%=df.format(productPrice*productCount) %> 원</span>
    					</p>
    					<p class="d-flex">
    						<span>배송비
    						<span data-tooltip="5만원 이상 무료 배송" style="display:inline-block; width:10px;">
    							<img src="resources/images/icon/icons8-help-18.png">
    						</span>
    						</span>
    						<%int del=0; %>
    						<%if(orderPrice*productCount < 50000){ %>
    							<%del=2500; %>
    							<span>2500 원</span>
    						<%}else{ %>
    							<%del=0; %>
    							<span>0원</span>
    						<%} %>
    					</p>
    					<p class="d-flex">
    						<span>총 할인된 금액</span>
    						<span><%=df.format(productPrice*productCount-orderPrice*productCount) %> 원</span>
    					</p>
    					<hr>
    					<p class="d-flex total-price">
    						<span>총 결제금액</span>
    						<span><%=df.format(orderPrice*productCount+del) %> 원</span>
    						<input type="hidden" name="totalPrice" id="totalPrice" value="<%=orderPrice*productCount+del %>">
    					</p>
					</div>
	          	</div>
	          	<p><a onclick="document.getElementById('goOrder').submit();" class="btn btn-primary py-3 px-4" style="margin-left: 20rem; color:white;">주문하기</a></p>
 	          </div>
          </div> <!-- .col-md-8 -->
        </div>
        </form>
      </div>
    </section> <!-- .section -->

  <%@ include file="/view/common/footer.jsp" %>

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

<script>
	function change(){
		var checkbox = document.getElementById('chkChange');
		var chkChange = checkbox.checked;
		var address = "<%=loginUser.getAddress()%>";
		if(chkChange == true){
			$('input[name=receverName]').attr('value',$('#orderName').val());
			$('input[name=receverPhone]').attr('value',$('#orderPhone').val());
			$('input[name=address]').attr('value',address);
		} else{
			$('input[name=receverName]').attr('value',"");
			$('input[name=receverPhone]').attr('value',"");
			$('input[name=address]').attr('value',"");
		}
	};
</script>
    
  </body>
</html>