<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Register form</title>
    <style>
        .error {
            color: red;
        }
    </style>

</head>
<body>

<form:form method="post" modelAttribute="user">

    <label>
        Podaj e-mail: <br>
        <form:input path="email"/><form:errors path="email" cssClass="error"/>
    </label>
    <br>
    <label>
        Podaj nazwę użytkownika: <br>
        <form:input path="username"/><form:errors path="username" cssClass="error"/>
    </label>
    <br>
    <label>
        Podaj hasło: <br>
        <form:password path="password"/><form:errors path="password" cssClass="error"/>
    </label>
    <br>
    <label>
        <input type="submit" value="Zarejestruj się">
    </label>
    <label>
        <input type="reset" value="Usuń wartości">
    </label>
    <br>
    <label>
        <a href="http://localhost:8080/login">Masz już konto? Zaloguj się!</a>
    </label>

</form:form>

</body>
</html>