<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.04.2017
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление фильма</title>
</head>
<body>
<%@include file="../header.jsp" %>
<form action="${pageContext.request.contextPath}/filmsave" method="post">
    <label for="name" id="name">Название</label>
    <input type="text" name="name" title="Название"><br>
    <label for="releaseDay" id="releaseDay">Дата выхода</label>
    <input type="date" name="releaseDay" title="Дата выхода"><br>
    <label for="country" id="country">Страна выпуска</label>
    <input type="text" name="country" title="Страна выпуска"><br>
    <label class="form-lable" for="genres">Ganre</label>
    <select id="genres" class="form-control" name="genre">
        <c:forEach items="${requestScope.genres}" var="genre">
            <option value="${genre.id}">${genre.name}</option>
        </c:forEach>
    </select>
    <br>
    Добавить съёмочную группу<br>
    <select id="firstId" class="form-control" name="actDir">
        <c:forEach items="${requestScope.actDir}" var="actDir">
            <option value="${actDir.id}">${actDir.firstName}${" "}${actDir.lastName}</option>
        </c:forEach>
        <br>
    </select>
    <select id="roleOne" class="form-control" name="roleOne">
        <c:forEach items="${requestScope.role}" var="role">
            <option value="${role.id}">${role.role}</option>
        </c:forEach>
    </select>
    <br>
    Добавить съёмочную группу<br>
    <select id="secondId" class="form-control" name="actDir">
        <c:forEach items="${requestScope.actDir}" var="actDir">
            <option value="${actDir.id}">${actDir.firstName}${" "}${actDir.lastName}</option>
        </c:forEach>
        <br>
    </select>
    <select id="role" class="form-control" name="role">
        <c:forEach items="${requestScope.role}" var="role">
            <option value="${role.id}">${role.role}</option>
        </c:forEach>
    </select>
    <button type="submit">Save</button>
</form>
Если не нашли Актёра или Режисёра можно его добавить!<br>
<a href="${pageContext.request.contextPath}/actdirsave">Добавить съёмочную группу</a>
<%@include file="../footer.jsp" %>
</body>
</html>
