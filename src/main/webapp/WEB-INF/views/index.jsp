<html>
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
<h2>Hello World! The controller said ${message}</h2>
<form action="addScheme1" >
		<input type="submit" value="Add Scheme" /> 
	</form>
	
	<form action="getData" >
		<input type="submit" value="Get Scheme Details" /> 
	</form>
	
	<form action="calculate1" >
		<input type="submit" value="Calculate amount" /> 
	</form>
	</div>
</body>
</html>
