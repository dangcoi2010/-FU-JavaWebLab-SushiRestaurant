<%-- 
    Document   : ViewList
    Created on : Jul 9, 2018, 8:15:33 PM
    Author     : Windows 10 Version 2
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Product</title>
        <link href="CSS/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">

            <%@include file="GENERAL_PAGES/Header.jsp" %>

            <div class="main">
                <div class="container">
                    <div class="left maincontent">
                        <div class="heading"><h3></h3></div>

                        <div class="section">
                            <div class="heading"><h3>${product.getPname()}</h3></div>
                            <div class="content">
                                <div class="image"><img src="${product.getImage()}"/></div>
                                <p>
                                    <span>
                                        ${product.getDesc()}
                                    </span>
                                </p>
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
