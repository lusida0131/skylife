package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {

	// 댓글 등록
	public void comment(ReplyVO vo);
	
	// 댓글 목록
	public List<ReplyVO> selectcomment(int vo);
	
	// 댓글 삭제
	public int delete(int r_num);
	
	// 댓글 수정
	public int update(ReplyVO vo);
	
	// 댓글 목록(페이징)
	public List<ReplyVO> getListWithPaging(	
			@Param("cri") Criteria cri, @Param("b_num") Integer b_num);
	
	// 댓글의 갯수를 구하는 매소드
	public int getCountByBno(Integer b_num);	

}
