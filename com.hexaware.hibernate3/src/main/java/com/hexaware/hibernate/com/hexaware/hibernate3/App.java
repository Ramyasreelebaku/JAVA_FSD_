package com.hexaware.hibernate.com.hexaware.hibernate3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
/*
 * public class App { public static void main(String[] args) { SessionFactory
 * fac = new
 * Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.
 * class) .buildSessionFactory();
 * 
 * Session ses = fac.openSession();
 * 
 * Transaction tx = ses.beginTransaction();
 * 
 * 
 * Result r = new Result(); r.setMarks(101); r.setSub("dsa");
 * 
 * Student s1 = new Student(); s1.setRoll(101); s1.setName("asha");
 * s1.setFee(5000.0); s1.setRes(r);
 * 
 * ses.save(s1);
 * 
 * tx.commit(); ses.close(); } }
 */

/*public class App {
	public static void main(String[] args) {
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Certificate.class)
				.buildSessionFactory();

		Session ses = fac.openSession();

		Transaction tx = ses.beginTransaction();

		Student s1 = new Student();
		s1.setName("Asha");
		Certificate cert = new Certificate();
		cert.setCourseName("Java");
		cert.setStudent(s1);
		s1.setCer(cert);

		ses.save(s1);

		tx.commit();
		ses.close();
	}
}*/

/*public class App {
	 
	public static void main(String[] args) {
		UserDetails user = new UserDetails(); //create the user entity
		Vehicle vehicle = new Vehicle(); //create the vehicle entity
 
		vehicle.setVehicleName("BMW Car"); //set vehicle name
 
		user.setUserName("Dinesh Rajput"); //set the user name
		user.setVehicle(vehicle); //set the vehicle entity to the field of the user entity i.e. vehicle entity inside the user entity
 
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); //create session factory object
		Session session = sessionFactory.openSession(); //create the session object
		session.beginTransaction();//create the transaction from the session object
 
		session.save(vehicle); // save the vehicle entity to the database
		session.save(user); // save the user entity to the database
 
		session.getTransaction().commit(); //close the transaction
		session.close(); //close the session
 
	}
 
}*/

/*public class App {
	 
	public static void main(String[] args) {
		UserDetails user = new UserDetails(); 
 
		Vehicle vehicle = new Vehicle(); 
		Vehicle vehicle2 = new Vehicle(); 
 
		vehicle.setVehicleName("BMW Car"); 
		vehicle2.setVehicleName("AUDI Car");
 
		user.setUserName("Dinesh Rajput"); 
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction(); 
 
		session.save(vehicle);
		session.save(vehicle2);
		session.save(user); 
 
		session.getTransaction().commit();
		session.close();
 
	}
 
}*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class App {
 
	public static void main(String[] args) {
		UserDetails user = new UserDetails(); //create an user entity
 
		Vehicle vehicle = new Vehicle(); //create a vehicle entity
		Vehicle vehicle2 = new Vehicle(); //create second vehicle entity
 
		vehicle.setVehicleName("BMW Car"); //set BMW car
		vehicle.setUser(user); //set user for that car
 
		vehicle2.setVehicleName("AUDI Car"); //set second car Audi
		vehicle2.setUser(user);//set user for that car
 
		user.setUserName("Dinesh Rajput"); //set user property
 
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); //create the session factory object
		Session session = sessionFactory.openSession(); //create the session object
		session.beginTransaction(); //create the transaction object
		session.save(vehicle);
		session.save(vehicle2);
		session.save(user);
		session.getTransaction().commit();
		session.close();
 
	}
 
}
