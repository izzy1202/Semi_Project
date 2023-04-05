package com.e2.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e2.mypage.model.dao.OrderDao;
import com.e2.mypage.model.service.OrderService;
import com.e2.user.model.vo.Member;

/**
 * Servlet implementation class OrderDeleteController
 */
@WebServlet("/OrderDelete.my")
public class OrderDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderDeleteController() {
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
			int orderNo = Integer.parseInt(request.getParameter("ono"));
			int result = new OrderService().orderDelete(orderNo);

			if (result > 0) {
				session.setAttribute("alertMsg", "주문 취소가 완료되었습니다.");
				response.sendRedirect(request.getContextPath() + "/orderGet.my?ono=" + orderNo);
			} else {
				request.setAttribute("errorMsg", "주문상세 페이지를 가져오는데 실패했습니다.");
				request.getRequestDispatcher("/view/common/errorPage.jsp").forward(request, response);
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
