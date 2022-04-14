<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/application/manufacturer/add"  var="manufacturerAdd"/>
<c:url value="/application/manufacturers"  var="manufacturer"/>

<c:url value="/application/manufacturer/edit"  var="manufacturerAdd"/>
<c:url value="/application/manufacturer/delete"  var="manufacturerDel"/>
<style>
/* Add a black background color to the top navigation */
.topnav {
  background-color: #333;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
</style>
<div class="topnav">
	
		<a class="active" href="${manufacturerAdd}">Dodaj proizvodjaca</a>
		<a href="${manufacturer}">Pogledaj sve</a>
		<a href="${manufacturerAdd}">Azuriraj proizvodjaca</a>
		<a href="${manufacturerDel}">Obrisi proizvodjaca</a>

</div>