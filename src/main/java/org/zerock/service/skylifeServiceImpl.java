package org.zerock.service;

import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

//import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.zerock.domain.skylifeVO;
import org.zerock.mapper.skylifeMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class skylifeServiceImpl implements skylifeService{
	@Inject
	private skylifeMapper mapper;

	// 회원가입
	@Override
	public void register(skylifeVO skylifevo) {
		mapper.register(skylifevo);
	}

	// 아이디 중복
	@Override
	public int idCheck(String id) {
		int result = mapper.idCheck(id);
		return result;
	}

	// 로그인 
	@Override
	public skylifeVO Login(skylifeVO skylifevo) throws Exception {
		return mapper.login(skylifevo);
	}

	// 회원 수정
	@Override
	public void memUpdate(skylifeVO vo) throws Exception {
		//받은 vo를 mapper로 보내준다.
		mapper.memUpdate(vo);
	}
	
	// 비밀번호 찾기
	@Override
	public skylifeVO findPw(String email) throws Exception {
		return mapper.findPw(email);
	}

	// 비밀번호 수정
	@Override
	public void updatePW(skylifeVO skylifevo) {
		mapper.updatePW(skylifevo);
	}
	
	// 아이디 찾기
	@Override
	public String findID(HttpServletResponse response, String email) throws Exception {
		response.setContentType("texk/html;charset=ftf-8");
		PrintWriter out = response.getWriter();
		String id = mapper.findID(email);
		
		if(id == null) {
			out.println("<script>");
			out.println("alert('가입된 아이디가 없습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		} else {
			return id;
		}
	}

	// 이메일 중복확인
	@Override
	public int emailhave(String email) {
		int result = mapper.emailhave(email);
		return result;
	}

	// 회원 리스트
	@Override
	public List<skylifeVO> list(skylifeVO mvo) {
		return mapper.list(mvo);
	}
	// 회원 삭제
	@Override
	public boolean remove(String id) {
		log.info("remove..." + id);
		return mapper.delete(id);
	}
	 
	// 회원 목록 뷰
	 @Override 
	 public skylifeVO get(String id) {
	      log.info("public num: " + id);
	      return mapper.read(id);
	 }
	 
	 
	//구글 회원가입
	@Override
	public void joinMemberByGoogle(skylifeVO vo) {
		mapper.joinMemberByGoogle(vo);
	}

	//구글 로그인
	@Override
	public skylifeVO loginMemberByGoogle(skylifeVO vo) {
		skylifeVO returnVO = null;
		try {
			returnVO = mapper.readMemberWithIDPW(vo.getId());
			System.out.println("S: 로그인 아디: "+vo.getId()+" 이름: "+vo.getName());
		} catch (Exception e) {
			e.printStackTrace();
			returnVO = null; //실행하다 문제가 생겼을때 해당 데이터를 보내지않겠다는 의미 = 예외처리
		}
		return returnVO;
	}



}
