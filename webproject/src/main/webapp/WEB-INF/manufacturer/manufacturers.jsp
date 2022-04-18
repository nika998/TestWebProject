<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style>
body {
	font-family: 'Roboto', sans-serif;
	color: white;
	margin: 0;
	background-image:
		url("https://img.freepik.com/free-photo/warehouse-industrial-building-interior-with-people-forklifts-handling-goods-storage-area_342744-1498.jpg?t=st=1650146681~exp=1650147281~hmac=17c45af0e204a320b95f2dc9cdc939346ba2c7f7ebc10be84fac5baef9568beb&w=740");
	background-size: cover;
}

.div-body {
	display: flex;
	flex-direction: column;
	justify-content: flex-start;
	align-items: center;
	height: 75vh;
	width: 80vw;
	position: absolute;
	left: 50%;
	top: 55%;
	transform: translate(-50%, -50%);
	background-color: rgba(0, 0, 0, 0.6);
	box-shadow: 0 0 10px #000;
	border-radius: 10px;
}

.tableDiv {
	overflow-x: auto;
	height: 60vh;
	width: 75vw;
	margin: 0 10px 10px 10px;
	border-radius: 10px;
}

table {
	width: 100%;
	padding: 10px 20%;
	border-collapse: collapse;
	border-radius: 10px;
	color: black;
	text-align: center;
}

thead tr {
	position: sticky;
	top: 0;
	z-index: 1;
	height: 2.5rem;
	background: #36304a;
	font-family: 'Roboto', sans-serif;
	line-height: 1.2;
	color: #fff;
}

tbody tr {
	height: 2.5rem;
	font-family: 'Roboto', sans-serif;
	color: #808080;
}

tbody tr:nth-child(odd) {
	background-color: #fff;
}

tbody tr:nth-child(even) {
	background-color: #f5f5f5;
}

td {
	vertical-align: center;
}

td a {
	display: block;
	text-align: center;
	margin: 5px 15px;
	color: black;
	text-decoration: none;
	vertical-align: bottom;
	color: #808080;
}

td a:hover {
	border-radius: 10px;
	background-color: #36304a;
	color: #fff;
}

h2 {
	text-align: center;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Svi proizvodjaci</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/fragment/login-user.jsp" flush="true" />
		<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true" />
	</header>
	<div class="div-body">
		<main>
			<div class="divTitle">
				<h2>Svi proizvodjaci registrovani u sistemu</h2>
			</div>
			<div class="tableDiv">
				<table>
					<thead>
						<tr>
							<th>Maticni broj</th>
							<th>Pib</th>
							<th>Adresa</th>
							<th>Mesto</th>
							<th>Azuriranje</th>
							<th>Brisanje</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="manufacturer" items="${manufacturers}">
							<tr>
								<td>${manufacturer.maticniBroj}</td>
								<td>${manufacturer.pib}</td>
								<td>${manufacturer.adresa}</td>
								<td>${manufacturer.mesto}</td>
								<td><a class="tableLink"
									href="/webproject/application/manufacturer/view?maticniBroj=${manufacturer.maticniBroj}">Azuriraj</a>
								</td>
								<td><a class="tableLink"
									href="/webproject/application/manufacturer/delete_manufacturer_table?maticniBroj=${manufacturer.maticniBroj}">Obrisi</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</main>
	</div>

	<footer>
		<jsp:include page="/WEB-INF/fragment/footer.jsp" flush="true" />
	</footer>


</body>
</html>
