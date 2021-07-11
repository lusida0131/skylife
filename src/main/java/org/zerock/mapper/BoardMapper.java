package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	// 게시글 작성
	public void insert(BoardVO vo);
	
	// 게시글 상세보기
	public BoardVO view(int b_num);
	
	// 게시글 수정
	public void update(BoardVO vo);
	
	// 게시글 삭제
	public void delete(int b_num);
	
	// 게시글 리스트
	public List<BoardVO> list(BoardVO vo);
	
	// 게시글 조회수
	public void increaseViewcnt(int b_num);
	
<<<<<<< HEAD
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
	
	// 댓글이 추가(amount=+1), 삭제(amount=-1)되면 replyCnt 값을 갱신하는 매소드
	public void updateReplyCnt(@Param("b_num") Integer bno, @Param("amount") int amount);
=======
	public List<BoardVO> getListWithPaging(Criteria cri);
>>>>>>> 7072013cbb2f31018919d4c176d1c18a78121639
}
