package org.example.demo6;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        out.println("The Student is: " + request.getParameter("firstName") + " " + request.getParameter("lastName"));

        String[] favoriteLanguages = request.getParameterValues("favoriteLanguage");
        out.println("<br>");
        out.println("Favorite Languages:");
        out.println("<br>");
        for (var lang : favoriteLanguages) {

            out.println(lang);
            out.println("<br>");
        }

        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}