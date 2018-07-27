<%-- 
    Document   : homepage
    Created on : May 15, 2018, 8:08:35 PM
    Author     : Windows 10 Version 2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/default.css" rel="stylesheet" type="text/css"/>
        <title>Home Page</title>
    </head>
    <body>
        <div class="wrapper">

            <%@include file="GENERAL_PAGES/Header.jsp" %>

            <div class="main">
                <div class="container">
                    <div class="left maincontent">

                        <!-- Article -->
                        <div class="article">
                            <div class="heading"></div>
                            <div class="content">
                                <div class="image"><a href="#"><img src="${requestScope.banner}"/></a></div>
                            </div>
                        </div>
                        <c:forEach items="${products}" var="p">
                            <div class="section">
                                <div class="heading">
                                    <h3>
                                        <a href="ViewDetailController?pid=${p.getPid()}">
                                            ${p.getPname()}
                                        </a>
                                    </h3>
                                </div>
                                <div class="content">
                                    <div class="image">
                                        <a href="ViewDetailController?pid=${p.getPid()}">
                                            <img src="${p.getImage()}"/>
                                        </a>
                                    </div>
                                    <p>
                                        <span>
                                            ${p.getDesc()}
                                        </span>
                                    </p>
                                </div>
                            </div>
                        </c:forEach>

                        <div id="pagination">
                            <c:forEach begin="0" end="${requestScope.maxPage - 1}" var="i">
                                <c:set var="page" scope="request" value="${requestScope.page}" />
                                <a href="HomepageController?page=${i}" class="<c:out value="${page eq i ? 'nolink' : ''}" />"> ${i+1}</a>
                            </c:forEach>
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