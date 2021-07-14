package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.SfileVO;
import org.zerock.mapper.SfileMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Service
public class SfileServiceImpl implements SfileService {
	@Inject
	SfileMapper mapper;

	@Override
	public void insert(SfileVO vo) {
		mapper.insert(vo);
	}
	
}
