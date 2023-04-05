<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	import="com.e2.board.model.vo.Reply,java.util.ArrayList"%>
<%
	ArrayList<Reply> list = (ArrayList<Reply>)request.getAttribute("list"); 
%>
		<li class="comment">
        <%for(int i=0 ;i<list.size();i++) {%>    
          <% if(i!=0 && list.get(i).getReplySort() !=  list.get(i-1).getReplySort()){%>
			<ul class="children">
          		<li class="comment">
		  <%}%>
            <div class="comment-body">
              <h3><%=list.get(i).getBoardWriter() %></h3>
              <div class="meta"><%=list.get(i).getReplyDate() %></div>
              <p><%=list.get(i).getReply() %></p>
              <input type="button" class="writeReply" value="작성">
              <input type="button" class="writeReply" onclick="replyDelete(<%=list.get(i).getReplyGroup()%>,<%=list.get(i).getReplySort()%>,<%=list.get(i).getReplyDepth()%>)"value="삭제">
              <!-- 댓글 클릭시 폼 보여주기 -->
              <div class="replyOpen">
	             <div class="comment-form-wrap pt-5 a">
	               	<div class="p-5 bg-light">
	                   <div class="form-group">
	                   <label for="message">댓글</label>
	                   <textarea id="message" cols="30" rows="10" class="form-control replyTextArea"></textarea>
	                 </div>
	                 <div class="form-group">
	                  <!-- 여기서 댓글 삽입 -->
	                    <input type="button" value="댓글 입력" class="btn py-3 px-4 btn-primary btn_reply"
	                    onclick="replyInsert(<%=list.get(i).getReplyGroup()%>,<%=list.get(i).getReplySort()%>,<%=list.get(i).getReplyDepth()%>);">
	                    
	                </div>
	              </div>
				</div>
			</div>

            </div>
            <%if(i != list.size()-1 && list.get(i).getReplySort() != list.get(i+1).getReplySort()){%>
				<%for(int j =0 ; j<= list.get(i).getReplySort()-list.get(i+1).getReplySort() ; j++){ %>
				</li>
           	</ul>
           	<%} %>
        <%} %>
        
        <%} %>
        </li>
	<script>
		
	$(function () {
		 $(".replyOpen").hide(); 
	})
	
		 
		
	</script>

  </body>

  </html>
  
