package org.zerock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
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
	public void comment(ReplyVO vo) {
		mapper.comment(vo);    
	}
	@Override
	public List<ReplyVO> selectcomment(Criteria cri, int vo) {
		return mapper.getListWithPaging(cri, vo);
	}
	@Override
	public int delete(int r_num) {
		return mapper.delete(r_num);      
	}
	@Override
	public int update(ReplyVO vo) {
	
		return mapper.update(vo);   
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Integer b_num) {
		// page -1일 경우 처리를 해주어야 한다. -> 댓글의 수와 빈 목록을 반환
		if(cri.getPageNum() == -1) {	// 댓글의 수만 필요함
			return new ReplyPageDTO(mapper.getCountByBno(b_num),
					new ArrayList<ReplyVO>());
		} else {
			return new ReplyPageDTO(mapper.getCountByBno(b_num),
					mapper.getListWithPaging(cri, b_num));
		}
	}
}
