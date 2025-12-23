package com.emphub.controller;

import com.emphub.model.Employee;
import com.emphub.model.LeaveRequest;
import com.emphub.service.AttendanceService;
import com.emphub.service.EmployeeService;
import com.emphub.service.LeaveService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LeaveService leaveService;

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/dashboard")
    public String dashboard() {

        return "employee-dashboard";
    }

    @GetMapping("/profile")
    public String viewEmployees(Model model) {

        model.addAttribute("employees", employeeService.getAll());
        return "employee-profile";
    }

    @GetMapping("/leave")
    public String viewLeaveRequest(HttpSession session, Model model) {

        Employee employee = (Employee) session.getAttribute("employee");

        model.addAttribute("myLeaves",
                leaveService.getEmployeeLeaves(employee.getId()));

        return "employee-leave";
    }

    @GetMapping("/leave/apply")
    public String applyLeavePage(HttpSession session, Model model) {

        Employee employee = (Employee) session.getAttribute("employee");

        if (leaveService.hasPendingLeave(employee.getId())) {
            model.addAttribute("error", "You already have a pending leave request." +
                    " Please wait until it is approved or rejected.");

            model.addAttribute("myLeaves",
                    leaveService.getEmployeeLeaves(employee.getId()));

           return "employee-leave";
        }

        return "apply-leave";
    }

    @PostMapping("/leave/apply-page")
    public String applyLeave(
            @RequestParam("fromDate") String fromDate,
            @RequestParam("toDate")String toDate,
            @RequestParam("reason")String reason,
            HttpSession session, RedirectAttributes ra) {

        Employee employee = (Employee) session.getAttribute("employee");

        LeaveRequest leave = new LeaveRequest();
        leave.setEmployeeId(employee.getId());
        leave.setFromDate(LocalDate.parse(fromDate));
        leave.setToDate(LocalDate.parse(toDate));
        leave.setReason(reason);

        leaveService.applyLeave(leave);

        return "redirect:/employee/leave";
    }

    @GetMapping("/attendance")
    public String attendance(){
        return "employee-attendance";
    }

    @GetMapping("/attendance/view")
    public String viewAttendance(HttpSession session, Model model) {

        Employee employee = (Employee) session.getAttribute("employee");

        model.addAttribute("attendanceList",
                attendanceService.employeeAttendance(employee.getId()));

        return "attendance-view";
    }

    @PostMapping("/attendance/checkin")
    public String checkIn(HttpSession session, RedirectAttributes ra) {

        Employee employee = (Employee) session.getAttribute("employee");

        try {
            attendanceService.checkIn(employee.getId());
            ra.addFlashAttribute("success", "Checked in successfully");

        }  catch (IllegalStateException e) {
            ra.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/employee/attendance";
    }

    @PostMapping("/attendance/checkout")
    public String checkOut(HttpSession session, RedirectAttributes ra) {

        Employee employee = (Employee) session.getAttribute("employee");

        try {
            attendanceService.checkOut(employee.getId());
            ra.addFlashAttribute("success", "Checked out successfully");
        } catch (IllegalStateException e) {
            ra.addFlashAttribute("error", e.getMessage());
        }

        return "redirect:/employee/attendance";
    }

}
