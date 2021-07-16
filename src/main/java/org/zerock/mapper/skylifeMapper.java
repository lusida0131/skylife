package org.zerock.mapper;


import java.sql.Date;
import java.util.List;



import org.zerock.domain.skylifeVO;


public interface skylifeMapper {
	
	// 회원가입
	public void register(skylifeVO skylifevo);
	
	// 아이디 중복 체크
	public int idCheck(String id);
	
	// 로그인
	public skylifeVO login(skylifeVO skylifevo)throws Exception;
	
	// 회원정보 수정
	public void memUpdate(skylifeVO vo) throws Exception;
	
	// 비밀번호 찾기
	public skylifeVO findPw(String email) throws Exception;

	// 비밀번호 수정
	public void updatePW(skylifeVO skylifevo);
	
	// 아이디 찾기
	public String findID(String email) throws Exception;
	
	// 이메일 중복 체크
	public int emailhave(String email);

	// 회원 정보 리스트
	public List<skylifeVO> list(skylifeVO mvo);
	
	// 회원 삭제 
	public boolean delete(String id);
 	public skylifeVO read(String id);


	// 구글회원가입

	public void joinMemberByGoogle(skylifeVO vo);
		
	// 구글로그인
	public skylifeVO loginMemberByGoogle(skylifeVO vo);
	
	//R: 회원 정보 조회 - ID정보에 해당하는 사용자 정보
	public skylifeVO readMemberWithIDPW(String userid) throws Exception;
	
	
	// 카카오 회원가입
	public void joinMemberByKakao(skylifeVO kvo);
	
	// 카카오 회원 ID 조회
	public skylifeVO readMemberWithKakaoID(String id) throws Exception;
	
}
