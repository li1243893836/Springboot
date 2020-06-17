package com.itly.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itly.dao.AdminDao;
import com.itly.pojo.Admin;

@Repository
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	JdbcTemplate template;

	@Override
	public Admin findByAdmin(Admin admin) {
		// TODO 自动生成的方法存根
		Admin ad;
		try {
			String sql = "select * from admin where name = ? and password = ?";
			ad = template.queryForObject(sql, new BeanPropertyRowMapper<>(Admin.class), admin.getName(),admin.getPassword());
		}catch(Exception e) {
			ad = null;
		}
		
		return ad;
	}

}
