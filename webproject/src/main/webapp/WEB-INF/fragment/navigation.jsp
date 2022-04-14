<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/application/city/add"  var="cityAdd"/>
<c:url value="/application/city"  var="cities"/>

<c:url value="/application/company/add"  var="companyAdd"/>
<c:url value="/application/company"  var="companies"/>

<div class="topnav">
	<nav>
		<a class="active" href="${cityAdd}">Dodaj proizvodjaca</a>
		<a href="${cities}">Pogledaj sve</a>
		<a href="${companyAdd}">Azuriraj proizcodjaca</a>
		<a href="${companies}">Obrisi proizvodjaca</a>
	</nav>
</div>