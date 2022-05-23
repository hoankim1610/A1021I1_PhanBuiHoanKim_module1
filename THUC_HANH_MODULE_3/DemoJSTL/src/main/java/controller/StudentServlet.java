package controller;

import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                create(request, response);
                break;
//            case "update":
//                update(request, response);
//                break;
            case "list":
            default:
                showList(request, response);
        }
    }

    private void create (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthdayAsString = request.getParameter("birthday");
        String sexAsString = request.getParameter("sex");

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date birthday = null;
        try {
            birthday = format.parse(birthdayAsString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean sex = "Name".equals(sexAsString);
        StudentService studentService = new StudentServiceImpl();
        studentService.create(new Student(id, name, birthday, sex));
        response.sendRedirect("student?action=list_jstl");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "List";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "update":
                break;
            case "view":
                break;
            case "delete":
                break;
            case "list":
            default:
                showList(request, response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentService.findAll();
        request.setAttribute("list", studentList);
        request.getRequestDispatcher("/student/list_jstl.jsp").forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/student/create.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getParameter("id");
        studentService.delete("id");
        response.sendRedirect("student?action=list_jstl");
    }
}
