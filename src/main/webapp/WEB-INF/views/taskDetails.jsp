<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <title>Task Details</title>

</head>
<body>

    <h2>
        <c:out value="${task.generalPurpose}"/>
    </h2>
    <li>
        <c:out value="${task.firstStep}"/>
    </li>
    <li>
        <c:out value="${task.secondStep}"/>
    </li>
    <a href="/addtask?edit=true&id=${task.id}">Edytuj zadanie</a>
    <a href="/deleteTask?id=${task.id}">Usuń zadanie</a>
    <a href="/finishTask/${task.id}">Wykonane</a>

</body>
</html>