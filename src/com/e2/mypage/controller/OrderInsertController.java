package com.e2.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e2.mypage.model.service.CartService;
import com.e2.mypage.model.service.OrderService;
import com.e2.mypage.model.vo.Cart;
import com.e2.user.model.vo.Member;

/**
 * Servlet implementation class OrderInsertController
 */
//주문하기 - 박혜영 (MY_0020.jsp)
@WebServlet("/orderInsert.my")
public class OrderInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
			response.sendRedirect(request.getContextPath());
		} else {
			Member m = (Member) session.getAttribute("loginUser");
			int userNo = m.getUserNo();

			int productNo = Integer.parseInt(request.getParameter("productNo"));
			int productCount = Integer.parseInt(request.getParameter("productCount"));

			String address = request.getParameter("address");
			String receverName = request.getParameter("receverName");
			String receverPhone = request.getParameter("receverPhone");
			int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
			int result = new OrderService().orderInsert(productNo, productCount, userNo, address, receverName,
					receverPhone, totalPrice);

			if (result > 0) {
				session.setAttribute("alertMsg", "상품 주문에 성공했습니다.");
				response.sendRedirect(request.getContextPath() + "/orderGetList.my");
			} else {
				request.setAttribute("errorMsg", "상품 주문에 실패했습니다.");
				RequestDispatcher view = request.getRequestDispatcher("view/common/errorPage.jsp");
				view.forward(request, response);
			}
		}
	}

}
