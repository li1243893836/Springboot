package com.itly.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itly.dao.ScoreDao;
import com.itly.pojo.Course;
import com.itly.pojo.Score;
import com.itly.pojo.ScoreCustom;

@Repository
public class ScoreDaoImpl implements ScoreDao{
	
	@Autowired
	JdbcTemplate template;

	@Override
	public List<ScoreCustom> findStudentScore(Integer id) {
		// TODO 自动生成的方法存根
		String sql = "SELECT score.id as id,student.name AS student_name," + 
				"course.name AS course_name," + 
				"score FROM score,course,student " + 
				"WHERE student_id = student.id AND " + 
				"course_id = course.id and student_id = ?";
		return template.query(sql, new BeanPropertyRowMapper<>(ScoreCustom.class),id);
	}

	@Override
	public List<Course> findByScoreId(Integer id) {
		// TODO 自动生成的方法存根
		String sql = "SELECT  course.id,course.name AS NAME FROM course,score,student WHERE  course.id = score.course_id" + 
				" AND score.student_id = student.id AND student.id = ?";
		return template.query(sql,new BeanPropertyRowMapper<>(Course.class),id);
	}

	@Override
	public void update(ScoreCustom scoreCustom) {
		// TODO 自动生成的方法存根
		String sql = "update score set score = ? where id = ?";
		template.update(sql,scoreCustom.getScore(),scoreCustom.getId());
	}

	@Override
	public void deleteId(Integer id) {
		// TODO 自动生成的方法存根
		String sql = "delete from score where id = ?";
		template.update(sql,id);
	}

	@Override
	public void add(ScoreCustom scoreCustom) {
		// TODO 自动生成的方法存根
		String sql = "insert into score(student_id,course_id,score) values(?,?,?)";
		template.update(sql,scoreCustom.getStudent_id(),scoreCustom.getCourse_name(),scoreCustom.getScore());
	}

	@Override
	public Score findById(Integer id) {
		// TODO 自动生成的方法存根
		String sql = "select * from score where id = ?";
		return template.queryForObject(sql,new BeanPropertyRowMapper<>(Score.class),id);
	}

	@Override
	public Score findByTwoId(Integer student_id, Integer course_id) {
		// TODO 自动生成的方法存根
		String sql = "select * from score where student_id = ? and course_id = ?";
		
		return template.queryForObject(sql,new BeanPropertyRowMapper<>(Score.class),student_id,course_id);
	}

}
