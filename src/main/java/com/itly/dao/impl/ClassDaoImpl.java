package com.itly.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itly.dao.ClassDao;
import com.itly.pojo.SClass;
import com.itly.pojo.Student;
@Repository
public class ClassDaoImpl implements ClassDao {

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<SClass> findAll() {
		// TODO 自动生成的方法存根
		String sql = "select * from sclass";
		return template.query(sql, new Object[]{},new BeanPropertyRowMapper<>(SClass.class));
	}

	@Override
	public SClass findById(Integer id) {
		// TODO 自动生成的方法存根
		String sql = "select * from sclass where id = ?";
		return template.queryForObject(sql, new BeanPropertyRowMapper<>(SClass.class),id);
	}

	@Override
	public void update(SClass sclass) {
		// TODO 自动生成的方法存根
		String sql = "update sclass set name = ?,info = ? where id = ?";
		template.update(sql,sclass.getName(),sclass.getInfo(),sclass.getId());
	}

	@Override
	public void add(SClass sclass) {
		// TODO 自动生成的方法存根
		String sql  = "insert into sclass(name,info) values(?,?)";
		System.out.println(sclass.getName()+sclass.getInfo());
		template.update(sql,sclass.getName(),sclass.getInfo());

	}

	@Override
	public SClass findByName(String name) {
		// TODO 自动生成的方法存根
		
		SClass sclass = null;
		try {
			String sql = "select * from sclass where name = ?";
			sclass = template.queryForObject(sql, new BeanPropertyRowMapper<>(SClass.class),name);
		}catch(Exception e) {
		
			return sclass;
		}
		return null;
	}

}
