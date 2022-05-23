package com.hb03.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {

	public static void main(String[] args) {
		
		Student03 student1 = new Student03();
		Diary diary1 = new Diary();
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		con.addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		student1 = session.get(Student03.class, 1001);
		System.out.println(student1.getDiary());
		
		diary1 = session.get(Diary.class, 101);
		System.out.println(diary1);
		
		
		
		
		
		
		
		tx.commit();

		session.close();
		sf.close();

	}

}
