package com.hexaware.hibernate.com.hexaware.hibernate3;
import javax.persistence.*;

@Entity
public class Certificate {
    @Id
    @GeneratedValue()
    private int id;

    private String courseName;

    @OneToOne
    @JoinColumn(name = "roll")  
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

