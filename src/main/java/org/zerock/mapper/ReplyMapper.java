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

}
