<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="UniversalCSS.css">
<head>
    <meta charset="UTF-8">
    <title>AddScore Page</title>
</head>
<body style="background: url(backgound.png) no-repeat; height: 100%; width: 100%; background-size: 100%">
<h1>录入成绩</h1>
<h2>请输入考生学号和对应成绩</h2>
${massage}<br>
<form action="setScore.do" method="post">
    <h3>学号:<br></h3>
    <input type="text" name="StuID"><br>
    <h3>成绩:<br></h3>
    听力部分:<input type="text" name="score_1"><br>
    阅读理解:<input type="text" name="score_2"><br>
    写作:<input type="text" name="score_3"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>