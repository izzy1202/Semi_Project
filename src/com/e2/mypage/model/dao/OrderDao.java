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
import com.e2.mypage.model.vo.Order;

public class OrderDao {

	private Properties prop = new Properties();

	public OrderDao() {
		String filePath = OrderDao.class.getResource("/db/sql/mypage-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 주문내역 리스트
	public ArrayList<Order> orderGetList(Connection conn, int userNo) {
		ArrayList<Order> oList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("orderGetList");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				// ORDER_DATE, ORDER_NO, PRODUCT_NAME, ORDER_STATUS, ORDER_COUNT, PRODUCT_PRICE
				// ORDER_COUNT는 주문한 상품 개수 PRODUCT_COUNT 빌려쓰기
				oList.add(new Order(rset.getDate("ORDER_DATE"), rset.getInt("ORDER_NO"), rset.getString("PRODUCT_NAME"),
						rset.getString("ORDER_STATUS"), rset.getInt("ORDER_COUNT"), rset.getInt("PRODUCT_PRICE"),
						rset.getString("SAVE_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return oList;
	}

	// 주문상세 내역 리스트
	public ArrayList<Order> orderGetDetailList(Connection conn, int orderNo) {
		ArrayList<Order> orderDetailList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("orderGet");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderNo);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				orderDetailList.add(new Order(rset.getInt("PRODUCT_NO"), rset.getString("PRODUCT_NAME"),
						rset.getInt("PRODUCT_COUNT"), rset.getInt("PRODUCT_PRICE"), rset.getInt("ORDER_DETAIL_NO"),
						rset.getString("SAVE_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return orderDetailList;
	}

	// 주문정보
	public Order orderGetInfo(Connection conn, int orderNo) {
		Order o = new Order();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("orderGetInfo");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				o = new Order(rset.getString("RECEVER_NAME"), rset.getString("RECEVER_PHONE"),
						rset.getString("ADDRESS"), rset.getInt("PRODUCT_PRICE"), rset.getString("ORDER_STATUS"),
						rset.getDate("ORDER_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return o;
	}

	// 주문취소
	public int orderDelete(Connection conn, int orderNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("orderDelete");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int orderInfoInsert(Connection conn, int userNo, String address, String receverName, String receverPhone) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("orderInfoInsert");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setString(2, address);
			pstmt.setString(3, receverName);
			pstmt.setString(4, receverPhone);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int orderDetailInsert(Connection conn, int productNo, int productCount, int totalPrice) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("orderDetailInsert");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			pstmt.setInt(2, productCount);
			pstmt.setInt(3, totalPrice);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 마이페이지 1개월 주문내역 - 이지은
	public ArrayList<Order> mypageOrderList(Connection conn, int userNo) {
		ArrayList<Order> oList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("orderGetList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				// ORDER_DATE, ORDER_NO, PRODUCT_NAME, ORDER_STATUS, ORDER_COUNT, PRODUCT_PRICE
				// ORDER_COUNT는 주문한 상품 개수 PRODUCT_COUNT 빌려쓰기
				oList.add(new Order(rset.getDate("ORDER_DATE"), rset.getInt("ORDER_NO"), rset.getString("PRODUCT_NAME"),
						rset.getString("ORDER_STATUS"), rset.getInt("ORDER_COUNT"), rset.getInt("PRODUCT_PRICE"),
						rset.getString("SAVE_NAME")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return oList;
	}

}
