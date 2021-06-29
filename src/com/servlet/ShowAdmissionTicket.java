package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
        String[] data = new String[10];
        while ((line = bufferedReader.readLine()) != null) {
            String[] Data = line.split("#",0);
            if(Data[0].equals(request.getParameter("username")))  {
                flag = true;
                System.arraycopy(Data,0,data,0,4);
                break;
            }
        }
        if(!flag) {
            printWriter.println("<a href=\"check.html\">login</a>");
            printWriter.println("<script language='javascript'>alert('try again')</script>");
        }else {
            String Path = this.getServletContext().getRealPath("/upload/");
            Path = Path + data[0] + ".jpg";
            File file = new File(Path);
            System.out.println(Path);
            if(!file.exists()) {
                out.println("<html><head><title>ERROR</title><head><body>Haven't Upload Photo...<br>");
                out.println("<a href=\"upload.jsp\">Upload Page</a></body><html>");
            }
            out.println("<html><head><title>Admission Ticket of " + data[2] + "</title></head>" +
                    "<body><h1>National Collage English Test - 2021</h1><br>" +
                    "<h2>Admission Ticket</h2>" +
                    "<table><tr><th>Personal Information</th><th></th></tr>" +
                    "<tr><th>" +
                    "Ticket ID:" + data[3] + "<br>" +
                    "Student Name:" + data[2] + "<br>" +
                    "Student ID:" + data[3] + "<br>" +
                    "</th><th>" +
                    "</th></tr></table>" +
                    "<img src=\"" + Path +"\" alt=\"00\"/>" +
                    "<table><tr><th>Arrangement of Time</th><th></th></tr>" +
                    "<tr><th>TIME!!!</th><th></th>" +
                    "</table>" +
                    "<table><tr><th>Arrangement of Exam Room</th><th></th></tr>" +
                    "<tr><th>Room ID</th><th>Seat ID</th></tr>" +
                    "<tr><th>" + data[3] + "</th><th>" + data[3] + "</th></tr>" +
                    "</table>" +
                    "<table><tr><th>TIPS!!!</th></tr></table></body></html>");
        }
    }
}
