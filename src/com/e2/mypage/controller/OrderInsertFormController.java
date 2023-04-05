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

import com.e2.mypage.model.service.OrderService;
import com.e2.mypage.model.vo.Order;
import com.e2.product.model.vo.Product;
import com.e2.user.model.vo.Member;

/**
 * Servlet implementation class OrderInsertController
 */
//주문하기 - 박혜영 (MY_0020.jsp)
@WebServlet("/orderInsertForm.my")
public class OrderInsertFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderInsertFormController() {
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
			response.sendRedirect(request.getHeader("referer"));
		} else {
			Member m = (Member) session.getAttribute("loginUser");
			request.getRequestDispatcher("/view/mypage/MY_0070.jsp").forward(request, response);
		}
	}
}
