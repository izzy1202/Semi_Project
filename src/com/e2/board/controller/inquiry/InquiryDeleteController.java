package com.e2.board.controller.inquiry;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.board.model.service.BoardService;

/**
 * Servlet implementation class InquiryDeleteController
 */
//1대1문의 삭제- 우도균
@WebServlet("/InquiryDelete.bd")
public class InquiryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		int result = new BoardService().InquiryDelete(bno);
		if(result >0) {
			request.getRequestDispatcher("/InquiryGet.bd?currentPage=1").forward(request, response);
		}else {
			request.setAttribute("errorMsg", "InquiryDeleteController 문제입니다.");
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
