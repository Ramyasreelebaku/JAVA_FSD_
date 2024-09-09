package com.hexaware.hibernate.com.hexaware.hibernate3;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue()
    private int roll;

    private String name;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Certificate cer;
    
    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Certificate getCer() {
        return cer;
    }

    public void setCer(Certificate cer) {
        this.cer = cer;
    }
}



