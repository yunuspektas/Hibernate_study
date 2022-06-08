package com.hb04.onetomany;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04 {

	public static void main(String[] args) {
		
		Student04 student1 = new Student04();
		Book04 book1 = new Book04();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student04.class).addAnnotatedClass(Book04.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		// -----> SORU01 : Id si verilen bir ögrencinin kitaplarını get metodu ile alalım
		
//		student1 = session.get(Student04.class, 1001);
//		for (Book04 book : student1.getBookList()) {
//			
//			System.out.println(book);
//		}
		
	// not:"hibernate.cfg.xml" dosyasında , <property name="hbm2ddl.auto">update</property>    kısmı "update" 
		//halinde iken önce RunnerSave04 sınıfını run edip daha sonra RunnerFetch04 sınıfını çalşıştırılınca 
		//uygulama düzgün çalışıyor, ancak update değilde create ise uyguylama düzgün çalışmıyor çünkü 
		//RunnerSave04 sınıfın ırun da etseniz uygulama bitince tablolar sıfırlanacağı için RunnerFetch04 
		//sınıfını çalıştırfıgınızda student01 boş geliyor.	
		
		// -----> SORU02 : Id si verilen bir kitabın sahibinin ismini get metodu ile getirelim
		
//		book1 = session.get(Book04.class, 101);
//		System.out.println(book1.getStudent().getName()); // book1.getStudent() geri dönüş olarak Student04 objesi döndürüyor
		
		// -----> SORU03 : 
		
//		String sqlQuery = "SELECT std_name FROM Student04 WHERE id=1001  ";
//		List<Object []> resultList = session.createSQLQuery(sqlQuery).getResultList();
//		for (Object[] r : resultList) {
//			System.out.println(Arrays.toString(r));
//		}
		
		// ----> SQL kullanarak INNER JOIN yazalım
		
//		String sqlQuery1 = "SELECT s.std_name,b.name FROM Student04 s INNER JOIN Book04 b ON s.id=b.student_id";
//		List<Object []> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
//		for (Object[] r : resultList1) {
//			System.out.println(Arrays.toString(r));
//		}
		
		// ---> Yukardaki SQL sorgusunun aynısını HQL ile yazalım
		
//		String hqlQuery1 = "SELECT s.name, b.name FROM Student04 s inner join Fetch Book04 b on s.id=b.student";
//		// yukardaki kodda dikkat edilecekler : HQL yazdığımız için sınıf içindeki değişken isimleri kullanılıor. 
//		//yani; s.std;_name değil s.name olur , b.student_id değil b.student olacak
//		List<Object []> resultList2 = session.createQuery(hqlQuery1).getResultList();
//		for (Object[] r : resultList2) {
//			System.out.println(Arrays.toString(r));
//		}
		
		
		// ----> Right Join ile HQL yazılımı
		
//		String hqlQuery2 = "SELECT s.name, b.name FROM Student04 s right join Fetch Book04 b on s.id=b.student";
//
//		List<Object []> resultList3 = session.createQuery(hqlQuery2).getResultList();
//		for (Object[] r : resultList3) {
//			System.out.println(Arrays.toString(r));
//		}
		
		// ---> SQL İLE TÜM KAYITLARIN SİLİNMESİ
		
//		String sqlQuery3 = "DELETE from book04";
//		int numOfRec1 = session.createSQLQuery(sqlQuery3).executeUpdate(); // executeUpdate etkilenen kayıtların sayısını dönüyor
//		System.out.println("Effected row count : " + numOfRec1);
//		
		// ---> HQL İLE TÜM KAYITLARIN SİLİNMESİ
		
//		String hqlQuery4 = "DELETE from Book04";
//		int numOfRec2 = session.createQuery(hqlQuery4).executeUpdate(); // executeUpdate etkilenen kayıtların sayısını dönüyor
//		System.out.println("Effected row count : " + numOfRec2);
		
		// ----> id si verilen bir öğrenci kaydını HQL ile silme
		
		// Eğer silinmek istenen öğrencinin bir kitabı var ise
		// Yani Book tablosundaki student_id kolonunda bu öğrenci id ile ilgili bir kayıt var ise
		//student_id kolonu foreign key olduğu için student silme işlemi yapılamıyacaktır.
		
//		String hqlQuery5 = " DELETE Student04 s WHERE s.id=1002";
//		int numOfRec3 = session.createQuery(hqlQuery5).executeUpdate();
//		System.out.println("Effected row count : " + numOfRec3);
		
		// ---> YUKARDAKİ SİLME İŞLEMİNİ GET.DELETE METODU İLE YAPALIM
		
//		book1= session.get(Book04.class, 103);
//		session.delete(book1);
		
		// DİKKAT : kitabı olan bir öğrenciyi silmek problemli: silmek istersek önce bağlı olduğu 
		//kitap silinir daha sonrailgili öğrenci silinebilir, bunu aşmaın yolu orphanRemoval propertise ı 
		//true olarak set etmek , Student04.java da 28. satırda yapılıyor 
		
		// her book un studentını setStudent metodu ile set etmek istemiyorsam @  annotationını eklerim
		
		
		
		
		
		
		session.close();
		sf.close();
		

	}

}
