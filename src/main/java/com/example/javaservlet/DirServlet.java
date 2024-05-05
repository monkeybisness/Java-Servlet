package com.example.javaservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import Service.FileManager;
import java.io.*;

@WebServlet(urlPatterns = {"/Manager"})
public class DirServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        FileManager fileManager = new FileManager();
        File[] folders = fileManager.allFolders(request.getParameter("path"));
        if (folders == null) {
            folders = new File[0];
        }

        File[] files = fileManager.allFiles(request.getParameter("path"));
        if (files == null) {
            files = new File[0];
        }

        request.setAttribute("folders", folders);
        request.setAttribute("files", files);
        request.getRequestDispatcher("Manager.jsp").forward(request, response);//попросил Manager.jsp обработать запрос

    }

    public void destroy() {
    }
}