package com.e2.board.model.vo;

import java.sql.Date;

public class Reply {

	private int replyNo;
	private int refBno;
	private String boardWriter;
	private String reply;
	private int replyDepth;
	private int replySort;
	private int replyGroup;
	private Date replyDate;
	private String status;
	public Reply() {
		super();
	}
	public Reply(int replyNo, String boardWriter, String reply, int replyDepth, int replySort, int replyGroup, Date replyDate) {
		super();
		this.replyNo = replyNo;
		this.boardWriter = boardWriter;
		this.reply = reply;
		this.replyDepth = replyDepth;
		this.replySort = replySort;
		this.replyGroup = replyGroup;
		this.replyDate = replyDate;
	}
	public Reply(int replyNo, int refBno, String boardWriter, String reply, int replyDepth, int replySort,
			int replyGroup, Date replyDate, String status) {
		super();
		this.replyNo = replyNo;
		this.refBno = refBno;
		this.boardWriter = boardWriter;
		this.reply = reply;
		this.replyDepth = replyDepth;
		this.replySort = replySort;
		this.replyGroup = replyGroup;
		this.replyDate = replyDate;
		this.status = status;
	}
	
	
	public Reply(int refBno, String boardWriter, String reply, int replyDepth, int replySort, int replyGroup) {
		super();
		this.refBno = refBno;
		this.boardWriter = boardWriter;
		this.reply = reply;
		this.replyDepth = replyDepth;
		this.replySort = replySort;
		this.replyGroup = replyGroup;
	}
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public int getRefBno() {
		return refBno;
	}
	public void setRefBno(int refBno) {
		this.refBno = refBno;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public int getReplyDepth() {
		return replyDepth;
	}
	public void setReplyDepth(int replyDepth) {
		this.replyDepth = replyDepth;
	}
	public int getReplySort() {
		return replySort;
	}
	public void setReplySort(int replySort) {
		this.replySort = replySort;
	}
	public int getReplyGroup() {
		return replyGroup;
	}
	public void setReplyGroup(int replyGroup) {
		this.replyGroup = replyGroup;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", refBno=" + refBno + ", boardWriter=" + boardWriter + ", reply=" + reply
				+ ", replyDepth=" + replyDepth + ", replySort=" + replySort + ", replyGroup=" + replyGroup
				+ ", replyDate=" + replyDate + ", status=" + status + "]";
	}
	
	

}
