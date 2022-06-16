package com.hb08.first_Second_levelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {

	public static void main(String[] args) {
		
		Student08 student1 = new Student08();
		Student08 student2 = new Student08();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student08.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		// First Level Cache ----> 1.senaryo :  aynı session içinde aynı ID ile fetch yapıldıgında :
		
//		student1 = session.get(Student08.class, 1L);  // id long verildiği için 1L yazıldı
//		System.out.println("-------------------");
//		System.out.println(student1);
//		
//		// session.clear(); ---> Eger first level Cache i temizlemek istersek session.clear ile yapılır.
//		
//		System.out.println("-------------------");
//		student1 = session.get(Student08.class, 1L); // aynı id ile aynı session içinde işlem yapınca , 
//		//bu sorguda 2.kez veritabanına gitmeden firstLevelCache den alıp getirir
//		System.out.println("-------------------");
//		System.out.println(student1);
//
//		
//		tx.commit();	
//		session.close();
//		sf.close();
		
		//	2.level cache ----->  1.senaryo :
			// hibernate.jcache ve ehcache dependency lerin eklenmesi gerekiyor pom.xml dosyasına
			// aynı Id yi farklı sessionlarda ( ama aynı SessionFactory de olması gerekiyor) çağırdıgımız 
			//zaman hibernate 2 defa veritabanına gitmek yerine, ilk gittiğinde aldıgı bilgiyi 
			// 2.level cache e atar ve dah sonra çağırıldığında cache den gidip alır
		
		student1 = session.get(Student08.class, 1L);
		System.out.println(student1 );
		
		tx.commit();	
		session.close();
		
		// 2.session  ( farklı session ama aynı ID li obje kullanılacak)
		Session session2 = sf.openSession();
		Transaction tx2 = session2.beginTransaction();
		
		student2 = session2.get(Student08.class, 1L);
		System.out.println(student2);
		
		tx2.commit();
		session2.close();
		
		sf.close();
		
		
		

	}

}
