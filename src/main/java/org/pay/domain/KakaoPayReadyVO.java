package org.pay.domain;

import java.util.Date;

import lombok.Data;
 
@Data
public class KakaoPayReadyVO {
    
	// response
	// 결제 요청에 대한 응답을 받는 객체
    private String tid;
    private String next_redirect_pc_url;
    private Date created_at;
    
}
 