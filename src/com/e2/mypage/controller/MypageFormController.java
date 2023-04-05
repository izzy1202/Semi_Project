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
import com.e2.user.model.vo.Member;

/**
 * Servlet implementation class MypageFormController
 */

/* [메인] 마이페이지 메인: 이지은 */
@WebServlet("/MypageForm.my")
public class MypageFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MypageFormController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// 마이페이지 메인 띄우기
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("loginUser") == null) {
			session.setAttribute("alertMsg", "로그인 후 가능한 서비스입니다.");
			response.sendRedirect(request.getContextPath());
		} else {
			Member m = (Member) session.getAttribute("loginUser");
			int userNo = m.getUserNo();
			ArrayList<Order> oList = new OrderService().mypageOrderList(userNo);

			if (oList != null) {
				request.setAttribute("oList", oList);
				request.getRequestDispatcher("view/mypage/MY_0010.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMsg", "주문내역 불러오기에 실패했습니다.");
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
