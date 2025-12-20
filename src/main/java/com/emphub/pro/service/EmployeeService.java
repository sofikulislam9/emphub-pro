package com.emphub.pro.service;

import com.emphub.pro.model.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee emp);
    List<Employee> getAllEmployees();
}
