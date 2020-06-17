package com.itly.service;

import org.springframework.stereotype.Service;

import com.itly.pojo.Admin;

@Service
public interface AdminService {

	Admin findAdminByAdmin(Admin admin);
	

}
