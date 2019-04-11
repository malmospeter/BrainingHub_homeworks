<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		
	%>


	<h1 align="center">Translation</h1>
	<br />
	<h3 align="center">
		<%
			out.println("Hungarian: " + request.getAttribute("hun"));
		%>
		<br/>
		<%
			out.println("English: " + request.getAttribute("eng"));
		%>
	</h3>
	<br />

	<form action="dictionary.jsp" >
		<h3 align="center">
			<input type="submit" value="Back">
		</h3>
	</form>
</body>
</html>