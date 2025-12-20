package com.emphub.pro.controller;

import com.emphub.pro.model.User;
import com.emphub.pro.service.DashboardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        User user = (User) session.getAttribute("loggedUser");

        if (!"ADMIN".equals(user.getRole())) {
            return "redirect:/login";
        }

        model.addAttribute("stats",
                dashboardService.getDashboardStats());

        return "dashboard";
    }

}
