package org.zerock.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.zerock.domain.BoardVO;
import org.zerock.domain.ICNVO;
import org.zerock.domain.ParkInfoVO;
import org.zerock.domain.skylifeVO;
import org.zerock.mapper.parkMapper;

import lombok.AllArgsConstructor;


public interface parkService {
	// 주차장 목록 1
	public ArrayList<ParkInfoVO> parkApi(String schAirportCode) throws IOException;
	
	// 주차장 목록 2
	public ArrayList<ParkInfoVO> parkApi1(String schAirportCode) throws IOException;

	/************************************ 인천 국제 공항 *********************************************/
	public ArrayList<ICNVO> icnInfo() throws IOException;
}
