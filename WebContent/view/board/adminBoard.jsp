<%@page import="com.e2.user.model.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="java.util.ArrayList, com.e2.board.model.vo.*" %>
<% 
	PageInfo pi=(PageInfo)session.getAttribute("pi"); ArrayList<Board> list = (ArrayList<Board>)session.getAttribute("list");
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
		
		.text-center{
        	margin-top : 20px;
        }
        
        .form-group	{
        	float: right;
        }
        .board_title{
        	display: inline-block;
        }
        
        .px-3{
        	width: 50px;
        	font-size : 17px;
        	float : right;
        }
        .searchWrap{
        	margin-bottom : 0px !important;
        	padding-top : 40px;
        	align-content: center;
        }
        .board_list .num {
		    width: 5% !important;
		}
		.board_list .check {
		    width: 5% !important;
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
		<!-- 사이드바 include -->
		<%@ include file="/view/board/sidebar.jsp" %>
			<article id="mainContent" class="container_size">
				<div class="board_wrap">
				
					<div>
						<div class="board_title">
							<strong>1:1관리페이지(관리자)</strong>
							<p>관리자만 들어올 수 있음</p>
						</div>
					</div>
					
					
			<form action="<%=contextPath %>/InquiryAdminDelete.bd" method="post" id="deleteBoards">
			<button type="submit" onclick= "deleteArray();document.getElementById('deleteBoards').submit();" >삭제</button>
			<input type="hidden" name="selectArray">
					
					<div class="board_list_wrap">
					
						<div class="board_list">
							<div class="top">
								<div class="check"><input type="checkbox"  name="bno" onclick="selectAll(this);"></div>
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
											<div class="check box"><input type="checkbox" id="check" name="bno" value=<%=b.getBoardNo() %>></div>
											<div class="num">
												<%=b.getBoardNo() %>
											</div>
											<!-- 제목 클릭시 detail로 보여줌 -->
											<div class="title">
											<a href="<%=contextPath %>/InquiryDetail.bd?bno=<%=b.getBoardNo() %>">
													<%=b.getBoardTitle() %>
												</a></div>
											<div class="writer">
												<%=b.getBoardWriter() %>
											</div>
											<div class="date">
												<%=b.getBoardDate() %>
											</div>
											<div class="count">
												<%=b.getBoardCount() %>
											</div>
										</div>
										<%} %>
											<%} %>
						</div>
</form>
						<!-- 페이징바   -->

						<div class="col text-center">
							<div class="block-27">
								<ul>
									<%if(pi.getCurrentPage() !=1) {%>
										<li><a href="<%=contextPath%>/InquiryAdminGet?currentPage=<%=pi.getCurrentPage()-1%>">&lt;</a></li>
										<%} %>
											<%for(int i=pi.getStartPage(); i<=pi.getEndPage(); i++) {%>
												<%if(i==pi.getCurrentPage()) {%>
													<!-- 내가 요청한 페이지 버튼 비활성화 -->
									<li class="active"><span>
											<%=i %>
										</span></li>
									<%}else{ %>
									
										<li><a href="<%=contextPath%>/InquiryAdminGet?currentPage=<%=i%>"><%=i %></a></li>
										<%} %>
											<%} %>
												<%if(pi.getCurrentPage() !=pi.getMaxPage()) {%>
													<li>
														<a href="<%=contextPath%>/InquiryAdminGet?currentPage=<%=pi.getCurrentPage()+1%>">&gt;</a>
													</li>
													<%} %>
								</ul>
							</div>
						</div>

						<div class="bt_wrap">
							<a href="<%=contextPath %>/view/board/write.jsp" class="on">등록</a>
						</div>
					</div>
				</div>
			</article>
		</div>
	<footer id="pageFooter">
		<%@ include file="/view/common/footer.jsp" %>
	</footer>
	
	<script>
		//체크박스 클릭시 전체 선택
		function selectAll(selectAll)  {
			  const checkboxes 
			       = document.getElementsByName('bno');
			  
			  checkboxes.forEach((checkbox) => {
			    checkbox.checked = selectAll.checked;
			  })
			}
		
		//여러개 삭제
		function deleteArray(){
			
			var selectArray = new Array();
			  
	        $('.box>input[type="checkbox"]:checked').each(function (index) {
	        	selectArray.push($(this).val());
	        });
	        //console.log(selectArray);
	        $('input[name=selectArray]').attr('value', selectArray);
	        /* 
	        if(confirm(selectArray.length+"개의 게시글을 삭제하시겠습니까?")){
	        	
	        }else{
	        	alert("아니요");
	        }
	         */
	        //console.log("selectArray :"+$('input[name=selectArray]').val());
	  		
		} 
	</script>

</body>

</html>

