package com.itly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itly.dao.CourseDao;
import com.itly.pojo.Course;
import com.itly.pojo.CourseCustom;
import com.itly.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseDao courseDao;

	@Override
	public List<CourseCustom> findCourseAll() {
		// TODO 自动生成的方法存根
		return courseDao.findAll();
	}

}
