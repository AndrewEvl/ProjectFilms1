<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.04.2017
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${requestScope.films}" var="film">
    <a href="${pageContext.request.contextPath}/filmsinfo?id=${film.id}">${film.name}${" "}${film.county}</a> <br>
</c:forEach>
</body>
</html>
