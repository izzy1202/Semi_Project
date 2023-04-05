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
import com.e2.mypage.model.vo.Order;
import com.e2.user.model.vo.Member;

/**
 * Servlet implementation class GetCartList
 */
// 장바구니 목록 조회 - 박혜영
@WebServlet("/cartGetList.my")
public class CartGetListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartGetListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("loginUser") == null) {
			session.setAttribute("alertMsg", "로그인 후 가능한 서비스입니다.");
			response.sendRedirect(request.getContextPath());
		} else {
			Member m = (Member) session.getAttribute("loginUser");
			int userNo = m.getUserNo();
			ArrayList<Cart> cList = new CartService().cartGetList(userNo);

			if (cList != null) {
				request.setAttribute("cList", cList);
				request.getRequestDispatcher("/view/mypage/MY_0050.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMsg", "장바구니 불러오기에 실패했습니다.");
				RequestDispatcher view = request.getRequestDispatcher("view/common/errorPage.jsp");
				view.forward(request, response);
			}
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
