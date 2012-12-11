<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Contact</title>
</head>
<body>
<form method="post" action="UpdateContact">
		<table>
			<tr>
				<tr>
					<td><i>last name: <input type="text" name="lastname" size="25"></i></td>
				</tr>
				<tr>
					<td><i>first name: <input type="text" name="firstname" size="25"></i></td>
				</tr>
				<tr>
					<td><i>id: <input type="text" name="id" size="25"></i></td>
				</tr>
				
				
				
			
		</table>
		
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
         <!--<input type="text" name="group" value="" /> -->
         </p>

        <p>
        <input type="submit" name="submit" value="Envoyer" />
        <input type="reset" name="reset" value="Reset" />
        </p>
		
	</form>
	
</body>
</html>