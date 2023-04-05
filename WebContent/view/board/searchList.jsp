<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.e2.board.model.vo.*,com.e2.user.model.vo.Member" %>
<% 
	PageInfo pi=(PageInfo)session.getAttribute("pi"); 
	ArrayList<Board> list = (ArrayList<Board>)session.getAttribute("list");
	String contextPath = request.getContextPath();
%>
<!-- 검색 결과 -->
<div class="board_list">
	<div class="top">
		<div class="num">번호</div>
		<div class="title">제목</div>
		<div class="writer">글쓴이</div>
		<div class="date">작성일</div>
		<div class="count">조회</div>
	</div>
	<% if(list.isEmpty()) {%>
		<div>
			<div class="title">조회된 게시글이 없습니다.</div>
		</div>
	<%}else{ %>
		<%for(Board b : list) {%>
			<div>
				<div class="num"><%=b.getBoardNo() %></div>
				<!-- 제목 클릭시 detail컨트롤러로 이동 -->
				<div class="title">
					<a href="<%=contextPath %>/InquiryDetail.bd?bno=<%=b.getBoardNo() %>"><%=b.getBoardTitle() %></a>
				</div>
				<div class="writer"><%=b.getBoardWriter() %></div>
				<div class="date"><%=b.getBoardDate() %></div>
				<div class="count">	<%=b.getBoardCount() %>	</div>
			</div>
		<% } %>
	<% } %>
</div>

<!-- 페이징바   -->
<div class="col text-center">
	<div class="block-27">
		<ul>
		<% if(!list.isEmpty()) {%>
			<%if(pi.getCurrentPage() !=1) {%>
				<li><a href="javascript:void(0);" onclick="paing(<%=pi.getCurrentPage()-1%>);">&lt;</a></li>
			<%}%>
			<%for(int i=pi.getStartPage(); i<=pi.getEndPage(); i++) {%>
				<%if(i==pi.getCurrentPage()) {%>
					<!-- 내가 요청한 페이지 버튼 비활성화 -->
					<li class="active"><span><%=i %></span></li>
				<%}else{ %>
					<li><a href="javascript:void(0);" onclick="paing(<%=i%>);"><%=i %></a></li>
				<% } %>
			<% } %>
			<%if(pi.getCurrentPage() !=pi.getMaxPage()) {%>
				<li>
					<a href="javascript:void(0);" onclick="paing(<%=pi.getCurrentPage()+1%>);">&gt;</a>
				</li>
			<%} %>
		<%} %>
		</ul>
	</div>
</div> 



<!-- 글 등록으로 이동 -->
<div class="bt_wrap">
	<a href="<%=contextPath %>/InquiryInsertForm.bd" class="on" id="btn_submit">등록</a>
</div>
