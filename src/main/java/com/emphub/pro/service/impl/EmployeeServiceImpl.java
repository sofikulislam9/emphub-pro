package com.emphub.pro.service.impl;

import com.emphub.pro.dao.EmployeeDao;
import com.emphub.pro.model.Employee;
import com.emphub.pro.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee login(String username, String email) {
        return employeeDao.findByUsernameAndEmail(username, email);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }
}
