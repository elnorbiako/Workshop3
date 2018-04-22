package pl.workshop3.controller;

import pl.workshop3.model.Group;
import pl.workshop3.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/useredit")
public class UserEditServlet extends HttpServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            int id =Integer.parseInt(request.getParameter("id"));
            String name =request.getParameter("name");
            String email =request.getParameter("email");
            String password =request.getParameter("password");
            int groupId = Integer.parseInt(request.getParameter("groupId"));

            User user = new User(id, name, email, password, groupId);

            User.update(user);

            response.sendRedirect("/allusers");

        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));

            request.setAttribute("id", id);

            getServletContext().getRequestDispatcher("/useredit.jsp")
                    .forward(request, response);
        }
    }
