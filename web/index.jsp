<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="language.jsp"%>
<fmt:setLocale value="${not empty sessionScope.currentLanguage ? sessionScope.currentLanguage : 'ru_RU'}"/>
<fmt:setBundle basename="translations"/>
<html>
<head>
    <title></title>
</head>
<body>
<a href="${pageContext.request.contextPath}/usersave"><fmt:message key="addUser"/> </a><br>
<a href="${pageContext.request.contextPath}/filmsave"><fmt:message key="addFilm"/></a><br>
<a href="${pageContext.request.contextPath}/actdirsave"><fmt:message key="addActor"/></a><br>
<a href="${pageContext.request.contextPath}/filmList"><fmt:message key="FilmsList"/></a><br>
<a href="${pageContext.request.contextPath}/actordirectorinfo"><fmt:message key="ActorsList"/></a><br>
<a href="${pageContext.request.contextPath}/find-film"><fmt:message key="FindFilm"/></a><br>
<a href="${pageContext.request.contextPath}/getFile">Скачка отчёта</a>
</body>
</html>