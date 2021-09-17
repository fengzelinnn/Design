package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.sql.Timestamp;

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
        int max = 50;
        int min = 1;
        String line;
        String massage;

        String userName = request.getParameter("username");
        String userPWD = request.getParameter("password");
        String userPWD_Q = request.getParameter("Q_password");
        String stuName = request.getParameter("StuName");
        String stuId = request.getParameter("StuId");
        String brand = request.getParameter("brand");
        if(request.getParameter("username").equals(request.getParameter("password"))
                ||request.getParameter("username").equals(request.getParameter("StuName"))
                ||request.getParameter("password").equals(request.getParameter("StuName"))) {
            massage = "不推荐用户名、密码、姓名相同";
            request.setAttribute("massage", massage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/register.jsp");
            requestDispatcher.forward(request, response);
        }else {
            while ((line = bufferedReader.readLine())!=null) {
                String[] data = line.split("#");
                if(data[0].equals(userName))  {
                    flag = false;
                    massage = "该用户名已被注册";
                    request.setAttribute("massage", massage);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/register.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
            }
            if(flag) {
//                long randomNum = System.currentTimeMillis();
//                int uuid = (int) (randomNum%(max-min)+min);
                FileWriter fileWriter = new FileWriter(url.getFile(),true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                if(userPWD.equals(userPWD_Q)) {
                    String info = userName + "#" + userPWD
                            + "#" + stuName + "#" + stuId + "#" + brand + "#" + null + "#" + null + "#" + null + "#"
                            + null + "#" + null + "#" + null + "#" + null + "#";
                    bufferedWriter.write(info);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }else {
                    massage = "两次输入的密码不同";
                    request.setAttribute("massage", massage);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/register.jsp");
                    requestDispatcher.forward(request, response);
                }
            }
            massage = "注册成功请登录";
            request.setAttribute("massage", massage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request, response);
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }
}
