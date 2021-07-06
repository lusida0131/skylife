package org.zerock.mapper;

import javax.servlet.http.HttpServletResponse;

import org.zerock.domain.skylifeVO;

public interface skylifeMapper {
	
	public void register(skylifeVO skylifevo);
	public int idCheck(String id);
	public skylifeVO login(skylifeVO skylifevo)throws Exception;
	
	public void memUpdate(skylifeVO vo) throws Exception;
	
	// 비밀번호 찾기
	public skylifeVO findPw(String email) throws Exception;
	public void updatePW(skylifeVO skylifevo);
	// 아이디 찾기
	public String findID(String email) throws Exception;
}
