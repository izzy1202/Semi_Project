package com.e2.mypage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.e2.common.JDBCTemplate;
import com.e2.mypage.model.dao.OrderDao;
import com.e2.mypage.model.vo.Order;

public class OrderService {

	public ArrayList<Order> orderGetList(int userNo) {
		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Order> oList = new OrderDao().orderGetList(conn, userNo);

		JDBCTemplate.close(conn);
		return oList;
	}

	public ArrayList<Order> orderGetDetailList(int orderNo) {
		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Order> o = new OrderDao().orderGetDetailList(conn, orderNo);
		JDBCTemplate.close(conn);
		return o;
	}

	public Order orderGetInfo(int orderNo) {
		Connection conn = JDBCTemplate.getConnection();

		Order o = new OrderDao().orderGetInfo(conn, orderNo);
		JDBCTemplate.close(conn);
		return o;
	}

	public int orderDelete(int orderNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new OrderDao().orderDelete(conn, orderNo);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);

		return result;
	}

	public int orderInsert(int productNo, int productCount, int userNo, String address, String receverName, String receverPhone, int totalPrice) {
		Connection conn = JDBCTemplate.getConnection();
		int resultInfo = new OrderDao().orderInfoInsert(conn, userNo, address, receverName, receverPhone);
		int resultDetail = new OrderDao().orderDetailInsert(conn, productNo, productCount, totalPrice);

		if (resultInfo * resultDetail > 0) {
			if (resultInfo > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			JDBCTemplate.close(conn);
		}
		return resultInfo * resultDetail;
	}
	
	//마이페이지 1개월 주문내역 - 이지은
	public ArrayList<Order> mypageOrderList(int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Order> oList = new OrderDao().mypageOrderList(conn,userNo);
		JDBCTemplate.close(conn);
		return oList;
	}
}
