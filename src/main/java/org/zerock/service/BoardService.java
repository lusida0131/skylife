package org.zerock.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;


public interface BoardService {
	// 게시글 작성
		public void insert(BoardVO vo);
		
		// 게시글 상세보기
		public BoardVO view(int b_num);
		
		// 게시글 수정
		public void update(BoardVO vo);
		
		// 게시글 삭제
		public void delete(int b_num);
		
		// 게시글 리스트
//		public List<BoardVO> list(BoardVO vo);
				
		public List<BoardVO> list(Criteria cri);			// 게시글 목록 보기
		public int getTotal(Criteria cri);

		// 게시글 조회수
		public boolean increaseViewcnt(int b_num) throws Exception;

}
