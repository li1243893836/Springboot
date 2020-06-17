package com.itly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itly.pojo.Course;
import com.itly.pojo.CourseCustom;
import com.itly.pojo.StudentCustom;
import com.itly.service.CourseService;
import com.itly.service.StudentService;

@Controller
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/course")
	public String course(Model model) {
		List<CourseCustom> course = courseService.findCourseAll();
		model.addAttribute("course",course);
		return "course";
	}
	
	@RequestMapping("/findStudentByCourse")
	public String findStudentByCourse(Model model,HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		List<StudentCustom> student = studentService.findStudentByCourse(id);
		model.addAttribute("student", student);
		return "student";
	}
	

}
