package org.zerock.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.domain.SfileVO;
import org.zerock.domain.skylifeVO;
import org.zerock.service.BoardService;
import org.zerock.service.ReplyService;
import org.zerock.service.SfileService;

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
	
	@Autowired
	SfileService fservice;
	
	// 게시글 리스트
	@GetMapping("/board/board")
	public void boardList(Criteria cri, Model model) {
		log.info("list..." + cri);
		model.addAttribute("list", service.list(cri));	// 게시글 목록
		// 페이징 처리를 위해 PageDTO 객체를 전달 -> jsp 페이지에서 페이징 처리를 한다.
		int total = service.getTotal(cri);
		log.info("total: " + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));

	}
	
	

	
	// 게시글 작성
	@GetMapping("/page/boardWrite")
	public String write(@ModelAttribute skylifeVO vo) {
		log.info("board write button click");
		return "/board/boardWrite";
	}
	// 게시글 작성
	@PostMapping("/page/boardWrite")
	public String write1(@ModelAttribute BoardVO vo) {
		service.insert(vo);
		log.info("write success: " + vo);
		
		return "redirect:/board/board";
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

		return "/board/boardView";
	}
		

	// 게시글 수정 폼
	@GetMapping("/board/update")
	public void updatePage(@RequestParam("b_num") Integer b_num, Model model) throws Exception {
		model.addAttribute("blist", service.view(b_num));
	}
	
	// 게시글 수정 (기능)
	@RequestMapping(value="/board/update", method=RequestMethod.POST)
	public String update(@ModelAttribute BoardVO vo) throws Exception {
		log.info("board update success");
		service.update(vo);
		log.info("update success: " + vo);
		
		return "redirect:/board/board";
	}

	
	// 게시글 삭제
	@RequestMapping("board/delete")
	public String delete(@RequestParam int b_num) throws Exception {
		service.delete(b_num);
		
		return "redirect:/board/board";
	}
	
	/*************************** 파일 업로드 **********************************/
	// bean의 id가 uploadPath인 태그를 참조
	@Resource(name="uploadPath")
	String uploadPath;
	
	@RequestMapping(value="/fileTest/fileupload2", method=RequestMethod.GET)
    public String fileupload() {
        return "fileUpload/fileupload2";
    }
	
	// 업로드 흐름 : 업로드 버튼을 클릭 -> 임시디렉토리에 업로드 => 지정된 디렉토리에 저장  => 파일정보가 file에 저장
	@RequestMapping(value="/fileTest/fileupload", method=RequestMethod.POST)
	public ModelAndView uploadForm(MultipartFile file, ModelAndView mav, SfileVO fvo) throws Exception {
		
		log.info("파일 이름 : " + file.getOriginalFilename());
		log.info("파일 크기 : " + file.getSize());
		log.info("컨텐츠 타입 : " + file.getContentType());
		
		String fileName = file.getOriginalFilename();
		
		// 업로드 폴더 생성
		if(!new File(uploadPath).exists()) {
			new File(uploadPath).mkdirs();
		}
		
		// 파일이름 중복 방지
		UUID uuid = UUID.randomUUID();
		fileName = uuid.toString() + "_" + fileName;
		
		// 파일 저장
		File savefile = new File(uploadPath, fileName);
		try {
		// FileCopyUtils.copy(바이트배열, 파일객체)
		file.transferTo(savefile);
		mav.addObject("file", file);
		fvo.setUuid(uuid.toString());
		fvo.setUploadPath(uploadPath);
		fvo.setFileName(fileName);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("file", "error");
		}
		
		// View 위치 설정
		mav.setViewName("fileUpload/fileupload");
		mav.addObject("fileName", fileName);
		
		// 업로드 결과화면으로 포워딩
		fservice.insert(fvo);
		return mav;
	}
}