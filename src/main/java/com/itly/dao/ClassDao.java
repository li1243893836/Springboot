package com.itly.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itly.pojo.SClass;

@Repository
public interface ClassDao {

	public List<SClass> findAll();

	public SClass findById(Integer id);

	public void update(SClass sclass);

	public void add(SClass sclass);

	public SClass findByName(String name);
}
