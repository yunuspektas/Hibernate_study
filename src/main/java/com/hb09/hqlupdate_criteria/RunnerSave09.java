package com.hb09.hqlupdate_criteria;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {

	public static void main(String[] args) {
		Configuration con=new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student09.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx= session.beginTransaction();
		
		//persist metodu void döner. session.persist
		//save metodu ise persiste edilen Objeyi döner.
		//session.save
		
		
		Random random=new Random();
		for(int i=1;i<=50;i++) {
			Student09 student=new Student09();
			student.setId(i);
			student.setName("Random Name"+i);
			student.setGrade(random.nextInt(100));
			session.save(student);
		}
		
		tx.commit();
		session.close();
		sf.close();
	}

}
