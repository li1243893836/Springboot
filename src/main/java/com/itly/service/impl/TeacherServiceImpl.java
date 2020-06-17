package com.itly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itly.dao.TeacherDao;
import com.itly.pojo.Teacher;
import com.itly.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	TeacherDao teacherDao;

	@Override
	public List<Teacher> findTeacherAll() {
		// TODO 自动生成的方法存根
		return teacherDao.findAll();
	}

	@Override
	public void deleteTeacher(int parseInt) {
		// TODO 自动生成的方法存根
		teacherDao.delete(parseInt);
	}

	@Override
	public Teacher findTeacherById(Integer id) {
		// TODO 自动生成的方法存根
		return teacherDao.findById(id);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO 自动生成的方法存根
		teacherDao.update(teacher);
	}

	@Override
	public void insertTeacher(Teacher teacher) {
		// TODO 自动生成的方法存根
		teacherDao.insert(teacher);
	}

	@Override
	public List<Teacher> findTeacherByName(String name) {
		// TODO 自动生成的方法存根
		return teacherDao.findByName(name);
	}

	@Override
	public List<Teacher> findTeacherByTitle(String title) {
		// TODO 自动生成的方法存根
		return teacherDao.findByTitle(title);
	}

	@Override
	public List<Teacher> findTeacherByTitleAndName(String name, String title) {
		// TODO 自动生成的方法存根
		return teacherDao.findByNameAndTitle(name,title);
	}

}
