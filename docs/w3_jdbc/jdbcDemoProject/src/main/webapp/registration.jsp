<%-- 
    Document   : registration
    Created on : Nov 20, 2017, 8:19:56 PM
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
       <%
       String error = (String)request.getAttribute("error");
       if(error!=null){
           out.println(error);
       %>
       Hov hov der var en fejl i din indtastning...
        <%
       }
       %>
       <form>
           dssfsdf
       </form>
    </body>
</html>
