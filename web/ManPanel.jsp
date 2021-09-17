<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="UniversalCSS.css">
<head>
    <title>Welcome to management system of CET!</title>
</head>
<body style="background: url(backgound.png) no-repeat; height: 100%; width: 100%; background-size: 100%">
<form action="setRoom.do" method="post">
<img src="161230188.jpg" alt="icon">
<h1>大学英语四、六级管理系统</h1>
<h2>请选择操作</h2>
<h3>
    ${massage}<br>
    <input type="submit" value="设置考场"><br>
    <a href="AddScore.jsp">添加成绩</a>
</h3>
</form>
</body>
</html>