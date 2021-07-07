package org.zerock.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.pay.domain.ParkInfoVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.skylifeVO;
import org.zerock.mapper.parkMapper;

import lombok.AllArgsConstructor;


public interface parkService {
	
	public List<ParkInfoVO> parkApi(String parkingAirportCodeName, String parkingFullSpace, String parkinglIncnt, String parkingGettime, String aprKor, String parkingIincnt) throws IOException;
	
}
