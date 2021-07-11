package org.zerock.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.zerock.domain.skylifeVO;
import org.zerock.mapper.skylifeMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class skylifeServiceImpl implements skylifeService{
	
	private skylifeMapper mapper;

	@Override
	public void register(skylifeVO skylifevo) {
		mapper.register(skylifevo);
	}


	@Override
	public int idCheck(String id) {
		int result = mapper.idCheck(id);
		return result;
	}


	@Override
	public skylifeVO Login(skylifeVO skylifevo) throws Exception {
		return mapper.login(skylifevo);
	}

	@Override
	public void memUpdate(skylifeVO vo) throws Exception {
		//받은 vo를 mapper로 보내준다.
		mapper.memUpdate(vo);
	}

	@Override
	public skylifeVO findPw(String email) throws Exception {
		return mapper.findPw(email);
	}


	@Override
	public void updatePW(skylifeVO skylifevo) {
		mapper.updatePW(skylifevo);
	}

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

	//회원 리스트
	@Override
	public List<skylifeVO> list(skylifeVO mvo) {
		return mapper.list(mvo);
	}
	@Override
	public boolean remove(String id) {
		log.info("remove..." + id);
		return mapper.delete(id);
	}
	 
	 @Override 
	 public skylifeVO get(String id) {
	      log.info("public num: " + id);
	      return mapper.read(id);
	   }

}
