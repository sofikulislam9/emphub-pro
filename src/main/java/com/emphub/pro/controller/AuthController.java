package com.emphub.pro.controller;

import com.emphub.pro.model.User;
import com.emphub.pro.service.AuthService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model
    ) {
        User user = authService.login(username, password);

        if (user == null) {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }

        session.setAttribute("loggedUser", user);
        session.setAttribute("role", user.getRole());

        if ("ADMIN".equals(user.getRole())) {
            return "redirect:/admin/dashboard";
        } else {
            return "redirect:/employee/dashboard";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}
