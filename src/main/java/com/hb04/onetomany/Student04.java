package com.hb04.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

	@OneToMany(mappedBy = "student", orphanRemoval=true, cascade= CascadeType.ALL) // --->  bir öğrenciye bir çok kitaba sahip olabileceği için 
	//	OneToMany ilişkişi kuruldu
	//  ---> her book un studentını setStudent metodu ile set etmek istemiyorsam CascadeType.ALL eklerim. 
	//  Cascade yapabilmek için RunnerSave04 sınıfındaki 36, 40 ve 44. satırları commente aldım.
	// CascadeType.Remove  --->  parent nesneyi silrsem ona bağlı olan bütün childlarda silinir.
	// CascadeType.Persist --->  parent objem kaydedildiği zaman diğer childlarda UYGULANIR
	// orphanRemoval=true  --->  foreign key de olsa ilgili row u silmemizi sağlıyor
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
