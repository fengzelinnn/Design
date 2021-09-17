package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URL;

@WebServlet(name = "Override", urlPatterns = {"/override.do"})
public class Override extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String[] Data = (String[]) session.getAttribute("Data");
        boolean flag = false;
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("User.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(url.getFile()));
        String line = null;
        String massage;
        String temp = "";
        if(!Data[1].equals(request.getParameter("OP"))) {
            massage = "Wrong Password!";
            request.setAttribute("massage", massage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/override.jsp");
            requestDispatcher.forward(request, response);
        }else {
            if(!request.getParameter("password").equals(request.getParameter("Q_password"))) {
                massage = "There are difference between the password input twice";
                request.setAttribute("massage", massage);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/override.jsp");
                requestDispatcher.forward(request, response);
            } else {
                while ((line = bufferedReader.readLine()) != null) {
                    String tt = line;
                    String[] data = line.split("#", 0);
                    if (data[0].equals(Data[0])) {
                        tt = data[0] + "#" + request.getParameter("password") + "#" + request.getParameter("StuName") +
                                "#" + request.getParameter("StuID") + "#" + request.getParameter("brand") + "#"
                                + data[5] + "#" + data[6] + "#" + data[7] + "#" + data[8] + "#" + data[9] + "#" +data[10] + "#" + data[11] + "#";
                    }
                    temp = temp + tt + "\n";
                }
                PrintWriter printWriter = new PrintWriter(url.getFile());
                printWriter.write(temp);
                printWriter.flush();
                printWriter.close();
                massage = "更改成功请重新登录";
                request.setAttribute("massage", massage);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
                requestDispatcher.forward(request, response);
            }

        }

    }
}