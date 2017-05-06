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
Название фильма : ${requestScope.info.name}
Жанр : ${requestScope.info.genre}

<c:forEach items="${requestScope.film.info}" var="films">
    ${films.name}${" "}${films.actors}
    ${films.reviews}${" "}${films.genre}
</c:forEach>
</body>
</html>
