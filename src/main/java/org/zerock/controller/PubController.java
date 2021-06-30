package org.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.PubVO;
import org.zerock.service.PubService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/pub/*")
@AllArgsConstructor
public class PubController {
	private PubService service;
	
	@GetMapping("/public")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	@GetMapping("/modify")
	public String modify(PubVO pub, RedirectAttributes rttr) {
		log.info("modify" + pub);
		if(service.modify(pub)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/pub/public";
	}
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(PubVO pub, RedirectAttributes rttr) {
		log.info("register: " + pub);
		service.insert(pub);
		rttr.addFlashAttribute("result", pub.getPno());
		return "redirect:/pub/public";
	}
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Integer pno, RedirectAttributes rttr) {
		log.info("remove..." +pno);
		if(service.remove(pno) ) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/pub/public";
	}
	/*
	 * @RequestMapping(value="/public", method=RequestMethod.POST,
	 * produces="application/text; charset=utf8") // @GetMapping("/loginForm")
	 * // @PostMapping("/loginForm") public String loginForm(PubVO pub, Model model,
	 * HttpSession session) throws Exception { PubVO pvo = service.insert(pub);
	 * session.setAttribute("list", pvo); return "redirect:/pub/public"; }
	 */
}
