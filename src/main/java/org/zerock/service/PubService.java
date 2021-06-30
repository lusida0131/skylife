package org.zerock.service;

import java.util.List;

import org.zerock.domain.PubVO;

public interface PubService {
	public void insert(PubVO pub);
	public boolean modify(PubVO pub);
	public boolean remove(Integer pno);
	public List<PubVO> getList();	
}
