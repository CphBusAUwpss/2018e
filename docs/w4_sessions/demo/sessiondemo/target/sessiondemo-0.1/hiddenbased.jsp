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
        <h1>Hiddenbased state</h1>
        <form action="SessionDemoServlet" method="POST">
            <input type="hidden" name="origin" value="hiddenbased" />
            <input type="text" name="username" placeholder="Skriv brugenavn her"/>
            <input type="submit" value="Gå til SessionDemoServlet" />
        </form>
    </body>
</html>
