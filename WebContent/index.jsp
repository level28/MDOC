<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" title="Design" href="design.css" />
		<title>Connexion</title>
		
		<style>
		input {
	background-color: white;
}
		</style>
	</head>
	
	<body>
	<form method="post" action="loginServlet">
		<table>
			<tr>
				<th><h2>Carnet d'adresse MDOC</h2></th>
				<tr>
					<td><i>Name: <input type="text" name="name" size="25"></i></td>
				</tr>
				<tr>
					<td><i>Password: <input type="password" name="password" size="25"></i></td>
				</tr>
				<tr>
					<td><input class="button" type="submit" value="Submit" /><input class="button" type="reset" value="Reset"></td>
				</tr>
			
		</table>
	</form>
		<!-- 		<form method="post" action="LoginJsp.jsp">
			<table>
				<tr>
					<th><h2>Et un second avec un jsp</h2></th>
				</tr> 
				<tr>
					<td>Name: <input type="text" name="name" size="25"></td>
				</tr>
				<tr>
					<td>Password: <input type="password" name="password" size="25"></td>
				</tr>
				<tr>
					<td><input class="button" type="submit" value="Submit" /><input class="button" type="reset" value="Reset"></td>
				</tr>	
			</table>
		</form>-->
	</body>
</html>