
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Scriptlet JSP</title>
</head>
<body>

    <h1>Scriptlet Example</h1>

    <%
        java.util.Date currentDate = new java.util.Date();
        String host = request.getRemoteHost();
    %>

    <p>Current time: <%= currentDate %></p>

    <p>Server's IP address: <%= host %></p>

</body>
</html>
