<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/application/manufacturer/add"  var="manufacturerAdd"/>
<c:url value="/application/manufacturers"  var="manufacturer"/>

<c:url value="/application/manufacturer/edit"  var="manufacturerAdd"/>
<c:url value="/application/manufacturer/delete"  var="manufacturerDel"/>
<style>
.topnav {
  height: 8hv;
  display: flex;
  height: 8vh;
  flex-direction: row;
  justify-content: space-evenly;
  align-content: center;
  align-items: center;
  gap: 10px;
  background-color: #333;
  overflow: hidden;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
  box-shadow: 0 0 10px #333;
  opacity: 0.9;
}

.topnav a {
  height: 70%;
  display: flex;
  align-items: center;
  padding: 5px 5px;
  float: left;
  color: #f2f2f2;
  text-decoration: none;
  font-size: 25wv;
  font-weight: bold;
}

.topnav a:hover {
  border-radius: 10px;
  background-color: #ddd;
  color: black;
}

</style>
<div class="topnav">
	
<<<<<<< Updated upstream
		<a class="active" href="${manufacturerAdd}">Dodaj proizvodjaca</a>
		<a href="${manufacturer}">Pogledaj sve</a>
		<a href="${manufacturerAdd}">Azuriraj proizvodjaca</a>
		<a href="${manufacturerDel}">Obrisi proizvodjaca</a>
=======
		<a href="${manufacturerAdd }">Dodaj proizvodjaca</a>
		<a href="${manufacturer }">Pogledaj sve</a>
		<a href="${manufacturerEdit }">Azuriraj proizvodjaca</a>
		<a href="${manufacturerDelete }">Obrisi proizvodjaca</a>
>>>>>>> Stashed changes

</div>