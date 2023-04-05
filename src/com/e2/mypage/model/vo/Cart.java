package com.e2.mypage.model.vo;

public class Cart {
	private int cartNo;
	private int productNo;
	private int userNo;
	private int productCount;

	private String productName;
	private String saveName;
	private int productPrice;
	private int paymentPrice;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartNo, int productNo, int userNo, int productCount) {
		super();
		this.cartNo = cartNo;
		this.productNo = productNo;
		this.userNo = userNo;
		this.productCount = productCount;
	}

	public Cart(int cartNo, int productNo, String productName, int userNo, int productCount, String saveName,
			int productPrice, int paymentPrice) {
		super();
		this.cartNo = cartNo;
		this.productNo = productNo;
		this.productName = productName;
		this.userNo = userNo;
		this.productCount = productCount;
		this.saveName = saveName;
		this.productPrice = productPrice;
		this.paymentPrice = paymentPrice;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	public int getPaymentPrice() {
		return paymentPrice;
	}
	
	public void setPaymentPrice(int paymentPrice) {
		this.paymentPrice = paymentPrice;
	}
}
