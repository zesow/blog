package com.Blog.board.paging;

public class Paging {
	// 하나의 페이지에 표시할 게시물 갯수 
	private int maxPost;
	// 맨 처음 보여주는 페이지 = 1
	private int firstPageNo;
	// 이전 버튼을 눌렀을 때 이전 페이지 그룹이 나타나도록 함(5의 배수) 
	private int prevPageNo;
	// 이전 버튼을 눌렀을 때 이전 페이지 그룹의 마지막 페이지를 나타내는 변수 
	private int startPageNo;
	// 현재 페이지 
	private int currentPageNo;
	// 페이징 갯수 = 5개 
	private int sizeOfPage;
	// 마지막 그룹에서 페이지 번호  
	private int endPageNo;
	// prevPageNo의 반대로 다음 버튼 
	private int nextPageNo;
	// 게시물 수에 따른 마지막 페이지의 숫자.
	private int finalPageNo;
	// 게시물의 총 갯수 
	private int numOfRecords;
	
	public Paging(int maxPost, int currentPageNo) {
		//페이지 한 그룹은 5개로 설정.
		this.sizeOfPage = 5;
		this.currentPageNo = currentPageNo;
//		게시물 최대 갯수가 0개가 아니라면 현재 게시물 갯수로 하고, 0개이면 10개 고정한다.
		this.maxPost = (maxPost != 0) ? maxPost : 10;
	}
	public int getMaxPost() {
		return maxPost;
	}
	public void setMaxPost(int maxPost) {
		this.maxPost = maxPost;
	}
	public int getFirstPageNo() {
		return firstPageNo;
	}
	public void setFirstPageNo(int firstPageNo) {
		this.firstPageNo = firstPageNo;
	}
	public int getPrevPageNo() {
		return prevPageNo;
	}
	public void setPrevPageNo(int prevPageNo) {
		this.prevPageNo = prevPageNo;
	}
	public int getStartPageNo() {
		return startPageNo;
	}
	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getSizeOfPage() {
		return sizeOfPage;
	}
	public void setSizeOfPage(int sizeOfPage) {
		this.sizeOfPage = sizeOfPage;
	}
	public int getEndPageNo() {
		return endPageNo;
	}
	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}
	public int getNextPageNo() {
		return nextPageNo;
	}
	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}
	public int getFinalPageNo() {
		return finalPageNo;
	}
	public void setFinalPageNo(int finalPageNo) {
		this.finalPageNo = finalPageNo;
	}
	public int getNumOfRecords() {
		return numOfRecords;
	}
	public void setNumOfRecords(int numOfRecords) {
		this.numOfRecords = numOfRecords;
	}
	
	public void makePaging() {
		// 등록된 글이 없으면 페이지를 만들지 않는다.
		if(numOfRecords == 0)
			return;
		//페이지의 최소를 1로 설정.
		if(currentPageNo == 0)
			setCurrentPageNo(1);
		// 한 페이지당 글 갯수는 10개로 기본 설정.
		if(maxPost == 0)
			setMaxPost(10);
		
		//총 페이지 수 = (전체 게시물 수 + 한 페이지에 보여지는 최대 게시물 수(10-1)) / 한 페이지에 보여지는 최대 게시물 수(10)
		//마지막에 10개가 아니더라도 보여줄 페이지가 있을 때 페이지가 하나 더 증가하므로 +(maxPost-1) 을 해 줌.
		int finalPage = (numOfRecords + (maxPost-1)) / maxPost;
		
		// 현재 페이지가 마지막 페이지를 넘어갈 수 없게 처리.
		if(currentPageNo > finalPage)
			setCurrentPageNo(finalPage);
		
		// 현재 페이지가 첫 번째 페이지 밑으로 내려갈 수 없게 처리.
		if(currentPageNo < 0)
			currentPageNo = 1;
		
		// 첫 페이지인지 마지막 페이지인지.
		boolean isNowFirst = currentPageNo == 1? true:false;
		boolean isNowFinal = currentPageNo == finalPage? true:false;
		
		// 이번 페이지 그룹의 시작 페이지 = ((현재페이지-1) / 페이지 크기) * 페이지 크기 + 1 
		int startPage = ((currentPageNo-1)/sizeOfPage) * sizeOfPage + 1;
		// 이번 페이지 그룹의 끝 페이지 = 시작 페이지 + (페이지 크기 - 1)
		int endPage = startPage + sizeOfPage - 1;
		
		//페이지 그룹의 끝이 마지막 페이지를 넘어가지 않게 처리.
		if(endPage > finalPage)
			endPage = finalPage;
		
		//첫 페이지는 무조건 1로 확정.
		setFirstPageNo(1);
		
		//첫 페이지가 아니면 '이전'버튼으로 갈 페이지는 이번 페이지 그룹의 시작 -1.
		//첫 페이지일 경우에는 무조건 첫 페이지로.
		if(!isNowFirst)
			setPrevPageNo(((startPage-1) < 1 ? 1 : (startPage-1)));
		
		//이번 페이지 그룹의 시작,끝 번호 확정.
		setStartPageNo(startPage);
		setEndPageNo(endPage);
		
		//마지막 페이지가 아니면 '다음'버튼으로 갈 페이지는 이번 페이지 그룹의 끝 +1.
		//마지막 페이지일 경우에는 무조건 마지막 페이지로.
		if(!isNowFinal)
			setNextPageNo(((endPage+1 > finalPage? finalPage : (endPage+1))));
		
		//전체 페이지의 마지막 페이지 번호 확정.
		setFinalPageNo(finalPage);
	}

	
}
