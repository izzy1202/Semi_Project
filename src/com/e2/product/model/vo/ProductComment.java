package com.e2.product.model.vo;

// 상품 상세페이지 코맨트 VO - 유원호
public class ProductComment {

	private int cmNo; // 코맨트번호 COMMENT_NO NUMBER
	private String cmContent;// 작성자 COMMENT_CONTENT VARCHAR2
	private String cmName; // 비밀번호 COMMENT_NAME VARCHAR2
	private String cmPwd;// 내용 COMMNET_PWD VARCHAR2
	private int cmPdNo; // 상품코드 PD_NO NUMBER
	private String cmStatus; // 코맨트상태 COMMENT_STAUS VARCHAR2

	public ProductComment() {
		super();
	}

	public int getCmNo() {
		return cmNo;
	}

	public void setCmNo(int cmNo) {
		this.cmNo = cmNo;
	}

	public String getCmContent() {
		return cmContent;
	}

	public void setCmContent(String cmContent) {
		this.cmContent = cmContent;
	}

	public String getCmName() {
		return cmName;
	}

	public void setCmName(String cmName) {
		this.cmName = cmName;
	}

	public String getCmPwd() {
		return cmPwd;
	}

	public void setCmPwd(String cmPwd) {
		this.cmPwd = cmPwd;
	}

	public int getCmPdNo() {
		return cmPdNo;
	}

	public void setCmPdNo(int cmPdNo) {
		this.cmPdNo = cmPdNo;
	}

	public String getCmStatus() {
		return cmStatus;
	}

	public void setCmStatus(String cmStatus) {
		this.cmStatus = cmStatus;
	}

	@Override
	public String toString() {
		return "ProductComment [cmNo=" + cmNo + ", cmContent=" + cmContent + ", cmName=" + cmName + ", cmPwd=" + cmPwd
				+ ", cmPdNo=" + cmPdNo + ", cmStatus=" + cmStatus + "]";
	}

}
