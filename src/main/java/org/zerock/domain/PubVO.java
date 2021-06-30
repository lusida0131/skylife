package org.zerock.domain;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PubVO {
	private int pno;
	private Date p_time;
	private String p_title;
	private String p_content;
}
