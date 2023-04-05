package com.e2.board.controller.notice;

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
import com.google.gson.Gson;

/**
 * Servlet implementation class NoticeSearch
 */
@WebServlet("/NoticeSearch.bd")
public class NoticeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		int categoryNo=Integer.parseInt(request.getParameter("categoryNo"));
		String searchContent=request.getParameter("searchContent");
		int currentPage=Integer.parseInt(request.getParameter("currentPage")); 
		int listCount=new BoardService().noticeSearchCount(categoryNo,searchContent); //카테고리번호와,검색내용을 가지고 해당하는 목록개수를 세옴(select지만 반환은 int)
		
		PageInfo pi=new PageInfo(listCount,currentPage); 
		

		ArrayList<Board> list=new BoardService().noticeSearchGet(pi,categoryNo,searchContent); //페이징정보,카테고리번호,검색내용 해당하는 리스트 가져옴
		
		request.getSession().setAttribute("pi", pi);
		request.getSession().setAttribute("list",list);
	
		 //System.out.println("1109 컨트롤러 넘어오는지 확인용"+list);
		
		if(!list.isEmpty()){	
		   request.getRequestDispatcher("/view/board/boardSearch.jsp").forward(request,response);
		}
		
		
		/*
		 * response.setContentType("application/json; charset=UTF-8");
		 * new Gson().toJson(list,response.getWriter());
		 */
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
