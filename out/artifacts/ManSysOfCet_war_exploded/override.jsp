<%--
  Created by IntelliJ IDEA.
  User: fengzelin
  Date: 2021/7/1
  Time: 10:38 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String[] Data = (String[]) session.getAttribute("Data");
%>
<link rel="stylesheet" href="UniversalCSS.css">
<head>
    <title>Override page</title>
</head>
<body style="background: url(backgound.png) no-repeat; height: 100%; width: 100%; background-size: 100%">
<form action="override.do" method="post">
    <h1>请重新输入您的个人信息:</h1>
    <h3>你好<%=Data[2]%></h3>
    <p>
        姓名:<input type="text" name="StuName" required = "required"><br>
        学号:<input type="text" name="StuID" required = "required"><br>
        旧密码:<input type="password" name="OP" required = "required"><br>
        新密码:<input type="password" name="password" required = "required"><br>
        确认新密码:<input type="password" name="Q_password" required = "required"><br>
        考试级别:<select name="brand" required = "required" style="text-align: start">
            <option value="4b">CET4</option>
            <option value="6b">CET6</option>
        </select><br>
        <%
            session.setAttribute("Data", Data);
        %>
        ${massage}
        <input type="submit" value="提交">
    </p>
</form>
</body>
</html>
