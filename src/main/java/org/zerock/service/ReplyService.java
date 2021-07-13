package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	
	// 댓글 등록
	public void comment(ReplyVO vo);
	
	// 댓글 목록
	public List<ReplyVO> selectcomment(Criteria cri, int vo);
	
	// 댓글 삭제
	public int delete(int r_num);
	
	// 댓글 수정
	public int update(ReplyVO vo);
	
	// 댓글 목록(페이징)
	public ReplyPageDTO getListPage(Criteria cri, Integer b_num);
}
