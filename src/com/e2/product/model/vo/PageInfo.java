package com.e2.product.model.vo;

import com.e2.product.model.service.ProductService;

// 페이징 VO - 유원호
public class PageInfo {

	// 페이징 처리
	private int listCount; // 현재 총 게시물 갯수
	private int currentPage; // 현재 페이지(즉, 사용자가 요청한 페이지)
	private int pageLimit; // 페이지 하단에 보여질 페이징바의 페이지 최대 개수
	private int boardLimit; // 한 페이지에 보여질 게시글의 최대갯수(몇개 단위씩 보여질건지)

	private int maxPage; // 가장 마지막 페이지가 몇번 페이지인지(총 페이지수)
	private int startPage; // 페이지 하단에 보여질 페이징바의 시작수
	private int endPage; // 페이지 하단에 보여질 페이징바의 끝수

	// 페이징 처리
	public PageInfo(int currentPage, int cNo) {

		// listCount : 현재 총 게시글의 갯수.
		listCount = new ProductService().productSelectListCount(cNo);

		// currentPage : 현재 페이지 (사용자가 요청한 페이지)
		this.currentPage = currentPage;

		// pageLimit : 페이지 하단에 보여질 최대 갯수
		pageLimit = 5;

		// boardLimit : 한 페이지에 몇개씩 보여줄것인지
		boardLimit = 4;

		// 총페이지 수 = 나머지 올림메소드((더블형)총게시물 수 / 한 페이지에 보여질 게시물수))
		maxPage = (int) Math.ceil(((double) listCount / boardLimit));

		// 시작페이징 번호 = (현재페이지-1) / 보여질 페이징 개수 * 보여질 페이징 개수+1
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		// 페이지 하단에 끝페이징 번호 = 시작 페이징번호 + 보여질페이징 갯수-1
		endPage = startPage + pageLimit - 1;

		// startPage 가 11 일때 endPage 는 20으로 된다 (만약 maxPage 가 13이라면? 20까지 나오니까)
		// endPage 를 maxPage로 변경
		if (endPage > maxPage) {
			endPage = maxPage;
		}
	}

	// 기본생성자
	public PageInfo() {
		super();
	}

	// 생성자 전체
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

	// getter-setter
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
