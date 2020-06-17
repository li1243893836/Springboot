package com.itly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itly.pojo.Admin;
import com.itly.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	@RequestMapping("/loginAdmin")
	public String adminLogin(@ModelAttribute Admin admin,Model model) {
		Admin ad = adminService.findAdminByAdmin(admin);
		if(ad == null) {
			String mrc = "用户名或密码错误！";
			model.addAttribute("mrc", mrc);
			return "login";
		}
		return "index";
	}

}
