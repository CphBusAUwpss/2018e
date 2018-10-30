<%-- 
    Document   : products
    Created on : Nov 27, 2017, 6:30:03 PM
    Author     : tha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, domain.Product" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, th, td{
                border: solid 1px red;
            }
        </style>
    </head>
    <body>
        <%
        if(session.getAttribute("username")==null){
//         Boolean b = (Boolean)session.getAttribute("boolean");
//        if(b){
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
        %>
        <div>Logged in as: <%= session.getAttribute("username") %> boolean: <%=session.getAttribute("boolean") %> integer: <%=session.getAttribute("integer") %></div>
       <%
           out.println("<table><thead><tr><th>Image</th><th>ID</th><th>Product name</th><th>Price</th></tr></thead>");
           List<Product> products = (List<Product>)session.getAttribute("products");
           for(Product product: products){
               out.println("<tr><td><img src=\"img/"+product.getImage()+"\"></td><td>"+product.getId()+"</td><td>"+product.getName()+"</td><td>"+product.getPrice()+"</td></tr>");
           }
           out.println("</table>");
       %>
       
    </body>
</html>
