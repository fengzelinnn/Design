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
        String name = null;
        String massage;
        PrintWriter printWriter = response.getWriter();
        String[] Data = new String[13];
        if(request.getParameter("username").equals("admin") && request.getParameter("password").equals("admin")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManPanel.jsp");
            requestDispatcher.forward(request, response);
        }else {
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split("#", 0);
                if (data[0].equals(request.getParameter("username"))) {
                    if (data[1].equals(request.getParameter("password"))) {
                        System.arraycopy(data, 0, Data, 0, 12);
                        name = data[2];
                        flag = true;
                    } else {
                        massage = "密码错误请重试";
                        request.setAttribute("massage", massage);
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
                        requestDispatcher.forward(request, response);
                    }
                    break;
                }
            }
            HttpSession session = request.getSession();
            if (flag) {
                System.out.println(Data[4]);
                session.setAttribute("Data", Data);
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            }
            if(line == null) {
                massage = "未找到用户名，请先注册";
                request.setAttribute("massage", massage);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }
}
