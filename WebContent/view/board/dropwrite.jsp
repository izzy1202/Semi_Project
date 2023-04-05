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
		
		<form action="<%=contextPath %>/InquiryInsert.bd" method="post" id="myDropzone"> 
			<div class="board_wrap">
				<div class="board_title">
					<strong>공지사항</strong>
					<p>공지사항을 빠르고 정확하게 안내해드립니다.</p>
				</div>
			
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
							<textarea placeholder="내용 입력" name="content" required></textarea>
						</div>
					</div>
				</div>

				<!-- 첨부 파일부분입니다. -->
				<!-- <form action="InquiryInsert.bd" method="post" id="myDropzone"> -->
				<div class="dropzone">
					<!-- userNo은 임의로 설정 나중에 바꿔줄꺼임 -->
					<input type="hidden" name="userNo" value=2> 
					<input type="hidden" id="title2" name="title2"> 
					<input type="hidden" id="content2" name="content2">
					
					 <div class="dz-message needsclick" id="my-dropzone">
						<span class="text"> 
						<img src="http://www.freeiconspng.com/uploads/------------------------------iconpngm--22.png"
						alt="Camera" /> 
					</span> 
					<span class="plus"> +</span>
				
				</div>
			</div>
				<!-- </form> -->
			</form>
				<div class="bt_wrap">
					<!-- <button id="ntn" style="width : 50px; height: 40px"
						onclick='getText();document.getElementById("myDropzone").submit();'>사진
						등록</button> -->
						<button type="submit">등록</button>
					<a href="<%=request.getContextPath()%>/InquiryGet.bd?currentPage=1">취소</a>
				</div>
			</div>

			<script>
				Dropzone.autoDiscover = false;  // deprecated 된 옵션. false로 해놓는걸 공식문서에서 명시
			    const dropzone = new Dropzone("div.dropzone", { 
			        url: "https://httpbin.org/post",
			        method: 'post'
			        
			    });
			</script>
			
			

			<script>
				Dropzone.autoDiscover = false; // deprecated 된 옵션. false로 해놓는걸 공식문서에서 명시

				/* const dropzone = new Dropzone("div.dropzone", {
					url: "https://httpbin.org/post",
				}); */

				Dropzone.discover(); // deprecated 된 옵션. false로 해놓는걸 공식문서에서 명시
				Dropzone.options.myDropzone = {
					url: "<%=request.getContextPath()%>/InquiryInsert.bd",
					init: function () {
						var submitButton = document.querySelector("ntn");
						var myDropzone = this;
						submitButton.addEventListener("click", function () {
							console.log("업로드");
							myDropzone.processQueue();
						});
					},
					autoProcessQueue: false,
				}
				//여기서 제목과 내용을 얻습니다.
				function getText() {
					var t = $('input[name=title]').val();
					var c = $('textarea[name=content]').val();
					$('input[name=title2]').attr('value', t);
					$('input[name=content2]').attr('value', c);
				}

			</script>

	</body>

	</html>