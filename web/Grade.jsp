<%@ page import="javax.xml.crypto.Data" %><%--
  Created by IntelliJ IDEA.
  User: fengzelin
  Date: 2021/7/1
  Time: 9:32 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="UniversalCSS.css">
<%
    String[] data = (String[]) session.getAttribute("Data");
%>
<head>
    <title>Grade Page</title>
</head>
<body>
    <h1>2021年全国大学英语四、六级考试</h1><br>
    <%
        String time = "";
        if(data[4].equals("4b")) time = "CET4" ;
        else time = "CET6";
    %>
    <h2>成绩单<%=time%></h2>
    <h3>姓名: <%=data[2]%><br>
        学号: <%=data[3]%><br>
        准考证号:2100<%=data[4]%><%=data[7]%><br>
        <%
            String massage;
            if(data[11].equals("null")) {
                massage = "未查询到成绩";
                request.setAttribute("massage", massage);
                request.getRequestDispatcher("/welcome.jsp").forward(request, response);
            }
        %>
        听力部分: <%=data[8]%><br>
        阅读理解:<%=data[9]%><br>
        写作:<%=data[10]%><br>
        总分:<%=data[11]%><br>
    </h3>
</body>
</html>
