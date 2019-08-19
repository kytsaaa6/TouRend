package com.kym.tr.review.domain;

import java.util.List;

public class ReviewListView {

	private int reviewTotalCount;
	private int currentPageNumber;
	private List<Review> reviewList;
	private int pageTotalCount;
	private int reviewCountPerPage;
	private int firstRow;
	private int endRow;
	
	public ReviewListView(int reviewTotalCount, int currentPageNumber, List<Review> reviewList,
			int reviewCountPerPage, int firstRow, int endRow) {

		this.reviewTotalCount = reviewTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.reviewList = reviewList;
		this.reviewCountPerPage = reviewCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
	}


	private void calcuratePageTotalCount() {
		
		if(reviewTotalCount == 0) {
			pageTotalCount = 0;
		} else {
			
			pageTotalCount = reviewTotalCount / reviewCountPerPage;
			
			if( reviewTotalCount % reviewCountPerPage > 0) {
				pageTotalCount++;
			}
			
		}
	
	}
	public int getReviewTotalCount() {
		return reviewTotalCount;
	}

	public void setReviewTotalCount(int reviewTotalCount) {
		this.reviewTotalCount = reviewTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}

	public int getReviewCountPerPage() {
		return reviewCountPerPage;
	}

	public void setReviewCountPerPage(int reviewCountPerPage) {
		this.reviewCountPerPage = reviewCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	public boolean isEmpty() {
		return reviewCountPerPage == 0;
	}
	
}
