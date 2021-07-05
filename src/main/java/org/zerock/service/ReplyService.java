package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	public int register(ReplyVO vo);
	public ReplyVO get(Integer r_num);
	public int modify(ReplyVO vo);
	public int remove(Integer r_num);
	public List<ReplyVO> getList(Criteria cri, Integer b_num);
}
