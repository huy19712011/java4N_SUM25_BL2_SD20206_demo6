package org.example.demo6;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MvcDemoServlet", value = "/MvcDemoServlet")
public class MvcDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // add data
        String[] students = {"Student 1", "Student 2", "Student 3"};
        request.setAttribute("student_list", students);

        // get request dispatcher
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/view_students.jsp");

        // forward request to JSP
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}