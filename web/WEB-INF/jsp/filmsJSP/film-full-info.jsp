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
<p></p>
Съёмочная группа :<br><p>
<c:forEach items="${requestScope.info.actors}" var="actors">
    Имя : ${actors.firstName}${" "}${actors.lastName}${" "}<br> Роль : ${actors.role}<br></p>
</c:forEach>
<p></p>
Отзовы :<br>
<c:forEach items="${requestScope.info.reviews}" var="reviews">
    Имя : ${reviews.user.nickName}<br>${reviews.text}<br>
</c:forEach>
</body>
</html>
