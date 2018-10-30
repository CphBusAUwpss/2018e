<%-- 
    Document   : login
    Created on : Nov 20, 2017, 7:47:21 PM
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
        <form action="Login" method="POST">
            <input type="text" name="username" placeholder="user name"/><br/>
            <input type="text" name="password" placeholder="password"/><br/>
            <input type="submit" value="Login"/><br/>
        </form>
    </body>
</html>
