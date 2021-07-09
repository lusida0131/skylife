package org.zerock.domain;

import lombok.Data;

@Data
public class ICNVO {
	private String resultCode;
	private String resultMsg;
	private int numOfRows;
	private int pageNo;
	private int totalCount;
	private String floor;
	private int parking;
	private int parkingarea;
	private String datetm;
}
