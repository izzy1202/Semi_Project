package com.e2.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.board.model.service.BoardService;
import com.e2.product.model.dao.ProductDao;
import com.e2.product.model.service.ProductService;
import com.e2.product.model.vo.Product;
import com.e2.product.model.vo.ProductComment;

/**
 * Servlet implementation class ProductGet
 */

//상품 상세 페이지 - 유원호
@WebServlet("/ProductGet.pd")
public class ProductGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ProductGetController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 상품 번호 값 가져오기
		int pNo = Integer.parseInt(request.getParameter("pdPno"));

		// 조회수 증가 시키기
		int result = new ProductService().productIncreaseCount(pNo);

		String errMsg = "";

		if (result > 0) {
			// 상세페이지 조회
			Product product = new ProductService().ProductGet(pNo);

			// 상세페이지 코맨트 리스트 조회
			ArrayList<ProductComment> cmList = new ProductService().productCmList(pNo);

			// 상세페이지 코맨트 갯수 조회
			int cmCount = new ProductService().productCmListCount(pNo);

			if (cmList != null) {
				// request 에 값 넣기
				request.setAttribute("cmList", cmList);
				request.setAttribute("cmCount", cmCount);
			}

			if (product != null) {
				// request 에 값 넣기
				request.setAttribute("product", product);
			} else {
				errMsg = "상품 정보가 없습니다.";
			}

		} else {
			errMsg = "조회수 UDADTE에 실패하였습니다.";
		}

		if (errMsg != "") {
			request.setAttribute("errorMsg", errMsg);
			request.getRequestDispatcher("/view/common/errorPage.jsp").forward(request, response);
		} else {
			// 상세페이지로 값 보내기
			request.getRequestDispatcher("/view/product/PD_0020.jsp").forward(request, response);
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