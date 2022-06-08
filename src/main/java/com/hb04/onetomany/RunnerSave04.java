package com.hb04.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {

	public static void main(String[] args) {
		
		Book04 book1 = new Book04();
		Book04 book2 = new Book04();
		Book04 book3 = new Book04();
		Book04 book4 = new Book04();
		
		Student04 student1 = new Student04();
		Student04 student2 = new Student04();
		Student04 student3 = new Student04();
		
		
		student1.setId(1001);
		student1.setGrade(100);
		student1.setName("John Coffe");
		
		student2.setId(1002);
		student2.setGrade(86);
		student2.setName("Walter White");
		
		student3.setId(1003);
		student3.setGrade(100);
		student3.setName("Maximus Decimus");
		
		book1.setId(101);
		book1.setName(student1.getName()+" 's book");
		book1.setStudent(student1);
		
		book2.setId(102);
		book2.setName(student1.getName()+" 's book");
		book2.setStudent(student1);
		
		book3.setId(103);
		book3.setName(student2.getName()+" 's book");
		book3.setStudent(student2);
		
		book4.setId(104);
		book4.setName("No body's book");
		
		student1.getBookList().add(book1);
		// student1.getBookList().set(0,null) ---> bu komut ile student1 objesinin bir üstteki book1 ile bağlantısını kaldırmış olduk
		// student1 in 1.kitabına null atadığımız için student1 in 1.kitabı boşa düşüyor ve orphan.remove olduğu zman boşa düşen kitabı da tablodan da silinir.
		// ancak oprhan.remove değilde cascadeType.remove olsaydı bağlantıyı koparır ama 1.kitab kaydını silmez.
		student1.getBookList().add(book2);
		student1.getBookList().add(book4);  // book tarafında book4.setStudent() fonksiyonu 
		//									set edilmediği için tabloda student1 öğrencisine book4 set edilmeyecek ancak 
		//									her seferinde set etmek istemiyorsam "CascadeType.ALL" kullanmam gerekir
		
		student2.getBookList().add(book3);
		
		
		
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student04.class).addAnnotatedClass(Book04.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(student1);
		session.save(student2);


		// cascadeType.ALL  yapıldığı için aşağıdaki book sınıflarını kaydetmek için 
		// kod yazmaya gerek kalmadı, bunu hibernate otomatik olarak kendisi yapıyor
		
//		session.save(book1);   
//		session.save(book2);
//		session.save(book3);
//		session.save(book4);
		
		tx.commit();
		
		
		
		session.close();
		sf.close();
		

	}

}
