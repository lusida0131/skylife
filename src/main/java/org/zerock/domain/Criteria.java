package org.zerock.domain;

<<<<<<< HEAD
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
   private int pageNum;
   private int amount;
   private String type;
   private String keyword;
   
   // 처음 보여줄 페이지 개수
   public Criteria() {
      this(1, 10);
   }
   
   public Criteria(int pageNum, int amount) {
      this.pageNum = pageNum; // 페이지 개수
      this.amount = amount; // 게시물 개수
   }
   
   public int getPageStart() {
      return (pageNum - 1) * amount;
   }
   
   // 검색조건 페이지
   public String[] getTypeArr() {
      return type == null? new String[] { } : type.split("");
   }
   
   public String getListLink() {
      UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
         .queryParam("pageNum", this.pageNum)
         .queryParam("amount", this.amount)
         .queryParam("type", this.getType())
         .queryParam("keyword", this.getKeyword());
      return builder.toUriString();
   }
=======
public class Criteria {
	private int page;
	private int perPageNum;
	
	public int getPageStart() {
		return (this.page-1)*perPageNum;
	}
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
		}else {
			this.page = page;
		}
	}
	
	public int getPerPageNum() {
		return perPageNum;
	}
	
	public void setPerPageNum(int pageCount) {
		int cnt = this.perPageNum;
		if(pageCount != cnt) {
			this.perPageNum = cnt;
		} else {
			this.perPageNum = pageCount;
		}
	}
>>>>>>> e890ee0a28ff2f5b523bb6d2f351f17ed86efa4b
}
