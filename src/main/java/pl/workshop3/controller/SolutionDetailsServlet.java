package pl.workshop3.controller;

import pl.workshop3.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/solDetails")
public class SolutionDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int solId = Integer.parseInt(request.getParameter("id"));

        Solution solution = Solution.read(solId);

        request.setAttribute("solution", solution);

        getServletContext().getRequestDispatcher("/solution.jsp")
                .forward(request, response);

    }
}
