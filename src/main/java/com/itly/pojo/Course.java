package com.itly.pojo;

public class Course {

	private Integer id;
	private String name;
	private Integer teacher_id;
	private Integer max_student_num;
	private String info;
	private String selected_num;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}
	public Integer getMax_student_num() {
		return max_student_num;
	}
	public void setMax_student_num(Integer max_student_num) {
		this.max_student_num = max_student_num;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getSelected_num() {
		return selected_num;
	}
	public void setSelected_num(String selected_num) {
		this.selected_num = selected_num;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", teacher_id=" + teacher_id + ", max_student_num="
				+ max_student_num + ", info=" + info + ", selected_num=" + selected_num + "]";
	}
	
}
