<%--
  Created by IntelliJ IDEA.
  User: insania
  Date: 2019-04-20
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wrong password</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-blue">
<div class="w3-container w3-blue w3-opacity w3-right-align">
    <h1>You entered wrong password!</h1>
</div>
<div class="w3-container w3-center">
    <div class="w3-bar w3-padding-large w3-padding-24">
        <button class="w3-btn w3-hover-blue w3-round-large" onclick="location.href='/registration'">Register new account</button><br /><br />
        <button class="w3-btn w3-hover-blue w3-round-large" onclick="location.href='/login'">Try again</button><br /><br />
    </div>
</div>
</body>
</html>