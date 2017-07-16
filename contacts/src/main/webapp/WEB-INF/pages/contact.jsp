<%--
  Created by IntelliJ IDEA.
  User: igor
  Date: 15.07.17
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.title" /></title>
</head>
<body>
<%--<a href="<c:url value="/logout"/>"> <spring:message code="label.logout"/> </a>--%>
<form:form method="post" action="add" commandName="contact">
    <table>
        <tr>
            <td><form:label path="firstname"><spring:message code="label.firstname"/> </form:label></td>
            <td><form:input path="NAME"/></td>
        </tr>
        <tr>
            <td><form:label path="lastname">
                <spring:message code="label.lastname" />
            </form:label></td>
            <td><form:input path="SNAME" /></td>
        </tr>
        <tr>
            <td><form:label path="email">
                <spring:message code="label.email" />
            </form:label></td>
            <td><form:input path="EMAIL" /></td>
        </tr>
        <tr>
            <td><form:label path="telephone">
                <spring:message code="label.telephone" />
            </form:label></td>
            <td><form:input path="PHONE" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="<spring:message code="label.addContact"/>" /></td>
        </tr>
    </table>
</form:form>
<h3><spring:message code="label.contacts"/></h3>
<c:if test="${!empty contactList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.firstname" /></th>
            <th><spring:message code="label.email" /></th>
            <th><spring:message code="label.telephone" /></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${contactList}" var="contact">
            <tr>
                <td>${contact.SNAME}, ${contact.NAME}</td>
                <td>${contact.EMAIL}</td>
                <td>${contact.PHONE}</td>
                <td><a href="delete/${contact.ID}"><spring:message code="label.delete" /></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
