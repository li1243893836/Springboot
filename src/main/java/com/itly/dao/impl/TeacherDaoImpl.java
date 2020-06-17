package com.itly.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itly.dao.TeacherDao;
import com.itly.pojo.Student;
import com.itly.pojo.Teacher;

@Repository
public class TeacherDaoImpl implements TeacherDao{
	
	@Autowired
	JdbcTemplate template;

	@Override
	public List<Teacher> findAll() {
		// TODO 自动生成的方法存根
		String sql = "select * from teacher";
		return template.query(sql, new Object[]{},new BeanPropertyRowMapper<>(Teacher.class));
	}

	@Override
	public void delete(Integer id) {
		// TODO 自动生成的方法存根
		String sql = "delete from course where teacher_id = ?";
		String sql1 = "delete from teacher where id = ?";
		template.update(sql,id);
		template.update(sql1,id);
		
	}

	@Override
	public Teacher findById(Integer id) {
		// TODO 自动生成的方法存根
		String sql = "select * from teacher where id = ?";
		return template.queryForObject(sql,new BeanPropertyRowMapper<>(Teacher.class),id);
	}

	@Override
	public void update(Teacher teacher) {
		// TODO 自动生成的方法存根
		String sql = "update teacher set sex = ?,title = ?,age = ?,address = ?,qq = ?,email = ? where id = ?";
		template.update(sql,teacher.getSex(),teacher.getTitle(),teacher.getAge(),teacher.getAddress(),teacher.getQq(),teacher.getEmail(),teacher.getId());
	}

	@Override
	public void insert(Teacher teacher) {
		// TODO 自动生成的方法存根
		String sql = "insert into teacher(name,sex,age,address,qq,email,title,username,password) values(?,?,?,?,?,?,?,?,?)";
		template.update(sql,teacher.getName(),teacher.getSex(),teacher.getAge(),teacher.getAddress(),teacher.getQq(),teacher.getEmail(),teacher.getTitle(),teacher.getUsername(),teacher.getPassword());
	}

	@Override
	public List<Teacher> findByName(String name) {
		// TODO 自动生成的方法存根
		String sql = "select * from teacher where name = ?";
		return template.query(sql, new BeanPropertyRowMapper<>(Teacher.class),name);
	}

	@Override
	public List<Teacher> findByTitle(String title) {
		// TODO 自动生成的方法存根
		String sql = "select * from teacher where title = ?";
		return template.query(sql, new BeanPropertyRowMapper<>(Teacher.class),title);
	}

	@Override
	public List<Teacher> findByNameAndTitle(String name, String title) {
		// TODO 自动生成的方法存根
		String sql = "select * from teacher where name = ? and title = ?";
		return template.query(sql, new BeanPropertyRowMapper<>(Teacher.class),name,title);
	}
	
	

}
