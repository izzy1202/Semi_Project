package com.e2.board.model.vo;

import java.sql.Date;

public class Board {
	private int boardNo;
	private int bCategoryNo;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private int boardCount;
	private String boardStatus;
	private int boardLike;
	private String boardComment;
	private String boardSort;
	private String boardDepth;
	
	public Board() {
		super();
	}
	
	public Board(int bCategoryNo) {
		super();
		this.bCategoryNo = bCategoryNo;
	}
	
	//selectFaq용 매개변수 생성자 1108
		public Board(String boardTitle, String boardContent,int boardNo) {
			super();
			this.boardTitle = boardTitle;
			this.boardContent = boardContent;
			this.boardNo = boardNo;
		}
		
		//faq 글목록 보여주기용 1108
		public Board(String boardTitle, String boardContent,int boardNo,int bCategoryNo) {
			super();
			this.boardTitle = boardTitle;
			this.boardContent = boardContent;
			this.boardNo = boardNo;
			this.bCategoryNo=bCategoryNo;
		}
	
	public Board(int boardNo, int bCategoryNo, String boardWriter, String boardTitle, String boardContent,
			Date boardDate, int boardCount, String boardStatus, int boardLike, String boardComment, String boardSort,
			String boardDepth) {
		super();
		this.boardNo = boardNo;
		this.bCategoryNo = bCategoryNo;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardCount = boardCount;
		this.boardStatus = boardStatus;
		this.boardLike = boardLike;
		this.boardComment = boardComment;
		this.boardSort = boardSort;
		this.boardDepth = boardDepth;
	}
	
	public Board(int boardNo, int bCategoryNo, String boardTitle, String boardContent, Date boardDate, int boardCount,
			String boardStatus, int boardLike, String boardComment, String boardSort, String boardDepth) {
		super();
		this.boardNo = boardNo;
		this.bCategoryNo = bCategoryNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardCount = boardCount;
		this.boardStatus = boardStatus;
		this.boardLike = boardLike;
		this.boardComment = boardComment;
		this.boardSort = boardSort;
		this.boardDepth = boardDepth;
	}
	public Board(int boardNo, String boardWriter, String boardTitle, Date boardDate, int boardCount) {
		super();
		this.boardNo = boardNo;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardDate = boardDate;
		this.boardCount = boardCount;
	}

	public Board(int boardNo, String boardWriter, String boardTitle, String boardContent, Date boardDate,
			int boardCount) {
		super();
		this.boardNo = boardNo;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardCount = boardCount;
	}
	
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getbCategoryNo() {
		return bCategoryNo;
	}
	public void setbCategoryNo(int bCategoryNo) {
		this.bCategoryNo = bCategoryNo;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public String getBoardStatus() {
		return boardStatus;
	}
	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}
	public int getBoardLike() {
		return boardLike;
	}
	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}
	public String getBoardComment() {
		return boardComment;
	}
	public void setBoardComment(String boardComment) {
		this.boardComment = boardComment;
	}
	public String getBoardSort() {
		return boardSort;
	}
	public void setBoardSort(String boardSort) {
		this.boardSort = boardSort;
	}
	public String getBoardDepth() {
		return boardDepth;
	}
	public void setBoardDepth(String boardDepth) {
		this.boardDepth = boardDepth;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", bCategoryNo=" + bCategoryNo + ", boardWriter=" + boardWriter
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardDate=" + boardDate
				+ ", boardCount=" + boardCount + ", boardStatus=" + boardStatus + ", boardLike=" + boardLike
				+ ", boardComment=" + boardComment + ", boardSort=" + boardSort + ", boardDepth=" + boardDepth + "]";
	}
	
}
