package com.example.sqlitedatabasedemo;

public class Student {
    public int id;
    public String name;
    public  String course;
    public int fees;
    public byte[] stImages;

    public Student(int id, String name, String course, int fees,byte[] stImages) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.fees = fees;
        this.stImages = stImages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }
    public byte[] getStImage() {
        return stImages;
    }

    public void setStImages(byte[] stImages) {
        this.stImages = stImages;
    }
}
