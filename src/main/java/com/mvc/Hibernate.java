package com.mvc;

import java.io.IOException;
import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Hibernate {

	public static void saveSlika(Slika slika) {
		Session session = openSession();
		session.beginTransaction();
		
		session.persist(slika);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public static Slika getSlika(int id) {
		Session session = openSession();
		Slika slika = (Slika) session.get(Slika.class, id);
		session.close();
		
		return slika;
	}
	
	public static byte[] getFajl(int id) throws SQLException, IOException {
		Session session = openSession();
		Query q = session.createQuery("Select file from Slika where id = " + id);
		byte[] file = (byte[]) q.uniqueResult();
		
		session.close();
		
		return file;
	}
	
	public static Session openSession() {
		Configuration config = new Configuration().configure().addAnnotatedClass(Slika.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(reg);
		return factory.openSession();
	}
	
}
