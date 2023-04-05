<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
   import="com.e2.board.model.vo.* " %>
<% 
	Board b = (Board)request.getAttribute("board");
	Attachment at = (Attachment)request.getAttribute("at");
%>
<!DOCTYPE html>
<html lang=" ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
    
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bcss.css">
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
   		<nav><%@ include file="/view/board/sidebar.jsp" %></nav>
		<article id="mainContent" class="container_size">
    		<div class="board_wrap">
        		<div class="board_title">
            		<strong>공지사항</strong>
            		<p>공지사항 안내</p>
        		</div>
        		<div class="board_view_wrap">
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
							<%=b.getBoardContent() %>
						</div>
					</div>
					<div class="showfile">
						<%if(at==null) {%>
							첨부파일이 없습니다.
						<%}else{ %>
							첨부파일:  <a download="<%=at.getOriginName() %>" href="<%=contextPath %>/<%=at.getFilePath()+at.getSaveName() %>"><%=at.getOriginName() %></a>
						<%} %>
					</div>
                      
					<div id="sns" align="right">
						<a id="btnTwitter" class="link-icon twitter" href="javascript:shareTwitter();" width="10px"  height="10px"><img src="resources/images/icon-twitter.png" width="30" height="30" border-radius="50%"></a>
						<a id="btnFacebook" class="link-icon facebook" href="javascript:shareFacebook();"><img src="resources/images/icon-facebook.png" height="30" width="30" border-radius="50%"></a>    
						<a id="btnKakao" class="link-icon kakao" href="javascript:shareKakao();"  ><img src="resources/images/icon-kakao.png" height="30" width="30" border-radius="50%"></a>  
						<a href="#" onclick="clip(); return false;"><img src="resources/images/link.png" height="30" width="30"  border-radius="50%"></a>
					</div>

					<%if(loginUser != null && loginUser.getUserNo() == 1) {%>
					<div class="bt_wrap">
						<!-- 목록은 전페이지 이동입니다. -->
						<a href="#" onClick="history.back()" class="on">목록</a>
						<a id="btn_submit"href="<%=contextPath%>/NoticeUpdateForm.bd?bno=<%=b.getBoardNo()%>" class="on">수정</a>
						<a id="btn_delete"href="<%=contextPath%>/NoticeDelete.bd?bno=<%=b.getBoardNo()%>">삭제</a>
					</div>
					<%} %>
				</div>
			</div>
		</article>
	  </div>

<script type="text/javascript">

	//사이트주소공유
	function clip(){
	
		var url = '';
		var textarea = document.createElement("textarea");
		document.body.appendChild(textarea);
		url = window.document.location.href;
		textarea.value = url;
		textarea.select();
		document.execCommand("copy");
		document.body.removeChild(textarea);
		alert("URL이 복사되었습니다.")
	}
	
	
	
	function shareTwitter() {
	    var sendText = "지은E 서점 공지"; // 전달할 텍스트
	    var sendUrl = "<%=request.getContextPath()%>/NoticeDetail.bd?bcate=1&bno=<%=b.getBoardNo()%>/"; 
	    // 전달할 URL
	    window.open("https://twitter.com/intent/tweet?text=" + sendText + "&url=" + sendUrl);
	}
	
	function shareFacebook() {
	    var sendUrl ="https://www.google.com/webhp?hl=ko&sa=X&ved=0ahUKEwiH0paklK_7AhU68jgGHUXqDEQQPAgI"; // 전달할 URL
	    window.open("http://www.facebook.com/sharer/sharer.php?u="+sendUrl);
	}
	
	function shareKakao() {
		  // 사용할 앱의 JavaScript 키 설정
		  Kakao.init('e1858aba9a246282ab00c7cbb1865e4f');
		 
		  // 카카오링크 버튼 생성
		  Kakao.Link.createDefaultButton({
		    container: '#btnKakao', // 카카오공유버튼ID
		    objectType: 'feed',
		    content: {
		      title: "지은E서점 공지입니다", // 보여질 제목
		      description: "서점 공지를 알려드립니다", // 보여질 설명
		      imageUrl: "devpad.tistory.com/", // 콘텐츠 URL
		      link: {
		         mobileWebUrl: "http://localhost:8888/ePower2/NoticeDetail.bd?bcate=1&bno=<%=b.getBoardNo()%>",
	         webUrl: "https://www.naver.com/"
	      }
	    }
	  });
	}

</script>

<footer id="pageFooter">
	<%@ include file="/view/common/footer.jsp" %>
</footer>

</body>

</html>



