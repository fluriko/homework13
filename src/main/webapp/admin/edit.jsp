<%--
  Created by IntelliJ IDEA.
  User: insania
  Date: 2019-04-24
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit user</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-blue">
<div class="w3-container w3-blue w3-opacity w3-right-align">
    <h9>Admin <c:out value="${user.login}"/>
        <button class="w3-btn w3-hover-blue w3-round-large" onclick="location.href='/user/profile'">My profile</button>
        <button class="w3-btn w3-hover-blue w3-round-large" onclick="location.href='/logout'">Log out</button>
    </h9>
</div>
<form method="post" class="w3-selection w3-light-blue w3-padding">
    <h3>Enter new data for user: <c:out value="${userToEdit.id}"/> </h3>
    <h7><c:out value="${violations}"/></h7><br /><br />
    <label> login:
        <input type="text" name="login" value = "<c:out value="${userToEdit.login}"/>" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br /><br />
    </label>
<label> password:
    <input type="password" name="password" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br /><br />
</label>
    <label> mail:
        <input type="text" name="mail" value = "<c:out value="${userToEdit.mail}"/>" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br /><br />
    </label>
    <label>Set role:</label><br /><br />
<c:forEach items="${roles}" var="role">
    <input type="radio" name="role" value="<c:out value="${role.id}"/>">   <c:out value="${role.name}"/><br /><br />
</c:forEach>
    <input type="radio" name="role"
           value="<c:out value="${userToEdit.role.id}"/>" checked>
    <c:out value="${userToEdit.role}"/><br /><br />
    <button type="submit" class="w3-btn w3-blue w3-round-large w3-margin-bottom">Submit</button>
</form>
<button class="w3-btn w3-hover-blue w3-round-large" onclick="location.href='/admin/list'">Back to user list</button>
<button class="w3-btn w3-hover-blue w3-round-large" onclick="location.href='/admin'">Back to admin page</button>
<button class="w3-btn w3-round-large" onclick="location.href='/main'">Back to main</button>
</body>
</html>
