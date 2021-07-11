package org.zerock.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.skylifeVO;
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
		
//		b_title = b_title.replace("<", "&lt;");
//		b_title = b_title.replace("<", "&gt;");
//		id = id.replace("<", "&gt;");
//		id = id.replace("<", "&gt;");
//		
//		b_title = b_title.replace(" ", "&nbsp;&nbsp;");
//		id = id.replace(" ", "&nbsp;&nbsp;");
//		
//		b_content = b_content.replace("\n", "<br>");
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
	
	// 게시글 리스트
	@Override
	public List<BoardVO> list(BoardVO vo) {
		log.info("get list..");
		return mapper.list(vo);
	}
	
	// 게시글 조회수
	@Override
	public boolean increaseViewcnt(int b_num) throws Exception {
		return mapper.increaseViewcnt(b_num);
	}


	
}
