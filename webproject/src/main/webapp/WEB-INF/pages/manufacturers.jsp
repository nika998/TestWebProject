<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<header>
		<jsp:include page="/WEB-INF/fragment/login-user.jsp" flush="true" />
		<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true" />
	</header>

	<main>
		<h2>Svi proizvodjaci registrovani u sistemu</h2>
		<article>
			<div>
				<table>
					<thead>
						<tr>
							<th>Pib</th>
							<th>Maticni broj</th>
							<th>Adresa</th>
							<th>Mesto</th>
							<th>Detalji</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="manufacturer" items="${manufacturers}">
							<tr>
								<th>${manufacturer.pib}</th>
								<th>${manufacturer.maticniBroj}</th>
								<th>${manufacturer.adresa}</th>
								<th>${manufacturer.mesto}</th>
								<th>
									<br/>
									<a href="/webproject/application/city/view?zipCode=${manufacturer.pib}">Pogledaj</a>
									<br/>
								</th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</article>
	</main>

	<footer>
	<jsp:include page="/WEB-INF/fragment/footer.jsp" flush="true"/>
	</footer>


</body>
</html>
