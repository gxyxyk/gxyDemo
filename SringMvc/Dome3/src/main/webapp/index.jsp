<%--
  Created by IntelliJ IDEA.
  User: 南阳子
  Date: 2020/12/13
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="user/testString">跳转1</a>
    <a href="user/initAdd">void直接响应数据</a>
    <a href="user/initAdd1">转发到add1</a>
    <a href="user/initAdd2">重定向到add2</a>
    <a href="user/findAll">ModeAndVier到aa</a>
    <input type="button" id="btn" value="ajax访问"/>
    <h3>文件上传</h3>
    <form action="user/fileupload" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        <input type="submit" value="上传文件"/>
    </form>
    <a href="user/excption">错误测试！</a>
</body>
</html>
<script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
<script type="text/javascript">
    $("#btn").click(function () {
        $.ajax({
            url:"user/testJson",
            contentType:"application/json;charset=utf-8",
            data:'{"addressName":"aa","addressNum":100}',
            dataType:"json",
            type:"post",
            success:function (data) {
                alert(data);
                alert(data.addressName);
            }
        })
    })
</script>
