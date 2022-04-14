<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.login{
  display: flex;
  background-color: #666;
  overflow: hidden;
}

.topnav div {
  flex: 1;
  float: left;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.login:first-child {
    margin-right: 20px;
    
} 

a{
 float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;

}

 a:hover {
  background-color: #ddd;
  color: black;
}

p{
font-size: 17px;
    color: #f2f2f2;
vertical-align: middle; 
  text-align: center; 
}

</style>
<div class="login">
	<div><p>Prijavljeni ste kao: ${sessionScope.loginUser.username}<p></div>
	<div>
		<a href="/webproject/application/logout">Odjavite se</a>
	</div>


</div>