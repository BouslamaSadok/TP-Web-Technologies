<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<html>
    <head>
        <title>Young People</title>
    </head>
    <body>
        <h1>Welcome! You were born in 1990 or after.</h1>
        <jsp:useBean id="person" type="lab.mvc.model.Person" scope="request"/>
        <h2>Person Information</h2>
        <p> FirstName:
            <jsp:getProperty name="person" property="firstName"/>
        </p>
        <p> LastName:
            <jsp:getProperty name="person" property="lastName"/>
        </p>
        <p> BirthDay:
            <jsp:getProperty name="person" property="birthDay"/>    
        </p>
        <p> Sex:
            <jsp:getProperty name="person" property="sex"/>
        </p>

    </body>
</html>