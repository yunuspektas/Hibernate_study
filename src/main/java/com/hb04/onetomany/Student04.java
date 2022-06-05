package com.hb04.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student04 {

	@Id
	private int id;
	// length : max karakter sayısını
	// nullable : ilgili kolonun mutlaka null olup olmayacagını belirler
	// updatable : update edilebilir. mesela ilk create eden kişinin isminin
	// değişmesini istemiyebiliriz
	// insertable : insert edilebilir
	@Column(name = "std_name", length = 100, nullable = false, unique = true) // @Column yazsanda yazmasanda kolon
																				// gerçekleşir
	private String name;

	private int grade;

	@OneToMany(mappedBy = "student") // bir öğrenciye bir çok kitaba sahip olabileceği için OneToMany ilişkişi kuruldu
	
	private List<Book04> bookList = new ArrayList<>();  // one to many ilişkisi için yazıldı. 
	//														bir öğrencinin birden fazala kitabı olabilir.
	
	
	 

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

	public List<Book04> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book04> bookList) {
		this.bookList = bookList;
	}

	@Override
	public String toString() {
		return "Student04 [id=" + id + ", name=" + name + ", grade=" + grade + ", bookList=" + bookList + "]";
	}
	
	

}
