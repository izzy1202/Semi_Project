<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.e2.board.model.vo.*,java.util.ArrayList"%>
<% 
	ArrayList<Board> list = (ArrayList<Board>)session.getAttribute("list");
    PageInfo pi=(PageInfo)session.getAttribute("pi");
%>

<div class="top">
	<div class="num">번호</div>
	<div class="title">제목</div>
	<div class="writer">글쓴이</div>
	<div class="date">작성일</div>
	<div class="count">조회</div>
</div>
<%if(list.isEmpty()) {%>
	<div class="writer">조회된 게시글이 없습니다.</div>
<%}else{ %>
	<%for(Board b : list) {%>
		<div>
			<div class="num"><%=b.getBoardNo() %></div>
			<!-- 제목 클릭시 detail컨트롤러로 이동 -->
			<div class="title">
				<a href="<%=request.getContextPath() %>/NoticeDetail.bd?bcate=1&bno=<%=b.getBoardNo()%>">
					<%=b.getBoardTitle() %>
				</a>
			</div>
			<div class="writer">
				<%=b.getBoardWriter() %>
			</div>
			<div class="date">
				<%=b.getBoardDate() %>
			</div>
			<div class="count">
				<%=b.getBoardCount() %>
			</div>
		</div>
	<%} %>
<%} %>


