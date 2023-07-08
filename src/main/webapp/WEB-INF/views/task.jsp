<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add User</title>

    <style>
        .error {
            color: red;
        }
    </style>

</head>
<body>

<form:form method="post" action="/addtask" modelAttribute="task">
    <form:hidden path="user" />
    <label>
        Podaj swój cel: <br>
        <form:textarea path="generalPurpose"/><form:errors path="generalPurpose" cssClass="error"/>
    </label>
    <label>
        Jaki jest pierwszy krok: <br>
        <form:textarea path="firstStep"/><form:errors path="firstStep" cssClass="error"/>
    </label>
    <label>
        Jaki jest drugi krok: <br>
        <form:textarea path="secondStep"/><form:errors path="secondStep" cssClass="error"/>
    </label>
    <label>
        <input type="submit" value="Dodaj zadanie">
    </label>
    <label>
        <input type="reset" value="Usuń wartości">
    </label>

</form:form>

</body>
</html>