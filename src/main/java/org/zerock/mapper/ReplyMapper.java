package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	public void comment(ReplyVO vo);
	public List<ReplyVO> selectcomment(int vo);
	public int delete(int r_num);
	public int update(ReplyVO vo);
	public List<ReplyVO> getListWithPaging(	// 댓글 목록(페이징)
			@Param("cri") Criteria cri, @Param("b_num") Integer b_num);
	public int getCountByBno(Integer b_num);	// 댓글의 갯수를 구하는 매소드

}
