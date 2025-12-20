package com.emphub.pro.controller;

import com.emphub.pro.model.Employee;
import com.emphub.pro.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String getEmployees(Model model) {

        model.addAttribute("employee", employeeService.getAllEmployees());

        return "employee";
    }

    @PostMapping("/add")
    public String add(@RequestParam("name") String name,
                      @RequestParam("email") String email,
                      @RequestParam("department") String department,
                      @RequestParam("designation") String designation) {

        Employee emp = new Employee();

        emp.setName(name);
        emp.setEmail(email);
        emp.setDepartment(department);
        emp.setDesignation(designation);
        emp.setJoinDate(LocalDate.now());
        emp.setStatus("ACTIVE");

        employeeService.addEmployee(emp);

        return "redirect:/employee";

    }

}
