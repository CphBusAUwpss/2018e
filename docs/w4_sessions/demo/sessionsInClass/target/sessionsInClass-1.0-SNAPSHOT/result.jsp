<%-- 
    Document   : result
    Created on : Nov 27, 2017, 5:37:45 PM
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
        <h1>Hello <%= session.getAttribute("username")%></h1>
    </body>
</html>
