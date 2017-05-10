<%--
  Created by IntelliJ IDEA.
  User: Lino
  Date: 01.05.2017
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="${pageContext.request.contextPath}/changeLanguage" method="get">
    <select name="language" onchange="submit()">
        <option value="ru_RU" ${sessionScope.currentLanguage eq 'ru_RU' ? 'selected' : ''}>Русский</option>
        <option value="en_US" ${sessionScope.currentLanguage eq 'en_US' ? 'selected' : ''}>English</option>
    </select>
</form>