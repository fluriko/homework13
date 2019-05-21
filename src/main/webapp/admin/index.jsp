<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BunnyLand.fur</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-blue">

<div class="w3-container w3-blue w3-opacity w3-right-align">
    <h2>Admin  <c:out value="${user.login}"/>, we are glad to see you in BunnyLand!</h2>
    <button class="w3-btn w3-hover-blue w3-round-large" onclick="location.href='/user/profile'">My profile</button>
    <button class="w3-btn w3-hover-blue w3-round-large" onclick="location.href='/logout'">Log out</button>
    <h3><c:out value="${message}"/></h3>
</div>
<br /><br />
    <div class="w3-container w3-center">
        <div class="w3-bar w3-padding-large w3-padding-24">
            <button class="w3-btn w3-hover-blue w3-round-large" onclick="location.href='/admin'">Admin page</button><br /><br />
        </div>
        <div class="w3-container w3-center">
            <button class="w3-btn w3-round-large" onclick="location.href='/user/goods'">Catalog of goods</button><br /><br />
        </div>

    <div class="w3-container w3-center">
        <h2>Some special content for admin</h2> <br />
        Secret information <br />
        And more...<br />
        And more <br /><br /><br />
    </div>
</div>
</body>
</html>
