package org.zerock.service;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;


import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.stereotype.Service;
import org.zerock.domain.searchVO;
//import org.zerock.mapper.skylifeMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@AllArgsConstructor
public class searchServiceImpl implements searchService{
	
	@Override
	public ArrayList<searchVO> airApi(String daID, String aaID, String dpTime) throws IOException {
		
		ArrayList<searchVO> list = new ArrayList<searchVO>();
		
		// URL
		StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList");
		// Service Key
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=E7TR7GkGB3YlWwOR8BSGYwtixVpS2cWRFjy4QGwrUCYwfQDoxoiNyg8jBvpJaBL4li1G1zDarq9S%2BZpgqa8KZg%3D%3D");
		// 한 페이지 결과 수
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8"));
		// 페이지 번호
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
		// 출발공항ID
		urlBuilder.append("&" + URLEncoder.encode("depAirportId","UTF-8") + "=" + URLEncoder.encode(daID, "UTF-8"));
		// 도착공항ID
		urlBuilder.append("&" + URLEncoder.encode("arrAirportId","UTF-8") + "=" + URLEncoder.encode(aaID, "UTF-8"));
		// 출발일
		urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode(dpTime, "UTF-8"));
		// 항공사ID
		urlBuilder.append("&" + URLEncoder.encode("airlineId","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
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
	    
	    // (response -> body)  두번째 JSONObject를 가져와서 key-value를 읽습니다.
	    JSONObject bodyObject = responseObject.getJSONObject("body");
	    JSONObject itemsObject = bodyObject.getJSONObject("items");
	    String numOfRows = Integer.toString(bodyObject.getInt("numOfRows"));
	    String pageNo = Integer.toString(bodyObject.getInt("pageNo"));
	    String totalCount = Integer.toString(bodyObject.getInt("totalCount"));
	    log.info("(body)totalCount: " + totalCount);
	    
	    // (response -> body -> items -> item(node 2개이상))  세번째 JSONObject를 가져와서 key-value를 읽습니다.
	    JSONArray itemArray = itemsObject.getJSONArray("item");
	    for (int i = 0; i < itemArray.length(); i++) {
	    	
	    	searchVO svo = new searchVO();
	    	JSONObject iobj = itemArray.getJSONObject(i);
	    	//log.info("iobj(" + i + "): " + iobj.toString());
	        
	    	// 항공편명
	        svo.setVihicleId(iobj.getString("vihicleId"));
	        // 항공사명
	        svo.setAirlineNm("airlineName is Null");
	    	if( iobj.has("airlineNm") ) {
	        	svo.setAirlineNm(iobj.getString("airlineNm"));
	        }
	    	// 출발시간
	    	svo.setDepPlandTime(iobj.getLong("depPlandTime"));
	        // 도착시간
	        svo.setArrPlandTime(iobj.getLong("arrPlandTime"));
	        // 일반석운임
	        svo.setEconomyCharge(87000);
	        if( iobj.has("economyCharge") ) {
	        	svo.setEconomyCharge(iobj.getInt("economyCharge"));
	        }
	        // 비즈니스석운임
	        svo.setPrestigeCharge(118000);
	        if( iobj.has("prestigeCharge") ) {
	        	svo.setPrestigeCharge(iobj.getInt("prestigeCharge"));
	        }
	        // 출발공항
	        svo.setDepAirportNm(iobj.getString("depAirportNm"));
	        // 도착공항
	        svo.setArrAirportNm(iobj.getString("arrAirportNm"));
	        
	        log.info(i + "번째 item: " + svo);
	        
	        list.add(svo);
	        
	    }
	    
	    return list;
	}

//	@Override
//	public int airlinePrice() {
//		
//		
//		
//		return 0;
//	}
	
}
