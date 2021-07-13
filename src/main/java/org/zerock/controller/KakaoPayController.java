package org.zerock.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.pay.domain.OrderVO;
import org.zerock.mapper.OrderMapper;
import org.zerock.service.KakaoPay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;



@Log4j
@Controller
@RequestMapping
@AllArgsConstructor
public class KakaoPayController {

	@Setter(onMethod_ = @Autowired)
    private KakaoPay kakaopay;
    
	@Setter(onMethod_ = {@Autowired})
	private OrderMapper om;
    
	
	
	// 카카오페이 결제 1
    @RequestMapping(value="/kakaoPay", method=RequestMethod.POST)
    public String kakaoPay(OrderVO ovo, HttpServletResponse resp) throws IOException {
        log.info("kakaoPay post start..........");
        log.info("ovo: " + ovo);
        
        return "redirect:" + kakaopay.kakaoPayReady(ovo);
    }
    
    // 카카오페이 결제 2
    @GetMapping("/kakaoPaySuccess")
    public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, HttpSession session, Model model) {
        log.info("kakaoPaySuccess get..........");
        log.info("pg_token: " + pg_token);
        
        String str = String.valueOf(session.getAttribute("user"));
    	String[] arr = str.split(", ");
    	String id = arr[1].substring(3);
        log.info("session id: " + id);
        
        model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token, id));
    }
    
    // 카카오페이 결제 취소
    @GetMapping("/kakaoPayCancel")
    @ResponseBody
    public void kakaoPayCancel(HttpServletResponse resp) throws IOException {
    	resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<br><br><hr><br><h2 style=\"margin-left: 20px;\">결제를 취소하였습니다.</h2><br><br><br>");
        out.println("<div style=\"margin-left: 20px;\"><button onClick=\"location.href='/'\">메인으로</button></div>");
        out.println("<br><br><br><hr><br><br>");
        out.println("</body></html>");
        out.flush();
    }
    
    // 카카오페이 결제 1 -> 실패
    @PostMapping("/kakaoPaySuccessFail")
    @ResponseBody
    public void kakaoPaySuccessFail(HttpServletResponse resp) throws IOException {
    	resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<br><br><hr><br><h2 style=\"margin-left: 20px;\">결제에 실패하였습니다. 관리자에게 문의하세요.</h2><br><br><br>");
        out.println("<div style=\"margin-left: 20px;\"><button onClick=\"location.href='/'\">메인으로</button></div>");
        out.println("<br><br><br><hr><br><br>");
        out.println("</body></html>");
        out.flush();
    }
	
}