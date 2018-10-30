<%-- 
    Document   : login
    Created on : Nov 27, 2017, 6:20:03 PM
    Author     : tha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ´<h1>Login here</h1>
        <form action="Control" method="POST">
            <input type="text" name="username"/>
            <input type="text" name="password"/>
            <input type="hidden" name="origin" value="login"/>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
