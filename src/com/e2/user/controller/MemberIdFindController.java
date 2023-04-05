package com.e2.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.e2.user.model.service.MemberService;

/**
 * Servlet implementation class MemberIdFindController
 */
//유저 아이디 찾기 Controller - 김용건
@WebServlet("/idFind.member")
public class MemberIdFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberIdFindController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @return 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		System.out.println(email);
		
		String userId = new MemberService().findId(email);
		System.out.println(userId);
		
		response.setContentType("text/html; charset=UTF-8");
		JSONObject jobj = new JSONObject();
		
		if(userId != null) {
			System.out.println("성공");
			jobj.put("userId",userId);
			jobj.put("msg","success");
			response.setContentType("aplication/json; charset=UTF-8");
			response.getWriter().print(jobj);
		}else {
			System.out.println("실패");
			response.getWriter().print("fail");
		}
		
		
		HttpSession session = request.getSession();
		request.setAttribute("userId", userId);
	}

}
