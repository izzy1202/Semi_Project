<%@page import="com.e2.product.model.vo.ProductComment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	//코맨트 리스트 꺼내기
	ArrayList<ProductComment> cmList = (ArrayList<ProductComment>)request.getAttribute("cmList");
	
	// 코맨트 리스트 갯수 꺼내기
	int cmCount = ((int)(request.getAttribute("cmCount")));
	
%>

<!-- [상품] 상품 코맨트 조회 ajax : 유원호 -->
<!-- 코맨트 갯수 -->
<h3 class="mb-5"><%=cmCount%> Comments</h3>
<ul class="comment-list">
	<% for (ProductComment pComment : cmList) { //코맨트 리스트 반복문 %>
		<% if ( !pComment.getCmStatus().equals("N")) { // 코맨트 상태가 'Y'일 경우 %>
			<li class="comment" style="margin-bottom: 0px;"><hr>
				<div class="comment-body" style="width: 100%;">
					<h3> 작성자 : <%=pComment.getCmName()%></h3>
					<p> 내용 : <%=pComment.getCmContent()%></p>
					<div class="pwd_wrap">
						<!-- 코맨트 번호 -->
						<input type="hidden" class="pComment_cmNo" value="<%=pComment.getCmNo() %>"/>
						<!-- 코맨트 비밀번호 -->
						<input type="hidden" class="pComment_cmPwd" value="<%=pComment.getCmPwd() %>"/>
						<!-- 코맨트 상품 번호 -->
						<input type="hidden" class="pComment_pdPno" value="<%=pComment.getCmPdNo()%>"/>
						<p>
						<button class="reply delete" style="width: 50px; height: 20px; padding: 0px; font-size: 9px;">삭제</button>
						</p>
						<div style="display: none;" class="deleteChk">
							<input type="text" class="pwdChk" placeholder="비밀번호입력하세요." style="border: none; border-bottom: 1px solid black;" value=""/>
							<button class="reply deleteSubmit" style="width: 50px; height: 20px; padding: 0px; font-size: 9px;">확인</button>
						</div>
					</div>
				</div>
			</li>
		<% } %>
	<% } %>
</ul>
