package org.zerock.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.pay.domain.OrderVO;
import org.zerock.mapper.OrderMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;



@Controller
@RequestMapping
@AllArgsConstructor
@Log4j
public class OrderController {
	
	
	@Setter(onMethod_ = {@Autowired})
	private OrderMapper om;
	

	
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
    	log.info("movement wish list: " + wlist);
    	
    	return "/fs/wish";
    }
    
    @RequestMapping(value="/fs/wishDelete", method=RequestMethod.POST, produces="application/text; charset=utf8")
	@ResponseBody
    public String wishDelete(int w_num) {
    	log.info("delete wishlist item (w_num) :" + w_num);
    	
    	Integer result = om.WishDelete(w_num);
    	
    	if(result == 0) { // delete fail
    		return "fail";
    	}
    	
    	return "success";
    }
    
    @GetMapping("/fs/payment")
    public String paymentList(HttpSession session, Model model) {

    	String str = String.valueOf(session.getAttribute("user"));
    	String[] arr = str.split(", ");
    	String id = arr[1].substring(3);
    	
    	ArrayList<OrderVO> pmlist = om.PaymentList(id);
    	model.addAttribute("pmlist", pmlist);
    	log.info("movement payment list: " + pmlist);
    	
    	return "/fs/payment";
    }

}