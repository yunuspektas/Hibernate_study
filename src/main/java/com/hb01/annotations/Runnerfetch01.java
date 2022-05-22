package com.hb01.annotations;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Runnerfetch01 {

	public static void main(String[] args) {
		
		Student01 student1 = new Student01();
		
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student01.class);
		
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//Veri fetch etmek için 1.metod : 
		
		//student1=session.get(Student01.class, 1001); // 2.parametreye primery key girilmesi gerekiyor
		//System.out.println("------" + student1.getName()+ "--------");
		//System.out.println(student1); // pojo daki string metodu çalışır
		
		//Veri fetch etmek için 2.metod : 
		
		/*
		 * //String sglQuery1 = "SELECT * FROM student01"; // native Query ile select
		 * işlemi //listenin her elemanı bir kayıttır, her kayır kolonlardan oluştuıgu
		 * için Object Array içindeki her bir element //bir kolon bilgisi tutar
		 * //List<Object[]> resultList1 =
		 * session.createSQLQuery(sglQuery1).getResultList(); //for (Object[] r :
		 * resultList1) { // System.out.println(Arrays.toString(r)); //
		 * System.out.println("--------"); // System.out.println(r[2]); //}
		 */		
		
		// Veri fetch etmek için 3.metod ---> HQL : Hybernate Query Language 
		// HQL sorgularında FROM dan sonra Entity ismini kullanıyoruz.
		// Bu örnekte Entity ismi Student01 olduğu için aşağıdaki sorguda bu şekildedir
		/*
		 * String hqlQuery1 = "FROM Student01"; // HQL de sorgularımızda artık class
		 * kullanıyoruz. List<Student01> resultList2 =
		 * session.createQuery(hqlQuery1).getResultList(); for ( Student01 student :
		 * resultList2) { System.out.println(student); }
		 */
		
		
		// SQl sorgu yani native query sorgu kullanmanın dezavantajı : mysql ve postgresql e has farklı syntax olabilir. 
		//burada kullanılan native query hataya sebeb olabilir, o yüzden olabildiğince 1. ve 3. metod kullanılmalı
		
		
		// ismi John Coffee olan öğrenciis fetch edelim :
		
		// 1.yol: SQL ile
		String sqlQuery2 = "SELECT * FROM student01 where name='John Coffee'";
		/*
		 * String sqlQuery2 = "SELECT * FROM student01 where name='John Coffee'";
		 * List<Object []> resultList3 =
		 * session.createSQLQuery(sqlQuery2).getResultList(); for (Object [] r :
		 * resultList3) { System.out.println(Arrays.toString(r)); }
		 */
		
		// Eğer sorgu sonucu tek bir kayıt (unıque) döneceğinden eminsek 
		/*
		 * Object[] result1 = (Object[])
		 * session.createSQLQuery(sqlQuery2).uniqueResult();
		 * System.out.println(Arrays.toString(result1));
		 */
		
		// HQL ile unique result 
//		String hqlQuery2 = "FROM Student01 s where s.name='John Coffee'"; // Student01'e s takma ismi verdim (alias kullanıldı)
//		Object result2 = session.createQuery(hqlQuery2).uniqueResult();
//		System.out.println(result2);
		
		
		// HQL ile notu 100 olan öğrencleri fetch edelim
		
		/*
		 * String hqlQuery3 = "FROM Student01 s where s.grade=100"; List<Object>
		 * resultList4 = session.createQuery(hqlQuery3).getResultList(); for (Object r :
		 * resultList4) { System.out.println(r); }
		 */
		
		// HQL ile notu 100 olan öğrenclerin adlarını fetch edelim
		
		String hqlQuery4 = "SELECT s.name FROM Student01 s where s.grade=100";
		List<Object> resultList5 = session.createQuery(hqlQuery4).getResultList();
		for (Object r : resultList5) {
			System.out.println(r);
		}
		
		
		
		
		
		tx.commit(); 	
		session.close();   
		sf.close();

	}

}
