package org.zerock.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.pay.domain.OrderVO;
import org.zerock.domain.searchVO;
import org.zerock.mapper.OrderMapper;
import org.zerock.service.searchService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;



@Controller
@RequestMapping
@AllArgsConstructor
@Log4j
public class searchController {
	
	private searchService service;
	
	@Setter(onMethod_ = {@Autowired})
	private OrderMapper om;
	
	@PostMapping("/fs/flightList")
	public String flightViewTest() {
		return"/fs/flightList";
	}
	
	
	@RequestMapping(value="/fs/searchFlight", method=RequestMethod.POST)
	public String searchFlight(HttpServletRequest request, Model model) throws IOException, ParseException {
		
		String startPortName = request.getParameter("from_place");
		String endPortName = request.getParameter("to_place");
		String startTime = request.getParameter("date_start");
		//String endTime = request.getParameter("date_end");
		
		// data format change
		SimpleDateFormat before = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat after = new SimpleDateFormat("yyyyMMdd");
		Date temp01 = before.parse(startTime);
		//Date temp02 = before.parse(endTime);
		startTime = after.format(temp01);
		//endTime = after.format(temp02);
		
		
		log.info("startPortName: " + startPortName + " // endPortName: " + endPortName + " // startTime: " + startTime);
		
		ArrayList<searchVO> clist = service.airApi(startPortName, endPortName, startTime);
		
		model.addAttribute("clist", clist);
		//log.info("clist: " + clist);
		
		return "/fs/flightList";
		
	}
	
    @PostMapping("/addwish")
    public void sWish(OrderVO ovo, HttpServletResponse response) throws IOException {

        log.info("your wish get..........");
        log.info("ovo: " + ovo);
        
        om.WishInsert(ovo);
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('wish list에 추가되었습니다.'); </script>");
        out.flush();
        
    }
    
    @GetMapping("/fs/wish")
    public String wish(HttpSession session, Model model) {

    	String str = String.valueOf(session.getAttribute("user"));
    	String[] arr = str.split(", ");
    	String id = arr[1].substring(3);
    	
    	ArrayList<OrderVO> wlist = om.WishList(id);
    	
    	model.addAttribute("wlist", wlist);
    	
    	log.info("wlist: " + wlist);
    	
    	return "/fs/wish";
    }

}
