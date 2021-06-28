<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Upload File</title>
</head>
<body>
${message}<br>
<h1>Please Upload Your Photo</h1>
<div style="align-content: center">
    <form action="${pageContext.request.contextPath}/Upload.do" method="post" enctype="multipart/form-data">
        select your photo:
        <label>
        <input type="text" name="username" size="30"/>
        <input type="file" name="filename" size="30"/>
        <br/><br/>
        <input type="submit" value="Upload"/>
        </label>
    </form>
</div>
</body>
</html>
