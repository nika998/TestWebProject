<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<header>
		<jsp:include page="/WEB-INF/fragment/login-user.jsp" flush="true"/>
		<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true"/>
	</header>
	
	<main>
		<h2>Dobro dosli, uspesno ste se prijavili na aplikaciju</h2>
		<article>
			<div>
				Ovo je pocetna stranica koja se prikazuje korisniku nakon prijave na sistem!
			</div>
		</article>
	</main>
	
	<footer> Copyright 2022.</footer>
</body>
</html>
