package org.zerock.service;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.stereotype.Service;
//import org.zerock.domain.skylifeVO;
//import org.zerock.mapper.skylifeMapper;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class searchServiceImpl implements searchService{
	
	
	@Override
	public void airApi() throws IOException {
		StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList"); /*URL*/
	    
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=E7TR7GkGB3YlWwOR8BSGYwtixVpS2cWRFjy4QGwrUCYwfQDoxoiNyg8jBvpJaBL4li1G1zDarq9S%2BZpgqa8KZg%3D%3D"); /*Service Key*/
	    urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
	    urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
	    urlBuilder.append("&" + URLEncoder.encode("depAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKJJ", "UTF-8")); /*출발공항ID*/ // 김포공ㅇ항
	    urlBuilder.append("&" + URLEncoder.encode("arrAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKPC", "UTF-8")); /*도착공항ID*/ // 제주국제공항
	    urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode("20210731", "UTF-8")); /*출발일*/ //0731
	    urlBuilder.append("&" + URLEncoder.encode("airlineId","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*항공사ID*/
	    urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*json type return*/
	    
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
	    
	    System.out.println("result: " + sb.toString());
	    
	    
	    
	    //========================= (test code) =========================
	    
	    String jsonString = sb.toString();
	    // 가장 큰 JSONObject를 가져옵니다.
	    JSONObject jObject = new JSONObject(jsonString);
	    
	    
	    // 0번째 JSONObject를 가져옵니다.
	    // (response)
	    JSONObject responseObject = jObject.getJSONObject("response");
	    //System.out.println("responseObject: " + responseObject.toString());
	    
	    
	    // 첫번째 JSONObject를 가져와서 key-value를 읽습니다.
	    // (response -> header)
	    JSONObject headerObject = responseObject.getJSONObject("header");
	    System.out.println("headerObject: " + headerObject.toString());
	    
	    String resultCode = headerObject.getString("resultCode");
	    String resultMsg = headerObject.getString("resultMsg");
	    System.out.println("header -> resultCode: " + resultCode);
	    System.out.println("header -> resultMsg: " + resultMsg);
	    
	    
	    // 두번째 JSONObject를 가져와서 key-value를 읽습니다.
	    // (response -> body)
	    JSONObject bodyObject = responseObject.getJSONObject("body");
	    System.out.println("bodyObject: " + bodyObject.toString());
	    
	    JSONObject itemsObject = bodyObject.getJSONObject("items");
	    String numOfRows = Integer.toString(bodyObject.getInt("numOfRows"));
	    String pageNo = Integer.toString(bodyObject.getInt("pageNo"));
	    String totalCount = Integer.toString(bodyObject.getInt("totalCount"));
	    
	    System.out.println("body -> numOfRows: " + numOfRows);
	    System.out.println("body -> pageNo: " + pageNo);
	    System.out.println("body -> totalCount: " + totalCount);
	    
	    
	    // 세번째 JSONObject를 가져와서 key-value를 읽습니다.
	    // (response -> body -> items -> item) : item이 한개일때
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
	    
	    
	    System.out.println();
	    // 세번째 JSONObject를 가져와서 key-value를 읽습니다.
	    // (response -> body -> items -> item) : item이 두개 이상의 배열일때
	    JSONArray itemArray = itemsObject.getJSONArray("item");
	    for (int i = 0; i < itemArray.length(); i++) {
	    	JSONObject iobj = itemArray.getJSONObject(i);
	    	//String airlineNm = iobj.getString("airlineNm");
	    	String airlineNm = "airlineNm is Null";
	        if( iobj.has("airlineNm") ) {
	        	airlineNm = iobj.getString("airlineNm");
	        }
	        String arrAirportNm = iobj.getString("arrAirportNm");
	        String arrPlandTime = Integer.toString(iobj.getInt("arrPlandTime"));
	        String depAirportNm = iobj.getString("depAirportNm");
	        int depPlandTime = iobj.getInt("depPlandTime");
	        //Integer economyCharge = iobj.getInt("economyCharge");
	        int economyCharge = -1;
	        if( iobj.has("economyCharge") ) {
	        	economyCharge = iobj.getInt("economyCharge");
	        }
	        //Integer prestigeCharge = iobj.getInt("prestigeCharge");
	        int prestigeCharge = -1;
	        if( iobj.has("prestigeCharge") ) {
	        	prestigeCharge = iobj.getInt("prestigeCharge");
	        }
	        String vihicleId = iobj.getString("vihicleId");
	        
	        System.out.println("item("+i+") airlineNm: " + airlineNm);
	        System.out.println("item("+i+") arrAirportNm: " + arrAirportNm);
	        System.out.println("item("+i+") arrPlandTime: " + arrPlandTime);
	        System.out.println("item("+i+") depAirportNm: " + depAirportNm);
	        System.out.println("item("+i+") depPlandTime: " + depPlandTime);
	        System.out.println("item("+i+") economyCharge: " + economyCharge);
	        System.out.println("item("+i+") prestigeCharge: " + prestigeCharge);
	        System.out.println("item("+i+") vihicleId: " + vihicleId);
	
			
		}
	}

}
