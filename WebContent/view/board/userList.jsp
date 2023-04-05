<%@page import="com.e2.user.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.e2.board.model.vo.*"%>
<% 
	PageInfo pi = (PageInfo)session.getAttribute("pi");
	ArrayList<Board> list = (ArrayList<Board>)session.getAttribute("list");
%>
<!-- 1:1문의 리스트 페이지-->
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
    
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bcss.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
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
        nav{
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
		.container_size{
			margin-top : -200px;
		}		
        
        .text-center{
        	margin-top : 20px;
        }
        .board_list .title {
		    width: 55%;
		    text-align: left;
		    padding-left: 50px;
		}
        .board_list .date {
		    width: 15%;
		}
        
    </style>
	
</head>
<body class="goto-here">
	
<header id="pageHeader">
	<%@ include file="/view/common/header.jsp" %>
</header>
	
<div class="container">
	<%@ include file="/view/board/sidebar.jsp" %>
	<article id="mainContent" class="container_size">
	<div class="board_wrap">
		<div class="board_title">
			<strong>1:1문의 내역</strong>
			<p>유저가 적은 리스트들만 보여줌</p>
		</div>
		<div class="board_list_wrap">
			<div class="board_list">
				<div class="top">
					<div class="num">번호</div>
					<div class="title">제목</div>
					<div class="writer">글쓴이</div>
					<div class="date">작성일</div>
					<div class="count">조회</div>
				</div>
				<%if(list.isEmpty()) {%>
					<div class="writer">조회된 게시글이 없습니다.</div>
				<%}else{ %>
					<%for(Board b : list) {%>
						<div>
							<div class="num"><%=b.getBoardNo() %></div>
							<!-- 제목 클릭시 detail로 보여줌 -->
							<div class="title"><a href="<%=contextPath %>/InquiryDetail.bd?bno=<%=b.getBoardNo() %>"><%=b.getBoardTitle() %></a></div>
							<div class="writer"><%=b.getBoardWriter() %></div>
							<div class="date"><%=b.getBoardDate() %></div>
							<div class="count"><%=b.getBoardCount() %></div>
						</div>
					<% } %>
				<% } %>
			</div>


			<!-- 페이징바   -->
			<div class="col text-center">
				<div class="block-27">	
					<ul>
						<%if(pi.getCurrentPage() != 1) {%>
							<li><a href="<%=contextPath%>/InquiryUserList.bd?currentPage=<%=pi.getCurrentPage()-1%>&userNo=<%=loginUser.getUserNo()%>">&lt;</a></li>
						<% } %>
						<%for(int i=pi.getStartPage(); i<=pi.getEndPage(); i++) {%>
							<%if(i==pi.getCurrentPage()) {%>
								<!-- 내가 요청한 페이지 버튼 비활성화 -->
								<li class="active"><span><%=i %></span></li>
							<%}else{ %>
								<li><a href="<%=contextPath%>/InquiryUserList.bd?currentPage=<%=i%>&userNo=<%=loginUser.getUserNo()%>"><%=i %></a></li>
							<%} %>        	 
						<% } %>
						<%if(pi.getCurrentPage() != pi.getMaxPage()) {%>
							<li><a href="<%=contextPath%>/InquiryUserList.bd?currentPage=<%=pi.getCurrentPage()+1%>&userNo=<%=loginUser.getUserNo()%>">&gt;</a></li>
						<% } %>
					</ul>
				</div>
			</div>
      
			<div class="bt_wrap">
				<!-- a태그를 POST방식으로 전송 -->
				<a href="<%=contextPath %>" class="on">메인 페이지로</a>
				<a href="<%=contextPath %>/InquiryInsertForm.bd" class="on">등록</a>
				<!--<a href="#">수정</a>-->
			</div>
		</div>
	</div>
	</article>
      <!-- <div id="siteAds">빈공간 </div> -->
</div>

<footer id="pageFooter">
	<%@ include file="/view/common/footer.jsp" %>
</footer>
	
</body>
</html>