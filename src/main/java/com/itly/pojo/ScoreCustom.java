package com.itly.pojo;

import org.springframework.stereotype.Component;

@Component
public class ScoreCustom extends Score{
	private String student_name;
	private String course_name;
	private Integer student_id;
	
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	@Override
	public String toString() {
		return "ScoreCustom [student_name=" + student_name + ", course_name=" + course_name + "]";
	}
	

}
