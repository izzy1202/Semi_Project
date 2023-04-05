package com.e2.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.product.model.service.ProductService;
import com.e2.product.model.vo.ProductComment;

/**
 * Servlet implementation class ProductInsertController
 */

//상품 코맨트 등록
@WebServlet("/ProductCommentInsert.pd")
public class ProductCmInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ProductCmInsertController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 인코딩 하기
		request.setCharacterEncoding("UTF-8");

		// 상품 번호 가져오기
		int pNo = Integer.parseInt(request.getParameter("pdPno"));

		// 상품 코맨트 값 가져오기
		String name = request.getParameter("comment_name");
		String pwd = request.getParameter("comment_pwd");
		String content = request.getParameter("comment_message");

		// 상품 코맨트 객체 생성
		ProductComment pdCm = new ProductComment();

		// 상품 코맨트 객체에 값 넣기
		pdCm.setCmName(name);
		pdCm.setCmPwd(pwd);
		pdCm.setCmContent(content);
		pdCm.setCmPdNo(pNo);

		// 상품 코맨트 등록하기
		int result = new ProductService().productCmInsert(pdCm);

		if (result > 0) {
			// 해당 상품 상세페이지로 이동
			response.sendRedirect(request.getContextPath() + "/ProductGet.pd?pdPno=" + pNo);
		} else {
			request.setAttribute("errorMsg", "등록이 실패했습니다.");
			request.getRequestDispatcher("/view/common/errorPage.jsp").forward(request, response);
		}

	}

}