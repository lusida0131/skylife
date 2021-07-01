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



@Controller
@RequestMapping
@AllArgsConstructor
public class searchController {
	
	private searchService service;
	
	
//	@GetMapping("/page/flightViewTest")
//	public String flightViewTestG() {
//		return"/page/flightViewTest";
//	}
	@PostMapping("/page/flightViewTest")
	public String flightViewTest() {
		return"/page/flightViewTest";
	}
	
	
	//@RequestMapping(value="/page/flightViewTest", method=RequestMethod.POST)
	@RequestMapping(value="/page/searchFlight", method=RequestMethod.POST)
	public String searchFlight(HttpServletRequest request, searchVO sVO, Model model) throws IOException {
		
		String startPortName = request.getParameter("from_place");
		String endPortName = request.getParameter("to_place");
		String startTime = request.getParameter("date_start");
		//String endTime = request.getParameter("date_end");

//		System.out.println("@@@@@@@@@@\n@startPortName: " + startPortName + "\n@endPortName: " + endPortName 
//				+ "\n@startTime: " + startTime + "\n@endTime: " + endTime + "\n@@@@@@@@@@");
		System.out.println("@@@@@@@@@@\n@startPortName: " + startPortName + "\n@endPortName: " + endPortName 
				+ "\n@startTime: " + startTime + "\n@@@@@@@@@@");
		
		ArrayList<searchVO> clist = service.airApi();
		//ArrayList<searchVO> clist = service.airApi(startPortName, endPortName, startTime);
		
		model.addAttribute("clist", clist);
		System.out.println("\n clist: " + clist);
		
		return "/page/flightViewTest";
		
	}
	
	
	

}
