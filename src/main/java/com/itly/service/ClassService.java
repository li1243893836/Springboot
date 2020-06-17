package com.itly.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itly.pojo.SClass;

@Service
public interface ClassService {

	public List<SClass> findAll();

	public SClass findClassById(Integer id);

	public void updateClass(SClass sclass);

	public void addClass(SClass sclass);

	public SClass findClassByName(String name);
}
