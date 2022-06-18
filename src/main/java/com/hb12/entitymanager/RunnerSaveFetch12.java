package com.hb12.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RunnerSaveFetch12 {

	public static void main(String[] args) {
		
		
		Student12 student=new Student12();
		student.setName("John Coffee");
		student.setGrade(100);
		
		//Hibernatedeki SessionFactory'e karşılık gelir.
		EntityManagerFactory emf=Persistence.
				createEntityManagerFactory("studentunit"/*persistence.xml den unit bilgisini studentunit ie aldık.*/);
		
		//Hibernate session'a karşılık geliyor.
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//session.save gibi
//		em.persist(student);
		
		//session.get
		Student12 student1 = em.find(Student12.class, 1);
//		System.out.println(student1);

		
//		Object result = em.createQuery("FROM Student12 s Where s.name='John Coffee'").getSingleResult();
//		System.out.println(result);
		
		
		em.remove(student1);
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
