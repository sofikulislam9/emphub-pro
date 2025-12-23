package com.emphub.controller;

import com.emphub.model.Admin;
import com.emphub.model.Employee;
import com.emphub.service.AdminService;
import com.emphub.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "admin-login";
    }

    @GetMapping("/admin/logout")
    public String adminLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }

    @PostMapping("/admin/login")
    public String adminLogin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             HttpSession session,
                             Model model) {

        Admin admin = adminService.login(username, password);

        if (admin != null) {
            session.setAttribute("admin", admin);
            return "redirect:/admin/dashboard";
        }

        model.addAttribute("error", "Invalid admin credentials");
        return "admin-login";
    }

    @GetMapping("/employee/login")
    public String employeeLoginPage() {
        return "employee-login";
    }

    @GetMapping("/employee/logout")
    public String employeeLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/employee/login";
    }


    @PostMapping("/employee/login")
    public String employeeLogin(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                HttpSession session,
                                Model model) {

        Employee employee = employeeService.login(username, password);

        if (employee != null) {
            session.setAttribute("employee", employee);
            return "redirect:/employee/dashboard";
        }

        model.addAttribute("error", "Invalid employee credentials");
        return "employee-login";
    }

}
