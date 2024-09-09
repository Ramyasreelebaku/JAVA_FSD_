package com.hexaware.demo3;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bank {
	
	@Id
	int AccNo;
	String Name;
	Double Balance;
	String email;
	public int getAccNo() {
		return AccNo;
	}
	public void setAccNo(int accNo) {
		AccNo = accNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Double getBalance() {
		return Balance;
	}
	public void setBalance(Double balance) {
		Balance = balance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Bank [AccNo=" + AccNo + ", Name=" + Name + ", Balance=" + Balance + ", email=" + email + "]";
	}
	
	

}
