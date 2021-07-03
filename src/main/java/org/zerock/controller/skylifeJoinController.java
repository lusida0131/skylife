package org.zerock.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.zerock.domain.skylifeVO;
import org.zerock.service.skylifeService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping
@AllArgsConstructor
public class skylifeJoinController {
	
	@Autowired
	private JavaMailSender mailSender;	// 메일 서비스를 사용하기 위해 의존성을 주입함.
	
	private skylifeService service;
	
	//로깅을 위한 변수
	private static final Logger logger= 
	LoggerFactory.getLogger(skylifeJoinController.class);
	private static final String String = null;
	
	@GetMapping("/auth/loginForm")
	public String login() {
		return "/auth/loginForm";
	}

	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return"/auth/joinForm";
	}
	
	@PostMapping("/auth/joinForm")
	public String joinForm(skylifeVO skylifevo,RedirectAttributes redirectAttributes) {
		String hashedPw = BCrypt.hashpw(skylifevo.getPw(), BCrypt.gensalt()); 
		skylifevo.setPw(hashedPw); 
		service.register(skylifevo); 
		redirectAttributes.addFlashAttribute("msg", "REGISTERED");

		return "redirect:/auth/loginForm";
	}
	
	@PostMapping("/auth/loginForm")
	public String loginForm(HttpSession session, skylifeVO skylifevo, Model model ) throws Exception {
		skylifeVO user = service.Login(skylifevo);
		if(user!=null&&BCrypt.checkpw(skylifevo.getPw(), user.getPw())) {
			session.setAttribute("user", user);
			
			return "redirect:/";
		}
		else {
	
			
			return "redirect:/auth/loginForm";
		}
	}
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {

		session.invalidate();

		return "redirect:/";
	}

	
	
	@RequestMapping(value = "/idCheck",method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		int result=service.idCheck(id);
		return Integer.toString(result);
	}
	
//////////////////////////////////////////////////////////////
// 이메일 인증
	@RequestMapping(value="/auth/mailCheck", method=RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception {
		/* 뷰(view)로부터 넘어온 데이터 확인 */
		logger.info("이메일 데이터 전송 확인");
		logger.info("인증메일 : " + email);

		/* 인증번호 (난수) 생성*/
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("인증번호 " + checkNum);

		/* 이메일 보내기 */
		String setFrom = "SkyLifeKorea@gmail.com";
		String toMail = email;
		String title = "회원가입 인증 이메일 입니다.";
		String content =
						"홈페이지를 방문해주셔서 감사합니다." +
						"<br><br>" + 
						"인증 번호는 " + checkNum + "입니다." +
						"<br>" +
						"해당 인증번호를 인증번호 확인칸에 기입하여 주세요.";
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);;
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
		} catch(Exception e) {
			e.printStackTrace();
		}

		String num = Integer.toString(checkNum);

		return num;
	}
	////////////////////////////////////////////////////////
	// 회원정보 수정
	@RequestMapping(value="/page/memView", method = RequestMethod.GET)
	public String memView() throws Exception {
		return "/page/memView";
	}
	
	@RequestMapping(value="/page/memUpdate", method = RequestMethod.GET)
	public String memUpdateView() throws Exception {
		return "/page/memUpdate";
	}
	
	@RequestMapping(value="/memUpdate", method = RequestMethod.POST)
	public String memUpdate(skylifeVO vo, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		String hashedPw = BCrypt.hashpw(vo.getPw(), BCrypt.gensalt()); 
		vo.setPw(hashedPw); 
		service.memUpdate(vo);
		redirectAttributes.addFlashAttribute("msg", "REGISTERED");
		
		session.invalidate();
		
		return "redirect:/";
	}
}
