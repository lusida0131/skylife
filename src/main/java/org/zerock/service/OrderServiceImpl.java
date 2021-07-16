package org.zerock.service;

import javax.inject.Inject;

import org.pay.domain.OrderVO;
import org.springframework.stereotype.Service;

import org.zerock.mapper.OrderMapper;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class OrderServiceImpl implements OrderService{

	@Inject
	private OrderMapper mapper;
	
	public Integer data(String data) {
		return mapper.data(data);
		
	}
}
