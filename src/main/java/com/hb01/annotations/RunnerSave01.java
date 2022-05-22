package com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

	public static void main(String[] args) {
		
		Student01 student1 = new Student01();
		student1.setId(1001);
		student1.setName("John Coffee");
		student1.setGrade(100);
		
		Student01 student2 = new Student01();
		student2.setId(1002);
		student2.setName("Water White");
		student2.setGrade(90);
		
		Student01 student3 = new Student01();
		student3.setId(1003);
		student3.setName("Maximus Decimus");
		student3.setGrade(90);
		
		
		
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student01.class);
		
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		tx.commit(); // veri tabanına bu öğrenci bilgisinin yazılmasını sağlıyor
		
		
		
		
		
		
		
		session.close();   // close edilmezse her istekde yeni bir connection açar. belli bir sayıda connection havuzu var.
		//sonunda connection leak olkuşur ve veri tabanı ulaşılamaz olur.
		sf.close();
		
		
		
	}

}
