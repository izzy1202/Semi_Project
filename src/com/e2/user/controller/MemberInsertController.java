package com.e2.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e2.user.model.service.MemberService;
import com.e2.user.model.vo.Member;

/**
 * Servlet implementation class MemberInsertController
 */

/*[회원] 회원가입: 이지은*/
@WebServlet("/MemberInsert.do")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		Member m = new Member(userId,userPwd,userName,phone,email,address);
		int result = new MemberService().userInsert(m);
		
		if(result>0) {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원가입이 완료되었습니다. 다시 로그인 해주세요.");
			request.getRequestDispatcher("view/user/US_0020.jsp").forward(request, response);
		}else {
			request.setAttribute("errorMsg", "회원가입에 실패하였습니다.");
			RequestDispatcher view = request.getRequestDispatcher("view/common/errorPage.jsp");
			view.forward(request, response);
			
		}
	}

}
