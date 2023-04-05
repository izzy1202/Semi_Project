<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	import="com.e2.board.model.vo.Reply,java.util.ArrayList"%>
<%
	ArrayList<Reply> list = (ArrayList<Reply>)request.getAttribute("list"); 
%>

<% for(int i=0 ;i<list.size();i++) { %>    
	<li class="comment">
		<div class="comment-body">
			<h3><%=list.get(i).getBoardWriter() %></h3>
			<div class="meta"><%=list.get(i).getReplyDate() %></div>
			<p><%=list.get(i).getReply() %></p>
			<p><a href="javascript:void(0)" onclick="deleteReply();" id="btn_replyDelete<%=i %>" class="reply">삭제</a></p>
		</div>
	</li>
<% } %>
