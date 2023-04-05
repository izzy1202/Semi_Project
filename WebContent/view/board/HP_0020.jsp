<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="java.util.ArrayList, com.e2.board.model.vo.*,com.e2.user.model.vo.Member" %>
<% 
	PageInfo pi=(PageInfo)session.getAttribute("pi"); 
	ArrayList<Board> list = (ArrayList<Board>)session.getAttribute("list");
%>
				
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bcss.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
<Style>
	/*html 영역잡는 css(해더,풋터등 잡는 css)*/
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
	
	/*페이징바 위치조절*/
	.text-center{
       	margin-top : 8px;
       }
       
     /*검색창 조절중(아직 구현하는중)*/
     .form-group	{
     	float: right;
     }
     .board_title{
     	display: inline-block;
     }
     .search{
     	width : 250px !important;
     	
     }
     .px-3{
     	width: 50px;
     	font-size : 17px;
     }
     .searchWrap{
     	margin-bottom : 0px !important;
     	padding-top : 40px;
     	align-content: center;
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
	<!-- 해더 include -->
<header id="pageHeader">
<%@ include file="/view/common/header.jsp" %>
</header>

<div class="container">
	<!-- 사이드바 include -->
	<nav><%@ include file="/view/board/sidebar.jsp" %></nav>

	<article id="mainContent" class="container_size">
	<div class="board_wrap">
		<div>
			<div class="board_title">
				<strong>1:1문의접수</strong>
				<p>문의사항을 빠르고 정확하게 안내해드립니다.</p>
			</div>
			<!-- 검색창  -->
			<div class="form-group d-flex searchWrap">
				<input type="text" id="searchText" class="form-control search" placeholder="검색어를 입력해주세요">
				<input type="button" value="검색" class="submit px-3"	>
			</div>
		</div>

		<div class="board_list_wrap" id="searchAjax">
	
	
			<div class="board_list">
				<div class="top">
					<div class="num">번호</div>
					<div class="title">제목</div>
					<div class="writer">글쓴이</div>
					<div class="date">작성일</div>
					<div class="count">조회</div>
				</div>
					<% if (list.isEmpty()) { %>
						<div class="writer">조회된 게시글이 없습니다.</div>
					<% } else { %>
						<%for(Board b : list) {%>
							<div>
								<div class="num"><%=b.getBoardNo() %></div>
								<!-- 제목 클릭시 detail컨트롤러로 이동 -->
								<div class="title">
									<a href="<%=contextPath %>/InquiryDetail.bd?bno=<%=b.getBoardNo() %>"><%=b.getBoardTitle() %></a>
								</div>
								<div class="writer"><%=b.getBoardWriter() %></div>
								<div class="date"><%=b.getBoardDate() %></div>
								<div class="count">	<%=b.getBoardCount() %>	</div>
							</div>
						<%} %>
					<% } %>
			</div>
			<!-- 페이징바   -->
			<div class="col text-center">
				<div class="block-27">
					<ul>
						<%if(pi.getCurrentPage() !=1) {%>
							<li><a href="<%=contextPath%>/InquiryGet.bd?currentPage=<%=pi.getCurrentPage()-1%>">&lt;</a></li>
						<%} %>
						<%for(int i=pi.getStartPage(); i<=pi.getEndPage(); i++) {%>
							<%if(i==pi.getCurrentPage()) {%>
								<!-- 내가 요청한 페이지 버튼 비활성화 -->
								<li class="active"><span><%=i %></span></li>
							<%}else{ %>
								<li><a href="<%=contextPath%>/InquiryGet.bd?currentPage=<%=i%>"><%=i %></a></li>
							<%} %>
						<% } %>
						<%if(pi.getCurrentPage() !=pi.getMaxPage()) {%>
							<li>
								<a href="<%=contextPath%>/InquiryGet.bd?currentPage=<%=pi.getCurrentPage()+1%>">&gt;</a>
							</li>
						<% } %>
					</ul>
				</div>
			</div>
		
			<!-- 글 등록으로 이동 -->
			<div class="bt_wrap">
				<a href="<%=contextPath %>/InquiryInsertForm.bd" class="on" id="btn_submit">등록</a>
			</div>
		</div>
	</div>
	</article>
</div>

<!-- 풋터 include -->
<footer id="pageFooter">
	<%@ include file="/view/common/footer.jsp" %>
</footer>

<script>

	//엔터키 눌렀을때 search()실행
	$("#searchText").on("keyup",function(key){
	    if(key.keyCode==13) {
	        search();
	    }
	});
	
	//검색기능
	function search() {
		
		$.ajax({
			url:"SearchGet.bd",
      		type : "get",
      		data : { categoryNo : 2,
      				 currentPage : 1,
      				 searchText : $("#searchText").val()},
      		success : function(result){
      			$("#searchAjax").html(result);
      		},
      		error : function(){
      			console.log("ajax 통신 실패!1");
      		}
      	})
      	
	}
	//검색후 페이징 기능
	function paing(pageNum) {
		$.ajax({
			url:"SearchGet.bd",
	  		type : "get",
	  		data : { categoryNo : 2,
	  				 currentPage : pageNum,
	  				 searchText : $("#searchText").val()},
	  		success : function(result){
	  			$("#searchAjax").html(result);
	  		},
	  		error : function(){
	  			console.log("ajax 통신 실패!1");
	  		}
	  	})
	}
	
	</script>
</body>

</html>