<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<c:if test="${!empty contactList}">
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
        <c:forEach items="${contactList}" var="contact">
            <tr>
                <td>${contact.id}</td>
                <td>${contact.name}</td>
                <td>${contact.surname}</td>
                <td>${contact.bithDate}</td>
                <td>${contact.sex}</td>
                <td>${contact.phone}</td>
                <td><a href="<c:url value="/edit/${contact.id}"/>">Edit</a></td>
                <td><a href="<c:url value="/remove/${contact.id}"/>">Remove</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add cont</h1>
<c:url var="addAction" value="/contacts/add" />

</body>
</html>
