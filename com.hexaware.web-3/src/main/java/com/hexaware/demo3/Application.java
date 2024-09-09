package com.hexaware.demo3;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		BankRepository rep = context.getBean(BankRepository.class);
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1.....open an account");
			System.out.println("2.....deposit the amount");
			System.out.println("3.....withdraw amount");
			System.out.println("4.....search by account number");
			System.out.println("5.....transfer amount");
			System.out.println("6.....close account");
			System.out.println("7.....exit");

			int ch = sc.nextInt();
			sc.nextLine();

			switch (ch) {
			case 1:
				openAccount(sc, rep);
				break;
			case 2:
				deposit(sc, rep);

				break;
			case 3:
				withdraw(sc, rep);

				break;
			case 4:
				searchAccount(sc, rep);

				break;
			case 5:
				transferAmount(sc, rep);

				break;
			case 6:
				closeAccount(sc, rep);

				break;
			case 7:
				System.out.println("Exiting.....");
				sc.close();
				return;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}
	}

	public static void openAccount(Scanner sc, BankRepository rep) {
		Bank b = new Bank();
		System.out.println("enter AccNo:");
		int accno = sc.nextInt();
		sc.nextLine();
		b.setAccNo(accno);

		System.out.println("enter name:");
		String name = sc.nextLine();
		b.setName(name);

		System.out.println("enter balance:");
		double bal = sc.nextDouble();
		sc.nextLine();
		b.setBalance(bal);

		System.out.println("enter email:");
		String email = sc.nextLine();
		b.setEmail(email);

		if (b.getBalance() >= 1000) {
			rep.save(b);
			System.out.println("Account opened successfully");
		} else {
			System.out.println("Insufficient balance to open account");
		}
	}

	private static void deposit(Scanner sc, BankRepository rep) {
		// TODO Auto-generated method stub
		System.out.println("enter account id:");
		int accno = sc.nextInt();

		Optional<Bank> bank = rep.findById(accno);

		if (bank.isPresent()) {

			Bank bank1 = bank.get();
			System.out.println("enter the amount you want to deposit:");
			Double amount = sc.nextDouble();
			if (amount > 0) {
				Double newbal = amount + bank1.getBalance();
				bank1.setBalance(newbal);
				rep.save(bank1);
				System.out.println("deposit succesfull");
			} else {
				System.out.println("amount must be positive");
			}

		} else {
			System.out.println("account not found");
		}

	}

	private static void withdraw(Scanner sc, BankRepository rep) {
		// TODO Auto-generated method stub
		System.out.println("enter account id:");
		int accno = sc.nextInt();

		Optional<Bank> bank = rep.findById(accno);

		if (bank.isPresent()) {

			Bank bank1 = bank.get();
			System.out.println("enter the amount you want to withdraw:");
			Double amount = sc.nextDouble();
			if (amount > 0) {
				Double newbal = bank1.getBalance() - amount;
				bank1.setBalance(newbal);
				rep.save(bank1);
				System.out.println("withdraw succesfull");
			} else {
				System.out.println("amount must be positive");
			}

		} else {
			System.out.println("account not found");
		}

	}

	private static void searchAccount(Scanner sc, BankRepository rep) {
		// TODO Auto-generated method stub
		System.out.println("enter account id:");
		int accno = sc.nextInt();

		Optional<Bank> bank = rep.findById(accno);

		if (bank.isPresent()) {
			Iterable<Bank> b = rep.findAll();
			b.forEach((temp) -> System.out.println(temp.toString()));
		} else {
			System.out.println("account not found");
		}

	}

	private static void transferAmount(Scanner sc, BankRepository rep) {
		// TODO Auto-generated method stub
		System.out.println("enter sender's account no:");
		int s = sc.nextInt();
		System.out.println("enter receiver's account no:");
		int r = sc.nextInt();

		Optional<Bank> bank1 = rep.findById(s);
		Optional<Bank> bank2 = rep.findById(r);

		if (bank1.isPresent() && bank2.isPresent()) {
			Bank b1 = bank1.get();
			Bank b2 = bank2.get();
			System.out.println("enter the amount you want  to transfer");
			Double amt = sc.nextDouble();
			if (b1.getBalance() >= amt) {
				Double sendernewbal = b1.getBalance() - amt;
				b1.setBalance(sendernewbal);
				Double receivernewbal = b2.getBalance() + amt;
				b2.setBalance(receivernewbal);
				rep.save(b1);
				rep.save(b2);
				System.out.println("transfer successful");

			} else {
				System.out.println("insufficient balance in senders account");
			}
		} else {
			System.out.println("either sender's or receiver's account id is not found");
		}
	}

	private static void closeAccount(Scanner sc, BankRepository rep) {
		// TODO Auto-generated method stub
		System.out.println("enter the account no to close:");
		int accno = sc.nextInt();
		Optional<Bank> bank = rep.findById(accno);

		if (bank.isPresent()) {
			rep.deleteById(accno);
			System.out.println("account closed");

		} else {
			System.out.println("account not found");
		}
	}

}
