package com.emphub.pro.controller;

import com.emphub.pro.model.LeaveRequest;
import com.emphub.pro.model.User;
import com.emphub.pro.service.LeaveService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping
    public String myLeaves(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedUser");
        model.addAttribute("leaves",
                leaveService.getEmployeeLeaves(user.getId()));
        return "leave";
    }

    @PostMapping("/apply")
    public String apply(@RequestParam("fromDate") String fromDate,
                        @RequestParam("toDate") String toDate,
                        @RequestParam("reason") String reason,
                        HttpSession session) {

        User user = (User) session.getAttribute("loggedUser");

        LeaveRequest l = new LeaveRequest();
        l.setEmployeeId(user.getId());
        l.setFromDate(LocalDate.parse(fromDate));
        l.setToDate(LocalDate.parse(toDate));
        l.setReason(reason);

        leaveService.applyLeave(l);
        return "redirect:/leave";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("leaves", leaveService.getAllLeaves());
        return "leave-admin";
    }

    @PostMapping("/update")
    public String update(@RequestParam int leaveId,
                         @RequestParam String status) {

        leaveService.updateLeaveStatus(leaveId, status);
        return "redirect:/leave/admin";
    }

}
