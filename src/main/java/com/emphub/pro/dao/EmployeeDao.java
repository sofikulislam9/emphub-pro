package com.emphub.pro.dao;

import com.emphub.pro.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void save(Employee emp);
    List<Employee> findAll();

}
