package com.e2.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.e2.user.model.service.MemberService;
import com.e2.user.model.vo.Member;
import com.google.gson.Gson;

/**
 * Servlet implementation class UserUpdateController
 */
//유저 회원정보 수정 Controller - 김용건
@WebServlet("/InfoUpdate.member")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
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
		
		HttpSession session = request.getSession(); 
		Member u = (Member)session.getAttribute("loginUser");
		String userId = u.getUserId();
		
		String userName = request.getParameter("userName"); 
		String phone = request.getParameter("phone"); 
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		u.setUserName(userName);
		u.setPhone(phone);
		u.setEmail(email);
		u.setAddress(address);
		
		Member updateUser = new MemberService().infoUpdate(u);		
		
		
		if(updateUser != null) {
			System.out.println("완전성공");
			response.getWriter().print("Y");
		}else {
			System.out.println("완전실패");
			response.getWriter().print("N");
		
		}
		
		
		
		
	}
}

