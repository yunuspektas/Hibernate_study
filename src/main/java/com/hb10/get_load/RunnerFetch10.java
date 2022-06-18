package com.hb10.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch10 {

	public static void main(String[] args) {
		
		
		//GET unique bir id ile istek yapılıyor.
		//GET hemen istenen objeyi hemen döndürüyor.
		//GET metodunda istenen id ile ilgili bir kayıt yok ise null döner
		//GET metodu yavaştır
		
		//LOAD metodu sorgu oluşturmadığı için daha hızlıdır.
		//LOAD ise objenin referansını döndürüyor.
        //LOAD metodunda istenen id ile bir kayıt yok ise ObjectNotFoundException alınır
		
		
		Configuration con=new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student10.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx= session.beginTransaction();

//		Student10 student1=session.get(Student10.class, 1003);
//		System.out.println(student1);
		
		
		Student10 student2=session.load(Student10.class, 1003);
		//System.out.println(student2.getName());
		
		
		tx.commit();
		session.close();
		
		
		//System.out.println(student2.getName());
		
		sf.close();
	}

}
