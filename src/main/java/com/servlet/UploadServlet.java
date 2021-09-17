package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

import static java.lang.System.*;

@WebServlet(name = "UploadServlet", urlPatterns = {"/Upload.do"})
@MultipartConfig(fileSizeThreshold = 1024)
public class UploadServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String path = this.getClass().getClassLoader().getResource("/").getPath();
        String UName = request.getParameter("username");
        Part part = request.getPart("filename");
        String message ;
        if(part.getSize() > 1024*1024*3) {
            part.delete();
            message = "文件过大";
        }else{
            System.out.println(path);
            File f = new File(path);
            if(!f.exists()){
                Boolean isSucToMkdirs;
                isSucToMkdirs = f.mkdirs();
                if(!isSucToMkdirs){
                    out.println("无效目录");
                    return;
                }
            }
            String h = part.getHeader("content-disposition");
            String fname = h.substring(h.lastIndexOf("/") + 1, h.length() - 1);
            part.write(path + "/" + UName + ".jpg");
            message = "Successfully upload";
        }
        request.setAttribute("message", message);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/upload.jsp");
        requestDispatcher.forward(request, response);
    }
}
