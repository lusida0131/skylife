package org.zerock.domain;

import lombok.Data;

@Data
public class ICNVO {
	private String resultCode;
	private String resultMsg;
	private int numOfRows;
	private int pageNo;
	private String totalCount;
	private String floor;
	private String parking;
	private String parkingarea;
	private String datetm;
}
