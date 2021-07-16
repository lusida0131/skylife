package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import org.zerock.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping
@AllArgsConstructor
@Log4j
public class AdminController {

	@Autowired
	private OrderService service;

	@GetMapping("/admin/mobthspayment")
	public String joinForm(HttpServletRequest request, Model model) {
		String date = request.getParameter("input_date");

		Integer all = service.data(date);
		log.info("data " + date);

		log.info("all " + all);
		model.addAttribute("all", all);
		return "/admin/mobthspayment";
	}

	// 관리자 페이지 이동
	@GetMapping("/auth/anonymous")
	public String admin() {
		return "auth/anonymous";
	}

	// 관리자 페이지
	@GetMapping("/auth/admin")
	public String admin1() {
		return "/auth/admin";
	}

	//게시판 수정
	@GetMapping("/admin/publicup")
	public String public1() {
		return "/admin/publicup";
	}

	//댓글 수정
	@GetMapping("/admin/product_list")
	public String product() {
		return "/admin/product_list";
	}
}
