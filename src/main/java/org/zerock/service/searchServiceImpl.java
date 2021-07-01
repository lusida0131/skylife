package org.zerock.service;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.stereotype.Service;
import org.zerock.domain.searchVO;
//import org.zerock.mapper.skylifeMapper;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class searchServiceImpl implements searchService{
	
	//
	
	@Override
	public ArrayList<searchVO> airApi() throws IOException {
		
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
		urlBuilder.append("&" + URLEncoder.encode("depAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKJJ", "UTF-8"));
		// 도착공항ID
		urlBuilder.append("&" + URLEncoder.encode("arrAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKPC", "UTF-8"));
		// 출발일
		urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode("20210731", "UTF-8"));
		// 항공사ID
		urlBuilder.append("&" + URLEncoder.encode("airlineId","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		// json type return
		urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
	    
	    URL url = new URL(urlBuilder.toString());
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Content-type", "application/json");
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
	    //System.out.println("api URL result: " + sb.toString());
	    
	    
	    
	    //========================= (list code) =========================
	    
	    String jsonString = sb.toString();
	    // 가장 큰 JSONObject를 가져옵니다.
	    JSONObject jObject = new JSONObject(jsonString);
	    
	    
	    // (response)  0번째 JSONObject를 가져옵니다.
	    JSONObject responseObject = jObject.getJSONObject("response");
	    //System.out.println("responseObject: " + responseObject.toString());
	    
	    
	    // (response -> header)  1번째 JSONObject를 가져와서 key-value를 읽습니다.
	    JSONObject headerObject = responseObject.getJSONObject("header");
	    System.out.println("headerObject: " + headerObject.toString());
	    
	    String resultCode = headerObject.getString("resultCode");
	    String resultMsg = headerObject.getString("resultMsg");
	    System.out.println("header -> resultCode: " + resultCode);
	    System.out.println("header -> resultMsg: " + resultMsg);
	    
	    
	    // (response -> body)  두번째 JSONObject를 가져와서 key-value를 읽습니다.
	    JSONObject bodyObject = responseObject.getJSONObject("body");
	    System.out.println("bodyObject: " + bodyObject.toString());
	    
	    JSONObject itemsObject = bodyObject.getJSONObject("items");
	    String numOfRows = Integer.toString(bodyObject.getInt("numOfRows"));
	    String pageNo = Integer.toString(bodyObject.getInt("pageNo"));
	    String totalCount = Integer.toString(bodyObject.getInt("totalCount"));
	    
	    System.out.println("body -> numOfRows: " + numOfRows);
	    System.out.println("body -> pageNo: " + pageNo);
	    System.out.println("body -> totalCount: " + totalCount);
	    System.out.println();
	    
	    
	    // (response -> body -> items -> item(node 1개))  세번째 JSONObject를 가져와서 key-value를 읽습니다.
	//    JSONObject itemObject = itemsObject.getJSONObject("item");
	//    System.out.println("itemObject" + itemObject.toString());
	//    System.out.println();
	//    
	//    String airlineNm = itemObject.getString("airlineNm");
	//    String arrAirportNm = itemObject.getString("arrAirportNm");
	//    String arrPlandTime = Integer.toString(itemObject.getInt("arrPlandTime"));
	//    String depAirportNm = itemObject.getString("depAirportNm");
	//    int depPlandTime = itemObject.getInt("depPlandTime");
	//    int economyCharge = itemObject.getInt("economyCharge");
	//    int prestigeCharge = itemObject.getInt("prestigeCharge");
	//    String vihicleId = itemObject.getString("vihicleId");
	//    
	//    System.out.println("item -> airlineNm: " + airlineNm);
	//    System.out.println("item -> arrAirportNm: " + arrAirportNm);
	//    System.out.println("item -> arrPlandTime: " + arrPlandTime);
	//    System.out.println("item -> depAirportNm: " + depAirportNm);
	//    System.out.println("item -> depPlandTime: " + depPlandTime);
	//    System.out.println("item -> economyCharge: " + economyCharge);
	//    System.out.println("item -> prestigeCharge: " + prestigeCharge);
	//    System.out.println("item -> vihicleId: " + vihicleId);
	    
	    
	    
	    // (response -> body -> items -> item(node 2개이상))  세번째 JSONObject를 가져와서 key-value를 읽습니다.
	    JSONArray itemArray = itemsObject.getJSONArray("item");
	    for (int i = 0; i < itemArray.length(); i++) {
	    	
	    	JSONObject iobj = itemArray.getJSONObject(i);

	    	// 항공편명
	        String vihicleId = iobj.getString("vihicleId");
	    	// 항공사명			//String airlineNm = iobj.getString("airlineNm");
	    	String airlineNm = "airlineNm is Null";
	        if( iobj.has("airlineNm") ) {
	        	airlineNm = iobj.getString("airlineNm");
	        }
	        // 출발시간
	        int depPlandTime = iobj.getInt("depPlandTime");
	        // 도착시간
	        int arrPlandTime = iobj.getInt("arrPlandTime");
	        // 일반석운임			//Integer economyCharge = iobj.getInt("economyCharge");
	        int economyCharge = -1;
	        if( iobj.has("economyCharge") ) {
	        	economyCharge = iobj.getInt("economyCharge");
	        }
	        // 비즈니스석운임		//int prestigeCharge = iobj.getInt("prestigeCharge");
	        int prestigeCharge = -1;
	        if( iobj.has("prestigeCharge") ) {
	        	prestigeCharge = iobj.getInt("prestigeCharge");
	        }
	        // 출발공항
	        String depAirportNm = iobj.getString("depAirportNm");
	        // 도착공항
	        String arrAirportNm = iobj.getString("arrAirportNm");
	        
	        
	        // console print
	        System.out.println("item("+i+") vihicleId: " + vihicleId);				// 항공편명
	        System.out.println("item("+i+") airlineNm: " + airlineNm);				// 항공사명
	        System.out.println("item("+i+") depPlandTime: " + depPlandTime);		// 출발시간
	        System.out.println("item("+i+") arrPlandTime: " + arrPlandTime);		// 도착시간
	        System.out.println("item("+i+") economyCharge: " + economyCharge);		// 일반석운임
	        System.out.println("item("+i+") prestigeCharge: " + prestigeCharge);	// 비즈니스석운임
	        System.out.println("item("+i+") depAirportNm: " + depAirportNm);		// 출발공항
	        System.out.println("item("+i+") arrAirportNm: " + arrAirportNm);		// 도착공항
	        
	        list.add(new searchVO(vihicleId, airlineNm, depPlandTime, arrPlandTime, economyCharge, prestigeCharge, depAirportNm, arrAirportNm));
		
	    }
	    
	    return list;
	}
	
}
