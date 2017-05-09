<%--
  Created by IntelliJ IDEA.
  User: Lino
  Date: 07.05.2017
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="username">Логин</label>
    <input type="text" id="username" name="username">
    <label for="password">Пароль</label>
    <input type="password" id="password" name="password">
    <button type="submit">Войти</button>
</form>

<a href="${pageContext.request.contextPath}/usersave">Зарегестрироваться</a><br>

</body>
</html>
