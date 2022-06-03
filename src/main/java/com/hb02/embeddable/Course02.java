package com.hb02.embeddable;

import javax.persistence.Embeddable;

@Embeddable    // bu annotatşon ile b uannotationun sahip oldugu instance veriableları ayrı sınıfda 
//				ama Student02 ile aynı tabloda tutmak istediğimi belirtiyorum, 
public class Course02 {
	
	public String getElective() {
		return elective;
	}
	public void setElective(String elective) {
		this.elective = elective;
	}
	public String getMandatory() {
		return mandatory;
	}
	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}
	private String elective;
	private String mandatory;
	
	
	@Override
	public String toString() {
		return "Course02 [elective=" + elective + ", mandatory=" + mandatory + "]";
	}
	
	

}
