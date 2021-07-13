package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.PubVO;

public interface PubMapper {
	
	// 공지사항 목록
	public List<PubVO> list();
	
	// 공지사항 뷰
	public PubVO read(Integer pno); 
	
	// 공지사항 등록
	public void insert(PubVO pub);
	
	// 공지사항 삭제
	public int delete(Integer pno);
	
	// 공지사항 수정
	public int update(PubVO pno);
}
