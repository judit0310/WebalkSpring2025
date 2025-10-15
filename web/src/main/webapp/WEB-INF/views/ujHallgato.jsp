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
    </fieldset>
    <br>
    <fieldset>
        <legend>Alap adatok</legend>
        <form:label path="teljesNev">Teljes név:</form:label>
        <form:input path="teljesNev" />
        <br>
        <form:label path="email">Email cím:</form:label>
        <form:input path="email" />
        <br>
        <form:label path="szuletesiDatum" >Születési dátum:</form:label>
        <form:input path="szuletesiDatum" type="date"/>
        <br>
        <form:label path="nem">Nem:</form:label>
        <form:select path="nem" >
            <form:options/>
        </form:select>
    </fieldset>
        <input type="submit" value="Hozzáadás">



</form:form>

</body>
</html>
