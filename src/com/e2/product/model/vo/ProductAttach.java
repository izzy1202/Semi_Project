package com.e2.product.model.vo;

import java.sql.Date;

//상품  이미지 VO - 유원호
public class ProductAttach {

	private int fileNo; // 파일번호 FILE_NO ,NUMBER, PRIMARY KEY
	private int pdNo; // 상품코드 PRODUCT_NO ,NUMBER
	private String originName; // 원본파일명 ORIGIN_NAME ,VARCHAR2(255)
	private String changeName; // 저장파일명 SAVE_NAME ,VARCHAR2(255)
	private String filePath; // 저장경로 FILE_PATH ,VARCHAR2(1000)
	private String thumnail; // 썸네일여부(Y/N) THUMBNAIL ,VARCHAR2(1)
	private Date uploadDate; // 업로드날짜 UPLOAD_DATE ,DATE

	// 기본생성자
	public ProductAttach() {
		super();
	}

	// getter-setter
	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getPdNo() {
		return pdNo;
	}

	public void setPdNo(int pdNo) {
		this.pdNo = pdNo;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getThumnail() {
		return thumnail;
	}

	public void setThumnail(String thumnail) {
		this.thumnail = thumnail;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Override
	public String toString() {
		return "ProductAttach [fileNo=" + fileNo + ", pdNo=" + pdNo + ", originName=" + originName + ", changeName="
				+ changeName + ", filePath=" + filePath + ", thumnail=" + thumnail + ", uploadDate=" + uploadDate + "]";
	}

}
