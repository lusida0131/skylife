package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.PubVO;

public interface PubMapper {
	public List<PubVO> list();
	public PubVO read(Integer pno); // get 세부조회
	public void insert(PubVO pub);
	public int delete(Integer pno);
	public int update(PubVO pno);
}
