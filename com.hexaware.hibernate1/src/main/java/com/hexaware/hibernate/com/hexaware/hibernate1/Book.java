package com.hexaware.hibernate.com.hexaware.hibernate1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ITBook")
public class Book {
	@Id
	@GeneratedValue
	long Bno;
	@Column
	String Name;
	@Column
	Double price;
	@Transient
	int qty;
	public long getBno() {
		return Bno;
	}
	public void setBno(int bno) {
		Bno = bno;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [Bno=" + Bno + ", Name=" + Name + ", price=" + price + "]";
	}
	

}
