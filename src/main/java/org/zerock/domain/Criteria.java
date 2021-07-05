package org.zerock.domain;

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
}
