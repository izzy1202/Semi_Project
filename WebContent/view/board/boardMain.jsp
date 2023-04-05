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
	
	
	<!--입력폼-->
	<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
	
	
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
		
	          <!-- 메인콘텐츠 -->	
			<article id="mainContent" class="container_size">
				
				
				
				<div id="summernote"></div> 
				
				
				
				
				<!-- 스크립트 -->
				<script type="text/javascript">
				
				$(document).ready(function() {
					  $('#summernote').summernote();
					});
				
				</script>
				
				
			</article>
		</div>
	<!-- 풋터 include -->
	<footer id="pageFooter">
		<%@ include file="/view/common/footer.jsp" %>
	</footer>

</body>

</html>