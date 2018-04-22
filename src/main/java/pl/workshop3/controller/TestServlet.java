package pl.workshop3.controller;

import pl.workshop3.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int userGroupId = Integer.parseInt(request.getParameter("user_group_id"));

        User user = new User(name, email, password, userGroupId);

        User.add(user);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter().append("<form method ='post' action = ''>");
        response.getWriter().append("Name: <input type ='text' name ='name'/><br>");
        response.getWriter().append("Email: <input type ='text' name ='email'/><br>");
        response.getWriter().append("Password: <input type ='text' name ='password'/><br>");
        response.getWriter().append("User Id: <input type ='number' name ='user_group_id'/><br>");
        response.getWriter().append("<input type ='submit' />");
        response.getWriter().append("</form>");

    }
}
