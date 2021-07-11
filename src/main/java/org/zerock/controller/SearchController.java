package org.zerock.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.SearchVO;
import org.zerock.service.SearchService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;



@Controller
@RequestMapping
@AllArgsConstructor
@Log4j
public class SearchController {
	
	private SearchService service;
	

	
	@PostMapping("/fs/flightList")
	public String flightViewTest() {
		return"/fs/flightList";
	}
	
	
	@RequestMapping(value="/fs/searchFlight", method=RequestMethod.POST)
	public String searchFlight(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ParseException {
		
		String startPortName = request.getParameter("from_place");
		String endPortName = request.getParameter("to_place");
		String startTime = request.getParameter("date_start");
		
		// data format change
		SimpleDateFormat before = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat after = new SimpleDateFormat("yyyyMMdd");
		Date temp = before.parse(startTime);
		startTime = after.format(temp);
		
		log.info("filght schedule search >>>> startPortName: " 
					+ startPortName + " // endPortName: " + endPortName + " // startTime: " + startTime);
		
		
		ArrayList<SearchVO> clist = service.airApi(startPortName, endPortName, startTime);
		
		if (clist.isEmpty()) {
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('해당 항공편은 존재하지 않습니다.'); </script>");
	        out.flush();
			
			return "/fs/flight";
		}
		
		model.addAttribute("clist", clist);
		
		return "/fs/flightList";
		
	}


}
