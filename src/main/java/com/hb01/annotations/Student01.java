package com.hb01.annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@Entity // veri tabanında bir tablo karşılığı oldugunu gösterir. 
//@Entity(name="student01") ---> bu hem tablo ismini hem de sorgularda kullanacağınız entity ismi bu verilen isim olacaktır
//@Table(name="tbl_student01") ---> bu anotation oluşturulacak tablonun ismini belirler.
public class Student01 {
	
	@Id    // bu annotation altındaki değişkeni primary key yapar, bu annotation her entity sınıfında olmalı
	private int id ;
	
	//@Column(name="student_name") ---> eger tablodaki kolon ismini değişken isminden fatklı bir isim olarak oluşturmak istersek
	@Column
	private String name ;
	
	
	@Column
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
		return "Student01 [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	
	
	

}
