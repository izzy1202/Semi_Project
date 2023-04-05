package com.e2.board.controller.inquiry;

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
 * Servlet implementation class InquiryUpdateFormController
 */
//1대1문의 수정버튼 완료시- 우도균
@WebServlet("/InquiryUpdateForm.bd")
public class InquiryUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int bno = Integer.parseInt(request.getParameter("bno"));
//		Board b = new BoardService().InquiryUpdateForm(bno);
//		
//		request.getSession().setAttribute("b", b);
		
		int boardNo=Integer.parseInt(request.getParameter("bno"));
		   
	   	   
		Board b=new BoardService().getNoticeUpdateForm(boardNo);
		
		Attachment at=new BoardService().selectAttachment(boardNo); 	
		
		String str = b.getBoardContent();
		str = str.replace("<br/>","\r\n");
		
		b.setBoardContent(str);
				
		request.setAttribute("b", b);
		request.setAttribute("at", at);
		
		
//		request.getRequestDispatcher("/view/board/boardUpdate.jsp").forward(request, response);	
		
		//제일 중요
		request.getRequestDispatcher("/view/board/edit.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
