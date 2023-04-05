<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="com.e2.board.model.vo.* , java.util.ArrayList" %>
<% 
	Board b=(Board)session.getAttribute("b");
	ArrayList<BoardAttachment> list = (ArrayList<BoardAttachment>)session.getAttribute("list");  
%>
<!DOCTYPE html>
<html lang=" ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
    <!-- ajax CDN -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bcss.css">
    <Style>
        .container {
            display: grid;
            grid-template-areas:

                "header header header"
                "nav article ads"
                "footer footer footer";

            grid-template-rows: 150px 1fr 150px;
            grid-template-columns: 20% 1fr 15%;

            grid-gap: 10px;

            
        }

        header,
        footer,
        article,
        nav {
            padding: 20px
        }

        #pageHeader {
            grid-area: header;
        }

        #pageFooter {
            grid-area: footer;
        }

        #mainContent {
            grid-area: article;
        }

        #mainNav {
            grid-area: nav;
        }

        #siteAds {
            grid-area: ads;
        }

        .container_size {
            margin-top: -200px;
        }

    </style>
</head>

<body>
<header id="pageHeader">
	<%@ include file="/view/common/header.jsp" %>
</header>
<div class="container">
	<nav><%@ include file="/view/board/sidebar.jsp" %></nav>	
	<article id="mainContent" class="container_size">
		<div class="board_wrap">
			<div class="board_title">
				<strong>1:1문의</strong>
				<p>1:1문의을 빠르고 정확하게 안내해드립니다.</p>
			</div>
			<div class="board_view_wrap">
				<input type="hidden" id="content" value="<%=b.getBoardContent() %>">
				<div class="board_view">
    				<div class="title"><%=b.getBoardTitle() %></div>
					<div class="info">
    					<dl>
					        <dt>번호</dt>
					        <dd><%=b.getBoardNo() %></dd>
						</dl>
						<dl>
						    <dt>글쓴이</dt>
						    <dd><%=b.getBoardWriter() %></dd>
						</dl>
						<dl>
						    <dt>작성일</dt>
						    <dd><%=b.getBoardDate() %></dd>
						</dl>
						<dl>
						    <dt>조회</dt>
						    <dd><%=b.getBoardCount() %></dd>
						    </dl>
					</div>
					<!-- 내용 -->
					<div class="cont">
						<div class="comment-message" style="white-space:rep-wrap"><%=b.getBoardContent() %></div>
    				</div>
				</div>
				<!-- 이미지 있으면 보여줌-->
				<%if (!list.isEmpty()) {%>
					<div>
						<h3>상세이미지</h3>
						<%for(int i=0;i<list.size();i++){ %>
							<img id="contentImg<%=i %>"src="<%=contextPath %>/<%= (list.get(i).getFilePath())+(list.get(i).getSaveName())%>" width="150" height="120">
						<%} %>
					</div>
				<% } %>

				<div class="bt_wrap">
    				<!-- 목록은 전페이지 이동입니다. -->
					<a href="#" onClick="history.back()" class="on">목록</a>
					<%if(loginUser.getUserId().equals(b.getBoardWriter())) {%>
						<a id="btn_submit"href="<%=request.getContextPath() %>/InquiryUpdateForm.bd?bno=<%=b.getBoardNo() %>"class="on">수정</a>	
					<%} %>
					<%if(loginUser.getUserId().equals("admin") || loginUser.getUserId().equals(b.getBoardWriter())) {%>
						<a id="btn_delete"href="<%=request.getContextPath() %>/InquiryDelete.bd?bno=<%=b.getBoardNo()%>">삭제</a>
					<%} %>
				</div>
    		</div>
		</div>

		<!-- START 댓글 넣는 폼 -->
		<div class="comment-form-wrap pt-5">
			<h3 class="mb-5">Leave a comment</h3>
			<div class="p-5 bg-light">
				<div class="form-group">
					<label for="message">댓글</label>
					<textarea id="message" cols="30" rows="10" class="form-control replyTextArea"></textarea>
				</div>
				<div class="form-group">
	            	<!-- 여기서 댓글 삽입 -->
					<input type="button" onclick="replyGroupInsert();" value="댓글 입력" class="btn py-3 px-4 btn-primary btn_reply">
				</div>
           	</div>
		</div>
        <!-- END 댓글 넣는 폼 -->

		<!-- START 댓글 LIST -->
		<div class="pt-5 mt-5">
			<h3 class="mb-5">Comments</h3>
			<ul class="comment-list">
            	<!-- 댓글 뿌려주는 곳 (ajax) -->
			</ul>
		</div>
		<!-- END 댓글 LIST -->

	</article>
