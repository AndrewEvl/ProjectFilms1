<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="${pageContext.request.contextPath}/changeLanguage" method="get">
    <select name="language" onchange="submit()">
        <option value="ru_RU" ${sessionScope.currentLanguage eq 'ru_RU' ? 'selected' : ''}>Русский</option>
        <option value="en_US" ${sessionScope.currentLanguage eq 'en_US' ? 'selected' : ''}>English</option>
    </select>
</form>
<a href="${pageContext.request.contextPath}/changeLanguage?language=en_US">English</a>
<a href="${pageContext.request.contextPath}/changeLanguage?language=ru_RU">Русский</a>