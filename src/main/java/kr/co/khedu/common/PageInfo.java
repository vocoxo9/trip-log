package kr.co.khedu.common;

import lombok.Data;

/**
 * 
 * @author 임성준
 * 페이지 정보를 저장하는 객체
 */

@Data
public class PageInfo {
	private int listCount;		// 전체 아이템 갯수
	private int currentPageNo;	// 현재 페이지 번호
	private int pageLimit;		// 페이징 바의 최대 갯수
	private int itemLimit;		// 한 페이지 당 보여줄 아이템의 최대 갯수
	private int maxPageNo;		// 가장 마지막 페이지 번호
	private int startPageNo;	// 페이징 바의 시작 페이지 번호
	private int endPageNo;		// 페이징 바의 끝 페이지 번호
	
	public PageInfo(int listCount, int currentPageNo, int pageLimit, int itemLimit) {
		this.listCount = listCount;
		this.currentPageNo = currentPageNo;
		this.pageLimit = pageLimit;
		this.itemLimit = itemLimit;

		this.maxPageNo = (int)Math.ceil((double)listCount / itemLimit);
		this.startPageNo = ((currentPageNo - 1) / pageLimit) * pageLimit + 1;
		this.endPageNo = this.startPageNo + pageLimit - 1;
		this.endPageNo = this.endPageNo > this.maxPageNo ? this.maxPageNo : this.endPageNo;
	}
}
