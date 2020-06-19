package com.itly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itly.pojo.Admin;
import com.itly.pojo.StudentCustom;
import com.itly.service.AdminService;
import com.itly.service.StudentService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/index")
	public String login() {
		
		return "index";
	}
	@RequestMapping("/loginAdmin")
	public String adminLogin(@ModelAttribute Admin admin,Model model) {
		Admin ad = adminService.findAdminByAdmin(admin);
		if(ad == null) {
			String mrc = "用户名或密码错误！";
			model.addAttribute("mrc", mrc);
			return "login1";
		}
		return "student";
	}

	@RequestMapping("/student")
	public String student() {
		return "student";
	}
	@RequestMapping("/class1")
	public String class1() {
		return "class1";
	}
	@RequestMapping("/teacher")
	public String teacher() {
		return "teacher";
	}
	
}
