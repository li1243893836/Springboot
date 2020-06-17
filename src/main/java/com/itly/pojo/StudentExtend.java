package com.itly.pojo;

import org.springframework.stereotype.Component;

@Component
public class StudentExtend {
	
	private Student student;
	private SClass sclass;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public SClass getSclass() {
		return sclass;
	}
	public void setSclass(SClass sclass) {
		this.sclass = sclass;
	}
	@Override
	public String toString() {
		return "StudentExtend [student=" + student + ", sclass=" + sclass + "]";
	}
	

}
