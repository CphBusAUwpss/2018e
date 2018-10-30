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
            <input type="text" name="username" placeholder="username"/>
            <input type="text" name="password" placeholder="password"/>
            <input type="text" name="email" placeholder="email"/>
            <input type="hidden" name="origin" value="register"/>
            <input type="submit" value="Register"/>
        </form>
    </body>
</html>
