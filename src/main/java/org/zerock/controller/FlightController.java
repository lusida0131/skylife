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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.FlightVO;
import org.zerock.service.FlightService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;



@Controller
@RequestMapping
@AllArgsConstructor
@Log4j
public class FlightController {
	
	private FlightService service;
	
	
	
	@RequestMapping(value="/fs/searchFlight", method=RequestMethod.POST)
	public String searchFlight(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ParseException {
		
		String startPortName = request.getParameter("from_place");
		String endPortName = request.getParameter("to_place");
		String startDate = request.getParameter("date_start");
		Integer pageNum = 1;
		
		// data format change
		SimpleDateFormat before = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat after = new SimpleDateFormat("yyyyMMdd");
		Date temp = before.parse(startDate);
		startDate = after.format(temp);
		
		log.info("filght schedule search >>>> startPortName: " + startPortName + " // endPortName: " + endPortName 
				+ " // startDate: " + startDate + " // pageNum: " + pageNum);
		
		
		ArrayList<FlightVO> flist = service.airApi(startPortName, endPortName, startDate, pageNum);
		
		if (flist.isEmpty()) {
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('해당 항공편은 존재하지 않습니다.'); </script>");
	        out.flush();
			
			return "/fs/flight";
		}
		
		FlightVO fhlist = new FlightVO();
		fhlist.setStartPortName(startPortName);
		fhlist.setEndPortName(endPortName);
		fhlist.setStartDate(startDate);
		fhlist.setPageNo(pageNum);
		fhlist.setTotalCount(flist.get(0).getTotalCount());
		fhlist.setEndPN_ko(service.nameset(endPortName));
		
		model.addAttribute("flist", flist);
		model.addAttribute("fhlist", fhlist);
		
		return "/fs/flightList";
		
	}
	
	
	@RequestMapping(value="/fs/flightPage", method=RequestMethod.POST)
	public String flightNext(HttpServletRequest request, Model model) throws IOException, ParseException {
		
		String startPortName = request.getParameter("spn");
		String endPortName = request.getParameter("epn");
		String startDate = request.getParameter("sd");
		Integer pageNum = Integer.parseInt(request.getParameter("pNum"));
		
		log.info("NextPage schedule search >>>> startPortName: " + startPortName + " // endPortName: " + endPortName 
				+ " // startDate: " + startDate + " // pageNum: " + pageNum);
		
		ArrayList<FlightVO> flist = service.airApi(startPortName, endPortName, startDate, pageNum);
		
		FlightVO fhlist = new FlightVO();
		fhlist.setStartPortName(startPortName);
		fhlist.setEndPortName(endPortName);
		fhlist.setStartDate(startDate);
		fhlist.setPageNo(pageNum);
		fhlist.setTotalCount(flist.get(0).getTotalCount());
		fhlist.setEndPN_ko(service.nameset(endPortName));
		
		log.info("fhlist: " + fhlist);
		
		model.addAttribute("flist", flist);
		model.addAttribute("fhlist", fhlist);
		
		return "/fs/flightList";
		
	}

}
