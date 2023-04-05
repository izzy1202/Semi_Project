package com.e2.board.controller.faq;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.board.model.service.BoardService;
import com.e2.board.model.vo.Board;

/**
 * Servlet implementation class FaqGetController
 */

//faq리스트 조회- 추지은
@WebServlet("/FaqGet.bd")
public class FaqGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //faq 리스트조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//>> Q 카테번호를 어떻게 넘겨올 것인지 고민
		//System.out.println(bCategoryNo);
		int bCategoryNo=Integer.parseInt(request.getParameter("bcate"));
		
		//int bCategoryNo=Integer.parseInt(request.getParameter("category"));
		//System.out.println(bCategoryNo);
		
		//~ 요청처리
		ArrayList<Board> list=new BoardService().getFaqGet(bCategoryNo);
		//System.out.println("faq 잘넘어오나요"+list);		
		
		
		//request.getSession().
		
		//<< 넘김
		request.setAttribute("list", list);
		request.getRequestDispatcher("/view/board/faq.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
