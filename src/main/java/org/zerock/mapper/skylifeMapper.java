package org.zerock.mapper;

import org.zerock.domain.skylifeVO;

public interface skylifeMapper {
	
	public void register(skylifeVO skylifevo);
	
	public int idCheck(String id);
	
	public skylifeVO login(skylifeVO skylifevo)throws Exception;
	
}
