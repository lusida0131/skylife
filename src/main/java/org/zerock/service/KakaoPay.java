package org.zerock.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.pay.domain.KakaoPayApprovalVO;
import org.pay.domain.KakaoPayReadyVO;
import org.pay.domain.OrderVO;
import org.zerock.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
 

@Service
@Log4j
public class KakaoPay {
 
    private static final String HOST = "https://kapi.kakao.com";
    
    private KakaoPayReadyVO kakaoPayReadyVO;
    private KakaoPayApprovalVO kakaoPayApprovalVO;
    
    @Setter(onMethod_ = {@Autowired})
	private OrderMapper om;
    
    
    // 결제 요청
    public String kakaoPayReady(OrderVO ovo) {
 
        RestTemplate restTemplate = new RestTemplate();

        String itemName = "SkyLife_" + ovo.getAirlineNm() + ovo.getVihicleId() + "-" + ovo.getDepPlandTime();
        String itemCode = ovo.getVihicleId() + ovo.getDepPlandTime();
        int quantity = 1;
        int totalAmount = ovo.getEconomyCharge() * quantity;
        int installMonth = 1;
        
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "KakaoAK myServiceKey"); // admin key
        header.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        header.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        body.add("cid", "TC0ONETIME");										// (String) test code, 가맹점코드
        body.add("partner_order_id", "SkyLife_oi");							// (String) 가맹점 주문번호
        body.add("partner_user_id", ovo.getId());							// (String) 가맹점 회원 id
        body.add("item_name", itemName);									// (String) 상품명
        body.add("item_code", itemCode);									// (String) 상품코드
        body.add("quantity", String.valueOf(quantity));						// (int) 상품 수량
        body.add("total_amount", String.valueOf(totalAmount));				// (int) 상품 총액
        body.add("tax_free_amount", "0");									// (int) 상품 비과세 금액
        body.add("approval_url", "http://localhost:8080/kakaoPaySuccess");	// (String) 결제 성공시 url
        body.add("cancel_url", "http://localhost:8080/kakaoPayCancel");		// (String) 결제 취소시 url
        body.add("fail_url", "http://localhost:8080/kakaoPaySuccessFail");	// (String) 결제 실패시 url
        body.add("install_month", String.valueOf(installMonth));			// (int) 카드 할부개월
        
        HttpEntity<MultiValueMap<String, String>> param = new HttpEntity<MultiValueMap<String, String>>(body, header);
 
        try {
        	// RestTemplate을 이용해 카카오페이에 데이터를 보내고, KakaoPayReadyVO.class를 응답받는 객체로 설정
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), param, KakaoPayReadyVO.class);
            log.info("kakaoPayReadyVO: " + kakaoPayReadyVO);
            
            // 1차 데이터베이스 추가
            ovo.setTid(kakaoPayReadyVO.getTid());
            om.AddOrder(ovo);
            
            // return 값으로 redirect url을 불러와 결제가 완료되면 해당 주소로 가게끔 설정
            return kakaoPayReadyVO.getNext_redirect_pc_url();
            
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        
        System.out.println("pay ready 완료 중 에러, 리턴넘김");
        return "/pay";
        
    }


	// 결제 완료 후 정보를 받아옴
    public KakaoPayApprovalVO kakaoPayInfo(String pg_token, String id) {
    	
        System.out.println("... KakaoPayInfo.....  kakaoPayInfo String id: " + id);
        
        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "KakaoAK myServiceKey");	// admin key
        header.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        header.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        body.add("cid", "TC0ONETIME");
        body.add("tid", kakaoPayReadyVO.getTid());
        body.add("partner_order_id", "SkyLife_oi");
        body.add("partner_user_id", id);
        body.add("pg_token", pg_token);
        
        HttpEntity<MultiValueMap<String, String>> param = new HttpEntity<MultiValueMap<String, String>>(body, header);
        
        try {
        	// 응답정보를 받는 KakaoPayApprovalVO 클래스
            kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), param, KakaoPayApprovalVO.class);
            System.out.println("kakaoPayApprovalVO: " + kakaoPayApprovalVO);
            
            // 2차 데이터베이스 추가
            om.AddOrderApproval(kakaoPayApprovalVO);
            
            return kakaoPayApprovalVO;
        
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}