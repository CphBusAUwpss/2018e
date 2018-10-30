<%-- 
    Document   : cookiebased
    Created on : Nov 23, 2016, 9:51:48 AM
    Author     : Thomas Hartmann - tha@cphbusiness.dk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% session.setAttribute("username", "SuperOverAdmin"); %>
        <form action="SessionDemoServlet" method="POST">
            <input type="hidden" name="origin" value="cookiebased">
            <input type="submit" value="Go to servlet">
        </form>
        <h1>Hello World!</h1>
    </body>
</html>
