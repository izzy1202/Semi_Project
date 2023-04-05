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
 * Servlet implementation class InquiryAdminGetController
 */
//관리자가 전체 리스트 볼때- 우도균
@WebServlet("/InquiryAdminGet")
public class InquiryAdminGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryAdminGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				int categoryNo = 2;
				//int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
				int currentPage; //현재 페이지(즉,사용자가 요청한 페이지)
				
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
				
				//페이징 처리 구문 VO 생성자에 넣고 생성시에 작업 되도록 
				PageInfo pi = new PageInfo(currentPage);
				
				//패이징을 통한 리스트 얻기
				ArrayList<Board> list = new BoardService().selectList(pi,categoryNo);
				request.getSession().setAttribute("pi", pi);
				request.getSession().setAttribute("list", list);
				if(!list.isEmpty()) {
					request.getRequestDispatcher("/view/board/adminBoard.jsp").forward(request, response);
				}else {
					request.setAttribute("errorMsg", "admin페이지 오류");
					request.getRequestDispatcher("/view/common/errorPage.jsp").forward(request, response);
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
