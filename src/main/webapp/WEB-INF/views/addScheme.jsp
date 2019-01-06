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
	<form action="addScheme" method="post">
	<label>SchemeId:</label><br>
	<input type="number" name="schemeId"><br>
	<label>SchemeName:</label><br>
	<input type="text" name="schemeName"><br>
	<label>BankName:</label><br>
	<select name="bankName">
	<option value="sbi">SBI</option>
	<option value="axis">AXIS</option>
	</select><br>
	<!-- <input type="text" name="bankName"><br> -->
	<label>SchemeType:</label><br>
	<select name="schemeType">
	<option value="fd">Fixed Deposit</option>
	<option value="rd">Recurring Deposit</option>
	</select><br>
	<!-- <input type="text" name="schemeType"><br> -->
	<label>ROI:</label><br>
	<input type="number" name="roi"><br>
	<span>Click:</span>
	<input type="submit" value="Add Scheme">
	</form>
	</div>
</body>
</html>