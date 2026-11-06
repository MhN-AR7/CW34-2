<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 11/6/2026
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Add Book Form</title>
</head>
<body>

<h2>Adding New Book</h2>

<hr>

<form action="${pageContext.request.contextPath}/books/add" method="post">
    <label>
        Title:
        <input name="title" type="text" placeholder="Enter book's title" required>
    </label>

    <label>
        Author:
        <input name="author" type="text" placeholder="Enter book's author" required>
    </label>

    <label>
        Published Year:
        <input name="publishedYear" type="number" min="1850" placeholder="Enter book's published year" required>
    </label>

    <button type="submit">Add</button>
</form>

</body>
</html>
