package com.hexaware.hql.com.hexaware.hql1;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App {

	SessionFactory fac;
	Session ses;
	Transaction tx;
	Scanner sc = new Scanner(System.in);

	App() {
		fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory();
		ses = fac.openSession();
	}

	void addNewItem() {
		tx = ses.beginTransaction();

		Product p = new Product();
		System.out.print("Enter product name: ");
		p.setName(sc.nextLine());
		System.out.print("Enter product price: ");
		p.setPrice(sc.nextDouble());
		sc.nextLine();

		ses.save(p);
		tx.commit();
		System.out.println("Product added successfully.");
	}

	void removeItemByCode() {
		System.out.println("Enter product id to remove: ");
		int pid = sc.nextInt();

		tx = ses.beginTransaction();
		String hql = "DELETE FROM Product WHERE pid = :pid";
		Query query = ses.createQuery(hql);
		query.setParameter("pid", pid);
		int result = query.executeUpdate();

		if (result > 0) {
			System.out.println("Product removed successfully.");
		} else {
			System.out.println("Product not found.");
		}

		tx.commit();
	}

	void updatePriceByCode() {
		System.out.print("Enter product ID to update price: ");
		int pid = sc.nextInt();
		System.out.print("Enter new price: ");
		double newPrice = sc.nextDouble();
		tx = ses.beginTransaction();

		String hql = "UPDATE Product SET price = :price WHERE pid = :pid";
		Query query = ses.createQuery(hql);
		query.setParameter("price", newPrice);
		query.setParameter("pid", pid);
		int result = query.executeUpdate();

		if (result > 0) {
			System.out.println("Price updated successfully.");
		} else {
			System.out.println("Product not found.");
		}

		tx.commit();
	}

	void calculateTotalBill() {
		System.out.print("Enter product ID to calculate bill: ");
		int pid = sc.nextInt();
		System.out.print("Enter quantity: ");
		int qty = sc.nextInt();
		tx = ses.beginTransaction();

		String hql = "FROM Product WHERE pid = :pid";
		Query<Product> query = ses.createQuery(hql, Product.class);
		query.setParameter("pid", pid);
		List<Product> products = query.list();

		if (!products.isEmpty()) {
			Product p = products.get(0);
			double totalBill = p.getPrice() * qty;
			System.out.println("Total Bill: " + totalBill);
		} else {
			System.out.println("Product not found.");
		}

		tx.commit();
	}

	public static void main(String[] args) {
		App app = new App();
		Scanner sc = new Scanner(System.in); 

		while (true) {
			System.out.println("1. Add new Item");
			System.out.println("2. Remove Item by code");
			System.out.println("3. Update Price of item by code");
			System.out.println("4. Calculate Total Bill");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				app.addNewItem();
				break;
			case 2:
				app.removeItemByCode();
				break;
			case 3:
				app.updatePriceByCode();
				break;
			case 4:
				app.calculateTotalBill();
				break;
			case 5:
				System.out.println("Exiting...");
				app.ses.close();
				app.fac.close();
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
		

	}

}
