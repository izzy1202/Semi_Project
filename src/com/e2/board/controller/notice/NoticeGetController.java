package com.e2.board.controller.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e2.board.model.service.BoardService;
import com.e2.board.model.vo.Board;
import com.e2.board.model.vo.PageInfo;

/**
 * Servlet implementation class NoticeGetController
 */
//공지사항 리스트 조회- 추지은
@WebServlet("/NoticeGetController.bd")
public class NoticeGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int bCategoryNo=Integer.parseInt(request.getParameter("bcate"));		
		
		
				int currentPage=Integer.parseInt(request.getParameter("currentPage"));
				PageInfo pi = new PageInfo(currentPage);	
				
				
		ArrayList<Board> list=new BoardService().getNoticeGet(bCategoryNo, pi);
		//System.out.println(list);		
	
		
		
				request.setAttribute("list", list);
				request.setAttribute("pi", pi);
				
				request.getRequestDispatcher("/view/board/boardView.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
