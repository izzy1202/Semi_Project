package com.e2.mypage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.e2.common.JDBCTemplate;
import com.e2.mypage.model.dao.CartDao;
import com.e2.mypage.model.dao.OrderDao;
import com.e2.mypage.model.vo.Cart;

public class CartService {

	public ArrayList<Cart> cartGetList(int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Cart> cartList = new CartDao().cartGetList(conn, userNo);
		JDBCTemplate.close(conn);
		return cartList;
	}

	public int cartDelete(int productNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new CartDao().cartDelete(conn, productNo);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int cartInsert(int productNo, int userNo, int productCount) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new CartDao().cartInsert(conn, productNo, userNo, productCount);

		if (result> 0) {
			if (result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int cartSearch(int userNo, int productNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new CartDao().cartSearch(conn, userNo, productNo);

		JDBCTemplate.close(conn);
		return result;
	}
}
