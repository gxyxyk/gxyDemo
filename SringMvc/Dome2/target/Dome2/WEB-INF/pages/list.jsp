<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 南阳子
  Date: 2020/12/12
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <c:forEach var="acoounts" items="${list}">
            <tr>
                <td>${acoounts.id}</td>
                <td>${acoounts.name}</td>
                <td>${acoounts.money}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
