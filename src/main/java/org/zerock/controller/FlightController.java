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
	
	
	
	// 항공편 스케줄 조회
	@RequestMapping(value="/fs/searchFlight", method=RequestMethod.POST)
	public String searchFlight(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ParseException {
		
		// 출발날짜 미지정 조회시
		if ("".equals(request.getParameter("date_start")) || (request.getParameter("date_start")) == null) {
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('출발 날짜를 선택해주세요.'); </script>");
	        out.flush();
			return "/fs/flight";
		}
		
		String startPortName = request.getParameter("from_place");
		String endPortName = request.getParameter("to_place");
		String startDate = request.getParameter("date_start");
		String airline = "";
		Integer pageNum = 1;
		// data format change
		SimpleDateFormat before = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat after = new SimpleDateFormat("yyyyMMdd");
		Date temp = before.parse(startDate);
		startDate = after.format(temp);
		
		// 항공사 선택옵션 null값 처리
		if ("".equals(request.getParameter("airline")) || (request.getParameter("airline")) == null) {
			airline = "";
		} else {
			airline = request.getParameter("airline");
		}
		
		log.info("filght schedule search >>>> startPortName: " + startPortName + " // endPortName: " + endPortName 
				+ " // startDate: " + startDate + " // airline: " + airline + " // pageNum: " + pageNum);
		
		ArrayList<FlightVO> flist = service.airApi(startPortName, endPortName, startDate, airline, pageNum);
		
		if (flist.isEmpty()) { // api 조회 결과가 없을 때 = 항공편 미존재
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('해당 항공편은 존재하지 않습니다.'); </script>");
	        out.flush();
			
			return "/fs/flight";
		}
		
		FlightVO fhlist = new FlightVO(startPortName, endPortName, startDate, airline, pageNum, 
				flist.get(0).getTotalCount(), service.nameset(endPortName));
		
		// flist : api요청 결과		fhlist : api요청 정보
		model.addAttribute("flist", flist);
		model.addAttribute("fhlist", fhlist);
		
		return "/fs/flightList";
		
	}
	
	// 항공편 스케줄 조회 페이지이동
	@RequestMapping(value="/fs/flightPage", method=RequestMethod.POST)
	public String flightNext(HttpServletRequest request, Model model) throws IOException, ParseException {
		
		String startPortName = request.getParameter("spn");
		String endPortName = request.getParameter("epn");
		String startDate = request.getParameter("sd");
		String airline = request.getParameter("al");
		Integer pageNum = Integer.parseInt(request.getParameter("pNum"));
		
		log.info("filght schedule search >>>> startPortName: " + startPortName + " // endPortName: " + endPortName 
				+ " // startDate: " + startDate + " // airline: " + airline + " // pageNum: " + pageNum);
		
		// flist : api요청 결과		fhlist : api요청 정보
		ArrayList<FlightVO> flist = service.airApi(startPortName, endPortName, startDate, airline, pageNum);
		FlightVO fhlist = new FlightVO(startPortName, endPortName, startDate, airline, pageNum, 
								flist.get(0).getTotalCount(), service.nameset(endPortName));

		model.addAttribute("flist", flist);
		model.addAttribute("fhlist", fhlist);
		
		return "/fs/flightList";
		
	}

}
