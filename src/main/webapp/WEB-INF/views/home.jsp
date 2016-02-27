<%-- 
    Document   : home
    Created on : Feb 6, 2016, 3:48:08 PM
    Author     : Carlos Igreja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html ng-app="app1" >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url var="maincss" value="/resources/css/main.css" />
        <link rel="stylesheet" type="text/css" href="${maincss}" />
        <title>title</title>
    </head>
    <body  ng-controller="ctrl1">

        <!-- HEADER -->
        <div id="header">
            Employee Website
        </div>

        <!-- NAVIGATION -->
        <div id="navigation">
            <ul>
                <li>
                    <a class="{{addNavSelection}}" 
                       ng-click="addEmployeeNavSelection()" 
                       href="">Add Employee</a>
                </li>
                <li>
                    <a class="{{getNavSelection}}" 
                       ng-click="getEmployeeNavSelection()" 
                       href="">Get Employee</a>
                </li>
            </ul>
        </div>

        <!-- ADD EMPLOYEE -->
        <div style="text-align: center;">
            <p><span style="color: red;">${addErrMsg}</span></p>
            <div class="divContainer">
                <div class="divHeader">
                    Add Employee
                    <div class="divBody" >
                        <form action="Add" method="POST">
                            <div style="text-align: center;">
                                <table>

                                    <!-- First Name -->
                                    <tr>
                                        <td>
                                            <label class="divBodyLabel">First Name:</label>
                                        </td>
                                        <td>
                                            <input class="divBodyInput" name="firstName" type="text" required>
                                        </td>
                                    </tr>

                                    <!-- Last Name -->
                                    <tr>
                                        <td>
                                            <label class="divBodyLabel">Last Name:</label>
                                        </td>
                                        <td>
                                            <input class="divBodyInput" name="lastName"  type="text" required>
                                        </td>
                                    </tr>

                                    <!-- ADDRESS -->
                                    <tr>
                                        <td>
                                            <label class="divBodyLabel">Address:</label>
                                        </td>
                                        <td>
                                            <input class="divBodyInput" name="address"  type="text" required>
                                        </td>
                                    </tr>

                                    <!-- Salary -->
                                    <!--
                                    <tr>
                                        <td>
                                            <label class="divBodyLabel">Salary:</label>
                                        </td>
                                        <td>
                                            <input class="divBodyInput" name="salary" type="number" required>
                                        </td>
                                    </tr> 
                                    -->
                                </table>
                            </div>
                            <input type="submit" value="Submit">
                        </form>
                    </div>
                </div>
            </div>
        </div>

    <!-- GET EMPLOYEE --> 
    <center>
        <p><span style="color: red;">${getErrMsg}</span></p>
        <div class="divContainer">
            <div class="divHeader">
                Get Employee Addresses
                <div class="divBody" >
                    <form action="Get" method="POST">
                        <center>
                            <table>

                                <!-- First Name -->
                                <tr>
                                    <td>
                                        <label class="divBodyLabel">First Name:</label>
                                    </td>
                                    <td>
                                        <input class="divBodyInput" name="firstName" type="text" required>
                                    </td>
                                </tr>

                                <!-- Last Name -->
                                <tr>
                                    <td>
                                        <label class="divBodyLabel">Last Name:</label>
                                    </td>
                                    <td>
                                        <input class="divBodyInput" name="lastName"  type="text" required>
                                    </td>
                                </tr>
                            </table>
                            <input type="submit" value="Submit" />
                        </center>
                    </form>
                </div>
            </div>
        </div>
    </center>

    <!-- EMPLOYEE ADDRESSES --> 
    <c:if test=" ${addresses} == null">
        <center>
            <div class="divContainer">
                <div class="divHeader">
                    Employee Addresses
                    <div class="divBody" >
                        <c:forEach var="address" items="${addresses}">
                            <p><c:out value="${address.address}" /></p>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </center>
    </c:if>
    
    <!-- ANGULAR JS IMPORT -->
    <script 
    src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.min.js">
    </script>
    <c:url var="angularjs" value="/resources/js/angular.js" />
    <script src="${angularjs}"></script>
</body>
</html>
