package com.e2.board.controller.inquiry;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.board.model.service.BoardService;
import com.e2.board.model.vo.Board;
import com.e2.board.model.vo.PageInfo;

/**
 * Servlet implementation class SearchGetController
 */
@WebServlet("/SearchGet.bd")
public class SearchGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		String searchText = request.getParameter("searchText");
		int listCount =new BoardService().selectSearchCount(categoryNo,searchText);
		
		PageInfo pi = new PageInfo(listCount,currentPage);
		ArrayList<Board> list = new BoardService().searchGet(pi,categoryNo,searchText);
		//패이징을 통한 리스트 얻기
		request.getSession().setAttribute("pi", pi);
		request.getSession().setAttribute("list", list);
		
		//searchList.jsp로 넘김
		request.getRequestDispatcher("/view/board/searchList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
