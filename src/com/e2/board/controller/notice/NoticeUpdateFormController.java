package com.e2.board.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.board.model.service.BoardService;
import com.e2.board.model.vo.Attachment;
import com.e2.board.model.vo.Board;

/**
 * Servlet implementation class NoticeUpdateFormController
 */

//공지사항 상세글에서 수정버튼 클릭시 수정폼에 띄워줌- 추지은 
@WebServlet("/NoticeUpdateForm.bd")
public class NoticeUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	   int boardNo=Integer.parseInt(request.getParameter("bno"));
	   
	   	   
		Board b=new BoardService().getNoticeUpdateForm(boardNo);
		
		Attachment at=new BoardService().selectAttachment(boardNo); 	
		
				
		request.setAttribute("b", b);
		request.setAttribute("at", at);
		request.getRequestDispatcher("/view/board/boardUpdate.jsp").forward(request, response);		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
