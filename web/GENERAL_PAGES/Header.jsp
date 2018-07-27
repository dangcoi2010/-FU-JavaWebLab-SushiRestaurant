<%-- 
    Document   : Header
    Created on : Jul 3, 2018, 2:48:15 PM
    Author     : Windows 10 Version 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header Page</title>
        <link href="../CSS/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header">
                <div class="container">
                    <!-- tittle -->
                    <div class="title-wrapper">
                        <div class="title "> <a class="title" href="">The Sushi Restaurant</a> </div>
                        <div class="subtitle">Welcome to this website</div>
                    </div>

                    <div class="menu">
                        <ul class="nav">
                            <li class="${requestScope.active eq "home" ? 'active' : ''}">
                                <a href="HomepageController">Home</a>
                            </li><li class="${requestScope.active eq "menu" ? 'active' : ''}">
                                <a href="MenuController">Menu and Price list</a>
                            </li><li class="${requestScope.active eq "findus" ? 'active' : ''}">
                                <a href="ContactController">Find us</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
    </body>
</html>
