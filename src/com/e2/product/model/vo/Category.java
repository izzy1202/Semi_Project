package com.e2.product.model.vo;

//상품 카테고리 VO - 유원호
public class Category {

	private int cNo; // 카테고리 코드 CATEGORY_NO
	private String cName; // 카테고리 이름 CATEGORY_NAME
	private String cType; // 카테고리 타입 CATEGORY_TYPE

	// 기본생성자
	public Category() {
		super();
	}

	// getter-setter
	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	// tostring - 유원호
	@Override
	public String toString() {
		return "ProductCategory [cNo=" + cNo + ", cName=" + cName + "]";
	}
}
