<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Personal Data form</title>
    <style>
        .error {
            color: red;
        }
    </style>

</head>
<body>

<form:form method="post" action="/personaldata" modelAttribute="personalData">
    <form:hidden path="user" />
    <label>
        Podaj swoje imię:<br>
        <form:input path="firstName"/>
    </label>
    <br>
    <label>
        Podaj swoje nazwisko:<br>
        <form:input path="lastName"/>
    </label>
    <br>
    <label>
        Podaj swoja dzienny cel zadań:<br>
        <form:input type="number" path="goal"/>
    </label>
    <br>
    <label>
        Podaj swój wiek:<br>
        <form:input type="number" path="age"/>
    </label>
    <br>
    <label>
        Podaj swój wzrost:<br>
        <form:input type="number" path="height"/>
    </label>
    <br>
    <label>
        Podaj swoją wagę:<br>
        <form:input type="number" path="weight"/>
    </label>
    <br>
    <label>
        <input type="submit" value="Zapisz swoje dane">
    </label>
    <label>
        <input type="reset" value="Usuń wartości">
    </label>
</form:form>

</body>
</html>