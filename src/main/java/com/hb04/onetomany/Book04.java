package com.hb04.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book04 {
	
	@Id  // otomatik import için bu ide de ctrl + shift+o ya basmak yeterli olur
	private int id;
	
	private String name;
	
	@ManyToOne
	private Student04 student;
	
	

}
