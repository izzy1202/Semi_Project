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

//메인 베스트셀러 - 이지은
@WebServlet("/ProductGetList.main")
public class IndexGetListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public IndexGetListController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 베스트 목록 조회해 오기
		ArrayList<Product> topList = new ProductService().MainTopList();

		// request 에 값 넣기
		request.setAttribute("topList", topList);
		response.setContentType("application/json; charset=UTF-8"); 
		new Gson().toJson(topList,response.getWriter());
	
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
