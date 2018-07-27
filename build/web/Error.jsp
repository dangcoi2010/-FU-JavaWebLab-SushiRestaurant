<%-- 
    Document   : Error
    Created on : Jul 3, 2018, 2:48:51 PM
    Author     : Windows 10 Version 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR page</title>
        <link href="CSS/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">

            <%@include file="GENERAL_PAGES/Header.jsp" %>

            <div class="main">
                <div class="container">
                    <div class="left maincontent">

                        <!-- Article -->
                        <div class="section">
                            <div class="heading"><h3 class="">ERROR</h3></div>
                            <div class="content">
                                Some errors happening!
                            </div>
                        </div>
                    </div>
                    <!-- side bar -->
                    <%@include file="GENERAL_PAGES/Sidebar.jsp" %>
                </div>
            </div>

            <%@include file="GENERAL_PAGES/Footer.jsp" %>
        </div>
    </body>
</html>
