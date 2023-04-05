<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html lang="ko">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>공지사항</title>
		<!-- 다른 경로 타고오면 적용이 안돼서 /ePower2를 따로 적어줌 -->
		<link rel="stylesheet" href="/ePower2/resources/css/bcss.css">
		<link rel="stylesheet" href="/ePower2/resources/css/drop.css">
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
				<strong>공지사항</strong>
				<p>공지사항을 빠르고 정확하게 안내해드립니다.</p>
			</div>
	
			<form method="post" action="<%=request.getContextPath()%>/InquiryInsert.bd" enctype="multipart/form-data">
				<!-- 히든타입 유저 넘버 로그인될때 받을꺼라서 일단 2로 넘겨준다고 했습니당~ 나중에 수정해야되요 -->
				<input type="hidden" name="userNo" value="2">

				<div class="board_write_wrap">
					<div class="board_write">
						<div class="title">
							<dl>
								<dt>제목</dt>
								<dd>
									<input type="text" placeholder="제목 입력" id="title" name="title" required>
								</dd>
							</dl>
						</div>
		
						<div class="cont">
							<textarea placeholder="내용 입력" id="content" name="content" required></textarea>
						</div>
					</div>
				</div>

				<!-- 드롭다운바 넣을꺼라서 깨질꺼라  css 못했습니다 나중에 수정할꼐여;; -->
				<!-- 첨부파일 부분  name잘봐야해요~-->
				<input type="file" name = "upfile">
				<button id="btn_submit" onclick="textArea();"type="submit">등록</button>
				<!-- 취소버튼 넘어가고 싶은 페이지 넣으세요 -->
				<a id="btn_cancel" href="<%=request.getContextPath()%>/InquiryGet.bd?currentPage=1">취소</a>
			</form>
		</div>
	</article>
</div>

<!-- 풋터 include -->
<footer id="pageFooter">
	<%@ include file="/view/common/footer.jsp" %>
</footer>

<script>
function textArea(){
	var str = document.getElementById("content").value;
	str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
	document.getElementById("content").value = str;
}
</script>
</body>
</html>