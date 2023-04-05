package com.e2.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e2.mypage.model.service.CartService;
import com.e2.mypage.model.service.OrderService;
import com.e2.user.model.vo.Member;

/**
 * Servlet implementation class InsertCart
 */
//장바구니 추가- 박혜영
@WebServlet("/CartInsert.pd")
public class CartInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		if (session.getAttribute("loginUser") == null) {
			session.setAttribute("alertMsg", "로그인 후 가능한 서비스입니다.");
			response.sendRedirect(request.getHeader("referer"));
		} else {
			Member m = (Member) session.getAttribute("loginUser");
			int userNo = m.getUserNo();
			int productNo = Integer.parseInt(request.getParameter("productNo"));
			int productCount = Integer.parseInt(request.getParameter("quantity"));

			int searchResult = new CartService().cartSearch(userNo, productNo);

			int result = 0;
			
			if (searchResult > 0) {
				session.setAttribute("alertMsg", "이미 장바구니에 담겨 있는 상품입니다.");
				response.sendRedirect(request.getHeader("referer"));
			} else {
				result = new CartService().cartInsert(productNo, userNo, productCount);

				if (result > 0) {
					session.setAttribute("alertMsg", "상품을 장바구니에 담았습니다.");
					response.sendRedirect(request.getHeader("referer"));
				} else {
					request.setAttribute("errorMsg", "상품 주문에 실패했습니다.");
					RequestDispatcher view = request.getRequestDispatcher("view/common/errorPage.jsp");
					view.forward(request, response);
				}
			}
		}
	}

}
