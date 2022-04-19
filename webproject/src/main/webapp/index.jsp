<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<style>
body {
	diplay: flex;
	flex-direction: column;
	justify-content: flex-start;
	align-items: center;
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
	height: 60vh;
	width: 30vw;
	min-height: 250px;
	min-width: 300px;
	background-color: rgba(0, 0, 0, 0.6);
	box-shadow: 0 0 10px #000;
	border-radius: 10px;
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
	overflow: auto;
}

.divTitle {
	height: 10%;
	text-align: center;
	font-size: 17px;
}

.divForm {
	diplay: flex;
	flex-direction: column;
	justify-content: space-between;
	align-items: center;
	height: 70%;
	padding: 15px;
	font-size: 15px;
}

input[type=text], input[type=password] {
	width: 100%;
	height: 7vh;
	border-radius: 10px;
	font-size: 15px;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	font-family: 'Roboto', sans-serif;
	font-weight: bold;
}

button {
	display: inline-flex;
	align-items: center;
	justify-content: space-around;
	height: 7vh;
	width: 100%;
	background-color: deepskyblue;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	cursor: pointer;
	border-radius: 10px;
	font-size: 15px;
	font-family: 'Roboto', sans-serif;
	font-weight: bold;
}

button:hover {
	transform: scale(1.05);
}

#error {
	display: inline-flex;
	align-items: center;
	justify-content: space-around;
	height: 6vh;
	width: 100%;
	color: #DAA520;
	font-size: 15px;
	font-weight: bold;
	text-align: center;
}

.register {
	width: 100%;
	display: flex;
	justify-content: center;
}

.register a {
	color: deepskyblue;
	font-family: 'Roboto', sans-serif;
}

.buttons {
	display: flex;
	justify-content: space-around;
}
</style>

<title>Prijava</title>
<body>
	<div class="divBody">

		<div class="divTitle">
			<h2>Prijava</h2>
		</div>
		<div class="divForm">
			<form action="/webproject/application/login" method="post">


				<label for="username"><b>Korisnicko ime</b></label> <input
					type="text" placeholder="Uneti korisnicko ime" name="username"
					value="${u.username}" required> <label for="password"><b>Lozinka</b></label>
				<input type="password" placeholder="Uneti lozinku" name="password"
					required>

				<div class="buttons">
					<button type="submit">Prijavi se</button>
				</div>
				<div id="error">${error_message}</div>

				<div class="register">
					<a href="/webproject/application/register">Nemate nalog?
						Registrujte se</a>
				</div>
			</form>

		</div>

	</div>

</body>
</html>
