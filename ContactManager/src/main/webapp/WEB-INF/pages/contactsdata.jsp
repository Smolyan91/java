<%--
  Created by IntelliJ IDEA.
  User: igor
  Date: 02.07.17
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Data</title>
</head>
<body>
<a href="../../index.jsp">Back to main</a>
<br/>
<br/>
<br/>
<h1>Contact List</h1>

<c:if test="${!empty listContacts}">
    <table class="tg">
        <tr>
            <th width="70">ID</th>
            <th width="120">Name</th>
            <th width="120">Surname</th>
            <th width="120">Birthday</th>
            <th width="120">Sex</th>
            <th width="120">Phone</th>
            <th width="70">Edit</th>
            <th width="70">Delete</th>
        </tr>
        <c:forEach items="${listContacts}" var="contact">
            <tr>
                <td>${contact.id}</td>
                <td>${contact.name}</td>
                <td>${contact.surname}</td>
                <td>${contact.bithDate}</td>
                <td>${contact.sex}</td>
                <td>${contact.phone}</td>
                <td><a href="<c:url value="/edit" " </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
