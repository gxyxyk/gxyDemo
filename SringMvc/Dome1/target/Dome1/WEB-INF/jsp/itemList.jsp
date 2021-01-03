<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 南阳子
  Date: 2020/12/10
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${itemList.size()}
    <c:forEach items="${itemList}" var="list">
        <ul>
            <li>${list.name}</li>
            <li>${list.price}</li>
            <li>${list.detail}</li>
        </ul>
    </c:forEach>
</body>
</html>
