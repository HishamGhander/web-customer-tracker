<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Hesham
  Date: 7/27/2020
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customers</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Management</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <input type="button" class="add-button" onclick="window.location.href='showFormForAdd'; return false;"
               value="Add Customer"/>
        <form:form method="get" action="search">
            Search Customer: <input type="text" name="theSearchName"/>
            <input type="submit" value="Search" class="add-button"/>
        </form:form>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            <c:forEach var="customer" items="${customers}">

                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${customer.id}"></c:param>
                </c:url>

                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${customer.id}"></c:param>
                </c:url>
                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this customer'))) return false;">| Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
