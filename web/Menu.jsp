<%-- 
    Document   : Menu
    Created on : Jul 3, 2018, 2:45:22 PM
    Author     : Windows 10 Version 2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Page</title>
        <link href="CSS/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">

            <%@include file="GENERAL_PAGES/Header.jsp" %>

            <div class="main">
                <div class="container">
                    <div class="left maincontent">
                        <div class="heading"><h3>Menu and Price list</h3></div>
                        
                        <c:forEach items="${products}" var="p">
                            <div class="section">
                                <div class="content">
                                    <table class="table">
                                        <tr>
                                            <th>Menu ${p.getPid()}</th>
                                            <th class="align-right">Price</th>
                                        </tr>
                                        <tr>
                                            <td>${p.getPname()}</td>
                                            <td class="align-right">$${p.getPrice()}</td>
                                        </tr>
                                    </table>
                                    <p>${p.getDesc()}</p>
                                </div>
                            </div>
                        </c:forEach>
                        
                        <div id="pagination">
                            <c:forEach begin="0" end="${requestScope.maxPage - 1}" var="i">
                                <c:set var="page" scope="request" value="${requestScope.page}" />
                                <a href="MenuController?page=${i}" class="<c:out value="${page eq i ? 'nolink' : ''}" />"> ${i+1}</a>
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
