package com.hb11.object_life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave11 {

	public static void main(String[] args) {
		
		//Transient 
		//Hibernate session ile ilişkilendirilmemiş objenin durumudur.
		Student11 student1=new Student11();
		student1.setId(1);
		student1.setName("aaaa");
		student1.setGrade(56);
		
		Configuration con=new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student11.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx= session.beginTransaction();
		
		//MANAGED STATE
		//Hibernate ile ilişkendirilmiş object statei managedir'dir
		session.save(student1);
        //student1.setName("bbbbb"); 

        
        //DETACHED state session.close yapıldığında object detached duruma düşer.
		session.detach(student1);
		student1.setName("cccc");
		
		tx.commit();
		
		
		
		session.close();
		
		//REMOVE objenin hibernate ile ilişkisinin kalmadığını ifade eder.
		
		sf.close();
	}

}
