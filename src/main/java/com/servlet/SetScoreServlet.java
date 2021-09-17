package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SetScore", urlPatterns = {"/setScore.do"})
public class SetScoreServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("User.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(url.getFile()));
        String StuID = request.getParameter("StuID");
        int userScore1 = Integer.parseInt(request.getParameter("score_1"));
        int userScore2 = Integer.parseInt(request.getParameter("score_2"));
        int userScore3 = Integer.parseInt(request.getParameter("score_3"));
        int userScore = userScore1 + userScore2 + userScore3;

        String text = "";
        String line = null;
        boolean flag = false;
        while ((line = bufferedReader.readLine()) != null) {
            String tt = line;
            System.out.println(tt);
            String[] data = line.split("#", 0);
            if(data[3].equals(request.getParameter("StuID"))) {
                tt = data[0] + "#" + data[1] + "#" + data[2] + "#" + data[3] + "#" + data[4] + "#" + data[5] + "#" + data[6]
                        + "#" + data[7] + "#" + userScore1 + "#" + userScore2 + "#" + userScore3 + "#" + userScore + "#";
                flag = true;
            }
            text += tt + "\n";
        }
        PrintWriter printWriter = new PrintWriter(url.getFile());
        printWriter.write(text);
        printWriter.flush();
        printWriter.close();
        String massage;
        if(flag) {
            massage = "成功为" + StuID + "添加成绩";
            request.setAttribute("massage", massage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AddScore.jsp");
            requestDispatcher.forward(request, response);
        }else {
            massage = "未找到" + StuID;
            request.setAttribute("massage", massage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AddScore.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        super.doPost(request, response);
    }
}
