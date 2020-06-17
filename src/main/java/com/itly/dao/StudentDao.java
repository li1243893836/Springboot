package com.itly.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itly.pojo.Student;
import com.itly.pojo.StudentCustom;
import com.itly.pojo.StudentExtend;

@Repository
public interface StudentDao {

	/*
	 * 查询全部
	 */
	public List<Student> findAll();
	public List<StudentCustom> findCustomAll();
	/*
	 * 添加用户
	 */
	public void addStudent();
	public Student findById(Integer id);
	public void update(Student student);
	public void delete(Integer id);
	public void insert(StudentCustom studentCustom);
	public List<StudentCustom> findByCname(String cname);
	public List<StudentCustom> findByName(String name);
	public List<StudentCustom> findByCnameAndName(String name, String cname);
	public List<StudentCustom> findByClassId(Integer id);
	public List<StudentCustom> findByCourse(Integer id);
}
