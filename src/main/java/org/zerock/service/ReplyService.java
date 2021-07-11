package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	public void comment(ReplyVO vo);
	public List<ReplyVO> selectcomment(Criteria cri, int vo);
	public int delete(int r_num);
	public int update(ReplyVO vo);
	public ReplyPageDTO getListPage(Criteria cri, Integer b_num);
}
