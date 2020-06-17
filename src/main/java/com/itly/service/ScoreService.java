package com.itly.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itly.pojo.Course;
import com.itly.pojo.Score;
import com.itly.pojo.ScoreCustom;

@Service
public interface ScoreService {

	List<ScoreCustom> findStudentScore(Integer id);

	List<Course> findCourseByScoreId(Integer id);

	void updateScore(ScoreCustom scoreCustom);

	void deleteById(Integer id);

	void AddScore(ScoreCustom scoreCustom);

	Score findScoreById(Integer id);

	Score findScoreByTwoId(Integer student_id, Integer course_id);

}
