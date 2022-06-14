package com.hb07.fetchtype;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchRunner07 {

	public static void main(String[] args) {
		
		
		Student07 student1 = new Student07();
		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
	
		student1 = session.get(Student07.class, 1001);
		System.out.println(student1); // fetchType.Lazy olursa burada sadece student objesi gelir , 
									//	eğer EAGER ayarlanırsa Student ile beraber kitap listeside gelirdi yani 
									// EAGER da ilişkili olduğu tüm objeler gelir
		// ---> advantage of LAZY : 
			// * ilk yukleme zamanı daha hızlıdır
			// * daha az kaynak kullanır
		// ---> disadvantages of LAZY :
			// * istek sayısı artabilir ( bağlantılı objeler gelmediği için )
		
		// ---> Advantages of EAGER :
			// * istek sayısı daha az
		// ---> Disadvantages of EAGER :
			// * süre uzun ve kaynak kullanımı yüksektir
		
		// ---> Hangi tip ilişkilerde EAGER yapmalı ?  1To1 ve MTo1 
		// OneToOne		-	Hibernate default EAGER yapar
		// ManyToOne	-	Hibernate default EAGER yapar
		
		// OneToMany	-	Hibernate default LAZY yapar
		// ManyToMany	-	Hibernate default LAZY yapar



		
		
		tx.commit();	
		session.close();
		
		System.out.println(student1); // session kapandıktyan sonra bu satır çalışırsa bütün 
									// yapı gelir EAGER iken, ama fetcTYPE LAZY olsaydı exeption fırlatırdı
		// not : Student clasında STRING metodunda BookList istendiği için ve LAZY de BookList gelmediği için 
		//exeption fırlatıyor, session kapanmasaydı exeption fırlatmazdı. 
		
		// Not : LAZY ayarlandığında , session kapandıktan sonra ilişkili objeler get edilemez bu yüzden exeption alınır
		
		sf.close();
		
		
		

	}

}
