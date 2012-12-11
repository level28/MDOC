<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Contact</title>
</head>
<body>
	<form method="post" action="DeleteContact">
		<table>
			<tr>
				<td><i>Firstname: <input type="text" name="firstName" size="25"></i></td>
			</tr>
			<tr>
				<td><i>Lastname: <input type="text" name="lastName" size="25"></i></td>
			</tr>
			<tr>
				<td><input class="button" type="submit" value="Submit" /><input
					class="button" type="reset" value="Reset"/>
					
			</tr>
		</table>
	</form>
</body>
</html>