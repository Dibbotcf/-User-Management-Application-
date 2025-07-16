<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>User List</title></head>
<body>
<h2>Users</h2>
<a href="new">Add New User</a>
<table border="1" cellpadding="5" cellspacing="0">
    <tr><th>Name</th><th>Email</th><th>Country</th><th>Actions</th></tr>
    <c:forEach var="user" items="${listUser}">
        <tr>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td>
                <a href="edit?id=${user.id}">Edit</a> | 
                <a href="delete?id=${user.id}" onclick="return confirm('Are you sure?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
