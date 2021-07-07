package org.zerock.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.pay.domain.KakaoPayApprovalVO;
import org.pay.domain.KakaoPayReadyVO;
import org.pay.domain.OrderVO;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
 
import lombok.extern.log4j.Log4j;
 

@Service
@Log4j
public class KakaoPay {
 
    private static final String HOST = "https://kapi.kakao.com";
    
    private KakaoPayReadyVO kakaoPayReadyVO;
    private KakaoPayApprovalVO kakaoPayApprovalVO;
    
    
    // 결제 요청
    public String kakaoPayReady(OrderVO ovo, String userID) {
 
        RestTemplate restTemplate = new RestTemplate();
        
//        String pOrderID = "SkyLife" + "orderID부여";
//        String pUserID = "ovo.getUserID()세션값";
        String itemName = "SkyLife_" + ovo.getAirlineNm() + ovo.getVihicleId()
        					+ "-" + ovo.getDepPlandTime();
        String itemCode = ovo.getVihicleId() + ovo.getDepPlandTime();
        int quantity = 1;
        int totalAmount = ovo.getEconomyCharge() * quantity;
        int installMonth = 1;
        
        // 서버로 요청할 Header
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "KakaoAK b13acc12ae82b6a10f628a48b0e3990d"); // admin key
        header.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        header.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        
        // 서버로 요청할 Body
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        body.add("cid", "TC0ONETIME");										// (String) test code, 가맹점코드
        body.add("partner_order_id", "SkyLife_oi");							// (String) 가맹점 주문번호, 최대 100자
        body.add("partner_user_id", userID);								// (String) 가맹점 회원 id, 최대 100자
        body.add("item_name", itemName);									// (String) 상품명, 최대 100자
        body.add("item_code", itemCode);									// (String) 상품코드, 최대 100자
        body.add("quantity", String.valueOf(quantity));						// (int) 상품 수량
        body.add("total_amount", String.valueOf(totalAmount));				// (int) 상품 총액
        body.add("tax_free_amount", "0");									// (int) 상품 비과세 금액
        body.add("approval_url", "http://localhost:8080/kakaoPaySuccess");	// (String) 결제 성공시 url
        body.add("cancel_url", "http://localhost:8080/kakaoPayCancel");		// (String) 결제 취소시 url
        body.add("fail_url", "http://localhost:8080/kakaoPaySuccessFail");	// (String) 결제 실패시 url
        body.add("install_month", String.valueOf(installMonth));			// (int) 카드 할부개월, 0~12
        
        
        // header와 body를 붙임
        HttpEntity<MultiValueMap<String, String>> param = new HttpEntity<MultiValueMap<String, String>>(body, header);
 
        try {
        	// RestTemplate을 이용해 카카오페이에 데이터를 보내고, KakaoPayReadyVO.clas를 응답받는 객체로 설정
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), param, KakaoPayReadyVO.class);
            log.info("kakaoPayReadyVO: " + kakaoPayReadyVO);
            
            // return 값으로 redirect url을 불러와 결제가 완료되면 해당 주소로 가게끔 설정
            return kakaoPayReadyVO.getNext_redirect_pc_url();
            
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        
        System.out.println("pay ready 완료, 리턴넘김");
        return "/pay";
        
    }
    
    
    private String subString(String valueOf, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}


	// 결제 완료 후 정보를 받아옴
    public KakaoPayApprovalVO kakaoPayInfo(String pg_token, String userID) {
    	 
        System.out.println("KakaoPayInfoVO............................................");
        System.out.println("KakaoPayReadyVO: " + kakaoPayReadyVO);
        log.info("----------------------------------------");
        
        RestTemplate restTemplate = new RestTemplate();
        
//        String pOrderID = "SkyLife" + "orderID부여";
//        String pUserID = "ovo.getPUserID()세션값";
 
        // 서버로 요청할 Header
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "KakaoAK b13acc12ae82b6a10f628a48b0e3990d");	// admin key
        header.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        header.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
 
        // 서버로 요청할 Body
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        body.add("cid", "TC0ONETIME");
        body.add("tid", kakaoPayReadyVO.getTid());
        body.add("partner_order_id", "SkyLife_oi");
        body.add("partner_user_id", userID);
        body.add("pg_token", pg_token);
        
        HttpEntity<MultiValueMap<String, String>> param = new HttpEntity<MultiValueMap<String, String>>(body, header);
        
        System.out.println("Approval Info param: " + param);
        
        try {
        	// 응답정보를 받는 KakaoPayApprovalVO 클래스
            kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), param, KakaoPayApprovalVO.class);
            log.info("kakaoPayApprovalVO: " + kakaoPayApprovalVO);
            System.out.println("kakaoPayApprovalVO: " + kakaoPayApprovalVO);
          
            return kakaoPayApprovalVO;
        
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}