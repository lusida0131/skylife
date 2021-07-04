package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> list(Integer b_num);
	public void update(ReplyVO vo);
	public void delete(Integer r_num);
	public void create(ReplyVO vo);
}
