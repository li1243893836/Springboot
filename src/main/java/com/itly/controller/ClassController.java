package com.itly.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itly.pojo.SClass;
import com.itly.pojo.StudentCustom;
import com.itly.service.ClassService;
import com.itly.service.StudentService;

@Controller
public class ClassController {
	
	@Autowired
	ClassService classService;
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/classList")
	public String classList(Model model) {
		List<SClass> sclass = classService.findAll();
		model.addAttribute("sclass", sclass);
		return "classList";
	}
	
	@RequestMapping("/findClassById")
	public String findClassById(Model model,HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		SClass sclass = classService.findClassById(id);
		model.addAttribute("sclass",sclass);
		return "updateClass";
	}
	
	@RequestMapping("/updateClass")
	public String updateClass(@ModelAttribute SClass sclass) {
		classService.updateClass(sclass);
		return "redirect:/classList";
	}

	@RequestMapping("/findStudentByClass")
	public String findStudentByClass(Model model,HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		List<StudentCustom> student = studentService.findStudentByClassId(id);
		model.addAttribute("student",student);
		return "student";
	}
	
	@RequestMapping("/addc")
	public String add() {
		return "addClass";
	}
	
	@RequestMapping("/addClass")
	public String addClass(@ModelAttribute SClass sclass) {
		SClass scla = null;
		scla = classService.findClassByName(sclass.getName());
		if(scla != null) {
			
			return "redirect:/classList";
		}
		classService.addClass(sclass);
		return "redirect:/classList";
	}
}
