package com.hb09.hqlupdate_criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class RunnerFetch09 {

	public static void main(String[] args) {
		
		//private String name;
		//findByName()
		//findById()
		//findBySSN()
		
		/*
		 * CRUD: create: read update: delete:
		 * 
		 * create (insert):
		 * session.save, session.persist,hql ile insert yapılamıyor.
		 * read (select): sql, hql, session.get(id): criteria API
		 * update:
		 * delete: hql, ve session.delete 
		 */
		Student09 student1=new Student09();
		
		Configuration con=new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student09.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx= session.beginTransaction();
		
		//bir id ile kayıt güncelleme: get method
//		student1=session.get(Student09.class , 1);
//		student1.setName("Updated:"+student1.getName());
//		session.update(student1); 
		
		//bir id ile kayıt güncelleme: HQL ile
//		String hqlQuery1="UPDATE Student09 s SET s.name='Updated with HQL' WHERE s.id=5";
//		int numOfRecords=session.createQuery(hqlQuery1).executeUpdate();
//		System.out.println("Effected row count:"+numOfRecords);
		
		//notu 90 üstünde olanların notunu 100 yap
//		String hqlQuery2="UPDATE Student09 s SET s.grade=100 WHERE s.grade>90";
//		int numOfRecords2 = session.createQuery(hqlQuery2).executeUpdate();
//		System.out.println("Effected row count:"+numOfRecords2);
		
		//notu 50'den küçük olan öğrencileri fetch et sonra onların notlarını 50'ye set et.
//		String hqlQuery3="FROM Student09 s WHERE s.grade<50";
//		List<Student09> resultList1 = session.createQuery(hqlQuery3).getResultList();
//		
//		for (Student09 student : resultList1) {
//			student.setGrade(50);
//			session.update(student);
//		}
//		
		
	//Criteria API Examples
	//---------------------------------------------------
	
//		CriteriaBuilder cb=session.getCriteriaBuilder();
//		CriteriaQuery<Student09> criteriaQuery= cb.createQuery(Student09.class);
//		Root<Student09> root= criteriaQuery.from(Student09.class);
		
		//Tüm kayıtları select etme
		//criteriaQuery.select(root);
		
		//Expression ile sorgu oluşturma
//		criteriaQuery.select(root).where(cb.equal(root.get("name"),"Random Name2"));
//		
//       	Query<Student09> query= session.createQuery(criteriaQuery);
//		List<Student09> resultList1= query.getResultList();
//		
//		resultList1.forEach(r->System.out.println(r));
		
		
		//iki koşulu birleştirerek criteria apı kullanım
//		Predicate predicateForName=cb.equal(root.get("name"),"Random Name2");
//		Predicate predicateForGt50=cb.gt(root.get("grade"),50);
//		
//		Predicate predicateStd=cb.and(predicateForName,predicateForGt50);
//		
//		criteriaQuery.where(predicateStd);
//		
//   	Query<Student09> query= session.createQuery(criteriaQuery);
//	List<Student09> resultList1= query.getResultList();
//	
//	resultList1.forEach(r->System.out.println(r));
		
		
		//Aggregate function (sum) 
	    //öğrecilerin notlarının toplamını getirmek istiyorum
		CriteriaBuilder cb=session.getCriteriaBuilder();
		CriteriaQuery<Integer> criteriaQueryInteger=  cb.createQuery(Integer.class);
		Root<Student09> root= criteriaQueryInteger.from(Student09.class);
		
		criteriaQueryInteger.select(cb.sum(root.get("grade")));
		
		Query<Integer> queryForSum = session.createQuery(criteriaQueryInteger);
		
		Integer sum= queryForSum.getSingleResult();
		
		System.out.println("Toplam:"+sum);
		
		
		tx.commit();
		session.close();
		sf.close();
	}

}
