package org.zerock.service;


import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.zerock.domain.skylifeVO;


public interface skylifeService {
	
	// 회원가입
	public void register(skylifeVO skylifevo);
	
	// 아이디 중복체크
	public int idCheck(String id);
	
	// 로그인
	public skylifeVO Login(skylifeVO id)throws Exception;
	
	// 회원 수정
	public void memUpdate(skylifeVO vo) throws Exception;
	// 회원정보 비밀번호 체크
	public String getPW(skylifeVO vo) throws Exception;
	// 회원정보 비밀번호 수정
	public void memPWUpdate(skylifeVO vo) throws Exception;
	
	// 비밀번호 찾기
	public skylifeVO findPw(String email) throws Exception;
	
	// 비밀번호 수정
	public void updatePW(skylifeVO skylifevo);
	
	// 아이디 찾기
	public String findID(HttpServletResponse response, String email) throws Exception;

	// 이메일 중복체크
	public int emailhave(String email);
	// 회원 리스트
	public List<skylifeVO> list(skylifeVO mvo);
		
	// 회원 삭제
	public boolean remove(String id);
	public skylifeVO get(String id);
	
	
	//구글회원가입
	public void joinMemberByGoogle(skylifeVO vo);
		
	//구글로그인
	public skylifeVO loginMemberByGoogle(skylifeVO vo);
	
	
	

}
