package pl.workshop3.controller;

import pl.workshop3.model.Excercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getex")
public class GetExServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("excerciseId"));

        Excercise ex = new Excercise();

        ex = Excercise.read(userId);

        response.getWriter().append("Ex. title: " + ex.getTitle() + "\n");
        response.getWriter().append("Ex. descripiton: " + ex.getDescription());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");
        response.getWriter().append("<form method ='post' action = ''>");
        response.getWriter().append("Ex Id: <input type ='number' name ='excerciseId'/><br>");
        response.getWriter().append("<input type ='submit' />");
        response.getWriter().append("</form>");
    }
}
