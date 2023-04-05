package com.e2.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.e2.common.JDBCTemplate;
import com.e2.product.model.dao.ProductDao;
import com.e2.product.model.vo.Category;
import com.e2.product.model.vo.PageInfo;
import com.e2.product.model.vo.Product;
import com.e2.product.model.vo.ProductComment;

// 상품 Service - 유원호
public class ProductService {

	// 사용자 요청 페이지 상품목록 메소드
	public ArrayList<Product> productSelectList(PageInfo pageInfo, int cNo) {
		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Product> list = new ProductDao().productSelectList(conn, pageInfo, cNo);

		JDBCTemplate.close(conn);

		return list;
	}

	// 카테고리 목록 조회
	public ArrayList<Category> productSelectCategoryList() {

		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Category> cList = new ProductDao().productSelectCategoryList(conn);

		JDBCTemplate.close(conn);

		return cList;
	}

	// 베스트 TOP5 조회
	public ArrayList<Product> productTopList() {

		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Product> list = new ProductDao().productTopList(conn);

		JDBCTemplate.close(conn);

		return list;
	}

	// 상세페이지 상품 조회
	public Product ProductGet(int pNo) {

		Connection conn = JDBCTemplate.getConnection();

		Product product = new ProductDao().ProductGet(conn, pNo);

		JDBCTemplate.close(conn);

		return product;
	}

	// 카테고리별 상품 총 갯수 조회
	public int productSelectListCount(int cNo) {

		Connection conn = JDBCTemplate.getConnection();

		int count = new ProductDao().productSelectListCount(conn, cNo);

		JDBCTemplate.close(conn);

		return count;
	}

	// 상품 조회수 증가 메소드
	public int productIncreaseCount(int pNo) {

		Connection conn = JDBCTemplate.getConnection();

		int result = new ProductDao().productIncreaseCount(conn, pNo);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

	// 상세페이지 상품 코맨트 등록
	public int productCmInsert(ProductComment pdCm) {

		Connection conn = JDBCTemplate.getConnection();

		int result = new ProductDao().productCmInsert(conn, pdCm);

		if (result > 0) {
			JDBCTemplate.commit(conn);

		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

	// 상세 페이지 상품 코맨트 리스트 조회
	public ArrayList<ProductComment> productCmList(int pNo) {

		Connection conn = JDBCTemplate.getConnection();

		ArrayList<ProductComment> cmList = new ProductDao().productCmList(conn, pNo);

		JDBCTemplate.close(conn);

		return cmList;
	}

	// 상세페이지 상품 코맨트 삭제
	public int productCmDelete(int cmNo) {

		Connection conn = JDBCTemplate.getConnection();

		int result = new ProductDao().productCmDelete(conn, cmNo);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

	// 상세페이지 상품 코맨트 갯수 조회
	public int productCmListCount(int pNo) {

		Connection conn = JDBCTemplate.getConnection();

		int count = new ProductDao().productCmListCount(conn, pNo);

		JDBCTemplate.close(conn);

		return count;
	}
	
	//메인 베스트셀러- 이지은
	public ArrayList<Product> MainTopList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product> list = new ProductDao().MainTopList(conn);

		JDBCTemplate.close(conn);

		return list;
	}

}
