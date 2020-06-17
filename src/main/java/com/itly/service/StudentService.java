package com.itly.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itly.pojo.Student;
import com.itly.pojo.StudentCustom;
import com.itly.pojo.StudentExtend;

@Service
public interface StudentService {
	/*
	 * 查询所有
	 */
	public List<Student> findAll();
	public List<StudentCustom> findCustomAll();
	public Student findStudentById(Integer id);
	public void updateStudent(Student student);
	public void deleteStudent(Integer id);
	public void insertStudent(StudentCustom studentCustom);
	public List<StudentCustom> findStudentByCname(String cname);
	public List<StudentCustom> findStudentByName(String name);
	public List<StudentCustom> findStudentByCnameAndName(String name, String cname);
	public List<StudentCustom> findStudentByClassId(Integer id);
	public List<StudentCustom> findStudentByCourse(Integer id);
}