</div>

<footer id="pageFooter">
	<%@ include file="/view/common/footer.jsp" %>
</footer>
	
<script>


	var replyText = "";
	
	//처음에 db에 있는 댓글 뿌리기
	$(function(){
		$.ajax({
			url:"ReplyGet.bd",
			type : "post",
			data : { bno : <%=b.getBoardNo()%>},
			success : function(result){
				$(".comment-list").html(result);
				console.log("성공");
			},
			error : function(){
				console.log("ajax 통신 실패!");
			}
		});
		
		
		//reply 누를시 입력폼 보여주기
	   	$(document).on("click",".writeReply",function(){
	   		$(".replyOpen").hide();
	        $(this).next().show();
	        $(this).closest(".comment-body").find(".replyOpen").show();
	        
			$('.replyTextArea').on("keyup",function(){
				replyText = $(this).closest('.replyOpen').find('.replyTextArea').val();
				console.log("text 내용:"+replyText);
			})
			function replyInsert(groupNum,sortNum,depthNum){
				
				 $.ajax({
					url:"ReplyInsert.bd",
					type : "post",
					data : { bno : <%=b.getBoardNo()%>,
							userNo : <%=loginUser.getUserNo()%>,
							reply : replyText,
							depth : depthNum,
							sort : sortNum,
							group : groupNum},
					success : function(result){
						$(".comment-list").html(result);
						console.log("group"+groupNum);
						console.log("sort"+sortNum);
						console.log("depth"+depthNum);
						console.log("성공 controoler에 들어감");
					},
					error : function(){
						console.log("ajax 통신 실 패!1");
					}
				})
				
		   	};
			
	   	});
		
	});
	
	//댓글 달기 ajax
	function replyInsert(groupNum,sortNum,depthNum){
		
			 $.ajax({
				url:"ReplyInsert.bd",
				type : "post",
				data : { bno : <%=b.getBoardNo()%>,
						userNo : <%=loginUser.getUserNo()%>,
						reply : replyText,
						depth : depthNum+1,
						sort : sortNum+1,
						group : groupNum},
				success : function(result){
					$(".comment-list").html(result);
				},
				error : function(){
				}
			})
			
	   	};
	//댓글달기 group
   	function replyGroupInsert(groupNum,sortNum,depthNum){

		 $.ajax({
			url:"ReplyInsert.bd",
			type : "post",
			data : { bno : <%=b.getBoardNo()%>,
					userNo : <%=loginUser.getUserNo()%>,
					reply : textArea($(".replyTextArea").val()),
					depth : 0,
					sort : 0,
					group : 0},
			success : function(result){
				$(".comment-list").html(result);
			},
			error : function(){
				console.log("ajax 통신 실 패!1");
			}
		})
   	};
   	
	
	//댓글 삭제
	function replyDelete(groupNum,sortNum,depthNum) {

		 $.ajax({
			url:"ReplyDelete.bd",
			type : "post",
			data : { bno : <%=b.getBoardNo()%>,
					userNo : <%=loginUser.getUserNo()%>,
					reply : replyText,
					depth : depthNum,
					sort : sortNum,
					group : groupNum},
			success : function(result){
				$(".comment-list").html(result);
			},
			error : function(){
			}
		})
		
  	};
       
    //댓글 엔터 넣기
	function textArea(message){
		message = message.replace(/(?:\r\n|\r|\n)/g, '<br/>');
		return message;
		
	}
       
</script>
	
	
</body>

</html>