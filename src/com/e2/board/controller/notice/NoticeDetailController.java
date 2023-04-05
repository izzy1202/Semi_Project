package com.e2.board.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.board.model.dao.BoardDao;
import com.e2.board.model.service.BoardService;
import com.e2.board.model.vo.Attachment;
import com.e2.board.model.vo.Board;
import com.e2.common.JDBCTemplate;

/**
 * Servlet implementation class NoticeDetailController
 */
//공지사항글 목록 클릭시 세부내용- 추지은
@WebServlet("/NoticeDetail.bd")
public class NoticeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//> 글번호 정보
		int boardNo=Integer.parseInt(request.getParameter("bno"));
		//System.out.println("번호넘겨옴?"+boardNo);
		
		//>카테정보
		int bCategoryNo=Integer.parseInt(request.getParameter("bcate"));
		//System.out.println("카테넘겨옴?"+bCategoryNo);
		
	
		// ~ 조회수 증가 시키고 
     int result=new BoardService().increaseNoticeCount(boardNo,bCategoryNo); //먼저 조회수를 증가시켜준다
				                  
      if(result>0) {  //조회수 증가에 성공했다면
				
	 //게시글 조회메소드 호출
	 Board b=new BoardService().getNoticeDetail(boardNo,bCategoryNo);
	 		
	//첨부파일 조회 메소드 호출
	 Attachment at = new BoardService().selectAttachment(boardNo);
	
	 request.setAttribute("board", b);
	 request.setAttribute("at", at);
	 request.getRequestDispatcher("/view/board/boardDetailView.jsp").forward(request, response);
	           
      }
   
   
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
