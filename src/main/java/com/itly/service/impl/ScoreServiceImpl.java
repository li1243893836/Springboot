package com.itly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itly.dao.ScoreDao;
import com.itly.pojo.Course;
import com.itly.pojo.Score;
import com.itly.pojo.ScoreCustom;
import com.itly.service.ScoreService;
@Service
public class ScoreServiceImpl implements ScoreService{

	@Autowired
	ScoreDao scoreDao;
	@Override
	public List<ScoreCustom> findStudentScore(Integer id) {
		// TODO 自动生成的方法存根
		return scoreDao.findStudentScore(id);
	}
	@Override
	public List<Course> findCourseByScoreId(Integer id) {
		// TODO 自动生成的方法存根
		return scoreDao.findByScoreId(id);
	}
	@Override
	public void updateScore(ScoreCustom scoreCustom) {
		// TODO 自动生成的方法存根
		scoreDao.update(scoreCustom);
	}
	@Override
	public void deleteById(Integer id) {
		// TODO 自动生成的方法存根
		scoreDao.deleteId(id);
	}
	@Override
	public void AddScore(ScoreCustom scoreCustom) {
		// TODO 自动生成的方法存根
		scoreDao.add(scoreCustom);
	}
	@Override
	public Score findScoreById(Integer id) {
		// TODO 自动生成的方法存根
		return scoreDao.findById(id);
	}
	@Override
	public Score findScoreByTwoId(Integer student_id, Integer course_id) {
		// TODO 自动生成的方法存根
		return scoreDao.findByTwoId(student_id,course_id);
	}

}
