package com.emphub.controller;

import com.emphub.model.Employee;
import com.emphub.service.AttendanceService;
import com.emphub.service.EmployeeService;
import com.emphub.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
    public String dashboard() {

        return "admin-dashboard";
    }

    @GetMapping("/employee/list")
    public String viewEmployees(Model model) {

        model.addAttribute("employees", employeeService.getAll());
        return "employee-list";
    }

    @GetMapping("/employee/view")
    public String view(@RequestParam("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getById(id));
        return "employee-view";
    }

    @GetMapping("/employee/add")
    public String add() {
        return "employee-form";
    }

    @GetMapping("/employee/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getById(id));
        model.addAttribute("mode", "edit");
        return "employee-form";
    }

    @PostMapping("/employee/save")
    public String saveOrUpdate(@RequestParam(value = "id", required = false) Integer id,
                       @RequestParam("name") String name,
                       @RequestParam("username") String username,
                       @RequestParam("email") String email,
                       @RequestParam("department") String department,
                       @RequestParam("designation") String designation,
                       @RequestParam("joinDate") String joinDate, Model model) {

        Employee e = new Employee();
        e.setName(name);
        e.setEmail(email);
        e.setUsername(username);
        e.setDepartment(department);
        e.setDesignation(designation);
        e.setJoinDate(LocalDate.parse(joinDate));

        boolean success;

        if (id == null || id == 0) {
            success = employeeService.save(e);
        } else {
            e.setId(id);
            success = employeeService.update(e);
        }

        if (!success) {
            model.addAttribute("employee", e);
            model.addAttribute("mode", "edit");
            model.addAttribute("error", "Username is not available!");
            return "employee-form";
        }

        return "redirect:/admin/employee/list";
    }

    @GetMapping("/employee/delete")
    public String delete(@RequestParam("id") int id) {
        employeeService.delete(id);
        return "redirect:/admin/employee/list";
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

