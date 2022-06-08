<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ru">
<head>
    <title>Meals</title>
    <link href="static/css/mealsTable.css" rel="stylesheet" type="text/css">

</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<h4><a href="meal.jsp">Add new meal</a></h4>
<table class="minimalistBlack">
    <thead>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    </thead>
    <c:forEach var="entry" items="${attr1}">
        <c:if test="${entry.value.excess == true}">
            <tr style="color: red">
        </c:if>
        <fmt:parseDate value="${ entry.value.dateTime }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both"/>
        <td><fmt:formatDate value="${parsedDateTime}" pattern="yyyy-MM-dd HH-mm"/></td>
        <td>${entry.value.description}</td>
        <td>${entry.value.calories}</td>
        <td><a href="index.html"> Update</a></td>
        <td><a href="meals?action=delete&id=${entry.key}"> Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>