<%@ page import="dev.overlax.booker.util.TimeUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<hr>
<h2>Books</h2>
<hr>
<br><br>
<form action="books" method="post">
    <table>
        <tr>
            <th>Description</th>
            <th>Pages</th>
            <th>Current page</th>
        </tr>
        <tr>
            <input type="hidden" name="id" value="${param.id ne null ? param.id : ''}">

            <td>
                <input type="text" name="description" value="${param.description ne null ? param.description : ''}"
                       required>
            </td>

            <input type="hidden" name="addTime" id="${param.addTime ne null ? param.addTime : ''}">

            <td>
                <input type="number" min="0" name="pages" value="${param.pages ne null ? param.pages : ''}" required>
            </td>

            <td>
                <input type="number" min="0" max="${param.pages}" name="currentPage"
                       value="${param.currentPage ne null ? param.currentPage : ''}">
            </td>
        </tr>
    </table>
    <div class="saveButton">
        <button type="submit">Save</button>
    </div>
</form>
<br>
<table>
    <thead>
    <tr>
        <th>Adding time</th>
        <th>Last edit</th>
        <th>Description</th>
        <th>Pages</th>
        <th>Current page</th>
        <th>Progress</th>
        <th colspan="2">Actions</th>
    </tr>
    </thead>
    <c:forEach items="${books}" var="book">
        <jsp:useBean id="book" type="dev.overlax.booker.model.BookTo"/>
        <tr class="${book.progress < 50 ? 'fifteen' : book.progress < 100 ? 'seventeen' : 'done'}">
            <td><%=TimeUtil.toString(book.getAddTime())%>
            </td>
            <td><%=TimeUtil.toString(book.getEditTime())%>
            </td>
            <td>${book.description}</td>
            <td>${book.pages}</td>
            <td>${book.currentPage}</td>
            <td>${book.progress}%</td>
            <td>
                <button onclick="location.href='books?action=edit&id=${book.id}&addTime=${book.addTime}&description=${book.description}&pages=${book.pages}&currentPage=${book.currentPage}'"
                        type="button">
                    Edit
                </button>
            </td>
            <td>
                <button onclick="location.href='books?action=delete&id=${book.id}'" type="button">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
