package com.e2.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.product.model.service.ProductService;
import com.e2.product.model.vo.ProductComment;

/**
 * Servlet implementation class ProductCmDeleteController
 */

// 상품 코맨트 삭제 (ajax)
@WebServlet("/ProductCmDelte.pd")
public class ProductCmDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductCmDeleteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 상품 코맨트 번호 값 가져오기
		int cmNo = Integer.parseInt(request.getParameter("cmNo"));

		// 상품 코맨트 삭제하기
		int result = new ProductService().productCmDelete(cmNo);
		
		// 상품 번호 값 가져오기
		int pNo = Integer.parseInt(request.getParameter("pdPno"));
		
		// 코맨트 리스트 조회
		ArrayList<ProductComment> cmList = new ProductService().productCmList(pNo);
		
		// 코맨트 리스트 갯수 조회
		int cmCount = new ProductService().productCmListCount(pNo);
		
		// request 에 값 넣기
		request.setAttribute("cmCount", cmCount);
		request.setAttribute("cmList", cmList);
		
		// ajax 코맨트 form 에 값 뿌리기
		request.getRequestDispatcher("/view/product/PD_0021.jsp").forward(request, response);
		
		
	}

}
