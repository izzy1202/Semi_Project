package com.e2.board.model.vo;

import java.sql.Date;

public class Attachment {

	 private int fileNo;		//	FILE_NO	NUMBER(38,0)
	 private int boardNo;		//	BOARD_NO	NUMBER(38,0)
	 private String originName;		//	ORIGIN_NAME	VARCHAR2(255 BYTE)
	 private String	saveName;	//	SAVE_NAME	VARCHAR2(255 BYTE)
	 private String filePath;		//	FILE_PATH	VARCHAR2(1000 BYTE)
	 private String thumbNail;		//	THUMBNAIL	VARCHAR2(1 BYTE)
	 private  Date uploadDate;	//	UPLOAD_DATE	DATE
	
	 
	 public Attachment() {
		super();
	}


	public Attachment(int fileNo, int boardNo, String originName, String saveName, String filePath, String thumbNail,
			Date uploadDate) {
		super();
		this.fileNo = fileNo;
		this.boardNo = boardNo;
		this.originName = originName;
		this.saveName = saveName;
		this.filePath = filePath;
		this.thumbNail = thumbNail;
		this.uploadDate = uploadDate;
	}
	
	
	
     //파일조회용 생성자 selectAttachment (boardDao에서 넘어왔음)
	public Attachment(int fileNo, String originName, String saveName, String filePath) {
		super();
		this.fileNo = fileNo;
		this.originName = originName;
		this.saveName = saveName;
		this.filePath = filePath;
	}


	public int getFileNo() {
		return fileNo;
	}


	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public String getOriginName() {
		return originName;
	}


	public void setOriginName(String originName) {
		this.originName = originName;
	}


	public String getSaveName() {
		return saveName;
	}


	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getThumbNail() {
		return thumbNail;
	}


	public void setThumbNail(String thumbNail) {
		this.thumbNail = thumbNail;
	}


	public Date getUploadDate() {
		return uploadDate;
	}


	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}


	@Override
	public String toString() {
		return "Attachment [fileNo=" + fileNo + ", boardNo=" + boardNo + ", originName=" + originName + ", saveName="
				+ saveName + ", filePath=" + filePath + ", thumbNail=" + thumbNail + ", uploadDate=" + uploadDate + "]";
	}
	 
	
	
	
}
