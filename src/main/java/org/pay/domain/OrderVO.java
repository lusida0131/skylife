package org.pay.domain;

import lombok.Data;


@Data
public class OrderVO {
    
	private String id;
	private String tid;
	
	private int w_num;
	
	private String vihicleId;		// 항공편명
	private String airlineNm;		// 항공사명
	private long depPlandTime;		// 출발시간
	private long arrPlandTime;		// 도착시간
	private int economyCharge;		// 일반석운임
	private int prestigeCharge;		// 비즈니스석운임
	private String depAirportNm;	// 출발공항
	private String arrAirportNm;	// 도착공항
	
//	private String aid;						// 요청 고유 번호
//	private String tid;						// 결제 고유 번호
//	private String partner_user_id;			// userID
//	private String payment_method_type;		// 결제 수단
//	private String amount_total;			// 전체 결제 금액
//	private String amount_vat;				// 부가세 금액
//	private String card_purchase_corp;		// 매입 카드사 한글명
//	private String card_install_month;		// 할부 개월
//	private String item_name;				// 상품 이름
//	private String item_code;				// 상품 코드
//	private String quantity;				// 상품 수량
//	private String created_at;				// 결제 준비 요청 시각
//	private String approved_at;				// 결제 승인 시각
   
	
//	public OrderVO(String vihicleId, String airlineNm, String depPlandTime, String arrPlandTime,
//			String economyCharge, String prestigeCharge, String depAirportNm, String arrAirportNm) {
//		
//		this.vihicleId = vihicleId;
//		this.airlineNm = airlineNm;
//		this.depPlandTime = Long.valueOf(depPlandTime);
//		this.arrPlandTime = Long.valueOf(arrPlandTime);
//		this.economyCharge = Integer.valueOf(economyCharge);
//		this.prestigeCharge =Integer.valueOf(prestigeCharge);
//		this.depAirportNm = depAirportNm;
//		this.arrAirportNm = arrAirportNm;
//		
//	}
    
}