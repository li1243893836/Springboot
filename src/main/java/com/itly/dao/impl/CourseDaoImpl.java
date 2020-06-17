package com.itly.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itly.dao.CourseDao;
import com.itly.pojo.Course;
import com.itly.pojo.CourseCustom;

@Repository
public class CourseDaoImpl implements CourseDao{

	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<CourseCustom> findAll() {
		// TODO 自动生成的方法存根
		String sql = "SELECT course.id as id,course.name AS NAME ,teacher.name AS tname," + 
				"max_student_num,info,selected_num FROM course,teacher " + 
				"WHERE course.teacher_id = teacher.id";
		return template.query(sql, new BeanPropertyRowMapper<>(CourseCustom.class));
	}

}
