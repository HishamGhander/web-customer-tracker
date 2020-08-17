<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Hesham
  Date: 8/17/2020
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Form</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>
<div id="container">
    <h3>Save Customer</h3>

    <form:form action="saveCustomer" modelAttribute="customer" method="post">
        <table>
            <tbody>
            <tr>
                <td>First Name</td>
                <td><form:input type="text" path="firstName" placeholder="First Name"/></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><form:input type="text" path="lastName" placeholder="Last Name"/></td>
            </tr>
            <tr>
                <td>First Name</td>
                <td><form:input type="text" path="email" placeholder="Email"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" class="save" value="Save"></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <a href="${pageContext.request.contextPath}/customer/list">Back To Customer Page</a>
</div>
</body>
</html>
