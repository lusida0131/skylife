package org.zerock.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.zerock.domain.searchVO;
import org.zerock.service.searchService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;



@Controller
@RequestMapping
@AllArgsConstructor
@Log4j
public class searchController {
	
	private searchService service;
	
	
	@PostMapping("/page/flightList")
	public String flightViewTest() {
		return"/page/flightList";
	}
	
	
	@RequestMapping(value="/page/searchFlight", method=RequestMethod.POST)
	public String searchFlight(HttpServletRequest request, searchVO sVO, Model model) throws IOException {
		
		String startPortName = request.getParameter("from_place");
		String endPortName = request.getParameter("to_place");
		String startTime = request.getParameter("date_start");
		
		log.info("startPortName: " + startPortName + " // endPortName: " + endPortName + " // startTime: " + startTime);
		
		//ArrayList<searchVO> clist = service.airApi();
		ArrayList<searchVO> clist = service.airApi(startPortName, endPortName, startTime);
		
		model.addAttribute("clist", clist);
		log.info("clist: " + clist);
		
		return "/page/flightList";
		
	}
	
	
	

}
