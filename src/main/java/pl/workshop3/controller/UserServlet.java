package pl.workshop3.controller;

import pl.workshop3.model.Solution;
import pl.workshop3.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("id"));
        User user = User.read(userId);

        request.setAttribute("user", user);

        Solution[] solutions = Solution.loadAllSolsByUserId(userId);

        request.setAttribute("solutions", solutions);

        getServletContext().getRequestDispatcher("/user.jsp")
                .forward(request, response);
    }
}
