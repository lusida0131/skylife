package org.zerock.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {
	private ReplyService service;
	
	@RequestMapping(value="/comment", method=RequestMethod.POST)
	@ResponseBody
	public String comment(ReplyVO vo) {
		log.info(vo);
		String result = null;
		service.comment(vo);
		result="order";
		return result;
	}
	@RequestMapping(value = "/commentDelete", method = RequestMethod.GET)
	@ResponseBody
	public void commentdelete(ReplyVO vo) {
		log.info("vo : "+ vo);
	    service.commentdelete(vo);
	}
	@RequestMapping(value = "/commentUpdate", method = RequestMethod.POST)
	@ResponseBody
	public void commentupdate(ReplyVO vo) {
		log.info("vo : " + vo);
	    service.commentupdate(vo);
	   }

}
