package org.zerock.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.zerock.domain.ICNVO;
import org.zerock.domain.ParkInfoVO;
import org.zerock.domain.searchVO;
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
	public ArrayList<ParkInfoVO> parkApi(String schAirportCode) throws IOException {
		
		ArrayList<ParkInfoVO> list = new ArrayList<ParkInfoVO>();
		
		//url
		StringBuilder urlBuilder = new StringBuilder("http://openapi.airport.co.kr/service/rest/AirportParking/airportparkingRT");
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=c1sNS0F8dzRRFujphkwtO4hhp5OmOL%2FM8ZD31ri59F0wB%2B3CtmKCGRzhXc43qEHoEvIdMERNztk0vvVjdNKOFA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        // 한 페이지 결과 수
     	urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8"));
     	// 페이지 번호
     	urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("schAirportCode","UTF-8") + "=" + URLEncoder.encode(schAirportCode, "UTF-8")); /*공항명*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
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
        
        System.out.println(sb.toString());    
			    
		//========================= (list code) =========================
        String jsonString = sb.toString();
	    // 가장 큰 JSONObject를 가져옵니다.
	    JSONObject jObject = new JSONObject(jsonString);
	    
	    // (response)  0번째 JSONObject를 가져옵니다.
	    JSONObject responseObject = jObject.getJSONObject("response");
	    
	    // (response -> header)  1번째 JSONObject를 가져와서 key-value를 읽습니다.
	    JSONObject headerObject = responseObject.getJSONObject("header");
	    String resultCode = headerObject.getString("resultCode");
	    String resultMsg = headerObject.getString("resultMsg");
	    log.info("(header)resultCode: " + resultCode);
	    log.info("(header)resultMsg: " + resultMsg);
	    
	    JSONObject bodyObject = responseObject.getJSONObject("body");
	    JSONObject itemsObject = bodyObject.getJSONObject("items");
//	    String numOfRows = Integer.toString(bodyObject.getInt("numOfRows"));
//	    String pageNo = Integer.toString(bodyObject.getInt("pageNo"));
//	    String totalCount = Integer.toString(bodyObject.getInt("totalCount"));
//	    log.info("(body)totalCount: " + totalCount);
	    
	 // (response -> body -> items -> item(node 2개이상))  세번째 JSONObject를 가져와서 key-value를 읽습니다.
	    JSONArray itemArray = itemsObject.getJSONArray("item");
	    for (int i = 0; i < itemArray.length(); i++) {
	    	
	    	ParkInfoVO pvo = new ParkInfoVO();
	    	JSONObject iobj = itemArray.getJSONObject(i);
	    	//log.info("iobj(" + i + "): " + iobj.toString());
	        
	        // 공항명
	        pvo.setAprKor(iobj.getString("aprKor"));
	        // 주차장명
	        pvo.setParkingAirportCodeName(iobj.getString("parkingAirportCodeName"));
	        // 총 주차구역
	        pvo.setParkingFullSpace(iobj.getInt("parkingFullSpace"));
	        // 주차된 차
	        pvo.setParkingIstay(iobj.getInt("parkingIstay"));
	        // 업데이트 시간
	        pvo.setParkingGettime(iobj.getString("parkingGettime"));
	        
	        
	        
	        
	        log.info(i + "번째 item: " + pvo);
	        
	        list.add(pvo);
	        
	       
	    }
		
		System.out.println("list: " + list);
		return list;
		/* return list; */
	}
	
	@Override
	public ArrayList<ParkInfoVO> parkApi1(String schAirportCode) throws IOException {
		
		ArrayList<ParkInfoVO> list = new ArrayList<ParkInfoVO>();
		
		//url
		StringBuilder urlBuilder = new StringBuilder("http://openapi.airport.co.kr/service/rest/AirportParking/airportparkingRT");
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=c1sNS0F8dzRRFujphkwtO4hhp5OmOL%2FM8ZD31ri59F0wB%2B3CtmKCGRzhXc43qEHoEvIdMERNztk0vvVjdNKOFA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        // 한 페이지 결과 수
     	urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8"));
     	// 페이지 번호
     	urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("schAirportCode","UTF-8") + "=" + URLEncoder.encode(schAirportCode, "UTF-8")); /*공항명*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
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
        
        System.out.println(sb.toString());    

			    
		//========================= (list code) =========================
        String jsonString = sb.toString();
	    // 가장 큰 JSONObject를 가져옵니다.
	    JSONObject jObject = new JSONObject(jsonString);
	    
	    // (response)  0번째 JSONObject를 가져옵니다.
	    JSONObject responseObject = jObject.getJSONObject("response");
	    
	    // (response -> header)  1번째 JSONObject를 가져와서 key-value를 읽습니다.
	    JSONObject headerObject = responseObject.getJSONObject("header");
	    String resultCode = headerObject.getString("resultCode");
	    String resultMsg = headerObject.getString("resultMsg");
	    log.info("(header)resultCode: " + resultCode);
	    log.info("(header)resultMsg: " + resultMsg);
	    
	    JSONObject bodyObject = responseObject.getJSONObject("body");
	    JSONObject itemsObject = bodyObject.getJSONObject("items");
//	    String numOfRows = Integer.toString(bodyObject.getInt("numOfRows"));
//	    String pageNo = Integer.toString(bodyObject.getInt("pageNo"));
//	    String totalCount = Integer.toString(bodyObject.getInt("totalCount"));
//	    log.info("(body)totalCount: " + totalCount);
	    
	 // (response -> body -> items -> item(node 2개이상))  세번째 JSONObject를 가져와서 key-value를 읽습니다.
	    
	    JSONObject iobj = itemsObject.getJSONObject("item");
			
	    ParkInfoVO pvo = new ParkInfoVO();
    	
    	//log.info("iobj(" + i + "): " + iobj.toString());
        
        // 공항명
        pvo.setAprKor(iobj.getString("aprKor"));
        // 주차장명
        pvo.setParkingAirportCodeName(iobj.getString("parkingAirportCodeName"));
        // 총 주차구역
        pvo.setParkingFullSpace(iobj.getInt("parkingFullSpace"));
        // 주차된 차
        pvo.setParkingIstay(iobj.getInt("parkingIstay"));
        // 업데이트 시간
        pvo.setParkingGettime(iobj.getString("parkingGettime"));
	    
		System.out.println("list: " + list);
		
		list.add(pvo);
		
		return list;
		/* return list; */
	}
	
	/************************************ 인천 국제 공항 *********************************************/
	@Override
	public ArrayList<ICNVO> icnInfo() throws IOException {
		
		ArrayList<ICNVO> list = new ArrayList<ICNVO>();
		
		StringBuilder urlBuilder = new StringBuilder("http://openapi.airport.kr/openapi/service/StatusOfParking/getTrackingParking"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=c1sNS0F8dzRRFujphkwtO4hhp5OmOL%2FM8ZD31ri59F0wB%2B3CtmKCGRzhXc43qEHoEvIdMERNztk0vvVjdNKOFA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
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
        System.out.println(sb.toString());
        
		/***************************************** list code *********************************************/
        String jsonString = sb.toString();
	    // 가장 큰 JSONObject를 가져옵니다.
	    JSONObject jObject = new JSONObject(jsonString);
	    
	    // (response)  0번째 JSONObject를 가져옵니다.
	    JSONObject responseObject = jObject.getJSONObject("response");
	    
	    // (response -> header)  1번째 JSONObject를 가져와서 key-value를 읽습니다.
	    JSONObject headerObject = responseObject.getJSONObject("header");
	    String resultCode = headerObject.getString("resultCode");
	    String resultMsg = headerObject.getString("resultMsg");
	    log.info("(header)resultCode: " + resultCode);
	    log.info("(header)resultMsg: " + resultMsg);
	    
	    JSONObject bodyObject = responseObject.getJSONObject("body");
	    JSONObject itemsObject = bodyObject.getJSONObject("items");
	    String numOfRows = Integer.toString(bodyObject.getInt("numOfRows"));
	    String pageNo = Integer.toString(bodyObject.getInt("pageNo"));
	    String totalCount = Integer.toString(bodyObject.getInt("totalCount"));
	    log.info("(body)totalCount: " + totalCount);
	    
	 // (response -> body -> items -> item(node 2개이상))  세번째 JSONObject를 가져와서 key-value를 읽습니다.
	    JSONArray itemArray = itemsObject.getJSONArray("item");
	    for (int i = 0; i < itemArray.length(); i++) {
	    	
			ICNVO ivo = new ICNVO();
	    	JSONObject iobj = itemArray.getJSONObject(i);
	    	//log.info("iobj(" + i + "): " + iobj.toString());
	        
//	        // 공항명
//	        ivo.setAprKor(iobj.getString("aprKor"));
	        // 주차장명
	        ivo.setFloor(iobj.getString("floor"));
	        // 총 주차구역
	        ivo.setParkingarea(iobj.getInt("parkingarea"));
	        // 주차된 차
	        ivo.setParking(iobj.getInt("parking"));
	        // 업데이트 시간
	        ivo.setDatetm(iobj.getString("datetm"));
	        
	        
	        
	        log.info(i + "번째 item: " + ivo);
	        
	        
	        list.add(ivo);
	        
	       
	    }
	    
		System.out.println("list: " + list);
		return list;
		/* return list; */
	}
}