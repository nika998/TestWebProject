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

.divBody {
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
	background-color: rgba(0, 0, 0, 0.6); box-shadow : 0 0 10px #000;
	overflow: auto;
	box-shadow: 0 0 10px #000;
}

.divTitle {
	height: 15%;
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
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	box-sizing: border-box;
	height: 6vh;
	border-radius: 10px;
	font-size: 15px;
	font-family: 'Roboto', sans-serif;
	font-weight: bold;
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

input[type=submit] {
	background-color: deepskyblue;
	border-radius: 10px;
	color: white;
	text-align: center;
	padding: 10px;
	display: inline-flex;
	align-items: center;
	justify-content: space-around;
	text-align: center;
	text-align: center;
	font-size: 13px;
	width: 200px;
	font-family: 'Roboto', sans-serif;
	font-weight: bold;
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

select {
	width: 100%;
	margin: 8px 0;
	display: inline-block;
	box-sizing: border-box;
	height: 6vh;
	padding: 6px 20px;
	border-radius: 10px;
	font-family: 'Roboto', sans-serif;
	font-weight: bold;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Azuriraj proizvodjaca</title>
</head>
<body>

	<header>
		<jsp:include page="/WEB-INF/fragment/login-user.jsp" flush="true" />
		<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true" />
	</header>
	<div class="divBody">
		<main>

			<div class="divTitle">
				<h2>Azuriraj proizvodjaca</h2>
			</div>

			<div class="divForm">

				<form
					action="/webproject/application/manufacturer/edit_manufacturer_pib"
					method="post">

					<label>Maticni broj</label> <input type="text" name="maticniBroj"
						value="${manufacturer.maticniBroj}" readonly /> <label>
						Pib</label> <input placeholder="Uneti poreski ident. broj" type="text" name="pib"
						value="${manufacturer.pib}" required /> <label>Adresa</label> <input
						placeholder="Uneti adresu" type="text" name="adresa" value="${manufacturer.adresa}" required/> <label>Mesto</label>

					<select name="postanskiBroj" id="mesto" required>
                             <option value="" disabled selected>Izaberite mesto</option>
						<c:forEach var="city" items="${cities}">

							<c:choose>
								<c:when test="${manufacturer.mesto.pttBroj == city.pttBroj}">
									<option selected value="${city.pttBroj}">${city.naziv}</option>

								</c:when>
								<c:otherwise>
									<option value="${city.pttBroj}">${city.naziv}</option>
								</c:otherwise>
							</c:choose>

						</c:forEach>

					</select>

					<div class="buttons">


						<input type="submit" value="Save changes" name="operation"> <input
							type="submit" value="Cancel" name="operation" formnovalidate>
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