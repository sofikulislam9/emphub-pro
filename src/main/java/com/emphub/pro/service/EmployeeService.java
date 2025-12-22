package com.emphub.pro.service;

import com.emphub.pro.model.Employee;

import java.util.List;


public interface EmployeeService {

    Employee login(String username, String email);

    List<Employee> getAll();

    Employee getById(int id);

    boolean save(Employee employee);

    boolean update(Employee employee);

    void delete(int id);

}
