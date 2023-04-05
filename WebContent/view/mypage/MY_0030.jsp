<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.e2.mypage.model.vo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	ArrayList<Order> oList = (ArrayList<Order>)request.getAttribute("oList");
	DecimalFormat df = new DecimalFormat("###,###,###,###");
%>
  <%@ include file="/view/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- [상품] 주문내역 리스트: 박혜영 -->
<title>주문내역 리스트</title>
	<meta charset="utf-8">
</head>
<%if(loginUser==null){ %>
	<a href="<%=contextPath%>/errorPage.jsp"></a>
<%}else{ %>

  <body class="goto-here">
    <!-- END nav -->

    <div class="hero-wrap hero-bread" style="background-image: url('resources/images/open-book-ge8dcf28a1_1920.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
          	<p class="breadcrumbs"><span class="mr-2"></span> <span>ORDER LIST</span></p>
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
						        <th>주문번호</th>
						        <!-- <th>주문상품</th>
						        <th>&nbsp;</th> -->
						        <th colspan="2">주문상품</th>
						        <th>주문일자</th>
						        <th>총 가격</th>
						        <th>상태</th>
						      </tr>
						    </thead>
						    <tbody>
						    <%if(oList == null || oList.isEmpty()) {%>
							    <tr>
									<td colspan="3">주문내역이 없습니다.</td>
								</tr> 
						    <%}else{ %>
							    <%for(Order o : oList){ %>
								      <tr class="text-center">
								        <!-- <td class="product-remove"><a href="#"><span class="ion-ios-close"></span></a></td> -->
								        <td><%=o.getOrderNo() %></td>
								        <td class="image-prod"><div class="img" style="background-image:url(resources/images/thumbnail_upfiles/<%=o.getSaveName() %>);"></div></td>
								        <td class="product-name">
								        	<h3><%=o.getProductName() %></h3>
								        	<p>외 <%=o.getProductCount()-1 %> 개 상품</p>
								        </td>
								        
								        <td class="price"><%=o.getOrderDate() %></td>
								        <td class="total"><%=df.format(o.getProductPrice()) %> 원</td>
								        <%if(o.getOrderStatus().equals("Y")){ %>
			   								<td class="quantity">주문 완료</td>
				   						<%}else if (o.getOrderStatus().equals("N")){ %>
			   								<td class="quantity">주문 취소</td>
				   						<%} %>
								      </tr><!-- END TR-->
							    <%} %>
						    <%} %>
						    </tbody>
						  </table>
					  </div>
    			</div>
    		</div>
			</div>
		</section>
<%} %>
        <%@ include file="/view/common/footer.jsp" %>

 	<script>
	 	$(function(){
			$(".table>tbody>tr").click(function(){
				location.href="<%=contextPath%>/orderGet.my?ono=" + $(this).children().eq(0).text();
			})
		});
	</script>
    
  </body>
</html>