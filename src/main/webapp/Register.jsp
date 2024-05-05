<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.04.2024
  Time: 6:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form action="Register" method="POST">
    Логин: <input type="text" name="login"/>
    Пароль: <input type="password" name="password"/>
    Почта: <input type="text" name="email"/>
    <input type="submit" value="Зарегистрироваться">
</form>
</body>
</html>
