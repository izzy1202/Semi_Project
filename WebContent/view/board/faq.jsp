<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.util.ArrayList, com.e2.board.model.vo.*,com.e2.user.model.vo.Member" %>
    <% 
    	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list"); 
    
    	%>

            <!DOCTYPE html>
            <html lang="ko">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>공지사항</title>
                <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/faqbutton.css">
                <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bcss.css">
                <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
                <Style>
                    /*html 영역잡는 css(해더,풋터등 잡는 css)*/
                    .col_wrap {
                        width: 100px;
                    }
                    
                    .accordion-item-header {
                    font-weight:normal !important;
                    padding-left:20px !important;
                    }
                    
                    .card{
                     min-width: 650px !important;
                     background-color: #eee !important; 
                    }
                    
                 .p-3 {
                     padding: 1rem !important; 
                   }
                    

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
                        margin-top: -160px;
                    }

                    /*페이징바 위치조절*/
                    .text-center {
                        margin-top: 8px;
                    }

                    /*검색창 조절중(아직 구현하는중)*/
                    .form-group {
                        float: right;
                    }

                    .board_title {
                        display: inline-block;
                    }

                    .search {
                        width: 250px !important;

                    }

                    .px-3 {
                        width: 50px;
                        font-size: 17px;
                    }

                    .searchWrap {
                        margin-bottom: 0px !important;
                        padding-top: 40px;
                        align-content: center;
                    }
                    
                    
                    /*버튼 스타일 조절*/
                    #insertBtn,
                    #updateBtn,
                    #deleteBtn
                    {
                     background: black;
                     color:white;
                    }
                    
                    .card {
					    border: none;
					    background: #d3d3d3 !important;
					}
					
					
					.accordion-item-body-content {
					    background-color: #d3d3d3 !important;
					    padding: 1rem;
					    line-height: 1.5rem;
					    font-family: sans-serif;
					    border-top: 1px solid;
					    font-size: 16px;
					    border-image: linear-gradient(to right, transparent, #34495e, transparent) 1;
					}
                    
                    
                    
                </style>
            </head>

            <body class="goto-here">
            
               <script src="http://code.jquery.com/jquery-latest.min.js"></script>
                        <!-- <script src="/tab.js"></script> -->

                <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/faq.css">

                <!-- 해더 include -->
                <header id="pageHeader">
                    <%@ include file="/view/common/header.jsp" %>
                </header>

                <div class="container">
                    <!-- 사이드바 include -->
                    <nav>
                        <%@ include file="/view/board/sidebar.jsp" %>
                    </nav>

                    <!-- 여기가 콘텐츠 -->
                    <article id="mainContent" class="container_size">
                        <!--카테검색 영역-->
                        <div class="container mt-4">
                            <div class="row d-flex justify-content-center col_wrap">
                                <div class="col-md-9">
                                    <div class="card p-4 mt-3">
                                        <h3 class="heading mt-5 text-center"><strong>자주 묻는 질문</strong></h3>
                                        <div class="d-flex justify-content-center px-5">
                    <!----------------------------------- 검색창 영역 ------------------------------------>                                        
                                            <div class="search">
                                                <input type="text" class="search-input" id="searchbox" placeholder="search" name="">
                                                <a href="#" class="search-icon" onclick="faqSearch()"><img src="resources/images/glass.png" height="20" width="20"><i class="fa fa-search"></i>
                                                </a>
                                            </div>
                                        </div>
                                        <div class="row mt-4 g-1 px-4 mb-5">
                                            <div class="col-md-2">
                                                <div class="cate card-inner p-3 d-flex flex-column align-items-center"
                                                    value="3"
                                                    onclick="location.href='<%=contextPath%>/FaqGet.bd?bcate=3'">
                                                    <img src="resources/images/boardcate.refund.jpg" width="45"
                                                        height="45">
                                                    <div class="text-center mg-text">
                                                        <span class="mg-text">결제환불</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-2">
                                                <div class="cate card-inner p-3 d-flex flex-column align-items-center"
                                                    value="4"
                                                    onclick="location.href='<%=contextPath%>/FaqGet.bd?bcate=4'">
                                                    <img src="resources/images/boardcate1.subscriptioin.png" width="45"
                                                        height="45">
                                                    <div class="text-center mg-text">
                                                        <span class="mg-text">정기구독</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-2">
                                                <div class="cate card-inner p-3 d-flex flex-column align-items-center"
                                                    value="5"
                                                    onclick="location.href='<%=contextPath%>/FaqGet.bd?bcate=5'">
                                                    <img src="resources/images/boardcate.people.png" width="45"
                                                        height="45">
                                                    <div class="text-center mg-text">
                                                        <span class="mg-text">회원</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-2">
                                                <div class="cate card-inner p-3 d-flex flex-column align-items-center"
                                                    onclick="location.href='<%=contextPath%>/FaqGet.bd?bcate=6'">
                                                    <img src="resources/images/boardcate.self-service.png" width="45"
                                                        height="45">
                                                    <div class="text-center mg-text">
                                                        <span class="mg-text">서비스</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-2">
                                                <div class="cate card-inner p-3 d-flex flex-column align-items-center"
                                                    onclick="location.href='<%=contextPath%>/FaqGet.bd?bcate=7'">
                                                    <img src="resources/images/boardcate.ereader.png" width="45"
                                                        height="45">
                                                    <div class="text-center mg-text">
                                                        <span class="mg-text">리더기</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-2">
                                                <div class="card-inner p-3 d-flex flex-column align-items-center"
                                                    onclick="location.href='<%=contextPath%>/FaqGet.bd?bcate=9'">
                                                    <img src="resources/images/boardcate.mybook.png" width="45"
                                                        height="45">
                                                    <div class="text-center mg-text">
                                                        <span class="mg-text">내서재</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                       

                        <!---아코디언(본문)--->
                        <div class="accordion" id="faqsearchAjax">
                                   <!-- 여기서부터 가져감 -->
                            <div class="accordion-item">
                                <!--첫번째 질문-->
                                <% for (Board b : list) { %>
                                            <!--아코디언제목란 -->
                                    <div class="accordion-item-header">
                                         <!-- 체크박스 -->
                                      <%if(loginUser != null && loginUser.getUserNo() == 1) {%>
                                      <div>
                                        <input type="checkbox" class="ckbox" id="ckbox" name="ckbox" value=<%=b.getBoardNo()%>>
                                      </div>
                                      <%} %>
                                        &nbsp; <%=b.getBoardTitle()%>
                                    </div>
                                          <!-- 아코디언내용란 -->                                    
                                    <div class="accordion-item-body">
                                        <div class="accordion-item-body-content">
                                            <%=b.getBoardContent()%>
                                        </div>
                                    </div>
                                    <% } %>
                            </div>
                        </div>
                        
         <!---------------------------관리자용버튼----------------------------->
         <%if(loginUser != null && loginUser.getUserNo() == 1) {%>
                        <div class="faqcontainer">
                            <h2></h2>
                            <a href="<%=request.getContextPath()%>/FaqInsertForm.bd"  class="btn-gradient cyan small" id="insertBtn">등록</a>
                            <a href="javascript:void(0);" class="btn-gradient cyan small" id="updateBtn" onclick="return updateClick()">수정</a>
                            <a href="javascript:void(0);" class="btn-gradient cyan small" id="deleteBtn" onclick="deleteClick()"  >삭제</a>
                        </div>
		<%} %>                        
                        
                      
                        <script>
                        
                        //faq 아코디언 펼쳐지는 스크립트
                        const accordionItemHeaders = document.querySelectorAll(".accordion-item-header");

                        accordionItemHeaders.forEach(accordionItemHeader => {
                            accordionItemHeader.addEventListener("click", event => {

                                accordionItemHeader.classList.toggle("active");
                                const accordionItemBody = accordionItemHeader.nextElementSibling;
                                if (accordionItemHeader.classList.contains("active")) {
                                    accordionItemBody.style.maxHeight = accordionItemBody.scrollHeight + "px";
                                }
                                else {
                                    accordionItemBody.style.maxHeight = 0;
                                }

                            });
                        });
                        
                        	//검색창 검색
                            $("#searchbox").on("keyup",function(key){
                        	    if(key.keyCode==13) {
                        	        faqSearch();
                        	    }
                        	});
                            
                            
                            function faqSearch(){
                          	$.ajax({
                          	url:"FaqSearch.bd",
                          	data:{searchContent: $("#searchbox").val()},
                          	success: function(result){
                          	     console.log("통신성공");
                          		$("#faqsearchAjax").html(result);
                          		
                          		
                          		
                          		 //검색후에 faq 아코디언 펼쳐지는 스크립트
                                const accordionItemHeaders = document.querySelectorAll(".accordion-item-header");

                                accordionItemHeaders.forEach(accordionItemHeader => {
                                    accordionItemHeader.addEventListener("click", event => {

                                        accordionItemHeader.classList.toggle("active");
                                        const accordionItemBody = accordionItemHeader.nextElementSibling;
                                        if (accordionItemHeader.classList.contains("active")) {
                                            accordionItemBody.style.maxHeight = accordionItemBody.scrollHeight + "px";
                                        }
                                        else {
                                            accordionItemBody.style.maxHeight = 0;
                                        }

                                    });
                                });
                          		
                          	
                          	},
                          	 error:function(){
                          	  console.log("통신실패");
                          	 }
                          	});
                            };	
                        	
                   
                        
                        ///////////////////////////////////////////////////////////////////수정스크립트
                        function updateClick(){
                     		//체크된 게시글의 숫자
                        let count=$("input:checkbox[name='ckbox']:checked").length;
                     		
                     	var bno=$("input:checkbox[name='ckbox']:checked").val();
                     	
                     	if(count==0){ //체크박스 선택하지 않으면 수정버튼작동x 수정폼으로 넘어가지 않게함
                     	    alert("수정할 게시글을 선택해주세요.");
                     		return false;
                     	}else{
                      	   if(count>=2){ //체크박스 2개를 선택했을시에 1개만 선택하도록 알람
                      		  $(this).prop("checked",false);
                      		  alert("수정은 게시글 1개까지만 선택할 수 있습니다.");
                      	   }else{ // 체크박스 하나만 선택했을시에 업데이트 폼으로 보냄 (정상작동)
                      		   console.log(count);
                      		   console.log(bno);
                      		location.href="FaqUpdateForm.bd?bno="+bno;
                      	   }
                     	}
                      	   
                        }
                       
                        //버튼 누르면 선택삭제 스크립트 (여러개의 게시글 번호를 가지고 간다.) 
                         function deleteClick(){
                        	  
                        	 var checkBoxArr=[]; //선택한 체크박스값 넣어줄 배열
                        	 
                        	 //console.log($("input:checkbox[name='ckbox']:checked")); //Object
                        	 
                        	 $("input:checkbox[name='ckbox']:checked").each(function(){
                        		 checkBoxArr.push($(this).val());
                        		 //var bno=$("input[name=ckbox]:checked").val();
                        		 console.log("asd"+checkBoxArr); 
                              	});
                        	 
                        	 
                        	 $.ajax({
                           		
                               	url:"FaqDelete.bd",
                               	type:"post",
                               	traditional:true,
                               	data:{
                               		"bno":checkBoxArr
                               	},
                               	dataType:"json",
                               	success:function(result){
                               		console.log("통신성공");
                               		
                               		if(result>0){
                               			location.reload(); //새로고침
                               			alert("삭제성공")
                               		}else{
                               			alert("삭제실패")
                               		}
                               	},
                               	error:function(){
                               	console.log("통신실패");
                               	}
                         	 })
                        	
                          }
                        
                         </script>
                         
                        </main>
                      
                       
                    
                    </article>
                </div> 
                
                <!-- 풋터 include -->
                <footer id="pageFooter">
                    <%@ include file="/view/common/footer.jsp" %>
                </footer>

            </body>
            </html>