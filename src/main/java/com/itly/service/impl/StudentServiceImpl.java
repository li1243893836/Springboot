package com.itly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itly.dao.StudentDao;
import com.itly.pojo.Student;
import com.itly.pojo.StudentCustom;
import com.itly.pojo.StudentExtend;
import com.itly.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> findAll() {
		// TODO 自动生成的方法存根
		return studentDao.findAll();
	}

	@Override
	public List<StudentCustom> findCustomAll() {
		// TODO 自动生成的方法存根
		return studentDao.findCustomAll();
	}

	@Override
	public Student findStudentById(Integer id) {
		// TODO 自动生成的方法存根
		return studentDao.findById(id);
	}

	@Override
	public void updateStudent(Student student) {
		// TODO 自动生成的方法存根
		studentDao.update(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		// TODO 自动生成的方法存根
		studentDao.delete(id);
	}

	@Override
	public void insertStudent(StudentCustom studentCustom) {
		// TODO 自动生成的方法存根
		studentDao.insert(studentCustom);
	}

	@Override
	public List<StudentCustom> findStudentByCname(String cname) {
		// TODO 自动生成的方法存根
		return studentDao.findByCname(cname);
	}

	@Override
	public List<StudentCustom> findStudentByName(String name) {
		// TODO 自动生成的方法存根
		return studentDao.findByName(name);
	}

	@Override
	public List<StudentCustom> findStudentByCnameAndName(String name, String cname) {
		// TODO 自动生成的方法存根
		return studentDao.findByCnameAndName(name,cname);
	}

	@Override
	public List<StudentCustom> findStudentByClassId(Integer id) {
		// TODO 自动生成的方法存根
		return studentDao.findByClassId(id);
	}

	@Override
	public List<StudentCustom> findStudentByCourse(Integer id) {
		// TODO 自动生成的方法存根
		return studentDao.findByCourse(id);
	}

}
