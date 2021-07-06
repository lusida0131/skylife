package org.pay.domain;

import java.util.Date;

import lombok.Data;
 
@Data
public class KakaoPayApprovalVO {
    
	// response
	// 결제 완료 후에 결제에 대한 응답을 받는 객체
//    private String aid;
//    private String tid;
//    private String cid;
//    private String sid;
//    
//    private String partner_order_id;
//    private String partner_user_id;
//    private String payment_method_type;
//    
//    private AmountVO amount;
//    private CardVO card_info;
//    
//    private String item_name;
//    private String item_code;
//    private String payload;
//    
//    private Integer quantity;
//    private Integer tax_free_amount;
//    private Integer vat_amount;
//    
//    private Date created_at;
//    private Date approved_at;
	
	private String aid, tid, cid, sid;
    private String partner_order_id, partner_user_id, payment_method_type;
    private AmountVO amount;
    private CardVO card_info;
    private String item_name, item_code, payload;
    private Integer quantity, tax_free_amount, vat_amount;
    private Date created_at, approved_at;
    
}