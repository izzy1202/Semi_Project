package com.e2.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e2.product.model.service.ProductService;
import com.e2.product.model.vo.Category;
import com.e2.product.model.vo.PageInfo;
import com.e2.product.model.vo.Product;
import com.google.gson.Gson;

/**
 * Servlet implementation class ProductGetListController
 */

//상품 목록 조회 - 유원호
@WebServlet("/ProductGetList.pd")
public class ProductGetListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ProductGetListController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 현재 페이지
		int curPage = 1;
		
		// 카테고리 번호
		int cNo = 0;

		try {
			// 현제 페이지 값 가져오기
			curPage = Integer.parseInt(request.getParameter("curPage"));

			// 카테고리 번호 값 가져오기
			cNo = Integer.parseInt(request.getParameter("category"));

			// 카테고리 번호 request 에 넣기
			request.setAttribute("category", cNo);
		} catch (Exception e) {

		}

		// 페이징 객체 생성(현재 페이지, 카테고리 번호)
		PageInfo pageInfo = new PageInfo(curPage, cNo);

		// 현재 사용자가 요청한 페이지에 대해 보여질 게시글 리스트 조회해 오기
		ArrayList<Product> list = new ProductService().productSelectList(pageInfo, cNo);

		// 카테고리 목록 조회해 오기
		ArrayList<Category> cList = new ProductService().productSelectCategoryList();

		// 베스트 목록 조회해 오기
		ArrayList<Product> topList = new ProductService().productTopList();

		// request 에 값 넣기
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("list", list);
		request.setAttribute("cList", cList);
		request.setAttribute("topList", topList);

		// 상품 목록 페이지에 뿌리기
		request.getRequestDispatcher("/view/product/PD_0010.jsp").forward(request, response);
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
