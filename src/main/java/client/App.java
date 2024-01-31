package client;

import entity.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {

	public static void main(String[] args) {
		Employee em=new Employee();
//		em.setId(0);
		em.setName("Kapil");
		em.setGender("Female");
		em.setSalary(30000);
		
		StandardServiceRegistry ssr= new StandardServiceRegistryBuilder().configure("hibernate12.cfg.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		
		SessionFactory sf=meta.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();	
		
		session.save(em);
		tx.commit();
	}

}
