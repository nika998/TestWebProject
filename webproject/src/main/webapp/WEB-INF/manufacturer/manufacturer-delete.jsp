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
	display: flex;
	flex-direction: column;
	justify-content: space-around;
	background-color: #f1f1f1;
	position: absolute;
	height: 40%;
	width: 30%;
	min-height: 250px;
	min-width: 300px;
	left: 50%;
	top: 55%;
	transform: translate(-50%, -50%);
	background-color: rgba(0, 0, 0, 0.6);
	box-shadow: 0 0 10px #000;
	border-radius: 10px;
}

.divTitle {
padding: 0 0 10px;
	height: 10%;
	text-align: center;
	font-size: 17px;
}

.divForm {
	padding: 0 10%;
	font-size: 15px;
	font-weight: bold;
}

.buttons {
padding: 10px;
	display: flex;
	flex-direction: row;
	justify-content: space-around;
	gap: 5px;
}

input[type=submit] {
	display: inline-block;
	background-color: deepskyblue;
	border-radius: 10px;
	color: white;
	text-align: center;
	font-size: 15px;
	padding: 10px;
	width: 200px;
	font-family: 'Roboto', sans-serif;
	font-weight: bold;
}

[type=submit]:hover {
	transform: scale(1.05);
}

select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border-radius: 10px;
	box-sizing: border-box;
	font-family: 'Roboto', sans-serif;
	font-weight: bold;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Obrisi proizvodjaca</title>
</head>
<body>
	<div class="divHeader">
		<header>
			<jsp:include page="/WEB-INF/fragment/login-user.jsp" flush="true" />
			<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true" />
		</header>
	</div>
	<div class="divBody">
		<main>
			<div class="divTitle">
				<h2>Obrisi proizvodjaca</h2>
			</div>
			<div class="divForm">
				<form
					action="/webproject/application/manufacturer/delete_manufacturer"
					method="post">

					<label>Maticni broj</label> <select name="maticniBroj" id="maticniBroj" required>
                         <option value="" disabled selected>Izaberite opciju</option>
						<c:forEach var="manufacturer" items="${manufacturers}">

							<option value="${manufacturer.maticniBroj}">${manufacturer.maticniBroj}</option>

						</c:forEach>

					</select>

					<div class="buttons">


						<input type="submit" value="Delete" name="operation"> <input
							type="submit" value="Cancel" name="operation" formnovalidate>
					</div>
					<div>${error}</div>

				</form>
			</div>



		</main>
	</div>
	<div>
		<footer>
			<jsp:include page="/WEB-INF/fragment/footer.jsp" flush="true" /></footer>
	</div>
</body>
</html>