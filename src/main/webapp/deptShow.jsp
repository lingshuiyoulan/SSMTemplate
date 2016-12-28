<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>部门信息</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>地址</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${depts}" var="dept">
        <tr>
            <td>${dept.deptno}</td>
            <td>${dept.dname}</td>
            <td>${dept.loc}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
