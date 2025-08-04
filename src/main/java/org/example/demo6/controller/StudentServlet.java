package org.example.demo6.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.demo6.entity.Student;
import org.example.demo6.service.StudentService;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = {
        "/students",
        "/students/new",
        "/students/insert",
        "/students/delete",
        "/students/edit",
        "/students/update",
        "/students/saveStudent"
})
public class StudentServlet extends HttpServlet {

    private StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        switch (path) {
            case "/students":
                listStudents(request, response);
                break;
            case "/students/new":
                showNewForm(request, response);
                break;
            case "/students/insert":
                insertStudent(request, response);
                break;
            case "/students/delete":
                deleteStudent(request, response);
                break;
            case "/students/edit":
                editStudent(request, response);
                break;
            case "/students/update":
                updateStudent(request, response);
                break;
            case "/students/saveStudent":
                saveStudent(request, response);
                break;
        }
    }

    private void saveStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //Student student = getStudentFromForm(request);
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Student student = new Student(id, name, email, phone);
        service.addStudent(student);

        JSONObject json = new JSONObject();
        json.put("id", student.getId());
        json.put("name", student.getName());
        json.put("email", student.getEmail());
        json.put("phone", student.getPhone());

        response.setContentType("application/json");
        response.getWriter().write(json.toString());


    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // read student from form
        Student student = getStudentFromForm(request);

        // update to DB
        service.updateStudent(student);

        // redirect to list students
        response.sendRedirect("/students");
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // load student to form
        // get student by id
        Long id = Long.parseLong(request.getParameter("id"));
        Student student = service.getStudentById(id);

        // forward student to jsp
        request.setAttribute("student", student);
        request.getRequestDispatcher("/views/updateStudentForm.jsp")
                .forward(request, response);

    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        service.deleteStudent(id);

        response.sendRedirect("/students");

    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // read data from form
        Student student = getStudentFromForm(request);

        // save data to DB
        service.addStudent(student);

        // redirect to list students
        response.sendRedirect("/students");
    }

    private Student getStudentFromForm(HttpServletRequest request) {

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        return new Student(id, name, email, phone);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/views/addStudentForm.jsp")
                .forward(request, response);
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // data: students from DB
        List<Student> students = new ArrayList<>();
        students = service.getStudents();

        // data => studentList.jsp
        request.setAttribute("students", students);
        request.getRequestDispatcher("/views/studentList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}