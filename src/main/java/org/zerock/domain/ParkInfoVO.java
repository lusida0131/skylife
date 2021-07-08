package org.zerock.domain;

import lombok.Data;

@Data
public class ParkInfoVO {
	
	private String aprEng;
	private String aprKor;
	private String parkingAirportCodeName;
	private int parkingFullSpace;
	private String parkingGetdate;
	private String parkingGettime;
	private int parkingIincnt;
	private int parkingIoutcnt;
	private int parkingIstay;
	
}