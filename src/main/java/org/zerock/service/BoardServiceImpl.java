package org.zerock.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	BoardMapper mapper;
	
	// 게시글 작성
	@Override
	public void insert(BoardVO vo) {
		String b_title = vo.getB_title();
		String b_content = vo.getB_content();
		String id = vo.getId();
		vo.setB_title(b_title);
		vo.setB_content(b_content);
		vo.setId(id);
		mapper.insert(vo);
	}
	
	// 게시글 보기
	@Override
	public BoardVO view(int b_num) {
		return mapper.view(b_num);
	}
	
	// 게시글 수정
	@Override
	public void update(BoardVO vo) {
		mapper.update(vo);
	}
	
	// 게시글 삭제
	@Override
	public void delete(int b_num) {
		mapper.delete(b_num);
	}
	

	// 게시글 총수
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}
	// 게시글 목록
	@Override
	public List<BoardVO> list(Criteria cri) {
		log.info("getList with Paging..." + cri);
		return mapper.getListWithPaging(cri);
	}

	
	
	
	
	// 게시글 조회수
	@Override
	public boolean increaseViewcnt(int b_num) throws Exception {
		return mapper.increaseViewcnt(b_num);
	}


	
}
