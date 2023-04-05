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
 * Servlet implementation class LoginController
 */
//유저 로그인 Controller - 김용건
@WebServlet("/login.member")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		String userPwd = request.getParameter("password");
		
		Member memberLogin = new MemberService().MemberLogin(userId, userPwd);
		
		if(memberLogin==null) {
			//값넘기기
			HttpSession session = request.getSession();

			session.setAttribute("alertMsg", "아이디와 비밀번호를 다시한번 확인해주세요");
			
			//setAttribute("이름", "값");
			//주소 넘기기
			response.sendRedirect(request.getContextPath());	
			
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", memberLogin);
			session.setAttribute("loginDone", memberLogin.getUserName()+"님 환영합니다.");
			
			response.sendRedirect(request.getContextPath());
			
		}
	}

}
