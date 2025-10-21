<%--
  Created by IntelliJ IDEA.
  User: Judit
  Date: 2025. 10. 03.
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Új hallgato felvitele</title>
</head>
<body>

<h2>Hallgato adatai:</h2>
<c:if test="${!empty message}">
    <h1>${message}</h1></c:if>

<form:form method="post" action="ujHallgato" modelAttribute="hallgato">
    <fieldset>
        <legend>Azonosítok</legend>
        <form:label path="neptunKod">Neptun kod:</form:label>
        <form:input path="neptunKod" type="text"/>
        <form:errors path="neptunKod"></form:errors>
    </fieldset>
    <br>
    <fieldset>
        <legend>Alap adatok</legend>
        <form:label path="teljesNev">Teljes név:</form:label>
        <form:input path="teljesNev" />
        <form:errors path="teljesNev"></form:errors>
        <br>
        <form:label path="email">Email cím:</form:label>
        <form:input path="email" />
        <form:errors path="email"></form:errors>
        <br>
        <form:label path="szuletesiDatum" >Születési dátum:</form:label>
        <form:input path="szuletesiDatum" type="date"/>
        <form:errors path="szuletesiDatum"></form:errors>
        <br>
        <form:label path="nem">Nem:</form:label>
        <form:select path="nem" >
            <form:options/>
        </form:select>
        <form:errors path="nem"></form:errors>
    </fieldset>

    <c:if test="${method ne 'View'}">
        <input type="submit" value="Hozzáadás">

    </c:if>



</form:form>

</body>
</html>
