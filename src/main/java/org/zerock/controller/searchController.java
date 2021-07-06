package org.zerock.controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String searchFlight(HttpServletRequest request, Model model) throws IOException, ParseException {
		
		String startPortName = request.getParameter("from_place");
		String endPortName = request.getParameter("to_place");
		String startTime = request.getParameter("date_start");
		String endTime = request.getParameter("date_end");
		
		// data format change
		SimpleDateFormat before = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat after = new SimpleDateFormat("yyyyMMdd");
		Date temp01 = before.parse(startTime);
		Date temp02 = before.parse(endTime);
		startTime = after.format(temp01);
		endTime = after.format(temp02);
		
		
		log.info("startPortName: " + startPortName + " // endPortName: " + endPortName 
				+ " // startTime: " + startTime + " // endTime: " + endTime);
		
		ArrayList<searchVO> clist = service.airApi(startPortName, endPortName, startTime);
		
		model.addAttribute("clist", clist);
		//log.info("clist: " + clist);
		
		return "/page/flightList";
		
	}
	
	
	

}
