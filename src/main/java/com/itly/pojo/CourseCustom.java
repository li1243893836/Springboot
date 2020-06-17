package com.itly.pojo;

import org.springframework.stereotype.Component;

@Component
public class CourseCustom extends Course{
	
	private String tname;
	private String tid;
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	

}
