<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="UniversalCSS.css">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Upload File</title>
</head>
<body>
<h1>上传您要更改的照片</h1>
${message}<br>
<div style="align-content: center">
    <form action="" method="post" enctype="multipart/form-data">
        选择照片:
        <label>
        <input type="text" name="username" size="30"/>
        <input type="file" name="filename" size="30"/>
        <br/><br/>
        <input type="submit" value="上传"/>
        </label>
    </form>
</div>
</body>
</html>
