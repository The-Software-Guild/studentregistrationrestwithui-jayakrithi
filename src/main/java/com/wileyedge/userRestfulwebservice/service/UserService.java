package com.wileyedge.userRestfulwebservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wileyedge.userRestfulwebservice.dao.IDao;
import com.wileyedge.userRestfulwebservice.model.Student;

@Service
public class UserService implements IService {

	@Autowired
	@Qualifier(value="jparepos")
	//@Qualifier(value="hiberjparepos")
	private IDao dao;
	

	@Override
	public List<Student> retrieveAllUsers() {
		System.out.println("Inside retrieveAllUsers() of UserService");
		List<Student> users = dao.findAll();
		return users;
	}
	
	@Override
	public Student retrieveOne(int id) {
		Optional<Student> opt = dao.findById(id);
		Student user = null;
		if(opt.isPresent()) {
			user = opt.get();
		}
		return user;
	}
	
	@Override
	public Student save(Student user) {
		System.out.println("user");
		Student u = dao.save(user);
		return u;
	}
	
	public void deleteOneUser(int id) {
		System.out.println("Delete a user");
		dao.deleteById(id);
	}

	@Override
	public List<Student> findByName(String name) {
		System.out.println("Inside findByName a userService");
	    return dao.findByName(name);
	}

}
