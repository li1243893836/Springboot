package com.itly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itly.pojo.SClass;
import com.itly.pojo.Student;
import com.itly.pojo.StudentCustom;
import com.itly.pojo.Teacher;
import com.itly.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	TeacherService teacherService;
	
	@RequestMapping("/teacherList")
	public String teacher(Model model,HttpServletRequest request) {
		List<Teacher> teacher = teacherService.findTeacherAll();
		String[] ids = request.getParameterValues("uid");
		if(ids != null) {
			for(String id : ids) {
				teacherService.deleteTeacher(Integer.parseInt(id));
			}
			return "redirect:/teacher";
		}
		model.addAttribute("teacher",teacher);
		return "teacherList";
	}
	@RequestMapping("/deleteTeacher")
	public String deleteTeacher(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		teacherService.deleteTeacher(id);
		return "redirect:/teacher";
	}
	@RequestMapping("/updateTeacher")
	public String updateStudent(@ModelAttribute Teacher teacher) {
		teacherService.updateTeacher(teacher);
		return "redirect:/teacher";
	}
	@RequestMapping("/findTeacherById")
	public String findTeacherById(Model model,HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Teacher teacher = teacherService.findTeacherById(id);
		teacher.setId(id);
		model.addAttribute("teacher",teacher);
		return "updateTeacher";
	}
	@RequestMapping("/addt")
	public String add() {
		return "addTeacher";
	}
	@RequestMapping("/addTeacher")
	public String addStudent(HttpServletRequest request) {
		Teacher teacher = new Teacher();
		teacher.setAddress(request.getParameter("address"));
		teacher.setAge(Integer.parseInt(request.getParameter("age")));
		teacher.setTitle(request.getParameter("title"));
		teacher.setEmail(request.getParameter("email"));
		teacher.setName(request.getParameter("name"));
		teacher.setPassword(request.getParameter("password"));
		teacher.setQq(request.getParameter("qq"));
		teacher.setSex(request.getParameter("sex"));
		teacher.setUsername(request.getParameter("username"));
		teacherService.insertTeacher(teacher);
		return "redirect:/teacher";
	}
	@RequestMapping("/selectTeacher")
	public String selectStudent(Model model,HttpServletRequest request) {
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		List<Teacher> teacher = null ;
		if((name == null || "".equals(name))&&(title != null || !("".equals(title)))) {
			teacher = teacherService.findTeacherByTitle(title);
		}else if((name != null || !(" ".equals(name)))&&(title == null || "".equals(title))){
			teacher = teacherService.findTeacherByName(name);
		}else if((name != null || !"".equals(name))&&(title != null || !"".equals(title))){
			teacher = teacherService.findTeacherByTitleAndName(name,title);
		}
		if(name == "" && title == ""){
			return "redirect:/teacher";
		}
		model.addAttribute("teacher",teacher);
		return "teacherList";
	}
}
