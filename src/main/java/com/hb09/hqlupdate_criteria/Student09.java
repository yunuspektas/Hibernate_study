package com.hb09.hqlupdate_criteria;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student09 {

	@Id
	private int id;
	
	private String name;
	
	private int grade;

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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student09 [id=" + getId() + ", name=" + name + ", grade=" + grade + "]";
	}


	
	
}
