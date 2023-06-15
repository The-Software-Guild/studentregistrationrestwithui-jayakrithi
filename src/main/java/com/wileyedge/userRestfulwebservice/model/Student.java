package com.wileyedge.userRestfulwebservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "students")
public class Student {
	@Id
	private int id;
	
	private static int idGenerator = 0;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Age")
	private int age;
	
	@Column(name = "Mobileno")
	private long mobileno;
	
	@Column(name = "Address")
	private String address;
	
	public Student() {
		
	}

	public Student(String name, int age, long mobileno, String address) {
		super();
		this.id = idGenerator+1;
		this.name = name;
		this.age = age;
		this.mobileno = mobileno;
		this.address = address;
		idGenerator = idGenerator + 1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", mobileno=" + mobileno + ", address="
				+ address + "]";
	}
	
}
