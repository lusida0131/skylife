package org.zerock.service;

import java.util.List;

import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

public class ReplyServiceImpl implements ReplyService {
	
	private ReplyMapper mapper;
	
	@Override
	public void create(ReplyVO vo) {
		mapper.create(vo);
	}
	@Override
	public void update(ReplyVO vo) {

	}
	@Override
	public void delete(Integer r_num) {

	}
	@Override
	public List<ReplyVO> list(Integer b_num) {
		return mapper.list(b_num);
	}
}
