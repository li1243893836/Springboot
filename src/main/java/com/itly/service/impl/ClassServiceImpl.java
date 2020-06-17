package com.itly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itly.dao.ClassDao;
import com.itly.pojo.SClass;
import com.itly.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService{

	@Autowired
	private ClassDao classDao;
	
	@Override
	public List<SClass> findAll() {
		// TODO 自动生成的方法存根
		return classDao.findAll();
	}

	@Override
	public SClass findClassById(Integer id) {
		// TODO 自动生成的方法存根
		return classDao.findById(id);
	}

	@Override
	public void updateClass(SClass sclass) {
		// TODO 自动生成的方法存根
		classDao.update(sclass);
	}

	@Override
	public void addClass(SClass sclass) {
		// TODO 自动生成的方法存根
		classDao.add(sclass);
	}

	@Override
	public SClass findClassByName(String name) {
		// TODO 自动生成的方法存根
		return classDao.findByName(name);
	}

}
