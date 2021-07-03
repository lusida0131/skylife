package org.zerock.controller;




import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.skylifeVO;
import org.zerock.service.KakaoAPI;
import org.zerock.service.skylifeService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping
@AllArgsConstructor
public class skylifeJoinController {
	
	private skylifeService service;
	private KakaoAPI kakao;
	
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
			
			return "redirect:/page/index";
		}
		else {
			
			
			return "redirect:/auth/loginForm";
		}
	}
	
	//카카오 로그인 할때 사용
	@RequestMapping(value="/auth/loginForm")
	public String login(@RequestParam("code") String code, HttpSession session) {
	    String access_Token = kakao.getAccessToken(code);
	    HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
	    System.out.println("login Controller : " + userInfo);
	    
	    //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
	    if (userInfo.get("email") != null) {
	        session.setAttribute("userId", userInfo.get("email"));
	        session.setAttribute("access_Token", access_Token);
	    }
	    return "redirect:/page/index";
	}
	
	@RequestMapping(value = "/idCheck",method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		
		String userID = request.getParameter("userID");
		int result=service.idCheck(userID);
		return Integer.toString(result);
	}
	
	@RequestMapping(value="/auth/index")
	public String index() {
	    System.out.println("auth/index : ");
	    return "page/index";
	}
	
	

}
