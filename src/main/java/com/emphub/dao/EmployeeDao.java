package com.emphub.dao;

import com.emphub.model.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee findByUsernameAndEmail(String username, String email);

    List<Employee> findAll();

    Employee findById(int id);

    boolean save(Employee employee);

    boolean update(Employee employee);

    void delete(int id);

}
