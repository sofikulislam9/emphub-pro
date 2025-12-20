package com.emphub.pro.controller;

import com.emphub.pro.service.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/checkin")
    public String checkIn(@RequestParam("employeeId") int employeeId ) {
        attendanceService.checkIn(employeeId);
        return "redirect:/attendance/" + employeeId;
    }

    @PostMapping("/checkout")
    public String checkOut(@RequestParam("employeeId") int employeeId) {
        attendanceService.checkOut(employeeId);
        return  "redirect:/attendance/" + employeeId;
    }

    @GetMapping("/{employeeId}")
    public String view(@PathVariable("employeeId") int employeeId, Model model) {
        model.addAttribute("records",
                attendanceService.getAttendance(employeeId));
        model.addAttribute("employeeId", employeeId);
        return "attendance";
    }

}
