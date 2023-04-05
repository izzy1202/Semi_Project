package com.e2.board.model.vo;

import java.sql.Date;

public class BoardAttachment {

	private int fileNo;
	private int boardNo;
	private String originName;
	private String saveName; 
	private String filePath;
	private String thumbnail;
	private Date uploadDate;
	
	
	public BoardAttachment() {
		super();
	}

	public BoardAttachment(int fileNo, int boardNo, String originName, String saveName, String filePath,
			String thumbnail, Date uploadDate) {
		super();
		this.fileNo = fileNo;
		this.boardNo = boardNo;
		this.originName = originName;
		this.saveName = saveName;
		this.filePath = filePath;
		this.thumbnail = thumbnail;
		this.uploadDate = uploadDate;
	}

	public BoardAttachment(int fileNo, String originName, String saveName, String filePath) {
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Override
	public String toString() {
		return "BoardAttachment [fileNo=" + fileNo + ", boardNo=" + boardNo + ", originName=" + originName
				+ ", saveName=" + saveName + ", filePath=" + filePath + ", thumbnail=" + thumbnail + ", uploadDate="
				+ uploadDate + "]";
	}
	
}
