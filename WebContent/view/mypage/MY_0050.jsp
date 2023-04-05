<%@page import="java.text.DecimalFormat"%>
<%@page import="com.e2.mypage.model.vo.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Cart> cList = (ArrayList<Cart>)request.getAttribute("cList");
	DecimalFormat df = new DecimalFormat("###,###,###,###");
%>
<%@ include file="/view/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- [상품] 장바구니: 박혜영 -->
<title>Insert title here</title>
</head>
<body class="goto-here" id="cart-list">
    <!-- END nav -->

    <div class="hero-wrap hero-bread" style="background-image: url('resources/images/open-book-ge8dcf28a1_1920.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
          	<p class="breadcrumbs">
          	<span class="mr-2"></span><span>CART</span></p>
            <h1 class="mb-0 bread">장바구니</h1>
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
							        <th>&nbsp;</th>
							        <th colspan="2">상품 목록</th>
							        <th>수량</th>
							        <th>상품 금액</th>
							        <th>할인된 금액</th>
							        <th>&nbsp;</th>
							      </tr>
							    </thead>
							    <tbody>
							    <%if(cList == null || cList.isEmpty()) {%>
								    <tr>
										<td colspan="4">찜한 상품이 없습니다.</td>
									</tr> 
							    <%}else{ %>
								    <%for(Cart c : cList){ %>
							      <tr class="text-center">
							        <td><input type="hidden" value="<%=c.getProductNo()%>">
							        	<div class="col-md-12">
											<%-- <div class="checkbox">
											   <label>
											   		<input type="checkbox" name="chkCart" value="<%=c.getProductNo()%>" class="mr-2">
											   </label>
											</div> --%>
										</div>
							        </td>
							        <td class="image-prod">
							        	<%-- <a href="<%=contextPath%>/ProductGet.pd?pdPno=<%=c.getProductNo() %>"> --%>
						        		<div class="img" style="background-image:url(resources/images/thumbnail_upfiles/<%=c.getSaveName() %>);" onclick="location.href='<%=contextPath%>/ProductGet.pd?pdPno=<%=c.getProductNo() %>';"></div>
							        	<!-- </a> -->
							        </td>
							        
							        <td class="product-name"><input type="hidden" id="pdName<%=c.getProductNo()%>" value="<%=c.getProductName()%>">
							        	<h3>
							        		<div onclick="location.href='<%=contextPath%>/ProductGet.pd?pdPno=<%=c.getProductNo() %>';"><%=c.getProductName() %><div>
							        	</h3>
							        </td>
							        
							        <td class="quantity">
							        	<%=c.getProductCount()%><input type="hidden" value="<%=c.getProductCount()%>">
									</td>
							        <!--  -->
							        <td class="price"><%=df.format((c.getProductPrice()*c.getProductCount())) %></td>
							        <td class="total"><%=df.format((c.getPaymentPrice()*c.getProductCount())) %></td>
							        <td class="product-remove">
							        	<a href="javascript:void(0);">
								        	<span class="ion-ios-close"></span>
							        	</a>
							        </td>
							      </tr><!-- END TR-->
	 								<%} %>
							    <%} %>
							    </tbody>
							  </table>
						  </div>
	    			</div>
	    		</div>
	    		<br>
		</div>
	</section>

  <!-- loader -->
	<%@ include file="/view/common/footer.jsp" %>
	
  	<script>

  	$(function(){
		$(".table>tbody>tr>td>a").click(function(){
			var pdNo = $(this).parents().parents().eq(0).find("input").val();
			$.ajax({
				url : "<%=contextPath %>/CartDelete.my",
				data : {pdNo : pdNo},
				type : "get",
				success : function(result){
					$("#cart-list").html(result);
				},
				error : function(){
				}
			})
		})
	});
	</script>
    
  </body>
  </html>