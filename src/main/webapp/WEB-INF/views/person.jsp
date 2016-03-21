<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MVC 1.0 Demo Application</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/5.0.0/css/foundation.css">

</head>
<body style="padding: 40px;">

<div class="row">
    <div class="column large-5 large-push-1">
        <form action="/mvc/app/person" method="post">
            <input type="text" name="name" placeholder="Name">
            <input type="text" name="surname" placeholder="Surname">
            <input type="number" name="age" placeholder="Age">
            <input type="hidden" name="${mvc.csrf.name}" value="${mvc.csrf.token}"/>
            <button class="button" type="submit">Send</button>
        </form>
    </div>
    <div class="column large-5 large-pull-1">
        <table style="width: 100%;">
            <thead>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Age</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="person" items="${personList}">
                <tr>
                    <td>${person.name}</td>
                    <td>${person.surname}</td>
                    <td>${person.age}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<ul>
    <c:forEach var="message" items="${messages}">
        <li>${message}</li>
    </c:forEach>
</ul>
</body>
</html>
