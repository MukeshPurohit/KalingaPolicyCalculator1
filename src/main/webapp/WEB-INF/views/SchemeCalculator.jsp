<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
div{
background-color: yellow;
width:300px;
height:300px;
border: 2px solid black;
}
</style>
<body>
<div>
<form action="calculate" method="post">
	<label>Scheme:</label><br>
	<input type="number" name="id"><br>
	<label>Maturity:</label><br>
	<input type="number" name="maturity"><br>
	<label>Amount Invested:</label><br>
	<input type="number" name="amountInvested"><br>
	
	<span>Click:</span>
	<input type="submit" value="Calculate">
	</form>
	<h2>The maturity amount is</h2> ${message}
	</div>
</body>
</html>