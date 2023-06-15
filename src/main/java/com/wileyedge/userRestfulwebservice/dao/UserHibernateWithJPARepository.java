package com.wileyedge.userRestfulwebservice.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.wileyedge.userRestfulwebservice.model.Student;

@Repository(value="hiberjparepos")
public class UserHibernateWithJPARepository implements IDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public Student save(Student user) {
		System.out.println("Inside save() of UserHibernateWithJPARepository");
		em.merge(user);
		return null;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Student> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
