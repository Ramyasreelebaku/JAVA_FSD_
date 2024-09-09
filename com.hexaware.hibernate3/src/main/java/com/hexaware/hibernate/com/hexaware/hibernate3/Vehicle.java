package com.hexaware.hibernate.com.hexaware.hibernate3;
/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="VEHICLE")
public class Vehicle {
 
@Id
@Column(name="VEHICLE_ID")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int vehicleId;
 
@Column(name="VEHICLE_NAME")
private String vehicleName;
 
public int getVehicleId() {
	return vehicleId;
}
 
public String getVehicleName() {
	return vehicleName;
}
public void setVehicleName(String vehicleName) {
	this.vehicleName = vehicleName;
}
 
public void setVehicleId(int vehicleId) {
	this.vehicleId = vehicleId;
}
 
 
}*/

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="VEHICLE")
public class Vehicle {
 
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="VEHICLE_ID")
private int vehicleId;
 
@Column(name="VEHICLE_NAME")
private String vehicleName;
 
public int getVehicleId() {
	return vehicleId;
}
 
public String getVehicleName() {
	return vehicleName;
}
 
public void setVehicleId(int vehicleId) {
	this.vehicleId = vehicleId;
}
 
public void setVehicleName(String vehicleName) {
	this.vehicleName = vehicleName;
}
 
}*/

import javax.persistence.*;

@Entity
@Table(name="VEHICLE")
public class Vehicle {
 
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="VEHICLE_ID")
private int vehicleId;
 
@Column(name="VEHICLE_NAME")
private String vehicleName;
 
@ManyToOne
@JoinColumn(name="USER_ID")
private UserDetails user;
 
public int getVehicleId() {
	return vehicleId;
}
 
public String getVehicleName() {
	return vehicleName;
}
 
public UserDetails getUser() {
	return user;
}
 
public void setVehicleId(int vehicleId) {
	this.vehicleId = vehicleId;
}
 
public void setVehicleName(String vehicleName) {
	this.vehicleName = vehicleName;
}
 
public void setUser(UserDetails user) {
	this.user = user;
}
 
}