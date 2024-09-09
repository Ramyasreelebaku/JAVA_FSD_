package com.hexaware.hibernate.com.hexaware.hibernate1;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/*public class App {
	public static void main(String[] args) {

		SessionFactory fac = new Configuration().configure("hiber.cfg.xml").addAnnotatedClass(Book.class)
				.buildSessionFactory();

		Session ses = fac.openSession();

		Transaction tx = ses.beginTransaction();

		Book b = new Book();
		b.setBno(102);
		b.setName("java");
		b.setPrice(3000.9);

		ses.save(b);
		tx.commit();

		System.out.println("Welcome");

	}
}*/

public class App {
	SessionFactory fac;
	Session ses;
	Transaction tx;
	Scanner sc = new Scanner(System.in);

	App() {
		fac = new Configuration().configure("hiber.cfg.xml").addAnnotatedClass(Book.class).buildSessionFactory();

		ses = fac.openSession();

	}

	void insertBook() {
		tx = ses.beginTransaction();

		Book b = new Book();
		b.setName("React js");
		b.setPrice(4000.9);

		ses.save(b);
		tx.commit();
	}

	void RemoveByBNo() {
		System.out.println("enter book id: ");
		int bn = sc.nextInt();
		tx = ses.beginTransaction();
		Book b = ses.find(Book.class, bn);
		if (b != null) {
			ses.delete(b);
			tx.commit();

		} else {
			System.out.println("Not Found");
		}

	}

	void UpdateBkPriceByBNo() {
		System.out.println("enter book id to update price: ");
		int bn = sc.nextInt();
		System.out.println("enter price: ");
		Double pn = sc.nextDouble();
		tx = ses.beginTransaction();

		Book b = ses.find(Book.class, bn);
		if (b != null) {

			b.setPrice(pn);
			ses.update(b);
			tx.commit();

		} else {
			System.out.println("Not Found");
		}

	}

	void searchById() {
		System.out.println("enter book id to search: ");
		int bn = sc.nextInt();
		tx = ses.beginTransaction();

		Book b = ses.find(Book.class, bn);
		if (b != null) {

			System.out.println(b.toString());

		} else {
			System.out.println("Not Found");
		}
	}

	void showAll() {

		tx = ses.beginTransaction();

		Query q = ses.createQuery("from Book ");
		List<Book> books = q.list();

		for (Book b : books) {
			System.out.println(b.toString());

		}

	}

	void showData() {
		tx = ses.beginTransaction();
		String hql = "from Book B where B.price>:p and B.Name=:nm ";
		Query q = ses.createQuery(hql, Book.class);
		q.setParameter("p", 100.0);
		q.setParameter("nm", "React");
		List<Book> books = q.list();

		System.out.println(books);

	}

	public static void main(String[] args) {

		App app = new App();
		app.showData();

		System.out.println("Welcome");

	}
}