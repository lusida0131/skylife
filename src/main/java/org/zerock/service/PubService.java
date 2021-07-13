package org.zerock.service;

import java.util.List;

import org.zerock.domain.PubVO;

public interface PubService {
	
	// 공지사항 등록
	public void register(PubVO pub);
    
	// 공지사항 뷰
	public PubVO get(Integer pno); 
	
	// 공지사항 수정
	public boolean modify(PubVO pub);
	
	// 공지사항 삭제
	public boolean remove(Integer pno);
	
	// 공지사항 목록
	public List<PubVO> list();	
}
