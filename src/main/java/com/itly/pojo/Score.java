package com.itly.pojo;

import org.springframework.stereotype.Component;

@Component
public class Score {

	private Integer id;
	private Integer student_id;
	private Integer course_id;
	private Integer score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Score [id=" + id + ", student_id=" + student_id + ", course_id=" + course_id + ", score=" + score + "]";
	}
	
}
