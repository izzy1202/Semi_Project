<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.e2.mypage.model.vo.Order"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	ArrayList<Order> orderDetailList = (ArrayList<Order>)request.getAttribute("orderDetailList");
	Order o = (Order)request.getAttribute("o");
	DecimalFormat df = new DecimalFormat("###,###,###,###");
	String ono = request.getParameter("ono");
%>
<%@ include file="/view/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- [상품] 주문내역 상세: 박혜영 -->
<title>주문내역 상세</title>
    <!-- 툴팁 -->
    <link rel="stylesheet" href="resources/css/tooltip.css">
</head>
<%if(loginUser==null){ %>
	
	<%response.sendRedirect("/epower2/view/common/errorPage.jsp");%>
<%}else{ %>
<body class="goto-here">
    <!-- END nav -->

    <div class="hero-wrap hero-bread" style="background-image: url('resources/images/open-book-ge8dcf28a1_1920.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
          	<p class="breadcrumbs"><span class="mr-2"></span> <span>ORDER DETAIL</span></p>
            <h1 class="mb-0 bread">주문내역</h1>
          </div>
        </div>
      </div>
    </div>

    <section class="ftco-section ftco-cart">
    <%@ include file="/view/common/mySidebar.jsp" %>
			<div class="container">
				<div class="row">
    			<div class="col-md-12 ftco-animate">
    				<div class="cart-list">
	    				<table class="table">
						    <thead class="thead-primary">
						      <tr class="text-center">
						        <th colspan="2">주문 상품</th>
						        <th>수량</th>
						        <th>상품 금액</th>
						        <th>할인 금액</th>
						      </tr>
						    </thead>
						    <tbody>
						    <%int sumBeforPrice =0; %>
						    <% for(Order odl : orderDetailList){%>
							     <tr class="text-center">
							     <input type="hidden" id="productNo" name="productNo" value="<%=odl.getProductNo() %>">
							        <td class="image-prod">
							        	<div class="img" style="background-image:url(resources/images/thumbnail_upfiles/<%=odl.getSaveName() %>);" ></div>
							        </td>
							        <td class="product-name">
							        	<h3><%=odl.getProductName() %></h3>
							        </td>
							        <td class="price"><%=odl.getProductCount() %></td>
							        <td class="quantity"><del><%=df.format(odl.getProductPrice()) %></del></td>
							        <td class="total"><%=df.format(odl.getOrderDetailNo()) %></td>
							     </tr>
							      <!-- END TR-->
							     <%sumBeforPrice += odl.getProductPrice(); %>
				        	 <%} %>

						    </tbody>
						  </table>
					  </div>
    			</div>
    		</div>
    		<div class="row justify-content-end">
    			<div class="col-lg-4 mt-5 cart-wrap ftco-animate">
    				<div class="cart-total mb-3">
    					<h3>주문상태</h3>
  						<form action="#" class="info">
	              <div class="form-group">
	              	<p class="d-flex">
    						<span>주문일자 :</span>
   							<span><%=o.getOrderDate() %></span>
    				</p>
	              	<p class="d-flex">
   						<span>주문상태 :</span>
   						<%if(o.getOrderStatus().equals("Y")){ %>
   							<span>주문 완료</span>
   						<%}else if (o.getOrderStatus().equals("N")){ %>
   							<span>주문 취소</span>
   						<%} %>
    				</p>
	              </div>
	            </form>
    				</div>
    				<p>
    					<%if(o.getOrderStatus().equals("Y")){ %>
	    				<a href="<%=contextPath%>/OrderDelete.my?ono=<%=ono %>" class="btn btn-primary py-3 px-4">
   							<span>주문 취소</span>
   						<%}%>
	    				</a>
    				</p>
    			</div>
    			<div class="col-lg-4 mt-5 cart-wrap ftco-animate">
    				<div class="cart-total mb-3">
    					<h3>수령자 정보</h3>
  						<form action="#" class="info">
			              <div class="form-group">
			              	<p class="d-flex">
		   						<span>이름 :</span>
	   							<span><%=o.getReceverName() %></span>
		    				</p>
			              </div>
			              <div class="form-group">
			              	<p class="d-flex">
		   						<span>핸드폰번호 :</span>
	   							<span><%=o.getReceverPhone() %></span>
		    				</p>
			              </div>
			              <div class="form-group">
			              	<p class="d-flex">
		   						<span>주소 :</span>
	   							<span><%=o.getAddress() %></span>
		    				</p>
			              </div>
			            </form>
    				</div>
    			</div>
    			
    			<div class="col-lg-4 mt-5 cart-wrap ftco-animate">
    				<div class="cart-total mb-3">
    					<h3>결제 정보</h3>
    					<p class="d-flex">
    						<span>상품 가격</span>
    						<span><%=df.format(o.getProductPrice()) %> 원</span>
    					</p>
    					<p class="d-flex">
    						<span>배송비
    						<span data-tooltip="5만원 이상 무료 배송" style="display:inline-block; width:10px;">
    							<img src="resources/images/icon/icons8-help-18.png">
    						</span>
    						</span>
    						<%int del=0; %>
    						<%if(o.getProductPrice() <50000){ %>
    							<%del=2500; %>
    							<span>2500 원</span>
    						<%}else{ %>
    							<%del=0; %>
    							<span>0원</span>
    						<%} %>
    					</p>
    					<p class="d-flex">
    						<span>총 할인된 금액</span>
    						<span><%=df.format(sumBeforPrice-o.getProductPrice()) %> 원</span>
    					</p>
    					<hr>
    					<p class="d-flex total-price">
    						<span>총 결제금액</span>
    						<span><%=df.format(o.getProductPrice()+del) %> 원</span>
    					</p>
    				</div>
    			</div>
    		</div>
			</div>
		</section>
		<%} %>
  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>
	<%@ include file="/view/common/footer.jsp" %>

 	<script>
	 	$(function(){
			$(".table>tbody>tr").click(function(){
				location.href="<%=contextPath%>/ProductGet.pd?pdPno=" + $(this).eq(0).find('input').val();
			})
		});
	</script>
    
  </body>
</html>