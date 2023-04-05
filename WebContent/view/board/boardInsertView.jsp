<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.e2.board.model.vo.Board
                                 ,com.e2.user.model.vo.Member" %>
    
 <% 
   
     Board b=(Board)request.getAttribute("board");
     
 %>   
    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
    <link rel="stylesheet" href="resources/css/bcss.css">
</head>

<body>
    <div class="board_wrap">
       <form action="<%=request.getContextPath() %>/NoticeInsert.bd" method="post" id="enrollform"> 
 
        <div class="board_title">
            <strong>공지사항 작성</strong>
            <p>서점 공지사항</p>
        </div>
        <div class="board_write_wrap">
            <div class="board_write">
                <div class="title">
                    <dl>
                        <dt>제목</dt>
                        <dd><input type="text" name="title" value="title" placeholder="제목 입력"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt>글쓴이</dt>
                        <dd><input type="text" name=userName value="userName" placeholder="글쓴이 입력"></dd>
                    </dl>
                    <dl>
                        <dt>비밀번호</dt>
                        <dd><input type="password" placeholder="비밀번호 입력"></dd>
                    </dl>
                </div>
                <div class="cont">
                    <textarea name="content" value="content" placeholder="내용 입력"></textarea>
                </div>
            </div>
            <div class="bt_wrap">
                <a href="<%=request.getContextPath() %>/NoticeInsert.bd" class="on">등록</a>
                <a href="<%=request.getContextPath() %>/NoticeGetController.bd?bcate=1&currentPage=1">취소</a>
            </div>
        </div>
      </form>
    </div>
</body>

</html>