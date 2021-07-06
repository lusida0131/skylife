package org.zerock.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.BoardVO;
import org.zerock.domain.ReplyVO;
import org.zerock.domain.skylifeVO;
import org.zerock.service.BoardService;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@AllArgsConstructor
@RequestMapping
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService service;
	
	@Autowired
	ReplyService Replyservice;
	
	// 게시글 목록
	@GetMapping("/page/board")
	public String boardList(BoardVO vo, Model model) {
		log.info("call board list");
		List<BoardVO> list = service.list(vo);
		model.addAttribute("list", list);
		
		return "/page/board";
	}
	
	// 게시글 작성
	@GetMapping("/page/boardWrite")
	public String write(@ModelAttribute skylifeVO vo) {
		log.info("board write button click");
		return "/page/boardWrite";
	}
	@PostMapping("/page/boardWrite")
	public String write1(@ModelAttribute BoardVO vo) {
		service.insert(vo);
		log.info("write success: " + vo);
		
		return "redirect:/page/board";
	}
	
	// 게시글 조회

	@GetMapping("/page/boardView")
	public String view1(Model model, @RequestParam int b_num) throws Exception {
		BoardVO data = service.view(b_num);
		model.addAttribute("data", data);
		log.info("돌아가~ " + data);
		List<ReplyVO> replyData = Replyservice.selectcomment(b_num);
		model.addAttribute("replyData", replyData);
		log.info("돌아가~ " + replyData);

		return "/page/boardView";
	}

	
	@GetMapping("/board/update")
	public String updatePage() throws Exception {
		return "/page/boardUpdate";
	}
	
	// 게시글 수정 (기능)
	@RequestMapping(value="/board/update", method=RequestMethod.POST)
	public String update(@ModelAttribute BoardVO vo) throws Exception {
		service.update(vo);
		log.info("update success: " + vo);
		
		return "redirect:/page/board";
	}
//	@GetMapping("/page/boardUpdate")
//	public String update1(@ModelAttribute skylifeVO vo) {
//		log.info("수정전");
//		return "/page/boardUpdate";
//	}
	
	// 게시글 삭제
	@RequestMapping("board/delete")
	public String delete(@RequestParam int b_num) throws Exception {
		service.delete(b_num);
		
		return "redirect:/page/board";
	}
}
