package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int b_num;
	private String b_title;
	private String b_content;
	private String id;
	private Date time;
	private int rcount;
}
