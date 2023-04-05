package com.e2.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.mypage.model.service.CartService;

/**
 * Servlet implementation class CartDelete
 */
// 장바구니 삭제 Controller - 박혜영
@WebServlet("/CartDelete.my")
public class CartDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartDeleteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productNo = Integer.parseInt(request.getParameter("pdNo"));
		
		int result = new CartService().cartDelete(productNo);
		
		if (result > 0) {
			response.sendRedirect(request.getContextPath() + "/cartGetList.my");
		} else {
			request.setAttribute("errorMsg", "장바구니 목록을 가져오는데 실패했습니다.");
			request.getRequestDispatcher("/view/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
