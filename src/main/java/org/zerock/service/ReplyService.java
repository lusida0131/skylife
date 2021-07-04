package org.zerock.service;

import java.util.List;

import org.zerock.domain.ReplyVO;

public interface ReplyService {
	public List<ReplyVO> list(Integer b_num);
	public void create(ReplyVO vo);
	public void update(ReplyVO vo);
	public void delete(Integer r_num);
}
