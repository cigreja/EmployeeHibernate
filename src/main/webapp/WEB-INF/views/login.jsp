<%-- 
    Document   : login
    Created on : Feb 21, 2016, 4:55:38 PM
    Author     : Carlos Igreja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url var="maincss" value="/resources/css/main.css" />
        <link rel="stylesheet" type="text/css" href="${maincss}" />
        <title>Login</title>
    </head>
    <body>
        <div style="text-align: center;">
            <span style="color: red;">${errorMsg}</span><br/>
            <div class="divContainer">
                <div class="divHeader">
                    Login
                    <div class="divBody" >
                        <form action="Login" method="post">
                            <div style="text-align: center;">
                                <table>
                                    <!-- ID -->
                                    <tr>
                                        <td>
                                            <label class="divBodyLabel">Username : </label>
                                        </td>
                                        <td>
                                            <input class="divBodyInput" name="username" type="text" required>
                                        </td>
                                    </tr>
                                    <!-- First Name -->
                                    <tr>
                                        <td>
                                            <label class="divBodyLabel">Password : </label>
                                        </td>
                                        <td>
                                            <input class="divBodyInput" name="password" type="password" required>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <input type="submit" value="Submit">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
