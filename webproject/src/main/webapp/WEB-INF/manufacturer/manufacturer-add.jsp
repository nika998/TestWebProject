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
	diplay: flex;
	flex-direction: column;
	justify-content: space-between;
	align-items: center;
	position: absolute;
	height: 70vh;
	width: 80vh;
	min-height: 250px;
	min-width: 300px;
	left: 50%;
	top: 54%;
	transform: translate(-50%, -50%);
	border-radius: 10px;
	background-color: rgba(0, 0, 0, 0.6);
	box-shadow: 0 0 10px #000;
	overflow: auto;
}

.divTitle {
	height: 10%;
	text-align: center;
}

.divForm {
	height: 70%;
	padding: 0 10%;
	font-size: 13px;
	font-weight: bold;
}

input[type=text], input[type=password] {
	width: 100%;
	height: 6vh;
	border-radius: 10px;
	font-size: 15px;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	box-sizing: border-box;
	font-family: 'Roboto', sans-serif;
	font-weight: bold;
}

input[type=submit] {
	display: inline-flex;
	align-items: center;
	justify-content: space-around;
	background: deepskyblue;
	border-radius: 10px;
	color: white;
	text-align: center;
	padding: 10px;
	text-align: center;
	font-size: 15px;
	width: 200px;
	font-family: 'Roboto', sans-serif;
	font-weight: bold;
}

select {
	width: 100%;
	height: 6vh;
	padding: 6px 20px;
	margin: 8px 0;
	display: inline-block;
	box-sizing: border-box;
	border-radius: 10px;
	font-family: 'Roboto', sans-serif;
	font-weight: bold;
	font-size: 15px;
}

#error {
	display: inline-flex;
	align-items: center;
	justify-content: space-around;
	height: 6vh;
	width: 100%;
	color: #DAA520;
	font-size: 15px;
}

[type=submit]:hover {
	transform: scale(1.05);
}

.buttons {
	padding: 5px;
	height: 6vh;
	display: flex;
	flex-direction: row;
	justify-content: space-around;
	gap: 5px;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Dodaj proizvodjaca</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/fragment/login-user.jsp" flush="true" />
		<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true" />
	</header>
	<div class="div-body">
		<main>
			<div class="divTitle">
				<h2>Dodaj proizvodjaca</h2>
			</div>

			<div class="divForm">
				<form action="/webproject/application/manufacturer/add_manufacturer"
					method="post">
					<label>Maticni broj</label> <input placeholder="Uneti maticni broj"
						type="text" name="maticniBroj" value="${manufacturer.maticniBroj}"
						required /> <label>Pib</label> <input
						placeholder="Uneti poreski ident. broj" type="text" name="pib"
						value="${manufacturer.pib}" required /> <label>Adresa</label> <input
						placeholder="Uneti adresu" type="text" name="adresa"
						value="${manufacturer.adresa}" required /> <label>Mesto</label> <select
						name="postanskiBroj" id="mesto" required>
						<option value="" disabled selected>Izaberite mesto</option>
						<c:forEach var="city" items="${cities}">
							<option value="${city.pttBroj}">${city.naziv}</option>
						</c:forEach>

					</select>

					<div class="buttons">


						<input type="submit" value="Dodaj" name="operation"> <input
							type="submit" value="Vrati" name="operation" formnovalidate>
					</div>
					<div id="error">${error}</div>

				</form>
			</div>


		</main>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/fragment/footer.jsp" flush="true" /></footer>

</body>
</html>