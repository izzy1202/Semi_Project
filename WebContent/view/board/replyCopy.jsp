<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	import="com.e2.board.model.vo.Reply,java.util.ArrayList"%>
<%
	ArrayList<Reply> list = (ArrayList<Reply>)request.getAttribute("list"); 
%>

      group
      depth
      sort
               
        <%for(int i=0 ;i<list.size();i++) {%>    
          <li class="comment">
            <div class="comment-body">
              <h3><%=list.get(i).getBoardWriter() %></h3>
              <div class="meta"><%=list.get(i).getReplyDate() %></div>
              <p><%=list.get(i).getReply() %></p>
              <input type="button" id="qweqwe"  value="작성">
              
              <!-- 댓글 클릭시 폼 보여주기 -->
              <div class="replyOpen">
	             <div class="comment-form-wrap pt-5 a">
	               	<div class="p-5 bg-light">
	                   <div class="form-group">
	                   <label for="message">댓글</label>
	                   <textarea id="message" cols="30" rows="10" class="form-control"></textarea>
	                 </div>
	                 <div class="form-group">
	                  <!-- 여기서 댓글 삽입 -->
	                    <input type="button" onclick="replyInsert();" value="댓글 입력" class="btn py-3 px-4 btn-primary">
	                  </div>
	              </div>
				</div>
			</div>
			<!--  -->

            </div>
          </li>
        <%} %>
            
       <li class="comment">
        <div class="comment-body">
          <h3>유저 네임</h3>
          <div class="meta">June 27, 2018 at 2:21pm</div>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur quidem laborum necessitatibus, ipsam
            impedit vitae autem, eum officia, fugiat saepe enim sapiente iste iure! Quam voluptas earum impedit
            necessitatibus, nihil?</p>
          <p><a href="#" class="reply">Reply</a></p>
        </div>


        <ul class="children">
          <li class="comment">
            <div class="comment-body">
              <h3>유저 네임</h3>
              <div class="meta">June 27, 2018 at 2:21pm</div>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur quidem laborum necessitatibus, ipsam
                impedit vitae autem, eum officia, fugiat saepe enim sapiente iste iure! Quam voluptas earum impedit
                necessitatibus, nihil?</p>
              <p><a href="#" class="reply">Reply</a></p>
            </div>

            <ul class="children">
              <li class="comment">
                <div class="comment-body">
                  <h3>John Doe</h3>
                  <div class="meta">June 27, 2018 at 2:21pm</div>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur quidem laborum necessitatibus,
                    ipsam impedit vitae autem, eum officia, fugiat saepe enim sapiente iste iure! Quam voluptas earum
                    impedit necessitatibus, nihil?</p>
                  <p><a href="#" class="reply">Reply</a></p>
                </div>
              </li>
            </ul>
            
          </li>
        </ul>
      </li>
      
	<script>
		
	$(function () {
		 $(".replyOpen").hide(); 
		 
		
		/*  function openReply(){

       		$(".replyOpen").hide();
       		$(this).next().show();
        	$(this).closest(".comment-body").find(".replyOpen").show();
        	$(this).text("asd");
        	$(".reply").text("asd");
        	console.log($(this));
        	console.log($(this));
        	console.log($(this).closest(".comment-body").find(".replyOpen")); 
        	
		};    */
	})
		//reply 누를시 입력폼 보여주기
		$(document).on("click","#qweqwe",function(){
			console.log("asd");
			console.log($(this));
			$(".replyOpen").hide();
       		$(this).next().show();
        	$(this).closest(".comment-body").find(".replyOpen").show();
		});
		 
		
	</script>

  </body>

  </html>