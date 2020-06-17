package com.itly.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itly.pojo.Course;
import com.itly.pojo.CourseCustom;

@Repository
public interface CourseDao {

	List<CourseCustom> findAll();

}
