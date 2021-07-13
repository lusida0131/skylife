package org.zerock.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

// 댓글의 페이징 처리를 위한 객체 -> jsp에게 뷰처리를 위해 전달해준다.
// 게시글 페이지 처리 : 게시글 수, 게시글 목록 -> PageDTO를 만들어서 jsp로 전달
// PageDTO에서 페이징 처리를 위한 데이터를 생성
// 댓글의 페이징 처리는 다른다. ReplyPageDTO를 만들고 jsp로 전달
// jsp에서 페이징 처리를 위한 데이터 생성은 javascript가 한다.
// 데이터를 만드는 작업을 서버에서 하지 않고 브라우저로 넘긴것으로 (서버의 부하를 줄임)
@Data
@AllArgsConstructor
@Getter
public class ReplyPageDTO {	
	private int replyCnt;		// 댓글의 수
	private List<ReplyVO> list;	// 댓글의 목록
}
