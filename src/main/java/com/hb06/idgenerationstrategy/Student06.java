package com.hb06.idgenerationstrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Student06 {
	
		// generatedVAlue tek başına kullanılırsa defaultta AUTO seçer.
		// GenerationType.IDENTITY en kolay ID oluşturma yöntemidir ama performans olarak en iyisi değildir. veritabanındaki auto increment olayına göre çalışır
		// GenerationType.SEQUENCE performansı daha yüksek ( IDENTITY ye göre). toplu insert işlemlerinde tercih edilmeli
		// GenerationType.TABLE performansı düşük , çok kullanılmıyor
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator ="STD_SEQ")
		// oto ID vermeye 1000 sayısı ile başlasın ve aynı sessionda iken birer birer artsın ama farklı session da iken  50 50 artsın
	@SequenceGenerator(name="STD_SEQ", initialValue = 1000, allocationSize = 50) 
	
	
	private int id;
	
	private String name ;
	
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
	

}
