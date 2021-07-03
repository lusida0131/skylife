package org.zerock.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Data
public class searchVO {

	private String vihicleId;		// 항공편명
	private String airlineNm;		// 항공사명
	private int depPlandTime;		// 출발시간
	private int arrPlandTime;		// 도착시간
	private int economyCharge;		// 일반석운임
	private int prestigeCharge;		// 비즈니스석운임
	private String depAirportNm;	// 출발공항
	private String arrAirportNm;	// 도착공항
	
	
	public searchVO() { }
	
	public searchVO(String vihicleId, String airlineNm, int depPlandTime, int arrPlandTime,
			int economyCharge, int prestigeCharge, String depAirportNm, String arrAirportNm) {
		
		this.vihicleId = vihicleId;
		this.airlineNm = airlineNm;
		this.depPlandTime = depPlandTime;
		this.arrPlandTime = arrPlandTime;
		this.economyCharge = economyCharge;
		this.prestigeCharge = prestigeCharge;
		this.depAirportNm = depAirportNm;
		this.arrAirportNm = arrAirportNm;
		
	}
	
}
