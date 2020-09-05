package com.example.project1firebase;

public class Employee {
    private int Id;
    private String Name;
    private String Desgination;
    private int Salary;

    public Employee(){}

    public Employee(int id, String name, String desgination, int salary) {
        Id = id;
        Name = name;
        Desgination = desgination;
        Salary = salary;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesgination() {
        return Desgination;
    }

    public void setDesgination(String desgination) {
        Desgination = desgination;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
}
