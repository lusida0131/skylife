package org.zerock.service;

import org.zerock.domain.skylifeVO;

public interface skylifeService {
	public void register(skylifeVO skylifevo);
	public int idCheck(String id);
	public skylifeVO Login(skylifeVO id)throws Exception;
	public void memUpdate(skylifeVO vo) throws Exception;
}
