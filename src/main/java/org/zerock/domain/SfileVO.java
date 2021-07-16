package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class SfileVO {
	// 파일 넘버
	private int fileNo;
//	// 파일 업로드 날짜
//	private String regDate;
//	// 유저 아이디
//	private String id;
	// uuid
	private String uuid;
	// 파일 데이터
	private String uploadPath;
	// 파일 이름
	private String fileName;



}
