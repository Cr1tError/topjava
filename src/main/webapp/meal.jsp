<%@ page contentType="text/html;charset=UTF-8" %>

<html lang="ru">
<head>
    <title>Users</title>
    <link href="static/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>New meal</h2>
    <form action="${pageContext.request.contextPath}/meals" method="post">
        <label for = "date"> Date:
            <input class="input-field" type = "datetime-local" id="date" name="date">
        </label><br>
        <label for = "description"> Description:
            <input class="input-field" type = "text" id="description" name="description">
        </label><br>
        <label for = "calories"> Calories:
            <input class="input-field" type = "number" id="calories" name="calories">
        </label><br>
        <input class="input-field" type="submit" value="Add">

    </form>

</body>
</html>