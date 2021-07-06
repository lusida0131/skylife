package org.zerock.controller;

import org.pay.domain.OrderVO;
import org.zerock.service.KakaoPay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    
//    @GetMapping("/kakaoPay")
//    public void kakaoPayGet() {
//        
//    }    
    @RequestMapping(value="/kakaoPay", method=RequestMethod.POST)
    public String kakaoPay(OrderVO ovo) {
        log.info("kakaoPay post start..........");
        log.info("ovo: " + ovo);
        
        return "redirect:" + kakaopay.kakaoPayReady(ovo);
    }
    
    
    @GetMapping("/kakaoPaySuccess")
    public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
        log.info("kakaoPaySuccess get..........");
        log.info("pg_token: " + pg_token);
        
        model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));
    }
	
}