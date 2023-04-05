<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.e2.board.model.vo.*" %>


<% 
  //게시글정보객체와 파일정보객체 불러옴<<
	Board b=(Board)request.getAttribute("b");
	Attachment at=(Attachment)request.getAttribute("at");
%>

	<!DOCTYPE html>
	<html lang="ko">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>공지사항 수정폼</title>
		<!-- 다른 경로 타고오면 적용이 안돼서 /ePower2를 따로 적어줌 -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bcss.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/drop.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
		<link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css" />

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
					<strong>공지사항 수정</strong>
					<p>수정할 내용을 입력해주세요</p>
				</div>
				
			<form method="post" action="<%=request.getContextPath()%>/NoticeUpdate.bd" enctype="multipart/form-data">
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
						
						<div class="cont">
							<textarea placeholder="내용 입력" id="content" name="content" required><%=b.getBoardContent()%></textarea>
						</div>
					</div>
				</div>
				 <br>
        <table>
            <tr>
            <th>첨부파일:</th>
            <td>
              <!-- 기존 첨부파일이 있으면, 수정폼에 첨부파일 이름 띄워주겠다 -->
            <% if(at!=null){ %>
              <%=at.getOriginName() %>
                <!-- 기존파일의 파일번호,수정명 -->
                 <!-- 기존파일 파일번호 -->
                <input type="hidden" name="originFileNo" value="<%=at.getFileNo() %>" >
                <!-- 기존파일 파일이름 -->
                <input type="hidden" name="originFileName" value="<%=at.getSaveName()%>" >
              <%} %>
            </td>
            <td>
            <!--수정파일!! 첨부란 -->
            &nbsp; &nbsp; <input type="file" name="reUpfile" >
            </td>
        </tr>
        <tr>
        <td></td>
        </tr>
        </table>
                <br>
                
                <div align="center">  
                <button type="submit" class="btn btn-primary py-3 px-5" align="center" >수정</button>
                <!-- 취소버튼 클릭시   공지목록으로 감-->
                <a href="<%=request.getContextPath()%>/NoticeGetController.bd?bcate=1&currentPage=1" class="btn btn-primary py-3 px-5">취소</a>	
				</div>
				
				</form>
			</div>
			</article>
		</div>
		
		
		        <!-- 글등록했을때 엔터가 들어가게 하는 스크립트 -->
		      <script>
		        function textArea(){
		        var str=document.getElementById("content").value;
		        str=str.replace(/(?:\r\n|\r\n)/g,'<br/>');
		        document.getElementById("content").value=str;
		        }
		      </script>
		
		
	<!-- 풋터 include -->
	<footer id="pageFooter"><%@ include file="/view/common/footer.jsp" %></footer>
	
	</body>
</html>