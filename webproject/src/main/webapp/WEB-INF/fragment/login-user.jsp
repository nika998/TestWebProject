<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.headerContainer{
  height: 6vh;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  background-color: #DAA520;
  overflow: hidden;
  border-bottom: 4px solid white;
}

.headerContainer div {
  padding: 10px;
  float: left;
  font-size: 7wv;
  font-weight: bold;
}

#headerLink{
  height: 30%;
  margin: 5px 5px;
  border-radius: 10px;
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 4px 16px;
  text-decoration: none;

}

#headerLink:hover {
  background-color: #CD5C5C;
  color: black;
}
</style>
<div class="headerContainer">
	<div id="item1"><p>Prijavljeni ste kao: ${sessionScope.loginUser.username}<p></div>
	<div id="item2">
		<a id="headerLink" href="/webproject/application/logout">Odjavite se</a>
	</div>


</div>