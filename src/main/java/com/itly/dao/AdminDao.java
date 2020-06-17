package com.itly.dao;

import org.springframework.stereotype.Repository;

import com.itly.pojo.Admin;

@Repository
public interface AdminDao {

	Admin findByAdmin(Admin admin);

}
