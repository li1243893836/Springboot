package com.itly.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itly.pojo.Teacher;

@Repository
public interface TeacherDao {

	List<Teacher> findAll();

	void delete(Integer id);

	Teacher findById(Integer id);

	void update(Teacher teacher);

	void insert(Teacher teacher);

	List<Teacher> findByName(String name);

	List<Teacher> findByTitle(String title);

	List<Teacher> findByNameAndTitle(String name, String title);

}
