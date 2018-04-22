package pl.workshop3.controller;

import pl.workshop3.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      //  int limit = Integer.parseInt(getServletContext().getInitParameter("number-solution"));

    //    response.getWriter().append(limit + "");

        Solution[] sols = Solution.loadAllSolutions(5);

        request.setAttribute("sols", sols);

        getServletContext().getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }
}
