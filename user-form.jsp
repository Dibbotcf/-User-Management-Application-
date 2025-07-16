<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>User Form</title></head>
<body>
<h2>${user == null ? "Add User" : "Edit User"}</h2>
<form action="${user == null ? 'insert' : 'update'}" method="post">
    <input type="hidden" name="id" value="${user != null ? user.id : ''}" />
    Name: <input type="text" name="name" value="${user != null ? user.name : ''}" required /><br/>
    Email: <input type="email" name="email" value="${user != null ? user.email : ''}" required /><br/>
    Country: <input type="text" name="country" value="${user != null ? user.country : ''}" required/><br/>
    <input type="submit" value="${user == null ? 'Add' : 'Update'}" />
</form>
<a href="list">Back to User List</a>
</body>
</html>
