package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/Register.do"})
public class Register extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        boolean flag = true;
        PrintWriter printWriter = response.getWriter();
        BufferedReader bufferedReader;
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("User.txt");
        bufferedReader = new BufferedReader(new FileReader(url.getFile()));
        String line;

        String userName = request.getParameter("username");
        String userPWD = request.getParameter("password");
        String userPWD_Q = request.getParameter("Q_password");
        String stuName = request.getParameter("StuName");
        String stuId = request.getParameter("StuId");

        while ((line = bufferedReader.readLine())!=null) {
            String[] data = line.split("#");
            if(data[0].equals(userName))  {
                flag = false;
                printWriter.println("<script language='javascript'>alert('There is already have this name')</script>");
                printWriter.println("<a href=\"register.html\">register</a>");
                break;
            }
        }

        if(flag) {
            FileWriter fileWriter = new FileWriter(url.getFile(),true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            if(userPWD.equals(userPWD_Q)) {
//                information.setNUM();
                String info = userName + "#" + userPWD
                        + "#" + stuName + "#" + stuId + "#";
                bufferedWriter.write(info);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                bufferedWriter.close();
            }else {
                printWriter.println("Have difference");
            }
            printWriter.println("<a href=\"login.html\">login</a>");
        }
    request.getRequestDispatcher("upload.jsp").forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }
}
