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
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "ManagerServlet", urlPatterns = {"/setRoom.do"})
public class ManagerServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int[] randoms1 = getRandom();
        int[] randoms2 = getRandom();
        response.setContentType("text/html;charset=UTF-8");
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("User.txt");
        assert url != null;
        BufferedReader bufferedReader =
                new BufferedReader
                        (new FileReader(url.getFile()));
        String line;
        String seat;
        String room;
        String AdmID;
        int i = 0;
        String text = "";
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split("#", 0);
            if(data[4].equals("4b")){
                seat = String.valueOf((randoms1[i] - 10) % 30);
                room = String.valueOf((randoms1[i] - 10) / 30);
                AdmID = String.valueOf(randoms1[i]);
            }else {
                seat = String.valueOf((randoms2[i] - 10) % 30);
                room = String.valueOf((randoms2[i] - 10) / 30);
                AdmID = String.valueOf(randoms2[i]);
            }
            line = data[0] + "#" + data[1] + "#" + data[2] + "#" + data[3] + "#" + data[4] + "#" + seat+ "#" + room
                    + "#" + AdmID + "#" + data[7] + "#" + data[8] + "#" + data[9] + "#" +data[10] + "#" + data[11];
            i++;
            text += line + "\n";
        }
        PrintWriter printWriter = new PrintWriter(url.getFile());
        printWriter.write(text);
        printWriter.flush();
        printWriter.close();
        String massage;
        massage = "考场设置成功";
        request.setAttribute("massage", massage);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManPanel.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
    public static int[] getRandom() {
        int[] randoms = new int[50];
        int index = 0;
        do {
            int random = (int) (Math.random() * 50 + 10);
            int j = 0;
            for (; j < randoms.length; j++) {
                if (random == randoms[j]) break;
            }
            if (j == randoms.length) randoms[index++] = random;
        } while (index != 50);
        return randoms;
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }
}
