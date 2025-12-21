package com.emphub.pro.controller;

import com.emphub.pro.service.AttendanceService;
import com.emphub.pro.service.EmployeeService;
import com.emphub.pro.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LeaveService leaveService;

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/dashboard")
    public String dashboard( Model model) {

        return "admin-dashboard";
    }

    @GetMapping("/employees")
    public String viewEmployees(Model model) {

        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee-list";
    }

    @GetMapping("/leaves")
    public String viewLeaves(Model model) {
        model.addAttribute("leaves", leaveService.getAllLeaves());
        return "leave-list";
    }

    @PostMapping("/leaves/approve")
    public String approve(@RequestParam("id") int id) {
        leaveService.updateStatus(id, "APPROVED");
        return "redirect:/admin/leaves";
    }

    @PostMapping("/leaves/reject")
    public String reject(@RequestParam("id") int id) {
        leaveService.updateStatus(id, "REJECTED");
        return "redirect:/admin/leaves";
    }

    @GetMapping("/attendance")
    public String viewAllAttendance(Model model) {

        model.addAttribute(
                "attendanceList",
                attendanceService.allAttendance()
        );
        return "admin-attendance";
    }
}

