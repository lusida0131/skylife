package org.zerock.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	@RequestMapping(value="/reply/delete/{r_num}")
    public ResponseEntity<String> replyDelete(@PathVariable("r_num") Integer r_num){
       
		log.info("r_num 값 : " + r_num);
		ResponseEntity<String> entity = null;
        try {
            service.delete(r_num);
            // 댓글 삭제가 성공하면 성공 상태메시지 저장
            entity = new ResponseEntity<String>("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // 댓글 삭제가 실패하면 실패 상태메시지 저장
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        // 삭제 처리 HTTP 상태 메시지 리턴
        return entity;
    }
}
	
	/*
	 * @RequestMapping(value = "/comment/delete", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public void commentdelete(ReplyVO vo) { log.info("vo : "+ vo);
	 * service.commentdelete(vo); }
	 */
	
	/*
	 * @DeleteMapping(value="/{r_num}", produces =
	 * {MediaType.APPLICATION_XML_VALUE}) public ResponseEntity<String>
	 * remove(@PathVariable("r_num") int r_num) { log.info("remove" + r_num);
	 * 
	 * return service.delete(r_num) == 1 ? new ResponseEntity<>("success",
	 * HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
	 * value="/{r_num}", consumes = "application/json", produces =
	 * {MediaType.TEXT_PLAIN_VALUE})
	 *//*
	 * @ResponseBody public void update(ReplyVO vo) { log.info("vo : " + vo);
	 * service. update(vo); }
	 */

