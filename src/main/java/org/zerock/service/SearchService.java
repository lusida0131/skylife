package org.zerock.service;


import java.io.IOException;
import java.util.ArrayList;

import org.zerock.domain.SearchVO;


public interface SearchService {
	
	public ArrayList<SearchVO> airApi(String daID, String aaID, String dpTime) throws IOException;
	
}
