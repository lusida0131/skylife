package org.zerock.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.zerock.domain.skylifeVO;

public interface skylifeService {
	public void register(skylifeVO skylifevo);
	public int idCheck(String id);
	public skylifeVO Login(skylifeVO id)throws Exception;
	public void memUpdate(skylifeVO vo) throws Exception;
	
	// 비밀번호 찾기
	public skylifeVO findPw(String email) throws Exception;
	public void updatePW(skylifeVO skylifevo);
	
	// 아이디 찾기
	public String findID(HttpServletResponse response, String email) throws Exception;
	public List<skylifeVO> list(skylifeVO mvo);
	

}
