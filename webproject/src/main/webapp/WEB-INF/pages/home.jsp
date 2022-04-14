<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.container{
width: 100%;
height: 70%;
}

.center {
text-align: center;

}

p{
vertical-align: middle;
}

h2 {
text-align: center;
vertical-align: middle;
}
</style>
<html>
<title>Home page</title>
<body>
	<header>
		<jsp:include page="/WEB-INF/fragment/login-user.jsp" flush="true"/>
		<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true"/>
	</header>
	
	<main>
	<div class="container">
	<h2>Dobro dosli, uspesno ste se prijavili na aplikaciju</h2>
		<div clas="center">
			<p>
				Ovo je pocetna stranica koja se prikazuje korisniku nakon prijave na sistem!
			</p>
		</div>
	</div>
		
	</main>
	<footer>
	<jsp:include page="/WEB-INF/fragment/footer.jsp" flush="true"/>
	</footer>
	
	
</body>
</html>
