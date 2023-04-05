package com.e2.board.controller.faq;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.board.model.service.BoardService;
import com.e2.board.model.vo.Board;

/**
 * Servlet implementation class FaqUpdateFormController
 */
//faq 수정버튼 완료시- 추지은
@WebServlet("/FaqUpdateForm.bd")
public class FaqUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int boardNo=Integer.parseInt(request.getParameter("bno"));
		//System.out.println(boardNo);
		
		Board b=new BoardService().getFaqUpdateForm(boardNo);
		
		//System.out.println("업데이트폼까지 넘어왔는지용?"+b);
		request.setAttribute("b",b);
		request.getRequestDispatcher("/view/board/faqUpdate.jsp").forward(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
