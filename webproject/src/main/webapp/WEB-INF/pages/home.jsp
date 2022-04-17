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
	justify-content: flex-end;
	align-items: center;
    height: 30vh;
    width: 40vw;
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
	text-align: center;
}

.divText{
font-size:20px;
}

.divTitle{
}

</style>
<head>
<meta charset="ISO-8859-1">
<title>Pocetna stranica</title>
</head>
<body>
	
		<header>
		<jsp:include page="/WEB-INF/fragment/login-user.jsp" flush="true" />
		<jsp:include page="/WEB-INF/fragment/navigation.jsp" flush="true" />
		</header>
	
	<div class="divBody">
		<main>
				<div class="divTitle"><h2>Dobro dosli, uspesno ste se prijavili na aplikaciju</h2></div>
				
				<div class="divText">Odaberite jednu od ponudjenih opcija u meniju</div>

			
		</main>
			
	</div>
	
		<footer>
			<jsp:include page="/WEB-INF/fragment/footer.jsp" flush="true" />
		</footer>
	

</body>
</html>
