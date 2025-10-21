<%--
  Created by IntelliJ IDEA.
  User: Judit
  Date: 2025. 10. 03.
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Hallgatoink</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<c:if test="${empty hallgatok}">
    Nincs hallgatonk, kérlek adj hozzá!
</c:if>
<c:if test="${!empty hallgatok}">
Hallgatoink.
<table>
    <tr>
        <th>Név:</th>
        <th>Neptun Kod:</th>
        <th>Email cím:</th>
        <th></th>
    </tr>
    <c:forEach items="${hallgatok}" var="hallgato">
        <tr>
            <td>${hallgato.teljesNev}</td>
            <td>${hallgato.neptunKod}</td>
            <td>${hallgato.email}</td>
            <td><i onclick="window.location = '${pageContext.servletContext.contextPath}/updateHallgato/${hallgato.neptunKod}';" class="fa-solid fa-pen-to-square"></i><i onclick="window.location = '${pageContext.servletContext.contextPath}/hallgato/${hallgato.neptunKod}';" class="fa-solid fa-eye"></i>  </td>
        </tr>
    </c:forEach>
</table>
</c:if>


<h1><a href="${pageContext.request.contextPath}/ujHallgato">Új hozzáadása:</a></h1>
</body>
</html>
