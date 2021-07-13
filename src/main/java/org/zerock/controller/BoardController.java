package org.zerock.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.domain.ReplyPageDTO;
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
	
	@GetMapping("/page/board")
	public void boardList(Criteria cri, Model model) {
		log.info("list..." + cri);
		model.addAttribute("list", service.list(cri));	// 게시글 목록
		// 페이징 처리를 위해 PageDTO 객체를 전달 -> jsp 페이지에서 페이징 처리를 한다.
		int total = service.getTotal(cri);
		log.info("total: " + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));

//		model.addAttribute("pageMaker", new PageDTO(cri, 123));	// total을 계산해 주어야 함
	}
	
	
	
	// 게시글 목록
//	@GetMapping("/page/board")
//	public String boardList(BoardVO vo, Model model) {
//		log.info("call board list");
//		List<BoardVO> list = service.list(vo);
//		model.addAttribute("list", list);
//		
//		return "/page/board";
//	}
//	
	
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
	public String view1(Model model,Criteria cri, @RequestParam int b_num) throws Exception {
		// 조회수
		service.increaseViewcnt(b_num);
		
		BoardVO data = service.view(b_num);
		model.addAttribute("data", data);
		log.info("board: " + data);
		List<ReplyVO> replyData = Replyservice.selectcomment(cri, b_num);
		model.addAttribute("replyData", replyData);
		log.info("reply: " + replyData);;

		return "/page/boardView";
	}
	
//	@GetMapping(value ="/page/boardView/{b_num}/{page}", produces = { MediaType.APPLICATION_XML_VALUE,
//			MediaType.APPLICATION_JSON_UTF8_VALUE })
//	public String view2(@PathVariable("page") int page, Model model, @RequestParam int b_num) throws Exception {
//		BoardVO data = service.view(b_num);
//		model.addAttribute("data", data);
//		log.info("돌아가~ " + data);
//		Criteria cri = new Criteria(page, 10);
//		List<ReplyVO> replyData = Replyservice.selectcomment(cri, b_num);
//		model.addAttribute("replyData", replyData);
//		log.info("돌아가~ " + replyData);
//
//		return "/page/boardView";
//	}
//	
//	@GetMapping(value = "/pages/{b_num}/{page}", produces = { MediaType.APPLICATION_XML_VALUE,
//			MediaType.APPLICATION_JSON_UTF8_VALUE })
//	public ResponseEntity<ReplyPageDTO> getList(@PathVariable("page") int page, Model model, @PathVariable("b_num") Integer b_num) {
//		
//		Criteria cri = new Criteria(page, 10);
//		log.info(cri);
//		return new ResponseEntity<ReplyPageDTO>(Replyservice.getListPage(cri, b_num), HttpStatus.OK);
//	}
//	
	
	

	
	@GetMapping("/board/update")
	public void updatePage(@RequestParam("b_num") Integer b_num, Model model) throws Exception {
		model.addAttribute("blist", service.view(b_num));
//		return "redirect:/page/boardUpdate";
	}
	
	// 게시글 수정 (기능)
	@RequestMapping(value="/board/update", method=RequestMethod.POST)
	public String update(@ModelAttribute BoardVO vo) throws Exception {
		log.info("board update success");
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
	
	@RequestMapping("/testjsp/rrrr")
	public String sadf() throws Exception {
		return "/testjsp/rrrr";
	}
}
