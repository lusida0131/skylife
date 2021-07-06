package org.pay.domain;

import lombok.Data;


@Data
public class OrderVO {
    
	private String vihicleId;		// 항공편명
	private String airlineNm;		// 항공사명
	private long depPlandTime;		// 출발시간
	private long arrPlandTime;		// 도착시간
	private int economyCharge;		// 일반석운임
	private int prestigeCharge;		// 비즈니스석운임
	private String depAirportNm;	// 출발공항
	private String arrAirportNm;	// 도착공항
	
	//private String pOrderID;	// partner_order_id		가맹점 주문번호, 최대 100자
	//private String pUserID;	// partner_user_id		가맹점 회원 id, 최대 100자
	//private String itemName;	// item_name			상품명, 최대 100자
	//private String itemCode;	// item_code			상품코드, 최대 100자
	//private int quantity;		// quantity				상품 수량
	//private int totalAmount;	// total_amount			상품 총액
	//private int taxFreeAmount;// tax_free_amount		상품 비과세 금액
	//private int installMonth;	// install_month		카드 할부개월, 0~12
   
	
	public OrderVO(String vihicleId, String airlineNm, String depPlandTime, String arrPlandTime,
			String economyCharge, String prestigeCharge, String depAirportNm, String arrAirportNm) {
		
		this.vihicleId = vihicleId;
		this.airlineNm = airlineNm;
		this.depPlandTime = Long.valueOf(depPlandTime);
		this.arrPlandTime = Long.valueOf(arrPlandTime);
		this.economyCharge = Integer.valueOf(economyCharge);
		this.prestigeCharge =Integer.valueOf(prestigeCharge);
		this.depAirportNm = depAirportNm;
		this.arrAirportNm = arrAirportNm;
		
	}
    
}