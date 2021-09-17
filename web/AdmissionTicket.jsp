<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: fengzelin
  Date: 2021/7/1
  Time: 4:29 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="UniversalCSS.css">
<%
    String[] Data = (String[]) session.getAttribute("Data");
%>
<head>
    <title>准考证</title>
</head>
<body>
<h1>2021年全国大学英语四、六级考试</h1>
<h2>准考证</h2>
<h3>个人信息:</h3>
<%
    String Path =Data[4] + Data[2] + Data[3] + ".jpg";
    System.out.println(Path);
    System.out.println(Data[4]);
%>
<%
    File file = new File(request.getServletContext().getRealPath("/" + Path));
    String massage;
    if(!file.exists()) {
        massage = "未找到与你相关的准考信息，请检查学号、姓名以及考试级别是否正确，或联系老师";
        request.setAttribute("massage", massage);
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
%>
<p><img src="<%=Path%>" alt="Student Photo" style="width: 150px;height: 200px"/><br> <%=Data[2]%>的照片</p>
<h4>
    准考证号: 2100<%=Data[4]%><%=Data[7]%><br>
    姓名: <%=Data[2]%><br>
    学号: <%=Data[3]%><br>
</h4>
<h3>科目与时间安排:<br></h3>
<h4>
    <%
        String time = "";
        if(Data[4].equals("4b")) time = "CET4: 2021-12-12 8:00" ;
        else time = "CET6 2021-12-12 15:00";
    %>
    <%=time%><br>
</h4>
<h3>考场安排:</h3>
<h4>
    <%
        String room = "1";
        if(Data[6].equals("0")) room = "1";
        else room = "2";
    %>
    考场号: <%=room%><br>
    座位号: <%=Data[5]%>
</h4>
</body>
</html>
