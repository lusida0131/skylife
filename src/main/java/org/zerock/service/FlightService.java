package org.zerock.service;


import java.io.IOException;
import java.util.ArrayList;

import org.zerock.domain.FlightVO;


public interface FlightService {
	
	public String nameset(String name);
	
	public ArrayList<FlightVO> airApi(String daID, String aaID, String dpTime, Integer pageNum) throws IOException;
	
}
