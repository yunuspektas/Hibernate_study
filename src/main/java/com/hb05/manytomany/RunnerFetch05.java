package com.hb05.manytomany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch05 {

	public static void main(String[] args) {
		
		Student05 student1 = new Student05();
		Book05 book1 = new Book05();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student05.class).addAnnotatedClass(Book05.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		student1 = session.get(Student05.class, 1001);
		System.out.println(student1.getName());
		System.out.println("-----------------------");
		System.out.println(student1.getBooks().get(0));
		
		
		book1 = session.get(Book05.class, 101);
		System.out.println(book1);
		
		// HQL ile kitap ismine göre kayıt getirme ve kitap sahiplerinin sayısını görme
		String hqlQuery1 = "FROM Book05 b WHERE b.name='Math Book'";
		book1 = (Book05) session.createQuery(hqlQuery1).getSingleResult();
		System.out.println(book1.getName()+" : "+book1.getStudentList().size());
		System.out.println("---------------------");
		book1.getStudentList().forEach(s->System.out.println(s));  // !! Lambda 
		
		// HQL ile öğrenci ismine göre sorgu : 
		String hqlQuery2 = "FROM Student05 s WHERE s.name='John Coffe'"; // Entity ( Student05 , Book05 ) 
		student1 = (Student05) session.createQuery(hqlQuery2).getSingleResult();															//dışındaki kodlar case sensitive değildir
		student1.getBooks().forEach(b->System.out.println(b));
		
		// HQL ile öğrenci verilerini çekmek
		String hqlQuery3 = "SELECT s.name FROM STudent05 s";
		List<Object []> resultList1 = session.createQuery(hqlQuery3).list();
		System.out.println(resultList1);
		
		
		
		tx.commit();		
		session.close();
		sf.close();
		
		

	}

}
