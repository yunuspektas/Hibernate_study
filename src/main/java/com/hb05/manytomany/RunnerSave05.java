package com.hb05.manytomany;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class RunnerSave05 {

	public static void main(String[] args) {
		
		Book05 bookArt = new Book05() ;	
		Book05 bookMath = new Book05() ;
		
		Student05 student1 = new Student05();
		Student05 student2 = new Student05();
		Student05 student3 = new Student05();
		
		student1.setId(1001);
		student1.setName("John Coffee");
		student1.setGrade(65);
		student1.getBooks().add(bookMath);
		student1.getBooks().add(bookArt);
		
		student2.setId(1002);
		student2.setName("Walter White");
		student2.setGrade(89);
		student2.getBooks().add(bookMath);
		student2.getBooks().add(bookArt);
		
		student3.setId(1003);
		student3.setName("Maximus Decimus");
		student3.setGrade(78);
		student3.getBooks().add(bookMath);
		student3.getBooks().add(bookArt);
		
		bookArt.setId(101);
		bookArt.setName("Art Book");
		
		bookMath.setId(102);
		bookMath.setName("Math Book");
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student05.class).addAnnotatedClass(Book05.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		
		
		
		tx.commit();		
		session.close();
		sf.close();
		
		
		
		
		
		
	}

}
