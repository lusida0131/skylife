package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	public void comment(ReplyVO vo);
	public List<ReplyVO> selectcomment(int vo);
	public void commentdelete(ReplyVO vo);
	public void commentupdate(ReplyVO vo);
}
