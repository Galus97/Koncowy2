<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>

</head>
<body>

<h1>TASK MANAGER - DON'T PROCRASTINAION</h1>
<h2>
    Witaj <c:out value="${data.firstName}"/>
</h2>
<h2>
    Dzienna liczba zadań do zrobienia: <c:out value="${data.goal}"/>
</h2>

<label>
    <a href="/addtask">Dodaj nowe zadanie</a> <br>
</label>
<label>
    <a href="/personaldata">Uzupełnij swoje dane osobowe</a> <br>
</label>
<label>
    <a href="/finishedTasks">Historia wykonanych działań</a> <br>
</label>



    <h2>Lista Zadań:</h2>
    <ul>
        <c:forEach var="task" items="${tasks}">
            <li>
                <a href="/taskdetails?id=${task.id}">${task.firstStep}</a>
            </li>
        </c:forEach>
    </ul>

<a href="/logout">Wyloguj</a>

</body>
</html>
