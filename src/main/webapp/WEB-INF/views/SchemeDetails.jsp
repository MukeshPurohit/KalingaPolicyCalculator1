<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
	<table>
		<tr>
			<th>Id</th>
			<th>SchemeName</th>
			<th>Bank</th>
			<th>ProductType</th>
			<th>ROI</th>
			
		</tr>
		<c:forEach items="${message}" var="scheme">
		 <tr>
		 	<td>${scheme.id}</td>
		 	<td>${scheme.name}</td>
		 	<td>${scheme.bank.name}</td>
		 	<td>${scheme.productType.name}</td>
		 	<td>${scheme.roi}</td>
		</tr>
		</c:forEach>
	
	</table>
	</div>
</body>
</html>