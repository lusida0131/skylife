package org.zerock.domain;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PubVO {
	private Integer pno;
	private Timestamp p_time;
	private String p_title;
	private String p_content;
}
