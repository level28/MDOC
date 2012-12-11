<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Contact</title>
</head>
<body>
<form method="post" action="NewContact">
		<p>
        <label>LastName:</label>
        <input type="text" name="lastName" />
        </p>

        <p>
        <label>FirstName:</label>
        <input type="text" name="firstName"/>
        </p>

        <p>
        <label>Email:</label>
        <input type="text" name="email"/>
        </p>


        <p>
        <label>Street:</label>
        <input type="text" name="Street"/>
        </p>

        <p>
        <label>City:</label>
        <input type="text" name="City"/>
        </p>

        <p>
        <label>Zip:</label>
        <input type="text" name="zip"/>
        </p>

        <p>
        <label>Country:</label>
        <input type="text" name="Country"/>
        </p>


		<p>
        <label>Phone1:</label>
        <input type="text" name="mobile"/>
        <input type="text" name="mobilekind"/>
        </p>

        <p>
        <label>Phone2:</label>
        <input type="text" name="home"/>
        <input type="text" name="homekind"/>
        </p>

        <p>
        <label>Phone3:</label>
        <input type="text" name="office"/>
        <input type="text" name="officekind" />
        </p>

		 <p>
        <input type="checkbox" name="group" value="Friends"/>
        <label>Friends</label>
        <input type="checkbox" name="group" value="Family"/>
        <label>Family</label>
        <input type="checkbox" name="group" value="Colleague" />
        <label>Colleague</label>
        <br/>Autre : 
        <input type="text" name="newgroup" value="" /> 
        </p>

        <p>
        <input type="submit" name="submit" value="Envoyer" />
        <input type="reset" name="reset" value="Reset" />
        </p>

		
		
		
		
		<!-- <table>
			<tr>
				<tr>
					<td><i>last name: <input type="text" name="lastname" size="25"></i></td>
				</tr>
				<tr>
					<td><i>first name: <input type="text" name="firstname" size="25"></i></td>
				</tr>
				<tr>
					<td><i>eMail: <input type="text" name="email" size="25"></i></td>
				</tr>
				  
				<tr><td>Address </td></tr>
				<tr>
					<td><i>Street: <input type="text" name="Street" size="50"></i></td>
				</tr>
				<tr>
					<td><i>City: <input type="text" name="City" size="50"></i></td>
				</tr>
				<tr>
					<td><i>zip: <input type="text" name="zip" size="50"></i></td>
				</tr>
				<tr>
					<td><i>Country: <input type="text" name="Country" size="50"></i></td>
				</tr>
		
				
			<tr><td>Phone Number </td></tr>
				<tr>
					<td><i>Mobile: <input type="text" name="Mobile" size="50"></i></td>
				</tr>
				<tr>
					<td><i>Home: <input type="text" name="Home" size="50"></i></td>
				</tr>
				<tr>
					<td><i>Work: <input type="text" name="Work" size="50"></i></td>
				</tr>
				
				<tr>
					<td><input class="button" type="submit" value="Submit" /><input class="button" type="reset" value="Reset"></td>
				</tr>
			
		</table>-->
	</form>
</body>
</html>