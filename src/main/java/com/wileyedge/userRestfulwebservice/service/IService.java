package com.wileyedge.userRestfulwebservice.service;

import java.util.List;

import com.wileyedge.userRestfulwebservice.model.Student;

public interface IService {

	public List<Student> retrieveAllUsers();
	public Student retrieveOne(int id) ;
	public Student save(Student user);
	public void deleteOneUser(int id) ;
	public List<Student> findByName(String name);
}
