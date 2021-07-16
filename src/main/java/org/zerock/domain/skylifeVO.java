package org.zerock.domain;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class skylifeVO {
	private int bno;
	private String id;
	private String pw;
	private String name;
	private Date bday;
	private String email;
	private String phone;
	
	public skylifeVO() { }

    public skylifeVO(String id, String name, String email) {

        this.id = id;
        this.name = name;
        this.email = email;

    }
}
