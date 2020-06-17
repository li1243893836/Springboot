package com.itly.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itly.dao.StudentDao;
import com.itly.pojo.SClass;
import com.itly.pojo.Student;
import com.itly.pojo.StudentCustom;
import com.itly.pojo.StudentExtend;

@Repository
public class StudentDaoImpl implements StudentDao{
	

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public List<Student> findAll() {
		// TODO 自动生成的方法存根
		String sql = "select * from student";
		return template.query(sql, new Object[]{},new BeanPropertyRowMapper<>(Student.class));
	}

	@Override
	public void addStudent() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public List<StudentCustom> findCustomAll() {
		// TODO 自动生成的方法存根
		String sql = "SELECT student.id as id,student.name as name,sclass.name as cname,"
				+ "sex,age,qq,email,address FROM student,sclass WHERE student.classId = sclass.id";
		
		return template.query(sql, new Object[]{},new BeanPropertyRowMapper<>(StudentCustom.class));
	}

	@Override
	public Student findById(Integer id) {
		// TODO 自动生成的方法存根
		String sql = "select * from student where id = ?";
		return template.queryForObject(sql,new BeanPropertyRowMapper<>(Student.class),id);	
	}

	@Override
	public void update(Student student) {
		// TODO 自动生成的方法存根
		String sql = "update student set sex = ?,age = ?,address = ?,qq = ?,email = ? where id = ?";
		template.update(sql,student.getSex(),student.getAge(),student.getAddress(),student.getQq(),student.getEmail(),student.getId());
	}

	@Override
	public void delete(Integer id) {
		// TODO 自动生成的方法存根
		String sql1 = "DELETE FROM selected_course WHERE student_id = ?";
		String sql2 = "DELETE from score where student_id = ?";
		String sql3 = "DELETE from attendance where student_id = ?";
		String sql = "DELETE from student where id = ?";
		template.update(sql1,id);
		template.update(sql2,id);
		template.update(sql3,id);
		template.update(sql,id);
	}

	@Override
	public void insert(StudentCustom studentCustom) {
		// TODO 自动生成的方法存根
		String sql = "insert into student(name,sex,age,address,qq,email,classId,username,password) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		template.update(sql,studentCustom.getName(),studentCustom.getSex(),studentCustom.getAge()
				,studentCustom.getAddress(),studentCustom.getQq(),studentCustom.getEmail(),
				studentCustom.getClassId(),studentCustom.getUsername(),studentCustom.getPassword());
	}

	@Override
	public List<StudentCustom> findByCname(String cname) {
		// TODO 自动生成的方法存根
		
		String sql = "SELECT student.id as id,student.name as name,"
				+ "sclass.name as cname,sex,age,qq,email,address FROM student,"
				+ "sclass WHERE student.classId = sclass.id and sclass.name = ? ";
				List<StudentCustom> s  = template.query(sql,new BeanPropertyRowMapper<>(StudentCustom.class),cname);
				for(StudentCustom s1 : s) {
					System.out.println(s1);
				}
				return s;
	}

	@Override
	public List<StudentCustom> findByName(String name) {
		// TODO 自动生成的方法存根
		String sql = "SELECT student.id as id,student.name as name,"
				+ "sclass.name as cname,sex,age,qq,email,address FROM student,"
				+ "sclass WHERE student.classId = sclass.id and student.name = ? ";
		return template.query(sql,new BeanPropertyRowMapper<>(StudentCustom.class),name);
	}

	@Override
	public List<StudentCustom> findByCnameAndName(String name, String cname) {
		// TODO 自动生成的方法存根
		String sql = "SELECT student.id as id,student.name as name,"
				+ "sclass.name as cname,sex,age,qq,email,address FROM student,"
				+ "sclass WHERE student.classId = sclass.id and sclass.name = ? and student.name = ? ";
		return template.query(sql,new BeanPropertyRowMapper<>(StudentCustom.class),name,cname);
	}

	@Override
	public List<StudentCustom> findByClassId(Integer cid) {
		// TODO 自动生成的方法存根
		String sql  = "SELECT student.id as id,student.name as name,sclass.name as cname," + 
				"sex,age,qq,email,address FROM student,sclass WHERE student.classId = sclass.id and sclass.id = ?";
		return template.query(sql,new BeanPropertyRowMapper<>(StudentCustom.class),cid);
	}

	@Override
	public List<StudentCustom> findByCourse(Integer id) {
		// TODO 自动生成的方法存根
		String sql = "SELECT distinct student.id as id,student.name as name,sclass.name as cname,"
				+ "sex,age,qq,email,address FROM student,sclass "
				+ "WHERE student.classId = sclass.id and student.id in ("
				+ "select student.id from student,course,selected_course "
				+ "where course.id = selected_course.course_id "
				+ "and student.id = selected_course.student_id and course.id = ?)";
		return template.query(sql,new BeanPropertyRowMapper<>(StudentCustom.class),id);
	}

}
