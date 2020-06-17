package com.itly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itly.dao.AdminDao;
import com.itly.pojo.Admin;
import com.itly.service.AdminService;

@Repository
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDao adminDao;

	@Override
	public Admin findAdminByAdmin(Admin admin) {
		// TODO 自动生成的方法存根
		return adminDao.findByAdmin(admin);
	}

}
