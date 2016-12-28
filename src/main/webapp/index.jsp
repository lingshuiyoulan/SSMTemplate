<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/fun.do" enctype="multipart/form-data" method="post">
    <input type="file" name="file">
    <br>
    <input type="submit">
</form>


<a href="${pageContext.request.contextPath}/depts.do">显示dept</a>
</body>
</html>
