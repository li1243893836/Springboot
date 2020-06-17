package com.itly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itly.pojo.Course;
import com.itly.pojo.SClass;
import com.itly.pojo.Score;
import com.itly.pojo.ScoreCustom;
import com.itly.pojo.Student;
import com.itly.pojo.StudentCustom;
import com.itly.service.ClassService;
import com.itly.service.ScoreService;
import com.itly.service.StudentService;

@Controller
public class StudentController {
	
	private static Integer score_student_id;
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private ScoreService scoreService;
	
	
	//@RequestMapping("/student")
	public String Student(Model model) {
		List<Student> student = studentService.findAll();
		for(Student s :student) {
			System.out.println(s);
		}
		model.addAttribute("student",student);
		return "student";
	}
	
	@RequestMapping("/student")
	public String StudentCustom(Model model,HttpServletRequest request) {
		List<StudentCustom> student = studentService.findCustomAll();
		String[] ids = request.getParameterValues("uid");
		if(ids != null) {
			for(String id : ids) {
				studentService.deleteStudent(Integer.parseInt(id));
			}
			return "redirect:/student";
		}
		model.addAttribute("student",student);
		return "student";
	}
	
	@RequestMapping("/findStudentById")
	public String findStudentById(Model model,HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Student student = studentService.findStudentById(id);
		student.setId(id);
		model.addAttribute("student",student);
		return "updateStudent";
	}
	@RequestMapping("/updateStudent")
	public String updateStudent(@ModelAttribute Student student) {
		studentService.updateStudent(student);
		return "redirect:/student";
	}
	@RequestMapping("/deleteStudent")
	public String deleteStudent(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		studentService.deleteStudent(id);
		return "redirect:/student";
	}
	
	@RequestMapping("/addStudent")
	public String addStudent(HttpServletRequest request) {
		StudentCustom studentCustom = new StudentCustom();
		studentCustom.setAddress(request.getParameter("address"));
		studentCustom.setAge(Integer.parseInt(request.getParameter("age")));
		studentCustom.setCname(request.getParameter("cname"));
		studentCustom.setEmail(request.getParameter("email"));
		studentCustom.setName(request.getParameter("name"));
		studentCustom.setPassword(request.getParameter("password"));
		studentCustom.setQq(request.getParameter("qq"));
		studentCustom.setSex(request.getParameter("sex"));
		studentCustom.setUsername(request.getParameter("username"));
		studentCustom.setClassId(Integer.parseInt(request.getParameter("cname")));
		studentService.insertStudent(studentCustom);
		return "redirect:/student";
	}

	@RequestMapping("/add")
	public String add(Model model) {
		List<SClass> sclass = classService.findAll();
		model.addAttribute("sclass",sclass);
		return "addStudent";
	}
	
	@RequestMapping("/selectStudent")
	public String selectStudent(Model model,HttpServletRequest request) {
		String name = request.getParameter("name");
		String cname = request.getParameter("cname");
		List<StudentCustom> student = null ;
		if((name == null || "".equals(name))&&(cname != null || !("".equals(cname)))) {
			student = studentService.findStudentByCname(cname);
		}else if((name != null || !(" ".equals(name)))&&(cname == null || "".equals(cname))){
			student = studentService.findStudentByName(name);
		}else if((name != null || !"".equals(name))&&(cname != null || !"".equals(cname))){
			student = studentService.findStudentByCnameAndName(name,cname);
		}
		if(name == "" && cname == ""){
			return "redirect:/student";
		}
		model.addAttribute("student",student);
		return "student";
	}
	
	@RequestMapping("/findStudentScore")
	public String findStudentScore(Model model,HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		score_student_id = id;
		List<ScoreCustom> score = scoreService.findStudentScore(id);
		model.addAttribute("score",score);
		return "score";
	}
	@RequestMapping("/adds")
	public String adds(Model model,HttpServletRequest request) {
		Student student = studentService.findStudentById(score_student_id);
		List<Course> course = scoreService.findCourseByScoreId(score_student_id);
		model.addAttribute("student",student);
		model.addAttribute("course",course);
		return "addScore1";
	}
	@RequestMapping("/updates")
	public String updates(Model model,HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Student student = studentService.findStudentById(score_student_id);
		List<Course> course = scoreService.findCourseByScoreId(score_student_id);
		model.addAttribute("student",student);
		model.addAttribute("course",course);
		model.addAttribute("id",id);
		return "addScore";
	}
	@RequestMapping("/addStudentScore")
	public String addStudentScore(@ModelAttribute ScoreCustom scoreCustom,HttpServletRequest request) {	
		Integer id1 = scoreCustom.getStudent_id();
		Integer id2 = Integer.parseInt(scoreCustom.getCourse_name());
		Score score = scoreService.findScoreByTwoId(id1,id2);
		if(score  != null) {
			return "redirect:/student";
		}
		scoreService.AddScore(scoreCustom);
		return "redirect:/student"; 
	}
	@RequestMapping("/updateStudentScore")
	public String updateStudentScore(@ModelAttribute ScoreCustom scoreCustom,HttpServletRequest request) {
		scoreService.updateScore(scoreCustom);
		return "redirect:/student"; 
	}
	@RequestMapping("/deleteScore")
	public String deleteScore(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		scoreService.deleteById(id);
		return "redirect:/student";
	}
	
}
