<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Login form</title>
    <style>
        .error {
            color: red;
        }
    </style>

</head>
<body>

<form:form method="post" action="/login">


    <div>
        Podaj nazwę użytkownika: <br>
        <input name="username" /><form:errors path="username" cssClass="error"/>
    </div>
    <div>
        Podaj hasło:<br>
        <input type="password" name="password"/><form:errors path="password" cssClass="error"/>
    </div>
    <div>
        <input type="submit" value="Zaloguj się">
    </div><br>
    <div>
        <input type="reset" value="Usuń wartości">
    </div>

</form:form>

</body>
</html>