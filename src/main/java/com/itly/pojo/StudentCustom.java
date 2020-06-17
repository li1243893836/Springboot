package com.itly.pojo;

import org.springframework.stereotype.Component;

@Component
public class StudentCustom extends Student{
	
	private String cname;

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	

}
