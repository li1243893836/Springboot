package com.itly.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itly.pojo.Course;
import com.itly.pojo.CourseCustom;

@Service
public interface CourseService {

	List<CourseCustom> findCourseAll();

	
}
