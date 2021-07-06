package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	public void comment(ReplyVO vo);
	public List<ReplyVO> selectcomment(int vo);
	public void commentdelete(ReplyVO vo);
	public void commentupdate(ReplyVO vo);

}
