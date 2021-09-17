<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="UniversalCSS.css">
<head>
    <meta charset="UTF-8">
    <title>register</title>
</head>
<body style="background: url(backgound.png) no-repeat; height: 100%; width: 100%; background-size: 100%">
<img src="161230188.jpg" alt="icon">
<h1>注册</h1>
<form action="Register.do" method="post">
  <p>用户名:
    <input type="text" name="username" required="required">
  </p>
  <p>密码:
    <input type="password" name="password" required="required">
  </p>
  <p>确认密码:
    <input type="password" name="Q_password" required="required">
  </p>
  <p>姓名:
    <input type="text" name="StuName" required="required">
  </p>
  <p>学号:
    <input type="text" name="StuId" required="required"><br>
    考试级别:
    <select name="brand">
      <option value="4b">CET4</option>
      <option value="6b">CET6</option>
    </select>
  </p>
  <p>
    ${massage}<br>
    <input type="submit" value="确认"><br>
    <a href="login.jsp">已有账号？请直接登录</a>
  </p>
</form>
</body>
</html>