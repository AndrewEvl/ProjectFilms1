<%--
  Created by IntelliJ IDEA.
  User: Lino
  Date: 29.04.2017
  Time: 23:47
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
<c:forEach items="${requestScope.info}" var="actor">
    <a href="${pageContext.request.contextPath}/fullinfoactor?id=${actor.id}">${actor.firstName}${" "}${actor.lastName}</a><br>
</c:forEach>

<a href="${pageContext.request.contextPath}/">На главную</a>
</body>
</html>
