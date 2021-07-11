package org.zerock.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Data
public class FlightVO {

	private String vihicleId;		// 항공편명
	private String airlineNm;		// 항공사명
	private long depPlandTime;		// 출발시간
	private long arrPlandTime;		// 도착시간
	private int economyCharge;		// 일반석운임
	private int prestigeCharge;		// 비즈니스석운임
	private String depAirportNm;	// 출발공항
	private String arrAirportNm;	// 도착공항
	
	private String pageNo;			// 페이지 번호
	private String totalCount;		// item count
	
	
	public FlightVO() { }
	
	public FlightVO(String vihicleId, String airlineNm, long depPlandTime, long arrPlandTime,
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
	public FlightVO(String vihicleId, String airlineNm, String depPlandTime, String arrPlandTime,
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
