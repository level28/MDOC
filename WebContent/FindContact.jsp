<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Find Contact</title>
</head>
<body>
	<form method="post" action="FindContact">
		<table>
			<tr>
				<tr>
					<td><i>last name: <input type="text" name="lastname" size="25"></i></td>
				</tr>
				<tr>
					<td><i>or first name: <input type="text" name="firstname" size="25"></i></td>
				</tr>
				<tr>
					<td><i>or eMail: <input type="text" name="email" size="25"></i></td>
				</tr>
				
				<tr>
					<td><input class="button" type="submit" value="Submit" /><input class="button" type="reset" value="Reset"></td>
				</tr>
			
		</table>
	</form>
</body>
</html>