package com.e2.board.controller.inquiry;

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
 * Servlet implementation class InquiryGetController
 */
//1대1문의 리스트 조회- 우도균
@WebServlet("/InquiryGet.bd")
public class InquiryGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") == null) {
			session.setAttribute("alertMsg", "로그인 후 가능한 서비스입니다.");
			response.sendRedirect(request.getContextPath());
		}else {
		//카테고리 번호를 여기에서 설정해도 문제없어서 설정함
		int categoryNo = 2;
		//int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		
		int currentPage; //현재 페이지(즉,사용자가 요청한 페이지)
		//int listCount = new BoardService().selectListCount();//현재 총 게시글 개수
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		//페이징 처리 구문 VO 생성자에 넣고 생성시에 작업 되도록 
		PageInfo pi = new PageInfo(currentPage);
		
		//패이징을 통한 리스트 얻기
		ArrayList<Board> list = new BoardService().selectList(pi,categoryNo);
		request.getSession().setAttribute("pi", pi);
		request.getSession().setAttribute("list", list);
		System.out.println("asd");
		/* if(!list.isEmpty()) { */
			request.getRequestDispatcher("/view/board/HP_0020.jsp").forward(request, response);
		/*}else {
			request.setAttribute("errorMsg", "InquiryGet 문제거나 게시판이 비어있습니다.");
			request.getRequestDispatcher("/view/common/errorPage.jsp").forward(request, response);
		}*/
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("post");
//		request.setCharacterEncoding("UTF-8");
//		int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
//		ArrayList<Board> list = new BoardService().InquiryGet(categoryNo);
//		request.getSession().setAttribute("list", list);
//		request.getRequestDispatcher("/view/board/list.jsp").forward(request, response);
	}

}
