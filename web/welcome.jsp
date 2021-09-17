<%--
  Created by IntelliJ IDEA.
  User: fengzelin
  Date: 2021/7/1
  Time: 10:04 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="UniversalCSS.css">
<%
    String[] Data = (String[]) session.getAttribute("Data");
%>
<head>
    <title>Welcome Page</title>
</head>

<body style="background: url(backgound.png) no-repeat; height: 100%; width: 100%; background-size: 100%">
<img src="161230188.jpg" alt="icon">
<h1>欢迎<%=Data[2]%>!</h1>
<h2>选择操作</h2>
<h4>${massage}</h4>
<%
    session.setAttribute("Data", Data);
%>
<h3><a href=AdmissionTicket.jsp>查看准考证</a><br>
    <a href=Grade.jsp>查看成绩单</a><br>
    <a href=upload.jsp>更改照片</a><br>
    <a href="override.jsp">更改个人信息</a>
</h3>
</body>
</html>