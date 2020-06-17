package com.itly.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itly.pojo.Teacher;

@Service
public interface TeacherService {

	List<Teacher> findTeacherAll();

	void deleteTeacher(int parseInt);

	Teacher findTeacherById(Integer id);

	void updateTeacher(Teacher teacher);

	void insertTeacher(Teacher teacher);


	List<Teacher> findTeacherByName(String name);

	List<Teacher> findTeacherByTitle(String title);

	List<Teacher> findTeacherByTitleAndName(String name, String title);

}
