package pl.workshop3.controller;

import pl.workshop3.dao.UserDao;
import pl.workshop3.model.Excercise;
import pl.workshop3.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/allusers")
public class AllUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User[] users = UserDao.loadAllUsers();

        request.setAttribute("users", users);

        getServletContext().getRequestDispatcher("/allusers.jsp")
                .forward(request, response);

    }
}