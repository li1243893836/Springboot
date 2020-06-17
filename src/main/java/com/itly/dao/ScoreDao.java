package com.itly.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itly.pojo.Course;
import com.itly.pojo.Score;
import com.itly.pojo.ScoreCustom;

@Repository
public interface ScoreDao {

	List<ScoreCustom> findStudentScore(Integer id);

	List<Course> findByScoreId(Integer id);

	void update(ScoreCustom scoreCustom);

	void deleteId(Integer id);

	void add(ScoreCustom scoreCustom);

	Score findById(Integer id);

	Score findByTwoId(Integer student_id, Integer course_id);

}
