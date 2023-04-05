package com.e2.board.controller.faq;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.board.model.service.BoardService;

/**
 * Servlet implementation class FaqUpdateController
 */
//faq 글 수정버튼 클릭시 세부내용 페이지- 추지은
@WebServlet("/FaqUpdate.bd")
public class FaqUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); 
		
		int boardNo=Integer.parseInt(request.getParameter("bno"));
		String boardTitle=request.getParameter("title");
		String boardContent=request.getParameter("content");
		
	     int bCategoryNo=Integer.parseInt(request.getParameter("bcate"));
		
		
		int result=new BoardService().getFaqUpdate(boardNo,boardTitle,boardContent);
		
		if(result>0) {
			response.sendRedirect(request.getContextPath()+"/FaqGet.bd?bcate="+bCategoryNo);		
	   }
		
		
		
		
	}

}
