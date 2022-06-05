package com.hb03.onetoone;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
		
//  ************************************
		/*
		 * student1 = session.get(Student03.class, 1001);
		 * System.out.println(student1.getDiary());
		 * 
		 * diary1 = session.get(Diary.class, 101); 
		 * System.out.println(diary1);
		 */
//  ****************************
//		String hqlQuery1 = "select s.name,d.name,s.grade from Student03 s inner join fetch Diary d on s.id=d.student";
//		List<Object []> resultList1 = session.createQuery(hqlQuery1).getResultList();
//		for (Object [] r : resultList1) {
//			System.out.println(Arrays.toString(r));
//		}
//   *****************************
//	String hqlQuery2 = "select s.name,d.name,s.grade from Student03 s left join fetch Diary d on s.id=d.student";
//	List<Object []> resultList2 = session.createQuery(hqlQuery2).getResultList();
//	for (Object [] r : resultList2) {
//		System.out.println(Arrays.toString(r));
//	}
//  ******************************
		/*
		 * String hqlQuery3 =
		 * "select s.name,d.name,s.grade from Student03 s r join fetch Diary d on s.id=d.student"
		 * ; List<Object []> resultList3 =
		 * session.createQuery(hqlQuery3).getResultList(); for (Object [] r :
		 * resultList3) { System.out.println(Arrays.toString(r)); }
		 */
//	****************
//		String hqlQuery4 ="from Student03 s inner join fetch s.diary";
//		
//		List<Student03> resultList4 = session.createQuery(hqlQuery4).getResultList();
//		System.out.println(resultList4);
//  ****************
//		String hqlQuery5 = "from Diary s inner join fetch d.student";
//
//		List<Student03> resultList5 = session.createQuery(hqlQuery5).getResultList();
//		System.out.println(resultList5);
		
//  ********************		
		Query<Result> query =  session.createQuery("select new com.hb03.onetoone.Result(s.name, d.name, s.grade) from Student03 s inner join fetch Diary d s.id=d.student"); 
		List<Result> results = query.getResultList();
		
		for (Result result : results) {
			System.out.println(result.getStudentName()+":"+result.getDiaryName()+":"+result.getStudentGrade());
		}
		
		
		
		
		

		tx.commit(); // fetch işlemlerinde commit e gerek yok ama konulması hibernate dökümantasyonlarında tavsiye ediliyor

		session.close();
		sf.close();

	}

}
