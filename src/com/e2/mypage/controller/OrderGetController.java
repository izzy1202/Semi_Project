package com.e2.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class OrderGetController
 */
//주문내역 상세- 박혜영 (MY_0040.jsp)
@WebServlet("/orderGet.my")
public class OrderGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderGetController() {
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
		Member m = (Member) session.getAttribute("loginUser");
		int orderNo = Integer.parseInt(request.getParameter("ono"));

		Order o = new OrderService().orderGetInfo(orderNo);
		ArrayList<Order> orderDetailList = new OrderService().orderGetDetailList(orderNo);
		
		if (session.getAttribute("loginUser") == null) {
			session.setAttribute("alertMsg", "로그인 후 가능한 서비스입니다.");
			response.sendRedirect(request.getHeader("referer"));
		}else if(o != null && orderDetailList !=null) {
			request.setAttribute("o", o);
			request.setAttribute("orderDetailList", orderDetailList);
			request.getRequestDispatcher("/view/mypage/MY_0040.jsp").forward(request, response);
		}else {
			request.setAttribute("errorMsg", "주문상세 페이지를 가져오는데 실패했습니다.");
			request.getRequestDispatcher("/view/common/errorPage.jsp").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
