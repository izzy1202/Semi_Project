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
import com.e2.board.model.vo.BoardAttachment;

/**
 * Servlet implementation class InquiryDetailController
 */
//1대1문의글 목록 클릭시 세부내용- 우도균
@WebServlet("/InquiryDetail.bd")
public class InquiryDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		Board b = new BoardService().InquiryDetail(bno);
		ArrayList<BoardAttachment> list = null;
		
		if(b != null) {
			list = new BoardService().selectAttachmentList(bno);
			request.getSession().setAttribute("b", b);
			request.getSession().setAttribute("list", list);
			request.getRequestDispatcher("/view/board/view.jsp").forward(request, response);
		}else {
			request.setAttribute("errorMsg", "InquiryDetailController 문제입니다.");
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
