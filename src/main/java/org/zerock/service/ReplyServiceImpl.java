package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{
	@Setter(onMethod_ = {@Autowired})
	private ReplyMapper mapper;
	
	@Setter(onMethod_ = {@Autowired})
	private BoardMapper boardmapper;
	
	@Override
	public int register(ReplyVO vo) {
		log.info("register..." + vo);
		return mapper.insert(vo);
	}
	@Override
	public ReplyVO get(Integer r_num) {
		log.info("get..." + r_num);
		return mapper.read(r_num);
	}
	@Override
	public int modify(ReplyVO vo) {
		log.info("modify.." + vo);
		return mapper.update(vo);
	}
	@Override
	public int remove(Integer r_num) {
		log.info("remove..." + r_num);
		return mapper.delete(r_num);
	}
	
	@Override
	public List<ReplyVO> getList(Criteria cri, Integer b_num) {
		log.info("get Reply List of a Board" + b_num);
		return mapper.getListWithPaging(cri, b_num);
	}
}
