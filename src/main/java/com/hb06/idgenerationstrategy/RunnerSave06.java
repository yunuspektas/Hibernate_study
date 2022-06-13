package com.hb06.idgenerationstrategy;

import javax.persistence.GeneratedValue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class RunnerSave06 {

	public static void main(String[] args) {
		
		
		// Burada oluşturulan objelerin "Id" değişkenlerini set etmeye gerek kalmadı, çünki Student06 clasında
		// id fielda @GeneratedValue olarak annotation ekledik.
		Student06 student1 = new Student06();
		student1.setName("John Coffe");
		student1.setGrade(100);

		Student06 student2 = new Student06();
		student1.setName("Maximus Decimus");
		student1.setGrade(65);
		
		Student06 student3 = new Student06();
		student1.setName("Walter White");
		student1.setGrade(85);
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student06.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		
		
		
		
		
		tx.commit();		
		session.close();
		sf.close();

	}

}
