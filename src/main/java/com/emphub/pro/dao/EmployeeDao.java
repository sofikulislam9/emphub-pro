package com.emphub.pro.dao;

import com.emphub.pro.model.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee findByUsernameAndEmail(String username, String email);

    List<Employee> findAll();

}
