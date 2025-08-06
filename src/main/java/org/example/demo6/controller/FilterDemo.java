package org.example.demo6.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "FilterDemo", urlPatterns = "/filterInput")
public class FilterDemo implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException, IOException {

        String username = request.getParameter("name");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();

        if (username.equals("user") & password.equals("123")) {
            chain.doFilter(request, response);
        } else {

            out.println("Invalid username or password");


        }


    }
}