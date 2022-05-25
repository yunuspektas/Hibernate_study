package com.hb04.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student04 {
	
	@Id
	private int id;
	@Column(name ="std_name") // bunu yazsanda yazmasanda kolon gerçekleşir
	private String name;

}
