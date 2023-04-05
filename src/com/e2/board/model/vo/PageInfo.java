package com.e2.board.model.vo;

import com.e2.board.model.service.BoardService;

public class PageInfo {
	
	private int listCount; //현재 총 게시글 개수
	private int currentPage; //현재 페이지(즉, 사용자가 요청한 페이지)
	private int pageLimit; //페이지 하단에 보여질 페이징바의 페이지 최대 개수
	private int boardLimit; // 한 페이지에 보여질 게시글의 최대 개수(몇개 단위씩 보여질건지)
	private int maxPage; //가장 마지막 페이지가 몇번페이지 인지(총 페이지수)
	private int startPage; //페이지 한단에 보여질 페이징바의 시작수
	private int endPage; // 페이지 하단에 보여질 페이징바의 끝수
	
	public PageInfo() {
		super();
	}
	
	//서치용 페이징
	public PageInfo(int listCount, int currentPage) {
		//currentPage : 현재 페이지(사용자가 요청한 페이지)
		this.currentPage = currentPage;
		this.listCount = listCount;
		//pageLimit : 페이지 하단에 보여질 페이징 바 최대 개수
		pageLimit = 10;
		
		//boardLimit : 한페이지에 게시글 몇개씩 보여줄것인지
		boardLimit = 10;
		
		maxPage = (int)((Math.ceil((double)listCount/boardLimit)));
		
		startPage = (currentPage-1)/pageLimit * pageLimit+1;
		endPage = startPage + pageLimit -1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
	}
	

		
		public PageInfo(int currentPage) {
			//페이징 처리
			
		 int listCount;  //현재 총 게시글개수
		 
		 this.currentPage=currentPage; //현재페이지(즉,사용자가 요청한 페이지)
		 
		 int pageLimit; //페이지 하단에 보여질 페이징바의 페이지 최대 개수
		 int boardLimit;//한 페이지에 보여질 게시글의 최대개수(몇개단위씩 보여질건지)
		 
		 int maxPage; //가장 마지막 페이지가 몇번페이지인지(총 페이지개수)
		 int startPage; //페이지 하단에 보여질 페이징바의 시작수
		 int endPage; //페이지 하단에 보여질 페이징바의 끝수 만약 내가 5개씩 자르면 1-5 만약 내가 10개씩 자르면1-10
		 

		 listCount=new BoardService().selectListCount();
		

		pageLimit =10;
		

		boardLimit=10;
		

		maxPage=(int)(Math.ceil(((double)listCount/boardLimit)));


		
		startPage=(currentPage-1)/pageLimit*pageLimit+1;
		endPage=startPage+pageLimit-1;

		
		
		if(endPage>maxPage) {
			endPage=maxPage;
		}
			
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
			
		}
	public PageInfo(int listCount, int currentPage, int pageLimit, int boardLimit, int maxPage, int startPage,
			int endPage) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}
	
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageLimit() {
		return pageLimit;
	}
	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}
	public int getBoardLimit() {
		return boardLimit;
	}
	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	@Override
	public String toString() {
		return "PageInfo [listCount=" + listCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", boardLimit=" + boardLimit + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}
}
