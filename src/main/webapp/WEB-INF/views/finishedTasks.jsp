<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <title>Finished Tasks</title>
</head>
<body>
<h2>Historia wykonanych działań:</h2>
<ul>
    <c:forEach var="finishedTask" items="${finishedTasks}">
        <li>
            <c:out value="${finishedTask.generalPurpose}"/>
        </li>
    </c:forEach>
</ul>

<a href="/home">Powrót do strony głównej</a>
</body>
</html>