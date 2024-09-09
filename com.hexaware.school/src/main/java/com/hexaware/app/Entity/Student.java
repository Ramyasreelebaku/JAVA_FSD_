package com.hexaware.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Student {
	@Id
	int Roll;

	@NotEmpty
	String name;
	Double fee;
	@Min(value = 18, message = "age should not be less than 18 ")
	@Max(value = 60, message = "age should be greater than 60")
	int age;
	@Email
	String email;
    @Size(min=4, max=5)
	String address;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Student(int roll, @NotEmpty String name, Double fee,
			@Min(value = 18, message = "age should not be less than 18 ") @Max(value = 60, message = "age should be greater than 60") int age,
			@Email String email, String address) {
		super();
		Roll = roll;
		name = name;
		this.fee = fee;
		this.age = age;
		this.email = email;
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRoll() {
		return Roll;
	}

	public void setRoll(int roll) {
		Roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Student [Roll=" + Roll + ", Name=" + name + ", fee=" + fee + ", age=" + age + ", email=" + email
				+ ", address=" + address + "]";
	}

}
