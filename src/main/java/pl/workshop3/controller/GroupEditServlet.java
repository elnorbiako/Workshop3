package pl.workshop3.controller;

import pl.workshop3.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/groupedit")
public class GroupEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id =Integer.parseInt(request.getParameter("id"));
        String name =request.getParameter("name");

        Group updateGroup = new Group(id, name);

        Group.update(updateGroup);

        response.sendRedirect("/allgroup");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("id", id);

        getServletContext().getRequestDispatcher("/groupedit.jsp")
                .forward(request, response);
    }
}
