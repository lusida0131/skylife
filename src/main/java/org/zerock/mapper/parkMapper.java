package org.zerock.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.domain.ICNVO;
import org.zerock.domain.ParkInfoVO;


@Mapper
public interface parkMapper {

	public ArrayList<ParkInfoVO> parkInfo() throws Exception;
	
	public ArrayList<ICNVO> icnInfo() throws Exception;
}
