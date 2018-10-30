<%-- 
    Document   : showusers
    Created on : Nov 23, 2016, 5:48:35 PM
    Author     : Thomas Hartmann - tha@cphbusiness.dk
--%>

<%@page import="domain.User, java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            th, td{
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <h1>Show users!</h1>
        <table>  
            <tr>
                <th>ID</th>
                <th>Username</th>
            <tr>
                <%
                    if (session.getAttribute("username") == null) {
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                        return;
                    }
                %>   
                <% List<User> users = (List<User>) session.getAttribute("users");
                    for (User user : users) {
                        out.println("<tr><td>" + user.getId() + "</td><td>" + user.getUsername() + "</td></tr>");
                    }
                %>
            
        </table>
                <form action="Login" method="POST">
                <input type="hidden" name="origin" value="logout" >
                <input type="submit" value="Logout">
            </form>
    </body>
</html>
