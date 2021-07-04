package org.zerock.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

@RestController
@RequestMapping("/reply/*")
public class ReplyController {
	private ReplyService replyService;
	
	@RequestMapping("insert")
	public void insert(@ModelAttribute ReplyVO vo, HttpSession session) {
		String id = (String) session.getAttribute("id");
		vo.setId(id);
		replyService.create(vo);
	}
	@RequestMapping("list")
	public ModelAndView list(@RequestParam int b_num, ModelAndView mav) {
		List<ReplyVO> list = replyService.list(b_num);
		mav.setViewName("page/boardView");
		mav.addObject("list", list);
		
		return mav;
	}
}
