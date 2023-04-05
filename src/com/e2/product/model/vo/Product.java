package com.e2.product.model.vo;

import java.sql.Date;

// 상품 VO - 유원호
public class Product {

	private int pdPno; // 상품코드 PRODUCT_NO
	private int pdCno; // 카테고리 코드 CATEGORY_NO
	private String pdCname; // 카테고리 이름 CATEGORY_NAME
	private String pdName; // 상품명 PRODUCT_NAME
	private String pdPrice; // 가격 PRODUCT_PRICE
	private int pdStock; // 재고 PRODUCT_STOCK
	private int pdDiscount; // 할인율 PRODUCT_DISCOUNT INT NOT NULL,
	private Date pdDate; // 등록일자 PRODUCT_DATE
	private String pdDesc; // 상품설명 PRODUCT_DESC
	private int pdCount; // 조회수 PRODUCT_COUNT
	private String statu; // 상태값 STATUS

	// 사진게시판 썸네일에 필요한 필드변수
	private String titleImg; // FILE_PATH || SAVE_NAME "TITLEIMG"

	// 기본 생성자 - 유원호
	public Product() {
		super();
	}

	// getter-setter 전체
	public int getPdPno() {
		return pdPno;
	}

	public void setPdPno(int pdPno) {
		this.pdPno = pdPno;
	}

	public int getPdCno() {
		return pdCno;
	}

	public void setPdCno(int pdCno) {
		this.pdCno = pdCno;
	}

	public String getPdCname() {
		return pdCname;
	}

	public void setPdCname(String pdCname) {
		this.pdCname = pdCname;
	}

	public String getPdName() {
		return pdName;
	}

	public void setPdName(String pdName) {
		this.pdName = pdName;
	}

	public String getPdPrice() {
		return pdPrice;
	}

	public void setPdPrice(String pdPrice) {
		this.pdPrice = pdPrice;
	}

	public int getPdStock() {
		return pdStock;
	}

	public void setPdStock(int pdStock) {
		this.pdStock = pdStock;
	}

	public int getPdDiscount() {
		return pdDiscount;
	}

	public void setPdDiscount(int pdDiscount) {
		this.pdDiscount = pdDiscount;
	}

	public Date getPdDate() {
		return pdDate;
	}

	public void setPdDate(Date pdDate) {
		this.pdDate = pdDate;
	}

	public String getPdDesc() {
		return pdDesc;
	}

	public void setPdDesc(String pdDesc) {
		this.pdDesc = pdDesc;
	}

	public int getPdCount() {
		return pdCount;
	}

	public void setPdCount(int pdCount) {
		this.pdCount = pdCount;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	@Override
	public String toString() {
		return "Product [pdPno=" + pdPno + ", pdCno=" + pdCno + ", pdCname=" + pdCname + ", pdName=" + pdName
				+ ", pdPrice=" + pdPrice + ", pdStock=" + pdStock + ", pdDiscount=" + pdDiscount + ", pdDate=" + pdDate
				+ ", pdDesc=" + pdDesc + ", pdCount=" + pdCount + ", statu=" + statu + ", titleImg=" + titleImg + "]";
	}

}
