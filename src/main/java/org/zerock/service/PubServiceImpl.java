package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.PubVO;
import org.zerock.mapper.PubMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class PubServiceImpl implements PubService{
	
	private PubMapper mapper;
	
	@Override
	public void register(PubVO pub) {
		log.info("register..." + pub);
		mapper.insert(pub);
	}
	
	@Override
	public boolean modify(PubVO pub) {
		log.info("modify..." + pub);
		return mapper.update(pub) == 1;
	}
	@Override
	public boolean remove(Integer pno) {
		log.info("remove..." + pno);
		return mapper.delete(pno) == 1;
	}
	@Override
	public List<PubVO> list() {
		log.info("getList...");
		return mapper.list();
	}
	
	 @Override 
	 public PubVO get(Integer pno) {
	      log.info("public num: " + pno);
	      return mapper.read(pno);
	   }
}
