<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
              import="com.e2.board.model.vo.Board" %>
	<!DOCTYPE html>
	
<%
    Board b=(Board)request.getAttribute("b");
%>	
	
	<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>공지사항</title>
		<!-- 다른 경로 타고오면 적용이 안돼서 /ePower2를 따로 적어줌 -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bcss.css">
		<link rel="stylesheet" href="/ePower2/resources/css/drop.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
		<!-- 버튼용 -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/faqbutton.css">
		<link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css"/>

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

				margin: 0;
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
			
			
			  /*버튼 스타일 조절*/
                    #insertBtn,
                    #returnBtn
                    {
                     background: black;
                     color:white;
                    }
           
		</style>

	</head>

	<body>
		<header id="pageHeader">
			<%@ include file="/view/common/header.jsp" %>
		</header>
		
		<div class="container">
		<!-- 사이드바 include -->
		<nav><%@ include file="/view/board/sidebar.jsp" %></nav>
		
			<article id="mainContent" class="container_size">
			<div class="board_wrap">
				<div class="board_title">
					<strong>faq수정폼</strong>
					<p> faq수정</p>
				</div>
				
			<form method="post" action="<%=request.getContextPath()%>/FaqUpdate.bd?bcate=<%=b.getbCategoryNo()%>">
			      <input type="hidden" name="bno" value="<%=b.getBoardNo()%>">
				<div class="board_write_wrap">
					<div class="board_write">
						<div class="title">
							<dl>
								<dt>제목</dt>
								<dd>
									<input type="text" placeholder="제목 입력" id="title" name="title" value="<%=b.getBoardTitle()%>" required>
								</dd>
							</dl>
						</div>
						<!-- 
						삭제해도 되고 나중에 쓸꺼 같으면 쓰시면 됩니다
						<div class="info">
						<dl>
							<dt>글쓴이</dt>
							<dd><input type="text" name="" placeholder="글쓴이 입력"></dd>
						</dl>
						<dl>
							<dt>비밀번호</dt>
							<dd><input type="password" name="ps" placeholder="비밀번호 입력"></dd>
						</dl>
					</div> -->
					
						<div class="cont">
							<textarea placeholder="내용 입력" name="content"  value="<%=b.getBoardContent()%>" required><%=b.getBoardContent()%></textarea>
						</div>
					</div>
				</div>

                 <div class="faqcontainer">
                   <button type="submit" class="btn btn-primary py-3 px-5">등록</button>
                   <a href="#"  onClick="history.back()"  class="btn btn-primary py-3 px-5" id="returnBtn">취소</a>
                 </div>

					</div>
				</form>
			</div>
			</article>
		</div>
		
	<!-- 풋터 include -->
	<footer id="pageFooter"><%@ include file="/view/common/footer.jsp" %></footer>
	
	</body>
</html>