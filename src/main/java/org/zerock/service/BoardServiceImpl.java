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
//	@Override
//	public List<BoardVO> list(BoardVO vo) {
//		log.info("get list..");
//		return mapper.list(vo);
//	}
	
	
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}
	@Override
	public List<BoardVO> list(Criteria cri) {
		log.info("getList with Paging..." + cri);
		return mapper.getListWithPaging(cri);
	}

	
	
	
	
	// 게시글 조회수
	@Override
	public void increaseViewcnt(int b_num, HttpSession session) throws Exception {
		long update_time = 0;
		// 세션에 저장된 조회시간 검색
		// 최초로 조회할 경우 세션에 저장된 값이 없기 때문에 if문은 실행 X
		if(session.getAttribute("update_time_" + b_num) != null) {
			update_time = (long)session.getAttribute("update_time_" + b_num);
		}
		// 시스템의 현재시간을 current_time에 저장c
		long current_time = System.currentTimeMillis();
		// 일정시간이 경과 후 조회수 증가 처리 24*60*60*1000(24시간)
		// 시스템 현재시간 - 열람시간 > 일정시간(조회수 증가가 가능하도록 지정한 시간)
		if(current_time - update_time > 5*1000) {
			mapper.increaseViewcnt(b_num);
			// 세션에 시간을 저장 : "update_time_" + b_num은 다른변수와 중복되지 않게 명명한 것
			session.setAttribute("update_time_" + b_num, current_time);
		}
	}


	
}
