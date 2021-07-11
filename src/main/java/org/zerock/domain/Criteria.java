package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {		// 페이징 처리를 위해서 데이터베이스에서 게시글을 가져올 때 사용
	private int pageNum;	// 보여줄 페이지 번호
	private int amount;		// 한 페이지에 보여줄 게시글의 수
	private String type;	// 검색 유형(TCW: Title, Content, Writer의 조합)
	private String keyword;	// 검색어
	
	// default 생성자 : 페이지를 지정하지 않을 경우 1페이지를 말하며, 보여줄 게시글의 수를 10으로 지정
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {	// 보여줄 페이지
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public int getPageStart() {		// XML mapper에서 사용
		return (pageNum - 1) * amount;
	}
	
	// type 문자열을 배열로 변환하는 매소드
	public String[] getTypeArr() {
		return type == null ? new String[] { } : type.split("");	// 한 문자씩 잘랐다.
	}
	
	// BoardController에서 redirect할 때 파라미터 생성(추가)하는 부분을 간단하게 해준다.
	// 한글처리를 자동으로 해준다. (키워드, 검색유형 : 한글이 존재하는데, UriComponentsBuilder 객체가
	// 한글처리를 자동으로 해준다.
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
			.queryParam("pageNum", this.pageNum)
			.queryParam("amount", this.amount)
			.queryParam("type", this.getType())
			.queryParam("keyword", this.getKeyword());
		return builder.toUriString();
	}
}