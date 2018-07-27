<%-- 
    Document   : index
    Created on : Jul 5, 2018, 11:08:07 PM
    Author     : Windows 10 Version 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%request.getRequestDispatcher("HomepageController").forward(request, response);%>
    </body>
</html>
