package com.hb05.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Book05 {
	
	@Id
	private int id;
	
	private String name;
	
	
	@ManyToMany(mappedBy = "books")   // mappedBy genelde parent tarafına yazılıyordu ama burada ilişkinin 
									 //  sahibi olmadığı için 2 tarafa da yazılabilir
	
	private List<Student05> students = new ArrayList<>();
	
	
	
	


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




	public List<Student05> getStudentList() {
		return students;
	}




	public void setStudentList(List<Student05> studentList) {
		this.students = studentList;
	}
	
	@Override
	public String toString() {
		return "Book05 [id=" + id + ", name=" + name + "]";
	}
	
	

}
