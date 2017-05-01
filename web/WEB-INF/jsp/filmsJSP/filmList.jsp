<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.04.2017
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${requestScope.films}" var="film">
    <p><a href="${pageContext.request.contextPath}/filmList?id${film.id}">${film.name}${" "}${film.coutry}${" "}${film.relese_day}</a> </p>
</c:forEach>
</body>
</html>
