package org.zerock.service;


import java.io.IOException;
import java.util.ArrayList;

import org.zerock.domain.searchVO;


public interface searchService {
	
	public ArrayList<searchVO> airApi(String daID, String aaID, String dpTime) throws IOException;
	
}
