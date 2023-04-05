package com.e2.board.controller.faq;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.board.model.dao.BoardDao;
import com.e2.board.model.service.BoardService;
import com.e2.board.model.vo.Board;

/**
 * Servlet implementation class FaqSearch
 */
@WebServlet("/FaqSearch.bd")
public class FaqSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String searchContent=request.getParameter("searchContent");
		//System.out.println("2시 넘어왔는지"+searchContent); 
		
		ArrayList<Board> list=new BoardService().faqSearch(searchContent);
		
		
		//System.out.println("서치 리스트넘어오나요"+list);
		
		
		request.getSession().setAttribute("list",list);
		if(!list.isEmpty()) {
			request.getRequestDispatcher("/view/board/faqSearch.jsp").forward(request,response);
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
