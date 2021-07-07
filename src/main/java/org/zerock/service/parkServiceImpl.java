package org.zerock.service;

import org.pay.domain.ParkInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.zerock.mapper.parkMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Service
public class parkServiceImpl implements parkService {
	parkMapper mapper;

	@Override
	public List<ParkInfoVO> parkApi(String parkingAirportCodeName, String parkingFullSpace, String parkinglIncnt,
			String parkingGettime, String aprKor, String parkingIincnt) throws IOException {
		
		ArrayList<ParkInfoVO> list = new ArrayList<ParkInfoVO>();
		
		//url
		StringBuilder urlBuilder = new StringBuilder("http://openapi.airport.co.kr/service/rest/AirportParking/airportparkingRT");
		// Service Key
				urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=c1sNS0F8dzRRFujphkwtO4hhp5OmOL%2FM8ZD31ri59F0wB%2B3CtmKCGRzhXc43qEHoEvIdMERNztk0vvVjdNKOFA%3D%3D");
				// 한 페이지 결과 수
				urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8"));
				// 페이지 번호
				urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
				// 주차공간명
				urlBuilder.append("&" + URLEncoder.encode("parkingAirportCodeName","UTF-8") + "=" + URLEncoder.encode(parkingAirportCodeName, "UTF-8"));
				// 총 주차공간
				urlBuilder.append("&" + URLEncoder.encode("parkingFullSpace","UTF-8") + "=" + URLEncoder.encode(parkingFullSpace, "UTF-8"));
				// 출발일
				urlBuilder.append("&" + URLEncoder.encode("parkingIincnt","UTF-8") + "=" + URLEncoder.encode(parkingIincnt, "UTF-8"));
				// 업데이트 시간
				urlBuilder.append("&" + URLEncoder.encode("parkingGettime","UTF-8") + "=" + URLEncoder.encode(parkingGettime, "UTF-8"));
				// 공항명
				urlBuilder.append("&" + URLEncoder.encode("aprKor","UTF-8") + "=" + URLEncoder.encode("aprKor", "UTF-8"));
				// json type return
				urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
		
				URL url = new URL(urlBuilder.toString());
			    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			    conn.setRequestMethod("GET");
			    conn.setRequestProperty("Content-type", "application/json");
			    log.info("api URL Response code: " + conn.getResponseCode());
			    System.out.println("api URL Response code: " + conn.getResponseCode());
			    
			    BufferedReader rd;
			    if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			        rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			    } else {
			        rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			    }
			    
			    StringBuilder sb = new StringBuilder();
			    String line;
			    while ((line = rd.readLine()) != null) {
			        sb.append(line);
			    }
			    rd.close();
			    conn.disconnect();
			    
		return null;
		/* return list; */
	}
	
	
}