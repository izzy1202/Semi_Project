package com.e2.mypage.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.e2.common.JDBCTemplate;
import com.e2.mypage.model.vo.Cart;

public class CartDao {
	private Properties prop = new Properties();

	public CartDao() {
		String filePath = CartDao.class.getResource("/db/sql/mypage-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 장바구니 리스트
	public ArrayList<Cart> cartGetList(Connection conn, int userNo) {
		ArrayList<Cart> cartGetList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("cartGetList");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				cartGetList.add(new Cart(rset.getInt("CART_NO"), rset.getInt("PRODUCT_NO"),
						rset.getString("PRODUCT_NAME"), rset.getInt("USER_NO"), rset.getInt("PRODUCT_COUNT"),
						rset.getString("SAVE_NAME"), rset.getInt("PRODUCT_PRICE"), rset.getInt("PAYMENT_PRICE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(conn);
		}

		return cartGetList;
	}

	public int cartDelete(Connection conn, int productNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("cartDelete");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}

		return result;
	}

	
	public int cartInsert(Connection conn, int productNo, int userNo, int productCount) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("cartInsert");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			pstmt.setInt(2, userNo);
			pstmt.setInt(3, productCount);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int cartSearch(Connection conn, int userNo, int productNo) {
		ResultSet rset = null;
		int count = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("cartSearch");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, productNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				count = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return count;
	}
}
