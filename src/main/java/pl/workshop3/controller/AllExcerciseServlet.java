package pl.workshop3.controller;

import pl.workshop3.dao.GroupDao;
import pl.workshop3.model.Excercise;
import pl.workshop3.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/allex")
public class AllExcerciseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Excercise[] exces = Excercise.loadAllExces();

        request.setAttribute("exces", exces);

        getServletContext().getRequestDispatcher("/allex.jsp")
                .forward(request, response);

    }
}