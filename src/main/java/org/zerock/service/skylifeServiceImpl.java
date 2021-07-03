package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.domain.skylifeVO;
import org.zerock.mapper.skylifeMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class skylifeServiceImpl implements skylifeService{
	
	private skylifeMapper mapper;
	
	@Override
	public void register(skylifeVO skylifevo) {
		mapper.register(skylifevo);
	}


	@Override
	public int idCheck(String id) {
		int result = mapper.idCheck(id);
		return result;
	}


	@Override
	public skylifeVO Login(skylifeVO skylifevo) throws Exception {
		return mapper.login(skylifevo);
	}

	@Override
	public void memUpdate(skylifeVO vo) throws Exception {
		
		//받은 vo를 mapper로 보내준다.
		mapper.memUpdate(vo);
	}
}
