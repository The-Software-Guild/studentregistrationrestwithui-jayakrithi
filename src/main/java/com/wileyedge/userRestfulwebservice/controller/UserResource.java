package com.wileyedge.userRestfulwebservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wileyedge.userRestfulwebservice.exceptions.UserNotFoundException;
import com.wileyedge.userRestfulwebservice.model.Student;
import com.wileyedge.userRestfulwebservice.service.IService;

@RestController
@CrossOrigin("*")
public class UserResource {

	@Autowired
	private IService service;
	
	// GET /users/
	// @RequestMapping(value="/users/", method = RequestMethod.GET)
	@GetMapping(path = "/users")
	public List<Student> fetchAllUsers(){
		System.out.println("Inside fetchAllUsers() of UserResource");
		List<Student> users = service.retrieveAllUsers();
		return users;		
	}
	
	// GET /users/10
	//@RequestMapping(value="/users/{id}")
	@GetMapping(path = "/users/{id}")
	public Student fetchUser(@PathVariable int id) {
		System.out.println("Inside fetchUser() of UserResource");
		Student user = service.retrieveOne(id);
		if(user == null) {
			throw new UserNotFoundException("User with "+ id + " not available");
		}
		return user;
	}
	
	//@PostMapping(path="/users",consumes = "application/json")
	@PostMapping(path="/users")
//	public User createUser(@Valid @RequestBody User user, BindingResult result) {
	public Student createUser(@Valid @RequestBody Student user) {	
		System.out.println("Inside createUser of UserResource");
		Student u = service.save(user);
		return u;
	}
	
	@DeleteMapping(path= "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		System.out.println("Inside delete user of UserResource");
		service.deleteOneUser(id);
	}
	
	@GetMapping(path="/users/name/{name}")
	public List<Student> retrieveUsersByName(@PathVariable String name) {
		System.out.println("Inside retrieveUsersByName of UserResource");
		List<Student> users = service.findByName(name);
		System.out.println("Returned users "+ users);
		if(users == null) {
			throw new UserNotFoundException("User with "+ name + " not available");
		}
		return users;
	}
	
	
}
