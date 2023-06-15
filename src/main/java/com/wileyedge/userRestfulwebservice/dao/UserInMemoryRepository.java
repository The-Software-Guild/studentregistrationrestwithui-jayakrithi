package com.wileyedge.userRestfulwebservice.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.wileyedge.userRestfulwebservice.model.Student;

@Repository
@Profile("dev")
public class UserInMemoryRepository implements IDao {

	private static List<Student> users = new ArrayList<Student>();
	private static int userCount = 3;
	
	//static blocks get called even before main method
	static {
		users.add(new Student("Jack",21, 8989, "Tokyo"));
		users.add(new Student("Liam",25, 7778, "Osaka"));
		users.add(new Student("Louis",27, 2121, "Seoul"));
	}
	
	public UserInMemoryRepository() {
		System.out.println("Object of userInMemory Repository created");
	}
	@Override
	public Student save(Student user) {
		System.out.println("Inside save");
		users.add(user);
		return user;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public Optional<Student> findById(int id) {
		// TODO Auto-generated method stub
		Student user = users.stream().filter(a -> a.getId() == id).findAny().orElse(null);
		Optional<Student> opt = Optional.ofNullable(user);
		return opt;
	}

	@Override
	public Student deleteById(int id) {
		Iterator<Student> iter = users.iterator();
		while(iter.hasNext()) {
			Student user = iter.next();
			if(user.getId() == id) {
				iter.remove();
				return user;
			}
		}
		return null;
	}

	@Override
	public List<Student> findByName(String name) {
		Iterator<Student> iter = users.iterator();
		List<Student> usersByName = new ArrayList<>();
		while(iter.hasNext()) {
			Student user = iter.next();
			if(user.getName().equalsIgnoreCase(name)) {
				usersByName.add(user);
			}
		}
		return usersByName;
	}

}
