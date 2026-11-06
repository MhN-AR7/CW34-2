<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 11/6/2026
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>

<h2>Book List</h2>

<hr>

<table border="2px">
<thead>
<tr>
    <th>ID</th>
    <th>Title</th>
    <th>Author</th>
    <th>Published Year</th>
</tr>
</thead>

<tbody>
<c:forEach var="book" items="${books}">
    <tr>
        <th>${book.id}</th>
        <th>${book.title}</th>
        <th>${book.author}</th>
        <th>${book.publishedYear}$</th>
    </tr>
</c:forEach>
</tbody>
</table>

<hr>

<a href="${pageContext.request.contextPath}/books/add">Add Book</a>

</body>
</html>
