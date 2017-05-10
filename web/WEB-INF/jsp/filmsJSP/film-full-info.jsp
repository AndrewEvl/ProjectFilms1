<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.04.2017
  Time: 20:21
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
Название фильма : ${requestScope.info.name}<br>
Жанр : ${requestScope.info.genre}<br>
Дата выхода : ${requestScope.info.releaseDay}
<p></p>
Съёмочная группа :<br><p>
<c:forEach items="${requestScope.info.actors}" var="actors">
    Имя : ${actors.firstName}${" "}${actors.lastName}${" "}<br> Дата рождения :${actors.birthday}${" "}<br> Роль : ${actors.role}<br></p>
</c:forEach>
<p></p>
Отзывы :<br>

<c:forEach items="${requestScope.info.reviews}" var="reviews">
    <p>Имя : ${reviews.user.nickName}<br> Отзыв : ${reviews.text}<br></p>
</c:forEach>


<form action=" " method="post">
    <label for="review">Пишите отзыв :</label>
    <input type="text" id="review" name="review"><br>
    <button type="submit">Добавить отзыв</button>
</form>
</body>
</html>
