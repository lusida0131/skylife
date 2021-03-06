package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.ICNVO;
import org.zerock.domain.ParkInfoVO;
import org.zerock.service.parkService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@AllArgsConstructor
@RequestMapping
public class ParkController {
	parkService service;
	
	// 주차장 목록
	@GetMapping("/page/Park")
	public List<ParkInfoVO> allPark() throws Exception {
		
		return null;
	}
	// 김포 
	@GetMapping("/Park/GMPList")
	public String GMPList(Model model) throws Exception {

		String schAirportCode = "GMP";
		
		String pname = "김포 국제 공항";
		
		ArrayList<ParkInfoVO> plist = service.parkApi(schAirportCode);
		model.addAttribute("plist", plist);
		model.addAttribute("pname", pname);
		return "/Park/ParkList";
	}
	
	// 김해 (PUS)
	@GetMapping("/Park/PUSList")
	public String PUSList(Model model) throws Exception {

		String schAirportCode = "PUS";
		
		String pname = "김해/부산 국제 공항";
		
		ArrayList<ParkInfoVO> plist = service.parkApi(schAirportCode);
		model.addAttribute("plist", plist);
		model.addAttribute("pname", pname);
		return "/Park/ParkList";
	}
	
	// 제주(CJU)
	@GetMapping("/Park/CJUList")
	public String CJUList(Model model) throws Exception {

		String schAirportCode = "CJU";
		
		String pname = "제주 국제 공항";
		
		ArrayList<ParkInfoVO> plist = service.parkApi(schAirportCode);
		model.addAttribute("plist", plist);
		model.addAttribute("pname", pname);
		return "/Park/ParkList";
	}
	
	// 대구 (TAE)
	@GetMapping("/Park/TAEList")
	public String TAEList(Model model) throws Exception {

		String schAirportCode = "TAE";
		
		String pname = "대구 국제 공항";
		
		ArrayList<ParkInfoVO> plist = service.parkApi(schAirportCode);
		model.addAttribute("plist", plist);
		model.addAttribute("pname", pname);
		return "/Park/ParkList";
	}
	
	// 청주 (CJJ) 
	@GetMapping("/Park/CJJList")
	public String CJJList(Model model) throws Exception {

		String schAirportCode = "CJJ";
		
		String pname = "청주 국제 공항";
		
		ArrayList<ParkInfoVO> plist = service.parkApi(schAirportCode);
		model.addAttribute("plist", plist);
		model.addAttribute("pname", pname);
		return "/Park/ParkList";
	}
	
	// 광주(KWJ)
	@GetMapping("/Park/KWJList")
	public String KWJList(Model model) throws Exception {

		String schAirportCode = "KWJ";
		
		String pname = "광주 공항";
		
		ArrayList<ParkInfoVO> plist = service.parkApi(schAirportCode);
		model.addAttribute("plist", plist);
		model.addAttribute("pname", pname);
		return "/Park/ParkList";
	}
	// 여수 (RSU)
	@GetMapping("/Park/RSUList")
	public String RSUList(Model model) throws Exception {

		String schAirportCode = "RSU";
		
		String pname = "여수 공항";
		
		ArrayList<ParkInfoVO> plist = service.parkApi(schAirportCode);
		model.addAttribute("plist", plist);
		model.addAttribute("pname", pname);
		return "/Park/ParkList";
	}
	
	// 울산 (USN)
	@GetMapping("/Park/USNList")
	public String USNList(Model model) throws Exception {

		String schAirportCode = "USN";
		
		String pname = "울산 공항";
		
		ArrayList<ParkInfoVO> plist = service.parkApi1(schAirportCode);
		model.addAttribute("plist", plist);
		model.addAttribute("pname", pname);
		return "/Park/ParkList";
	}
	
	// 군산 (KUV)
	@GetMapping("/Park/KUVList")
	public String KUVList(Model model) throws Exception {

		String schAirportCode = "KUV";
		
		String pname = "군산 공항";
		
		ArrayList<ParkInfoVO> plist = service.parkApi1(schAirportCode);
		model.addAttribute("plist", plist);
		model.addAttribute("pname", pname);
		return "/Park/ParkList";
	}
	
	// 원주 (WJU)
	@GetMapping("/Park/WJUList")
	public String WJUList(Model model) throws Exception {

		String schAirportCode = "WJU";
		
		String pname = "원주 공항";
		
		ArrayList<ParkInfoVO> plist = service.parkApi1(schAirportCode);
		model.addAttribute("plist", plist);
		model.addAttribute("pname", pname);
		return "/Park/ParkList";
	}
	
	// 인천(ICN)
	@GetMapping("/Park/ICNList")
	public String ICNList(Model model) throws Exception {
		
		String pname = "인천 국제 공항";
		
		ArrayList<ICNVO> plist = service.icnInfo();
		model.addAttribute("plist", plist);
		model.addAttribute("pname", pname);
		
		System.out.println(plist);
		return "/Park/ParkICN";
	}
}
