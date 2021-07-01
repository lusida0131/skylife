package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.PubVO;
import org.zerock.domain.skylifeVO;

public interface PubMapper {
	public List<PubVO> list();
	public PubVO read(Integer pno); // get ������ȸ
	public void insert(PubVO pub);
	public int delete(Integer pno);
	public int update(PubVO pno);

}
