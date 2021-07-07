package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.pay.domain.ParkInfoVO;

@Mapper
public interface parkMapper {

	public List<ParkInfoVO> parkInfo() throws Exception;
}
