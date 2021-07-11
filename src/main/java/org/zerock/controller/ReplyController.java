package org.zerock.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService service;
	
	
	@GetMapping(value = "/replies/pages/{b_num}/{page}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ReplyPageDTO> getList(
			@PathVariable("page") int page, @PathVariable("b_num") Integer b_num) {

		log.info("getList............");
		Criteria cri = new Criteria(page, 10);
		log.info(cri);
		
		return new ResponseEntity<ReplyPageDTO>(service.getListPage(cri, b_num), HttpStatus.OK);
	}
	

	@RequestMapping(value="/comment", method=RequestMethod.POST)
	@ResponseBody
	public String comment(ReplyVO vo) {
		log.info("vo=" + vo);
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
	@RequestMapping(value="/replies/update", method=RequestMethod.POST) //댓글 수정  
    @ResponseBody
    private int mCommentServiceUpdateProc(@RequestParam int r_num, @RequestParam String r_content) throws Exception{
		
		
        ReplyVO comment = new ReplyVO();
        comment.setR_num(r_num);
        comment.setR_content(r_content);
        
        return service.update(comment);
    }
}
	
