package com.example.javaservlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Service.AuthService;
import Service.Utility;

import java.io.IOException;
@WebServlet(urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(AuthService.GetUser(login, password) == null) {
            response.getWriter().println("Incorrect login or password");
            return;
        }

        request.getSession().setAttribute("login", login);
        request.getSession().setAttribute("password", password);
        response.sendRedirect(Utility.RedirectOn(request.getRequestURL().toString(), "/Manager?path=C:/Users/User/IdeaProjects/Java-Servlet/session/"+login+"/"));
    }
}
