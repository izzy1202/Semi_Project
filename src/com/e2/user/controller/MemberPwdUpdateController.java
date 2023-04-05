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

/**
 * Servlet implementation class MemberPwdFindController
 */
@WebServlet("/MemberPwdUpdate.member")
public class MemberPwdUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPwdUpdateController() {
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
		
		
		String userId = request.getParameter("userId");
		String updatePwd = request.getParameter("updatePwd");
		String userPwd = new MemberService().findPwd(userId);
		int result = 0;
		// userPwd가 없으면 아이디가 없는거 
		if(userPwd != null) {
			result = new MemberService().updatePwd(userId,updatePwd);
			if(result>0) {
				request.setAttribute("msg", "비밀번호 변경에 성공하셨습니다.");
				request.getRequestDispatcher("/view/mypage/MY_0020.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "비밀번호 변경에 실패하셨습니다.");
				request.getRequestDispatcher("/view/mypage/MY_0020.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("msg", "비밀번호 변경에 실패하셨습니다.");
			request.getRequestDispatcher("/view/mypage/MY_0020.jsp").forward(request, response);
		}
		
	}

}
