package com.e2.board.controller.inquiry;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.board.model.service.BoardService;

/**
 * Servlet implementation class InquiryAdminDeleteController
 */
//관리자가 글 여러개 삭제 할때- 우도균
@WebServlet("/InquiryAdminDelete.bd")
public class InquiryAdminDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryAdminDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectArray = request.getParameter("selectArray");
		System.out.println(selectArray);
		String[] selectArrays = selectArray.split(",");
		int result = new BoardService().InquiryAdminDelete(selectArrays);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/InquiryAdminGet?currentPage=1");
		}else {
			request.setAttribute("errorMsg", "InquiryGet 문제거나 게시판이 비어있습니다.");
			request.getRequestDispatcher("/view/common/errorPage.jsp").forward(request, response);
		}
	}

}
