package com.emphub.pro.filter;


import com.emphub.pro.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

            HttpServletRequest req =
                    (HttpServletRequest) servletRequest;
            HttpServletResponse res =
                    (HttpServletResponse) servletResponse;

            String uri = req.getRequestURI();

            // Allow login page
            if (uri.endsWith("login") || uri.contains("css")) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }

            HttpSession session = req.getSession(false);
            User user = (session != null)
                    ? (User) session.getAttribute("loggedUser")
                    : null;

            if (user == null) {
                res.sendRedirect(req.getContextPath() + "/login");
                return;
            }

        filterChain.doFilter(servletRequest, servletResponse);
        }
    }

