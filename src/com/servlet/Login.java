package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;

@WebServlet(name = "Login", urlPatterns = {"/Login.do"})
public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean flag = false;
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("User.txt");
        BufferedReader bufferedReader =
                new BufferedReader
                        (new FileReader(url.getFile()));
        String line = null;
        PrintWriter printWriter = response.getWriter();
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split("#");
            if (data[0].equals(request.getParameter("username"))) {
                if (data[1].equals(request.getParameter("password"))) {
                    flag = true;
                } else {
                    printWriter.println("<a href=\"login.html\">login</a>");
                    printWriter.println("<script language='javascript'>alert('try again')</script>");
                }
                break;
            }
        }
        if (flag) printWriter.println("<h1 align='center'>"+request.getParameter("username")+"Welcome"+"<h1>");
        if(line == null) {
            printWriter.println("<a href=\"login.html\">login</a>");
            printWriter.println("<a href=\"register.html\">register</a>");
            printWriter.println("<script language='javascript'>alert('No Such Username')</script>");
        }
    }
}
