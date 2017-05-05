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
${requestScope.actor.firstName}
${requestScope.actor.lastName}
<c:forEach items="${requestScope.actor.film}" var="film">
    ${film.name}
</c:forEach>
<%--Фильм Роль : ${actor.firstName}${" "}${actor.lastName}<br>--%>
</body>
</html>
