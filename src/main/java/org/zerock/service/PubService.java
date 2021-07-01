package org.zerock.service;

import java.util.List;

import org.zerock.domain.PubVO;

public interface PubService {
	public void register(PubVO pub);
    public PubVO get(Integer pno); // 공지사항 세부조회
	public boolean modify(PubVO pub);
	public boolean remove(Integer pno);
	public List<PubVO> list();	
}
