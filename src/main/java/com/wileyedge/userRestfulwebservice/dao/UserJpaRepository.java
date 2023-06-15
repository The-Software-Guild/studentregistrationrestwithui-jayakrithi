package com.wileyedge.userRestfulwebservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wileyedge.userRestfulwebservice.model.Student;
/*
 * The idea is that you 
   create interface method signatures in a specific format
   that the system can interpret and 
   convert to SQL queries behind the scenes.
   
   These method names always start with findBy, followed by the 
   filters we want to apply to the query
   
   eg: List<Store> findByManager(String manager); internally is converted to
   SELECT * FROM store WHERE manager = ?
   The question mark will be filled in by the parameter of the method.
 *  */
/*
  findById   : Retrieves one object based on the ID you pass it
  findAll    :	Retrieves a list of all the objects of the type
  save       :	Used for both creating and updating an object; returns the object that was created or updated as it now exists in the database
  deleteById : Deletes the object with the passed ID from the database
  count      : Retrieves a count of all objects of a type in the database
  existsById : Checks if an object with the passed ID exists in the database; returns true or false
*/
@Repository(value= "jparepos")
public interface UserJpaRepository extends IDao, JpaRepository<Student, Integer> {
	public List<Student> findByName(String name);
}




