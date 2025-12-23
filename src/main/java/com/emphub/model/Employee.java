package com.emphub.model;

import java.time.LocalDate;

public class Employee {

    private int id;
    private String name;
    private String username;
    private String email;
    private String department;
    private String designation;
    private LocalDate joinDate;

    public Employee() {
    }

    public Employee(int id, String name, String username, String email, String department, String designation, LocalDate joinDate) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.joinDate = joinDate;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
}

