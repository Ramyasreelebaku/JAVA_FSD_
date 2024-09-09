package com.hexaware.hibernate.com.hexaware.hibernate3;

import javax.persistence.Embeddable;

@Embeddable
class Result {
    private int marks;
    private String sub;

    // Getters and Setters
    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }
}