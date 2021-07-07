package org.zerock.controller;

import java.util.List;

import org.pay.domain.ParkInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@AllArgsConstructor
@RequestMapping
public class ParkController {
	
	@GetMapping("/page/Park")
	public List<ParkInfoVO> allPark() throws Exception {
		
		return null;
	}
	
	@GetMapping("/Park/GMPList")
	public String GMPList() throws Exception {
		return "/Park/GMPList";
	}
}
