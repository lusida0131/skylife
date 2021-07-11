package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage;		// 보여줄 시작 페이지
	private int endPage;		// 보여줄 마지막 페이지
	private boolean prev, next;	// 이전과 다음 버튼의 필요 여부
	private int total;			// 전체 게시글의 수
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;		// 계산에 의한 마지막 페이지
		this.startPage = this.endPage - 9;
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));	// 실질적인 마지막 페이지
		if (realEnd <= this.endPage) {
	      	this.endPage = realEnd;
		}
		this.prev = startPage > 1;
		this.next = endPage < realEnd;	// 더 있다.
	}
}
