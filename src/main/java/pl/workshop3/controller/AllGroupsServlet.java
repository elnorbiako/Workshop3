package pl.workshop3.controller;

import pl.workshop3.dao.GroupDao;
import pl.workshop3.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/allgroup")
public class AllGroupsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Group[] groups = GroupDao.loadAllGroups();

        request.setAttribute("groups", groups);

        getServletContext().getRequestDispatcher("/allgroup.jsp")
                .forward(request, response);

    }
}
