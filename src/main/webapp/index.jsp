<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
</head>
<body>
<br><br><br>

测试文件上传与返回json类型
<form action="${pageContext.request.contextPath}/fun.do" enctype="multipart/form-data" method="post">
    <input type="file" name="file">
    <br>
    <input type="submit">
</form>

<br><br><br>

<a href="${pageContext.request.contextPath}/depts.do">显示dept</a>

<br><br><br>

<table>
    <thead>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>地址</th>
    </tr>
    </thead>

    <tbody>
    <tr>
        <td id="deptno"></td>
        <td id="dname"></td>
        <td id="loc"></td>
    </tr>
    </tbody>
</table>
<br>
<br>
<br>
restful风格测试需在web.xml中开启
<button id="btn" type="button">ajax显示部门信息</button>
<script>
    $(function () {
        var parm0 = 10;
        var parm1 = "参数测试1";
        var parm2 = "参数测试2";
        $("#btn").on("click", function () {
            $.post(
                "${pageContext.request.contextPath}/restful/" + parm0 + "/" + parm1 + "/" + parm2,
                function (date) {
                    $("#deptno").text(date.deptno);
                    $("#dname").text(date.dname);
                    $("#loc").text(date.loc);
                }
            );
        });
    });
</script>
</body>
</html>
