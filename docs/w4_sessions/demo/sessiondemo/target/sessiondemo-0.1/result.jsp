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
        <h1>RESULT!</h1>
        Username taget fra session objektet: <% out.print(session.getAttribute("username"));  %><br>
        Message taget fra hidden felt og overført med request objektet: <% out.print(request.getAttribute("msg1")); %><br>
        Message taget fra url parametre og overført med request objektet: <% out.print(request.getAttribute("msg2")); %><br>
    </body>
</html>
