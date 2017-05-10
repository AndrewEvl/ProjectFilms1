<%--
  Created by IntelliJ IDEA.
  User: Lino
  Date: 06.05.2017
  Time: 23:50
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
Введите год выпуска фильма :<br>
<form action="${pageContext.request.contextPath}/find-film" method="post">
    <label for="yearFilm" id="yearFilm">Название</label>
    <input type="date" name="yearFilm" title="Название"><br>
    <button type="submit">Найти</button>
</form>
<c:forEach items="${requestScope.films}" var="film">
    <a href="${pageContext.request.contextPath}/filmsinfo?id=${film.id}">${film.name}</a><br>
</c:forEach>

<a href="${pageContext.request.contextPath}/">На главную</a>
</body>
</html>
