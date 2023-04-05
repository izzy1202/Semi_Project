<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

       <!--일단 공지사항 메인 화면 -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bcss.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
       <!-- 글작성 스타일시트 -->
      <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/board.css">
      <!-- 사이드바 스타일시트 -->
      
      <Style>
        .container {
            display: grid;
            grid-template-areas:
                "header header header"
                "nav article ads"
                "footer footer footer";
            grid-template-rows: 150px 1fr 150px;
            grid-template-columns: 20% auto 30%;
            grid-gap: 30px;
            margin: 0px;      
        }
        
        header,
        /* footer, */
        article,
        nav{
            padding: 20px;
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
		.container_size{
			margin-top : -300px;
		}
    </style>
	
</head>
<body>

        
	<div class="container">
		
	     <!-- 헤더----------------- -->
      <header id="pageHeader"><%@ include file="/view/common/header.jsp"%></header> 
	
	
         <!-- 내용 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-->
		<article id="mainArticle">
			<div class="board_wrap">
				<div class="board_title">
					<strong>공지사항</strong>
					<p>공지사항을 빠르고 정확하게 안내해드립니다.</p>
				</div>
				<div class="board_view_wrap">
					<div class="board_view">
						<div class="title">글 제목이 들어갑니다.</div>
						<div class="info">
							<dl>
								<dt>번호</dt>
								<dd>1</dd>
							</dl>
							<dl>
								<dt>글쓴이</dt>
								<dd>김이름</dd>
							</dl>
							<dl>
								<dt>작성일</dt>
								<dd>2021.1.16</dd>
							</dl>
							<dl>
								<dt>조회</dt>
								<dd>33</dd>
							</dl>
						</div>
						<div class="cont">
							글 내용이 들어갑니다<br> 글 내용이 들어갑니다<br> 글 내용이 들어갑니다<br> 글
							내용이 들어갑니다<br> 글 내용이 들어갑니다<br> 글 내용이 들어갑니다<br> 글
							내용이 들어갑니다<br> 글 내용이 들어갑니다
						</div>
					</div>
					<div class="bt_wrap">
						<a href="<%=request.getContextPath()%>/NoticeGetController.bd?bcate=1&currentPage=1" class="on">목록</a> <a href="edit.html">수정</a>
					</div>
				</div>
			</div>

		</article>
		
		
		<!-- 사이드바 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-->
		<nav id="mainNav">
			<%@include file="/view/board/sidebar.jsp" %>
		</nav>
		
		
		<div id="siteAds">빈공간!</div>



          <!-------------------푸터----------->
         <footer id="pageFooter">Footer 
            <%@ include file="/view/common/footer.jsp"%>
         </footer>
	
	</div>


</body>
</html>