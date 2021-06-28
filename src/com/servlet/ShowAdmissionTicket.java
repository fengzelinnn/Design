package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

@WebServlet(name = "Admission Ticket", urlPatterns = {"/Admission.do"})
public class ShowAdmissionTicket extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("User.txt");
        boolean flag = false;
        BufferedReader bufferedReader =
                new BufferedReader
                        (new FileReader(url.getFile()));
        String line;
        PrintWriter printWriter = response.getWriter();
        while ((line = bufferedReader.readLine())!=null) {
            String[] data = line.split("#");
            if(data[0].equals(request.getParameter("username")))  {
                flag = true;
                break;
            }else{
                printWriter.println("<a href=\"check.html\">login</a>");
                printWriter.println("<script language='javascript'>alert('try again')</script>");
            }
        }
        if (flag){
            request.getRequestDispatcher("AdmissionTicket.html").forward(request, response);
        }
    }
}
