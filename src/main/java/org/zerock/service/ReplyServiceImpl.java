package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
public class ReplyServiceImpl implements ReplyService{
	@Setter(onMethod_ = {@Autowired})
	private ReplyMapper mapper;
	
	@Setter(onMethod_ = {@Autowired})
	private BoardMapper boardmapper;
	
	@Override
	public void comment(ReplyVO vo) {
		mapper.comment(vo);    
	}
	@Override
	public List<ReplyVO> selectcomment(int vo) {
		return mapper.selectcomment(vo);
	}
	@Override
	public int delete(int r_num) {
		return mapper.delete(r_num);      
	}
	@Override
	public int update(ReplyVO vo) {
		return mapper.update(vo);   
	}
}
