<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dictionary Webb Application</title>
</head>
<body>

	<form method="GET" action="dictionary">

		<h1 align="center">Hungarian - English dictionary</h1>
		<br />
		<h3 align="center">
			<label for="input">Hungarian word: </label><input type="text"
				name="hungarian" id="hungarian">
		</h3>
		<br />

		<h3 align="center">
			<input type="submit" value="Translate">
		</h3>

	</form>

</body>
</html>