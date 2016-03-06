<%-- 
    Document   : home
    Created on : Feb 6, 2016, 3:48:08 PM
    Author     : Carlos Igreja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html ng-app="app1">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <meta name="viewport" content="width = device-width, initial-scale = 1">

    <title>BOOTSTRAP</title>

    <!-- BOOTSTRAP CSS LINK -->
    <c:url var="bootstrapcss" value="/resources/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="${bootstrapcss}"/>

    <!-- MAIN CSS LINK -->
    <c:url var="maincss" value="/resources/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="${maincss}"/>

</head>
<body ng-controller="ctrl1">

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
<div id="addEmployeeDiv" style="text-align: center;">
    <p><span id="addMsg" style="color: red;"></span></p>
    <div class="divContainer">
        <div class="divHeader">
            Add Employee
            <div class="divBody">
                <form id="addEmployeeForm">
                    <div style="text-align: center;">
                        <table>

                            <!-- First Name -->
                            <tr>
                                <td>
                                    <label class="divBodyLabel">First Name:</label>
                                </td>
                                <td>
                                    <input id="addFirstName" class="divBodyInput" name="firstName" type="text" required>
                                </td>
                            </tr>

                            <!-- Last Name -->
                            <tr>
                                <td>
                                    <label class="divBodyLabel">Last Name:</label>
                                </td>
                                <td>
                                    <input id="addLastName" class="divBodyInput" name="lastName" type="text" required>
                                </td>
                            </tr>

                            <!-- ADDRESS -->
                            <tr>
                                <td>
                                    <label class="divBodyLabel">Address:</label>
                                </td>
                                <td>
                                    <input id="address" class="divBodyInput" name="address" type="text" required>
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
                    <input type="reset" value="Clear">
                    <input id="addBtn" type="submit" value="Submit">
                </form>
            </div>
        </div>
    </div>
</div>

<!-- GET EMPLOYEE -->
<center>
    <p><span style="color: red;">${getErrMsg}</span></p>
    <div id="getEmployeeDiv" class="divContainer">
        <div class="divHeader">
            Get Employee Addresses
            <div class="divBody">
                <form id="getEmployeeForm">
                    <center>
                        <table>

                            <!-- First Name -->
                            <tr>
                                <td>
                                    <label class="divBodyLabel">First Name:</label>
                                </td>
                                <td>
                                    <input id="getFirstName" class="divBodyInput" name="firstName" type="text" required>
                                </td>
                            </tr>

                            <!-- Last Name -->
                            <tr>
                                <td>
                                    <label class="divBodyLabel">Last Name:</label>
                                </td>
                                <td>
                                    <input id="getLastName" class="divBodyInput" name="lastName" type="text" required>
                                </td>
                            </tr>
                        </table>
                        <input id="getBtn" type="submit" value="Submit"/>
                    </center>
                </form>
            </div>
        </div>
    </div>
</center>

<!-- EMPLOYEE ADDRESSES -->
<c:if test=" ${addresses eq null} ">
    <center>
        <div id="displayAddressesDiv" class="divContainer">
            <div class="divHeader">
                Employee Addresses
                <div class="divBody">
                    <c:forEach var="address" items="${addresses}">
                        <p><c:out value="${address.address}"/></p>
                    </c:forEach>
                </div>
            </div>
        </div>
    </center>
</c:if>

<!-- ADDRESSES TEST -->
<center>
    <div id="displayAddressesDivTest" class="divContainer">
        <div class="divHeader">
            Employee Addresses
            <div class="divBody">
                <p>create the json method and come back</p>
            </div>
        </div>
    </div>
</center>

<!-- NEW BOOTSTRAP DIV FOR DISPLAYING EMPLOYEES -->
<div class="container">
    <div class="page-header">
        <h1>Get Employee</h1>
    </div>

    <table class="table table-inverse">
        <thead>
        <tr>
            <th>#</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
            <td>@fat</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>Larry</td>
            <td>the Bird</td>
            <td>@twitter</td>
        </tr>
        </tbody>
    </table>
</div>

<!-- BOOTSTRAP JS -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<!-- JQUERY IMPORT CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js">
</script>

<!-- AJAX SCRIPT -->
<c:url var="ajaxjs" value="/resources/js/ajax.js"/>
<script src="${ajaxjs}"></script>

<!-- ANGULAR JS IMPORT -->
<script
        src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.min.js">
</script>

<!-- ANGULAR JS SCRIPT -->
<c:url var="angularjs" value="/resources/js/angular.js"/>
<script src="${angularjs}"></script>

</body>
</html>
