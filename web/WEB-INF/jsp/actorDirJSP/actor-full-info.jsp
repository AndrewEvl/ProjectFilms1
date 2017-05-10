<%--
  Created by IntelliJ IDEA.
  User: Lino
  Date: 30.04.2017
  Time: 23:39
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
Имя : ${requestScope.actor.firstName}<br>
Фамилия : ${requestScope.actor.lastName}<br>
Дата рождения : ${requestScope.actor.birthday}<br>

<p>
Список фильмов :<br>
<c:forEach items="${requestScope.actor.film}" var="film">
    Название фильма : ${film.name}${" "}<br> Жанр Фильма : ${film.genre}<br>
    Роль в фильме : ${film.role}<br></p>
</c:forEach>

<a href="${pageContext.request.contextPath}/">На главную</a>
</body>
</html>
