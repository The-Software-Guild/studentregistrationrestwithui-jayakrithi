package com.wileyedge.userRestfulwebservice.dao;

import java.util.List;
import java.util.Optional;

import com.wileyedge.userRestfulwebservice.model.Student;

public interface IDao {
	public Student save(Student user);
	public List<Student> findAll();
	Optional<Student> findById(int id);
	public Student deleteById(int id);
	public List<Student> findByName(String name);
}
