package com.hb04.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book04 {
	
	@Id  // otomatik import için bu ide de ctrl + shift+o ya basmak yeterli olur
	private int id;
	
	private String name;
	
	@ManyToOne    // bir çok kitab bir öğrenciye ait olabileceği için manyToOne ilişkişi kuruldu
	@JoinColumn(name = "student_id")
	private Student04 student;

		
	
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

	public Student04 getStudent() {
		return student;
	}

	public void setStudent(Student04 student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Book04 [id=" + id + ", name=" + name + ", student=" + student + "]";
	}
	
	

}
