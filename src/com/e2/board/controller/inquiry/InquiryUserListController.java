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
 * Servlet implementation class InquiryUserList
 */
//1대1문의 자신이 쓴 리스트 보여주기- 우도균
@WebServlet("/InquiryUserList.bd")
public class InquiryUserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryUserListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		System.out.println("user : "+userNo);
		
		//카테고리 번호를 여기에서 설정해도 문제없어서 설정함
				int categoryNo = 2;
				//int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
				
				int listCount;  //현재 총 게시글 개수
				int currentPage; //현재 페이지(즉,사용자가 요청한 페이지)
				int pageLimit; // 페이지 하단에 보여질 페이징바의 페이지 최대 개수
				int boardLimit; // 한 페이지에 보여질 게시글의 최대 개수 (몇개 단위씩 보여질건지)
				
				int maxPage;  //가장 마지막 페이지가 몇번페이지 인지 (총 페이지수)
				int startPage; //페이지 하단에 보여질 페이징바의 시작수
				int endPage; //페이지 하단에 보여질 페이징바의 끝수
				
				//
				listCount = new BoardService().selectListCount(userNo);
				//listCount = new BoardService().selectListCount();
				
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
				
				pageLimit = 10;
				boardLimit = 10;
				maxPage=(int)(Math.ceil(((double)listCount / boardLimit)));
				startPage = (currentPage-1)/pageLimit * pageLimit + 1;
				endPage = startPage + pageLimit - 1; 
				
				if(endPage>maxPage) {
					endPage = maxPage;
				}
				
				PageInfo pi2 = new PageInfo(currentPage);
				PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,
											maxPage,startPage,endPage);
				
				ArrayList<Board> list = new BoardService().selectUserList(pi,categoryNo,userNo);
				request.getSession().setAttribute("pi", pi);
				request.getSession().setAttribute("list", list);
				request.getRequestDispatcher("/view/board/userList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
