package org.zerock.controller;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
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
	
	private skylifeService service;
	
	
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
			
			return "redirect:/home";
		}
		else {
			
			
			return "redirect:/auth/loginForm";
		}
	}

	
	
	@RequestMapping(value = "/idCheck",method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		
<<<<<<< HEAD
		String id = request.getParameter("id");
		int result=service.idCheck(id);
=======
		String userID = request.getParameter("userID");
		int result=service.idCheck(userID);
>>>>>>> e3a52d50edaac527bdc22406ad3eb71c5df6ab45
		return Integer.toString(result);
	}
	
	
	

}
