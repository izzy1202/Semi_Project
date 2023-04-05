package com.e2.mypage.model.vo;

import java.sql.Date;

public class Order {
	private int orderNo; 		// ORDER_NO // USER_ORDER && USER_ORDER_DETAIL
	private int userNo;			// USER_NO
	private Date orderDate;		// ORDER_DATE
	private String address;		// ADDRESS
	private String receverName;	// RECEVER_NAME
	private String receverPhone;// RECEVER_PHONE
	private String orderStatus;	// ORDER_STATUS

	private int orderDetailNo;	// ORDER_DETAIL_NO
	private int productNo;		// PRODUCT_NO
	private String productName; // join해서 가져올 이름
	private int productCount;	// PRODUCT_COUNT
	private int productPrice;	// PRODUCT_PRICE
	private String saveName;	// join해서 가져올 saveName

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderNo, int userNo, Date orderDate, String address, String receverName, String receverPhone,
			String orderStatus) {
		super();
		this.orderNo = orderNo;
		this.userNo = userNo;
		this.orderDate = orderDate;
		this.address = address;
		this.receverName = receverName;
		this.receverPhone = receverPhone;
		this.orderStatus = orderStatus;
	}

	public Order(int orderNo, int orderDetailNo, int productNo, String productName, int productCount, int productPrice) {
		super();
		this.orderNo = orderNo;
		this.orderDetailNo = orderDetailNo;
		this.productNo = productNo;
		this.productName = productName;
		this.productCount = productCount;
		this.productPrice = productPrice;
	}

	public Order(Date orderDate, int orderNo, String productName, String orderStatus, int productCount, int productPrice, String saveName) {
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.productName = productName;
		this.productCount = productCount;
		this.productPrice = productPrice;
		this.saveName = saveName;
	}
	
	public Order(int productNo, String productName, int productCount, int productPrice, int orderDetailNo, String saveName) {
		this.productNo = productNo;
		this.productName = productName;
		this.productCount = productCount;
		this.productPrice = productPrice;
		this.orderDetailNo = orderDetailNo;
		this.saveName = saveName;
	}
	
	public Order(String receverName, String receverPhone, String address, int productPrice, String orderStatus, Date orderDate) {
		this.receverName = receverName;
		this.receverPhone = receverPhone;
		this.address = address;
		this.productPrice = productPrice;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReceverName() {
		return receverName;
	}

	public void setReceverName(String receverName) {
		this.receverName = receverName;
	}

	public String getReceverPhone() {
		return receverPhone;
	}

	public void setReceverPhone(String receverPhone) {
		this.receverPhone = receverPhone;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getOrderDetailNo() {
		return orderDetailNo;
	}

	public void setOrderDetailNo(int orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	

}
