package org.zerock.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.zerock.domain.BoardVO;
import org.zerock.domain.ParkInfoVO;
import org.zerock.domain.skylifeVO;
import org.zerock.mapper.parkMapper;

import lombok.AllArgsConstructor;


public interface parkService {
	
	public ArrayList<ParkInfoVO> parkApi(String schAirportCode) throws IOException;
	
	public ArrayList<ParkInfoVO> parkApi1(String schAirportCode) throws IOException;
}
