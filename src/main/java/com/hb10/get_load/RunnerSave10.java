package com.hb10.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {

	public static void main(String[] args) {
		Configuration con=new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student10.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx= session.beginTransaction();
		
		Student10 student1=new Student10();
		student1.setId(1001);
		student1.setName("John Coffee");
		student1.setGrade(100);
		
		
		Student10 student2=new Student10();
		student2.setId(1002);
		student2.setName("Walter White");
		student2.setGrade(54);
		
		//dönüşü void
		session.persist(student1);
		session.persist(student2);

		
		tx.commit();
		session.close();
		sf.close();
	}

}
