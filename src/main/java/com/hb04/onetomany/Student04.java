package com.hb04.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student04 {
	
	@Id
	private int id;
	//length : max karakter sayısını
	//nullable  : ilgili kolonun mutlaka null olup olmayacagını belirler
	//updatable : update edilebilir. mesela ilk create eden kişinin isminin değişmesini istemiyebiliriz
	//insertable : 
	@Column(name = "std_name", length = 100, nullable = false, unique = true) // bunu yazsanda yazmasanda kolon
																				// gerçekleşir
	private String name;

}
