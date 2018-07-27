<%-- 
    Document   : Findus
    Created on : Jul 3, 2018, 2:45:37 PM
    Author     : Windows 10 Version 2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find us page</title>
        <link href="CSS/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">

            <%@include file="GENERAL_PAGES/Header.jsp" %>

            <div class="main">
                <div class="container">
                    <div class="left maincontent">
                        <!-- Article -->
                        <div class="heading"><h3>Find us</h3></div>
                        <div class="section">

                            <div class="content">
                                <div class="span6">
                                    <div class="item">
                                        <div class="heading">
                                            <h4>Address and Contact:</h4>
                                        </div>
                                        <div class="content">
                                            <div class="country">
                                                <p>The Sushi Restaurant <br>
                                                    ${contact.getAddress()}
                                                </p>

                                            </div>
                                            <br>
                                            <div class="span3">
                                                Tel:<a href="tel:(555)-8547-268">
                                                    ${contact.getTelephone()}
                                                </a>
                                            </div> 
                                            <div class="span3">
                                                Email:
                                                <a href="mailto:info@ilcantodelamore.co.uk">
                                                    ${contact.getEmail()}
                                                </a>
                                            </div>   
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="item">
                                        <div class="heading">
                                            <h4>Opening hours:</h4>
                                        </div>
                                        <div class="content">
                                            <p>
                                                <c:forEach items="${time}" var="oh">
                                                    ${oh.getDayInWeek()}
                                                    ${(oh.isIsActive() == true ? oh.getOpenTime() : '')} - 
                                                    ${(oh.isIsActive() == true ? oh.getCloseTime() : '')} 
                                                    ${(oh.isIsActive() == true ? '' : 'Closed')}<br>
                                                </c:forEach>
                                            </p>
                                        </div>
                                    </div>
                                </div>

                            </div>

                        </div>
                        <div class="article">
                            <div class="content">
                                <div class="image"><a href="#"><img src="${requestScope.map}"/></a></div>
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
