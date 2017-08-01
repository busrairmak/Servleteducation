package com.mebitech.Servleteducation.conrtoller;

import com.mebitech.Servleteducation.domain.Student;
import com.mebitech.Servleteducation.service.StudentService;
import com.mebitech.Servleteducation.service.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/student")
public class StudentController extends HttpServlet {
    private StudentService studentService;

    public StudentController() {
        studentService = new StudentServiceImpl();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

    {
        String operation = request.getParameter("operation");

        if (operation == null) {
            operation = "";
        }
        switch (operation) {
            case "add":
                createStudent(request, response);
                break;
            case "delete":
                removeStudent(request, response);
                break;
            case "edit":
                editStudent(request, response);
                break;
            case "update":
                updateStudent(request, response);
                break;
            default:
                listStudent(request, response);
                break;
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id=Long.parseLong(request.getParameter("id"));
        String name=request.getParameter("name");
        Integer no=Integer.parseInt(request.getParameter("no"));
        studentService.updateStudent(new Student(id,name,no));
        response.sendRedirect("student");


    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Student student = studentService.getStudent(id);
        request.setAttribute("student", student);

        List<Student> list = studentService.getAll();
        request.setAttribute("list", list);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Student.jsp");
        requestDispatcher.forward(request, response);

    }

    private void removeStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        studentService.removeStudent(id);
        response.sendRedirect("student");

    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = studentService.getAll();
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Student.jsp");
        requestDispatcher.forward(request, response);


    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Integer no = Integer.parseInt(request.getParameter("no"));
        studentService.createStudent(new Student(name, no));
        response.sendRedirect("student");

    }

}
