package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	public int insert(ReplyVO vo);
	public ReplyVO read(Integer r_num);
	public int delete(Integer r_num);
	public int update(ReplyVO r_content);
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("b_num") Integer bno);
}
